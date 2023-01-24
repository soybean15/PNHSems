/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model;

/**
 *
 * @author root
 */
public class Personnel {
    
    private int id;
    private String title;
    private String employeeId;
    
    public Personnel(){}

    public Personnel(int id, String title, String employeeId) {
        this.id = id;
        this.title = title;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    
    
    
    
    
}
