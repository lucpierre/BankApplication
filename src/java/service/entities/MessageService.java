package service.entities;

import dao.entity.MessageEntity;
import dao.entity.UserEntity;
import exceptions.SenderOrRecieverMessageException;
import java.util.List;

/**
 *
 * @author lucqu
 */
public interface MessageService {
    public MessageEntity find(String id);
    public List<MessageEntity> findAll();
    public void save(MessageEntity u) throws SenderOrRecieverMessageException;
    public void update(MessageEntity entity) throws SenderOrRecieverMessageException;
    public void delete(MessageEntity entity);
    public List<MessageEntity> findBySender(UserEntity sender);
    public List<MessageEntity> findBySenderAndRecipient(UserEntity sender, UserEntity recipient);
<<<<<<< HEAD
=======
    public List<MessageEntity> findChat(UserEntity first_user, UserEntity second_user);
>>>>>>> 663c91bac5a8142b92b99f06d205a7ecb5448c36
}
