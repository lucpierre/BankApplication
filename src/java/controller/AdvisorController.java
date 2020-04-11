package controller;

import dao.entity.ClientEntity;
import dao.entity.UserEntity;
import java.text.ParseException;
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
        
        ModelAndView mv = new ModelAndView("advisor/managementClients");
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
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/delete_client", method = RequestMethod.GET)
    public ModelAndView delete_client(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        String user_id = request.getParameter("id");
        if(null == user_id || user_id.equals("")){
            // TODO Trouver comment ajouter un msg d'alert
            return this.handleRequestInternal(request, response);
        }
        
        UserEntity user = this.user_service.find(user_id);
        if(null == user){
            // TODO Trouver comment ajouter un msg d'alert
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
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/edit_client", method = RequestMethod.GET)
    public ModelAndView edit_client_get(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView("advisor/form_edit_client");
        
        String client_id = request.getParameter("id");
        if(null == client_id || client_id.equals("")){
            mv.addObject("alert_msg", "Impossible de récupérer le client demandé.");
            return this.handleRequestInternal(request, response);
        }
        
        UserEntity client = this.user_service.find(client_id);
        if(null == client){
            mv.addObject("alert_msg", "Impossible de récupérer le client demandé.");
            return this.handleRequestInternal(request, response);
        }
        
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
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/edit_client", method = RequestMethod.POST)
    public ModelAndView edit_client_post(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView("advisor/form_edit_client");
        
        String client_id = request.getParameter("id");
        if(null == client_id || client_id.equals("")){
            mv.addObject("alert_msg", "Aucun client correspondant.");
            return this.edit_client_get(request, response);
        }
        
        UserEntity client = this.user_service.find(client_id);
        if(null == client){
            mv.addObject("alert_msg", "Impossible de récupérer le client demandé.");
            System.err.println("Impossible to find the client");
            return this.edit_client_get(request, response);
        }
        
        String first_name = request.getParameter("first_name_input");
        String last_name = request.getParameter("last_name_input");
        String login = request.getParameter("login_input");
        String password = request.getParameter("password_input");
        String mail = request.getParameter("mail_input");
        String phone = request.getParameter("phone_input");
        String address = request.getParameter("address_input");
        String birthday = request.getParameter("birthday_input");
        
        
        try{
            client.setFirstName(first_name);
            client.setLastName(last_name);
            client.setLogin(login);
            client.setPassword(password);
            client.setMail(mail);
            client.setPhone(phone);
            client.setAddress(address);
            client.setBirthday(birthday);
        }
        catch(ParseException e){
            System.err.println(e.getMessage());
            mv.addObject("alert_msg", "Une erreur s'est produite durant la soumission du formulaire.");
        }
        
        this.client_service.update((ClientEntity)client);
        mv.addObject("info_msg", "Les informations ont été mises à jour.");
        mv.addObject("client", client);
        return mv;
    }
}