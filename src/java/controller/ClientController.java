package controller;

import dao.entity.AdvisorEntity;
import dao.entity.ClientEntity;
import dao.entity.MessageEntity;
import dao.entity.UserEntity;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.entities.ClientService;
import service.entities.ClientServiceImpl;

/**
 *
 * @author lucqu
 */
@Controller
public class ClientController extends AbstractController {
    
    @Autowired
    private final ClientService client_service;
    
    public ClientController() {
        this.client_service = new ClientServiceImpl();
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
        ModelAndView mv = new ModelAndView("client/chat");
        
        HttpSession session = request.getSession(false);
        if(null == session){
            return new ModelAndView("index");
        }
        
        String current_client_id = (String)(session.getAttribute("user_id"));
        if(null == current_client_id || current_client_id.equals("")){
            return new ModelAndView("index");
        }
        
        ClientEntity current_client = this.client_service.find(current_client_id);
        if(null == current_client){
            return new ModelAndView("index");
        }
        
        /**
         * =====================================================================
         * Mock to create the chet view
         */
        ArrayList<MessageEntity> messages = new ArrayList<>();
        MessageEntity client_send = new MessageEntity("Bonjour Mr le conseiller");
        client_send.setSender(current_client.getAdvisor());
        client_send.setRecipient(current_client);
        //---------
        MessageEntity advisor_send = new MessageEntity("Bonjour Mr le client");
        advisor_send.setSender(current_client);
        advisor_send.setRecipient(current_client.getAdvisor());
        //---------
        MessageEntity advisor_send2 = new MessageEntity("Comment allez vous ?");
        advisor_send2.setSender(current_client);
        advisor_send2.setRecipient(current_client.getAdvisor());
        //---------
        MessageEntity client_send2 = new MessageEntity("Très bien et vous ?");
        client_send2.setSender(current_client.getAdvisor());
        client_send2.setRecipient(current_client);
        
        messages.add(client_send);
        messages.add(advisor_send);
        messages.add(advisor_send2);
        messages.add(client_send2);
        
        mv.addObject("messages", messages);
        /**
         * =====================================================================
         */
        
        return mv;
    }
    
}
