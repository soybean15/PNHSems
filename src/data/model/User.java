package data.model;

import data.controllers.form.UserValidation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author root
 */
public class User {

    private String name;
    private String userName;
    private String role;
    private String email;
    private String password;
    private boolean enable;

    public User(String name, String userName, String email, String password,boolean enable) {

        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
          this.enable = enable;
    }

    public User(String name, String userName, String email,boolean enable,String role) {
        this.role = role;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.enable = enable;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    

    
    public boolean isEnable() {
        return enable;
    }
     public User(){}

    public User(String name, String userName, String email) {

        this.name = name;
        this.userName = userName;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getRole() {
        return role;
    }
    
    public boolean checkPasswordOnUpdate(){
        return UserValidation.checkField(password)==null;
    }
    

}
