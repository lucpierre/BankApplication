package dao.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lucqu
 */
@Entity
@NamedQueries({
    @NamedQuery(
        name = "find_by_sender",
        query = "SELECT m FROM MessageEntity m WHERE m.sender = :sender"
    ),
    @NamedQuery(
        name = "find_by_sender_and_recipient",
        query = "SELECT m FROM MessageEntity m WHERE m.sender = :sender AND m.recipient = :recipient"
    )
})
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String content;
    
    @Column
    private boolean unread;
    
    @ManyToOne
    @JoinColumn(name="sender_fk")
    private UserEntity sender;
    
    @ManyToOne
    @JoinColumn(name="recipient_fk")
    private UserEntity recipient;
    
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date created_at;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date updated_at;
    
    //////////////////////////
    // Generated methods   //
    ////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof MessageEntity)) {
            return false;
        }
        MessageEntity other = (MessageEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.entity.MessageEntity[ id=" + id + " ]";
    }
    
    //////////////////////////
    // Methods             //
    ////////////////////////
    
    /**
     * Empty constructor to be sure an entity will not break the database
     */
    public MessageEntity() {}
    
    /**
     * Constructor with no sender and receiver
     * @param content 
     */
    public MessageEntity(String content){
        this.content = content;
        this.unread = true;
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    /**
     * Get the content of te message
     * @return String
     */
    public String getContent() {
        return content;
    }

    /**
     * Set the content of the message
     * @param content 
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Getter on the unread field
     * @return boolean
     */
    public boolean getUnread() {
        return unread;
    }

    /**
     * Setter on the unread field
     * @param unread 
     */
    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    /**
     * Get the sender of the message
     * @return UserEntity
     */
    public UserEntity getSender() {
        return sender;
    }

    /**
     * Setter on the sender of the message
     * @param sender 
     */
    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    /**
     * Getter on the recipient of the message
     * @return USerEntity
     */
    public UserEntity getRecipient() {
        return recipient;
    }

    /**
     * Setter on the recipient of the message
     * @param recipient 
     */
    public void setRecipient(UserEntity recipient) {
        this.recipient = recipient;
    }

    /**
     * Getter on the creation date
     * @return Date
     */
    public Date getCreatedAt() {
        return created_at;
    }

    /**
     * Setter on the creation date
     * @param created_at 
     */
    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    /**
     * Getter on the update date
     * @return Date
     */
    public Date getUpdatedAt() {
        return updated_at;
    }

    /**
     * Setter on the update date
     * @param updated_at 
     */
    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }
    
    
    
}
