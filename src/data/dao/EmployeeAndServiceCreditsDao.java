/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.dao;

import data.model.EmployeeServiceCredit;
import data.model.ServiceCredit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public interface EmployeeAndServiceCreditsDao {

    public int addServiceCredit(String employeeId, int serviceCreditId)
            throws SQLException;

    public List<EmployeeServiceCredit> getEmployeeServiceCredits(String employeeId)
            throws SQLException;

}
