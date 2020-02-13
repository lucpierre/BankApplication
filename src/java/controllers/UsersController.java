/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author clepaire
 */
@Controller
public class UsersController extends AbstractController {
    
    @RequestMapping(value="index", method = RequestMethod.GET)     
    public String init(){
        return "dashboardAdvisors";
    }
    
    public UsersController() {
    }
    
    @RequestMapping(value="result", method = RequestMethod.POST)
    protected ModelAndView handleRequestInternal( HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String result;
        ModelAndView mv = new ModelAndView("result"); 
        String login = request.getParameter("login");
        if (login!=null && login.length()>0){
            result = "Bonjour "+login;
        }else{                      
            result = "Error";
        }
        mv.addObject("userMessage",result);
        return mv;
    }
    
}
