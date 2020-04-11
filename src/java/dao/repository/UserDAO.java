/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.repository;

import dao.entity.UserEntity;

/**
 *
 * @author lucqu
 */
public interface UserDAO extends GenericDAO<UserEntity>{
    public UserEntity findByLoginPassword(String login, String password);
}
