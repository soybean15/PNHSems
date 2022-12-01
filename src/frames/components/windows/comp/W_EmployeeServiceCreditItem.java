/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.components.windows.comp;

import data.model.EmployeeServiceCredit;
import frames.components.windows.listener.EmployeeServiceCreditItemListener;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author root
 */
public class W_EmployeeServiceCreditItem extends javax.swing.JPanel {

    /**
     * Creates new form W_EmployeeServiceCreditItem
     */
    int previous;
    private EmployeeServiceCredit employeeServiceCredit;
    EmployeeServiceCreditItemListener listener;

    public W_EmployeeServiceCreditItem(EmployeeServiceCreditItemListener listener, EmployeeServiceCredit employeeServiceCredit) {
        this.employeeServiceCredit = employeeServiceCredit;
        this.listener = listener;
        initComponents();
        setUpPanel();

        previous = Integer.parseInt(spinnerUse.getValue().toString());
    }

    private void setUpPanel() {
        lblOrderNumber.setText(employeeServiceCredit.getServiceCredit().getOrderNo());
        lblMemorandum.setText(employeeServiceCredit.getServiceCredit().getMemorandum());

        int defaultValue = employeeServiceCredit.getDays_used();
        int lowerBound = 0;
        int upperBound = employeeServiceCredit.getNo_of_days();
        int remaining = upperBound - defaultValue;

        lblRemaining.setText(String.valueOf(remaining));
        SpinnerNumberModel sm = new SpinnerNumberModel(defaultValue, lowerBound, upperBound, 1);
        spinnerUse.setModel(sm);

        spinnerUse.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = Integer.parseInt(spinnerUse.getValue().toString());
                int remaining = Integer.parseInt(lblRemaining.getText());

                employeeServiceCredit.setDays_used(value);
                if (previous <= value) {
                    remaining -= 1;
                 //   employeeServiceCredit.setNo_of_days(remaining);
                    listener.onSpinnerClick(true, employeeServiceCredit);

                } else {
                    remaining += 1;
                 //   employeeServiceCredit.setNo_of_days(remaining);
                    listener.onSpinnerClick(false, employeeServiceCredit);

                }

                previous = value;
                lblRemaining.setText(String.valueOf(remaining));

            }

        });
    }

    public EmployeeServiceCredit getEmployeeServiceCredit() {
        System.out.println(employeeServiceCredit.getServiceCredit().getMemorandum());
        return this.employeeServiceCredit;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOrderNumber = new javax.swing.JLabel();
        lblMemorandum = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblRemaining = new javax.swing.JLabel();
        spinnerUse = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        lblOrderNumber.setText("Order Number");
        lblOrderNumber.setPreferredSize(new java.awt.Dimension(100, 17));
        add(lblOrderNumber, java.awt.BorderLayout.WEST);

        lblMemorandum.setText("Memorandum");
        add(lblMemorandum, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        lblRemaining.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRemaining.setText("1");
        jPanel1.add(lblRemaining);

        spinnerUse.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerUseStateChanged(evt);
            }
        });
        spinnerUse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spinnerUseMouseClicked(evt);
            }
        });
        jPanel1.add(spinnerUse);

        jPanel2.add(jPanel1, java.awt.BorderLayout.LINE_END);
        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);
        jPanel2.add(jPanel4, java.awt.BorderLayout.SOUTH);

        add(jPanel2, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void spinnerUseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spinnerUseMouseClicked

    }//GEN-LAST:event_spinnerUseMouseClicked


    private void spinnerUseStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerUseStateChanged

    }//GEN-LAST:event_spinnerUseStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblMemorandum;
    private javax.swing.JLabel lblOrderNumber;
    private javax.swing.JLabel lblRemaining;
    private javax.swing.JSpinner spinnerUse;
    // End of variables declaration//GEN-END:variables
}
