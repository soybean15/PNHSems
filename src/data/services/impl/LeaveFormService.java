/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.services.impl;

import data.dao.implement.LeaveDaoImplement;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.LeaveForm;
import data.model.LeaveType;
import data.model.Personnel;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pnhsems.InvalidInputException;

/**
 *
 * @author root
 */
public class LeaveFormService {

    LeaveDaoImplement leaveDao = new LeaveDaoImplement();
    PersonnelService personnelService =new PersonnelService();


    EmployeeAndServiceCreditService employeeAndServiceCreditService = new EmployeeAndServiceCreditService();

    public List<LeaveType> getAllLeaveTypes() throws SQLException {
        List<LeaveType> leavetypes = leaveDao.getAllLeaveTypes();
        return leavetypes;
    }

    public int addLeaveType(LeaveType leaveType) throws SQLException {
        return leaveDao.addLeaveType(leaveType);
    }

    public List<EmployeeServiceCredit> getEmployeeServiceCredits(String employeeId) throws SQLException {
        return employeeAndServiceCreditService.getEmployeeServiceCredits(employeeId);
    }

    public EmployeeServiceCredit getEmployeeServiceCredit(String employeeId, int serviceCreditId) throws SQLException {
        return employeeAndServiceCreditService.getEmployeeServiceCredit(employeeId, serviceCreditId);
    }

    
     public List<LeaveForm> getLeaveLogServiceCreditbyDate(Employee employee, Date date) throws SQLException {
         return leaveDao.getLeaveLogServiceCreditbyDate(employee, date);
     }
    public List<EmployeeServiceCredit> getAvailableLeaveFormServiceCredits(List<EmployeeServiceCredit> items, List<EmployeeServiceCredit> itemsToRemove) {

        List<Integer> ids = getEmployeeServiceCreditsIds(itemsToRemove);
        List<EmployeeServiceCredit> available = new ArrayList<>();

        for (EmployeeServiceCredit item : items) {
            int id = item.getServiceCredit().getId();
            if (!ids.contains(id)) {
                available.add(item);
            }
        }
        return available;

    }

    private List<Integer> getEmployeeServiceCreditsIds(List<EmployeeServiceCredit> items) {
        List<Integer> ids = new ArrayList<>();

        for (EmployeeServiceCredit item : items) {
            ids.add(item.getServiceCredit().getId());

        }
        return ids;
    }

    public int addLeave(LeaveForm leaveForm) throws SQLException , InvalidInputException{
        
        if(leaveForm.validate()){
             return leaveDao.addLeave(leaveForm);
        }else{
            throw new InvalidInputException("Please Complete the Form");
        }
       
    }
    
     public List<LeaveForm> getLeaveLogs(Employee employee) throws SQLException{
         
      
         List<LeaveForm> leaveLogs = leaveDao.getEmployeeLeaveLogs(employee);
         
         
      
         for(LeaveForm item:leaveLogs){
             item.setEmployee(employee);        
             item.setServiceCredit(leaveDao.getLeaveLogServiceCredit(item.getId()));
           
        }

        return leaveLogs;
    }

    public String generateReferenceNumber() throws SQLException {
        long timestamp = System.currentTimeMillis();
        java.util.Random random = new java.util.Random();
        int randomNumber = 100+random.nextInt(900);
        
       // System.out.println("size = "+(timestamp)+""+randomNumber).length() );

      
        return String.valueOf(timestamp).substring(6)+randomNumber;
    }
    
     public List<LeaveForm> searchByReferenceNumber(Employee employee,String refNum) throws SQLException {
         
         return leaveDao.searchByReferenceNumber(employee, refNum);
     }
     
     public int getLeaveCount(String id)throws SQLException{
         return leaveDao.getLeaveCount(id);
     }

     public LeaveForm getRecent(Employee employee)throws SQLException{
         return leaveDao.getEmployeeRecentLeave(employee);
     }
     
     public List<Personnel> getPersonnels() throws SQLException{
         return personnelService.getPersonnels();
     }
}
