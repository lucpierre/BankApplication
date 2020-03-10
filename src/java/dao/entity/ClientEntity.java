package dao.entity;

import java.io.Serializable;
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
    ){
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