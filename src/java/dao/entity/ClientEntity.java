package dao.entity;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    
    /**
     * Account-s
     */
    @JoinTable(
            name="ClientEntity_AccountEntity",
            joinColumns=@JoinColumn(name="client_fk"),
            inverseJoinColumns=@JoinColumn(name="account_fk")
    )
    @ManyToMany
    private List<AccountEntity> accounts;
  
    
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
    
    /**
     * Get accounts list
     * 
     * @return the client-s
     */
    public ArrayList<AccountEntity> getAccounts() {
        return new ArrayList(this.accounts);
    }

    /**
     * Set accounts list
     * 
     * @param new_accounts
     */
    public void setAccounts(AccountEntity new_accounts) {
        this.accounts.add(new_accounts);
    }
    
    /**
     * Add a new account
     * 
     * @param new_account 
     */
    public void addAccount(AccountEntity new_account){
        if(!this.accounts.contains(new_account)){
            this.accounts.add(new_account);
            if(!new_account.getClients().contains(this)){
                new_account.addClient(this);
            }
        }
    }
    
    /**
     * Remove a new account
     * 
     * @param account 
     */
    public void removeAccount(AccountEntity account){
        if(this.accounts.contains(account)){
            this.accounts.remove(account);
            if(account.getClients().contains(this)){
                account.removeClient(this);
            }
        }
    }
}