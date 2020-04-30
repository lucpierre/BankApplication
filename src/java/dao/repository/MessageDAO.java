package dao.repository;

import dao.entity.MessageEntity;
import dao.entity.UserEntity;
import java.util.List;

/**
 *
 * @author lucqu
 */
public interface MessageDAO extends GenericDAO<MessageEntity>{
    public List<MessageEntity> findBySender(UserEntity sender);
    public List<MessageEntity> findBySenderAndRecipient(UserEntity sender, UserEntity recipient);
<<<<<<< HEAD
=======
    public List<MessageEntity> findChat(UserEntity first_user, UserEntity second_user);
>>>>>>> 663c91bac5a8142b92b99f06d205a7ecb5448c36
}