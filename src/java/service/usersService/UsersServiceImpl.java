/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.usersService;


import entity.User;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author clepaire
 */
@Service
public class UsersServiceImpl implements UsersService{
    
    private ArrayList<User> users;
   
    @Override
    public User getUser(int id){
        if(this.users.contains(id)){
            return this.users.get(id);
        }
        return null;
    }
    
    @Override
    public void addUser(User user){
        if(this.users.contains(user)){
            System.out.println("déjà dans la liste");
        }else{
            this.users.add(user);
        }
    }
    
    @Override
    public void removeUser(User user){
        if(this.users.contains(user)){
            this.users.remove(user);
        }else{
            System.out.println("User pas existant");
        }
    }
    
    @Override
    public String showUser(User user){
        if(this.users.contains(user)){
            return this.users.get(user.getId()).toString();
        }
        return "User not find";
    }
    
    @Override
    public void updateUser(User user){
        if(this.users.contains(user)){
            this.users.get(user.getId());
        }
    }
}
