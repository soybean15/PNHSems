/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.panels.employee_panel;

import data.model.Employee;
import frames.panels.employee_panel.profile.EmployeeProfilePanel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import themes.Theme;
import frames.listener.SidePanelListener;
import frames.panels.employee_panel.profile.EmployeeLeaveLogsPanel;
import frames.panels.employee_panel.profile.EmployeeServiceCreditsPanel;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class SidePanelEmployeeProfile extends javax.swing.JPanel {
    
    Theme primary = Theme.PRIMARY;
    
    SidePanelListener listener ;
    private final Employee employee;
    
    private EmployeeProfilePanel employeeProfile;
    private EmployeeServiceCreditsPanel employeeServiceCreditsPanel;
    private EmployeeLeaveLogsPanel employeeLeaveLogsPanel;
    private JLabel activeLabel;
    private JPanel activePanel;
    private HashMap<String,JPanel> panels ;
    
    

    /**
     * Creates new form sidePanelEmployeeProfile
     * @param listener
     * @param employee
     */
    public SidePanelEmployeeProfile( SidePanelListener listener , Employee employee) {
        initComponents();
        
        this.listener = listener;
        this.employee = employee;
        panels = listener.getPanels(this.employee);
        
        init();
    }
    
    private void init(){
        setDisplay();
        
        //getPanel reference
       
        employeeProfile =(EmployeeProfilePanel)panels.get("employee_profile");
        employeeServiceCreditsPanel=(EmployeeServiceCreditsPanel)panels.get("employee_service_credits");
        employeeLeaveLogsPanel =(EmployeeLeaveLogsPanel) panels.get("employee_leave_logs");

        activePanel(employeeProfile,lblProfile);
        
    }
    
    private void setDisplay(){
        lblEmployeeName.setText(employee.getFirstName()+"'s Profile");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblEmployeeName = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelProfile = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblProfile = new javax.swing.JLabel();
        panelServiceCredit = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblServiceCredit = new javax.swing.JLabel();
        panelLeaveLogs = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblLeaveLogs = new javax.swing.JLabel();
        panelExit = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setBackground(primary.COLOR.background_primary);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout(0, 10));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setText("    ");
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        lblEmployeeName.setFont(primary.FONT.big(12)
        );
        lblEmployeeName.setForeground(primary.COLOR.foreground_primary);
        lblEmployeeName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployeeName.setText("Employee name profile");
        jPanel1.add(lblEmployeeName, java.awt.BorderLayout.SOUTH);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(102, 255, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Image");
        jLabel12.setOpaque(true);
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 150));

        jPanel1.add(jPanel8, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(10, 0));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("     ");
        jPanel3.add(jLabel2, java.awt.BorderLayout.EAST);

        jLabel5.setText("     ");
        jPanel3.add(jLabel5, java.awt.BorderLayout.WEST);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        btnEdit.setBackground(new java.awt.Color(0, 51, 255));
        btnEdit.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel4.add(btnEdit);

        jButton2.setText("View");
        jPanel4.add(jButton2);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        panelProfile.setBackground(new java.awt.Color(255, 204, 204));
        panelProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelProfile.setOpaque(false);
        panelProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelProfileMouseExited(evt);
            }
        });
        panelProfile.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("jLabel4");
        panelProfile.add(jLabel4, java.awt.BorderLayout.LINE_START);

        lblProfile.setFont(primary.FONT.defaultFont(15)
        );
        lblProfile.setForeground(primary.COLOR.foreground_primary);
        lblProfile.setText("Profile");
        panelProfile.add(lblProfile, java.awt.BorderLayout.CENTER);

        jPanel2.add(panelProfile);

        panelServiceCredit.setBackground(new java.awt.Color(255, 204, 204));
        panelServiceCredit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelServiceCredit.setOpaque(false);
        panelServiceCredit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelServiceCreditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelServiceCreditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelServiceCreditMouseExited(evt);
            }
        });
        panelServiceCredit.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("jLabel4");
        panelServiceCredit.add(jLabel6, java.awt.BorderLayout.LINE_START);

        lblServiceCredit.setFont(primary.FONT.defaultFont(15)
        );
        lblServiceCredit.setForeground(primary.COLOR.foreground_primary);
        lblServiceCredit.setText("Service Credits");
        panelServiceCredit.add(lblServiceCredit, java.awt.BorderLayout.CENTER);

        jPanel2.add(panelServiceCredit);

        panelLeaveLogs.setBackground(new java.awt.Color(255, 204, 204));
        panelLeaveLogs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelLeaveLogs.setOpaque(false);
        panelLeaveLogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelLeaveLogsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelLeaveLogsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelLeaveLogsMouseExited(evt);
            }
        });
        panelLeaveLogs.setLayout(new java.awt.BorderLayout());

        jLabel8.setText("jLabel4");
        panelLeaveLogs.add(jLabel8, java.awt.BorderLayout.LINE_START);

        lblLeaveLogs.setFont(primary.FONT.defaultFont(15)
        );
        lblLeaveLogs.setForeground(primary.COLOR.foreground_primary);
        lblLeaveLogs.setText("Leave Logs");
        panelLeaveLogs.add(lblLeaveLogs, java.awt.BorderLayout.CENTER);

        jPanel2.add(panelLeaveLogs);

        panelExit.setBackground(new java.awt.Color(255, 204, 204));
        panelExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelExit.setOpaque(false);
        panelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelExitMouseExited(evt);
            }
        });
        panelExit.setLayout(new java.awt.BorderLayout());

        jLabel10.setText("jLabel4");
        panelExit.add(jLabel10, java.awt.BorderLayout.LINE_START);

        lblExit.setFont(primary.FONT.defaultFont(15)
        );
        lblExit.setForeground(primary.COLOR.foreground_primary);
        lblExit.setText("Exit");
        panelExit.add(lblExit, java.awt.BorderLayout.CENTER);

        jPanel2.add(panelExit);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void panelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelExitMouseClicked
        activePanel(employeeProfile,lblExit);
    
        
        listener.onEmployeeProfileExit();
    }//GEN-LAST:event_panelExitMouseClicked

    private void panelProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProfileMouseEntered
        onHover(lblProfile);
    }//GEN-LAST:event_panelProfileMouseEntered

    private void panelServiceCreditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelServiceCreditMouseEntered
       onHover(lblServiceCredit);
    }//GEN-LAST:event_panelServiceCreditMouseEntered

    private void panelLeaveLogsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLeaveLogsMouseEntered
       onHover(lblLeaveLogs);
    }//GEN-LAST:event_panelLeaveLogsMouseEntered

    private void panelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelExitMouseEntered
       onHover(lblExit);
    }//GEN-LAST:event_panelExitMouseEntered

    private void panelProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProfileMouseExited
        onExit(lblProfile);
    }//GEN-LAST:event_panelProfileMouseExited

    private void panelServiceCreditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelServiceCreditMouseExited
       onExit(lblServiceCredit);
    }//GEN-LAST:event_panelServiceCreditMouseExited

    private void panelLeaveLogsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLeaveLogsMouseExited
       onExit(lblLeaveLogs);
    }//GEN-LAST:event_panelLeaveLogsMouseExited

    private void panelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelExitMouseExited
         onExit(lblExit);
    }//GEN-LAST:event_panelExitMouseExited

    private void panelProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProfileMouseClicked
       activePanel(employeeProfile,lblProfile);

       
    }//GEN-LAST:event_panelProfileMouseClicked

    private void panelServiceCreditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelServiceCreditMouseClicked
        activePanel(employeeServiceCreditsPanel,lblServiceCredit);
         
    }//GEN-LAST:event_panelServiceCreditMouseClicked

    private void panelLeaveLogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLeaveLogsMouseClicked
         activePanel(employeeLeaveLogsPanel,lblLeaveLogs);
         
    }//GEN-LAST:event_panelLeaveLogsMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
      
        AddEmployeePanel add= (AddEmployeePanel) listener.onEditEmployeeListener(btnEdit.getText(), employee);
        add.setButton(btnEdit);
        if (btnEdit.getText().equals("Edit")) {
            activePanel.setVisible(false);
            btnEdit.setText("Back");
        } else {
            btnEdit.setText("Edit");
            activePanel(employeeProfile,lblProfile);
        }
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblLeaveLogs;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblServiceCredit;
    private javax.swing.JPanel panelExit;
    private javax.swing.JPanel panelLeaveLogs;
    private javax.swing.JPanel panelProfile;
    private javax.swing.JPanel panelServiceCredit;
    // End of variables declaration//GEN-END:variables

    private void onHover(JLabel label){
        if(activeLabel !=label)
        label.setFont(Theme.PRIMARY.FONT.big(13));
       

    }
     private void onExit(JLabel label){
         if(activeLabel !=label)
        label.setFont(primary.FONT.defaultFont(15));
       
    }
     
    private void activePanel( JPanel panel,JLabel label){ 
       
        if(btnEdit.getText().equals("Back")){
            int option = JOptionPane.showConfirmDialog(panel, "Are you sure you want to cancel Editing?","Leave Cancel profile",JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.NO_OPTION){
                return;
            }else{
                btnEdit.setText("Edit");
            }
        }
         if(activeLabel !=null){
            activeLabel.setFont(Theme.PRIMARY.FONT.defaultFont(13));
            
        }
        panel.setVisible(true);
        label.setFont( primary.FONT.big(15));
       
        activeLabel = label;
        activePanel = panel;
        listener.onSelectedPanelListener(panel);
        
        
    }
        
     
}
