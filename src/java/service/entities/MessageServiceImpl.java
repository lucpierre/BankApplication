package service.entities;

import dao.entity.MessageEntity;
import dao.entity.UserEntity;
import dao.repository.MessageDAO;
import exceptions.SenderOrRecieverMessageException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lucqu
 */
public class MessageServiceImpl implements MessageService{
    @Autowired
    MessageDAO dao;

    /**
     * Find a message with it's id
     * @param id
     * @return 
     */
    @Override
    public MessageEntity find(String id) {
         return dao.find(Long.parseLong(id));
    }
    
    /**
     * Find all the messages
     * @return 
     */
    @Override
    public List<MessageEntity> findAll(){
        return dao.findAll();
    }
    
    /**
     * Save a new message in database, check if the sender and the receiver are set.
     * @param entity
     * @throws SenderOrRecieverMessageException 
     */
    @Override
    public void save(MessageEntity entity) throws SenderOrRecieverMessageException {
        if(null == entity.getSender() || null == entity.getRecipient()){
            throw new SenderOrRecieverMessageException();
        }
        
        entity.setCreatedAt(new Date());
        dao.save(entity);
    }
    
    /**
     * Update a message in database, check if the sender and the receiver are set.
     * @param entity
     * @throws SenderOrRecieverMessageException 
     */
    @Override
    public void update(MessageEntity entity) throws SenderOrRecieverMessageException {
        if(null == entity.getSender() || null == entity.getRecipient()){
            throw new SenderOrRecieverMessageException();
        }
        
        entity.setUpdatedAt(new Date());
        dao.update(entity);
    }
    
    /**
     * Delete a message from the databes
     * @param entity 
     */
    @Override
    public void delete(MessageEntity entity){
        dao.delete(entity);
    }
    
    /**
     * Retrieves the list of messages where the sender corresponds to the one passed in parameter.
     * @param sender
     * @return MessageEntity list
     */
    @Override
    public List<MessageEntity> findBySender(UserEntity sender){
        return dao.findBySender(sender);
    }
    
    /**
     * Retrieves the list of messages where the sender and the recipient correspond to the ones passed in parameter.
     * @param sender
     * @param recipient
     * @return MessageEntity list
     */
    @Override
    public List<MessageEntity> findBySenderAndRecipient(UserEntity sender, UserEntity recipient){
        return dao.findBySenderAndRecipient(sender, recipient);
    }
}
