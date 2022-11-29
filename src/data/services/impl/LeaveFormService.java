/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.services.impl;

import data.dao.LeaveDao;
import data.dao.implement.LeaveDaoImplement;
import data.model.EmployeeServiceCredit;
import data.model.LeaveType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class LeaveFormService { 
    LeaveDaoImplement leaveDao = new LeaveDaoImplement();
    
    EmployeeAndServiceCreditService employeeAndServiceCreditService = new EmployeeAndServiceCreditService();

   
    public List<LeaveType> getAllLeaveTypes() throws SQLException {
    
       return  leaveDao.getAllLeaveTypes();
    }

   
    public int addLeaveType(LeaveType leaveType) throws SQLException {
        return leaveDao.addLeaveType(leaveType);
    }
    
      public List<EmployeeServiceCredit> getEmployeeServiceCredits(String employeeId) throws SQLException {
        return employeeAndServiceCreditService.getEmployeeServiceCredits(employeeId);
    }
    
      
      
      public List<EmployeeServiceCredit> getAvailableLeaveFormServiceCredits( List<EmployeeServiceCredit> items, List<EmployeeServiceCredit> itemsToRemove ) {
       
          List<Integer> ids = getEmployeeServiceCreditsIds(itemsToRemove);
          List<EmployeeServiceCredit> available = new ArrayList<>();
          
          for(EmployeeServiceCredit item :items){
              int id = item.getServiceCredit().getId();
              if(ids.contains(id)){
                 available.add(item);
              }
          }
          return available;
    
      }
      
       private List<Integer> getEmployeeServiceCreditsIds( List<EmployeeServiceCredit> items) {
        List<Integer> ids = new ArrayList<>();

  

        for (EmployeeServiceCredit item : items) {
            ids.add(item.getServiceCredit().getId());

        }
        return ids;
    }

    
    
}
