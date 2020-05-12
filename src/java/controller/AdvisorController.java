package controller;

import dao.entity.AccountEntity;
import dao.entity.AdvisorEntity;
import dao.entity.ClientEntity;
import dao.entity.MessageEntity;
import dao.entity.ProfessionalEntity;
import dao.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.PasswordService;
import service.SecurityService;
import service.SessionService;
import service.entities.AccountService;
import service.entities.AccountServiceImpl;
import service.entities.AdvisorService;
import service.entities.AdvisorServiceImpl;
import service.entities.ClientService;
import service.entities.ClientServiceImpl;
import service.entities.MessageService;
import service.entities.MessageServiceImpl;
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
    private final AccountService account_service;
    
    @Autowired
    private final ClientService client_service;
    
    @Autowired
    private final MessageService message_service;
    
    @Autowired
    private final ProfessionalService professional_service;
    
    @Autowired
    private final SecurityService security_service;
    
    @Autowired
    private final SessionService session_service;
    
    /**
     * Constructor
     */
    public AdvisorController() {
        this.user_service = new UserServiceImpl();
        this.advisor_service = new AdvisorServiceImpl();
        this.account_service = new AccountServiceImpl();
        this.client_service = new ClientServiceImpl();
        this.message_service = new MessageServiceImpl();
        this.professional_service = new ProfessionalServiceImpl();
        this.security_service = new SecurityService();
        this.session_service = new SessionService();
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
        if(!this.security_service.hasAccess(request, "list_clients_get")){
            return ErrorController.error403();
        }
        
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
        
        String current_advisor_id = (String)this.session_service.getSessionAttribute(request, "user_id");
        if(null == current_advisor_id || current_advisor_id.equals("")){
            return ErrorController.error404();
        }
        
        AdvisorEntity current_advisor = this.advisor_service.find(current_advisor_id);
        if(null == current_advisor){
            return ErrorController.expiredSession();
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
        if(!this.security_service.hasAccess(request, "delete_client_get")){
            return ErrorController.error403();
        }
        
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
        if(!this.security_service.hasAccess(request, "edit_client_get")){
            return ErrorController.error403();
        }
        
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
        if(!this.security_service.hasAccess(request, "edit_client_post")){
            return ErrorController.error403();
        }
        
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
            
            if(client instanceof ProfessionalEntity){
                this.professional_service.update((ProfessionalEntity)client);
            }
            else{
                this.client_service.update((ClientEntity)client);
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            mv.addObject("alert_msg", "Une erreur s'est produite durant la soumission du formulaire.");
            mv.addObject("client", client);
            return mv;
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
        if(!this.security_service.hasAccess(request, "add_client_get")){
            return ErrorController.error403();
        }
        
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
     */
    @RequestMapping(value="/add_client", method = RequestMethod.POST)
    public ModelAndView add_client_post(
            HttpServletRequest request,
            HttpServletResponse response)
    {
        if(!this.security_service.hasAccess(request, "add_client_post")){
            return ErrorController.error403();
        }
        
        ModelAndView mv = new ModelAndView("advisor/form_client");
        
        String advisor_id = (String)this.session_service.getSessionAttribute(request, "user_id");
        if(null == advisor_id || advisor_id.equals("")){
            return ErrorController.expiredSession();
        }
        
        AdvisorEntity current_advisor = this.advisor_service.find(advisor_id);
        if(null == current_advisor){
            return ErrorController.expiredSession();
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
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            mv.addObject("alert_msg", "Une erreur s'est produite durant la soumission du formulaire.");
            mv.addObject("client", client);
            return mv;
        }
        
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
    public ModelAndView add_supervised_client_get(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        if(!this.security_service.hasAccess(request, "add_supervised_client")){
            return ErrorController.error403();
        }
        
        ModelAndView mv = new ModelAndView("advisor/managementClients");
        
        String current_advisor_id = (String)this.session_service.getSessionAttribute(request, "user_id");
        if(null == current_advisor_id || current_advisor_id.equals("")){
            return ErrorController.expiredSession();
        }
        
        AdvisorEntity current_advisor = this.advisor_service.find(current_advisor_id);
        if(null == current_advisor){
            return ErrorController.expiredSession();
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
    public ModelAndView chat_advisor_get(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        if(!this.security_service.hasAccess(request, "chat_advisor_get")){
            return ErrorController.error403();
        }
        
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
        
        String current_advisor_id = (String)this.session_service.getSessionAttribute(request, "user_id");
        if(null == current_advisor_id || current_advisor_id.equals("")){
            return ErrorController.expiredSession();
        }
        
        AdvisorEntity current_advisor = this.advisor_service.find(current_advisor_id);
        if(null == current_advisor){
            return ErrorController.expiredSession();
        }
        
        ArrayList<MessageEntity> messages = new ArrayList<>(this.message_service.findChat(current_advisor, client));
        mv.addObject("client", client);
        mv.addObject("messages", messages);
        
        return mv;
    }
    
    /**
     * Path : /chat_advisor
     * Method : POST
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/chat_advisor", method = RequestMethod.POST)
    public ModelAndView chat_advisor_post(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        if(!this.security_service.hasAccess(request, "chat_advisor_post")){
            return ErrorController.error403();
        }
        
        ModelAndView mv;
        
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
        
        String current_advisor_id = (String)this.session_service.getSessionAttribute(request, "user_id");
        if(null == current_advisor_id || current_advisor_id.equals("")){
            return ErrorController.expiredSession();
        }
        
        AdvisorEntity current_advisor = this.advisor_service.find(current_advisor_id);
        if(null == current_advisor){
            return ErrorController.expiredSession();
        }
        
        String message_content = request.getParameter("message_content");
        if(null == message_content || message_content.equals("")){
            return this.chat_advisor_get(request, response);
        }
        
        MessageEntity message = new MessageEntity(message_content);
        message.setSender(current_advisor);
        message.setRecipient(client);
        this.message_service.save(message);
        
        return this.chat_advisor_get(request, response);
    }
    
    /**
     * PATH : NO_PATH
     * 
     * @param request
     * @param mv
     * @return
     * @throws Exception 
     */
    private ModelAndView client_dashboard(
        HttpServletRequest request,
        ModelAndView mv
    ) throws Exception{
        
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
    public ModelAndView client_dashboard_get(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        if(!this.security_service.hasAccess(request, "client_dashboard_get")){
            return ErrorController.error403();
        }
        
        ModelAndView mv = new ModelAndView("advisor/clientDashboard");
        
        return this.client_dashboard(request, mv);
    }
    
    /**
     * Path : /remove_client_account
     * Method : GET
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/remove_client_account", method = RequestMethod.GET)
    public ModelAndView remove_client_account_get(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        if(!this.security_service.hasAccess(request, "remove_client_account_get")){
            return ErrorController.error403();
        }
        
        ModelAndView mv = new ModelAndView("advisor/clientDashboard");
        
        String account_id = request.getParameter("account_id");
        if(null == account_id || account_id.equals("")){
            mv.addObject("alert_msg", "Le compte est introuvable.");
            return this.client_dashboard(request, mv);
        }
        
        AccountEntity account = this.account_service.find(account_id);
        if(null == account){
            mv.addObject("alert_msg", "Le compte est introuvable.");
            return this.client_dashboard(request, mv);
        }
        
        if(account.getBalance() != 0.0){
            mv.addObject("alert_msg", "Veuillez vider le compte avant de le cloturer.");
            return this.client_dashboard(request, mv);
        }
        
        ArrayList<ClientEntity> clients = new ArrayList(account.getClients());
        
        clients.forEach((client_entity) -> {
            ClientEntity client = this.client_service.find(Long.toString(client_entity.getId()));
            client.removeAccount(account);
            this.client_service.update(client);
        });
        
        this.account_service.delete(account);
        
        mv.addObject("alert_msg", "Le compte a bien été supprimé.");
        return this.client_dashboard(request, mv);
    }
    
    /**
     * Path : /add_client_account
     * Method : GET
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/add_client_account", method = RequestMethod.GET)
    public ModelAndView add_client_account_get(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        if(!this.security_service.hasAccess(request, "add_client_account_get")){
            return ErrorController.error403();
        }
        
        ModelAndView mv = new ModelAndView("advisor/formAccount");
        
        
        String client_id = request.getParameter("id");
        if(null == client_id || client_id.equals("")){
            mv.addObject("alert_msg", "Le client demandé est introuvable.");
            return mv;
        }
        
        ClientEntity client = this.client_service.find(client_id);
        if(null == client){
            mv.addObject("alert_msg", "Le client demandé est introuvable.");
            return mv;
        }
        
        mv.addObject("client", client);
        return mv;
    }
    
    /**
     * Path : /add_client_account
     * Method : POST
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/add_client_account", method = RequestMethod.POST)
    public ModelAndView add_client_account_post(
        HttpServletRequest request,
        HttpServletResponse response) throws Exception
    {
        if(!this.security_service.hasAccess(request, "add_client_account_post")){
            return ErrorController.error403();
        }
        
        ModelAndView mv = new ModelAndView("advisor/formAccount");
        
        
        String client_id = request.getParameter("id");
        if(null == client_id || client_id.equals("")){
            mv.addObject("alert_msg", "Le client demandé est introuvable.");
            return mv;
        }
        
        ClientEntity client = this.client_service.find(client_id);
        if(null == client){
            mv.addObject("alert_msg", "Le client demandé est introuvable.");
            return mv;
        }
        
        
        String account_type = request.getParameter("account_type_input");
        if(null == account_type || account_type.equals("")){
            mv.addObject("alert_msg", "Le type de compte n'est pas autorisé.");
            return mv;
        }
        
        String balance = request.getParameter("balance_input");
        if(null == balance || balance.equals("")){
            mv.addObject("alert_msg", "Le solde à l'ouverture doit être précisé.");
            return mv;
        }
        
        this.account_service.openNewAccount(client_id, account_type, balance);
        
        mv = new ModelAndView("advisor/clientDashboard");
        mv.addObject("info_msg", "Le compte a bien été ouvert.");
        mv.addObject("client", client);
        return this.client_dashboard(request, mv);
    }
}