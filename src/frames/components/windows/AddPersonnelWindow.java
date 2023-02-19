/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames.components.windows;

import data.controllers.EmployeeController;
import data.model.Employee;
import data.model.Personnel;
import frames.panels.PersonnelPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import themes.Theme;

/**
 *
 * @author root
 */
public class AddPersonnelWindow extends javax.swing.JFrame {

    /**
     * Creates new form AddPersonnelWindow
     */
    EmployeeController controller = new EmployeeController();

    List<Personnel> personnels;
    JLabel activeLabel;
    Personnel selectedPersonnel;
    
    JPanel parent;
    int personnelId;

    public AddPersonnelWindow() {
        initComponents();

        personnels = new ArrayList<>();
//
//        Employee employee = new Employee();
//        employee.setFirstName("Marlon");
//        employee.setLastName("Padilla");
//        personnels.add(new Personnel(1, new Position(), employee));
//        personnels.add(new Personnel(1, new Position(), employee));
//        personnels.add(new Personnel(1, new Position(), employee));

        populateList();
    }
    
    
    public void setFrame(int personnelId, JPanel parent,List<Personnel> personnels){
        this.parent=parent;
        this.personnels = personnels;
        this.personnelId = personnelId;
    }

    private void populateList() {
        
        selectedPersonnel = null;
        int size = personnels.size() + 3;

        mainContainer.removeAll();
        mainContainer.repaint();
        mainContainer.revalidate();

        mainContainer.setLayout(new GridLayout(size, 0));

        if (personnels.isEmpty()) {
            JLabel label = new JLabel("No data available");

            label.setBackground(Color.WHITE);
            label.setFont(Theme.PRIMARY.FONT.defaultFont(15));
            label.setForeground(Color.black);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            mainContainer.add(label);
        } else {
            for (Personnel personnel : personnels) {
                JLabel label = new JLabel(" " + personnel.getEmployee().getFullname());
                label.setOpaque(true);
                label.setBackground(Color.WHITE);
                label.setFont(Theme.PRIMARY.FONT.defaultFont(15));
                label.setForeground(Color.black);

                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (activeLabel != null) {
                            activeLabel.setBackground(Color.WHITE);
                            activeLabel.setForeground(Color.black);
                        }
                        label.setBackground(Color.BLUE);
                        label.setForeground(Color.white);
                        activeLabel = label;
                        selectedPersonnel = personnel;

                    }

                });

                mainContainer.add(label);
            }
        }

    }

    private List<Personnel> employeeToPersonnel(List<Employee> employees) {
        List<Personnel> _personnels = new ArrayList<>();
        for (Employee employee : employees) {
            Personnel personnel = new Personnel();
            personnel.setEmployee(employee);
            _personnels.add(personnel);
        }
        return _personnels;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainContainer = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        setUndecorated(true);

        mainContainer.setBorder(javax.swing.BorderFactory.createTitledBorder("Employees"));
        mainContainer.setPreferredSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout mainContainerLayout = new javax.swing.GroupLayout(mainContainer);
        mainContainer.setLayout(mainContainerLayout);
        mainContainerLayout.setHorizontalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        mainContainerLayout.setVerticalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        getContentPane().add(mainContainer, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 240, 30));

        jLabel1.setText("Search");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jButton1.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 70, 30));

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jButton3.setText("Ok");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel1.setPreferredSize(new java.awt.Dimension(10, 200));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel4.setPreferredSize(new java.awt.Dimension(10, 200));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String item = txtSearch.getText();
            List<Employee> employees = controller.searchEmployees(item);

            personnels = employeeToPersonnel(employees);
            populateList();

        } catch (java.sql.SQLException e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       PersonnelPanel panel = (PersonnelPanel)parent;
       
       if(selectedPersonnel!=null){
           selectedPersonnel.setId(this.personnelId);
       
           panel.updatePersonel(selectedPersonnel);
           dispose();
       }else{
           
           JOptionPane.showMessageDialog(this, "No Item Selected");
       }
       
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AddPersonnelWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPersonnelWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPersonnelWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPersonnelWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPersonnelWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel mainContainer;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
