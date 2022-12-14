/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.components.windows.comp;

import data.model.ServiceCredit;
import java.awt.Color;
import frames.components.windows.listener.ServiceCreditItemListener;
import javax.swing.JLabel;
import themes.Theme;

/**
 *
 * @author root
 */
public class W_ServiceCreditItem extends javax.swing.JPanel {

    /**
     * Creates new form W_ServiceCreditItem
     */
    private ServiceCredit serviceCredit;
    private ServiceCreditItemListener listener;

    public W_ServiceCreditItem(ServiceCredit serviceCredit, ServiceCreditItemListener listener) {
        initComponents();

        this.serviceCredit = serviceCredit;
        this.listener = listener;

        if (serviceCredit == null) {
             lbl1.setHorizontalAlignment(JLabel.CENTER);
             this.setOpaque(false);
            lbl1.setText("No Available Item ");
        } else {
            lbl1.setText(" " + serviceCredit.getMemorandum());
        }

    }

    public ServiceCredit getServiceCredit() {
        return this.serviceCredit;
    }

    public void selected() {
        if (serviceCredit != null) {
            this.setBackground(new Color(0, 51, 255));
            lbl1.setForeground(Color.WHITE);
        }

    }

    public void unSeleted() {
        if (serviceCredit != null) {
            this.setBackground(Color.WHITE);
            lbl1.setForeground(Color.BLACK);
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

        lbl1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(20, 25));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.GridLayout());

        lbl1.setFont(Theme.PRIMARY.FONT.tableFontDefault(14)
        );
        lbl1.setText("lbl1");
        add(lbl1);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        listener.onItemClick(this);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl1;
    // End of variables declaration//GEN-END:variables
}
