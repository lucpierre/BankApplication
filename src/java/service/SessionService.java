package service;

import dao.entity.UserEntity;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucqu
 */
@Service
public class SessionService {
    
    /**
     * Crée une session pour l'utilisateur.
     * 
     * @param request
     * @param u
     * @return 
     */
    public HttpSession createSession(HttpServletRequest request, UserEntity u){
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
     * Get an object stocked in the session ith its key
     * 
     * @param request
     * @param key
     * @return Object || null
     */
    public Object getSessionAttribute(HttpServletRequest request, String key){
        HttpSession session = request.getSession();
        if(null == session){
            return null;
        }
        
        Object obj = session.getAttribute(key);
        if(null == obj || obj.equals("")){
            return null;
        }
        
        return obj;
    }
    
    /**
     * Destroy session if it's existing
     * 
     * @param request 
     */
    public void destroySession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        
        if(null != session){
            session.invalidate();
        }
    }
    
}
