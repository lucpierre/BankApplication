package controller;

import dao.entity.AdvisorEntity;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.AdvisorService;
import service.AdvisorServiceImpl;

/**
 *
 * @author lucqu
 */
@Controller
public class AdministratorController extends AbstractController {
    
    @Autowired
    private final AdvisorService advisor_service;
    
    /**
     * Constructor
     */
    public AdministratorController() {
        this.advisor_service = new AdvisorServiceImpl();
    }
    
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
        ArrayList<AdvisorEntity> advisors = (ArrayList)this.advisor_service.findAll();
        
        ModelAndView mv = new ModelAndView("advisor/administrator/managementAdvisors");
        mv.addObject("advisors", advisors.toArray());
        return mv;
    }
}