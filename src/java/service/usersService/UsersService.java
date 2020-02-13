/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.usersService;

import entity.User;

/**
 *
 * @author clepaire
 */
public interface UsersService {
   public User getUser(int id);
   
   public void addUser(User user);
   
   public void removeUser(User user);
   
   public String showUser(User user);
   
   public void updateUser(User user);
   
}
