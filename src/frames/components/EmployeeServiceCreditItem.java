/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.components;

import data.controllers.EmployeeController;
import data.model.EmployeeServiceCredit;
import frames.listener.EmployeeServiceCreditListener;
import java.awt.Color;
import themes.Theme;


/**
 *
 * @author root
 */
public class EmployeeServiceCreditItem extends javax.swing.JPanel {

    /**
     * Creates new form EmployeeServiceCreditItem
     */
    private final int index;
    private final EmployeeServiceCredit employeeServiceCredit;

    EmployeeServiceCreditListener listener;

    public EmployeeServiceCreditItem(EmployeeServiceCreditListener listener, int index, EmployeeServiceCredit employeeServiceCredit) {
        initComponents();
        this.index = index;
        this.employeeServiceCredit = employeeServiceCredit;
        this.listener = listener;

        setDetails();
        setBackground();
    }

    private void setDetails() {
        lblOrderNo.setText(employeeServiceCredit.getServiceCredit().getOrderNo());
        lblMemorandum.setText(employeeServiceCredit.getServiceCredit().getMemorandum());
        String remaining = String.valueOf(employeeServiceCredit.getNo_of_days());
        String total = String.valueOf(employeeServiceCredit.getServiceCredit().getNumberOfDays());
        lblDays.setText(remaining + "/" + total);
    }

    private void setBackground() {
        if (this.index % 2 == 0) {
            this.setBackground(new Color(204, 230, 192));
        }
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
        lblOrderNo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblMemorandum = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblDays = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(756, 50));
        setPreferredSize(new java.awt.Dimension(451, 50));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(200, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(150, 100));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        lblOrderNo.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        lblOrderNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrderNo.setText("order number");
        jPanel1.add(lblOrderNo);

        add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(500, 2147483647));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 50));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        lblMemorandum.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        lblMemorandum.setText("memorandum");
        jPanel2.add(lblMemorandum);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel5.setMinimumSize(new java.awt.Dimension(200, 50));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(250, 0));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setMaximumSize(new java.awt.Dimension(80, 2147483647));
        jPanel3.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel3.setRequestFocusEnabled(false);
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        lblDays.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        lblDays.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDays.setText("days");
        jPanel3.add(lblDays);

        jPanel5.add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel4.setRequestFocusEnabled(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jButton1.setText("Use");
        jButton1.setPreferredSize(new java.awt.Dimension(70, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, java.awt.BorderLayout.WEST);

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, java.awt.BorderLayout.CENTER);

        jLabel1.setText(" ");
        jLabel1.setPreferredSize(new java.awt.Dimension(4, 10));
        jPanel4.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText(" ");
        jLabel2.setPreferredSize(new java.awt.Dimension(4, 10));
        jPanel4.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        jPanel5.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel5, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       listener.use(employeeServiceCredit);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        listener.delete(employeeServiceCredit);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblDays;
    private javax.swing.JLabel lblMemorandum;
    private javax.swing.JLabel lblOrderNo;
    // End of variables declaration//GEN-END:variables
}
