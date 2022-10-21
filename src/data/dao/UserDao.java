/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dao;

import data.model.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public interface UserDao {

    public int add(User user)
            throws SQLException;

    public int update(User user)
            throws SQLException;

    public int delete(User user)
            throws SQLException;

    public User getUser(String username, String password)
            throws SQLException;

    public User getUser()
            throws SQLException;

    public List<User> getUsers()
            throws SQLException;

    public boolean checkUserName(String username)
            throws SQLException;

    public boolean checkEmail(String email)
            throws SQLException;
    


}
