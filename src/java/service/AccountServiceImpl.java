/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.entity.AccountEntity;
import dao.repository.AccountDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Charles
 */
@Service
public class AccountServiceImpl implements AccountService {
    
    @Autowired
    AccountDAO dao;

    @Override
    public AccountEntity find(String id) {
         return dao.find(Long.parseLong(id));
    }

    @Override
    public AccountEntity findByNumber(String account_number) {
         return dao.findByNumber(account_number);
    }
    
    @Override
    public List<AccountEntity> findAll(){
        return new ArrayList<>();
    }
    
    @Override
    public void save(AccountEntity entity){
        entity.setCreatedAt(new Date());
        dao.save(entity);
    }
    
    @Override
    public void update(AccountEntity entity){
        entity.setUpdatedAt(new Date());
        dao.update(entity);
    }
    
    @Override
    public void delete(AccountEntity entity){
        dao.delete(entity);
    }
    
}
