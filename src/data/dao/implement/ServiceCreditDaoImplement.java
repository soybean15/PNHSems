/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dao.implement;

import data.dao.ServiceCreditsDao;
import data.database.DbConnection;
import data.model.ServiceCredit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class ServiceCreditDaoImplement implements ServiceCreditsDao{
    
    Connection conn = DbConnection.getConnection();

    @Override
    public int add(ServiceCredit serviceCredit) throws SQLException {
        String query ="insert into service_credits(order_no,title,memorandum,no_of_days) values(?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, serviceCredit.getOrderNo());
        ps.setString(2, serviceCredit.getTitle());
        ps.setString(3, serviceCredit.getMemorandum());
        ps.setInt(4, serviceCredit.getNumberOfDays());
        
        return ps.executeUpdate();
    }

    @Override
    public int update(ServiceCredit serviceCredit) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ServiceCredit serviceCredit) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ServiceCredit> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ServiceCredit get() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
