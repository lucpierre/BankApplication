/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.entities;

import dao.entity.BankingEntity;
import dao.repository.BankingDAO;
import exceptions.BankingInvalidException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Charles
 */
@Service
public class BankingServiceImpl implements BankingService{
    @Autowired
    BankingDAO dao;

    /**
     * Find a banking with it's id
     * @param id
     * @return 
     */
    @Override
    public BankingEntity find(String id) {
         return dao.find(Long.parseLong(id));
    }
    
    /**
     * Find all banking
     * @return 
     */
    @Override
    public List<BankingEntity> findAll(){
        return dao.findAll();
    }

    /**
     * Save a new banking in database, check if the cost, the account and the reference are set.
     * @param bEntity
     * @throws BankingInvalidException 
     */
    @Override
    public void save(BankingEntity bEntity) throws BankingInvalidException {
        if(bEntity.getAccount() == null || bEntity.getCost() == null || bEntity.getReference() == null){
            throw new BankingInvalidException();
        }
        
        bEntity.setCreatedAt(new Date());
        dao.save(bEntity);
    }

    @Override
    public void update(BankingEntity bEntity) throws BankingInvalidException {
        if(bEntity.getAccount() == null || bEntity.getCost() == null || bEntity.getReference() == null){
            throw new BankingInvalidException();             
        }
        
        bEntity.setUpdatedAt(new Date());
        dao.update(bEntity);
    }

    @Override
    public void delete(BankingEntity bEntity) {
        dao.delete(bEntity);
    }
    
}
