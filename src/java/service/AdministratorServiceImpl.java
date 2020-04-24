package service;

import dao.entity.AdministratorEntity;
import dao.repository.AdministratorDAO;
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

    @Override
    public AdministratorEntity find(String id) {
         return this.dao.find(Long.parseLong(id));
    }
    
    @Override
    public List<AdministratorEntity> findAll(){
        return this.dao.findAll();
    }
    
    @Override
    public void save(AdministratorEntity entity){
        entity.setCreatedAt(new Date());
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
