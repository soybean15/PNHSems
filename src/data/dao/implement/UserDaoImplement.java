/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dao.implement;

import data.controllers.form.LeaveFormValidation;
import data.controllers.form.UserValidation;
import data.database.DbConnection;
import data.dao.UserDao;
import data.model.User;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class UserDaoImplement implements UserDao {

    Connection conn = DbConnection.getConnection();

    @Override
    public int add(User user) throws SQLException {

        String query = "insert into users(username, password,email,name ) VALUES (?, ?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getName());
       
        return ps.executeUpdate();
    }

    @Override
    public int update(User user) throws SQLException {
       String query = "update users set  password =?, name=?, email =?, isenable=?, role=?, updated_at = CURRENT_TIMESTAMP where username =?";
        PreparedStatement ps = conn.prepareStatement(query);
       
          System.out.println("from dao "+user.getUserName());
        System.out.println("from dao "+user.getPassword());
      
        ps.setString(1, user.getPassword());
        ps.setString(2, user.getName());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.isEnable()?"true":"false");
         ps.setString(5, user.getRole());
        ps.setString(6, user.getUserName());
       
       
       
        
       return ps.executeUpdate();
    }

    @Override
    public int delete(User user) throws SQLException {
       String query = "delete from users where username =?";
       PreparedStatement ps =  conn.prepareStatement(query);
       
       ps.setString(1, user.getUserName());
       
       return ps.executeUpdate();
    }

    @Override
    public User getUser() throws SQLException {
       // String query
       return null;
    }

    @Override
    public List<User> getUsers() throws SQLException {
       List<User> users = new ArrayList<>();
       String query = "Select * from users where role != 'superadmin'";
       PreparedStatement pst = conn.prepareStatement(query);
       ResultSet rs = pst.executeQuery();
       
      while(rs.next()){
          String name = rs.getString("name");
          String username = rs.getString("username");
          String email = rs.getString("email");
           String password = rs.getString("password");
          boolean enable= rs.getString("isenable").equals("true");
         
         
          User user = new User(name, username, email,password,enable);
          users.add(user);
      }
       return users;
    }

    @Override
    public User getUser(String username, String password) throws SQLException {
        String query = "Select * from users where binary username = ? and binary password =?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            String name = rs.getString("name");
            String user_name = rs.getString("username");
            String email = rs.getString("email");
            boolean isEnable = rs.getString("isenable").equals("true");
            String role = rs.getString("role");

            return new User(name, user_name, email,isEnable,role);
        }

        return null;

    }

    @Override
    public boolean checkUserName(String username) throws SQLException {
       String query = "Select * from users where username=?";
       
       PreparedStatement pst = conn.prepareStatement(query);
       pst.setString(1, username);
       ResultSet rs = pst.executeQuery();
       
       return (rs.next());
           
       
    }

    @Override
    public boolean checkEmail(String email) throws SQLException {
        String query = "Select * from users where email=?";
       
       PreparedStatement pst = conn.prepareStatement(query);
       pst.setString(1, email);
       ResultSet rs = pst.executeQuery();
       
       return (rs.next());
           
    }
    
    public void createSuperAdmin(String username)throws SQLException{
        String query ="update users set role ='superadmin', isenable ='true' where username = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, username);
        
        pst.executeUpdate();
        
    }

   
}
