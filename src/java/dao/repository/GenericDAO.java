/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.repository;

import java.util.List;
import java.io.Serializable;

/**
 *
 * @author lucqu
 * @param <T>
 */
public interface GenericDAO <T>{
    
    /**
     * Save an object in database
     * @param entity
     */
    //public void save(T entity);
    
    /**
     * Update the a object in the database 
     * @param entity
     */
    //public void update(T entity);
    
    /**
     * Delete the entity from the database
     * @param entity 
     */
    //public void delete(T entity);
    
    /**
     * Find an element with its primary key
     * @param id
     * @return T
     */
    T find(Object id);
    
    /**
     * Return all the T entities in the databse
     * @return List
     */
    //List<T> findAll();
}
