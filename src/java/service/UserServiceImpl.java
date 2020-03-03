/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.entity.UserEntity;
import dao.repository.UserDAO;
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
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDAO dao;

    @Override
    public UserEntity find(String id) {
         return dao.find(Long.parseLong(id));
    }

    @Override
    public UserEntity findByLoginPassword(String login, String password) {
         return dao.findByLoginPassword(login, password);
    }
    
    @Override
    public List<UserEntity> findAll(){
        return new ArrayList<>();
    }
    
    @Override
    public void save(UserEntity entity){
        entity.setCreatedAt(new Date());
        dao.save(entity);
    }
    
    @Override
    public void update(UserEntity entity){
        entity.setUpdatedAt(new Date());
        dao.update(entity);
    }
    
    @Override
    public void delete(UserEntity entity){
        dao.delete(entity);
    }
    
}
