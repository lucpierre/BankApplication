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
 * @author clepaire
 */
public class Particular extends User{
    
    private String num_Siret;
    private String companyLocation;
    private String siren;
    private String companyPhone;
    
    public Particular(String login, String password, Date birthday, String first_name, String last_name, String civility, String mail, String phone, String num_Siret,String companyLocation, String siren, String companyPhone){
        super(login, password, birthday, first_name, last_name, civility, mail, phone);
        this.num_Siret = num_Siret;
        this.companyLocation = companyLocation;
        this.siren = siren;
        this.companyPhone = companyPhone;
    }

}
