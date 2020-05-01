package controller;

import dao.entity.ClientEntity;
import dao.entity.MessageEntity;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.SecurityService;
import service.SessionService;
import service.entities.ClientService;
import service.entities.ClientServiceImpl;
import service.entities.MessageService;
import service.entities.MessageServiceImpl;

/**
 *
 * @author lucqu
 */
@Controller
public class ClientController extends AbstractController {
    
    @Autowired
    private final ClientService client_service;
    
    @Autowired
    private final MessageService message_service;
    
    @Autowired
    private final SecurityService security_service;
    
    @Autowired
    private final SessionService session_service;
    
    public ClientController() {
        this.client_service = new ClientServiceImpl();
        this.message_service = new MessageServiceImpl();
        this.security_service = new SecurityService();
        this.session_service = new SessionService();
    }
    
    /**
     * Default method inherited from AbstractController
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("No need to implement it.");
    }
    
     /**
     * Path : /chat_client
     * Method : GET
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/chat_client", method = RequestMethod.GET)
    public ModelAndView chat_client_get(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        if(!this.security_service.hasAccess(request, "chat_client_get")){
            return ErrorController.error403();
        }
        
        ModelAndView mv = new ModelAndView("client/chat");
        
        String current_client_id = (String)this.session_service.getSessionAttribute(request, "user_id");
        if(null == current_client_id){
            return ErrorController.error404();
        }
        
        ClientEntity current_client = this.client_service.find(current_client_id);
        if(null == current_client){
            return ErrorController.error404();
        }
        
        ArrayList<MessageEntity> messages = new ArrayList<>(this.message_service.findChat(current_client, current_client.getAdvisor()));
        mv.addObject("client", current_client);
        mv.addObject("messages", messages);
        
        return mv;
    }
    
    /**
     * Path : /chat_client
     * Method : POST
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/chat_client", method = RequestMethod.POST)
    public ModelAndView chat_client_post(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        if(!this.security_service.hasAccess(request, "chat_client_post")){
            return ErrorController.error403();
        }
        
        String current_client_id = (String)this.session_service.getSessionAttribute(request, "user_id");
        if(null == current_client_id || current_client_id.equals("")){
            return ErrorController.error404();
        }
        
        ClientEntity current_client = this.client_service.find(current_client_id);
        if(null == current_client){
            return ErrorController.error404();
        }
        
        String message_content = request.getParameter("message_content");
        if(null == message_content || message_content.equals("")){
            return this.chat_client_get(request, response);
        }
        
        MessageEntity message = new MessageEntity(message_content);
        message.setSender(current_client);
        message.setRecipient(current_client.getAdvisor());
        this.message_service.save(message);
        
        return this.chat_client_get(request, response);
    }
    
}
