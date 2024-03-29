/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.panels;

import data.controllers.UserController;
import data.controllers.form.UserValidation;
import data.model.User;
import javax.swing.JOptionPane;
import otherclasses.BaseClass;
import pnhsems.InvalidInputException;

/**
 *
 * @author root
 */
public class AccountSettingPanel extends javax.swing.JPanel {

    /**
     * Creates new form AccountSettingPanel
     */
    UserController controller = new UserController();

    public AccountSettingPanel() {
        initComponents();

        txtName.setText(BaseClass.user.getName());
        txtEmail.setText(BaseClass.user.getEmail());

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
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        txtOld = new javax.swing.JPasswordField();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtNew = new javax.swing.JPasswordField();
        jPanel12 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(5, 0));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("   Name:");
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel2.add(jLabel1, java.awt.BorderLayout.WEST);
        jPanel2.add(txtName, java.awt.BorderLayout.CENTER);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel2.add(jPanel3, java.awt.BorderLayout.EAST);

        jPanel1.add(jPanel2);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("   Email:");
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel6.add(jLabel2, java.awt.BorderLayout.WEST);
        jPanel6.add(txtEmail, java.awt.BorderLayout.CENTER);

        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel6.add(jPanel7, java.awt.BorderLayout.EAST);

        jPanel1.add(jPanel6);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("   Old Password:");
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel8.add(jLabel3, java.awt.BorderLayout.WEST);

        jPanel9.setOpaque(false);
        jPanel9.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel8.add(jPanel9, java.awt.BorderLayout.EAST);
        jPanel8.add(txtOld, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel8);

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("   New Password:");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel10.add(jLabel4, java.awt.BorderLayout.WEST);

        jPanel11.setOpaque(false);
        jPanel11.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel10.add(jPanel11, java.awt.BorderLayout.EAST);
        jPanel10.add(txtNew, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel10);

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.BorderLayout());

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanel13.setOpaque(false);
        jPanel13.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel12.add(jPanel13, java.awt.BorderLayout.LINE_END);

        jPanel14.setOpaque(false);
        jPanel14.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel12.add(jPanel14, java.awt.BorderLayout.LINE_START);

        jPanel1.add(jPanel12);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 70));
        add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 300));
        add(jPanel5, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        User user = new User();
        user.setUserName(BaseClass.user.getUserName());
        user.setRole(BaseClass.user.getRole());
        user.setEnable(BaseClass.user.isEnable());
        
        boolean email = false;
        boolean name = false;
        boolean password = false;

        try {

            if (UserValidation.validateEmail(txtEmail.getText())) {
                user.setEmail(txtEmail.getText());
                email = true;
            }else throw new InvalidInputException("Invalid Email");
               
           

            if (UserValidation.checkField(txtName.getText()) != null) {
                user.setName(txtName.getText());
                name = true;
            }else throw new InvalidInputException("Invalid Name");

            if (UserValidation.checkField(txtOld.getText()) != null) {
                try {
                    if (controller.checkUser(BaseClass.user.getUserName(), txtOld.getText())) {
                        if (UserValidation.checkField(txtNew.getText()) != null) {
                            user.setPassword(txtNew.getText());
                            password = true;

                        }else throw new InvalidInputException("Password Mismatch");

                    }else throw new InvalidInputException("Incorrect Password");

                } catch (java.sql.SQLException e) {
                    e.printStackTrace();

                }
            }

            if (email && name && password) {
                try {
                    controller.updateUser(user);
                    
                    JOptionPane.showMessageDialog(this, "User Updated");
                    

                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Something went wrong");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all inputs");
            }

        } catch (InvalidInputException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
         txtOld.setText("");
         txtNew.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtNew;
    private javax.swing.JPasswordField txtOld;
    // End of variables declaration//GEN-END:variables
}
