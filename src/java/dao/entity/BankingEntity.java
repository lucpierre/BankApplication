/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="BankingEntity")
@DiscriminatorValue("BankingEntity")


public class BankingEntity implements Serializable {
    
    /**
     * Account
     */
    @ManyToOne
    @JoinColumn(name="account_fk")
    private AccountEntity account;
    

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long banking_id;
    
    @Column
    private String reference;
    
    @Column
    private double cost;
    
    @Column
    private boolean debtor;
    
    @Column
    private String comment = null;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date created_at;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date updated_at;
    
    /**
     * Getter on the banking id
     * @return Long : banking id
     */
    public Long getBanking_id() {
        return banking_id;
    }
    
    /**
     * Getter on the reference, the recipient of banking
     * @return String : reference
     */
    public String getReference() {
        return this.reference;
    }
    
    /**
     * Setter for the recipient of banking
     * @param new_reference 
     */
    public void setReference(String new_reference) {
        this.reference = new_reference;
    }
    
    /**
     * Getter on the reference, the recipient of banking
     * @return String : reference
     */
    public Double getCost() {
        return this.cost;
    }
    
    /**
     * Setter for the recipient of banking
     * @param new_cost 
     */
    public void setCost(Double new_cost) {
        this.cost = new_cost;
    }
    
    
    /**
     * Getter of debtor : true, the account is debtor, false, is creditor
     * @return boolean : debtor
     */
    public boolean getDebtor() {
        return this.debtor;
    }
    
    /**
     * Setter for debtor
     * @param new_debtor 
     */
    public void setDebtor(boolean new_debtor) {
        this.debtor = new_debtor;
    }

    
    /**
     * Getter of comment : justify the banking
     * @return String : comment
     */
    public String getComment() {
        return this.comment;
    }
    
    /**
     * Setter for comment
     * @param new_comment 
     */
    public void setComment(String new_comment) {
        this.comment = new_comment;
    }

    
    /**
     * Getter on the creation date
     * @return Date
     */
    public Date getCreatedAt() {
        return created_at;
    }

    /**
     * Setter on the creation date
     * @param new_date 
     */
    public void setCreatedAt(Date new_date) {
        this.created_at = new_date;
    }
    
    /**
     * Getter on the update date
     * @return Date
     */
    public Date getUpdatedAt() {
        return updated_at;
    }

    /**
     * Setter on the update date
     * @param updated_at 
     */
    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }
    
    /**
     * Getter of the account
     * @return the account
     */
    public AccountEntity getAccount() {
        return this.account;
    }
    
    /**
     * Setter on the account
     * @param new_account
     */
    public void setAccount(AccountEntity new_account) {
        this.account = new_account;
    }
    

}