package service.entities;

import dao.entity.ClientEntity;
import dao.entity.UserEntity;
import dao.repository.ClientDAO;
import dao.repository.UserDAO;
import exceptions.LoginAlreadyUsedException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucqu
 */
@Service
public class ClientServiceImpl implements ClientService {
    
    @Autowired
    ClientDAO dao;
    
    @Autowired
    UserDAO user_dao;

    @Override
    public ClientEntity find(String id) {
         return this.dao.find(Long.parseLong(id));
    }
    
    @Override
    public List<ClientEntity> findAll(){
        return this.dao.findAll();
    }
    
    @Override
    public void save(ClientEntity entity) throws LoginAlreadyUsedException{
        UserEntity user = this.user_dao.findByLogin(entity.getLogin());
        if(null != user){
            throw new LoginAlreadyUsedException();
        }
        
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        this.dao.save(entity);
    }
    
    @Override
    public void update(ClientEntity entity) throws LoginAlreadyUsedException {
        UserEntity user = this.user_dao.findByLogin(entity.getLogin());
        if(null != user){
            throw new LoginAlreadyUsedException();
        }
        
        entity.setUpdatedAt(new Date());
        this.dao.update(entity);
    }
    
    @Override
    public void delete(ClientEntity entity){
        this.dao.delete(entity);
    }
    
}
