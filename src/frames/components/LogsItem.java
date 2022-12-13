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
        lblDateFiled.setText(leaveForm.getDateFiled().toString());
        lblLeaveType.setText(leaveForm.getLeaveType()!=null? leaveForm.getLeaveType().getName():leaveForm.getDetails());
        lblStart.setText(leaveForm.getInclusiveDate_start().toString());
        lblEnd.setText(leaveForm.getInclusiveDate_end().toString());
        
        
        
               
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
         lblDateFiled.setFont(Theme.PRIMARY.FONT.tableFontBig(12));
        
        lblLeaveType.setFont(Theme.PRIMARY.FONT.tableFontBig(12));
        lblStart.setFont(Theme.PRIMARY.FONT.tableFontBig(12));
        lblEnd.setFont(Theme.PRIMARY.FONT.tableFontBig(12));
    }
    public void unSelected(){
         lblDateFiled.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
        
        lblLeaveType.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
        lblStart.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
        lblEnd.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDateFiled = new javax.swing.JLabel();
        lblLeaveType = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblStart = new javax.swing.JLabel();
        lblEnd = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setLayout(new java.awt.BorderLayout());

        lblDateFiled.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        lblDateFiled.setText("DateFiled");
        lblDateFiled.setPreferredSize(new java.awt.Dimension(100, 17));
        add(lblDateFiled, java.awt.BorderLayout.LINE_START);

        lblLeaveType.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        lblLeaveType.setText("LeaveType");
        add(lblLeaveType, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 36));
        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        lblStart.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        lblStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStart.setText("Start");
        jPanel1.add(lblStart);

        lblEnd.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        lblEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnd.setText("End");
        jPanel1.add(lblEnd);

        add(jPanel1, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDateFiled;
    private javax.swing.JLabel lblEnd;
    private javax.swing.JLabel lblLeaveType;
    private javax.swing.JLabel lblStart;
    // End of variables declaration//GEN-END:variables
}
