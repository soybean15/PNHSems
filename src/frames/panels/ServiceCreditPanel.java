/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.panels;

import data.controllers.ServiceCreditController;
import data.controllers.form.ServiceCreditValidation;
import data.model.ServiceCredit;
import frames.components.ServiceCreditItem;
import frames.listener.ServiceCreditItemListener;

import java.awt.GridLayout;
import java.util.List;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pnhsems.InvalidInputException;
import themes.Theme;

/**
 *
 * @author root
 */
public class ServiceCreditPanel extends javax.swing.JPanel implements ServiceCreditItemListener{

    /**
     * Creates new form ServiceCreditPanel
     */
    
    ServiceCreditController controller  = new ServiceCreditController();
    List<ServiceCredit> serviceCredits;
    
     ServiceCreditValidation serviceCreditValidation = new ServiceCreditValidation();

    private ServiceCredit serviceCredit;
    
    private boolean onEdit;
    private boolean onAdd;
    
    public ServiceCreditPanel() {
        initComponents();
        
        init();
         
        
       
    }
    
    private void onEditExit(){
        btn1.setText("Edit");
        btn2.setText("Delete");
        viewDetailsPanel.setVisible(true);
        addEditDetailPanel.setVisible(false);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));
        resetTextFields();
        
    }
    
    private void onEdit(){
        btn1.setText("Save");
        btn2.setText("Cancel");
        viewDetailsPanel.setVisible(false);

        addEditDetailPanel.setVisible(true);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Details"));
        setTextFields();
    }
    
    private void onAdd(){
        btn1.setText("Save");
        btn2.setText("Cancel");
        viewDetailsPanel.setVisible(false);

        addEditDetailPanel.setVisible(true);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Service Credit"));
        setTextFields();
    }
     private void onAddExit(){
        onEditExit();
    }
    
    private void setTextFields() {

        if (onEdit) {
            txtOrderNumber.setText(lblOrderNumber.getText());
            txtMemorandum.setText(lblMemorandum.getText());
            txtTitle.setText(lblTitle.getText());
            txtDays.setText(lblDays.getText());
        } else {
            resetTextFields();
        }

    }

    private void resetTextFields() {
  
        txtOrderNumber.setText("");
        txtMemorandum.setText("");
        txtTitle.setText("");
        txtDays.setText("");
    }
    

    
    private void init(){
         lblOrderNumber.setText("<html>Following example showcase how to add title to border of a JPanel in a Java Swing application.</html>");
        
         //display serviceCredits
        try{
             serviceCredits = controller.getAllServiceCredits();
             displayServiceCredits(serviceCredits);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        addEditDetailPanel.setVisible(false);
        
    }
    
    private void reloadList(){
          try{
             serviceCredits = controller.getAllServiceCredits();
             displayServiceCredits(serviceCredits);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    private void displayServiceCredits(List<ServiceCredit> serviceCredits){
        serviceCreditsList.removeAll();
        serviceCreditsList.repaint();
        serviceCreditsList.revalidate();
        
        int size = serviceCredits.size();
        int row =size;
        if(size<8){
            row=8;
        }
      
        serviceCreditsList.setLayout(new GridLayout(row,0));
        
        int index =0;
        for(ServiceCredit serviceCredit : serviceCredits){
          
            
            serviceCreditsList.add(new ServiceCreditItem(index,serviceCredit,this) );
             index++;
        }
      
    }
    
    
    private int addServiceCredit(){
        ServiceCredit _serviceCredit = new ServiceCredit();
        
        _serviceCredit.setOrderNo(serviceCreditValidation.checkField(txtOrderNumber.getText()));
        _serviceCredit.setMemorandum(serviceCreditValidation.checkField(txtMemorandum.getText()));
        _serviceCredit.setTitle(serviceCreditValidation.checkField(txtTitle.getText()));
        _serviceCredit.setNumberOfDays(serviceCreditValidation.checkInt(txtDays.getText()));
        
        try{
            return controller.addServiceCredit(serviceCredit);
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }catch(InvalidInputException iie){
            JOptionPane.showMessageDialog(this, iie.getMessage());
             return 0;
        }
        
        
    }
    
    private int updateServiceCredit(){
       
        
        serviceCredit.setOrderNo(serviceCreditValidation.checkField(txtOrderNumber.getText()));
        serviceCredit.setMemorandum(serviceCreditValidation.checkField(txtMemorandum.getText()));
        serviceCredit.setTitle(serviceCreditValidation.checkField(txtTitle.getText()));
        serviceCredit.setNumberOfDays(serviceCreditValidation.checkInt(txtDays.getText()));
        
        try{
            return controller.updateServiceCredit(serviceCredit);
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }catch(InvalidInputException iie){
            JOptionPane.showMessageDialog(this, iie.getMessage());
             return 0;
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

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        detailContainer = new javax.swing.JPanel();
        viewDetailsPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblOrderNumber = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblMemorandum = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblDays = new javax.swing.JLabel();
        addEditDetailPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtOrderNumber = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMemorandum = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtDays = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        serviceCreditsList = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(51, 51, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));
        jPanel3.setMaximumSize(new java.awt.Dimension(350, 32767));
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 257));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        detailContainer.setLayout(new javax.swing.OverlayLayout(detailContainer));

        viewDetailsPanel.setLayout(new java.awt.GridLayout(4, 0));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(Theme.PRIMARY.FONT.tableFontBig(10)
        );
        jLabel1.setText("Order No.:");
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel4.add(jLabel1, java.awt.BorderLayout.NORTH);

        lblOrderNumber.setFont(Theme.PRIMARY.FONT.defaultFont(13)
        );
        lblOrderNumber.setText("lbl");
        jPanel4.add(lblOrderNumber, java.awt.BorderLayout.CENTER);

        viewDetailsPanel.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(Theme.PRIMARY.FONT.tableFontBig(10)
        );
        jLabel2.setText("Memorandum:");
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel5.add(jLabel2, java.awt.BorderLayout.NORTH);

        lblMemorandum.setFont(Theme.PRIMARY.FONT.defaultFont(13)
        );
        lblMemorandum.setText("jLabel2");
        jPanel5.add(lblMemorandum, java.awt.BorderLayout.CENTER);

        viewDetailsPanel.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(Theme.PRIMARY.FONT.tableFontBig(10)
        );
        jLabel3.setText("Title:");
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel6.add(jLabel3, java.awt.BorderLayout.NORTH);

        lblTitle.setFont(Theme.PRIMARY.FONT.defaultFont(13)
        );
        lblTitle.setText("jLabel2");
        jPanel6.add(lblTitle, java.awt.BorderLayout.CENTER);

        viewDetailsPanel.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(Theme.PRIMARY.FONT.tableFontBig(10)
        );
        jLabel4.setText("Number of Days:");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel7.add(jLabel4, java.awt.BorderLayout.NORTH);

        lblDays.setFont(Theme.PRIMARY.FONT.defaultFont(13)
        );
        lblDays.setText("jLabel2");
        jPanel7.add(lblDays, java.awt.BorderLayout.CENTER);

        viewDetailsPanel.add(jPanel7);

        detailContainer.add(viewDetailsPanel);

        addEditDetailPanel.setLayout(new java.awt.GridLayout(4, 0));

        jPanel12.setBackground(new java.awt.Color(204, 204, 255));
        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(Theme.PRIMARY.FONT.tableFontBig(10)
        );
        jLabel5.setText("Order No.:");
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel12.add(jLabel5, java.awt.BorderLayout.NORTH);
        jPanel12.add(txtOrderNumber, java.awt.BorderLayout.CENTER);

        addEditDetailPanel.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(204, 204, 255));
        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(Theme.PRIMARY.FONT.tableFontBig(10)
        );
        jLabel6.setText("Memorandum:");
        jLabel6.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel13.add(jLabel6, java.awt.BorderLayout.NORTH);
        jPanel13.add(txtMemorandum, java.awt.BorderLayout.PAGE_END);

        addEditDetailPanel.add(jPanel13);

        jPanel18.setBackground(new java.awt.Color(204, 204, 255));
        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(Theme.PRIMARY.FONT.tableFontBig(10)
        );
        jLabel7.setText("Title:");
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel18.add(jLabel7, java.awt.BorderLayout.NORTH);
        jPanel18.add(txtTitle, java.awt.BorderLayout.CENTER);

        addEditDetailPanel.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(204, 204, 255));
        jPanel19.setOpaque(false);
        jPanel19.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(Theme.PRIMARY.FONT.tableFontBig(10)
        );
        jLabel8.setText("Number of Days:");
        jLabel8.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel19.add(jLabel8, java.awt.BorderLayout.NORTH);
        jPanel19.add(txtDays, java.awt.BorderLayout.CENTER);

        addEditDetailPanel.add(jPanel19);

        detailContainer.add(addEditDetailPanel);

        jPanel3.add(detailContainer);

        jPanel10.setBackground(new java.awt.Color(204, 204, 255));
        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.GridLayout(5, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel14);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel8);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel9);

        jPanel15.setLayout(new java.awt.GridLayout(1, 2));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel16);

        jPanel17.setLayout(new java.awt.GridLayout(1, 2));

        btn1.setText("Edit");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel17.add(btn1);

        btn2.setText("Delete");
        jPanel17.add(btn2);

        jPanel15.add(jPanel17);

        jPanel10.add(jPanel15);

        jPanel3.add(jPanel10);

        jPanel1.add(jPanel3, java.awt.BorderLayout.EAST);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        serviceCreditsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Service Credits"));
        serviceCreditsList.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(serviceCreditsList);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(670, 50));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/add-file.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, java.awt.BorderLayout.EAST);

        jPanel20.setMinimumSize(new java.awt.Dimension(350, 50));
        jPanel20.setName(""); // NOI18N
        jPanel20.setPreferredSize(new java.awt.Dimension(350, 50));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.setPreferredSize(new java.awt.Dimension(78, 25));
        jPanel20.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 260, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/search.png"))); // NOI18N
        jPanel20.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 10, 30, 30));

        jPanel2.add(jPanel20, java.awt.BorderLayout.LINE_START);

        add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel11.setPreferredSize(new java.awt.Dimension(670, 50));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        add(jPanel11, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        onEdit = !onEdit;
        if (onEdit) {

            onEdit();
 
        } else {

            if (onAdd) {

                if (addServiceCredit() == 1) {
                    JOptionPane.showMessageDialog(this, "New Service Credit Added");
                    reloadList();
                    onAdd = false;
                } else {
                    return;
                }
            } else {
                if (updateServiceCredit() == 1) {
                    JOptionPane.showMessageDialog(this, "Service Credit updated");
                    reloadList();
                  
                } else {
                    return;
                }

            }

            onEditExit();
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        onAdd = true;
          onAdd();
//           onEdit = false;
//
//        if (onAdd) {
//            onAdd();
//           onEdit = false;
//       }else{
//            onAddExit();
//            onAdd = false;
//       }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addEditDetailPanel;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JPanel detailContainer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblDays;
    private javax.swing.JLabel lblMemorandum;
    private javax.swing.JLabel lblOrderNumber;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel serviceCreditsList;
    private javax.swing.JTextField txtDays;
    private javax.swing.JTextField txtMemorandum;
    private javax.swing.JTextField txtOrderNumber;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JPanel viewDetailsPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDetails(ServiceCredit serviceCredit) {
        if(onEdit){
            int option = JOptionPane.showConfirmDialog(this, "Want to exit Editing?", "Exit", JOptionPane.YES_NO_OPTION);
            if(option==JOptionPane.YES_OPTION){
                onEditExit();
                onEdit = !onEdit;
                return;
            }
        }
        lblOrderNumber.setText(serviceCredit.getOrderNo());
            lblMemorandum.setText(serviceCredit.getMemorandum());
            lblTitle.setText(serviceCredit.getTitle());
            lblDays.setText(String.valueOf(serviceCredit.getNumberOfDays()));
            this.serviceCredit = serviceCredit;
        
        
    }
}