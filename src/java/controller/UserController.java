/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.entity.AdvisorEntity;
import dao.entity.ClientEntity;
import dao.entity.UserEntity;
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
import service.UserService;
import service.UserServiceImpl;

/**
 *
 * @author lucqu
 */
@Controller
public class UserController extends AbstractController {
    
    @Autowired
    private final UserService user_service;
    
    public UserController() {
        user_service = new UserServiceImpl();
    }
    
    //==========================================================================
    // handleRequestInternal
    /**
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
    
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView index(
            HttpServletRequest request,
            HttpServletResponse response)
    {    
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
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
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(
            HttpServletRequest request,
            HttpServletResponse response)
    {   
        loadFixtures();
        
        
        // Récupération num_client et mdp
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(null == login || login.equals("")){
            return new ModelAndView("index");
        }
        if(null == password || password.equals("")){
            return new ModelAndView("index");
        }
        
        // Récupération de l'utilisateur correspondant
        UserEntity u = user_service.findByLoginPassword(login, password);
        if(null == u){
            return new ModelAndView("index");
        }
        
        HttpSession session = this.createSession(request, u);
        
        if(u instanceof ClientEntity){
            ModelAndView mv = new ModelAndView("dashboardClient");
            mv.addObject("user", u);
            return mv;
        }
        else if (u instanceof AdvisorEntity){
            ModelAndView mv = new ModelAndView("dashboardAdvisor");
            mv.addObject("user", u);
            return mv;
        } 
        else {
            return new ModelAndView("index");
        }
    }
    
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
        session.setAttribute("user_type", u.getUserType());
        session.setAttribute("user_last_name", u.getLastName());
        session.setAttribute("user_first_name", u.getFirstName());
        session.setAttribute("user_civility", u.getCivility());
        
        return session;
    }
    
    private void loadFixtures(){
        ArrayList<UserEntity> users = new UserFixtures().getUsers();
        
        for(UserEntity user : users){
            this.user_service.save(user);
        }
    }
    
}