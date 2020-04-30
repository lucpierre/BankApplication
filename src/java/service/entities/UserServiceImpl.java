package service.entities;

import dao.entity.UserEntity;
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
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDAO dao;

    @Override
    public UserEntity find(String id) {
         return dao.find(Long.parseLong(id));
    }

    @Override
    public UserEntity findByLoginPassword(String login, String password) {
         return dao.findByLoginPassword(login, password);
    }
    
    @Override
    public List<UserEntity> findAll(){
        return dao.findAll();
    }
    
    @Override
    public void save(UserEntity entity) throws LoginAlreadyUsedException {
        UserEntity user = this.dao.findByLogin(entity.getLogin());
        if(null != user){
            throw new LoginAlreadyUsedException();
        }
        
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        dao.save(entity);
    }
    
    @Override
    public void update(UserEntity entity) throws LoginAlreadyUsedException{
        UserEntity user = this.dao.findByLogin(entity.getLogin());
        if(null != user){
            throw new LoginAlreadyUsedException();
        }
        
        entity.setUpdatedAt(new Date());
        dao.update(entity);
    }
    
    @Override
    public void delete(UserEntity entity){
        dao.delete(entity);
    }
    
}
