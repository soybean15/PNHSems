/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.panels.employee_panel.profile;

import data.controllers.LeaveFormController;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.LeaveForm;
import frames.components.LogsItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import otherclasses.UtilClass;
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

    LogsItem activeItem;
    LeaveForm selectedLeaveForm;
    private Employee employee;
    int comboIndex = -1;

    boolean sort;

    public EmployeeLeaveLogsPanel(Employee employee) {
        initComponents();

        this.employee = employee;

        reload();
        init();
        // print();
       
       
    }

    private void init() {
        cmbSort.addActionListener((ActionEvent e) -> {
            sort = true;
            if (comboIndex == -1) {
                if (cmbSort.getSelectedIndex() == 0) {
                    update();
                }
            } else {
                if (cmbSort.getSelectedIndex() != comboIndex) {
                    update();
                }
            }
            comboIndex = cmbSort.getSelectedIndex();
            sort = false;
        });

    }
    
    public void reload(){
           try {
            this.leaveLogs = controller.getLeaveLogs(employee);
            lblHeader.setText(employee.getFirstName() + "'s Leave Logs");

            update();

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }

    private void update() {
        if (sort) {
            Collections.reverse(leaveLogs);
        }

        int to = 10;

        if (leaveLogs.size() < 10) {
            to = leaveLogs.size();
        }

        populateList(leaveLogs.subList(0, to));
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

            if (remainingPages > 0) {
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

            if (activePage == null) {
                pages[0].setForeground(Color.white);
                pages[0].setOpaque(true);

                pages[0].setBackground(new Color(204, 204, 255));
                activePage = pages[0];
            }
            pages[i].setFont(Theme.PRIMARY.FONT.tableFontDefault(10));
            pages[i].setHorizontalAlignment(JLabel.CENTER);
            Border border = BorderFactory.createLineBorder(new Color(204, 204, 255), 1);
            pages[i].setBorder(border);
            pages[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pages[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (activePage != null) {
                        activePage.setFont(Theme.PRIMARY.FONT.tableFontDefault(10));
                        activePage.setBackground(Color.WHITE);
                        activePage.setForeground(Color.BLACK);
                        activePage.setOpaque(false);
                    }

                    selectedPage = (JLabel) e.getSource();
                    selectedPage.setForeground(Color.white);
                    selectedPage.setOpaque(true);

                    selectedPage.setBackground(new Color(204, 204, 255));
                    int pageNum = Integer.parseInt(selectedPage.getText());
                    int from = (pageNum * SET) - SET;
                    int to = from + SET;
                    if (to > leaveLogs.size()) {
                        to = leaveLogs.size();
                    }
                    List<LeaveForm> subList = leaveLogs.subList(from, to);

                    loadPage(subList);
                    activePage = selectedPage;
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
            LogsItem logItem = new LogsItem(i, item);
            logItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (activeItem != null) {
                        activeItem.unSelected();
                    }
                    LogsItem item = (LogsItem) e.getSource();
                    item.selected();
                    activeItem = item;
                    selectedLeaveForm = item.getLeaveForm();

                    setDetails();
                }
            });
            panelLogs.add(logItem);
            i++;
        }

    }

    private void setDetails() {
        lblDateFiled.setText("  " + selectedLeaveForm.getDateFiled().toString());
        lblLeaveType.setText("  " + selectedLeaveForm.getLeaveType() == null ? "--" : "  " + selectedLeaveForm.getLeaveType().getName());
        lblDetails.setText("  " + selectedLeaveForm.getDetails());
        lblStart.setText("  " + selectedLeaveForm.getInclusiveDate_start().toString());
        lblEnd.setText("  " + selectedLeaveForm.getInclusiveDate_end().toString());

        lblTotal.setText("Total: " + selectedLeaveForm.getCreditUsed() + " ");

        panelServiceCredits.setLayout(new GridLayout(5, 0));
        panelServiceCredits.removeAll();
        panelServiceCredits.repaint();
        panelServiceCredits.revalidate();

        for (EmployeeServiceCredit item : selectedLeaveForm.getServiceCredit()) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setOpaque(false);
            JLabel name = new JLabel("  " + item.getServiceCredit().getMemorandum());
            name.setFont(Theme.PRIMARY.FONT.tableFontDefault(10));
            JLabel count = new JLabel(String.valueOf(item.getDays_used()));
            count.setFont(Theme.PRIMARY.FONT.tableFontDefault(10));
            count.setPreferredSize(new Dimension(30, 0));
            panel.add(name, BorderLayout.CENTER);
            panel.add(count, BorderLayout.EAST);

            panelServiceCredits.add(panel);
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
        jLabel7 = new javax.swing.JLabel();
        txtSearchRefNum = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        buttonContainer = new javax.swing.JPanel();
        lblNxt = new javax.swing.JLabel();
        lblPrev = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        dateChooser = new datechooser.beans.DateChooserCombo();
        cmbSort = new javax.swing.JComboBox<>();
        lblHeader = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelLogs = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl4 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblDateFiled = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblLeaveType = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblDetails = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblStart = new javax.swing.JLabel();
        lblEnd = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        panelServiceCredits = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

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
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("Reference No:");
        jPanel9.add(jLabel7, java.awt.BorderLayout.WEST);

        txtSearchRefNum.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtSearchRefNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchRefNumKeyPressed(evt);
            }
        });
        jPanel9.add(txtSearchRefNum, java.awt.BorderLayout.CENTER);

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton2, java.awt.BorderLayout.LINE_END);

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
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel20.setOpaque(false);
        jPanel20.setPreferredSize(new java.awt.Dimension(85, 30));
        jPanel20.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("    Filter:  ");
        jPanel20.add(jLabel3, java.awt.BorderLayout.WEST);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/refresh.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel20, java.awt.BorderLayout.WEST);

        dateChooser.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Liberation Sans", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Liberation Sans", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Liberation Sans", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Liberation Sans", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Liberation Sans", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Liberation Sans", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateChooser.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
        public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
            dateChooserOnSelectionChange(evt);
        }
    });
    dateChooser.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            dateChooserOnCommit(evt);
        }
    });
    jPanel11.add(dateChooser, java.awt.BorderLayout.CENTER);

    cmbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oldest", "Recent" }));
    jPanel11.add(cmbSort, java.awt.BorderLayout.EAST);

    jPanel6.add(jPanel11, java.awt.BorderLayout.WEST);

    jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

    jPanel1.add(jPanel5, java.awt.BorderLayout.SOUTH);

    lblHeader.setFont(Theme.PRIMARY.FONT.big(24)
    );
    jPanel1.add(lblHeader, java.awt.BorderLayout.CENTER);

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
        .addGap(0, 335, Short.MAX_VALUE)
    );

    jPanel2.add(panelLogs, java.awt.BorderLayout.CENTER);

    jPanel3.setBackground(new java.awt.Color(0, 204, 204));
    jPanel3.setLayout(new java.awt.BorderLayout());

    lbl1.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
    );
    lbl1.setText(" DateFiled");
    lbl1.setPreferredSize(new java.awt.Dimension(100, 17));
    jPanel3.add(lbl1, java.awt.BorderLayout.LINE_START);

    lbl2.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
    );
    lbl2.setText(" LeaveType");
    jPanel3.add(lbl2, java.awt.BorderLayout.CENTER);

    jPanel4.setOpaque(false);
    jPanel4.setPreferredSize(new java.awt.Dimension(200, 36));
    jPanel4.setLayout(new java.awt.GridLayout(1, 2));

    lbl4.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
    );
    lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl4.setText("Start");
    jPanel4.add(lbl4);

    lbl3.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
    );
    lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl3.setText("End");
    jPanel4.add(lbl3);

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
        .addGap(0, 371, Short.MAX_VALUE)
    );

    add(jPanel7, java.awt.BorderLayout.WEST);

    jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leave Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 13), new java.awt.Color(204, 204, 204))); // NOI18N
    jPanel8.setOpaque(false);
    jPanel8.setPreferredSize(new java.awt.Dimension(350, 350));
    jPanel8.setLayout(new java.awt.BorderLayout());

    jPanel13.setOpaque(false);
    jPanel13.setPreferredSize(new java.awt.Dimension(350, 250));
    jPanel13.setLayout(new java.awt.GridLayout(4, 0));

    jPanel14.setOpaque(false);
    jPanel14.setLayout(new java.awt.BorderLayout());

    jLabel2.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
    );
    jLabel2.setText(" Date Filed");
    jPanel14.add(jLabel2, java.awt.BorderLayout.NORTH);

    lblDateFiled.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
    );
    lblDateFiled.setText(" ");
    jPanel14.add(lblDateFiled, java.awt.BorderLayout.CENTER);

    jPanel13.add(jPanel14);

    jPanel15.setOpaque(false);
    jPanel15.setLayout(new java.awt.BorderLayout());

    jLabel4.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
    );
    jLabel4.setText(" Leave Type");
    jPanel15.add(jLabel4, java.awt.BorderLayout.NORTH);

    lblLeaveType.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
    );
    lblLeaveType.setText("  ");
    jPanel15.add(lblLeaveType, java.awt.BorderLayout.CENTER);

    jPanel13.add(jPanel15);

    jPanel16.setOpaque(false);
    jPanel16.setLayout(new java.awt.BorderLayout());

    jLabel6.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
    );
    jLabel6.setText(" Details");
    jPanel16.add(jLabel6, java.awt.BorderLayout.NORTH);

    lblDetails.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
    );
    lblDetails.setText("  ");
    jPanel16.add(lblDetails, java.awt.BorderLayout.CENTER);

    jPanel13.add(jPanel16);

    jPanel17.setOpaque(false);
    jPanel17.setLayout(new java.awt.GridLayout(2, 2));

    jLabel8.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
    );
    jLabel8.setText(" Start");
    jPanel17.add(jLabel8);

    jLabel11.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
    );
    jLabel11.setText("End");
    jPanel17.add(jLabel11);
    jPanel17.add(lblStart);

    lblEnd.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
    );
    jPanel17.add(lblEnd);

    jPanel13.add(jPanel17);

    jPanel8.add(jPanel13, java.awt.BorderLayout.NORTH);

    jPanel18.setOpaque(false);
    jPanel18.setLayout(new java.awt.BorderLayout());

    jPanel19.setOpaque(false);
    jPanel19.setPreferredSize(new java.awt.Dimension(350, 30));
    jPanel19.setLayout(new java.awt.GridLayout(1, 2));

    jLabel1.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
    );
    jLabel1.setText(" ServiceCredit(s)");
    jPanel19.add(jLabel1);

    lblTotal.setFont(Theme.PRIMARY.FONT.tableFontBig(12)
    );
    lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    lblTotal.setText("Total: ");
    jPanel19.add(lblTotal);

    jPanel18.add(jPanel19, java.awt.BorderLayout.NORTH);

    panelServiceCredits.setOpaque(false);

    javax.swing.GroupLayout panelServiceCreditsLayout = new javax.swing.GroupLayout(panelServiceCredits);
    panelServiceCredits.setLayout(panelServiceCreditsLayout);
    panelServiceCreditsLayout.setHorizontalGroup(
        panelServiceCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 340, Short.MAX_VALUE)
    );
    panelServiceCreditsLayout.setVerticalGroup(
        panelServiceCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 67, Short.MAX_VALUE)
    );

    jPanel18.add(panelServiceCredits, java.awt.BorderLayout.CENTER);

    jPanel8.add(jPanel18, java.awt.BorderLayout.CENTER);

    add(jPanel8, java.awt.BorderLayout.EAST);

    jPanel12.setOpaque(false);
    jPanel12.setPreferredSize(new java.awt.Dimension(780, 20));

    javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
    jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
            .addContainerGap(424, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    jPanel12Layout.setVerticalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    add(jPanel12, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void lblNxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNxtMouseClicked
        current += SET;
        pageCounter++;
        firstPage = false;
        lastPage = pageCounter == numberOfPagesSet;

    
        createPagination(current);

    }//GEN-LAST:event_lblNxtMouseClicked

    private void lblPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrevMouseClicked
        current -= SET;
        pageCounter--;
        lastPage = false;
        firstPage = current == 1;

        createPagination(current);
    }//GEN-LAST:event_lblPrevMouseClicked

    private void dateChooserOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserOnSelectionChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dateChooserOnSelectionChange

    private void dateChooserOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserOnCommit
        try {

            String date = dateChooser.getText();
            java.sql.Date _date = java.sql.Date.valueOf(UtilClass.convertToSqlDate(date));
            leaveLogs = controller.getLeaveLogServiceCreditbyDate(employee, _date);
            update();
        } catch (java.sql.SQLException e) {

        }
    }//GEN-LAST:event_dateChooserOnCommit

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
            leaveLogs =  controller.getLeaveLogs(employee);
             update();
       }catch (java.sql.SQLException e) {

       }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSearchRefNumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchRefNumKeyPressed
        char c = evt.getKeyChar();
        if(!Character.isDigit(c) && evt.getKeyCode() != java.awt.event.KeyEvent.VK_BACK_SPACE){
            txtSearchRefNum.setEditable(false);
        }else{
            txtSearchRefNum.setEditable(true);
        }
    }//GEN-LAST:event_txtSearchRefNumKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         try {
             String refNum = txtSearchRefNum.getText();

            leaveLogs = controller.searchByReferenceNumber(employee, refNum);
            update();
            if(!leaveLogs.isEmpty()){
                selectedLeaveForm = leaveLogs.get(0);
                 setDetails();
            }
           
        } catch (java.sql.SQLException e) {

        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonContainer;
    private javax.swing.JComboBox<String> cmbSort;
    private datechooser.beans.DateChooserCombo dateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lblDateFiled;
    private javax.swing.JLabel lblDetails;
    private javax.swing.JLabel lblEnd;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblLeaveType;
    private javax.swing.JLabel lblNxt;
    private javax.swing.JLabel lblPrev;
    private javax.swing.JLabel lblStart;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelLogs;
    private javax.swing.JPanel panelServiceCredits;
    private javax.swing.JTextField txtSearchRefNum;
    // End of variables declaration//GEN-END:variables
}
