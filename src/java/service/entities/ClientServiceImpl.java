package service.entities;

import dao.entity.ClientEntity;
import dao.repository.ClientDAO;
import java.util.ArrayList;
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

    @Override
    public ClientEntity find(String id) {
         return this.dao.find(Long.parseLong(id));
    }
    
    @Override
    public List<ClientEntity> findAll(){
        return this.dao.findAll();
    }
    
    @Override
    public void save(ClientEntity entity){
        entity.setCreatedAt(new Date());
        this.dao.save(entity);
    }
    
    @Override
    public void update(ClientEntity entity){
        entity.setUpdatedAt(new Date());
        this.dao.update(entity);
    }
    
    @Override
    public void delete(ClientEntity entity){
        this.dao.delete(entity);
    }
    
}
