/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package frames.listener;

import data.model.Employee;
import data.model.ServiceCredit;
import frames.panels.employee_panel.LeaveFormPanel;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public interface MainPanelListener {
    public void onAddEmployeeClick();
    public void onEmployeeProfileClick(Employee employee);
    
    public void onOpeningLeaveForm(Employee employee,ServiceCredit serviceCredit);
    
   
    
}
