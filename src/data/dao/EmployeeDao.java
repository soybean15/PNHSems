/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.dao;

import data.model.Department;
import data.model.Employee;
import data.model.Position;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public interface EmployeeDao {

    public int add(Employee employee)
            throws SQLException;

    public int update(Employee employee)
            throws SQLException;

    public int delete(Employee employee)
            throws SQLException;

    public List<Employee> getAll()
            throws SQLException;

    public List<Employee> search(String item)
            throws SQLException;

    public Employee getEmployee(String id)
            throws SQLException;

    public String getLastId()
            throws SQLException;

    public int addPosition(Position position)
            throws SQLException;

    public Position getPosition(int id)
            throws SQLException;

    public List<Position> getPositions()
            throws SQLException;
    
    public int getEmployeeCount()
             throws SQLException;
    
     
    public Department getDepartment(int id)
             throws SQLException;
    
    public int addDepartment(Department department)
             throws SQLException;
    
    public List<Department> getDepartments()
             throws SQLException;
    

}
