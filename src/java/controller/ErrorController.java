package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author lucqu
 */
@Controller
public class ErrorController extends AbstractController {
    
    public ErrorController() {}
    
    /**
     * Return to the index page
     * 
     * @param request
     * @param response
     * @return index page
     * @throws Exception 
     */
    @Override
    protected ModelAndView handleRequestInternal(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception
    {
        throw new UnsupportedOperationException("No need to implement it");
    }
    
    /**
     * Error page when the session is expired
     * 
     * @return index page
     */
    public static ModelAndView expiredSession()
    {
        return new ModelAndView("index");
    }
    
    /**
     * Error page when asked ressource is not found
     * 
     * @return 404error
     */
    public static ModelAndView error404()
    {
        return new ModelAndView("errors/404error");
    }
    
    /**
     * Error page when the user does not have sufficient rights to access the resource
     * 
     * @return error403
     */
    public static ModelAndView error403()
    {
        return new ModelAndView("errors/404error");
    }
}
