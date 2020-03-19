package controller;

import dao.entity.ClientEntity;
import dao.entity.UserEntity;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.ClientService;
import service.ClientServiceImpl;
import service.UserService;
import service.UserServiceImpl;

/**
 *
 * @author lucqu
 */
@Controller
public class AdvisorController extends AbstractController {
    
    @Autowired
    private final UserService user_service;
    
    @Autowired
    private final ClientService client_service;
    
    /**
     * Constructor
     */
    public AdvisorController() {
        this.user_service = new UserServiceImpl();
        this.client_service = new ClientServiceImpl();
    }
    
    /**
     * Path : /list_clients
     * method GET
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @Override
    @RequestMapping(value="/list_clients", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        Vector<ClientEntity> clients_vector = new Vector<>();
        
        clients_vector = (Vector)this.client_service.findAll();
        
        ModelAndView mv = new ModelAndView("managementClients");
        mv.addObject("clients", clients_vector.toArray());
        mv.addObject("nb_clients", clients_vector.size());
        return mv;
    }
    
    /**
     * Path : /delete_client
     * Method : GET
     * 
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping(value="/delete_client", method = RequestMethod.GET)
    public ModelAndView delete_client(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        String user_id = request.getParameter("id");
        if(null == user_id || user_id.equals("")){
            // TODO Ajout d'un message info
            return this.handleRequestInternal(request, response);
        }
        
        UserEntity user = this.user_service.find(user_id);
        if(null == user){
            // TODO Ajout d'un message info
            return this.handleRequestInternal(request, response);
        }
        
        this.user_service.delete(user);
        
        return this.handleRequestInternal(request, response);
    }
    
    /**
     * Path : /edit_client
     * Method : GET
     * 
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping(value="/edit_client", method = RequestMethod.GET)
    public ModelAndView edit_client_get(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        String client_id = request.getParameter("id");
        if(null == client_id || client_id.equals("")){
            // TODO Ajout d'un message info
            return this.handleRequestInternal(request, response);
        }
        
        UserEntity client = this.user_service.find(client_id);
        if(null == client){
            // TODO Ajout d'un message info
            return this.handleRequestInternal(request, response);
        }
        
        ModelAndView mv = new ModelAndView("client/form_edit_client");
        mv.addObject("client", client);
        return mv;
    }
    
    /**
     * Path : /edit_client
     * Method : POST
     * 
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping(value="/edit_client", method = RequestMethod.POST)
    public ModelAndView edit_client_post(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        String client_id = request.getParameter("id");
        if(null == client_id || client_id.equals("")){
            // TODO Ajout d'un message info
            return this.edit_client_get(request, response);
        }
        
        UserEntity client = this.user_service.find(client_id);
        if(null == client){
            // TODO Ajout d'un message info
            return this.edit_client_get(request, response);
        }
        
        
        
        ModelAndView mv = new ModelAndView("client/form_edit_client");
        mv.addObject("client", client);
        return mv;
    }
}