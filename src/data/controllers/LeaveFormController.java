/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.controllers;

import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.LeaveForm;
import data.model.LeaveType;
import data.model.Personnel;
import java.sql.SQLException;
import data.services.impl.LeaveFormService;
import java.sql.Date;
import java.util.List;
import pnhsems.InvalidInputException;

/**
 *
 * @author root
 */
public class LeaveFormController {

    LeaveFormService service = new LeaveFormService();
    
    public String generateRefNum(Employee employee) throws SQLException{
        return service.generateReferenceNumber( );
    }

    public int addLeaveType(LeaveType leaveType) throws SQLException {
        return service.addLeaveType(leaveType);
    }

    public List<LeaveType> getLeaveTypes() throws SQLException {
        return service.getAllLeaveTypes();
    }

    public List<EmployeeServiceCredit> getEmployeeServiceCredits(String employeeId) throws SQLException {
        return service.getEmployeeServiceCredits(employeeId);
    }

    public List<EmployeeServiceCredit> getAvailableLeaveFormServiceCredits(List<EmployeeServiceCredit> items, List<EmployeeServiceCredit> itemsToRemove) {

        return service.getAvailableLeaveFormServiceCredits(items, itemsToRemove);
    }

    public EmployeeServiceCredit getEmployeeServiceCredit(String employeeId, int serviceCreditId) throws SQLException {
        return service.getEmployeeServiceCredit(employeeId, serviceCreditId);
    }

    public int addLeave(LeaveForm leaveForm) throws SQLException, InvalidInputException {
        return service.addLeave(leaveForm);
    }
    
    public List<LeaveForm> getLeaveLogs(Employee employee)throws SQLException{
        
    
        return service.getLeaveLogs(employee);
    }
    
     public List<LeaveForm> getLeaveLogServiceCreditbyDate(Employee employee, Date date) throws SQLException {
         return service.getLeaveLogServiceCreditbyDate(employee, date);
     }
     
     
      public List<LeaveForm> searchByReferenceNumber(Employee employee,String refNum) throws SQLException {
          return service.searchByReferenceNumber(employee, refNum);
      }
      
      public int getLeaveCount(String id){
          try{
             return service.getLeaveCount(id);
          }catch(SQLException e){
              e.printStackTrace();
              return 0;
          }
      }
      
      public LeaveForm getRecet(Employee employee)throws SQLException {
          return service.getRecent(employee);
      }
      
      
      public List<Personnel> getPersonnels()throws SQLException {
          return service.getPersonnels();
      }
}
