/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lucqu
 */
public class User {
    private static int id_num = 0;
    
    private int id;
    private String login;
    private String password;
    private Date birthday;
    private String mail;
    private String phone;
    private String location;
    private String first_name;
    private String last_name;
    private String civility;
    private ArrayList<Account> accounts;
    
    public User(String login){
        this.login = login;
    }
    public User(String login, String password, Date birthday, String first_name, String last_name, String civility, String mail, String phone){
        this.id = User.id_num;
        User.id_num++;
        
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.first_name = first_name;
        this.last_name = last_name;
        this.civility = civility;
        this.mail = mail;
        this.phone = phone;
                
        this.accounts = new ArrayList<Account>();
    }
    
    //////////////
    // GETTERS //
    ////////////

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    
    //////////////
    // SETTERS //
    ////////////

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
    
}
