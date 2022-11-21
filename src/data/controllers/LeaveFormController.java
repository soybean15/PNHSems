/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.controllers;

import data.model.LeaveType;
import java.sql.SQLException;
import data.services.impl.LeaveFormService;
import java.util.List;

/**
 *
 * @author root
 */
public class LeaveFormController {
    LeaveFormService service = new LeaveFormService();
    
    public int addLeaveType(LeaveType leaveType)throws SQLException{
        return service.addLeaveType(leaveType);
    }
    
    public List<LeaveType> getLeaveTypes()throws SQLException{
        return service.getAllLeaveTypes();
    }
    
}
