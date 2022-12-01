/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.services.impl;

import data.dao.implement.EmployeeAndServiceCreditsDaoImplement;
import data.model.EmployeeServiceCredit;
import data.model.ServiceCredit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class EmployeeAndServiceCreditService {

    EmployeeAndServiceCreditsDaoImplement dao = new EmployeeAndServiceCreditsDaoImplement();

    ServiceCreditService serviceCreditService = new ServiceCreditService();

    public int addServiceCredit(String employeeId, int serviceCreditId) throws SQLException {
        return dao.addServiceCredit(employeeId, serviceCreditId);
    }

    public List<EmployeeServiceCredit> getEmployeeServiceCredits(String employeeId) throws SQLException {
        return dao.getEmployeeServiceCredits(employeeId);
    }
    
    public EmployeeServiceCredit getEmployeeServiceCredit(String employeeId, int serviceCreditId) throws SQLException {
        return dao.getEmployeeServiceCredit(employeeId, serviceCreditId);
    }

    public List<ServiceCredit> getAvailableServiceCredits(String employeeId) throws SQLException {
        List<Integer> ids = getEmployeeServiceCreditsIds(employeeId);

        List<ServiceCredit> serviceCredits = serviceCreditService.getAll();
        List<ServiceCredit> available = new ArrayList<>();

        for (int i = 0; i < serviceCredits.size(); i++) {

            if (!ids.contains(serviceCredits.get(i).getId())) {
                available.add(serviceCredits.get(i));
            }
        }

        return available;

    }

    private List<Integer> getEmployeeServiceCreditsIds(String employeeId) throws SQLException {
        List<Integer> ids = new ArrayList<>();

        List<EmployeeServiceCredit> employeeServiceCredits = dao.getEmployeeServiceCredits(employeeId);

        for (EmployeeServiceCredit item : employeeServiceCredits) {
            ids.add(item.getServiceCredit().getId());

        }
        return ids;
    }

    public int deleteEmployeeServiceCredits(String employeeId, int serviceCreditId) throws SQLException {
        return dao.delete(employeeId, serviceCreditId);
    }
}
