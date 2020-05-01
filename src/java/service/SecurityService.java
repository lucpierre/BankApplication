package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author lucqu
 */
@Service
public class SecurityService {
    
    @Autowired
    private final SessionService session_service = new SessionService();
    
    /**
     * Map of the routes and the list of the kind of users who are allowed
     */
    private final HashMap<String, ArrayList<String>> ROUTING_MAP = new HashMap<>();
    
    /**
     * Constructor, add each routes and the corresponding roles
     */
    public SecurityService(){
        // Define the different roles for the users
        String[] all_roles = {"AdministratorEntity", "AdvisorEntity", "ClientEntity", "ProfessionalEntity"};
        String[] advisor = {"AdministratorEntity", "AdvisorEntity"};
        String[] admin = {"AdministratorEntity"};
        String[] client = {"ClientEntity", "ProfessionalEntity"};
        
        // Set the allowed roles foreach action
        
        // AdministratorController
        ROUTING_MAP.put("list_advisors_get", new ArrayList(Arrays.asList(admin)));
        ROUTING_MAP.put("delete_advisor_get", new ArrayList(Arrays.asList(admin)));
        ROUTING_MAP.put("edit_advisor_get", new ArrayList(Arrays.asList(admin)));
        ROUTING_MAP.put("edit_advisor_post", new ArrayList(Arrays.asList(admin)));
        ROUTING_MAP.put("add_advisor_get", new ArrayList(Arrays.asList(admin)));
        ROUTING_MAP.put("add_advisor_post", new ArrayList(Arrays.asList(admin)));
        
        // AdvisorController
        ROUTING_MAP.put("list_clients_get", new ArrayList(Arrays.asList(advisor)));
        ROUTING_MAP.put("delete_client_get", new ArrayList(Arrays.asList(advisor)));
        ROUTING_MAP.put("edit_client_get", new ArrayList(Arrays.asList(advisor)));
        ROUTING_MAP.put("edit_client_post", new ArrayList(Arrays.asList(advisor)));
        ROUTING_MAP.put("add_client_get", new ArrayList(Arrays.asList(advisor)));
        ROUTING_MAP.put("add_client_post", new ArrayList(Arrays.asList(advisor)));
        ROUTING_MAP.put("add_supervised_client_get", new ArrayList(Arrays.asList(advisor)));
        ROUTING_MAP.put("chat_advisor_get", new ArrayList(Arrays.asList(advisor)));
        ROUTING_MAP.put("chat_advisor_post", new ArrayList(Arrays.asList(advisor)));
        ROUTING_MAP.put("client_dashboard_get", new ArrayList(Arrays.asList(advisor)));
        
        // ClientController
        ROUTING_MAP.put("chat_client_get", new ArrayList(Arrays.asList(client)));
        ROUTING_MAP.put("chat_client_post", new ArrayList(Arrays.asList(client)));
        
        // UserConstroller
        ROUTING_MAP.put("index_get", new ArrayList(Arrays.asList(all_roles)));
        ROUTING_MAP.put("index_post", new ArrayList(Arrays.asList(all_roles)));
        ROUTING_MAP.put("logout_get", new ArrayList(Arrays.asList(all_roles)));
        ROUTING_MAP.put("login_post", new ArrayList(Arrays.asList(all_roles)));
        ROUTING_MAP.put("dashboard_get", new ArrayList(Arrays.asList(all_roles)));
    }
    
    public boolean hasAccess(HttpServletRequest request, String route_name){
        String user_type = (String)this.session_service.getSessionAttribute(request, "user_type");
        if(null == user_type || user_type.equals("")){
            return false;
        }
        
        ArrayList<String> roles = this.ROUTING_MAP.get(route_name);
        if(null == roles){
            return false;
        }
        
        if(!roles.contains(user_type)){
            return false;
        }
        
        return true;
    }
}
