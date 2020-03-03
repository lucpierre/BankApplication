/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.entity.UserEntity;
import java.util.List;

/**
 *
 * @author lucqu
 */
public interface UserService {
    public UserEntity find(String id);
    public UserEntity findByLoginPassword(String login, String password);
    public List<UserEntity> findAll();
    public void save(UserEntity u);
    public void update(UserEntity entity);
    public void delete(UserEntity entity);
}
