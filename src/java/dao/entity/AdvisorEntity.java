package dao.entity;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lucqu
 */
@Entity
@Table(name="AdvisorEntity")
@DiscriminatorValue("AdvisorEntity")
public class AdvisorEntity extends UserEntity implements Serializable {
    
    /**
     * Supervised clients list 
     */
    @OneToMany(mappedBy = "advisor")
    private List<ClientEntity> clients;
    
    //////////////////////////
    // Methods             //
    ////////////////////////
    
    /**
     * Empty constructor, set all the fields with the default value
     */
    public AdvisorEntity(){
        super();
        this.clients = new ArrayList<>();
    }
    
    /**
     * Constructor
     * @param address
     * @param birthday
     * @param civility
     * @param first_name
     * @param last_name
     * @param login
     * @param mail
     * @param password
     * @param phone
     * @throws NoSuchAlgorithmException 
     */
    public AdvisorEntity(
            String address,
            Date birthday,
            boolean civility,
            String first_name,
            String last_name,
            String login,
            String mail,
            String password,
            String phone
    ) throws NoSuchAlgorithmException{
        super(
            address,
            birthday,
            civility,
            first_name,
            last_name,
            login,
            mail,
            password,
            phone
        );
        this.clients = new ArrayList<>();
    }

    /**
     * Getter on the clients list
     * @return the supervised clients list
     */
    public List<ClientEntity> getClients() {
        return this.clients;
    }
    
    /**
     * Getter on the clients list
     * @param clients
     */
    public void setClients(List<ClientEntity> clients) {
        this.clients = clients;
    }
    
    /**
     * Add a client to the supervised clients list
     * @param new_client 
     */
    public void addClient(ClientEntity new_client) {
        if(!this.clients.contains(new_client)){
            this.clients.add(new_client);
            new_client.setAdvisor(this);
        }
    }
    
    /**
     * Remove a client from the supervised clients list
     * @param client 
     */
    public void removeClient(ClientEntity client) {
        if(this.clients.contains(client)){
            this.clients.remove(client);
            if(client.getAdvisor() == this){
                client.setAdvisor(null);
            }
        }
    }
}
