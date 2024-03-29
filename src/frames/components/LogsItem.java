/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.components;

import data.model.LeaveForm;
import java.awt.Color;
import themes.Theme;

/**
 *
 * @author root
 */


public class LogsItem extends javax.swing.JPanel {

    /**
     * Creates new form LogsItem
     */
    int index;
    private LeaveForm leaveForm;
    public LogsItem(int index,LeaveForm leaveForm) {
        initComponents();
        this.index=index;
        this.leaveForm = leaveForm;
        
         init();
    }
    
    
    private void init(){
        lblId.setText(leaveForm.getId());
        lblUser.setText(leaveForm.getUserId());
        lblLeaveType.setText(leaveForm.getLeaveType()!=null? leaveForm.getLeaveType().getName():leaveForm.getDetails());

        
        
        
               
        if(index%2==1){
            this.setBackground(Theme.PRIMARY.COLOR.background_secondary);
           
        }else{
            this.setBackground(new Color(204, 230, 192));
            
        }
    }
    
    

    public LogsItem getItem(){
        return this;
    }
    public LeaveForm getLeaveForm(){
        return this.leaveForm;
    }
    
    public void selected(){
        lblId.setFont(Theme.PRIMARY.FONT.tableFontBig(12));
         lblUser.setFont(Theme.PRIMARY.FONT.tableFontBig(12));
        
        lblLeaveType.setFont(Theme.PRIMARY.FONT.tableFontBig(12));
//        lblStart.setFont(Theme.PRIMARY.FONT.tableFontBig(12));
//        lblEnd.setFont(Theme.PRIMARY.FONT.tableFontBig(12));
    }
    public void unSelected(){
        lblId.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
         lblUser.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
        
        lblLeaveType.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
//        lblStart.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
//        lblEnd.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLeaveType = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setLayout(new java.awt.BorderLayout());

        lblLeaveType.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        lblLeaveType.setText("LeaveType");
        add(lblLeaveType, java.awt.BorderLayout.CENTER);

        lblUser.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        lblUser.setText("User");
        lblUser.setPreferredSize(new java.awt.Dimension(100, 17));
        add(lblUser, java.awt.BorderLayout.EAST);

        lblId.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblId.setText("Ref_Num");
        lblId.setPreferredSize(new java.awt.Dimension(100, 17));
        add(lblId, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLeaveType;
    private javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
}
