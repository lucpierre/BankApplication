package dao.repository;

import dao.entity.MessageEntity;
import dao.entity.UserEntity;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lucqu
 */
@Repository
public class MessageDAOImpl extends GenericDAOImpl<MessageEntity> implements MessageDAO{
    public MessageDAOImpl(){
        super(MessageEntity.class);
    }

    /**
     * Retrieves the list of messages where the sender corresponds to the one passed in parameter.
     * @param sender
     * @return MessageEntity list
     */
    @Override
    @Transactional
    public List<MessageEntity> findBySender(UserEntity sender) {
        try {
            Query query = this.getEm().createNamedQuery("find_by_sender");
            query.setParameter("sender", sender);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Retrieves the list of messages where the sender and the recipient correspond to the ones passed in parameter.
     * @param sender
     * @param recipient
     * @return MessageEntity list
     */
    @Override
    @Transactional
    public List<MessageEntity> findBySenderAndRecipient(UserEntity sender, UserEntity recipient) {
        try {
            Query query = this.getEm().createNamedQuery("find_by_sender_and_recipient");
            query.setParameter("sender", sender);
            query.setParameter("recipient", sender);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
<<<<<<< HEAD
=======
    
    /**
     * Retrieves the list of messages between two users.
     * @param first_user
     * @param second_user
     * @return MessageEntity list
     */
    @Override
    @Transactional
    public List<MessageEntity> findChat(UserEntity first_user, UserEntity second_user){
        try {
            Query query = this.getEm().createNamedQuery("find_chat");
            query.setParameter("first_user", first_user);
            query.setParameter("second_user", second_user);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
>>>>>>> 663c91bac5a8142b92b99f06d205a7ecb5448c36
}
