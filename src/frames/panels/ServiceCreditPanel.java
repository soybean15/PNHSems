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
import java.awt.Color;

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
public class ServiceCreditPanel extends javax.swing.JPanel implements ServiceCreditItemListener {

    /**
     * Creates new form ServiceCreditPanel
     */
    ServiceCreditController controller = new ServiceCreditController();
    List<ServiceCredit> serviceCredits;

    ServiceCreditValidation serviceCreditValidation = new ServiceCreditValidation();

    private ServiceCredit selected;
    private ServiceCreditItem activeItem;

    public ServiceCreditPanel() {
        initComponents();

        init();

    }

    private void exit() {
        btn1.setText("Edit");
        btn1.setBackground(new Color(0,51,255));
        
        btn2.setText("Delete");
        btn2.setBackground(new Color(255,0,0));
        viewDetailsPanel.setVisible(true);
        addEditDetailPanel.setVisible(false);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));
        resetTextFields();

    }

    private void onExit() {
        if (isEdit()) {
            String msg = "Want to exit Editing?";
            if (!jButton2.isVisible()) {
                msg = "Cancel Adding?";
            }
            int option = JOptionPane.showConfirmDialog(this, msg, "Exit", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                jButton2.setVisible(true);
                selected =null;
                exit();

            }
        }
    }

    private void onEdit() {
        btn1.setText("Save");
        btn1.setBackground(new Color(0,204,0));
        btn2.setText("Cancel");
        btn2.setBackground(new Color(255,51,0));
        viewDetailsPanel.setVisible(false);

        addEditDetailPanel.setVisible(true);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Details"));
        setTextFields();
    }

    private void onAdd() {
        btn1.setText("Save");
         btn1.setBackground(new Color(0,204,0));
        btn2.setText("Cancel");
        btn2.setBackground(new Color(255,51,0));
        viewDetailsPanel.setVisible(false);

        addEditDetailPanel.setVisible(true);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Service Credit"));

    }

    private boolean isEdit() {
        return btn1.getText().equals("Save");
    }

    private void setTextFields() {

        txtOrderNumber.setText(lblOrderNumber.getText());
        txtMemorandum.setText(lblMemorandum.getText());
        txtTitle.setText(lblTitle.getText());
        txtDays.setText(lblDays.getText());

    }

    private void resetTextFields() {
        lblOrderNumber.setText(txtOrderNumber.getText());
        lblMemorandum.setText(txtMemorandum.getText());
        lblTitle.setText(txtTitle.getText());
        lblDays.setText(txtDays.getText());

        txtOrderNumber.setText("");
        txtMemorandum.setText("");
        txtTitle.setText("");
        txtDays.setText("");

    }

    private void init() {
      

        //display serviceCredits
        try {
            serviceCredits = controller.getAllServiceCredits();
            displayServiceCredits(serviceCredits);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        addEditDetailPanel.setVisible(false);

    }

    private void reloadList() {
        try {
            serviceCredits = controller.getAllServiceCredits();
            displayServiceCredits(serviceCredits);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void displayServiceCredits(List<ServiceCredit> serviceCredits) {
        serviceCreditsList.removeAll();
        serviceCreditsList.repaint();
        serviceCreditsList.revalidate();

        int size = serviceCredits.size();
        int row = size;
        if (size < 8) {
            row = 8;
        }

        serviceCreditsList.setLayout(new GridLayout(row, 0));

        int index = 0;
        for (ServiceCredit serviceCredit : serviceCredits) {

            serviceCreditsList.add(new ServiceCreditItem(index, serviceCredit, this));
            index++;
        }

    }

    private int addServiceCredit() {
        ServiceCredit _serviceCredit = new ServiceCredit();

        _serviceCredit.setOrderNo(serviceCreditValidation.checkField(txtOrderNumber.getText()));
        _serviceCredit.setMemorandum(serviceCreditValidation.checkField(txtMemorandum.getText()));
        _serviceCredit.setTitle(serviceCreditValidation.checkField(txtTitle.getText()));
        _serviceCredit.setNumberOfDays(serviceCreditValidation.checkInt(txtDays.getText()));

        try {
            return controller.addServiceCredit(_serviceCredit);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (InvalidInputException iie) {
            JOptionPane.showMessageDialog(this, iie.getMessage());
            return 0;
        }

    }

    private int updateServiceCredit() {

        selected.setOrderNo(serviceCreditValidation.checkField(txtOrderNumber.getText()));
        selected.setMemorandum(serviceCreditValidation.checkField(txtMemorandum.getText()));
        selected.setTitle(serviceCreditValidation.checkField(txtTitle.getText()));
        selected.setNumberOfDays(serviceCreditValidation.checkInt(txtDays.getText()));

        try {
            return controller.updateServiceCredit(selected);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (InvalidInputException iie) {
            JOptionPane.showMessageDialog(this, iie.getMessage());
            return 0;
        }

    }
    
    private void delete(){
         try {
                if (controller.deleteServiceCredit(selected) == 1) {

                    JOptionPane.showMessageDialog(this, selected.getOrderNo() + " deleted");
                    reloadList();
                }

            } catch (SQLException e) {
                e.printStackTrace();
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
        jPanel21 = new javax.swing.JPanel();
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

        setBackground(Theme.PRIMARY.COLOR.background_secondary);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));
        jPanel3.setMaximumSize(new java.awt.Dimension(350, 32767));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 257));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        detailContainer.setOpaque(false);
        detailContainer.setLayout(new javax.swing.OverlayLayout(detailContainer));

        viewDetailsPanel.setOpaque(false);
        viewDetailsPanel.setLayout(new java.awt.GridLayout(4, 0));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
        );
        jLabel1.setText("Order No.:");
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel4.add(jLabel1, java.awt.BorderLayout.NORTH);

        lblOrderNumber.setFont(Theme.PRIMARY.FONT.tableFontDefault(13)
        );
        jPanel4.add(lblOrderNumber, java.awt.BorderLayout.CENTER);

        viewDetailsPanel.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
        );
        jLabel2.setText("Memorandum:");
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel5.add(jLabel2, java.awt.BorderLayout.NORTH);

        lblMemorandum.setFont(Theme.PRIMARY.FONT.tableFontDefault(13)
        );
        jPanel5.add(lblMemorandum, java.awt.BorderLayout.CENTER);

        viewDetailsPanel.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
        );
        jLabel3.setText("Title:");
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel6.add(jLabel3, java.awt.BorderLayout.NORTH);

        lblTitle.setFont(Theme.PRIMARY.FONT.tableFontDefault(13)
        );
        jPanel6.add(lblTitle, java.awt.BorderLayout.CENTER);

        viewDetailsPanel.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
        );
        jLabel4.setText("Number of Days:");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 17));
        jPanel7.add(jLabel4, java.awt.BorderLayout.NORTH);

        lblDays.setFont(Theme.PRIMARY.FONT.tableFontDefault(13)
        );
        jPanel7.add(lblDays, java.awt.BorderLayout.CENTER);

        viewDetailsPanel.add(jPanel7);

        detailContainer.add(viewDetailsPanel);

        addEditDetailPanel.setOpaque(false);
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

        jPanel14.setOpaque(false);

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

        jPanel8.setOpaque(false);

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

        jPanel9.setOpaque(false);

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

        jPanel21.setOpaque(false);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel21);

        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.GridLayout(1, 2));

        jPanel16.setOpaque(false);

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

        jPanel17.setOpaque(false);
        jPanel17.setLayout(new java.awt.GridLayout(1, 2));

        btn1.setBackground(new java.awt.Color(0, 51, 255));
        btn1.setFont(Theme.PRIMARY.FONT.tableFontBig(10)
        );
        btn1.setForeground(Theme.PRIMARY.COLOR.foreground_white);
        btn1.setText("Edit");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel17.add(btn1);

        btn2.setBackground(new java.awt.Color(255, 0, 0));
        btn2.setFont(Theme.PRIMARY.FONT.tableFontBig(10)
        );
        btn2.setForeground(Theme.PRIMARY.COLOR.foreground_white);
        btn2.setText("Delete");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel17.add(btn2);

        jPanel15.add(jPanel17);

        jPanel10.add(jPanel15);

        jPanel3.add(jPanel10);

        jPanel1.add(jPanel3, java.awt.BorderLayout.EAST);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        serviceCreditsList.setBackground(Theme.PRIMARY.COLOR.background_secondary);
        serviceCreditsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Service Credits"));
        serviceCreditsList.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(serviceCreditsList);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setOpaque(false);
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
        jPanel20.setOpaque(false);
        jPanel20.setPreferredSize(new java.awt.Dimension(350, 50));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.setPreferredSize(new java.awt.Dimension(78, 25));
        jPanel20.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 260, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/search.png"))); // NOI18N
        jPanel20.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 10, 30, 30));

        jPanel2.add(jPanel20, java.awt.BorderLayout.LINE_START);

        add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel11.setOpaque(false);
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

        if (!jButton2.isVisible()) {

            if (addServiceCredit() == 1) {

                JOptionPane.showMessageDialog(this, "New Service Credit Added");
                reloadList();

                jButton2.setVisible(true);
                exit();

            }
        } else {
            if (!isEdit()) {

                if (selected == null) {
                    return;
                }

                onEdit();

            } else {

                if (updateServiceCredit() == 1) {
                    JOptionPane.showMessageDialog(this, "Service Credit updated");
                    reloadList();

                    exit();

                }

            }
        }


    }//GEN-LAST:event_btn1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        resetTextFields();
        onAdd();
        jButton2.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if (btn2.getText().equals("Cancel")) {
            onExit();
        } else {
             int option = JOptionPane.showConfirmDialog(this, "Delete Item?", "Exit", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                delete();

                
            }
           
        }

    }//GEN-LAST:event_btn2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addEditDetailPanel;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JPanel detailContainer;
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
    private javax.swing.JPanel jPanel21;
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
        if (isEdit()) {
            String msg = "Want to exit Editing?";
            if (!jButton2.isVisible()) {
                msg = "Exit Adding?";
            }
            int option = JOptionPane.showConfirmDialog(this, msg, "Exit", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                exit();

                return;
            }
        }
        lblOrderNumber.setText(serviceCredit.getOrderNo());
        lblMemorandum.setText(serviceCredit.getMemorandum());
        lblTitle.setText(serviceCredit.getTitle());
        lblDays.setText(String.valueOf(serviceCredit.getNumberOfDays()));
        this.selected = serviceCredit;

    }

    @Override
    public void onItemSelected(ServiceCreditItem serviceCreditItem) {
        if(activeItem !=null ){
            activeItem.defaultFont();
        }
        serviceCreditItem.bigFont();
        activeItem = serviceCreditItem; 
    }
}
