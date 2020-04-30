package controller;

import dao.entity.AdvisorEntity;
import dao.entity.ClientEntity;
import dao.entity.MessageEntity;
import dao.entity.ProfessionalEntity;
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
import service.PasswordService;
import service.entities.AdvisorService;
import service.entities.AdvisorServiceImpl;
import service.entities.ClientService;
import service.entities.ClientServiceImpl;
import service.entities.ProfessionalService;
import service.entities.ProfessionalServiceImpl;
import service.entities.UserService;
import service.entities.UserServiceImpl;

/**
 *
 * @author lucqu
 */
@Controller
public class AdvisorController extends AbstractController {
    
    @Autowired
    private final UserService user_service;
    
    @Autowired
    private final AdvisorService advisor_service;
    
    @Autowired
    private final ClientService client_service;
    
    @Autowired
    private final ProfessionalService professional_service;
    
    /**
     * Constructor
     */
    public AdvisorController() {
        this.user_service = new UserServiceImpl();
        this.advisor_service = new AdvisorServiceImpl();
        this.client_service = new ClientServiceImpl();
        this.professional_service = new ProfessionalServiceImpl();
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
        ModelAndView mv = new ModelAndView("advisor/managementClients");
        return this.list_clients(request, mv);
    }
    
    /**
     * PATH : NO_PATH
     * Take a ModelAndView and return it with the list of the clients
     * 
     * @param mv
     * @return
     * @throws Exception 
     */
    private ModelAndView list_clients(
            HttpServletRequest request,
            ModelAndView mv
    ) throws Exception {
        ArrayList<ClientEntity> clients = (ArrayList)this.client_service.findAll();
        mv.addObject("clients", clients.toArray());
        
        HttpSession session = request.getSession(false);
        if(null == session){
            return new ModelAndView("index");
        }
        
        String current_advisor_id = (String)(session.getAttribute("user_id"));
        if(null == current_advisor_id || current_advisor_id.equals("")){
            return new ModelAndView("index");
        }
        
        AdvisorEntity current_advisor = this.advisor_service.find(current_advisor_id);
        if(null == current_advisor){
            return new ModelAndView("index");
        }
        
        ArrayList<ClientEntity> supervised_clients = new ArrayList(current_advisor.getClients());
        mv.addObject("supervised_clients", supervised_clients.toArray());
        
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
        ModelAndView mv = new ModelAndView("advisor/managementClients");
        
        String user_id = request.getParameter("id");
        if(null == user_id || user_id.equals("")){
            mv.addObject("alert_msg", "Impossible de trouver le client demandé.");
            return this.list_clients(request, mv);
        }
        
        UserEntity user = this.user_service.find(user_id);
        if(null == user){
            mv.addObject("alert_msg", "Impossible de trouver le client demandé.");
            return this.list_clients(request, mv);
        }
        
        this.user_service.delete(user);
        mv.addObject("alert_msg", "Le client a été supprimé avec succès.");
        
        return this.list_clients(request, mv);
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
        ModelAndView mv = new ModelAndView("advisor/form_client");
        
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
        ModelAndView mv = new ModelAndView("advisor/form_client");
        
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
        
        String siret = request.getParameter("siret_input");
        String siren = request.getParameter("siren_input");
        String head_office_address = request.getParameter("head_office_address_input");
        String civility = request.getParameter("civility_input");
        String first_name = request.getParameter("first_name_input");
        String last_name = request.getParameter("last_name_input");
        String login = request.getParameter("login_input");
        String password = request.getParameter("password_input");
        String mail = request.getParameter("mail_input");
        String phone = request.getParameter("phone_input");
        String address = request.getParameter("address_input");
        String birthday = request.getParameter("birthday_input");
        
        
        try{
            if(client instanceof ProfessionalEntity){
                ((ProfessionalEntity)client).setSiren(siren);
                ((ProfessionalEntity)client).setSiret(siret);
                ((ProfessionalEntity)client).setHeadOfficeAddress(head_office_address);
            }
            
            client.setCivility(civility);
            client.setFirstName(first_name);
            client.setLastName(last_name);
            client.setLogin(login);
            client.setMail(mail);
            client.setPhone(phone);
            client.setAddress(address);
            client.setBirthday(birthday);
            
            if(!PasswordService.compareString(password, client.getPassword())){
                client.setPassword(password);
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            mv.addObject("alert_msg", "Une erreur s'est produite durant la soumission du formulaire.");
            mv.addObject("client", client);
            return mv;
        }
        
        if(client instanceof ProfessionalEntity){
            this.professional_service.update((ProfessionalEntity)client);
        }
        else{
            this.client_service.update((ClientEntity)client);
        }
        
        mv.addObject("info_msg", "Les informations ont été mises à jour.");
        mv.addObject("client", client);
        return mv;
    }
    
    /**
     * Path : /add_client
     * Method : GET
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/add_client", method = RequestMethod.GET)
    public ModelAndView add_client_get(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView("advisor/form_client");
        return mv;
    }
    
    /**
     * Path : /add_client
     * Method : POST
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/add_client", method = RequestMethod.POST)
    public ModelAndView add_client_post(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView("advisor/form_client");
        
        HttpSession session = request.getSession(false);
        if(null == session){
            return new ModelAndView("index");
        }
        
        String advisor_id = (String)session.getAttribute("user_id");
        if(null == advisor_id || advisor_id.equals("")){
            return new ModelAndView("index");
        }
        
        AdvisorEntity current_advisor = this.advisor_service.find(advisor_id);
        if(null == current_advisor){
            return new ModelAndView("index");
        }
        
        String user_type = request.getParameter("user_type_input");
        String siret = request.getParameter("siret_input");
        String siren = request.getParameter("siren_input");
        String head_office_address = request.getParameter("head_office_address_input");
        String civility = request.getParameter("civility_input");
        String first_name = request.getParameter("first_name_input");
        String last_name = request.getParameter("last_name_input");
        String login = request.getParameter("login_input");
        String password = request.getParameter("password_input");
        String mail = request.getParameter("mail_input");
        String phone = request.getParameter("phone_input");
        String address = request.getParameter("address_input");
        String birthday = request.getParameter("birthday_input");
        
        ClientEntity client = null;
        
        try{
            if(user_type.equals("Professionnel")){
                client = new ProfessionalEntity();
                ((ProfessionalEntity)client).setSiren(siren);
                ((ProfessionalEntity)client).setSiret(siret);
                ((ProfessionalEntity)client).setHeadOfficeAddress(head_office_address);
            }
            else{
                client = new ClientEntity();
            }
            
            client.setCivility(civility);
            client.setFirstName(first_name);
            client.setLastName(last_name);
            client.setLogin(login);
            client.setPassword(password);
            client.setMail(mail);
            client.setPhone(phone);
            client.setAddress(address);
            client.setBirthday(birthday);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            mv.addObject("alert_msg", "Une erreur s'est produite durant la soumission du formulaire.");
            mv.addObject("client", client);
            return mv;
        }
        
        if(user_type.equals("Professionnel")){
            this.professional_service.save((ProfessionalEntity)client);
        }
        else{
            this.client_service.save(client);
        }
        
        // Get the new client in the database to add it to the supervised clientd of the current advisor
        // Don't test if the result is not null beacause we just insert it
        ClientEntity database_client = (ClientEntity) this.user_service.findByLoginPassword(login, password);
        
        current_advisor.addClient(database_client);
        
        this.client_service.update(database_client);
        this.advisor_service.update(current_advisor);
        
        mv.addObject("info_msg", "Le client est bien enregistré.");
        mv.addObject("client", client);
        return mv;
    }
    
    /**
     * Path : /add_supervised_client
     * Method : GET
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/add_supervised_client", method = RequestMethod.GET)
    public ModelAndView add_supervised_client(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView("advisor/managementClients");
        
        HttpSession session = request.getSession(false);
        if(null == session){
            return new ModelAndView("index");
        }
        
        String current_advisor_id = (String)(session.getAttribute("user_id"));
        if(null == current_advisor_id || current_advisor_id.equals("")){
            return new ModelAndView("index");
        }
        
        AdvisorEntity current_advisor = this.advisor_service.find(current_advisor_id);
        if(null == current_advisor){
            return new ModelAndView("index");
        }
        
        ArrayList<ClientEntity> supervised_clients = new ArrayList(current_advisor.getClients());
        
        String client_id = request.getParameter("client_id");
        
        if(null == client_id || client_id.equals("")){
            mv.addObject("alert_msg", "Impossible de trouver le client demandé.");
            return this.list_clients(request, mv);
        }
        
        ClientEntity client = this.client_service.find(client_id);
        if(null == client){
            mv.addObject("alert_msg", "Impossible de trouver le client demandé.");
            return this.list_clients(request, mv);
        }
        
        if(supervised_clients.contains(client)){
            mv.addObject("alert_msg", "Vous supervisez déjà ce client.");
            return this.list_clients(request, mv);
        }
        
        AdvisorEntity supervisor = client.getAdvisor();
        if(null != supervisor){
            mv.addObject("alert_msg", "Le client demandé est déjà supervisé par " + supervisor.getCivility() + " " + supervisor.getLastName() + " " + supervisor.getFirstName() + ".");
            return this.list_clients(request, mv);
        }
        
        current_advisor.addClient(client);
        
        this.advisor_service.update(current_advisor);
        this.client_service.update(client);
        
        return this.list_clients(request, mv);
    }
    
    /**
     * Path : /chat_advisor
     * Method : GET
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/chat_advisor", method = RequestMethod.GET)
    public ModelAndView chat_advisor(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView("advisor/chat");
        
        String client_id = request.getParameter("id");
        if(null == client_id || client_id.equals("")){
            mv = new ModelAndView("advisor/managementClients");
            mv.addObject("alert_msg", "Le client demandé est introuvable.");
            return this.list_clients(request, mv);
        }
        
        UserEntity client = this.user_service.find(client_id);
        if(null == client){
            mv = new ModelAndView("advisor/managementClients");
            mv.addObject("alert_msg", "Le client demandé est introuvable.");
            return this.list_clients(request, mv);
        }
        
        HttpSession session = request.getSession(false);
        if(null == session){
            return new ModelAndView("index");
        }
        
        String current_advisor_id = (String)(session.getAttribute("user_id"));
        if(null == current_advisor_id || current_advisor_id.equals("")){
            return new ModelAndView("index");
        }
        
        AdvisorEntity current_advisor = this.advisor_service.find(current_advisor_id);
        if(null == current_advisor){
            return new ModelAndView("index");
        }
        
        /**
         * =====================================================================
         * Mock to create the chet view
         */
        ArrayList<MessageEntity> messages = new ArrayList<>();
        MessageEntity client_send = new MessageEntity("Bonjour Mr le conseiller");
        client_send.setSender(client);
        client_send.setRecipient(current_advisor);
        //---------
        MessageEntity advisor_send = new MessageEntity("Bonjour Mr le client");
        advisor_send.setSender(current_advisor);
        advisor_send.setRecipient(client);
        //---------
        MessageEntity advisor_send2 = new MessageEntity("Comment allez vous ?");
        advisor_send2.setSender(current_advisor);
        advisor_send2.setRecipient(client);
        //---------
        MessageEntity client_send2 = new MessageEntity("Très bien et vous ?");
        client_send2.setSender(client);
        client_send2.setRecipient(current_advisor);
        
        messages.add(client_send);
        messages.add(advisor_send);
        messages.add(advisor_send2);
        messages.add(client_send2);
        
        mv.addObject("client", client);
        mv.addObject("messages", messages);
        /**
         * =====================================================================
         */
        
        return mv;
    }

    /**
     * Path : /client_dashboard
     * Method : GET
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/client_dashboard", method = RequestMethod.GET)
    public ModelAndView client_dashboard(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView("advisor/clientDashboard");
        
        String client_id = request.getParameter("id");
        if(null == client_id || client_id.equals("")){
            mv = new ModelAndView("advisor/clientDashboard");
            mv.addObject("alert_msg", "Le client demandé est introuvable.");
            return this.list_clients(request, mv);
        }
        
        ClientEntity client = this.client_service.find(client_id);
        if(null == client){
            mv = new ModelAndView("advisor/clientDashboard");
            mv.addObject("alert_msg", "Le client demandé est introuvable.");
            return this.list_clients(request, mv);
        }
        
        mv.addObject("client", client);
        return mv;
    }
}