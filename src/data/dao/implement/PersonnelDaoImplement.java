/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dao.implement;

import data.dao.PersonnelDao;
import data.database.DbConnection;
import data.model.Personnel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class PersonnelDaoImplement implements PersonnelDao {

    
    Connection conn = DbConnection.getConnection();
    
    @Override
    public int addPersonnel(Personnel personnel) throws SQLException {
        String query ="insert into personnels(id, title, employee_id) values(?,?,?)";
        
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, personnel.getId());
        pst.setInt(2, personnel.getPositionId());
        pst.setString(3, personnel.getEmployeeId());
        
        return pst.executeUpdate();
      
    }

    @Override
    public int checkPersonnelCount() throws SQLException {
       String query = "SELECT COUNT(*) as total FROM personnels";
       
       PreparedStatement pst = conn.prepareStatement(query);
       ResultSet rs = pst.executeQuery();
       
       return rs.getInt("total");
       
    }

   
}
