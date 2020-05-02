package controller;

import dao.entity.AccountEntity;
import dao.entity.AdvisorEntity;
import dao.entity.ClientEntity;
import dao.entity.UserEntity;
import exceptions.UserNotFoundException;
import fixtures.AccountFixtures;
import fixtures.UserFixtures;
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
import service.SecurityService;
import service.SessionService;
import service.entities.AccountService;
import service.entities.AccountServiceImpl;
import service.entities.AdvisorService;
import service.entities.AdvisorServiceImpl;
import service.entities.ClientService;
import service.entities.ClientServiceImpl;
import service.entities.UserService;
import service.entities.UserServiceImpl;

/**
 *
 * @author lucqu
 */
@Controller
public class UserController extends AbstractController {
    
    @Autowired
    private final UserService user_service;
    
    @Autowired
    private final AccountService account_service;
    
    @Autowired
    private final AdvisorService advisor_service;
    
    @Autowired
    private final ClientService client_service;
    
    @Autowired
    private final SecurityService security_service;
    
    @Autowired
    private final SessionService session_service;
    
    public UserController() {
        this.user_service = new UserServiceImpl();
        this.account_service = new AccountServiceImpl();
        this.advisor_service = new AdvisorServiceImpl();
        this.client_service = new ClientServiceImpl();
        this.security_service = new SecurityService();
        this.session_service = new SessionService();
    }
    
    //==========================================================================
    // handleRequestInternal
    /**
     * Path : /index
     * method POST
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @Override
    @RequestMapping(value="/index", method = RequestMethod.POST)
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    //==========================================================================
    
    /**
     * Path : /index
     * method GET
     * 
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView index(
            HttpServletRequest request,
            HttpServletResponse response)
    {
        // Charge des profils d'utilisateurs
        loadFixtures();
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    /**
     * Path /logout
     * method GET
     * 
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView logout(
            HttpServletRequest request,
            HttpServletResponse response)
    {
        this.session_service.destroySession(request);
        
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("logout", true);
        return mv;
    }
    
    /**
     * Path : /login
     * method POST
     * 
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(
            HttpServletRequest request,
            HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView("index");
        
        // Récupération num_client et mdp
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(null == login || login.equals("")){
            mv.addObject("alert_msg", "Login et/ou mot de passe incorrect.");
            return mv;
        }
        if(null == password || password.equals("")){
            mv.addObject("alert_msg", "Login et/ou mot de passe incorrect.");
            return mv;
        }
        
        UserEntity user = null;
        try{
            // Récupération de l'utilisateur correspondant
            user = user_service.findByLoginPassword(login, password);
            if(null == user){
                throw new UserNotFoundException();
            }
        }
        catch(UserNotFoundException e){
            mv.addObject("alert_msg", "Login et/ou mot de passe incorrect.");
            return mv;
        }
        
        // Création de la session
        HttpSession session = this.session_service.createSession(request, user);
        
        // Redirection vers le bon tableau de bord selon le type d'utilisateur
        return this.dashboard(request, response);
    }
    
    /**
     * Path : /dashboard
     * method GET
     * 
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard(
            HttpServletRequest request,
            HttpServletResponse response)
    {
        if(!this.security_service.hasAccess(request, "dashboard_get")){
            return ErrorController.error403();
        }
        
        // Récupération de la session existante
        String user_id = (String)this.session_service.getSessionAttribute(request, "user_id");
        if(null == user_id){
            return ErrorController.expiredSession();
        }
        
        
        UserEntity u = user_service.find(user_id);
        if(null == u){
            return ErrorController.expiredSession();
        }
        
        if(u instanceof ClientEntity){
            ModelAndView mv = new ModelAndView("client/dashboardClient");
            mv.addObject("user", u);
            return mv;
        }
        else if (u instanceof AdvisorEntity){
            ModelAndView mv = new ModelAndView("advisor/dashboardAdvisor");
            mv.addObject("user", u);
            return mv;
        } 
        else {
            // Jeter une exception
            return new ModelAndView("index");
        }
    }
    
    //==========================================================================
    // Méthodes internes
    //==========================================================================
    
    /**
     * Peuple la base de données
     */
    private void loadFixtures(){
        ArrayList<UserEntity> users = new UserFixtures().getUsers();
        ArrayList<AccountEntity> accounts = new AccountFixtures().getAccounts();
        
        
        try{
            for(UserEntity user : users){
                this.user_service.save(user);
            }
            
            for(AccountEntity account : accounts){
                this.account_service.save(account);
            }

            // Ajout du client d'id 1 (d'après les fixtures) à la liste des clients supervisés du conseiller d'id 3 (toujours d'après les fixtures
            AdvisorEntity a = ((AdvisorEntity)(user_service.find("3"))); 
            ClientEntity c = ((ClientEntity)(user_service.find("1")));

            a.addClient(c);
            this.advisor_service.update(a);
            this.client_service.update(c);
            
            // Ajout des comptes au client
            AccountEntity account_0 = this.account_service.find("5");
            AccountEntity account_1 = this.account_service.find("6");
            
            c.addAccount(account_0);
            c.addAccount(account_1);
            
            client_service.update(c);
            account_service.update(account_0);
            account_service.update(account_1);
        }
        catch(Exception e){
            System.err.println("Error during the loading of the fixtures.");
            e.printStackTrace();
        }
    }
    
}