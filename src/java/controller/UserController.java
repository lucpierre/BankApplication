package controller;

import dao.entity.AdvisorEntity;
import dao.entity.ClientEntity;
import dao.entity.UserEntity;
import exceptions.UserNotFoundException;
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
    private final AdvisorService advisor_service;
    
    @Autowired
    private final ClientService client_service;
    
    public UserController() {
        this.user_service = new UserServiceImpl();
        this.advisor_service = new AdvisorServiceImpl();
        this.client_service = new ClientServiceImpl();
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
        // Récupération de la session existante
        HttpSession session = request.getSession();

        if(null != session){
            session.invalidate();
        }
        
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
        // Récupération num_client et mdp
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(null == login || login.equals("")){
            return new ModelAndView("index");
        }
        if(null == password || password.equals("")){
            return new ModelAndView("index");
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
            return new ModelAndView("index");
        }
        
        // Création de la session
        HttpSession session = this.createSession(request, user);
        
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
        // Récupération de la session existante
        HttpSession session = request.getSession();
        
        String user_id = (String)session.getAttribute("user_id");
        if(user_id == null || user_id.equals("")){
            return this.logout(request, response);
        }
        
        UserEntity u = user_service.find(user_id);
        if(null == u){
            return new ModelAndView("index");
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
     * Crée une session pour l'utilisateur.
     * 
     * @param request
     * @param u
     * @return 
     */
    private HttpSession createSession(HttpServletRequest request, UserEntity u){
        // Crée une nouvelle session si aucune n'existe
        HttpSession session = request.getSession(true);
        
        // Ajout des champs utilisateurs à la session
        session.setAttribute("user_id", Long.toString(u.getId()));
        session.setAttribute("user_type", u.getUserType());
        session.setAttribute("user_last_name", u.getLastName());
        session.setAttribute("user_first_name", u.getFirstName());
        session.setAttribute("user_civility", u.getCivility());
        
        // Fixe le temps avant la destruction automatique de la session (en seconde)
        // 600 secondes = 10 minutes
        session.setMaxInactiveInterval(600);
        
        return session;
    }
    
    /**
     * Peuple la base de données
     */
    private void loadFixtures(){
        ArrayList<UserEntity> users = new UserFixtures().getUsers();
        
        for(UserEntity user : users){
            this.user_service.save(user);
        }
        
        // Ajout du client d'id 1 (d'après les fixtures) à la liste des clients supervisés du conseiller d'id 3 (toujours d'après les fixtures
        AdvisorEntity a = ((AdvisorEntity)(user_service.find("3"))); 
        ClientEntity c = ((ClientEntity)(user_service.find("1")));
        
        a.addClient(c);
        this.advisor_service.update(a);
        this.client_service.update(c);
    }
    
}