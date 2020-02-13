/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author clepaire
 */
public class Advisor {
    private ArrayList<User> users;
    private ArrayList<Account> accounts;
    
    public Advisor(){
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }
    
}
