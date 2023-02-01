/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.controllers;

import data.model.User;
import data.dao.implement.UserDaoImplement;
import java.sql.SQLException;
import java.util.List;
import pnhsems.InvalidInputException;

/**
 *
 * @author root
 */
public class UserController {
    private final UserDaoImplement userDao = new UserDaoImplement();
    private static User user;
    
    public User login(String username, String password) throws SQLException, InvalidInputException {
        user = userDao.getUser(username, password);

        if (user != null) {
            if (!user.isEnable()) {
                throw new InvalidInputException("You account has been disabled, please contact your Administrator");

            }
        }

        return user;
    }
    
    public static User getUser(){
       
        return user;
    }
    
    
    
    public boolean checkUserName(String username) throws SQLException{
        return userDao.checkUserName(username);
     }
    
    public boolean checkEmail(String email) throws SQLException{
        return userDao.checkEmail(email);
     }
    
    public void addUser(User user)throws SQLException{
        userDao.add(user);
    }
    
    public void updateStatus(User user)throws SQLException{
        userDao.update(user);
    }
    
    public int updateUser(User user)throws SQLException{
         return userDao.update(user);
      
    }
    
    public void deleteUser(User user)throws SQLException{
        userDao.delete(user);
    }
    
    
    public List<User> getAllUsers()throws SQLException{
       return userDao.getUsers();
    }
    
    public boolean checkUser(String username, String password)throws SQLException{
        return userDao.getUser(username, password)!=null;
    }
    
    
}
