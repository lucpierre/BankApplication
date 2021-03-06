package dao.entity;

import exceptions.UnknowCivilityException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import service.PasswordService;

/**
 *
 * @author lucqu
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="UserEntity")
@DiscriminatorColumn(name="usertype", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("UserEntity")

@NamedQueries({
    @NamedQuery(
        name = "find_by_login_password",
        query = "SELECT u FROM UserEntity u WHERE u.login = :login AND u.password = :password"
    ),
    @NamedQuery(
        name = "find_by_login",
        query = "SELECT u FROM UserEntity u WHERE u.login = :login"
    )
})

public class UserEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static String CIVILITY_MR = "Mr";
    public static String CIVILITY_MME = "Mme";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true)
    private String login;
    
    @Column
    private String password;
    
    @Column
    private String mail;
    
    @Column
    private String phone;
    
    @Column
    private String first_name;
    
    @Column
    private String last_name;

    @Column
    private String address;
    
    @Column
    private String civility;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date created_at;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date updated_at;
    
    @OneToMany(mappedBy="sender")
    private List<MessageEntity> sended_messages;
    
    @OneToMany(mappedBy="recipient")
    private List<MessageEntity> recieved_messages;
    

    //////////////////////////
    // Generated methods   //
    ////////////////////////
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = this.id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.entities.UserEntity[ id=" + id + " ]";
    }
    
    //////////////////////////
    // Methods             //
    ////////////////////////
    
    // Constructeur par défaut utilisé pour le debug à supprimer une fois les fixtures en places
    public UserEntity(){
        this.address = "address";
        this.birthday = new Date();
        this.civility = "Mr";
        this.created_at = new Date();
        this.first_name = "first_name";
        this.last_name = "last_name";
        this.login = "login";
        this.mail = "mail";
        this.password = "password";
        this.phone = "0011223344";
        this.updated_at = new Date();
        this.sended_messages = new ArrayList<>();
        this.recieved_messages = new ArrayList<>();
    }
    
    public UserEntity(
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
        this.address = address;
        this.birthday = birthday;
        this.civility = (civility) ? UserEntity.CIVILITY_MR : UserEntity.CIVILITY_MME;
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.mail = mail;
        this.password = PasswordService.hashString(password);
        this.phone = phone;
        this.sended_messages = new ArrayList<>();
        this.recieved_messages = new ArrayList<>();
    }
    
    /**
     * Getter on login
     * @return String
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Setter on login
     * @param new_login
     */
    public void setLogin(String new_login) {
        this.login = new_login;
    }

    /**
     * Getter on the password
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter on the password
     * @param new_password String
     * @throws java.security.NoSuchAlgorithmException
     */
    public void setPassword(String new_password) throws NoSuchAlgorithmException {
        this.password = PasswordService.hashString(new_password);
    }

    /**
     * Getter on the mail
     * @return String
     */
    public String getMail() {
        return this.mail;
    }

    /**
     * Setter on the mail
     * @param new_mail String
     */
    public void setMail(String new_mail) {
        this.mail = new_mail;
    }

    /**
     * Getter on the phone
     * @return String
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Setter on the phone
     * @param new_phone
     */
    public void setPhone(String new_phone) {
        this.phone = new_phone;
    }

    /**
     * Getter on the first name
     * @return String
     */
    public String getFirstName() {
        return this.first_name;
    }

    /**
     * Setter on the first name
     * @param new_name String
     */
    public void setFirstName(String new_name) {
        this.first_name = new_name;
    }

    /**
     * Getter on the last name
     * @return String
     */
    public String getLastName() {
        return this.last_name;
    }

    /**
     * Setter on the last name
     * @param new_name String
     */
    public void setLastName(String new_name) {
        this.last_name = new_name;
    }

    /**
     * Getter on the address
     * @return String
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Setter on the address
     * @param new_address
     */
    public void setAddress(String new_address) {
        this.address = new_address;
    }

    /**
     * Getter on the civility
     * @return String
     */
    public String getCivility() {
        return this.civility;
    }
    
    /**
     * Setter on the civility
     * @param new_civility
     * @throws exceptions.UnknowCivilityException
     */
    public void setCivility(String new_civility) throws UnknowCivilityException {
        if(new_civility.equals(UserEntity.CIVILITY_MR) || new_civility.equals(UserEntity.CIVILITY_MME)){
            this.civility = new_civility;
        }
        else{
            throw new UnknowCivilityException();
        }
    }

    /**
     * Get on the birthday
     * @return Date
     */
    public Date getBirthday() {
        return this.birthday;
    }
    
    /**
     * Setter on the birthday
     * @param new_date Date
     */
    public void setBirthday(Date new_date) {
        this.birthday = new_date;
    }
    
    /**
     * Setter on the birthday with a String
     * @param new_date String
     * @throws java.text.ParseException
     */
    public void setBirthday(String new_date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        this.birthday = formatter.parse(new_date);
    }
    
    /**
     * Get on the birthday
     * @return String
     */
    public String getFormattedBirthday() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(this.birthday);
    }

    /**
     * Getter on the created_at
     * @return Date
     */
    public Date getCreatedAt() {
        return this.created_at;
    }
    
    /**
     * Setter on the created_at
     * @param new_date Date
     */
    public void setCreatedAt(Date new_date) {
        this.created_at = new_date;
    }

    /**
     * Getter on the updated_at
     * @return Date
     */
    public Date getUpdatedAt() {
        return this.updated_at;
    }

    /**
     * Setter on the updated_at
     * @param new_date Date
     */
    public void setUpdatedAt(Date new_date) {
        this.updated_at = new_date;
    }

    /**
     * Getter on the list of the sended messages
     * @return the list of the sended messages
     */
    public List<MessageEntity> getSendedMessages() {
        return sended_messages;
    }

    /**
     * Set the list of the sended messages
     * @param new_sended_messages 
     */
    public void setSendedMessages(List<MessageEntity> new_sended_messages) {
        this.sended_messages = new_sended_messages;
    }
    
    /**
     * Add a message to the sended messages list
     * @param new_message 
     */
    public void addSendedMessage(MessageEntity new_message){
        if(!this.sended_messages.contains(new_message)){
            this.sended_messages.add(new_message);
            new_message.setSender(this);
        }
    }
    
    /**
     * Remove a message from the sended messages list
     * @param message 
     */
    public void removeSendedMessage(MessageEntity message){
        if(this.sended_messages.contains(message)){
            this.sended_messages.remove(message);
            message.setSender(null);
        }
    }

    /**
     * Get the list of the received messages
     * @return the list of the received messages
     */
    public List<MessageEntity> getRecievedMessages() {
        return recieved_messages;
    }

    /**
     * Set the list of the received messages
     * @param new_recieved_messages 
     */
    public void setRecievedMessages(List<MessageEntity> new_recieved_messages) {
        this.recieved_messages = new_recieved_messages;
    }
    
    /**
     * Add a message to the received messages list
     * @param new_message 
     */
    public void addReceivedMessage(MessageEntity new_message){
        if(!this.recieved_messages.contains(new_message)){
            this.recieved_messages.add(new_message);
            new_message.setRecipient(this);
        }
    }
    
    /**
     * Remove a message from the received messages list
     * @param message 
     */
    public void removeReceivedMessage(MessageEntity message){
        if(this.recieved_messages.contains(message)){
            this.recieved_messages.remove(message);
            message.setRecipient(null);
        }
    }
        
    /**
     * Return the type of the user
     * @return 
     */
    public String getUserType(){
        if (this instanceof ProfessionalEntity){
            return "ProfessionalEntity";
        }
        else if(this instanceof ClientEntity){
            return "ClientEntity";
        }
        else if(this instanceof AdministratorEntity){
            return "AdministratorEntity";
        }
        else{
            return "AdvisorEntity";
        }
    }
    
}
