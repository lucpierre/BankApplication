/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixtures;

import dao.entity.ClientEntity;
import dao.entity.ProfessionalEntity;
import dao.entity.UserEntity;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lucqu
 */
public class UserFixtures {
    
    ArrayList<UserEntity> users;
    
    public UserFixtures(){
        users = new ArrayList<>();
        
        users.add(
            new ClientEntity(
                "client_address",
                new Date(),
                true,
                "client_first_name",
                "client_last_name",
                "client_login",
                "client@mail.com",
                "client_password",
                "0011223344"
            )
        );
        
        users.add(
            new ProfessionalEntity(
                "professional_address",
                new Date(),
                true,
                "professional_first_name",
                "professional_last_name",
                "professional_login",
                "professional@mail.com",
                "professional_password",
                "5566778899",
                "siret",
                "siren",
                "head_office_address"
            )
        );   
    }
    
    public ArrayList<UserEntity> getUsers(){
        return this.users;
    }
}
