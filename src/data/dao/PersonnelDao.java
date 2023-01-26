/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.dao;

import data.model.Personnel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public interface PersonnelDao {

    public int addPersonnel(Personnel personnel)
            throws SQLException;

    public int checkPersonnelCount()
            throws SQLException;
    
    public List<Personnel> getPersonnels()
            throws SQLException;
    

    


}
