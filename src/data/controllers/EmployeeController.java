/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.controllers;

import otherclasses.UtilClass;
import data.model.Employee;
import data.model.Position;
import data.dao.implement.EmployeeDaoImplement;
import data.services.impl.EmployeeServices;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public class EmployeeController {

    EmployeeServices service = new EmployeeServices();

    public String generateId() throws SQLException {

        return service.generateId();
    }

    public int addEmployee(Employee employee) throws SQLException {
        return service.addEmployee(employee);

    }
    
    public int updateEmployee(Employee employee) throws SQLException{
        return service.updateEmployee(employee);
    }
    
    public Employee getEmployee(String id)throws SQLException{
        return service.getEmployee(id);
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return service.getAllEmployees();
    }

    public List<Employee> searchEmployees(String item) throws SQLException {

        return service.searchEmployees(item);
    }

    public int addPosition(Position position) throws SQLException {
        return service.addPosition(position);
    }

    public Position getPosition(int id) throws SQLException {
        return service.getPosition(id);
    }

    public List<Position> getPositions() {

        return service.getPositions();

    }

}
