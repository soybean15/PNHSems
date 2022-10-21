/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import data.controllers.UserController;
import data.model.User;
import data.dao.implement.UserDaoImplement;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pnhsems.InvalidInputException;
import themes.Theme;

/**
 *
 * @author root
 */
public class LoginFrame extends javax.swing.JFrame {
    
    UserController controller = new UserController();

    /**
     * Creates new form LoginFrame
     */
    Theme primary = Theme.PRIMARY;

    JLabel selectedLabel;
    JPanel selectedPanel;
    
    boolean username, password, name,email;

  
  

    public LoginFrame() {
        initComponents();
        init();
    }
    
    

    private void init() {
        //set up frame
        jLabel1.setBackground(primary.COLOR.background_primary);
        jLabel1.setForeground(primary.COLOR.foreground_primary);
        jLabel1.setFont(primary.FONT.defaultFont(14));

        jLabel2.setBackground(primary.COLOR.background_primary);
        jLabel2.setForeground(primary.COLOR.foreground_primary);
        jLabel2.setFont(primary.FONT.defaultFont(14));

        jLabel4.setBackground(primary.COLOR.background_primary);

        sidePanel.setBackground(primary.COLOR.background_primary);
        mainPanel.setBackground(primary.COLOR.background_secondary);

        //hide panel
        panelLogin.setVisible(false);
        panelRegister.setVisible(false);

        //panelLogin
        lblLogin.setBackground(primary.COLOR.background_primary);
        lblLogin.setForeground(primary.COLOR.foreground_primary);
        lblLogin.setFont(primary.FONT.defaultFont(13));

       

        selectedLabel(jLabel1, panelLogin);
        hideWarningLabel();
        checkAllField();
        
       
    }
    
    
    
    private void checkAllField(){
        
        if( username && password && name && email){
            
            
        lblSave.setBackground(primary.COLOR.background_primary);
        lblSave.setForeground(primary.COLOR.foreground_primary);
        lblSave.setFont(primary.FONT.defaultFont(13));
            
        }else{
            lblSave.setBackground(new Color(102,102,102));
            lblSave.setForeground(primary.COLOR.foreground_primary);
            lblSave.setFont(primary.FONT.defaultFont(13));
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

        sidePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        panelLogin = new javax.swing.JPanel();
        txtLoginUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtLoginPassword = new javax.swing.JPasswordField();
        lblLogin = new javax.swing.JLabel();
        lblWarning = new javax.swing.JLabel();
        panelRegister = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtRegUsername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRegName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtRegEmail = new javax.swing.JTextField();
        txtRegPassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        lblSave = new javax.swing.JLabel();
        password_warning = new javax.swing.JLabel();
        username_warning = new javax.swing.JLabel();
        name_warning = new javax.swing.JLabel();
        email_warning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setMinimumSize(new java.awt.Dimension(481, 372));
        setResizable(false);
        setSize(new java.awt.Dimension(481, 372));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        getContentPane().add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 390));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 4));

        jLabel1.setFont(new java.awt.Font("AnjaliOldLipi", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });
        jPanel2.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("AnjaliOldLipi", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Register");
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel2MouseReleased(evt);
            }
        });
        jPanel2.add(jLabel2);

        jLabel4.setOpaque(true);
        jPanel2.add(jLabel4);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 300, 40));

        mainPanel.setBackground(new java.awt.Color(30, 30, 30));
        mainPanel.setLayout(new javax.swing.OverlayLayout(mainPanel));

        panelLogin.setOpaque(false);
        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelLogin.add(txtLoginUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 250, 25));

        jLabel3.setFont(new java.awt.Font("AnjaliOldLipi", 1, 14)); // NOI18N
        jLabel3.setText("Username");
        panelLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("AnjaliOldLipi", 1, 14)); // NOI18N
        jLabel5.setText("Password");
        panelLogin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));
        panelLogin.add(txtLoginPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 250, 25));

        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("Login");
        lblLogin.setOpaque(true);
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLoginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblLoginMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblLoginMouseReleased(evt);
            }
        });
        panelLogin.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 70, 30));

        lblWarning.setBackground(new java.awt.Color(255, 0, 0));
        lblWarning.setFont(new java.awt.Font("Liberation Mono", 0, 12)); // NOI18N
        lblWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelLogin.add(lblWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 250, 50));

        mainPanel.add(panelLogin);

        panelRegister.setOpaque(false);
        panelRegister.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("AnjaliOldLipi", 1, 14)); // NOI18N
        jLabel6.setText("Username");
        panelRegister.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        txtRegUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRegUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRegUsernameFocusLost(evt);
            }
        });
        panelRegister.add(txtRegUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 250, 25));

        jLabel7.setFont(new java.awt.Font("AnjaliOldLipi", 1, 14)); // NOI18N
        jLabel7.setText("FullName");
        panelRegister.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        txtRegName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRegNameFocusLost(evt);
            }
        });
        panelRegister.add(txtRegName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 250, 25));

        jLabel8.setFont(new java.awt.Font("AnjaliOldLipi", 1, 14)); // NOI18N
        jLabel8.setText("Email");
        panelRegister.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txtRegEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRegEmailFocusLost(evt);
            }
        });
        panelRegister.add(txtRegEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 250, 25));

        txtRegPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRegPasswordFocusLost(evt);
            }
        });
        panelRegister.add(txtRegPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 250, 25));

        jLabel9.setFont(new java.awt.Font("AnjaliOldLipi", 1, 14)); // NOI18N
        jLabel9.setText("Password");
        panelRegister.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        lblSave.setBackground(new java.awt.Color(102, 102, 102));
        lblSave.setForeground(new java.awt.Color(255, 255, 255));
        lblSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSave.setText("Save");
        lblSave.setOpaque(true);
        lblSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSaveMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSaveMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblSaveMouseReleased(evt);
            }
        });
        panelRegister.add(lblSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 70, 30));

        password_warning.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        password_warning.setForeground(new java.awt.Color(204, 0, 0));
        password_warning.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        password_warning.setText("jLabel10");
        panelRegister.add(password_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 225, 180, -1));

        username_warning.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        username_warning.setForeground(new java.awt.Color(204, 0, 0));
        username_warning.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        username_warning.setText("jLabel10");
        panelRegister.add(username_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 45, 180, -1));

        name_warning.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        name_warning.setForeground(new java.awt.Color(204, 0, 0));
        name_warning.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        name_warning.setText("jLabel10");
        panelRegister.add(name_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 105, 180, -1));

        email_warning.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        email_warning.setForeground(new java.awt.Color(204, 0, 0));
        email_warning.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        email_warning.setText("jLabel10");
        panelRegister.add(email_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 165, 180, -1));

        mainPanel.add(panelRegister);

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 300, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        if (selectedLabel != jLabel1)
            jLabel1.setFont(primary.FONT.big(14));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        if (selectedLabel != jLabel1)
            jLabel1.setFont(primary.FONT.defaultFont(14));
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setFont(primary.FONT.big(14));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        if (selectedLabel != jLabel2)
            jLabel2.setFont(primary.FONT.defaultFont(14));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        selectedLabel(jLabel1, panelLogin);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        jLabel1.setForeground(primary.COLOR.foregroundOnTop);
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
        jLabel1.setForeground(primary.COLOR.foreground_primary);
    }//GEN-LAST:event_jLabel1MouseReleased

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        jLabel2.setForeground(primary.COLOR.foregroundOnTop);
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased
        jLabel2.setForeground(primary.COLOR.foreground_primary);
    }//GEN-LAST:event_jLabel2MouseReleased

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        selectedLabel(jLabel2, panelRegister);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void lblLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseEntered
        lblLogin.setBackground(primary.COLOR.backgroundOnTop);
    }//GEN-LAST:event_lblLoginMouseEntered

    private void lblLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseExited
        lblLogin.setFont(primary.FONT.defaultFont(13));
        lblLogin.setBackground(primary.COLOR.background_primary);
    }//GEN-LAST:event_lblLoginMouseExited

    private void lblLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMousePressed
        lblLogin.setForeground(primary.COLOR.foregroundOnTop);
        lblLogin.setBackground(primary.COLOR.background_primary);
    }//GEN-LAST:event_lblLoginMousePressed

    private void lblLoginMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseReleased
        lblLogin.setForeground(primary.COLOR.foreground_primary);
        lblLogin.setBackground(primary.COLOR.backgroundOnTop);
    }//GEN-LAST:event_lblLoginMouseReleased

    private void lblSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaveMouseEntered
        if( username && password && name && email)
        lblSave.setBackground(primary.COLOR.backgroundOnTop);
    }//GEN-LAST:event_lblSaveMouseEntered

    private void lblSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaveMouseExited
       if( username && password && name && email){
        lblSave.setFont(primary.FONT.defaultFont(13));
        lblSave.setBackground(primary.COLOR.background_primary);
       }
    }//GEN-LAST:event_lblSaveMouseExited

    private void lblSaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaveMousePressed
        if( username && password && name && email){
        lblSave.setForeground(primary.COLOR.foregroundOnTop);
        lblSave.setBackground(primary.COLOR.background_primary);
        }
    }//GEN-LAST:event_lblSaveMousePressed

    private void lblSaveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaveMouseReleased
        if( username && password && name && email){
        lblSave.setForeground(primary.COLOR.foreground_primary);
        lblSave.setBackground(primary.COLOR.backgroundOnTop);
        }
    }//GEN-LAST:event_lblSaveMouseReleased

    private void txtRegUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRegUsernameFocusLost
       
           
        try {
            if (controller.checkUserName(txtRegUsername.getText())) {

                throw new InvalidInputException("Username Already exist");

            }else if(txtRegUsername.getText().equals("")){
                throw new InvalidInputException("Username field is empty");
            }
            username_warning.setVisible(false);
            username=true;
        } catch (InvalidInputException iie) {
            
            username_warning.setVisible(true);
            username_warning.setText(iie.getMessage());
            username =false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
              checkAllField();
        }
        
       
    }//GEN-LAST:event_txtRegUsernameFocusLost

    private void txtRegUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRegUsernameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegUsernameFocusGained

    private void txtRegEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRegEmailFocusLost
       
          
        try {
            if (controller.checkEmail(txtRegEmail.getText())) {

                throw new InvalidInputException("Email Already exist");

            }else if(txtRegEmail.getText().equals("")){
                throw new InvalidInputException("Email field is Empty");
            }
            email_warning.setVisible(false);
            email =true;
        } catch (InvalidInputException iie) {
            email_warning.setVisible(true);
            email_warning.setText(iie.getMessage());
            email = false;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
              checkAllField();
        }
        
       
    }//GEN-LAST:event_txtRegEmailFocusLost

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
       String username = txtLoginUsername.getText();
       String password = String.valueOf(txtLoginPassword.getPassword());
        try{
            
            User user = controller.login(username, password);
            
            if(user != null){
                new MainFrame().setVisible(true);
                dispose();
            }else{
                lblWarning.setText("Invalid Username and Password");
            }
        }catch(SQLException e){
            lblWarning.setText("Something went wrong");
        }catch(InvalidInputException iie){
            lblWarning.setText("<html><center>"+iie.getMessage()+"</center></html>");
        }
    }//GEN-LAST:event_lblLoginMouseClicked

    private void txtRegNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRegNameFocusLost
         
        try{
            if(txtRegName.getText().equals("")){
                 throw new InvalidInputException("Name field is empty");
            }
            name_warning.setVisible(false);
            name = true;
        }catch(InvalidInputException iie){
            name_warning.setVisible(true);
            name_warning.setText(iie.getMessage());
            name=false;
        }finally{
              checkAllField();
        }
        
     
    }//GEN-LAST:event_txtRegNameFocusLost

    private void txtRegPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRegPasswordFocusLost
          
          
          
        try{
            if(String.valueOf(txtRegPassword.getPassword()).equals("")){
                 throw new InvalidInputException("Password field is empty");
            }
             password_warning.setVisible(false);
             password = true;
        }catch(InvalidInputException iie){
            password_warning.setVisible(true);
            password_warning.setText(iie.getMessage());
            password = false;
        }finally{
              checkAllField();
        }
          
        
    }//GEN-LAST:event_txtRegPasswordFocusLost

    private void lblSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaveMouseClicked
        if( username && password && name && email){
            try{
                String _name = txtRegName.getText();
                String _email = txtRegEmail.getText();
                String _password = String.valueOf(txtRegPassword.getPassword());
                String _username = txtRegUsername.getText();
            
                User user = new User(_name, _username, _email, _password,false);

                controller.addUser(user);
                
                JOptionPane.showMessageDialog(this, "New user successfully added");
                
                txtRegName.setText("");
                txtRegEmail.setText("");
                txtRegPassword.setText("");
                txtRegUsername.setText("");
                
                
                username= false;
                name =false ;
                email = false;
                password = false;
                
                checkAllField();
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
         
            
          
        }
    }//GEN-LAST:event_lblSaveMouseClicked

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel email_warning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSave;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel name_warning;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelRegister;
    private javax.swing.JLabel password_warning;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPasswordField txtLoginPassword;
    private javax.swing.JTextField txtLoginUsername;
    private javax.swing.JTextField txtRegEmail;
    private javax.swing.JTextField txtRegName;
    private javax.swing.JPasswordField txtRegPassword;
    private javax.swing.JTextField txtRegUsername;
    private javax.swing.JLabel username_warning;
    // End of variables declaration//GEN-END:variables


    private void hideWarningLabel() {
        username_warning.setVisible(false);
        name_warning.setVisible(false);
        email_warning.setVisible(false);
        password_warning.setVisible(false);
    }

    private void selectedLabel(JLabel label, JPanel panel) {
        if (selectedLabel != null) {
            this.selectedLabel.setBackground(primary.COLOR.background_primary);
            this.selectedLabel.setForeground(primary.COLOR.foreground_primary);
            this.selectedLabel.setFont(primary.FONT.defaultFont(14));
            selectedPanel.setVisible(false);
        }

        label.setBackground(primary.COLOR.background_secondary);
        label.setForeground(primary.COLOR.background_primary);
        label.setFont(primary.FONT.big(14));
        panel.setVisible(true);

        selectedLabel = label;
        selectedPanel = panel;

    }
}

