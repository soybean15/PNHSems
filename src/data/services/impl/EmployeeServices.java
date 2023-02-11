/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.services.impl;

import data.dao.implement.EmployeeDaoImplement;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.Personnel;
import data.model.Position;
import data.model.ServiceCredit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import otherclasses.UtilClass;

/**
 *
 * @author root
 */
public class EmployeeServices {

    EmployeeDaoImplement employeeDao = new EmployeeDaoImplement();

    EmployeeAndServiceCreditService employeeAndServiceCreditService = new EmployeeAndServiceCreditService();

    public String generateId() throws SQLException {

        String id = employeeDao.getLastId();

        return id == null ? "PEN-" + UtilClass.splitId("PEN-220000") : "PEN-" + UtilClass.splitId(id);
    }

    public int addEmployee(Employee employee) throws SQLException {
        if (employee.validate()) {
            return employeeDao.add(employee);

        }
        return 0;

    }

    public int updateEmployee(Employee employee) throws SQLException {
        return employeeDao.update(employee);
    }

    public Employee getEmployee(String id) throws SQLException {
        return employeeDao.getEmployee(id);
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return employeeDao.getAll();
    }

    public List<Employee> searchEmployees(String item) throws SQLException {

        return employeeDao.search(item);
    }

    public int addPosition(Position position) throws SQLException {
        return employeeDao.addPosition(position);
    }

    public Position getPosition(int id) throws SQLException {
        return employeeDao.getPosition(id);
    }

    public List<Position> getPositions() {
        try {
            return employeeDao.getPositions();
        } catch (SQLException e) {
            return null;
        }

    }

    public int addServiceCredit(String employeeId, int serviceCreditId) throws SQLException {
        return employeeAndServiceCreditService.addServiceCredit(employeeId, serviceCreditId);
    }

    public List<EmployeeServiceCredit> getEmployeeServiceCredits(String employeeId) throws SQLException {
        return employeeAndServiceCreditService.getEmployeeServiceCredits(employeeId);

    }

    public List<ServiceCredit> getAvailableServiceCredit(String employeeId) throws SQLException {

        return employeeAndServiceCreditService.getAvailableServiceCredits(employeeId);

    }

    public int deleteEmployeeServiceCredits(String employeeId, int serviceCreditId) throws SQLException {
        return employeeAndServiceCreditService.deleteEmployeeServiceCredits(employeeId, serviceCreditId);
    }
    
    public int deleteEmployee(Employee employee)throws SQLException{
        return employeeDao.delete(employee);
    }

    public int getEmployeeCount() throws SQLException {
        return employeeDao.getEmployeeCount();
    }
  

}
