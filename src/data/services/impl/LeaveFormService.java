/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.services.impl;

import data.dao.LeaveDao;
import data.dao.implement.LeaveDaoImplement;
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

   
    public List<LeaveType> getAllLeaveTypes() throws SQLException {
    
       return  leaveDao.getAllLeaveTypes();
    }

   
    public int addLeaveType(LeaveType leaveType) throws SQLException {
        return leaveDao.addLeaveType(leaveType);
    }
    
    
    
}
