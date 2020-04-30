/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.repository;

import dao.entity.UserEntity;
import java.security.NoSuchAlgorithmException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import service.PasswordService;

/**
 *
 * @author lucqu
 */
@Repository
public class UserDAOImpl extends GenericDAOImpl<UserEntity> implements UserDAO {
    
    public UserDAOImpl(){
        super(UserEntity.class);
    }
    
    /**
     * Find a user with his login and password
     * 
     * @param login
     * @param password
     * @return UserEntity
     */
    @Override
    @Transactional
    public UserEntity findByLoginPassword(String login, String password) {
        try {
            Query query = this.getEm().createNamedQuery("find_by_login_password");
            String hashed_password = PasswordService.hashString(password);
            query.setParameter("login", login);
            query.setParameter("password", hashed_password);
            return (UserEntity)query.getSingleResult();
        } catch (NoResultException | NoSuchAlgorithmException e) {
            return null;
        }
    }
    
    /**
     * Find a user with his login
     * 
     * @param login
     * @return UserEntity
     */
    @Override
    @Transactional
    public UserEntity findByLogin(String login) {
        try {
            Query query = this.getEm().createNamedQuery("find_by_login");
            query.setParameter("login", login);
            return (UserEntity)query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    
}
