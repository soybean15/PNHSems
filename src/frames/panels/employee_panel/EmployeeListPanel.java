/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.panels.employee_panel;

import data.controllers.EmployeeController;
import data.model.Employee;
import data.model.Position;
import frames.components.EmployeeItem;
import frames.listener.EmployeeItemListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import themes.Theme;
import java.sql.SQLException;
import javax.swing.border.MatteBorder;
import frames.listener.MainPanelListener;
import otherclasses.ImageHandler;

/**
 *
 * @author root
 */
public class EmployeeListPanel extends javax.swing.JPanel implements EmployeeItemListener {

    EmployeeController employeeController = new EmployeeController();

    EmployeeItem activeItem;

    
    MainPanelListener listener ;

    /**
     * Creates new form EmployeeListPanel
     * @param listener
     */
    public EmployeeListPanel(MainPanelListener listener ) {
        initComponents();
        
        btn1.setVisible(false);
        btn2.setVisible(false);

       this.listener = listener;

        txtSearch.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

    }
    
    public EmployeeListPanel displayAll() {
        try {
            displayEmployees(employeeController.getAllEmployees());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this;
    }

    private void displayEmployees(List<Employee> employees) {

        employeeList.removeAll();
        employeeList.repaint();
        employeeList.revalidate();

        int size = employees.size();
        int rows = size;
        if (size < 9) {
            rows = 8;
        }

        employeeList.setLayout(new GridLayout(rows, 0));

        int index = 0;
        for (Employee employee : employees) {

            employeeList.add(new EmployeeItem(this, employee, index));
            index++;

        }

    }

    private void disPlayEmployeeDetails(EmployeeItem employeeItem) {
        Employee employee = employeeItem.getEmployee();

        lblId.setText("ID: " + employee.getId());
        lblFirstname.setText(employee.getFirstName());
      
        lblLastname.setText( employee.getLastName() + " " + employee.getNameExtension());
        lblMiddlename.setText(employee.getMiddleName());
        lblGender.setText(employee.getGender());
        lblBday.setText(String.valueOf(employee.getBirthDate()));
        lblPob.setText(employee.getPlaceOfBirth());
        lblDateCreated.setText(String.valueOf(employee.getCreated_at()));
        
        lblImage.setIcon(ImageHandler.getImage(190, 190, employee));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        panelImage = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel2 = new javax.swing.JLabel();
        lblFirstname = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jLabel4 = new javax.swing.JLabel();
        lblLastname = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        jLabel6 = new javax.swing.JLabel();
        lblMiddlename = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jLabel8 = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jSplitPane5 = new javax.swing.JSplitPane();
        jLabel10 = new javax.swing.JLabel();
        lblBday = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jSplitPane6 = new javax.swing.JSplitPane();
        jLabel12 = new javax.swing.JLabel();
        lblPob = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jSplitPane7 = new javax.swing.JSplitPane();
        label4 = new javax.swing.JLabel();
        lblDateCreated = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeList = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblName2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        lblId3 = new javax.swing.JLabel();
        lblName4 = new javax.swing.JLabel();
        lblPosition3 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();

        setBackground(Theme.PRIMARY.COLOR.background_secondary);
        setLayout(new java.awt.GridLayout(2, 0));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel14.setBackground(Theme.PRIMARY.COLOR.background_secondary);
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelImage.setBackground(new java.awt.Color(255, 204, 204));
        panelImage.setLayout(new java.awt.GridLayout());

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelImage.add(lblImage);

        jPanel14.add(panelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 190, 190));

        lblId.setFont(Theme.PRIMARY.FONT.tableFontBig(10)
        );
        lblId.setText("ID: --");
        jPanel14.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 190, 30));

        jPanel3.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(8, 0));

        jLabel1.setFont(Theme.PRIMARY.FONT.big(13)
        );
        jLabel1.setText("Employee's Basic Information");
        jPanel4.add(jLabel1);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jSplitPane1.setDividerLocation(105);
        jSplitPane1.setDividerSize(0);

        jLabel2.setFont(Theme.PRIMARY.FONT.tableFontBig(9
        ));
        jLabel2.setText("Firstname:");
        jSplitPane1.setLeftComponent(jLabel2);

        lblFirstname.setFont(Theme.PRIMARY.FONT.defaultFont(13)
        );
        lblFirstname.setText("- -");
        jSplitPane1.setRightComponent(lblFirstname);

        jPanel5.add(jSplitPane1);

        jPanel4.add(jPanel5);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jSplitPane2.setDividerLocation(105);
        jSplitPane2.setDividerSize(0);

        jLabel4.setFont(Theme.PRIMARY.FONT.tableFontBig(9
        ));
        jLabel4.setText("LastName:");
        jSplitPane2.setLeftComponent(jLabel4);

        lblLastname.setFont(Theme.PRIMARY.FONT.defaultFont(13)
        );
        lblLastname.setText("- -");
        jSplitPane2.setRightComponent(lblLastname);

        jPanel6.add(jSplitPane2);

        jPanel4.add(jPanel6);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jSplitPane3.setDividerLocation(105);
        jSplitPane3.setDividerSize(0);

        jLabel6.setFont(Theme.PRIMARY.FONT.tableFontBig(9
        ));
        jLabel6.setText("MiddleName:");
        jSplitPane3.setLeftComponent(jLabel6);

        lblMiddlename.setFont(Theme.PRIMARY.FONT.defaultFont(13)
        );
        lblMiddlename.setText("- -");
        jSplitPane3.setRightComponent(lblMiddlename);

        jPanel7.add(jSplitPane3);

        jPanel4.add(jPanel7);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        jSplitPane4.setDividerLocation(105);
        jSplitPane4.setDividerSize(0);

        jLabel8.setFont(Theme.PRIMARY.FONT.tableFontBig(9
        ));
        jLabel8.setText("Gender:");
        jSplitPane4.setLeftComponent(jLabel8);

        lblGender.setFont(Theme.PRIMARY.FONT.defaultFont(13)
        );
        lblGender.setText("- -");
        jSplitPane4.setRightComponent(lblGender);

        jPanel8.add(jSplitPane4);

        jPanel4.add(jPanel8);

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jSplitPane5.setDividerLocation(105);
        jSplitPane5.setDividerSize(0);

        jLabel10.setFont(Theme.PRIMARY.FONT.tableFontBig(9
        ));
        jLabel10.setText("BirthDate:");
        jSplitPane5.setLeftComponent(jLabel10);

        lblBday.setFont(Theme.PRIMARY.FONT.defaultFont(13)
        );
        lblBday.setText("- -");
        jSplitPane5.setRightComponent(lblBday);

        jPanel9.add(jSplitPane5);

        jPanel4.add(jPanel9);

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        jSplitPane6.setDividerLocation(105);
        jSplitPane6.setDividerSize(0);

        jLabel12.setFont(Theme.PRIMARY.FONT.tableFontBig(9
        ));
        jLabel12.setText("Place of Birth:");
        jSplitPane6.setLeftComponent(jLabel12);

        lblPob.setFont(Theme.PRIMARY.FONT.defaultFont(13)
        );
        lblPob.setText("- -");
        jSplitPane6.setRightComponent(lblPob);

        jPanel10.add(jSplitPane6);

        jPanel4.add(jPanel10);

        jPanel11.setOpaque(false);
        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        jSplitPane7.setDividerLocation(105);
        jSplitPane7.setDividerSize(0);

        label4.setFont(Theme.PRIMARY.FONT.tableFontBig(9
        ));
        label4.setText("Date created:");
        jSplitPane7.setLeftComponent(label4);

        lblDateCreated.setFont(Theme.PRIMARY.FONT.defaultFont(13)
        );
        lblDateCreated.setText("- -");
        jSplitPane7.setRightComponent(lblDateCreated);

        jPanel11.add(jSplitPane7);

        jPanel4.add(jPanel11);

        jPanel1.add(jPanel4);

        add(jPanel1);

        jPanel12.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        employeeList.setOpaque(false);
        employeeList.setLayout(new java.awt.GridLayout(8, 0));
        jScrollPane1.setViewportView(employeeList);

        jPanel12.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel13.setBackground(new java.awt.Color(0, 204, 204));
        jPanel13.setMinimumSize(new java.awt.Dimension(364, 70));
        jPanel13.setPreferredSize(new java.awt.Dimension(920, 70));
        jPanel13.setLayout(new java.awt.GridLayout(2, 0));

        jPanel17.setBackground(new java.awt.Color(204, 230, 192));
        jPanel17.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17formMouseClicked(evt);
            }
        });
        jPanel17.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("  ");
        jPanel17.add(jLabel3, new java.awt.GridBagConstraints());

        txtSearch.setBorder(new javax.swing.border.MatteBorder(null));
        txtSearch.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.4;
        jPanel17.add(txtSearch, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setFont(Theme.PRIMARY.FONT.tableFontDefault(15)
        );
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton1, new java.awt.GridBagConstraints());

        lblName2.setBackground(new java.awt.Color(102, 255, 102));
        lblName2.setFont(new java.awt.Font("Liberation Mono", 0, 12)); // NOI18N
        lblName2.setMaximumSize(new java.awt.Dimension(60, 40));
        lblName2.setMinimumSize(new java.awt.Dimension(70, 40));
        lblName2.setPreferredSize(new java.awt.Dimension(70, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.9;
        jPanel17.add(lblName2, gridBagConstraints);

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setFont(Theme.PRIMARY.FONT.tableFontDefault(15)
        );
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton2, new java.awt.GridBagConstraints());

        jLabel5.setText("  ");
        jPanel17.add(jLabel5, new java.awt.GridBagConstraints());

        jPanel13.add(jPanel17);

        jScrollPane2.setBorder(null);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel22formMouseClicked(evt);
            }
        });
        jPanel22.setLayout(new java.awt.GridBagLayout());

        lblId3.setBackground(new java.awt.Color(102, 255, 102));
        lblId3.setFont(new java.awt.Font("Liberation Mono", 1, 13)); // NOI18N
        lblId3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblId3.setText("id");
        lblId3.setMaximumSize(new java.awt.Dimension(60, 40));
        lblId3.setMinimumSize(new java.awt.Dimension(70, 40));
        lblId3.setPreferredSize(new java.awt.Dimension(70, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.7;
        jPanel22.add(lblId3, gridBagConstraints);

        lblName4.setBackground(new java.awt.Color(102, 255, 102));
        lblName4.setFont(new java.awt.Font("Liberation Mono", 1, 13)); // NOI18N
        lblName4.setText("Full name");
        lblName4.setMaximumSize(new java.awt.Dimension(60, 40));
        lblName4.setMinimumSize(new java.awt.Dimension(70, 40));
        lblName4.setPreferredSize(new java.awt.Dimension(70, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.9;
        jPanel22.add(lblName4, gridBagConstraints);

        lblPosition3.setBackground(new java.awt.Color(102, 255, 102));
        lblPosition3.setFont(new java.awt.Font("Liberation Mono", 1, 13)); // NOI18N
        lblPosition3.setText("  Position");
        lblPosition3.setMaximumSize(new java.awt.Dimension(60, 40));
        lblPosition3.setMinimumSize(new java.awt.Dimension(70, 40));
        lblPosition3.setPreferredSize(new java.awt.Dimension(70, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        jPanel22.add(lblPosition3, gridBagConstraints);

        jPanel23.setOpaque(false);
        jPanel23.setPreferredSize(new java.awt.Dimension(156, 23));
        jPanel23.setLayout(new java.awt.GridLayout(1, 0));

        btn1.setText("View");
        jPanel23.add(btn1);

        btn2.setText("Add");
        btn2.setToolTipText("Add Service Credit");
        jPanel23.add(btn2);

        jPanel22.add(jPanel23, new java.awt.GridBagConstraints());

        jScrollPane2.setViewportView(jPanel22);

        jPanel13.add(jScrollPane2);

        jPanel12.add(jPanel13, java.awt.BorderLayout.NORTH);

        add(jPanel12);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel17formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17formMouseClicked

    private void jPanel22formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel22formMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        listener.onAddEmployeeClick();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            displayEmployees(employeeController.searchEmployees(txtSearch.getText()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JPanel employeeList;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JSplitPane jSplitPane5;
    private javax.swing.JSplitPane jSplitPane6;
    private javax.swing.JSplitPane jSplitPane7;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel lblBday;
    private javax.swing.JLabel lblDateCreated;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblId3;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblMiddlename;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblName4;
    private javax.swing.JLabel lblPob;
    private javax.swing.JLabel lblPosition3;
    private javax.swing.JPanel panelImage;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onEmployeeItemClick(EmployeeItem employeeitem) {
        disPlayEmployeeDetails(employeeitem);
        if (activeItem != null) {
            activeItem.defaultFont();
        }
        employeeitem.bigFont();
        activeItem = employeeitem;
    }

    @Override
    public void onViewEmployeeClick(Employee employee) {
        listener.onEmployeeProfileClick(employee);
    }
}
