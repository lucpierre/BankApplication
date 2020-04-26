<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
=======
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
package controller;

import dao.entity.AdvisorEntity;
import dao.entity.ClientEntity;
import dao.entity.UserEntity;
<<<<<<< HEAD
import fixtures.UserFixtures;
import java.util.ArrayList;
=======
import exceptions.UserNotFoundException;
import fixtures.UserFixtures;
import java.util.ArrayList;
import java.util.Vector;
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
<<<<<<< HEAD
import service.UserService;
import service.UserServiceImpl;
=======
import service.entities.UserService;
import service.entities.UserServiceImpl;
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b

/**
 *
 * @author lucqu
 */
@Controller
public class UserController extends AbstractController {
    
    @Autowired
    private final UserService user_service;
    
    public UserController() {
<<<<<<< HEAD
        user_service = new UserServiceImpl();
=======
        this.user_service = new UserServiceImpl();
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
    }
    
    //==========================================================================
    // handleRequestInternal
    /**
<<<<<<< HEAD
=======
     * Path : /index
     * method POST
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
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
    
<<<<<<< HEAD
=======
    /**
     * Path : /index
     * method GET
     * 
     * @param request
     * @param response
     * @return 
     */
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView index(
            HttpServletRequest request,
            HttpServletResponse response)
<<<<<<< HEAD
    {    
=======
    {
        // Charge des profils d'utilisateurs
        loadFixtures();
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
<<<<<<< HEAD
=======
    /**
     * Path /logout
     * method GET
     * 
     * @param request
     * @param response
     * @return 
     */
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
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
    
<<<<<<< HEAD
=======
    /**
     * Path : /login
     * method POST
     * 
     * @param request
     * @param response
     * @return 
     */
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(
            HttpServletRequest request,
            HttpServletResponse response)
<<<<<<< HEAD
    {   
        loadFixtures();
        
        
=======
    {
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
        // Récupération num_client et mdp
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(null == login || login.equals("")){
            return new ModelAndView("index");
        }
        if(null == password || password.equals("")){
            return new ModelAndView("index");
        }
        
<<<<<<< HEAD
        // Récupération de l'utilisateur correspondant
        UserEntity u = user_service.findByLoginPassword(login, password);
        if(null == u){
            return new ModelAndView("index");
        }
        
        HttpSession session = this.createSession(request, u);
        
        if(u instanceof ClientEntity){
            ModelAndView mv = new ModelAndView("dashboardClient");
=======
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
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
            mv.addObject("user", u);
            return mv;
        }
        else if (u instanceof AdvisorEntity){
<<<<<<< HEAD
            ModelAndView mv = new ModelAndView("dashboardAdvisor");
=======
            ModelAndView mv = new ModelAndView("advisor/dashboardAdvisor");
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
            mv.addObject("user", u);
            return mv;
        } 
        else {
<<<<<<< HEAD
=======
            // Jeter une exception
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
            return new ModelAndView("index");
        }
    }
    
<<<<<<< HEAD
    /*
    
    @RequestMapping(value="form_add_user", method = RequestMethod.GET)
    protected ModelAndView formAddUser(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    @RequestMapping(value="listusers", method = RequestMethod.GET)
    protected ModelAndView list(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    @RequestMapping(value="adduser", method = RequestMethod.POST)
    protected ModelAndView addUser(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    @RequestMapping(value="getuser", method = RequestMethod.GET)
    protected ModelAndView getUser(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    @RequestMapping(value="removeuser", method = RequestMethod.GET)
    protected ModelAndView removeUser(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    */
    
    private HttpSession createSession(HttpServletRequest request, UserEntity u){
        // Crée une nouvelle session si aucune n'existe
        HttpSession session = request.getSession(true);
        session.setAttribute("user_id", u.getId());
=======
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
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
        session.setAttribute("user_type", u.getUserType());
        session.setAttribute("user_last_name", u.getLastName());
        session.setAttribute("user_first_name", u.getFirstName());
        session.setAttribute("user_civility", u.getCivility());
        
<<<<<<< HEAD
        return session;
    }
    
=======
        // Fixe le temps avant la destruction automatique de la session (en seconde)
        // 600 secondes = 10 minutes
        session.setMaxInactiveInterval(600);
        
        return session;
    }
    
    /**
     * Peuple la base de données
     */
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
    private void loadFixtures(){
        ArrayList<UserEntity> users = new UserFixtures().getUsers();
        
        for(UserEntity user : users){
            this.user_service.save(user);
        }
    }
    
}