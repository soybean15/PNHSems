/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dao.implement;

import data.dao.EmployeeAndServiceCreditsDao;
import data.database.DbConnection;
import data.model.EmployeeServiceCredit;
import data.model.ServiceCredit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class EmployeeAndServiceCreditsDaoImplement implements EmployeeAndServiceCreditsDao {

    Connection conn = DbConnection.getConnection();

    @Override
    public int addServiceCredit(String employeeId, int serviceCreditId) throws SQLException {
        String query = "Insert into employee_and_service_credits(employeeId,service_credits_id, no_of_days) values(?,?,(SELECT no_of_days from service_credits WHERE service_credits.id = ?))";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, employeeId);
        pst.setInt(2, serviceCreditId);
        pst.setInt(3, serviceCreditId);

        return pst.executeUpdate();
    }

    @Override
    public List<EmployeeServiceCredit> getEmployeeServiceCredits(String employeeId) throws SQLException {
        String query = "SELECT * "
                + "FROM employee_and_service_credits "
                + "INNER JOIN service_credits on employee_and_service_credits.service_credits_id = service_credits.id "
                + "WHERE employee_and_service_credits.employeeId =?";

        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, employeeId);
        ResultSet rs = pst.executeQuery();

        List<EmployeeServiceCredit> employeeServiceCredits = new ArrayList<>();
        while (rs.next()) {
            ServiceCredit serviceCredit = new ServiceCredit();
            serviceCredit.setId(rs.getInt("id"));
            serviceCredit.setOrderNo(rs.getString("order_no"));
            serviceCredit.setMemorandum(rs.getString("memorandum"));

            serviceCredit.setTitle("title");
            serviceCredit.setNumberOfDays(rs.getInt("no_of_days"));
            serviceCredit.setCreated_at(rs.getTimestamp("created_at"));
            serviceCredit.setUpdated_at(rs.getTimestamp("updated_at"));

            EmployeeServiceCredit employeeServiceCredit = new EmployeeServiceCredit();
            
            employeeServiceCredit.setEmployeeId(employeeId);
            employeeServiceCredit.setServiceCredits(serviceCredit);
            employeeServiceCredit.setNo_of_days(rs.getInt("employee_and_service_credits.no_of_days"));
            
            
            employeeServiceCredits.add(employeeServiceCredit);
        }
        return employeeServiceCredits;
    }

    @Override
    public int delete(String employeeId, int serviceCreditId) throws SQLException {
        String query = "Delete from employee_and_service_credits where employeeId =? and service_credits_id =?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, employeeId);
        pst.setInt(2, serviceCreditId);
        
        return pst.executeUpdate();
    }

    @Override
    public EmployeeServiceCredit getEmployeeServiceCredit(String employeeId, int serviceCreditId) throws SQLException {
       String query ="Select * from employee_and_service_credits "
               + "inner join service_credits on employee_and_service_credits.service_credits_id = service_credits.id where "
               + "employee_and_service_credits.employeeId =? and employee_and_service_credits.service_credits_id =?";
       
       PreparedStatement pst = conn.prepareStatement(query);
       pst.setString(1, employeeId);
       pst.setInt(2, serviceCreditId);
       ResultSet rs = pst.executeQuery();
       
       
       
       if(rs.next()){
           EmployeeServiceCredit employeeServiceCredit = new EmployeeServiceCredit();
           
           employeeServiceCredit.setEmployeeId(employeeId);
           
             ServiceCredit serviceCredit = new ServiceCredit();
            serviceCredit.setId(rs.getInt("id"));
            serviceCredit.setOrderNo(rs.getString("order_no"));
            serviceCredit.setMemorandum(rs.getString("memorandum"));
            serviceCredit.setTitle("title");
            serviceCredit.setNumberOfDays(rs.getInt("no_of_days"));
            serviceCredit.setCreated_at(rs.getTimestamp("created_at"));
            serviceCredit.setUpdated_at(rs.getTimestamp("updated_at"));

                
            employeeServiceCredit.setEmployeeId(employeeId);
            employeeServiceCredit.setServiceCredits(serviceCredit);
            employeeServiceCredit.setNo_of_days(rs.getInt("employee_and_service_credits.no_of_days"));
            
            
           return employeeServiceCredit;
       }
       return null;
              
    }

}
