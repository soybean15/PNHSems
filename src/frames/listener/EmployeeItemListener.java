/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package frames.listener;

import data.model.Employee;
import frames.components.EmployeeItem;

/**
 *
 * @author root
 */
public interface EmployeeItemListener {
    
    void onEmployeeItemClick(EmployeeItem employeeItem);
    
    void onViewEmployeeClick(Employee employee);
    
    void onApplyLeaveClick(Employee employee);
    
    
}
