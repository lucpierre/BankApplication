package service.entities;

import dao.entity.ProfessionalEntity;
import dao.entity.UserEntity;
import dao.repository.ProfessionalDAO;
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
public class ProfessionalServiceImpl implements ProfessionalService {
    
    @Autowired
    ProfessionalDAO dao;
    
    @Autowired
    UserDAO user_dao;

    @Override
    public ProfessionalEntity find(String id) {
         return this.dao.find(Long.parseLong(id));
    }
    
    @Override
    public List<ProfessionalEntity> findAll(){
        return this.dao.findAll();
    }
    
    @Override
    public void save(ProfessionalEntity entity) throws LoginAlreadyUsedException{
        UserEntity user = this.user_dao.findByLogin(entity.getLogin());
        if(null != user){
            throw new LoginAlreadyUsedException();
        }
        
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        this.dao.save(entity);
    }
    
    @Override
    public void update(ProfessionalEntity entity) throws LoginAlreadyUsedException{
        UserEntity user = this.user_dao.findByLogin(entity.getLogin());
        if(null != user){
            throw new LoginAlreadyUsedException();
        }
        
        entity.setUpdatedAt(new Date());
        this.dao.update(entity);
    }
    
    @Override
    public void delete(ProfessionalEntity entity){
        this.dao.delete(entity);
    }
}
