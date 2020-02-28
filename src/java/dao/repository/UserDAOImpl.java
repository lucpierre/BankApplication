/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.repository;

import dao.entity.UserEntity;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lucqu
 */
@Repository
public class UserDAOImpl extends GenericDAOImpl<UserEntity> implements UserDAO {
    
    public UserDAOImpl(){
        super(UserEntity.class);
    }
    
    @Transactional
    @Override
    public UserEntity findByLoginPassword(String login, String password) {
        Query query = this.getEm().createQuery(
                "SELECT user "
                + "FROM UserEntity user "
                + "WHERE user.login = :login AND user.password = :password"
        );
        
        query.setParameter("login", login);
        query.setParameter("password", password);
        try {
            return (UserEntity) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
