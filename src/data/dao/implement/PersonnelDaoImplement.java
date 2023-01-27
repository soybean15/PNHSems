/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dao.implement;

import data.dao.PersonnelDao;
import data.database.DbConnection;
import data.model.Employee;
import data.model.Personnel;
import data.model.Position;
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
public class PersonnelDaoImplement implements PersonnelDao {

    
    Connection conn = DbConnection.getConnection();
    
    @Override
    public int addPersonnel(Personnel personnel) throws SQLException {
        String query ="insert into personnels(id, position_id, employee_id) values(?,?,?)";
        
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, personnel.getId());
        pst.setInt(2, personnel.getPosition().getId());
        pst.setString(3, personnel.getEmployee() ==null? null : personnel.getEmployee().getId());
        
        return pst.executeUpdate();
      
    }

    @Override
    public int checkPersonnelCount() throws SQLException {
       String query = "SELECT COUNT(*) as total FROM personnels";
       
       PreparedStatement pst = conn.prepareStatement(query);
       ResultSet rs = pst.executeQuery();
       
       rs.next();
     
       
       return rs.getInt("total");
       
    }

    @Override
    public List<Personnel> getPersonnels() throws SQLException {
        List<Personnel> personnels = new ArrayList<>();
        String query = "select * from personnels inner join positions on positions.id = personnels.position_id "
                + "left join employee on employee.id = personnels.employee_id";
        
        
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
         
            Personnel personnel = new Personnel(
                    rs.getInt("id"),
                    new Position().setId(rs.getInt("position_id")),
                    new Employee().setId(rs.getString("employee_id"))
            );
            
            personnels.add(personnel);
        }
       return personnels;
    }

    @Override
    public int updatePersonnel(Personnel personnel) throws SQLException {
        String query = "update personnels set employee_id = ? where id = ?";
        
        PreparedStatement pst = conn.prepareStatement(query);
        
          pst.setString(1, personnel.getEmployee().getId());
        pst.setInt(2, personnel.getId());
        
      
        return pst.executeUpdate();
    }

   
}
