package service.entities;

import dao.entity.AdministratorEntity;
import dao.entity.UserEntity;
import dao.repository.AdministratorDAO;
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
public class AdministratorServiceImpl implements AdministratorService {
    
    @Autowired
    AdministratorDAO dao;
    
    @Autowired
    UserDAO user_dao;

    @Override
    public AdministratorEntity find(String id) {
         return this.dao.find(Long.parseLong(id));
    }
    
    @Override
    public List<AdministratorEntity> findAll(){
        return this.dao.findAll();
    }
    
    @Override
    public void save(AdministratorEntity entity) throws LoginAlreadyUsedException{
        UserEntity user = this.user_dao.findByLogin(entity.getLogin());
        if(null != user){
            throw new LoginAlreadyUsedException();
        }
        
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        this.dao.save(entity);
    }
    
    @Override
    public void update(AdministratorEntity entity){
        entity.setUpdatedAt(new Date());
        this.dao.update(entity);
    }
    
    @Override
    public void delete(AdministratorEntity entity){
        this.dao.delete(entity);
    }
    
}
