/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dao.implement;

import data.dao.LeaveDao;
import data.database.DbConnection;
import data.model.LeaveForm;
import data.model.LeaveType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class LeaveDaoImplement implements LeaveDao{
    
     Connection conn = DbConnection.getConnection();

    @Override
    public List<LeaveType> getAllLeaveTypes() throws SQLException {
        String query = "Select * from leave_type";
        
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        
        List<LeaveType> leaveTypes = new ArrayList<>();
        
        while(rs.next()){
            LeaveType leaveType = new LeaveType();
            leaveType.setId(rs.getInt("id"));
            leaveType.setName(rs.getString("name"));
            leaveType.setReference(rs.getString("reference"));
            
            
            leaveTypes.add(leaveType);
        }
        
        return leaveTypes;
        
    }

    @Override
    public int addLeaveType(LeaveType leaveType) throws SQLException {
        String query ="insert into leave_type(name , reference) values(?,?)";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, leaveType.getName());
        pst.setString(2, leaveType.getReference());
        
        return pst.executeUpdate();
    
    }
    @Override
    public int addLeave(LeaveForm leaveForm) throws SQLException {
        String query = "insert into(employeeId, date_filed, inclusive_date_start, inclusive_date_end, days_used, leave_type_id, details) values(?,?,?,?,?,?,?,?)";
        
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, leaveForm.getEmployee().getId());
        pst.setDate(2, leaveForm.getDateFiled());
        pst.setDate(3, leaveForm.getInclusiveDate_start());
        pst.setDate(3, leaveForm.getInclusiveDate_end());
        pst.setInt(5, leaveForm.getCreditUsed());
        pst.setInt(6, leaveForm.getLeaveType().getId());
        pst.setString(7, leaveForm.getDetails());
        
        return pst.executeUpdate();
    }


    
    
    
    
}
