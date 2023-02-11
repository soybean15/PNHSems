/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import data.controllers.UserController;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.ServiceCredit;
import data.model.User;
import frames.panels.AccountSettingPanel;
import frames.panels.employee_panel.profile.EmployeeProfilePanel;
import frames.panels.PersonnelPanel;
import frames.panels.ServiceCreditPanel;
import frames.panels.employee_panel.SidePanelEmployeeProfile;
import frames.panels.UserPanel;
import frames.panels.employee_panel.AddEmployeePanel;
import frames.panels.employee_panel.EmployeeListPanel;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import themes.Theme;
import frames.listener.MainPanelListener;
import frames.listener.SidePanelListener;
import frames.panels.employee_panel.LeaveFormPanel;
import frames.panels.employee_panel.profile.EmployeeLeaveLogsPanel;
import frames.panels.employee_panel.profile.EmployeeServiceCreditsPanel;
import java.awt.Panel;
import java.util.HashMap;
import javax.swing.JOptionPane;
import otherclasses.BaseClass;
import otherclasses.ImageHandler;

/**
 *
 * @author root
 */
public class MainFrame extends javax.swing.JFrame implements MainPanelListener, SidePanelListener {

    Theme primary = Theme.PRIMARY;

    //Main Panels
    UserPanel userPanel = new UserPanel();

    PersonnelPanel personnelPanel = new PersonnelPanel();
    ServiceCreditPanel serviceCreditPanel = new ServiceCreditPanel();
    AccountSettingPanel accountSettingPanel = new AccountSettingPanel();
    AddEmployeePanel addEmployeePanel = new AddEmployeePanel(this, null);
    EmployeeListPanel employeeListPanel = new EmployeeListPanel(this);

    //profile Panels
    SidePanelEmployeeProfile sidePanelEmployeeProfile;
    EmployeeProfilePanel employeeProfilePanel;
    EmployeeServiceCreditsPanel employeeServiceCreditsPanel;
    EmployeeLeaveLogsPanel employeeLeaveLogsPanel;
    LeaveFormPanel leaveFormPanel;

    JPanel activeMainPanel;
    JPanel activeSidePanel;
    JPanel activeProfilePanel;

   

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        init();
    }

    private void init() {
        
       //  BaseClass.user = UserController.getUser();

         if(!BaseClass.user.getRole().equals("superadmin")){
        sidePanelMenu.remove(sidePanelUsers);
        sidePanelMenu.repaint();
        }
        mainContainer.add(userPanel).setVisible(false);

        mainContainer.add(personnelPanel).setVisible(false);
        mainContainer.add(serviceCreditPanel).setVisible(false);
        mainContainer.add(accountSettingPanel).setVisible(false);
        mainContainer.add(addEmployeePanel).setVisible(false);
        mainContainer.add(employeeListPanel).setVisible(false);

        //sidePanel.remove(splitPanelUsers);
        //set up sidePanel
        topPanel.setBackground(primary.COLOR.background_primary);
        sidePanelMenu.setBackground(primary.COLOR.background_primary);

        setSidePanelItem(sidePanelUsers, sideLabelUsers);

        setSidePanelItem(sidePanelEmployee, sideLabelEmployee);
        setSidePanelItem(sidePanelServiceCreds, sideLabelServiceCreds);
        setSidePanelItem(sidePanelPersonnel, sideLabelPersonnel);
        setSidePanelItem(sidePanelAccountSettings, sideLabelAccountSettings);

        setSidePanelItem(sidePanelLogOut, sideLabeLogOut);

        //first pop-up panel on main container
        selectedPanel(employeeListPanel.displayAll(), sidePanelEmployee, sideLabelEmployee);

        //sidePanelMenu.hide();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        sideContainer = new javax.swing.JPanel();
        sidePanelMenu = new javax.swing.JPanel();
        sidePanelEmployee = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        sideLabelEmployee = new javax.swing.JLabel();
        sidePanelServiceCreds = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        sideLabelServiceCreds = new javax.swing.JLabel();
        sidePanelPersonnel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        sideLabelPersonnel = new javax.swing.JLabel();
        sidePanelAccountSettings = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        sideLabelAccountSettings = new javax.swing.JLabel();
        sidePanelUsers = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        sideLabelUsers = new javax.swing.JLabel();
        sidePanelLogOut = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        sideLabeLogOut = new javax.swing.JLabel();
        mainContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(977, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));

        topPanel.setBackground(new java.awt.Color(153, 153, 255));
        topPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("       ");
        jPanel2.add(jLabel1, java.awt.BorderLayout.WEST);

        jLabel2.setIcon(ImageHandler.getLogo(130, 130)
        );
        jPanel2.add(jLabel2, java.awt.BorderLayout.CENTER);

        topPanel.add(jPanel2, java.awt.BorderLayout.WEST);

        jLabel3.setFont(primary.FONT.big(25)
        );
        jLabel3.setForeground(primary.COLOR.foreground_white);
        jLabel3.setText("PNHS Employee Management System(E-Service Credits)");
        topPanel.add(jLabel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new java.awt.BorderLayout());

        sideContainer.setPreferredSize(new java.awt.Dimension(250, 338));
        sideContainer.setLayout(new javax.swing.OverlayLayout(sideContainer));

        sidePanelMenu.setBackground(new java.awt.Color(255, 204, 204));
        sidePanelMenu.setLayout(new java.awt.GridLayout(10, 0));

        sidePanelEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidePanelEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sidePanelEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sidePanelEmployeeMouseExited(evt);
            }
        });
        sidePanelEmployee.setLayout(new java.awt.BorderLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("        ");
        jLabel4.setToolTipText("   ");
        sidePanelEmployee.add(jLabel4, java.awt.BorderLayout.LINE_START);

        sideLabelEmployee.setIcon(new javax.swing.ImageIcon(ImageHandler.getIconPath("/img/icons/employees(1).png")));
        sideLabelEmployee.setText("Employee");
        sidePanelEmployee.add(sideLabelEmployee, java.awt.BorderLayout.CENTER);

        sidePanelMenu.add(sidePanelEmployee);

        sidePanelServiceCreds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidePanelServiceCredsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sidePanelServiceCredsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sidePanelServiceCredsMouseExited(evt);
            }
        });
        sidePanelServiceCreds.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("        ");
        sidePanelServiceCreds.add(jLabel5, java.awt.BorderLayout.LINE_START);

        sideLabelServiceCreds.setIcon(new javax.swing.ImageIcon(ImageHandler.getIconPath("/img/icons/credit-card.png")));
        sideLabelServiceCreds.setText("Service Credits");
        sidePanelServiceCreds.add(sideLabelServiceCreds, java.awt.BorderLayout.CENTER);

        sidePanelMenu.add(sidePanelServiceCreds);

        sidePanelPersonnel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidePanelPersonnelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sidePanelPersonnelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sidePanelPersonnelMouseExited(evt);
            }
        });
        sidePanelPersonnel.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("        ");
        sidePanelPersonnel.add(jLabel6, java.awt.BorderLayout.LINE_START);

        sideLabelPersonnel.setIcon(new javax.swing.ImageIcon(ImageHandler.getIconPath("/img/icons/networking.png")));
        sideLabelPersonnel.setText("Personnels");
        sidePanelPersonnel.add(sideLabelPersonnel, java.awt.BorderLayout.CENTER);

        sidePanelMenu.add(sidePanelPersonnel);

        sidePanelAccountSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidePanelAccountSettingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sidePanelAccountSettingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sidePanelAccountSettingsMouseExited(evt);
            }
        });
        sidePanelAccountSettings.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("        ");
        sidePanelAccountSettings.add(jLabel7, java.awt.BorderLayout.LINE_START);

        sideLabelAccountSettings.setIcon(new javax.swing.ImageIcon(ImageHandler.getIconPath("/img/icons/settings.png")));
        sideLabelAccountSettings.setText("Account Settings");
        sidePanelAccountSettings.add(sideLabelAccountSettings, java.awt.BorderLayout.CENTER);

        sidePanelMenu.add(sidePanelAccountSettings);

        sidePanelUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidePanelUsersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sidePanelUsersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sidePanelUsersMouseExited(evt);
            }
        });
        sidePanelUsers.setLayout(new java.awt.BorderLayout());

        jLabel8.setText("        ");
        sidePanelUsers.add(jLabel8, java.awt.BorderLayout.LINE_START);

        sideLabelUsers.setIcon(new javax.swing.ImageIcon(ImageHandler.getIconPath("/img/icons/software-engineer.png")));
        sideLabelUsers.setText("Users");
        sidePanelUsers.add(sideLabelUsers, java.awt.BorderLayout.CENTER);

        sidePanelMenu.add(sidePanelUsers);

        sidePanelLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidePanelLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sidePanelLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sidePanelLogOutMouseExited(evt);
            }
        });
        sidePanelLogOut.setLayout(new java.awt.BorderLayout());

        jLabel9.setText("        ");
        sidePanelLogOut.add(jLabel9, java.awt.BorderLayout.LINE_START);

        sideLabeLogOut.setIcon(new javax.swing.ImageIcon(ImageHandler.getIconPath("/img/icons/log-out.png")));
        sideLabeLogOut.setText("Log Out");
        sidePanelLogOut.add(sideLabeLogOut, java.awt.BorderLayout.CENTER);

        sidePanelMenu.add(sidePanelLogOut);

        sideContainer.add(sidePanelMenu);

        jPanel1.add(sideContainer, java.awt.BorderLayout.WEST);

        mainContainer.setBackground(new java.awt.Color(255, 204, 204));
        mainContainer.setMinimumSize(new java.awt.Dimension(664, 520));
        mainContainer.setPreferredSize(new java.awt.Dimension(664, 520));
        mainContainer.setLayout(new javax.swing.OverlayLayout(mainContainer));
        jPanel1.add(mainContainer, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sidePanelEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelEmployeeMouseEntered
        mouseEnteredSidePanelItem(sidePanelEmployee);
    }//GEN-LAST:event_sidePanelEmployeeMouseEntered

    private void sidePanelServiceCredsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelServiceCredsMouseEntered
        mouseEnteredSidePanelItem(sidePanelServiceCreds);
    }//GEN-LAST:event_sidePanelServiceCredsMouseEntered

    private void sidePanelPersonnelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelPersonnelMouseEntered
        mouseEnteredSidePanelItem(sidePanelPersonnel);
    }//GEN-LAST:event_sidePanelPersonnelMouseEntered

    private void sidePanelAccountSettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelAccountSettingsMouseEntered
        mouseEnteredSidePanelItem(sidePanelAccountSettings);
    }//GEN-LAST:event_sidePanelAccountSettingsMouseEntered

    private void sidePanelUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelUsersMouseEntered
        mouseEnteredSidePanelItem(sidePanelUsers);
    }//GEN-LAST:event_sidePanelUsersMouseEntered

    private void sidePanelLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelLogOutMouseEntered
        mouseEnteredSidePanelItem(sidePanelLogOut);
    }//GEN-LAST:event_sidePanelLogOutMouseEntered

    private void sidePanelEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelEmployeeMouseExited
        mouseExitedSidePanelItem(sidePanelEmployee);
    }//GEN-LAST:event_sidePanelEmployeeMouseExited

    private void sidePanelServiceCredsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelServiceCredsMouseExited
        mouseExitedSidePanelItem(sidePanelServiceCreds);
    }//GEN-LAST:event_sidePanelServiceCredsMouseExited

    private void sidePanelPersonnelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelPersonnelMouseExited
        mouseExitedSidePanelItem(sidePanelPersonnel);
    }//GEN-LAST:event_sidePanelPersonnelMouseExited

    private void sidePanelAccountSettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelAccountSettingsMouseExited
        mouseExitedSidePanelItem(sidePanelAccountSettings);
    }//GEN-LAST:event_sidePanelAccountSettingsMouseExited

    private void sidePanelUsersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelUsersMouseExited
        mouseExitedSidePanelItem(sidePanelUsers);
    }//GEN-LAST:event_sidePanelUsersMouseExited

    private void sidePanelLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelLogOutMouseExited
        mouseExitedSidePanelItem(sidePanelLogOut);
    }//GEN-LAST:event_sidePanelLogOutMouseExited

    private void sidePanelEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelEmployeeMouseClicked

        selectedPanel(employeeListPanel.displayAll(), sidePanelEmployee, sideLabelEmployee);
        if (sideLabelEmployee.getText().equals("Back to List")) {
            sideLabelEmployee.setText("Employee");
        }

    }//GEN-LAST:event_sidePanelEmployeeMouseClicked

    private void sidePanelServiceCredsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelServiceCredsMouseClicked
        selectedPanel(serviceCreditPanel, sidePanelServiceCreds, sideLabelServiceCreds);
    }//GEN-LAST:event_sidePanelServiceCredsMouseClicked

    private void sidePanelPersonnelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelPersonnelMouseClicked
        selectedPanel(personnelPanel, sidePanelPersonnel, sideLabelPersonnel);
    }//GEN-LAST:event_sidePanelPersonnelMouseClicked

    private void sidePanelAccountSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelAccountSettingsMouseClicked
        selectedPanel(accountSettingPanel, sidePanelAccountSettings, sideLabelAccountSettings);
    }//GEN-LAST:event_sidePanelAccountSettingsMouseClicked

    private void sidePanelUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelUsersMouseClicked
        selectedPanel(userPanel, sidePanelUsers, sideLabelUsers);
    }//GEN-LAST:event_sidePanelUsersMouseClicked

    private void sidePanelLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelLogOutMouseClicked
         int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to Log out?","Log out",JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION){
               BaseClass.user = null;
               LoginFrame frame = new LoginFrame();
               frame.setVisible(true);
               dispose();
            }
    }//GEN-LAST:event_sidePanelLogOutMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainContainer;
    private javax.swing.JPanel sideContainer;
    private javax.swing.JLabel sideLabeLogOut;
    private javax.swing.JLabel sideLabelAccountSettings;
    private javax.swing.JLabel sideLabelEmployee;
    private javax.swing.JLabel sideLabelPersonnel;
    private javax.swing.JLabel sideLabelServiceCreds;
    private javax.swing.JLabel sideLabelUsers;
    private javax.swing.JPanel sidePanelAccountSettings;
    private javax.swing.JPanel sidePanelEmployee;
    private javax.swing.JPanel sidePanelLogOut;
    private javax.swing.JPanel sidePanelMenu;
    private javax.swing.JPanel sidePanelPersonnel;
    private javax.swing.JPanel sidePanelServiceCreds;
    private javax.swing.JPanel sidePanelUsers;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

    private void setSidePanelItem(JPanel panel, JLabel label) {
        panel.setBackground(primary.COLOR.background_primary);
        label.setFont(primary.FONT.big(14));
        label.setForeground(primary.COLOR.foreground_white);

    }

    private void mouseEnteredSidePanelItem(JPanel panel) {
        if (activeSidePanel != panel) {
            panel.setBackground(primary.COLOR.backgroundOnTop);
        }
    }

    private void mouseExitedSidePanelItem(JPanel panel) {
        if (activeSidePanel != panel) {
            panel.setBackground(primary.COLOR.background_primary);
        }
    }

    private void selectedPanel(JPanel main, JPanel side, JLabel sideLabel) {
        if (activeMainPanel != null) {
            activeMainPanel.setVisible(false);
            activeSidePanel.setBackground(primary.COLOR.background_primary);

            Component[] components = activeSidePanel.getComponents();

            for (Component component : components) {
                JLabel label = (JLabel) component;
                label.setForeground(primary.COLOR.foreground_white);
            }

        }
        main.setVisible(true);
        side.setBackground(primary.COLOR.background_secondary);
        sideLabel.setForeground(primary.COLOR.background_primary);

        activeMainPanel = main;
        activeSidePanel = side;
    }

    @Override
    public void onAddEmployeeClick() {

        mainContainer.remove(addEmployeePanel);
        mainContainer.repaint();
        mainContainer.revalidate();

        addEmployeePanel = new AddEmployeePanel(this, null);
        mainContainer.add(addEmployeePanel);

        selectedPanel(addEmployeePanel, sidePanelEmployee, sideLabelEmployee);
        if (sideLabelEmployee.getText().equals("Employee")) {
            sideLabelEmployee.setText("Back to List");
        }
    }

    @Override
    public void onEmployeeProfileExit() {

        mainContainer.remove(employeeProfilePanel);
        mainContainer.remove(employeeServiceCreditsPanel);
        mainContainer.remove(employeeLeaveLogsPanel);
        mainContainer.remove(leaveFormPanel);
        mainContainer.repaint();
        mainContainer.revalidate();

        sideContainer.remove(sidePanelEmployeeProfile);
        sideContainer.repaint();
        sideContainer.revalidate();

        if (addEmployeePanel.isVisible()) {
            addEmployeePanel.setVisible(false);
        }

        sidePanelMenu.setVisible(true);
        selectedPanel(employeeListPanel.displayAll(), sidePanelEmployee, sideLabelEmployee);

    }

    @Override
    public void onSelectedPanelListener(JPanel panel) {

        if (activeProfilePanel != null) {
            activeProfilePanel.setVisible(false);
        }
        panel.setVisible(true);
        activeProfilePanel = panel;

    }

    @Override
    public HashMap<String, JPanel> getPanels(Employee employee) {
        HashMap<String, JPanel> employeePanels = new HashMap<>();
        employeeProfilePanel = new EmployeeProfilePanel(employee);
        employeePanels.put("employee_profile", employeeProfilePanel);
        employeeServiceCreditsPanel = new EmployeeServiceCreditsPanel(this, employee);
        employeePanels.put("employee_service_credits", employeeServiceCreditsPanel);
        employeeLeaveLogsPanel = new EmployeeLeaveLogsPanel(employee);
        employeePanels.put("employee_leave_logs", employeeLeaveLogsPanel);
        leaveFormPanel = new LeaveFormPanel(this,employee);
         employeePanels.put("leave_form", leaveFormPanel);

        mainContainer.add(employeeProfilePanel).setVisible(false);
        mainContainer.add(employeeServiceCreditsPanel).setVisible(false);
        mainContainer.add(employeeLeaveLogsPanel).setVisible(false);
        mainContainer.add(leaveFormPanel).setVisible(false);
        return employeePanels;
    }

    @Override
    public JPanel onEditEmployeeListener(String text, Employee employee) {
        if (text.equals("Edit")) {

            mainContainer.remove(addEmployeePanel);
            mainContainer.repaint();
            mainContainer.revalidate();

            addEmployeePanel = new AddEmployeePanel(this, employee);

            mainContainer.add(addEmployeePanel);

            addEmployeePanel.setVisible(true);
            employeeProfilePanel.setVisible(false);
        } else {

            addEmployeePanel.setVisible(false);
            employeeProfilePanel.setVisible(true);
        }
        return addEmployeePanel;
    }

    @Override
    public void onFinishProfileEdit(String id) {
        addEmployeePanel.setVisible(false);
        employeeProfilePanel.refreshEmployee(id);
        employeeProfilePanel.setVisible(true);

    }

    @Override
    public void onEmployeeProfileClick(Employee employee) {

        onEmployeeProfileClick(false, employee,null);

    }

    @Override
    public void onOpeningLeaveForm(Employee employee,EmployeeServiceCredit employeeServiceCredit ) {
       
        onEmployeeProfileClick(true, employee,employeeServiceCredit);

    }

    private void onEmployeeProfileClick(boolean openLeaveForm, Employee employee,EmployeeServiceCredit employeeServiceCredit) {
        sidePanelMenu.setVisible(false);
        activeMainPanel.setVisible(false);
    
        if (sidePanelEmployeeProfile != null) {
          
            sideContainer.remove(sidePanelEmployeeProfile);
            sideContainer.repaint();
            sideContainer.revalidate();
        }

        sidePanelEmployeeProfile = new SidePanelEmployeeProfile(this, employee, openLeaveForm);
       
       if(openLeaveForm) sidePanelEmployeeProfile.setLeaveFormServiceCredit(employeeServiceCredit);
        sideContainer.add(sidePanelEmployeeProfile).setVisible(true);
    }

   
}
