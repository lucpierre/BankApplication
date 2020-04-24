/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entity;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author lucqu
 */
@Entity
@Table(name="AdvisorEntity")
@DiscriminatorValue("AdvisorEntity")
public class AdvisorEntity extends UserEntity implements Serializable {
    
    public AdvisorEntity(){super();}
    
    public AdvisorEntity(
            String address,
            Date birthday,
            boolean civility,
            String first_name,
            String last_name,
            String login,
            String mail,
            String password,
            String phone
    ) throws NoSuchAlgorithmException{
        super(
            address,
            birthday,
            civility,
            first_name,
            last_name,
            login,
            mail,
            password,
            phone
        );
    }
}
