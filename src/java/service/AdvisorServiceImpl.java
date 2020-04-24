package service;

import dao.entity.AdvisorEntity;
import dao.repository.AdvisorDAO;
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

    @Override
    public AdvisorEntity find(String id) {
         return this.dao.find(Long.parseLong(id));
    }
    
    @Override
    public List<AdvisorEntity> findAll(){
        return this.dao.findAll();
    }
    
    @Override
    public void save(AdvisorEntity entity){
        entity.setCreatedAt(new Date());
        this.dao.save(entity);
    }
    
    @Override
    public void update(AdvisorEntity entity){
        entity.setUpdatedAt(new Date());
        this.dao.update(entity);
    }
    
    @Override
    public void delete(AdvisorEntity entity){
        this.dao.delete(entity);
    }
    
}
