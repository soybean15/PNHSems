/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.services.impl;

import data.dao.ServiceCreditsDao;
import data.dao.implement.ServiceCreditDaoImplement;
import data.model.ServiceCredit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public class ServiceCreditService implements ServiceCreditsDao{
    
    ServiceCreditDaoImplement serviceCreditDao = new ServiceCreditDaoImplement();
    
    public int add(ServiceCredit serviceCredit)throws SQLException{
        return serviceCreditDao.add(serviceCredit);
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
        return serviceCreditDao.getAll();
    }

    @Override
    public ServiceCredit get() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
