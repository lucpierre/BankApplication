/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lucqu
 */
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long num_client;
    
    @Column
    private String login;
    
    @Column
    private String password;
    
    @Column
    private String mail;
    
    @Column
    private String phone;
    
    @Column
    private String first_name;
    
    @Column
    private String last_name;

    @Column
    private String address;
    
    @Column
    private String civility;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date created_at;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date updated_at;
    

    //////////////////////////
    // Generated methods   //
    ////////////////////////
    
    public Long getId() {
        return num_client;
    }

    public void setId(Long id) {
        this.num_client = num_client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (num_client != null ? num_client.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.num_client == null && other.num_client != null) || (this.num_client != null && !this.num_client.equals(other.num_client))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.entities.UserEntity[ id=" + num_client + " ]";
    }
    
    //////////////////////////
    // Methods   //
    ////////////////////////
    
    public void UserEntity(){
        this.address = "address";
        this.birthday = new Date();
        this.civility = "Mr";
        this.created_at = new Date();
        this.first_name = "first_name";
        this.last_name = "last_name";
        this.login = "login";
        this.mail = "mail";
        this.password = "password";
        this.phone = "0011223344";
        this.updated_at = new Date();
    }
    
    /**
     * Getter on login
     * @return String
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Setter on login
     * @param new_login
     */
    public void setLogin(String new_login) {
        this.login = new_login;
    }

    /**
     * Getter on the password
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter on the password
     * @param new_password String
     */
    public void setPassword(String new_password) {
        this.password = new_password;
    }

    /**
     * Getter on the mail
     * @return String
     */
    public String getMail() {
        return this.mail;
    }

    /**
     * Setter on the mail
     * @param new_mail String
     */
    public void setMail(String new_mail) {
        this.mail = new_mail;
    }

    /**
     * Getter on the phone
     * @return String
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Setter on the phone
     * @param new_phone
     */
    public void setPhone(String new_phone) {
        this.phone = new_phone;
    }

    /**
     * Getter on the first name
     * @return String
     */
    public String getFirstName() {
        return this.first_name;
    }

    /**
     * Getter on the last name
     * @return String
     */
    public String getLastName() {
        return this.last_name;
    }

    /**
     * Getter on the address
     * @return String
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Setter on the address
     * @param new_address
     */
    public void setAddress(String new_address) {
        this.address = new_address;
    }

    /**
     * Getter on the civility
     * @return String
     */
    public String getCivility() {
        return this.civility;
    }

    /**
     * Get on the birthday
     * @return Date
     */
    public Date getBirthday() {
        return this.birthday;
    }

    /**
     * Getter on the created_at
     * @return Date
     */
    public Date getCreatedAt() {
        return this.created_at;
    }

    /**
     * Getter on the updated_at
     * @return Date
     */
    public Date getUpdatedAt() {
        return this.updated_at;
    }

    /**
     * Setter on the updated_at
     * @param new_date Date
     */
    public void setUpdatedAt(Date new_date) {
        this.updated_at = new_date;
    }
    
}
