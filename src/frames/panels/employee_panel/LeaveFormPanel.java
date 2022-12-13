/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.panels.employee_panel;

import data.controllers.LeaveFormController;
import data.controllers.form.LeaveFormValidation;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.LeaveForm;
import data.model.LeaveType;
import frames.MainFrame;
import frames.components.LeaveTypeRadioButton;
import frames.components.windows.LeaveServiceCreditWindow;
import java.awt.Color;
import java.awt.Component;


import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import java.util.List;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import otherclasses.CircleBorder;


import otherclasses.UtilClass;
import pnhsems.InvalidInputException;
import themes.Theme;
/*
 * @author root
 */
public class LeaveFormPanel extends javax.swing.JPanel  {

    private final MainFrame root;
    private  SidePanelEmployeeProfile parent;

    private Employee employee;
    List<LeaveType> leaveTypes;
    

    
   // List<EmployeeServiceCredit> inUsedServiceCredits = new ArrayList<>();//current used Service Credit
    List<EmployeeServiceCredit> employeeServiceCredits;//all service credit of available fot employee
    LeaveFormController controller = new LeaveFormController();
    
    private LeaveType selectedLeaveType;
    private LeaveForm leaveForm = new LeaveForm();
    
    private JPanel activeDetailPanel;
   int usedCredits;
    
    
    private Calendar end ;
    
    boolean validDate;
   private String selectedDetails;
    private String otherDetails;//for textField
    

    /**
     * Creates new form LeaveFormPanel
     * @param root for disabling frame one mini window is opened
     * @param employee, to get the employee details
     */
    public LeaveFormPanel(MainFrame root, Employee employee) {
        initComponents();
        this.root = root;

        this.employee = employee;
        
        leaveForm.setEmployee(employee);

        try{
            employeeServiceCredits = controller.getEmployeeServiceCredits(employee.getId());
        }catch(SQLException e){
            e.printStackTrace();
        }
        

       
        init();
    }
 
    
    public void setParent(SidePanelEmployeeProfile parent){
        this.parent = parent;
    }
    public void setServiceCredit(EmployeeServiceCredit employeeServiceCredit){
     
         leaveForm.addServicCredit(employeeServiceCredit);
         
         int size =  leaveForm.getServiceCredit().size();
         
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
        
        
        startDate.setEnabled(false);
        endDate.setEnabled(false);
        
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
                    else if (selectedLeaveType.getId() == 4) {
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
                selectedDetails = radioOthers.getText();
                System.out.println(selectedDetails);
              
                if(activeDetailPanel!=null)activeDetailPanel.setVisible(false);
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
         
        if(! leaveForm.getServiceCredit().isEmpty() ){
            lblBadge.setVisible(true);
            lblBadge.setText(String.valueOf( leaveForm.getServiceCredit().size()));
        }else{
            lblBadge.setVisible(false);
        }
        usedCredits =UtilClass.getTotalUsedCredits(leaveForm.getServiceCredit());
         lblServiceCredits.setText("Service Credits(" + leaveForm.getServiceCredit().size() + ") ");
        lblCredits.setText("("+usedCredits+"/"+UtilClass.getTotalCredits(leaveForm.getServiceCredit())+")");
    }
    
    public void updateLeaveForm( List<EmployeeServiceCredit> inUsedServiceCredits){
         leaveForm.setServiceCredit(inUsedServiceCredits);
         updateBadge();
         if(usedCredits>0){
             startDate.setEnabled(true);
             endDate.setEnabled(true);
         }
        
    }
    
    
    
    private void leaveDetails(){

        btnGroupVacationLeave.add(radioWithinPh);
        radioWithinPh.addItemListener((ItemEvent e) -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {
                specifyWithinPh.setVisible(true);
                specifyAbroad.setVisible(false);
                selectedDetails = radioWithinPh.getText();
                otherDetails =null;
            }
        });

        btnGroupVacationLeave.add(radioAbroad);
        radioAbroad.addItemListener((ItemEvent e) -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {
                specifyWithinPh.setVisible(false);
                specifyAbroad.setVisible(true);
                selectedDetails = radioAbroad.getText();
                 otherDetails =null;
            }
        });

        ButtonGroup btnGroupSickLeave = new ButtonGroup();
        btnGroupSickLeave.add(radioInHospital);
        btnGroupSickLeave.add(radioOutPatient);

        radioInHospital.addItemListener((ItemEvent e) -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {
                panelInHospital.setVisible(true);
                panelOutPatient.setVisible(false);
                selectedDetails = radioInHospital.getText();
                 otherDetails =null;

            }
        });

        radioOutPatient.addItemListener((ItemEvent e) -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {
                panelInHospital.setVisible(false);
                panelOutPatient.setVisible(true);
                selectedDetails = radioOutPatient.getText();
                 otherDetails =null;
            }
        });

        ButtonGroup studyLeave = new ButtonGroup();
        studyLeave.add(radioMaster);
        studyLeave.add(radioBar);

        radioMaster.addItemListener((ItemEvent e) -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {

                selectedDetails = radioMaster.getText();
                 otherDetails =null;
            }
        });
        radioBar.addItemListener((ItemEvent e) -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {

                selectedDetails = radioBar.getText();
                 otherDetails =null;
            }
        });

        ButtonGroup otherLeave = new ButtonGroup();
        otherLeave.add(radioMonetize);
        otherLeave.add(radioTerminal);

        radioMonetize.addItemListener((ItemEvent e) -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {

                selectedDetails = radioMonetize.getText();
                 otherDetails =null;
            }
        });
        radioTerminal.addItemListener((ItemEvent e) -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {

                selectedDetails = radioTerminal.getText();
                 otherDetails =null;
            }
        });
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
        txtOthers = new javax.swing.JTextField();
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
        lblCredits = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        startDate = new datechooser.beans.DateChooserCombo();
        jPanel41 = new javax.swing.JPanel();
        endDate = new datechooser.beans.DateChooserCombo();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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
        radioBar = new javax.swing.JRadioButton();
        radioMaster = new javax.swing.JRadioButton();
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

        txtOthers.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOthersFocusLost(evt);
            }
        });
        specifyPanel.add(txtOthers, java.awt.BorderLayout.CENTER);

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
        jPanel10.add(lblServiceCredits, java.awt.BorderLayout.WEST);

        lblCredits.setForeground(new java.awt.Color(153, 153, 153));
        lblCredits.setText("(0/0)");
        jPanel10.add(lblCredits, java.awt.BorderLayout.CENTER);

        jPanel21.add(jPanel10, java.awt.BorderLayout.NORTH);

        jPanel37.setLayout(new java.awt.BorderLayout());

        jPanel39.setLayout(new java.awt.GridLayout(2, 0));

        jPanel40.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel40.setLayout(new java.awt.BorderLayout());

        jLabel29.setText("Start Date");
        jLabel29.setPreferredSize(new java.awt.Dimension(80, 50));
        jPanel40.add(jLabel29, java.awt.BorderLayout.WEST);

        jLabel27.setPreferredSize(new java.awt.Dimension(40, 17));
        jPanel40.add(jLabel27, java.awt.BorderLayout.EAST);

        startDate.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
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
    startDate.setFieldFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14));
    startDate.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
        public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
            startDateOnSelectionChange(evt);
        }
    });
    startDate.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            startDateOnCommit(evt);
        }
    });
    jPanel40.add(startDate, java.awt.BorderLayout.CENTER);

    jPanel39.add(jPanel40);

    jPanel41.setPreferredSize(new java.awt.Dimension(100, 30));
    jPanel41.setLayout(new java.awt.BorderLayout());

    endDate.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
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
endDate.setFieldFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14));
endDate.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
    public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
        endDateOnSelectionChange(evt);
    }
    });
    jPanel41.add(endDate, java.awt.BorderLayout.CENTER);

    jLabel30.setText("End Date");
    jLabel30.setPreferredSize(new java.awt.Dimension(80, 50));
    jPanel41.add(jLabel30, java.awt.BorderLayout.WEST);

    jLabel31.setPreferredSize(new java.awt.Dimension(40, 17));
    jPanel41.add(jLabel31, java.awt.BorderLayout.EAST);

    jPanel39.add(jPanel41);

    jPanel37.add(jPanel39, java.awt.BorderLayout.NORTH);

    jLabel32.setPreferredSize(new java.awt.Dimension(0, 10));
    jPanel37.add(jLabel32, java.awt.BorderLayout.PAGE_END);

    jLabel34.setPreferredSize(new java.awt.Dimension(30, 17));
    jPanel37.add(jLabel34, java.awt.BorderLayout.LINE_START);

    jLabel35.setPreferredSize(new java.awt.Dimension(30, 17));
    jPanel37.add(jLabel35, java.awt.BorderLayout.LINE_END);

    jButton1.setBackground(new java.awt.Color(0, 153, 0));
    jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
    jButton1.setForeground(new java.awt.Color(255, 255, 255));
    jButton1.setText("Save");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    jPanel37.add(jButton1, java.awt.BorderLayout.CENTER);

    jPanel21.add(jPanel37, java.awt.BorderLayout.CENTER);

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

    jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            jTextField3FocusLost(evt);
        }
    });
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

    jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            jTextField2FocusLost(evt);
        }
    });
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

    radioBar.setText("BAR/Board Examination");
    jPanel30.add(radioBar);

    radioMaster.setText("Completion of Master's Degree");
    jPanel30.add(radioMaster);

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

    jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            jTextField5FocusLost(evt);
        }
    });
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

    jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            jTextField4FocusLost(evt);
        }
    });
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
        
        //pass , this panel ref, inusedServiceCredit, unusedServiceCredit
        
        /**
         * @param mainframe reference to re-enable background frame
         * @param this, pass this panel reference to update serviceCredit list
         * @param inUsedServiceCredits currently selected service credits 
         * @param getAvailableLeaveFormServiceCredits get all available service credit of employee and extract unused
         */
        lw.setFrame(root,this,leaveForm.getServiceCredit(),controller.getAvailableLeaveFormServiceCredits(employeeServiceCredits, leaveForm.getServiceCredit()));
        root.setEnabled(false);
        lw.setVisible(true);
    }//GEN-LAST:event_jPanel36MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
//        Calendar start = Calendar.getInstance();
//        Calendar _end = Calendar.getInstance();
//
//        String[] start_str = startDate.getText().split("/");
//        String[] end_str = endDate.getText().split("/");
//        start.set(Calendar.YEAR, Integer.parseInt(start_str[2]));
//        start.set(Calendar.MONTH, Integer.parseInt(start_str[1]) - 1);
//        start.set(Calendar.DATE, Integer.parseInt(start_str[0]));
//
//        _end.set(Calendar.YEAR, Integer.parseInt(end_str[2]));
//        _end.set(Calendar.MONTH, Integer.parseInt(end_str[1]) - 1);
//        _end.set(Calendar.DATE, Integer.parseInt(end_str[0]));
//
//       
//        int additionalDate = usedCredits -2;
//        start.add(Calendar.DATE, additionalDate);
//        if (!start.before(end)) {
//
//            JOptionPane.showMessageDialog(this, "Invalid Date");
//        } else {
//            JOptionPane.showMessageDialog(this, "valid Date");
//        }
        if (validDate) {
            
           
            String _startDate = startDate.getText();
            String _endDate = endDate.getText();

            java.sql.Date date1 = java.sql.Date.valueOf(UtilClass.convertToSqlDate(_startDate));
            java.sql.Date date2 = java.sql.Date.valueOf(UtilClass.convertToSqlDate(_endDate));
       

            leaveForm.setInclusiveDate_start(date1);
            leaveForm.setInclusiveDate_end(date2);
            leaveForm.setLeaveType(selectedLeaveType);
            leaveForm.setDateFiled(UtilClass.getCurrentDate());
            leaveForm.setDetails(LeaveFormValidation.checkField(selectedDetails, otherDetails));
            leaveForm.setLeaveType(selectedLeaveType);
          
            leaveForm.setCreditUsed(usedCredits);
            
            try{
                if(controller.addLeave(leaveForm)==1){
                    JOptionPane.showMessageDialog(this, "Leave Successfully saved");
                    parent.exitForm();
                }
                
            }catch(SQLException e){
                e.printStackTrace();
            }catch(InvalidInputException iie){
                 JOptionPane.showMessageDialog(this, iie.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(this, "Invalid Date");
        }



 System.out.println(UtilClass.getCurrentDate().toString());


    }//GEN-LAST:event_jButton1ActionPerformed

    private void startDateOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_startDateOnSelectionChange
        Calendar start = startDate.getSelectedDate();
        
        
       
        if (usedCredits > 0) {
            
               int additionalDate = usedCredits - 1;
               start.add(Calendar.DAY_OF_WEEK, additionalDate);
        }

        endDate.setSelectedDate(start);
        end = endDate.getSelectedDate();
    }//GEN-LAST:event_startDateOnSelectionChange

    private void startDateOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_startDateOnCommit

    }//GEN-LAST:event_startDateOnCommit

    private void endDateOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_endDateOnSelectionChange
       
       
       Calendar start = Calendar.getInstance();
        
        String[] start_str = startDate.getText().split("/");
       
        start.set(Calendar.YEAR, Integer.parseInt(start_str[2]));
        start.set(Calendar.MONTH, Integer.parseInt(start_str[1]) - 1);
        start.set(Calendar.DATE, Integer.parseInt(start_str[0]));

        
        end = endDate.getSelectedDate();
       
        int additionalDate = usedCredits -2;
        start.add(Calendar.DATE, additionalDate);
       
       
//       Calendar _end = Calendar.getInstance();
//       String[] end_str = endDate.getText().split("/"); 
//        _end.set(Calendar.YEAR, Integer.parseInt(end_str[2]));
//        _end.set(Calendar.MONTH, Integer.parseInt(end_str[1]) - 1);
//        _end.set(Calendar.DATE, Integer.parseInt(end_str[0])-1);
//
//       
//        
//        System.out.println(_end.before(end));
        if(!start.before(end)){
             this.validDate =false;
            
        
          for(Component c : endDate.getComponents()){
              ((JComponent)c).setForeground(Color.red);
          }
          
             
        }else{
             this.validDate =true;
             for(Component c : endDate.getComponents()){
              ((JComponent)c).setForeground(Color.black);
          }
        }
       
        
    }//GEN-LAST:event_endDateOnSelectionChange

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        otherDetails=jTextField3.getText();
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        otherDetails=jTextField2.getText();
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
         otherDetails=jTextField5.getText();
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
         otherDetails=jTextField4.getText();
    }//GEN-LAST:event_jTextField4FocusLost

    private void txtOthersFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOthersFocusLost
          otherDetails=txtOthers.getText();
    }//GEN-LAST:event_txtOthersFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abroad;
    private javax.swing.ButtonGroup btnGroupLeaveType;
    private javax.swing.ButtonGroup btnGroupVacationLeave;
    private datechooser.beans.DateChooserCombo endDate;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
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
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblBadge;
    private javax.swing.JLabel lblCredits;
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
    private javax.swing.JRadioButton radioBar;
    private javax.swing.JRadioButton radioInHospital;
    private javax.swing.JRadioButton radioMaster;
    private javax.swing.JRadioButton radioMonetize;
    private javax.swing.JRadioButton radioOthers;
    private javax.swing.JRadioButton radioOutPatient;
    private javax.swing.JRadioButton radioTerminal;
    private javax.swing.JRadioButton radioWithinPh;
    private javax.swing.JPanel sickLeavePanel;
    private javax.swing.JPanel specifyAbroad;
    private javax.swing.JPanel specifyPanel;
    private javax.swing.JPanel specifyWithinPh;
    private datechooser.beans.DateChooserCombo startDate;
    private javax.swing.JPanel studyLeavePanel;
    private javax.swing.JTextField txtOthers;
    private javax.swing.JPanel vacationLeavePanel;
    // End of variables declaration//GEN-END:variables

 

}
