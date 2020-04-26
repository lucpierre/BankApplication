package controller;

import dao.entity.AdministratorEntity;
import dao.entity.AdvisorEntity;
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
import service.entities.AdministratorService;
import service.entities.AdministratorServiceImpl;
import service.entities.AdvisorService;
import service.entities.AdvisorServiceImpl;
import service.entities.UserService;
import service.entities.UserServiceImpl;

/**
 *
 * @author lucqu
 */
@Controller
public class AdministratorController extends AbstractController {
    
    @Autowired
    private final UserService user_service;
    
    @Autowired
    private final AdvisorService advisor_service;
    
    @Autowired
    private final AdministratorService administrator_service;
    
    /**
     * Constructor
     */
    public AdministratorController() {
        this.user_service = new UserServiceImpl();
        this.advisor_service = new AdvisorServiceImpl();
        this.administrator_service = new AdministratorServiceImpl();
    }
    
    //==========================================================================
    /**
     * Path : /list_advisors
     * method GET
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @Override
    @RequestMapping(value="/list_advisors", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("advisor/administrator/managementAdvisors");
        return this.list_advisor(mv);
    }
    //==========================================================================
    
    /**
     * PATH : NO_PATH
     * Take a ModelAndView and return it with the list of the advisors
     * 
     * @param mv
     * @return
     * @throws Exception 
     */
    private ModelAndView list_advisor(
            ModelAndView mv
    ) throws Exception {
        ArrayList<AdvisorEntity> advisors = (ArrayList)this.advisor_service.findAll();
        mv.addObject("advisors", advisors.toArray());
        return mv;
    }
    
    /**
     * Path : /delete_advisor
     * Method : GET
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/delete_advisor", method = RequestMethod.GET)
    public ModelAndView delete_advisor(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView("advisor/administrator/managementAdvisors");
        
        String advisor_id = request.getParameter("id");
        if(null == advisor_id || advisor_id.equals("")){
            mv.addObject("alert_msg", "Impossible de récupérer le conseiller demandé.");
            return this.list_advisor(mv);
        }
        
        UserEntity user = this.user_service.find(advisor_id);
        if(null == user){
            mv.addObject("alert_msg", "Impossible de récupérer le conseiller demandé.");
            return this.list_advisor(mv);
        }
        
        HttpSession session = request.getSession();
        String current_advisor_id = (String)session.getAttribute("user_id");
        if(current_advisor_id == null || current_advisor_id.equals("") ){
            mv.addObject("alert_msg", "Vous devez être connecté pour supprimer un conseiller.");
            return this.list_advisor(mv);
        }
        
        if(current_advisor_id.equals(advisor_id)){
            mv.addObject("alert_msg", "Vous ne pouvez supprimer un conseiller connecté.");
            return this.list_advisor(mv);
        }
        
        this.user_service.delete(user);
        mv.addObject("info_msg", "Le conseiller a bien été supprimé.");
        
        return this.list_advisor(mv);
    }
    
    /**
     * Path : /edit_advisor
     * Method : GET
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/edit_advisor", method = RequestMethod.GET)
    public ModelAndView edit_advisor_get(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView("advisor/administrator/form_advisor");
        
        String advisor_id = request.getParameter("id");
        if(null == advisor_id || advisor_id.equals("")){
            mv.addObject("alert_msg", "Impossible de récupérer le conseiller demandé.");
            return this.handleRequestInternal(request, response);
        }
        
        UserEntity advisor = this.user_service.find(advisor_id);
        if(null == advisor){
            mv.addObject("alert_msg", "Impossible de récupérer le conseiller demandé.");
            return this.handleRequestInternal(request, response);
        }
        
        mv.addObject("advisor", advisor);
        return mv;
    }
    
    /**
     * Path : /edit_advisor
     * Method : POST
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/edit_advisor", method = RequestMethod.POST)
    public ModelAndView edit_advisor_post(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView("advisor/administrator/form_advisor");
        
        String advisor_id = request.getParameter("id");
        if(null == advisor_id || advisor_id.equals("")){
            mv.addObject("alert_msg", "Aucun conseiller correspondant.");
            return this.edit_advisor_get(request, response);
        }
        
        UserEntity advisor = this.user_service.find(advisor_id);
        if(null == advisor){
            mv.addObject("alert_msg", "Impossible de récupérer le conseiller demandé.");
            System.err.println("Impossible to find the advisor");
            return this.edit_advisor_get(request, response);
        }
        
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
            advisor.setCivility(civility);
            advisor.setFirstName(first_name);
            advisor.setLastName(last_name);
            advisor.setLogin(login);
            advisor.setMail(mail);
            advisor.setPhone(phone);
            advisor.setAddress(address);
            advisor.setBirthday(birthday);
            
            if(!PasswordService.compareString(password, advisor.getPassword())){
                advisor.setPassword(password);
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            mv.addObject("alert_msg", "Une erreur s'est produite durant la soumission du formulaire.");
            mv.addObject("advisor", advisor);
            return mv;
        }
        
        this.advisor_service.update((AdvisorEntity)advisor);
        mv.addObject("info_msg", "Les informations ont été mises à jour.");
        mv.addObject("advisor", advisor);
        return mv;
    }
    
    /**
     * Path : /add_advisor
     * Method : GET
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/add_advisor", method = RequestMethod.GET)
    public ModelAndView add_advisor_get(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView("advisor/administrator/form_advisor");
        return mv;
    }
    
    /**
     * Path : /add_advisor
     * Method : POST
     * 
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping(value="/add_advisor", method = RequestMethod.POST)
    public ModelAndView add_advisor_post(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView("advisor/administrator/form_advisor");
        
        String user_type = request.getParameter("user_type_input");
        String civility = request.getParameter("civility_input");
        String first_name = request.getParameter("first_name_input");
        String last_name = request.getParameter("last_name_input");
        String login = request.getParameter("login_input");
        String password = request.getParameter("password_input");
        String mail = request.getParameter("mail_input");
        String phone = request.getParameter("phone_input");
        String address = request.getParameter("address_input");
        String birthday = request.getParameter("birthday_input");
        
        AdvisorEntity advisor = null;
        
        try{
            if(user_type.equals("Administrateur")){
                advisor = new AdministratorEntity();
            }
            else{
                advisor = new AdvisorEntity();
            }
            
            advisor.setCivility(civility);
            advisor.setFirstName(first_name);
            advisor.setLastName(last_name);
            advisor.setLogin(login);
            advisor.setPassword(password);
            advisor.setMail(mail);
            advisor.setPhone(phone);
            advisor.setAddress(address);
            advisor.setBirthday(birthday);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            mv.addObject("alert_msg", "Une erreur s'est produite durant la soumission du formulaire.");
            mv.addObject("advisor", advisor);
            return mv;
        }
        
        if(user_type.equals("Administrateur")){
            this.administrator_service.save((AdministratorEntity)advisor);
            mv.addObject("info_msg", "L'administrateur est bien enregistré.");
        }
        else{
            this.advisor_service.save(advisor);
            mv.addObject("info_msg", "Le conseiller est bien enregistré.");
        }
        
        mv.addObject("advisor", advisor);
        return mv;
    }
}