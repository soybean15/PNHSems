/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.panels.employee_panel.profile;

import data.controllers.LeaveFormController;
import data.model.Employee;
import data.model.LeaveForm;
import frames.components.LogsItem;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import themes.Theme;

/**
 *
 * @author root
 */
public class EmployeeLeaveLogsPanel extends javax.swing.JPanel {

    /**
     * Creates new form EmployeeLeaveLogsPanel
     */
    JLabel[] pages;
    List<LeaveForm> leaveLogs;
    LeaveFormController controller = new LeaveFormController();

    JLabel selectedPage;
    JLabel activePage;

    public EmployeeLeaveLogsPanel(Employee employee) {
        initComponents();

        try {
            this.leaveLogs = controller.getLeaveLogs(employee);
         
            Collections.reverse(leaveLogs);
            int to =10;
            if(leaveLogs.size()<10){
                to = leaveLogs.size();
            }
            populateList(leaveLogs.subList(0, to));
        } catch (java.sql.SQLException e) {

        }
        // print();
        System.out.println(leaveLogs.size() + "<---Size");
        setPagination();
    }

    boolean firstPage;

    boolean lastPage;
    boolean moreThan5;
    int size;
    int remaining;
    int remainingPages;
    int total;
    int numberOfPages;
    int numberOfPagesSet;
    int current;
    int pageCounter = 1;
    final int SET = 10;

    private void setPagination() {
        size = leaveLogs.size();
        remaining = size % SET;
        total = size - remaining;
        numberOfPages = total / SET;

        if (remaining > 0) {
            numberOfPages++;
        }

        if (numberOfPages > 5) {
            remainingPages = numberOfPages % 5;
            total = numberOfPages - remaining;
            numberOfPagesSet = numberOfPages / 5;
            
            if(remainingPages>0){
                numberOfPagesSet++;
            }
            moreThan5 = true;
            firstPage = true;

        } else {
            remainingPages = numberOfPages;
            lastPage = true;
        }
  

//        if (numberOfPages > 5) {
//            
//        }
        lblPrev.setVisible(false);
        lblNxt.setVisible(false);
        current = 1;
        createPagination(current);

    }

    private void createPagination(int start) {
        buttonContainer.removeAll();
        buttonContainer.repaint();
        buttonContainer.revalidate();
        buttonContainer.setLayout(new GridLayout(0, 5));
        pages = new JLabel[5];

        if (moreThan5) {
            if (firstPage) {
                lblPrev.setVisible(false);
            } else {
                lblPrev.setVisible(true);
            }
            if (lastPage) {
                
                lblNxt.setVisible(false);

            } else {
                lblNxt.setVisible(true);
            }
        }

        for (int i = 0; i < 5; i++) {
            if (lastPage) {
                if (i == remainingPages) {
                    break;
                }
            }
            
           

            pages[i] = new JLabel(String.valueOf(start++));
            pages[i].setFont(Theme.PRIMARY.FONT.tableFontDefault(10));
            pages[i] .setHorizontalAlignment(JLabel.CENTER);
            Border border = BorderFactory.createLineBorder(new Color(204,204,255), 1);
            pages[i].setBorder(border);
            pages[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pages[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(activePage!=null){
                        activePage.setFont(Theme.PRIMARY.FONT.tableFontDefault(10));
                        activePage.setBackground(Color.WHITE);
                        activePage.setForeground(Color.BLACK);
                        activePage.setOpaque(false);
                    }
                    
                    selectedPage = (JLabel) e.getSource();
                    selectedPage.setForeground(Color.white);
                    selectedPage.setOpaque(true);
                    
                    selectedPage.setBackground(new Color(204,204,255));
                    int pageNum = Integer.parseInt(selectedPage.getText());
                    int from = (pageNum * SET) - SET;
                    int to = from + SET;
                    if (to > leaveLogs.size()) {
                        to = leaveLogs.size();
                    }
                    List<LeaveForm> subList = leaveLogs.subList(from, to);

                    loadPage(subList);
                    activePage =selectedPage;
//                    JOptionPane.showMessageDialog(null, "Clicked" + selectedPage.getText() + "\n"
//                            + "from: " + from + "\nto :" + to);
                }
            });

        }

        for (JLabel label : pages) {
            if (label != null) {
                buttonContainer.add(label);

            }
        }
    }

    private void loadPage(List<LeaveForm> leaveLogs) {
        populateList(leaveLogs);
    }

    private void populateList(List<LeaveForm> leaveLogs) {
//        int row = leaveLogs.size();
//        if (row < 10) {
//            row = 9;
//        }
        panelLogs.removeAll();
        panelLogs.repaint();
        panelLogs.revalidate();
        int row = SET;

        panelLogs.setLayout(new GridLayout(row, 0));

        int i = 0;
        for (LeaveForm item : leaveLogs) {
            panelLogs.add(new LogsItem(i, item));
            i++;
        }

    }

    void print() {
        for (LeaveForm item : leaveLogs) {
            System.out.println(item.getId() + " " + item.getDetails());
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
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        buttonContainer = new javax.swing.JPanel();
        lblNxt = new javax.swing.JLabel();
        lblPrev = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelLogs = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblDateFiled = new javax.swing.JLabel();
        lblLeaveType = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblStart = new javax.swing.JLabel();
        lblEnd = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(780, 120));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(780, 30));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setMaximumSize(new java.awt.Dimension(220, 220));
        jPanel6.setMinimumSize(new java.awt.Dimension(220, 220));
        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(220, 220));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel9.setOpaque(false);
        jPanel9.setPreferredSize(new java.awt.Dimension(350, 350));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel9, java.awt.BorderLayout.EAST);

        jPanel10.setMaximumSize(new java.awt.Dimension(200, 30));
        jPanel10.setMinimumSize(new java.awt.Dimension(200, 30));
        jPanel10.setOpaque(false);
        jPanel10.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel10.setLayout(new java.awt.BorderLayout());

        buttonContainer.setMaximumSize(new java.awt.Dimension(200, 30));
        buttonContainer.setMinimumSize(new java.awt.Dimension(200, 30));
        buttonContainer.setOpaque(false);
        buttonContainer.setPreferredSize(new java.awt.Dimension(200, 30));
        buttonContainer.setLayout(new java.awt.BorderLayout());
        jPanel10.add(buttonContainer, java.awt.BorderLayout.CENTER);
        buttonContainer.getAccessibleContext().setAccessibleName("");

        lblNxt.setText(">");
        lblNxt.setToolTipText("");
        lblNxt.setPreferredSize(new java.awt.Dimension(30, 17));
        lblNxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNxtMouseClicked(evt);
            }
        });
        jPanel10.add(lblNxt, java.awt.BorderLayout.EAST);

        lblPrev.setText("<");
        lblPrev.setToolTipText("");
        lblPrev.setPreferredSize(new java.awt.Dimension(30, 17));
        lblPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrevMouseClicked(evt);
            }
        });
        jPanel10.add(lblPrev, java.awt.BorderLayout.WEST);

        jPanel6.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel11.setOpaque(false);
        jPanel11.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel11, java.awt.BorderLayout.WEST);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, java.awt.BorderLayout.SOUTH);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        panelLogs.setOpaque(false);

        javax.swing.GroupLayout panelLogsLayout = new javax.swing.GroupLayout(panelLogs);
        panelLogs.setLayout(panelLogsLayout);
        panelLogsLayout.setHorizontalGroup(
            panelLogsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        panelLogsLayout.setVerticalGroup(
            panelLogsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );

        jPanel2.add(panelLogs, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new java.awt.BorderLayout());

        lblDateFiled.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
        );
        lblDateFiled.setText(" DateFiled");
        lblDateFiled.setPreferredSize(new java.awt.Dimension(100, 17));
        jPanel3.add(lblDateFiled, java.awt.BorderLayout.LINE_START);

        lblLeaveType.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
        );
        lblLeaveType.setText(" LeaveType");
        jPanel3.add(lblLeaveType, java.awt.BorderLayout.CENTER);

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 36));
        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        lblStart.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
        );
        lblStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStart.setText("Start");
        jPanel4.add(lblStart);

        lblEnd.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
        );
        lblEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnd.setText("End");
        jPanel4.add(lblEnd);

        jPanel3.add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(15, 215));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        add(jPanel7, java.awt.BorderLayout.WEST);

        jPanel8.setOpaque(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(350, 350));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        add(jPanel8, java.awt.BorderLayout.EAST);

        jPanel12.setOpaque(false);
        jPanel12.setPreferredSize(new java.awt.Dimension(780, 20));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        add(jPanel12, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void lblNxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNxtMouseClicked
        current += SET;
        pageCounter++;
        firstPage = false;
        lastPage = pageCounter == numberOfPagesSet;

        System.out.println(lastPage);
        createPagination(current);

    }//GEN-LAST:event_lblNxtMouseClicked

    private void lblPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrevMouseClicked
        current -= SET;
        pageCounter--;
        lastPage = false;
        firstPage = current == 1;

        createPagination(current);
    }//GEN-LAST:event_lblPrevMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonContainer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblDateFiled;
    private javax.swing.JLabel lblEnd;
    private javax.swing.JLabel lblLeaveType;
    private javax.swing.JLabel lblNxt;
    private javax.swing.JLabel lblPrev;
    private javax.swing.JLabel lblStart;
    private javax.swing.JPanel panelLogs;
    // End of variables declaration//GEN-END:variables
}
