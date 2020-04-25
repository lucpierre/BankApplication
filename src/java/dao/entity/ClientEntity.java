package dao.entity;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author lucqu
 */
@Entity
@Table(name="ClientEntity")
@DiscriminatorValue("ClientEntity")
public class ClientEntity extends UserEntity implements Serializable {
    
    /**
     * Preferred advisor
     */
    @ManyToOne
    @JoinColumn(name="advisor_fk")
    private AdvisorEntity advisor;
    
    //////////////////////////
    // Methods             //
    ////////////////////////
    
    /**
     * Empty constructor, set all the fields with the default value
     */
    public ClientEntity(){super();}
    
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
    public ClientEntity(
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
    }

    /**
     * Get the preferred advisor
     * @return the preferred advisor
     */
    public AdvisorEntity getAdvisor() {
        return advisor;
    }

    /**
     * Set the preferred advisor
     * @param new_advisor 
     */
    public void setAdvisor(AdvisorEntity new_advisor) {
        this.advisor = new_advisor;
    }
}