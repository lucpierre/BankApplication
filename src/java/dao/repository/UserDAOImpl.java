/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.repository;

import dao.entity.UserEntity;
<<<<<<< HEAD
=======
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD
=======
import service.PasswordService;
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b

/**
 *
 * @author lucqu
 */
@Repository
public class UserDAOImpl extends GenericDAOImpl<UserEntity> implements UserDAO {
    
    public UserDAOImpl(){
        super(UserEntity.class);
    }
    
    @Override
    @Transactional
    public UserEntity findByLoginPassword(String login, String password) {
<<<<<<< HEAD
        Query query = this.getEm().createNamedQuery("find_by_login_password");
        
        query.setParameter("login", login);
        query.setParameter("password", password);
        try {
            return (UserEntity)query.getSingleResult();
        } catch (NoResultException e) {
=======
        try {
            Query query = this.getEm().createNamedQuery("find_by_login_password");
            String hashed_password = PasswordService.hashString(password);
            System.out.println(hashed_password);
            query.setParameter("login", login);
            query.setParameter("password", hashed_password);
            return (UserEntity)query.getSingleResult();
        } catch (NoResultException | NoSuchAlgorithmException e) {
>>>>>>> d16e95e926435aa011121ce5652b8dc5f0e1266b
            return null;
        }
    }
}
