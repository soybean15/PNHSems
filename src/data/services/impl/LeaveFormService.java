/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.services.impl;

import data.dao.LeaveDao;
import data.dao.implement.LeaveDaoImplement;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.LeaveForm;
import data.model.LeaveType;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import otherclasses.UtilClass;
import pnhsems.InvalidInputException;

/**
 *
 * @author root
 */
public class LeaveFormService {

    LeaveDaoImplement leaveDao = new LeaveDaoImplement();


    EmployeeAndServiceCreditService employeeAndServiceCreditService = new EmployeeAndServiceCreditService();

    public List<LeaveType> getAllLeaveTypes() throws SQLException {

        return leaveDao.getAllLeaveTypes();
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

    public String getLastId() throws SQLException {
        
        String id = leaveDao.getLastId();
        
        return id == null ? "ref-"+UtilClass.splitId("PEN-220000") : "ref-" + UtilClass.splitId(id);
    }

}
