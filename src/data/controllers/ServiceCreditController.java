/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.controllers;

import data.model.ServiceCredit;
import data.services.impl.ServiceCreditService;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author root
 */
public class ServiceCreditController {
    
    ServiceCreditService service = new ServiceCreditService();
    
    public int addServiceCredit(ServiceCredit serviceCredit)throws SQLException{
        return service.add(serviceCredit);
        
    }
    
    public List<ServiceCredit> getAllServiceCredits()throws SQLException{
        return service.getAll();
    }
    
}
