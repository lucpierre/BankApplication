/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lucqu
 */
@Repository
public class UserDAOImpl implements UserDAO {
     /*
    Get the entity manager
    */
    
    @PersistenceContext(unitName="BankPU")
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }
    
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    /*
    Implementation of the GenericDao methods
    */

    @Override
    public List findAll(){
        return new ArrayList<>();
    };

    @Override
    public void save(UserEntity entity) {
        entity = em.merge(entity);
        em.persist(entity);
    }

    @Override
    public void update(UserEntity entity) {
        em.merge(entity);
    }

    @Override
    public void delete(UserEntity entity) {
        entity = em.merge(entity);
        em.remove(entity);
    }
    
    @Transactional
    @Override
    public UserEntity find(long id) {
        UserEntity u = em.find(UserEntity.class, id);
        return u;
    }
}
