/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.services.impl;

import data.dao.implement.PersonnelDaoImplement;
import data.model.Personnel;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class PersonnelService {
    
    PersonnelDaoImplement personnelDao = new PersonnelDaoImplement();
    
    public int addPersonnels()throws SQLException{
        
        if(personnelDao.checkPersonnelCount() == 0 ){
            
            personnelDao.addPersonnel(new Personnel(1,3,null));
            personnelDao.addPersonnel(new Personnel(2,3,null));
            personnelDao.addPersonnel(new Personnel(3,5,null));
            personnelDao.addPersonnel(new Personnel(3,4,null));
                    
            
        }
        return 0;
              
        
    }
    
}
