/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class LeaveForm {
    private int id;
    private Employee employee;
    private List<EmployeeServiceCredit> serviceCredit = new ArrayList<>();
    private java.sql.Date dateFiled;
    private java.sql.Date inclusiveDate_start;
    private java.sql.Date inclusiveDate_end;
    private int creditUsed;
    private LeaveType leaveType;
    private String details;
    private java.sql.Timestamp created_at;

    
    
    public void addServicCredit(EmployeeServiceCredit employeeServiceCredit){
        serviceCredit.add(employeeServiceCredit);
    }
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

    public List<EmployeeServiceCredit> getServiceCredit() {
        return serviceCredit;
    }

    public void setServiceCredit(List<EmployeeServiceCredit> serviceCredit) {
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

    public Date getInclusiveDate_start() {
        return inclusiveDate_start;
    }

    public void setInclusiveDate_start(Date inclusiveDate_start) {
        this.inclusiveDate_start = inclusiveDate_start;
    }

    public Date getInclusiveDate_end() {
        return inclusiveDate_end;
    }

    public void setInclusiveDate_end(Date inclusiveDate_end) {
        this.inclusiveDate_end = inclusiveDate_end;
    }

    public int getCreditUsed() {
        return creditUsed;
    }

    public void setCreditUsed(int creditUsed) {
        this.creditUsed = creditUsed;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }
    
    
    public boolean validate(){
  
          return details!=null;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    
    
    
    
}
