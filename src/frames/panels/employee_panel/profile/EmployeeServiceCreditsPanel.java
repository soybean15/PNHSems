/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.panels.employee_panel.profile;

import data.controllers.EmployeeController;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.ServiceCredit;
import frames.MainFrame;
import frames.components.EmployeeServiceCreditItem;
import frames.components.windows.AddServiceCreditWindow;
import java.awt.GridLayout;
import java.util.List;
import java.sql.SQLException;
import javax.swing.JDialog;
import themes.Theme;

/**
 *
 * @author root
 */
public class EmployeeServiceCreditsPanel extends javax.swing.JPanel {

    /**
     * Creates new form EmployeeServiceCreditsPanel
     */
    private Employee employee;
    EmployeeController controller = new EmployeeController();
    List<EmployeeServiceCredit> employeesWithServiceCredits;
     MainFrame frame;
    public EmployeeServiceCreditsPanel(MainFrame frame, Employee employee) {
        this.employee = employee;
        this.frame=frame;
        initComponents();
        
        
        try{
            employeesWithServiceCredits = controller.getEmployeeServiceCredits(this.employee.getId());
        }catch(SQLException e){
            e.printStackTrace();
        }
        display( employeesWithServiceCredits);
    }
    
    private void display(List<EmployeeServiceCredit> employeesWithServiceCredits){
        serviceCreditList.removeAll();
        serviceCreditList.repaint();
        serviceCreditList.revalidate();
        int size = employeesWithServiceCredits.size();
        int row = size;
        if(row <9){
            row =8;
        }
        serviceCreditList.setLayout(new GridLayout(row,0));
        
        int index=0;
        for(EmployeeServiceCredit item :employeesWithServiceCredits){
            serviceCreditList.add(new EmployeeServiceCreditItem(index, item));
            index++;
        }
        
    }
    
    public int addServiceCredit(int serviceCreditId) {
        try {
            int n = controller.addServiceCredit(employee.getId(), serviceCreditId);

            employeesWithServiceCredits = controller.getEmployeeServiceCredits(this.employee.getId());
            display(employeesWithServiceCredits);
            return n;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblOrderNo = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblMemorandum = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lblDays = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        serviceCreditList = new javax.swing.JPanel();

        setBackground(Theme.PRIMARY.COLOR.background_secondary);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(20, 324));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(20, 324));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(668, 150));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(20, 150));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(20, 150));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.LINE_END);

        add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(employee.getFirstName()+"'s Service Credits"));
        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.BorderLayout());

        jPanel9.setMinimumSize(new java.awt.Dimension(756, 50));
        jPanel9.setOpaque(false);
        jPanel9.setPreferredSize(new java.awt.Dimension(451, 50));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));
        jPanel10.setMaximumSize(new java.awt.Dimension(200, 50));
        jPanel10.setMinimumSize(new java.awt.Dimension(150, 100));
        jPanel10.setOpaque(false);
        jPanel10.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel10.setLayout(new java.awt.GridLayout());

        lblOrderNo.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
        );
        lblOrderNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrderNo.setText("Order Number");
        jPanel10.add(lblOrderNo);

        jPanel9.add(jPanel10, java.awt.BorderLayout.WEST);

        jPanel11.setBackground(new java.awt.Color(255, 204, 204));
        jPanel11.setMaximumSize(new java.awt.Dimension(400, 2147483647));
        jPanel11.setMinimumSize(new java.awt.Dimension(290, 50));
        jPanel11.setOpaque(false);
        jPanel11.setPreferredSize(new java.awt.Dimension(290, 50));
        jPanel11.setLayout(new java.awt.GridLayout());

        lblMemorandum.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
        );
        lblMemorandum.setText("Memorandum");
        jPanel11.add(lblMemorandum);

        jPanel9.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel12.setMinimumSize(new java.awt.Dimension(200, 50));
        jPanel12.setOpaque(false);
        jPanel12.setPreferredSize(new java.awt.Dimension(270, 0));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(204, 255, 204));
        jPanel13.setMaximumSize(new java.awt.Dimension(80, 2147483647));
        jPanel13.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel13.setOpaque(false);
        jPanel13.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel13.setRequestFocusEnabled(false);
        jPanel13.setLayout(new java.awt.GridLayout());

        lblDays.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
        );
        lblDays.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDays.setText("Credits");
        jPanel13.add(lblDays);

        jPanel12.add(jPanel13, java.awt.BorderLayout.WEST);

        jPanel14.setOpaque(false);
        jPanel14.setPreferredSize(new java.awt.Dimension(120, 50));
        jPanel14.setRequestFocusEnabled(false);
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel1.setText(" ");
        jLabel1.setPreferredSize(new java.awt.Dimension(4, 10));
        jPanel14.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText(" ");
        jLabel2.setPreferredSize(new java.awt.Dimension(4, 10));
        jPanel14.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.setPreferredSize(new java.awt.Dimension(60, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton1, java.awt.BorderLayout.EAST);

        jPanel12.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel12, java.awt.BorderLayout.EAST);

        jPanel15.add(jPanel9, java.awt.BorderLayout.NORTH);

        jScrollPane1.setBackground(new java.awt.Color(102, 0, 102));
        jScrollPane1.setBorder(null);

        serviceCreditList.setBackground(Theme.PRIMARY.COLOR.background_secondary);

        javax.swing.GroupLayout serviceCreditListLayout = new javax.swing.GroupLayout(serviceCreditList);
        serviceCreditList.setLayout(serviceCreditListLayout);
        serviceCreditListLayout.setHorizontalGroup(
            serviceCreditListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );
        serviceCreditListLayout.setVerticalGroup(
            serviceCreditListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(serviceCreditList);

        jPanel15.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel15, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
            List<ServiceCredit> availableServiceCredits  = controller.getAvailableServiceCredit(employee.getId());
            
         
            
            AddServiceCreditWindow serviceCreditWindow = new AddServiceCreditWindow();
             serviceCreditWindow.setFrame(frame,this, availableServiceCredits);
            frame.setEnabled(false);
           //  JDialog modal = new JDialog(serviceCreditWindow, "This is a modal!", true);
           
           
            serviceCreditWindow.setVisible(true);
       }catch(SQLException e){
           e.printStackTrace();
       }
       
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDays;
    private javax.swing.JLabel lblMemorandum;
    private javax.swing.JLabel lblOrderNo;
    private javax.swing.JPanel serviceCreditList;
    // End of variables declaration//GEN-END:variables
}
