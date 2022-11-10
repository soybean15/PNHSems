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
import pnhsems.InvalidInputException;

/**
 *
 * @author root
 */
public class ServiceCreditService {

    ServiceCreditDaoImplement serviceCreditDao = new ServiceCreditDaoImplement();

    public int add(ServiceCredit serviceCredit) throws SQLException, InvalidInputException {
        if (serviceCredit.validate()) {

            return serviceCreditDao.add(serviceCredit);
        } else {
            throw new InvalidInputException("Please Fill all Fields");
        }

    }

    public int update(ServiceCredit serviceCredit) throws SQLException, InvalidInputException {
        if (serviceCredit.validate()) {

            return serviceCreditDao.update(serviceCredit);
        } else {
            throw new InvalidInputException("Please Fill all Fields");
        }
    }

    public int delete(ServiceCredit serviceCredit) throws SQLException {
        return serviceCreditDao.delete(serviceCredit);
    }

    public List<ServiceCredit> getAll() throws SQLException {
        return serviceCreditDao.getAll();
    }

    public ServiceCredit get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
}