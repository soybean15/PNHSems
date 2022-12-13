/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.dao;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.LeaveForm;
import data.model.LeaveType;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public interface LeaveDao {
    
    
    public List<LeaveType> getAllLeaveTypes()
            throws SQLException;
    
    public int addLeaveType(LeaveType leaveType)
            throws SQLException;
    
    public int addLeave(LeaveForm leaveForm)
              throws SQLException;
    
    public List<LeaveForm> getEmployeeLeaveLogs(Employee employee)
              throws SQLException;
    
    public List<EmployeeServiceCredit> getLeaveLogServiceCredit(int leaveId)
               throws SQLException;
    
    public List<LeaveForm> getLeaveLogServiceCreditbyDate(Employee employee, java.sql.Date date)
               throws SQLException;
}
