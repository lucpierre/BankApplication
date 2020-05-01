package service.entities;

import dao.entity.AdvisorEntity;
import dao.entity.UserEntity;
import dao.repository.AdvisorDAO;
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
public class AdvisorServiceImpl implements AdvisorService {
    
    @Autowired
    AdvisorDAO dao;
    
    @Autowired
    UserDAO user_dao;

    @Override
    public AdvisorEntity find(String id) {
         return this.dao.find(Long.parseLong(id));
    }
    
    @Override
    public List<AdvisorEntity> findAll(){
        return this.dao.findAll();
    }
    
    @Override
    public void save(AdvisorEntity entity) throws LoginAlreadyUsedException{
        UserEntity user = this.user_dao.findByLogin(entity.getLogin());
        if(null != user){
            throw new LoginAlreadyUsedException();
        }
        
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        this.dao.save(entity);
    }
    
    @Override
    public void update(AdvisorEntity entity) throws LoginAlreadyUsedException{
        UserEntity user = this.user_dao.findByLogin(entity.getLogin());
        if(null != user){
            throw new LoginAlreadyUsedException();
        }
        
        entity.setUpdatedAt(new Date());
        this.dao.update(entity);
    }
    
    @Override
    public void delete(AdvisorEntity entity){
        this.dao.delete(entity);
    }
    
}
