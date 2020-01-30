/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
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
public class GenericDaoImpl implements GenericDao {
    
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
    @Transactional
    public void save(Object entity) {
        entity = em.merge(entity);
        em.persist(entity);
    }

    @Override
    @Transactional
    public void update(Object entity) {
        em.merge(entity);
    }

    @Override
    @Transactional
    public void delete(Object entity) {
        entity = em.merge(entity);
        em.remove(entity);
    }

    @Override
    public Object find(Serializable primary_key) {
        return em.find(Object.class, primary_key);
    }

    @Override
    public List findAll(){
        return new ArrayList<>();
    };
    
}
