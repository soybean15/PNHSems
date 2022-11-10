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
import java.util.ArrayList;

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
        String query = "update service_credits set order_no =?, memorandum =?, title =?, no_of_days =?, updated_at =CURRENT_TIMESTAMP where id =?";
         
        System.out.println("id->"+serviceCredit.getId());
        System.out.println("order_no->"+serviceCredit.getOrderNo());
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, serviceCredit.getOrderNo());
        ps.setString(2, serviceCredit.getMemorandum());
        ps.setString(3, serviceCredit.getTitle());
        ps.setInt(4, serviceCredit.getNumberOfDays());
        ps.setInt(5   , serviceCredit.getId());
        return ps.executeUpdate();
    }

    @Override
    public int delete(ServiceCredit serviceCredit) throws SQLException {
       String query = " delete from service_credits where id =?";
       PreparedStatement ps= conn.prepareStatement(query);
       ps.setInt(1, serviceCredit.getId());
        return ps.executeUpdate();
       
    }

    @Override
    public List<ServiceCredit> getAll() throws SQLException {
      String query="Select * from service_credits";
      PreparedStatement pst = conn.prepareStatement(query);
      ResultSet rs = pst.executeQuery();
      
      List<ServiceCredit> serviceCredits = new ArrayList<>();
      while(rs.next()){
          
          ServiceCredit serviceCredit = new ServiceCredit();
          serviceCredit.setId(rs.getInt("id"));
          serviceCredit.setOrderNo(rs.getString("order_no"));
          serviceCredit.setMemorandum(rs.getString("memorandum"));
          serviceCredit.setTitle(rs.getString("title"));
          serviceCredit.setNumberOfDays(rs.getInt("no_of_days"));
          serviceCredit.setCreated_at(rs.getTimestamp("created_at"));
          serviceCredit.setUpdated_at(rs.getTimestamp("updated_at"));
          
          serviceCredits.add(serviceCredit);
      }
      
      return serviceCredits;
    }

    @Override
    public ServiceCredit get(int id) throws SQLException {
        String query = "Select * from service_credits where id = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        
        ResultSet rs = pst.executeQuery();
        ServiceCredit serviceCredit = new ServiceCredit();
        if(rs.next()){
            serviceCredit.setId(rs.getInt("id"));
            serviceCredit.setOrderNo("order_no ");
            serviceCredit.setMemorandum(rs.getString("memorandum"));
            serviceCredit.setTitle("title");
            serviceCredit.setNumberOfDays(rs.getInt("no_of_days"));
            serviceCredit.setCreated_at(rs.getTimestamp("created_at"));
            serviceCredit.setUpdated_at(rs.getTimestamp("updated_at"));
        }
        return serviceCredit;
    }
    
}
