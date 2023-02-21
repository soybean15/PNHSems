/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dao;
import data.model.ServiceCredit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public interface ServiceCreditsDao {
    
   public int add(ServiceCredit serviceCredit)
           throws SQLException ;
   
   public int update(ServiceCredit serviceCredit)
            throws SQLException ;
   public int delete(ServiceCredit serviceCredit)
            throws SQLException ;
   
   public List<ServiceCredit> getAll()      
            throws SQLException ;
   
   public ServiceCredit get(int id)
             throws SQLException ;
   
   public int reset()
           throws SQLException;
   
   public String getPassword(String id)
           throws SQLException;
    
}
