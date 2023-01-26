/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.services.impl;

import data.dao.implement.EmployeeDaoImplement;
import data.dao.implement.PersonnelDaoImplement;
import data.model.Employee;
import data.model.Personnel;
import data.model.Position;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public class PersonnelService {
    
    PersonnelDaoImplement personnelDao = new PersonnelDaoImplement();
    
    EmployeeDaoImplement employeeDao = new EmployeeDaoImplement();
    
    public int addPersonnels()throws SQLException{
        
        if(personnelDao.checkPersonnelCount() == 0 ){
            
            
            
            personnelDao.addPersonnel(new Personnel(1,employeeDao.getPosition(3),null));
            personnelDao.addPersonnel(new Personnel(2,employeeDao.getPosition(3),null));
            personnelDao.addPersonnel(new Personnel(3,employeeDao.getPosition(5),null));
            personnelDao.addPersonnel(new Personnel(4,employeeDao.getPosition(4),null));
                    
            
        }
        return 0;
              
        
    }
    
    
    public List<Personnel> getPersonnels() throws SQLException{
        List<Personnel> personnels = personnelDao.getPersonnels();
        
        for(Personnel item :personnels){
            Position position = employeeDao.getPosition(item.getPosition().getId());
            Employee employee = employeeDao.getEmployee(item.getEmployee().getId());
            
            item.setEmployee(employee);
            item.setPosition(position);
        }
        return personnels;
    }
    
}
