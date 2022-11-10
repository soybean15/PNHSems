/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model;


/**
 *
 * @author root
 */
public class EmployeeServiceCredit {
   private  String employeeId;
   private ServiceCredit serviceCredit;
    private int no_of_days;

    
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public ServiceCredit  getServiceCredit() {
        return serviceCredit;
    }

    public void setServiceCredits(ServiceCredit serviceCredit) {
        this.serviceCredit = serviceCredit;
    }

    public int getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_days(int no_of_days) {
        this.no_of_days = no_of_days;
    }
    
    
    
}
