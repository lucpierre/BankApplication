package dao.entity;

import java.io.Serializable;
<<<<<<< HEAD
=======
import java.security.NoSuchAlgorithmException;
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author lucqu
 */
@Entity
@Table(name="ClientEntity")
@DiscriminatorValue("ClientEntity")
public class ClientEntity extends UserEntity implements Serializable {
    
    public ClientEntity(){}
    
    public ClientEntity(
            String address,
            Date birthday,
            boolean civility,
            String first_name,
            String last_name,
            String login,
            String mail,
            String password,
            String phone
<<<<<<< HEAD
    ){
=======
    ) throws NoSuchAlgorithmException{
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
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