/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.io.Serializable;

/**
 *
 * @author lucqu
 * @param <T>
 * @param <PK>
 */
public interface GenericDao <T, PK extends Serializable>{
    
    /**
     * Save an object in database
     */
    public void save(T entity);
    
    /**
     * Update the a object in the database
     * @param a 
     */
    public void update(T entity);
    
    /**
     * Delete the entity from the database
     * @param entity 
     */
    public void delete(T entity);
    
    /**
     * Get the entity who has the primary_key
     * @param primary_key
     * @return 
     */
    public T find (PK primary_key);
    
    /**
     * Return all the T entities in the databse
     * @return List
     */
    List<T> findAll();
}
