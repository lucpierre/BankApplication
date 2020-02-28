/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.entity.UserEntity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private UserService user_service;
    
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
    @RequestMapping(value="index", method = RequestMethod.POST)
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    //==========================================================================
    
    @RequestMapping(value="index", method = RequestMethod.GET)
    public String init(){
        return "index";
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(
            HttpServletRequest request,
            HttpServletResponse response){
        ModelAndView mv = new ModelAndView("dashboardClient");
        
        // Récupération num_client et mdp
        String client_number = request.getParameter("client-number");
        String password = request.getParameter("password");
        if(null == client_number || "" == client_number){
            return new ModelAndView("index");
        }
        if(null == password || "" == password){
            return new ModelAndView("index");
        }
        
        //Récupération de l'utilisateur correspondant
        UserEntity u = user_service.find(client_number, password);
        
        
        mv.addObject("last_name", u.getLastName());
        
        return mv;
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
    
}