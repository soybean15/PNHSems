/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.services.impl;

import data.dao.implement.ServiceCreditDaoImplement;
import data.model.ServiceCredit;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class ServiceCreditService {
    
    ServiceCreditDaoImplement serviceCreditDao = new ServiceCreditDaoImplement();
    
    public int add(ServiceCredit serviceCredit)throws SQLException{
        return serviceCreditDao.add(serviceCredit);
    }
    
}
