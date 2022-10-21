/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package frames.listener;

import data.model.Employee;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public interface SidePanelListener {
    
    public void onSelectedPanelListener(JPanel panel);
    public void onEmployeeProfileExit();
    public HashMap<String, JPanel> getPanels(Employee employee);
    public JPanel onEditEmployeeListener(String text,Employee employee);
    
    
    public void onFinishProfileEdit(String id);
}
