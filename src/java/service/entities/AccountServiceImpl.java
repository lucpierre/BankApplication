/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.entities;

import dao.entity.AccountEntity;
import dao.repository.AccountDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
        return new ArrayList<>(dao.findAll());
    }
    
    @Override
    public void save(AccountEntity entity){
        String account_number = this.genUniqueAccountNumber();
        System.out.println(account_number);
        entity.setAccountNumber(account_number);
        System.out.println(entity.getAccountNumber());
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
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
    
    /**
     * Return a random account number made by 11 characters between 0 and 9
     * 
     * @return String
     */
    private String genAccountNumber(){
        int left_limit = 48; // char '0'
        int right_limit = 57; // letter '9'
        int target_string_length = 11;
        Random random = new Random();

        String generated_string = random.ints(left_limit, right_limit + 1)
          .limit(target_string_length)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();

        return generated_string;
    }
    
    /**
     * Return a unique random account number made by 11 characters between 0 and 9
     * 
     * @return 
     */
    private String genUniqueAccountNumber(){
        String gen_account_number = this.genAccountNumber();
        AccountEntity account = this.findByNumber(gen_account_number);
        
        if(null != account){
            while(null != account){
                gen_account_number = this.genAccountNumber();
                account = this.findByNumber(gen_account_number);
            }
        }
        
        return gen_account_number;
    }
    
}
