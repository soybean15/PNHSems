/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.panels.employee_panel;

import data.controllers.LeaveFormController;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.LeaveType;
import data.model.ServiceCredit;
import frames.MainFrame;
import frames.components.LeaveTypeRadioButton;
import frames.components.windows.LeaveServiceCreditWindow;
import java.awt.Color;


import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import otherclasses.CircleBorder;


import otherclasses.UtilClass;
import themes.Theme;
/*
 * @author root
 */
public class LeaveFormPanel extends javax.swing.JPanel  {

    private final MainFrame root;

    private Employee employee;
    List<LeaveType> leaveTypes;
    

    
    List<EmployeeServiceCredit> leaveFormServiceCredits = new ArrayList<>();
    List<EmployeeServiceCredit> employeeServiceCredits;
    LeaveFormController controller = new LeaveFormController();
    
    private LeaveType selectedLeaveType;
    
    private JPanel activeDetailPanel;
    

    /**
     * Creates new form LeaveFormPanel
     * @param root for disabling frame one mini window is opened
     * @param employee, to get the employee details
     */
    public LeaveFormPanel(MainFrame root, Employee employee) {
        initComponents();
        this.root = root;

        this.employee = employee;

        try{
            employeeServiceCredits = controller.getEmployeeServiceCredits(employee.getId());
        }catch(SQLException e){
            e.printStackTrace();
        }
        

        lblServiceCredits.setText("Service Credits(" + leaveFormServiceCredits.size() + ") ");
        init();
    }
 
    public void setServiceCredit(EmployeeServiceCredit employeeServiceCredit){
     
         leaveFormServiceCredits.add(employeeServiceCredit);
         
         int size = leaveFormServiceCredits.size();
         
         lblServiceCredits.setText("Service Credits("+size+") ");
         updateBadge();
    }
    
    private void getLeaveTypes(){
        try{
            this.leaveTypes = controller.getLeaveTypes();
        }catch(SQLException e){
            
        }
    }
    
    private void init(){
        
        
        
        lblDateOfFiling.setText(" "+UtilClass.getCurrent());
        lblFirstName.setText(employee.getFirstName());
        lblLastName.setText(employee.getLastName());
        lblMiddleName.setText(employee.getMiddleName());
        lblPosition.setText(" "+employee.getPosition().getName());
        
        
         getLeaveTypes();
         hideComponent();
         showLeaveTypes();
         leaveDetails();
         
         
       
         
       
    }
    
    public void showLeaveTypes() {
        int row = leaveTypes.size();

        leaveTypeList.setLayout(new GridLayout(row, 0));

        for (LeaveType leaveType : leaveTypes) {
            LeaveTypeRadioButton radio = new LeaveTypeRadioButton(leaveType);

            String text = "<html><b>" + leaveType.getName() + "</b><font size=2>(" + leaveType.getReference() + ")</font></html>";

            radio.addItemListener((ItemEvent e) -> {
                LeaveTypeRadioButton radio1 = (LeaveTypeRadioButton) e.getItem();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    
                    radio1.setForeground(Color.red);
                    selectedLeaveType = radio1.getLeaveType();
                    if (activeDetailPanel != null) {
                        activeDetailPanel.setVisible(false);
                    }
                    
                    if (selectedLeaveType.getId() == 1) {
                        vacationLeavePanel.setVisible(true);
                        activeDetailPanel = vacationLeavePanel;
                    }
                    
                    
                    else if (selectedLeaveType.getId() == 1) {
                        sickLeavePanel.setVisible(true);
                        activeDetailPanel = sickLeavePanel;
                    }
                    
                    else if (selectedLeaveType.getId() == 3) {
                        sickLeavePanel.setVisible(true);
                        activeDetailPanel = sickLeavePanel;
                    }  
                    else if (selectedLeaveType.getId() == 8) {
                        studyLeavePanel.setVisible(true);
                        activeDetailPanel = studyLeavePanel;
                    }else{
                        otherPurposePanel.setVisible(true);
                        activeDetailPanel =otherPurposePanel;
                    }
                    
                    
                } else {
                    radio1.setForeground(Color.BLACK);
                }
            });

            radio.setText(text);
            radio.setFont(Theme.PRIMARY.FONT.tableFontDefault(12));
            leaveTypeList.add(radio);
            btnGroupLeaveType.add(radio);

        }

        radioOthers.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {

                specifyPanel.setVisible(true);
                selectedLeaveType =null;
              
                
            } else {
                specifyPanel.setVisible(false);

            }
        });

        btnGroupLeaveType.add(radioOthers);
    }
    
       private void hideComponent() {
        //others specify
        specifyPanel.setVisible(false);

        vacationLeavePanel.setVisible(false);
        sickLeavePanel.setVisible(false);
        studyLeavePanel.setVisible(false);
        otherPurposePanel.setVisible(false);

        specifyAbroad.setVisible(false);
        specifyWithinPh.setVisible(false);

        panelInHospital.setVisible(false);
        panelOutPatient.setVisible(false);
       
        updateBadge();
    }
       
       
    private void updateBadge(){
         
        if(!leaveFormServiceCredits.isEmpty() ){
            lblBadge.setVisible(true);
            lblBadge.setText(String.valueOf(leaveFormServiceCredits.size()));
        }else{
            lblBadge.setVisible(false);
        }
    }
    private void leaveDetails(){
        
        btnGroupVacationLeave.add(radioWithinPh);
        radioWithinPh.addItemListener((ItemEvent e) -> {
               
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    specifyWithinPh.setVisible(true);
                    specifyAbroad.setVisible(false);
                } 
            });
        
        btnGroupVacationLeave.add(radioAbroad);
        radioAbroad.addItemListener((ItemEvent e) -> {
               
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    specifyWithinPh.setVisible(false);
                    specifyAbroad.setVisible(true);
                } 
            });
        
        
        ButtonGroup btnGroupSickLeave = new ButtonGroup();
        btnGroupSickLeave.add(radioInHospital);
        btnGroupSickLeave.add(radioOutPatient);

        radioInHospital.addItemListener((ItemEvent e) -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {
                panelInHospital.setVisible(true);
                panelOutPatient.setVisible(false);
            }
        });
        
         radioOutPatient.addItemListener((ItemEvent e) -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {
                panelInHospital.setVisible(false);
                panelOutPatient.setVisible(true);
            }
        });
         
         
                 
        ButtonGroup otherSickLeave = new ButtonGroup();
        otherSickLeave.add(radioMonetize);
        otherSickLeave.add(radioTerminal);
        

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupLeaveType = new javax.swing.ButtonGroup();
        btnGroupVacationLeave = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblDateOfFiling = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lblLastName = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblMiddleName = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        part1 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        leaveTypeList = new javax.swing.JPanel();
        othersPanel = new javax.swing.JPanel();
        radioOthers = new javax.swing.JRadioButton();
        specifyPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        lblBadge = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblServiceCredits = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        vacationLeavePanel = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        abroad = new javax.swing.JPanel();
        radioAbroad = new javax.swing.JRadioButton();
        specifyAbroad = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        radioWithinPh = new javax.swing.JRadioButton();
        specifyWithinPh = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        studyLeavePanel = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        sickLeavePanel = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        radioOutPatient = new javax.swing.JRadioButton();
        panelOutPatient = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        radioInHospital = new javax.swing.JRadioButton();
        panelInHospital = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        otherPurposePanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        radioMonetize = new javax.swing.JRadioButton();
        radioTerminal = new javax.swing.JRadioButton();
        jPanel34 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(Theme.PRIMARY.COLOR.background_secondary);
        jPanel1.setMinimumSize(new java.awt.Dimension(613, 100));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(613, 120));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(613, 20));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Norasi", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("APPLICATION FOR LEAVE");
        jPanel2.add(jLabel1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 100));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setText("1. Office/Department");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jPanel5.add(jLabel3);

        jPanel3.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel4.setText("3.Date of Filing");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel6.add(jLabel4);

        lblDateOfFiling.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        lblDateOfFiling.setForeground(new java.awt.Color(51, 51, 51));
        jPanel6.add(lblDateOfFiling);

        jPanel3.add(jPanel6);

        jPanel1.add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel7.setForeground(new java.awt.Color(153, 153, 153));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(2, 0));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel13.setText("1. Name");
        jLabel13.setPreferredSize(new java.awt.Dimension(60, 20));
        jPanel9.add(jLabel13, java.awt.BorderLayout.WEST);

        jPanel11.setOpaque(false);
        jPanel11.setLayout(new java.awt.GridLayout(1, 3));

        jLabel6.setText("(Last)");
        jPanel11.add(jLabel6);

        jLabel5.setText("(First)");
        jPanel11.add(jLabel5);

        jLabel7.setText("(Middle)");
        jPanel11.add(jLabel7);

        jPanel9.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel9);

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel14.setText(" ");
        jLabel14.setPreferredSize(new java.awt.Dimension(60, 20));
        jPanel12.add(jLabel14, java.awt.BorderLayout.WEST);

        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.GridLayout(1, 3));

        lblLastName.setForeground(new java.awt.Color(51, 51, 51));
        jPanel13.add(lblLastName);

        lblFirstName.setForeground(new java.awt.Color(51, 51, 51));
        jPanel13.add(lblFirstName);

        lblMiddleName.setForeground(new java.awt.Color(51, 51, 51));
        jPanel13.add(lblMiddleName);

        jPanel12.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel12);

        jPanel4.add(jPanel7);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel8.setForeground(new java.awt.Color(153, 153, 153));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridLayout(2, 4));

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel8.setText("4. Position");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel8.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel9.setText("5. Salary");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel8.add(jLabel9);

        lblPosition.setForeground(new java.awt.Color(51, 51, 51));
        lblPosition.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel8.add(lblPosition);

        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel8.add(jLabel11);

        jPanel4.add(jPanel8);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel14.setOpaque(false);
        jPanel14.setPreferredSize(new java.awt.Dimension(100, 30));
        add(jPanel14, java.awt.BorderLayout.SOUTH);

        jPanel35.setOpaque(false);
        jPanel35.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel35.setLayout(new javax.swing.OverlayLayout(jPanel35));

        part1.setOpaque(false);
        part1.setLayout(new java.awt.BorderLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel12.setText("3. Type of leave to be availed of");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel15.add(jLabel12, java.awt.BorderLayout.NORTH);

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.BorderLayout());

        jLabel15.setText(" ");
        jPanel18.add(jLabel15, java.awt.BorderLayout.PAGE_START);

        leaveTypeList.setOpaque(false);
        jPanel18.add(leaveTypeList, java.awt.BorderLayout.CENTER);

        othersPanel.setOpaque(false);
        othersPanel.setPreferredSize(new java.awt.Dimension(100, 30));
        othersPanel.setLayout(new java.awt.BorderLayout());

        radioOthers.setFont(Theme.PRIMARY.FONT.tableFontBig(10)
        );
        radioOthers.setText("Other");
        radioOthers.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioOthersStateChanged(evt);
            }
        });
        radioOthers.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                radioOthersFocusLost(evt);
            }
        });
        radioOthers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOthersActionPerformed(evt);
            }
        });
        othersPanel.add(radioOthers, java.awt.BorderLayout.WEST);

        specifyPanel.setOpaque(false);
        specifyPanel.setLayout(new java.awt.BorderLayout());

        jLabel16.setText(" Specify: ");
        specifyPanel.add(jLabel16, java.awt.BorderLayout.LINE_START);
        specifyPanel.add(jTextField1, java.awt.BorderLayout.CENTER);

        othersPanel.add(specifyPanel, java.awt.BorderLayout.CENTER);

        jPanel18.add(othersPanel, java.awt.BorderLayout.SOUTH);

        jPanel15.add(jPanel18, java.awt.BorderLayout.CENTER);

        part1.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel16.setOpaque(false);
        jPanel16.setPreferredSize(new java.awt.Dimension(350, 100));
        jPanel16.setRequestFocusEnabled(false);
        jPanel16.setLayout(new java.awt.BorderLayout());

        jLabel17.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel17.setText("3. Type of leave to be availed of");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel16.add(jLabel17, java.awt.BorderLayout.NORTH);

        jPanel19.setOpaque(false);
        jPanel19.setLayout(new java.awt.BorderLayout());

        jLabel18.setText(" ");
        jLabel18.setPreferredSize(new java.awt.Dimension(4, 5));
        jPanel19.add(jLabel18, java.awt.BorderLayout.NORTH);

        jPanel20.setOpaque(false);
        jPanel20.setLayout(new java.awt.BorderLayout());

        jPanel21.setOpaque(false);
        jPanel21.setPreferredSize(new java.awt.Dimension(100, 200));
        jPanel21.setLayout(new java.awt.BorderLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel10.setForeground(new java.awt.Color(255, 102, 102));
        jPanel10.setOpaque(false);
        jPanel10.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel36.setOpaque(false);
        jPanel36.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel36MouseClicked(evt);
            }
        });
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBadge.setBackground(new java.awt.Color(255, 0, 0));
        lblBadge.setFont(new java.awt.Font("Liberation Sans", 1, 10)); // NOI18N
        lblBadge.setForeground(new java.awt.Color(255, 255, 255));
        lblBadge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBadge.setText("5");
        lblBadge.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblBadge.setOpaque(true);
        lblBadge.setPreferredSize(new java.awt.Dimension(10, 10));
        lblBadge.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        lblBadge.setBorder(new CircleBorder(Color.red, 1));
        jPanel36.add(lblBadge, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 0, 13, 13));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/credit-card(1).png"))); // NOI18N
        jLabel24.setPreferredSize(new java.awt.Dimension(25, 25));
        jPanel36.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 24, 24));

        jPanel10.add(jPanel36, java.awt.BorderLayout.EAST);

        lblServiceCredits.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        lblServiceCredits.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblServiceCredits.setText("Service Credits ");
        jPanel10.add(lblServiceCredits, java.awt.BorderLayout.CENTER);

        jPanel21.add(jPanel10, java.awt.BorderLayout.NORTH);

        jPanel20.add(jPanel21, java.awt.BorderLayout.PAGE_END);

        jPanel22.setOpaque(false);
        jPanel22.setLayout(new javax.swing.OverlayLayout(jPanel22));

        vacationLeavePanel.setOpaque(false);
        vacationLeavePanel.setPreferredSize(new java.awt.Dimension(253, 150));
        vacationLeavePanel.setLayout(new java.awt.BorderLayout());

        jPanel31.setOpaque(false);
        jPanel31.setPreferredSize(new java.awt.Dimension(20, 100));
        vacationLeavePanel.add(jPanel31, java.awt.BorderLayout.WEST);

        jPanel25.setOpaque(false);
        jPanel25.setLayout(new java.awt.GridLayout(2, 0));

        abroad.setOpaque(false);
        abroad.setLayout(new java.awt.GridLayout(2, 0));

        radioAbroad.setText("Abroad");
        radioAbroad.setPreferredSize(new java.awt.Dimension(170, 20));
        abroad.add(radioAbroad);

        specifyAbroad.setOpaque(false);
        specifyAbroad.setLayout(new java.awt.BorderLayout());

        jLabel20.setText("Specify:");
        specifyAbroad.add(jLabel20, java.awt.BorderLayout.LINE_START);
        specifyAbroad.add(jTextField3, java.awt.BorderLayout.CENTER);

        abroad.add(specifyAbroad);

        jPanel25.add(abroad);

        jPanel23.setOpaque(false);
        jPanel23.setLayout(new java.awt.GridLayout(2, 0));

        radioWithinPh.setText("Within the Philippines    ");
        radioWithinPh.setPreferredSize(new java.awt.Dimension(170, 20));
        jPanel23.add(radioWithinPh);

        specifyWithinPh.setOpaque(false);
        specifyWithinPh.setLayout(new java.awt.BorderLayout());

        jLabel19.setText("Specify:");
        specifyWithinPh.add(jLabel19, java.awt.BorderLayout.LINE_START);
        specifyWithinPh.add(jTextField2, java.awt.BorderLayout.CENTER);

        jPanel23.add(specifyWithinPh);

        jPanel25.add(jPanel23);

        vacationLeavePanel.add(jPanel25, java.awt.BorderLayout.CENTER);

        jPanel27.setOpaque(false);
        jPanel27.setPreferredSize(new java.awt.Dimension(100, 10));
        vacationLeavePanel.add(jPanel27, java.awt.BorderLayout.SOUTH);

        jLabel25.setFont(new java.awt.Font("Liberation Sans", 2, 13)); // NOI18N
        jLabel25.setText("     In Case of Vacation/Special Privelege Leave");
        jLabel25.setPreferredSize(new java.awt.Dimension(253, 30));
        vacationLeavePanel.add(jLabel25, java.awt.BorderLayout.NORTH);

        jPanel22.add(vacationLeavePanel);
        vacationLeavePanel.getAccessibleContext().setAccessibleName("");

        studyLeavePanel.setOpaque(false);
        studyLeavePanel.setLayout(new java.awt.BorderLayout());

        jPanel30.setOpaque(false);
        jPanel30.setLayout(new java.awt.GridLayout(3, 0));

        jRadioButton6.setText("BAR/Board Examination");
        jPanel30.add(jRadioButton6);

        jRadioButton5.setText("Completion of Master's Degree");
        jPanel30.add(jRadioButton5);

        studyLeavePanel.add(jPanel30, java.awt.BorderLayout.CENTER);

        jLabel26.setFont(new java.awt.Font("Liberation Sans", 2, 13)); // NOI18N
        jLabel26.setText("    In Case Of Study Leave");
        jLabel26.setPreferredSize(new java.awt.Dimension(48, 30));
        studyLeavePanel.add(jLabel26, java.awt.BorderLayout.PAGE_START);

        jPanel32.setOpaque(false);
        jPanel32.setPreferredSize(new java.awt.Dimension(20, 100));
        studyLeavePanel.add(jPanel32, java.awt.BorderLayout.WEST);

        jPanel22.add(studyLeavePanel);

        sickLeavePanel.setOpaque(false);
        sickLeavePanel.setLayout(new java.awt.BorderLayout());

        jPanel26.setOpaque(false);
        jPanel26.setLayout(new java.awt.GridLayout(2, 0));

        jPanel29.setOpaque(false);
        jPanel29.setLayout(new java.awt.GridLayout(2, 0));

        radioOutPatient.setText("Out Patient");
        radioOutPatient.setPreferredSize(new java.awt.Dimension(170, 20));
        jPanel29.add(radioOutPatient);

        panelOutPatient.setOpaque(false);
        panelOutPatient.setLayout(new java.awt.BorderLayout());

        jLabel22.setText("Specify:");
        panelOutPatient.add(jLabel22, java.awt.BorderLayout.LINE_START);
        panelOutPatient.add(jTextField5, java.awt.BorderLayout.CENTER);

        jPanel29.add(panelOutPatient);

        jPanel26.add(jPanel29);

        jPanel24.setOpaque(false);
        jPanel24.setLayout(new java.awt.GridLayout(2, 0));

        radioInHospital.setText("In Hospital");
        radioInHospital.setPreferredSize(new java.awt.Dimension(170, 20));
        radioInHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioInHospitalActionPerformed(evt);
            }
        });
        jPanel24.add(radioInHospital);

        panelInHospital.setOpaque(false);
        panelInHospital.setLayout(new java.awt.BorderLayout());

        jLabel21.setText("Specify:");
        panelInHospital.add(jLabel21, java.awt.BorderLayout.LINE_START);
        panelInHospital.add(jTextField4, java.awt.BorderLayout.CENTER);

        jPanel24.add(panelInHospital);

        jPanel26.add(jPanel24);

        sickLeavePanel.add(jPanel26, java.awt.BorderLayout.CENTER);

        jLabel28.setFont(new java.awt.Font("Liberation Sans", 2, 13)); // NOI18N
        jLabel28.setText("     In Case Of Sick Leave");
        jLabel28.setPreferredSize(new java.awt.Dimension(48, 30));
        sickLeavePanel.add(jLabel28, java.awt.BorderLayout.NORTH);

        jPanel33.setOpaque(false);
        jPanel33.setPreferredSize(new java.awt.Dimension(20, 100));
        sickLeavePanel.add(jPanel33, java.awt.BorderLayout.WEST);

        jPanel22.add(sickLeavePanel);

        otherPurposePanel.setOpaque(false);
        otherPurposePanel.setLayout(new java.awt.BorderLayout());

        jLabel23.setFont(new java.awt.Font("Liberation Sans", 2, 13)); // NOI18N
        jLabel23.setText("     Other Purpose");
        jLabel23.setPreferredSize(new java.awt.Dimension(84, 30));
        otherPurposePanel.add(jLabel23, java.awt.BorderLayout.NORTH);

        jPanel28.setOpaque(false);
        jPanel28.setLayout(new java.awt.GridLayout(3, 0));

        radioMonetize.setText("Monetization of Leave");
        jPanel28.add(radioMonetize);

        radioTerminal.setText("Terminal Leave");
        jPanel28.add(radioTerminal);

        otherPurposePanel.add(jPanel28, java.awt.BorderLayout.CENTER);

        jPanel34.setOpaque(false);
        jPanel34.setPreferredSize(new java.awt.Dimension(20, 100));
        otherPurposePanel.add(jPanel34, java.awt.BorderLayout.WEST);

        jPanel22.add(otherPurposePanel);

        jPanel20.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel19.add(jPanel20, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel19, java.awt.BorderLayout.CENTER);

        part1.add(jPanel16, java.awt.BorderLayout.EAST);

        jPanel17.setOpaque(false);
        jPanel17.setLayout(new java.awt.GridLayout(1, 0));

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("6. DETAILS OF APPLICATION");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel17.add(jLabel10);

        part1.add(jPanel17, java.awt.BorderLayout.NORTH);

        jPanel35.add(part1);

        add(jPanel35, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void radioOthersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOthersActionPerformed
        
    }//GEN-LAST:event_radioOthersActionPerformed

    private void radioOthersFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radioOthersFocusLost
      
    }//GEN-LAST:event_radioOthersFocusLost

    private void radioOthersStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioOthersStateChanged
     
    }//GEN-LAST:event_radioOthersStateChanged

    private void radioInHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioInHospitalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioInHospitalActionPerformed

    private void jPanel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel36MouseClicked
        LeaveServiceCreditWindow lw= new LeaveServiceCreditWindow();
        lw.setFrame(root,leaveFormServiceCredits,controller.getAvailableLeaveFormServiceCredits(employeeServiceCredits, leaveFormServiceCredits));
        root.setEnabled(false);
        lw.setVisible(true);
    }//GEN-LAST:event_jPanel36MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abroad;
    private javax.swing.ButtonGroup btnGroupLeaveType;
    private javax.swing.ButtonGroup btnGroupVacationLeave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblBadge;
    private javax.swing.JLabel lblDateOfFiling;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMiddleName;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblServiceCredits;
    private javax.swing.JPanel leaveTypeList;
    private javax.swing.JPanel otherPurposePanel;
    private javax.swing.JPanel othersPanel;
    private javax.swing.JPanel panelInHospital;
    private javax.swing.JPanel panelOutPatient;
    private javax.swing.JPanel part1;
    private javax.swing.JRadioButton radioAbroad;
    private javax.swing.JRadioButton radioInHospital;
    private javax.swing.JRadioButton radioMonetize;
    private javax.swing.JRadioButton radioOthers;
    private javax.swing.JRadioButton radioOutPatient;
    private javax.swing.JRadioButton radioTerminal;
    private javax.swing.JRadioButton radioWithinPh;
    private javax.swing.JPanel sickLeavePanel;
    private javax.swing.JPanel specifyAbroad;
    private javax.swing.JPanel specifyPanel;
    private javax.swing.JPanel specifyWithinPh;
    private javax.swing.JPanel studyLeavePanel;
    private javax.swing.JPanel vacationLeavePanel;
    // End of variables declaration//GEN-END:variables

 

}
