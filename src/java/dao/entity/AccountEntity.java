/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Charles
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="AccountEntity")
@DiscriminatorColumn(name="accounttype", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("AccountEntity")

@NamedQueries({
    @NamedQuery(
        name = "find_by_number",
        query = "SELECT u FROM AccountEntity u WHERE u.account_number = :account_number"
    )
})

public class AccountEntity implements Serializable {
    
    
    /**
     * User-s
     */
    
    @ManyToMany(mappedBy = "accounts") 
    private ArrayList<ClientEntity> clients;
        
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long account_id;
    
    @Column
    private double balance;
    
    @Column
    private String account_number;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date created_at;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date updated_at;
    
    //////////////////////////
    // Generated methods   //
    ////////////////////////

    public Long getAccount_id() {
        return account_id;
    }
    
    public void setBalance(double new_balance) {
        this.balance = new_balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccount_number() {
        return account_number;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }
    
    public void setCreatedAt(Date new_date) {
        this.created_at = new_date;
    }

    
    public void setUpdatedAt(Date new_date) {
        this.updated_at = new_date;
    }

    
    public String getAccountType(){
        if(this instanceof SavingAccountsEntity){
            return "SavingAccountsEntity";
        }
        else{
            return "CurrentAccountEntity";
        }
    }
    
    
    /**
     * Get client-s
     * @return the client-s
     */
    public ArrayList<ClientEntity> getUser() {
        return this.clients;
    }

    /**
     * Set client
     * @param new_client 
     */
    public void setUser(ClientEntity new_client) {
        this.clients.add(new_client);
    }
    
    
}
