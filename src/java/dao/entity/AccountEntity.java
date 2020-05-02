/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
     * Clients list
     */
    @ManyToMany(mappedBy = "accounts") 
    private List<ClientEntity> clients;
        
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long account_id;
    
    @Column
    private double balance;
    
    @Column(unique = true)
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

    public String getAccountNumber() {
        return account_number;
    }
    
    public void setAccountNumber(String new_account_number) {
        this.account_number = new_account_number;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public Date getUpdatedAt() {
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
     * Set the clients list
     * 
     * @param new_clients 
     */
    public void setClients(List<ClientEntity> new_clients){
        this.clients = new_clients;
    }
    
    /**
     * Get the clients list
     * 
     * @return list of ClientEntity
     */
    public List<ClientEntity> getClients(){
        return this.clients;
    }
    
    /**
     * Add a new client
     * 
     * @param new_client 
     */
    public void addClient(ClientEntity new_client){
        if(!this.clients.contains(new_client)){
            this.clients.add(new_client);
            if(!new_client.getAccounts().contains(this)){
                new_client.addAccount(this);
            }
        }
    }
    
    /**
     * Remove a new client
     * 
     * @param client 
     */
    public void removeClient(ClientEntity client){
        if(this.clients.contains(client)){
            this.clients.remove(client);
            if(client.getAccounts().contains(this)){
                client.removeAccount(this);
            }
        }
    }
    
    
    
}
