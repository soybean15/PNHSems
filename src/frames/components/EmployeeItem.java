/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.components;

import data.model.Employee;
import frames.listener.EmployeeItemListener;
import java.awt.Color;
import themes.Theme;

/**
 *
 * @author root
 */
public class EmployeeItem extends javax.swing.JPanel {

    /**
     * Creates new form EmployeeItem
     */
    
    private final Employee employee;
    int index;
    
    EmployeeItemListener listener;
    
    public EmployeeItem( EmployeeItemListener listener, Employee employee,int index) {
        this.employee = employee;
        this.index = index;
        this.listener = listener;
        
        initComponents();
        
        setItem();
    }
    
    
    
    private void setItem(){
        
        lblId.setText(employee.getId());
//        String firstName = employee.getFirstName();
//        String lastName = employee.getLastName();
//        boolean hasMiddleName = employee.getMiddleName() != null;
//        String middleName = hasMiddleName? ", "+employee.getMiddleName().substring(0,1)+".":"";
//        String nameExt = employee.getNameExtension()==null?"": " "+employee.getNameExtension();
//        
        String position = employee.getPosition().getName();
              
        lblName.setText(employee.getFullname());
        
        lblPosition.setText(position);
        
             
        if(index%2==1){
            this.setBackground(Theme.PRIMARY.COLOR.background_secondary);
           
        }else{
            this.setBackground(new Color(204, 230, 192));
            
        }
        
        
    }
    
    public Employee getEmployee(){
        return this.employee;
    }
    
    public void defaultFont(){
        lblId.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
        lblName.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
        lblPosition.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
        
    } 
    
    public void bigFont(){
          lblId.setFont(Theme.PRIMARY.FONT.tableFontBig(12));
        lblName.setFont(Theme.PRIMARY.FONT.tableFontBig(12));
        lblPosition.setFont(Theme.PRIMARY.FONT.tableFontBig(12));
      
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

        lblId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(400, 40));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        lblId.setBackground(new java.awt.Color(102, 255, 102));
        lblId.setFont(new java.awt.Font("Liberation Mono", 0, 12)); // NOI18N
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblId.setText("id");
        lblId.setMaximumSize(new java.awt.Dimension(60, 40));
        lblId.setMinimumSize(new java.awt.Dimension(70, 40));
        lblId.setPreferredSize(new java.awt.Dimension(70, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.7;
        add(lblId, gridBagConstraints);

        lblName.setBackground(new java.awt.Color(102, 255, 102));
        lblName.setFont(new java.awt.Font("Liberation Mono", 0, 12)); // NOI18N
        lblName.setText("Full name");
        lblName.setMaximumSize(new java.awt.Dimension(60, 40));
        lblName.setMinimumSize(new java.awt.Dimension(70, 40));
        lblName.setPreferredSize(new java.awt.Dimension(70, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.9;
        add(lblName, gridBagConstraints);

        lblPosition.setBackground(new java.awt.Color(102, 255, 102));
        lblPosition.setFont(new java.awt.Font("Liberation Mono", 0, 12)); // NOI18N
        lblPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPosition.setText("Position");
        lblPosition.setMaximumSize(new java.awt.Dimension(60, 40));
        lblPosition.setMinimumSize(new java.awt.Dimension(70, 40));
        lblPosition.setPreferredSize(new java.awt.Dimension(70, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        add(lblPosition, gridBagConstraints);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(156, 23));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jButton3.setText("View");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        add(jPanel1, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       listener.onEmployeeItemClick(this);
    }//GEN-LAST:event_formMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        listener.onViewEmployeeClick(employee);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPosition;
    // End of variables declaration//GEN-END:variables
}
