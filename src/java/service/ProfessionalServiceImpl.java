package service;

import dao.entity.ProfessionalEntity;
import dao.repository.ProfessionalDAO;
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

    @Override
    public ProfessionalEntity find(String id) {
         return this.dao.find(Long.parseLong(id));
    }
    
    @Override
    public List<ProfessionalEntity> findAll(){
        return this.dao.findAll();
    }
    
    @Override
    public void save(ProfessionalEntity entity){
        entity.setCreatedAt(new Date());
        this.dao.save(entity);
    }
    
    @Override
    public void update(ProfessionalEntity entity){
        entity.setUpdatedAt(new Date());
        this.dao.update(entity);
    }
    
    @Override
    public void delete(ProfessionalEntity entity){
        this.dao.delete(entity);
    }
}
