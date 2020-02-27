/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author lucqu
 */
public interface UserDAO {
    /**
     * Save an object in database
     * @param entity
     */
    public void save(UserEntity entity);
    
    /**
     * Update the a object in the database 
     * @param entity
     */
    public void update(UserEntity entity);
    
    /**
     * Delete the entity from the database
     * @param entity 
     */
    public void delete(UserEntity entity);
    
    /**
     * Find an element with its primary key
     * @param id
     * @return T
     */
    UserEntity find(long id);
    
    /**
     * Return all the T entities in the databse
     * @return List
     */
    List<UserEntity> findAll();
}
