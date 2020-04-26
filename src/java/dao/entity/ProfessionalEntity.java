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
@Table(name="ProfessionalEntity")
@DiscriminatorValue("ProfessionalEntity")
public class ProfessionalEntity extends ClientEntity implements Serializable {
    
    private String siret;
    
    private String siren;
    
    private String head_office_address;
    
    
    //////////////////////////
    // Generated methods   //
    ////////////////////////
    
    public ProfessionalEntity(){
        super();
    }
    
    public ProfessionalEntity(
            String address,
            Date birthday,
            boolean civility,
            String first_name,
            String last_name,
            String login,
            String mail,
            String password,
            String phone,
            String siret,
            String siren,
            String h_o_address
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
        
        this.siret = siret;
        this.siren = siren;
        this.head_office_address = h_o_address;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getSiren() {
        return siren;
    }

    public void setSiren(String siren) {
        this.siren = siren;
    }

<<<<<<< HEAD
    public String getHead_office_address() {
        return head_office_address;
    }

    public void setHead_office_address(String head_office_address) {
=======
    public String getHeadOfficeAddress() {
        return head_office_address;
    }

    public void setHeadOfficeAddress(String head_office_address) {
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
        this.head_office_address = head_office_address;
    }
}
