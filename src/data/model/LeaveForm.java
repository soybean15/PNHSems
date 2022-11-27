/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author root
 */
public class LeaveForm {
    private int id;
    private Employee employee;
    private List<ServiceCredit> serviceCredit;
    private java.sql.Date dateFiled;
    private java.sql.Date inclusiveDate_start;
     private java.sql.Date inclusiveDate_end;
    private LeaveType leaveType;
    private String details;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<ServiceCredit> getServiceCredit() {
        return serviceCredit;
    }

    public void setServiceCredit(List<ServiceCredit> serviceCredit) {
        this.serviceCredit = serviceCredit;
    }

    public Date getDateFiled() {
        return dateFiled;
    }

    public void setDateFiled(Date dateFiled) {
        this.dateFiled = dateFiled;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
    
    
}
