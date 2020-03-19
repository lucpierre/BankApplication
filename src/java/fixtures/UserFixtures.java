/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixtures;

import dao.entity.AdvisorEntity;
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
                "c_address",
                new Date(),
                true,
                "c_first_name",
                "c_last_name",
                "c_login",
                "c@mail.com",
                "c_password",
                "0011223344"
            )
        );
        
        users.add(
            new ProfessionalEntity(
                "p_address",
                new Date(),
                true,
                "p_first_name",
                "p_last_name",
                "p_login",
                "p@mail.com",
                "p_password",
                "5566778899",
                "siret",
                "siren",
                "head_office_address"
            )
        );
        
        users.add(
            new AdvisorEntity(
                "a_address",
                new Date(),
                true,
                "a_first_name",
                "a_last_name",
                "a_login",
                "a@mail.com",
                "a_password",
                "9988776655"
            )
        );
    }
    
    public ArrayList<UserEntity> getUsers(){
        return this.users;
    }
}
