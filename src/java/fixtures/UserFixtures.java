/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixtures;

<<<<<<< HEAD
=======
import dao.entity.AdministratorEntity;
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
import dao.entity.AdvisorEntity;
import dao.entity.ClientEntity;
import dao.entity.ProfessionalEntity;
import dao.entity.UserEntity;
<<<<<<< HEAD
=======
import java.security.NoSuchAlgorithmException;
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
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
<<<<<<< HEAD
        
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
        
        users.add(
            new AdvisorEntity(
                "advisor_address",
                new Date(),
                true,
                "advisor_first_name",
                "advisor_last_name",
                "advisor_login",
                "advisor@mail.com",
                "advisor_password",
                "9988776655"
            )
        );
=======
        try{
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

            users.add(
                new AdministratorEntity(
                    "admin",
                    new Date(),
                    true,
                    "admin",
                    "admin",
                    "admin",
                    "admin@mail.com",
                    "admin",
                    "9988776655"
                )
            );
        }
        catch(NoSuchAlgorithmException e){
            System.err.println("An error occured during the loading of the users fixtures");
            System.err.println(e.getMessage());
        }
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
    }
    
    public ArrayList<UserEntity> getUsers(){
        return this.users;
    }
}
