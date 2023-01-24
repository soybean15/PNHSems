/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dao.implement;

import data.dao.LeaveDao;
import data.database.DbConnection;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.LeaveForm;
import data.model.LeaveType;
import data.model.ServiceCredit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import otherclasses.BaseClass;

/**
 *
 * @author root
 */
public class LeaveDaoImplement implements LeaveDao {

    Connection conn = DbConnection.getConnection();

    @Override
    public List<LeaveType> getAllLeaveTypes() throws SQLException {
        String query = "Select * from leave_type";

        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        List<LeaveType> leaveTypes = new ArrayList<>();

        while (rs.next()) {
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
        String query = "insert into leave_type(name , reference) values(?,?)";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, leaveType.getName());
        pst.setString(2, leaveType.getReference());

        return pst.executeUpdate();

    }

    @Override
    public int addLeave(LeaveForm leaveForm) throws SQLException {
        String query = "insert into employee_leave(employeeId, date_filed, inclusive_date_start, inclusive_date_end, days_used, leave_type_id, details,user_id,reference_num) values(?,?,?,?,?,?,?,?,?)";

        try {
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, leaveForm.getEmployee().getId());
            pst.setDate(2, leaveForm.getDateFiled());
            pst.setDate(3, leaveForm.getInclusiveDate_start());
            pst.setDate(4, leaveForm.getInclusiveDate_end());
            pst.setInt(5, leaveForm.getCreditUsed());
            
            if (leaveForm.getLeaveType() != null) {
                pst.setInt(6, leaveForm.getLeaveType().getId());
            } else {
                pst.setNull(6, 0);
            }

            pst.setString(7, leaveForm.getDetails());
            pst.setString(8, BaseClass.user.getUserName());
             pst.setString(9, leaveForm.getId());

            pst.executeUpdate();
            

            query = "SELECT LAST_INSERT_ID()";
            pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                query = "insert into leave_service_credits(service_credit_id, leave_id,credit_used) value(?,?,?) ";

                for (EmployeeServiceCredit item : leaveForm.getServiceCredit()) {
                    pst = conn.prepareStatement(query);
                    pst.setInt(1, item.getServiceCredit().getId());
                    pst.setInt(2, rs.getInt(1));
                    pst.setInt(3, item.getDays_used());

                    pst.executeUpdate();
                }

            }

            for (EmployeeServiceCredit item : leaveForm.getServiceCredit()) {
                query = "update employee_and_service_credits set remaining_days=? where employeeId =? and service_credits_id=?";
                pst = conn.prepareStatement(query);
                pst.setInt(1, item.getNo_of_days()-item.getDays_used());
                pst.setString(2, leaveForm.getEmployee().getId());
                pst.setInt(3, item.getServiceCredit().getId());
                pst.executeUpdate();
            }
          

            conn.commit();
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            conn.rollback();
            return 0;
        }

    }

    @Override
    public List<LeaveForm> getEmployeeLeaveLogs(Employee employee) throws SQLException {
        List<LeaveForm> leaveLogs = new ArrayList<>();
        String query = "select * from employee_leave left join leave_type on leave_type.id = leave_type_id "
                + "where employeeId =?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, employee.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                LeaveForm leaveForm = new LeaveForm();
                leaveForm.setId(rs.getString("reference_num"));
                leaveForm.setDateFiled(rs.getDate("date_filed"));
                leaveForm.setInclusiveDate_start(rs.getDate("inclusive_date_start"));
                leaveForm.setInclusiveDate_end(rs.getDate("inclusive_date_end"));
                leaveForm.setCreditUsed(rs.getInt("days_used"));
                leaveForm.setDetails(rs.getString("details"));
                leaveForm.setCreated_at(rs.getTimestamp("created_at"));
                leaveForm.setUserId(rs.getString("user_id"));

                if (rs.getString("leave_type_id") != null) {
                    LeaveType leaveType = new LeaveType();

                    leaveType.setId(rs.getInt("id"));
                    leaveType.setName(rs.getString("name"));
                    leaveType.setReference("reference");

                    leaveForm.setLeaveType(leaveType);

                }

                leaveLogs.add(leaveForm);
            }

            return leaveLogs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            conn.rollback();

            leaveLogs = new ArrayList<>();
            return leaveLogs;
        }
    }

    @Override
    public List<EmployeeServiceCredit> getLeaveLogServiceCredit(String leaveId) throws SQLException {
        String query = "Select * from leave_service_credits inner join service_credits on service_credits.id = service_credit_id"
                + " where leave_id =?";
        
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, leaveId);
        ResultSet rs = pst.executeQuery();
        
        List<EmployeeServiceCredit> list = new ArrayList<>();
        while(rs.next()){
           EmployeeServiceCredit item = new EmployeeServiceCredit();
           ServiceCredit serviceCredit = new ServiceCredit();
           
           serviceCredit.setId(rs.getInt("service_credits.id"));
           serviceCredit.setMemorandum(rs.getString("service_credits.memorandum"));
           
           serviceCredit.setNumberOfDays(rs.getInt("service_credits.no_of_days"));
           serviceCredit.setTitle(rs.getString("service_credits.title"));
           
           item.setDays_used(rs.getInt("credit_used"));
           item.setServiceCredits(serviceCredit);
           list.add(item);
        }
        return list;
    }

    @Override
    public List<LeaveForm> getLeaveLogServiceCreditbyDate(Employee employee, Date date) throws SQLException {
          List<LeaveForm> leaveLogs = new ArrayList<>();
        String query = "select * from employee_leave left join leave_type on leave_type.id = leave_type_id "
                + "where employeeId =? and date_filed = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, employee.getId());
            pst.setDate(2, date);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                LeaveForm leaveForm = new LeaveForm();
                leaveForm.setId(rs.getString("reference_num"));
                leaveForm.setDateFiled(rs.getDate("date_filed"));
                leaveForm.setInclusiveDate_start(rs.getDate("inclusive_date_start"));
                leaveForm.setInclusiveDate_end(rs.getDate("inclusive_date_end"));
                leaveForm.setCreditUsed(rs.getInt("days_used"));
                leaveForm.setDetails(rs.getString("details"));
                leaveForm.setCreated_at(rs.getTimestamp("created_at"));

                if (rs.getString("leave_type_id") != null) {
                    LeaveType leaveType = new LeaveType();

                    leaveType.setId(rs.getInt("id"));
                    leaveType.setName(rs.getString("name"));
                    leaveType.setReference("reference");

                    leaveForm.setLeaveType(leaveType);

                }

                leaveLogs.add(leaveForm);
            }

            return leaveLogs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            conn.rollback();

            leaveLogs = new ArrayList<>();
            return leaveLogs;
        }
    }

    @Override
    public String getLastId() throws SQLException {
        String query = "select reference_num from employee_leave order by reference_num desc limit 1";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        return rs.next() ? rs.getString("reference_num") : null;
    }

    @Override
    public List<LeaveForm> searchByReferenceNumber(Employee employee,String refNum) throws SQLException {
         List<LeaveForm> leaveLogs = new ArrayList<>();
        String query = "select * from employee_leave left join leave_type on leave_type.id = leave_type_id "
                + "where employeeId =? and reference_num = ?";
        
        
         try {
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, employee.getId());
            pst.setString(2, refNum);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                LeaveForm leaveForm = new LeaveForm();
                leaveForm.setId(rs.getString("reference_num"));
                leaveForm.setDateFiled(rs.getDate("date_filed"));
                leaveForm.setInclusiveDate_start(rs.getDate("inclusive_date_start"));
                leaveForm.setInclusiveDate_end(rs.getDate("inclusive_date_end"));
                leaveForm.setCreditUsed(rs.getInt("days_used"));
                leaveForm.setDetails(rs.getString("details"));
                leaveForm.setCreated_at(rs.getTimestamp("created_at"));

                if (rs.getString("leave_type_id") != null) {
                    LeaveType leaveType = new LeaveType();

                    leaveType.setId(rs.getInt("id"));
                    leaveType.setName(rs.getString("name"));
                    leaveType.setReference("reference");

                    leaveForm.setLeaveType(leaveType);

                }

                leaveLogs.add(leaveForm);
            }

            return leaveLogs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            conn.rollback();

            leaveLogs = new ArrayList<>();
            return leaveLogs;
        }
    }

}
