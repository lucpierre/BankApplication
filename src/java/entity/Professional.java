/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author clepaire
 */
public class Professional extends User{
    
    public Professional(String login, String password, Date birthday, String first_name, String last_name, String civility, String mail, String phone){
        super(login, password, birthday, first_name, last_name, civility, mail, phone);
    }

}
