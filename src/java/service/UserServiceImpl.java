/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.entity.UserEntity;
import dao.repository.UserDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucqu
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDAO dao;

    @Override
    public UserEntity find(String num_client, String password) {
         return dao.find(Long.parseLong(num_client));
    }
    
    /*
    @Override
    public List<UserEntity> findAll(){
        return new ArrayList<>();
    }
    
    @Override
    public void save(UserEntity u){
        dao.save(u);
    }
    
    @Override
    public void update(UserEntity entity){
        dao.update(entity);
    }
    
    @Override
    public void delete(UserEntity entity){
        dao.delete(entity);
    }
    */
    
}
