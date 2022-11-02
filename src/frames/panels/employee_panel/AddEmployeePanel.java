/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.panels.employee_panel;

import data.controllers.EmployeeController;
import data.controllers.form.EmployeeValidation;
import data.model.Employee;
import data.model.Employee_PersonalInfo;
import data.model.Position;
import frames.listener.SidePanelListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import otherclasses.ImageHandler;
import otherclasses.UtilClass;
import pnhsems.InvalidInputException;
import themes.Theme;

/**
 *
 * @author root
 */
public class AddEmployeePanel extends javax.swing.JPanel {

    /**
     * Creates new form AddEmployeePanel
     */
    private String id;
    
    EmployeeController employeeController = new EmployeeController();
    private Employee employee;
    private Employee_PersonalInfo personalInfo;

    EmployeeValidation validation = new EmployeeValidation();

    List<Position> positions;
    SidePanelListener listener ;
    JButton editButton;
    JLabel imageLabel;
    

     
    boolean onEdit;
    String imageSource =null;
   // @param employee set null if add new
    public AddEmployeePanel(  SidePanelListener listener ,Employee employee) {
        initComponents();
        

        this.employee = employee;
        this.listener = listener;
        
     

        init();
    }
    
    
    

    private void init() {
        PanelBasicInfo.setVisible(true);
        PanelAdditionalInfo.setVisible(false);
        activeLabel(jLabel51);

        positions = employeeController.getPositions();
        setComboBox();

        //start
        if (employee == null) {
            
            employee = new Employee();
            personalInfo = new Employee_PersonalInfo();
            try {
                id = employeeController.generateId();
                lblId.setText("ID: " + id + " ");

                employee.setId(id);
                personalInfo.setEmployeeId(id);
            } catch (SQLException ex) {

            }

        }else{
            onEdit=true;
            personalInfo =employee.getPersonalInfo();
            id = employee.getId();
            lblId.setText("ID: " + employee.getId() + " ");
            setFields();
            
               System.out.println(employee.getBirthDate());
        }

    }

    private void setComboBox() {
        cmbPosition.removeAllItems();
        cmbPosition.addItem("-Select Position-");
        for (Position pos : positions) {
            cmbPosition.addItem(pos.getName());
        }

    }
    
    private void setEmployee(){
       
        employee.setMiddleName(validation.checkField(txtMiddlename.getText()));
        employee.setPlaceOfBirth(validation.checkField(txtPlaceOfBirth.getText()));
        employee.setNameExtension(validation.checkField(txtExtension.getText()));
        employee.setGender(cmbGender.getSelectedItem().toString());
        
        
        personalInfo.setCitizenship(validation.checkField(txtCitizenship.getText()));
        personalInfo.setCivilStatus(cmbStatus.getSelectedIndex() <=0?null:cmbStatus.getSelectedItem().toString());
        personalInfo.setBloodType(validation.checkField(txtBloodType.getText()));
        personalInfo.setHeight(validation.checkField(txtHeight.getText()));
        personalInfo.setWeight(validation.checkField(txtWeight.getText()));
        personalInfo.setGsis(validation.checkField(txtGsis.getText()));
        personalInfo.setSss(validation.checkField(txtSss.getText()));
        personalInfo.setPhilHealth(validation.checkField(txtPhilhealth.getText()));
        personalInfo.setPagIbig(validation.checkField(txtPagibig.getText()));
        personalInfo.setTin(validation.checkField(txtTin.getText()));
        personalInfo.setCellphoneNumber(validation.checkField(txtCellphone.getText()));
        personalInfo.setTelephoneNumber(validation.checkField(txtTelephone.getText()));
        personalInfo.setEmail(validation.checkField(txtEmail.getText()));
        personalInfo.setPermanentAddress(validation.checkField(txtPermanent.getText()));
        personalInfo.setCurrentAddress(validation.checkField(txtCurrent.getText()));
        
        employee.setPersonalInfo(personalInfo);
    }
    private void resetFields(){
        txtFirstname.setText("");
        txtLastname.setText("");
        txtMiddlename.setText("");
        txtPlaceOfBirth.setText("");
        txtExtension.setText("");
        txtCitizenship.setText("");
        txtBloodType.setText("");
        txtHeight.setText("");
        txtWeight.setText("");
        txtGsis.setText("");
        txtSss.setText("");
        txtPhilhealth.setText("");
        txtPagibig.setText("");
        txtTin.setText("");
        txtCellphone.setText("");
        txtTelephone.setText("");
        txtEmail.setText("");
        txtPermanent.setText("");
        txtCurrent.setText("");
        
        cmbGender.setSelectedIndex(0);
        cmbPosition.setSelectedIndex(0);
        cmbStatus.setSelectedIndex(0);
        
        
    }
    
    private void setFields(){
        
        txtFirstname.setText(employee.getFirstName());
        txtLastname.setText(employee.getLastName());
        txtMiddlename.setText(employee.getMiddleName());
        txtPlaceOfBirth.setText(employee.getPlaceOfBirth());
        txtExtension.setText(employee.getNameExtension());
        txtDay.setText(String.valueOf(UtilClass.splitDate(employee.getBirthDate().toString(), 2)));
        txtMonth.setText(String.valueOf(UtilClass.splitDate(employee.getBirthDate().toString(), 1)));
        txtYear.setText(String.valueOf(UtilClass.splitDate(employee.getBirthDate().toString(), 0)));

        txtCitizenship.setText(personalInfo.getCitizenship());
        txtBloodType.setText(personalInfo.getBloodType());
        txtHeight.setText(personalInfo.getHeight());
        txtWeight.setText(personalInfo.getWeight());
        txtGsis.setText(personalInfo.getGsis());
        txtSss.setText(personalInfo.getSss());
        txtPhilhealth.setText(personalInfo.getPhilHealth());
        txtPagibig.setText(personalInfo.getPagIbig());
        txtTin.setText(personalInfo.getTin());
        txtCellphone.setText(personalInfo.getCellphoneNumber());
        txtTelephone.setText(personalInfo.getTelephoneNumber());
        txtEmail.setText(personalInfo.getEmail());
        txtPermanent.setText(personalInfo.getPermanentAddress());
        txtCurrent.setText(personalInfo.getCurrentAddress());
        
        cmbGender.setSelectedItem(employee.getGender());
        cmbPosition.setSelectedItem(employee.getPosition().getName());
        cmbStatus.setSelectedItem(personalInfo.getCivilStatus());
        
        if(employee.getImage() !=null){
            System.out.println(ImageHandler.getImagePath(employee.getImage()));
            btnUpload.setIcon(ImageHandler.getImage(50, 50, employee));
        }
    }
    
    public void setComponents(JButton button,JLabel imageLabel){
        this.editButton = button;
        this.imageLabel =imageLabel;
    }
            

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MainContainer = new javax.swing.JPanel();
        PanelBasicInfo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel10 = new javax.swing.JPanel();
        warning_firstname = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        warning_lastname = new javax.swing.JLabel();
        txtLastname = new javax.swing.JTextField();
        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtMiddlename = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jPanel16 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtExtension = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jSplitPane5 = new javax.swing.JSplitPane();
        jPanel18 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        gender_warning = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jSplitPane6 = new javax.swing.JSplitPane();
        jPanel20 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtMonth = new javax.swing.JFormattedTextField();
        txtDay = new javax.swing.JFormattedTextField();
        txtYear = new javax.swing.JFormattedTextField();
        jSplitPane9 = new javax.swing.JSplitPane();
        jPanel24 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        position_warning = new javax.swing.JLabel();
        cmbPosition = new javax.swing.JComboBox<>();
        jSplitPane7 = new javax.swing.JSplitPane();
        jPanel22 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        txtPlaceOfBirth = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jSplitPane8 = new javax.swing.JSplitPane();
        jLabel18 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnUpload = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        PanelAdditionalInfo = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCitizenship = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        txtBloodType = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtHeight = new javax.swing.JTextField();
        txtWeight = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtGsis = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtSss = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtPhilhealth = new javax.swing.JTextField();
        jPanel41 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        txtPagibig = new javax.swing.JTextField();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        txtTin = new javax.swing.JTextField();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtCellphone = new javax.swing.JTextField();
        txtTelephone = new javax.swing.JTextField();
        jPanel47 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        txtCurrent = new javax.swing.JTextField();
        jPanel48 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        txtPermanent = new javax.swing.JTextField();
        jPanel49 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(Theme.PRIMARY.COLOR.background_secondary);
        setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("       ");
        add(jLabel1, java.awt.BorderLayout.LINE_START);

        jLabel2.setText("       ");
        add(jLabel2, java.awt.BorderLayout.LINE_END);

        MainContainer.setLayout(new javax.swing.OverlayLayout(MainContainer));

        PanelBasicInfo.setBackground(Theme.PRIMARY.COLOR.background_secondary);
        PanelBasicInfo.setLayout(new java.awt.GridLayout(9, 0, 0, 5));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setText("Employee Basic Information");
        jPanel3.add(jLabel4);

        PanelBasicInfo.add(jPanel3);

        jSplitPane1.setDividerLocation(110);
        jSplitPane1.setDividerSize(0);

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.GridLayout(2, 0));

        warning_firstname.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        warning_firstname.setForeground(new java.awt.Color(255, 0, 0));
        warning_firstname.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        warning_firstname.setText("*");
        warning_firstname.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel10.add(warning_firstname);

        txtFirstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFirstnameFocusLost(evt);
            }
        });
        jPanel10.add(txtFirstname);

        jSplitPane1.setRightComponent(jPanel10);

        jPanel11.setOpaque(false);
        jPanel11.setLayout(new java.awt.GridLayout(2, 0));
        jPanel11.add(jLabel19);

        jLabel20.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel20.setText("FirstName:");
        jPanel11.add(jLabel20);

        jSplitPane1.setLeftComponent(jPanel11);

        PanelBasicInfo.add(jSplitPane1);

        jSplitPane2.setDividerLocation(110);
        jSplitPane2.setDividerSize(0);

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.GridLayout(2, 0));
        jPanel12.add(jLabel21);

        jLabel22.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel22.setText("LastName:");
        jPanel12.add(jLabel22);

        jSplitPane2.setLeftComponent(jPanel12);

        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.GridLayout(2, 0));

        warning_lastname.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        warning_lastname.setForeground(new java.awt.Color(255, 0, 0));
        warning_lastname.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        warning_lastname.setText("*");
        warning_lastname.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel13.add(warning_lastname);

        txtLastname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLastnameFocusLost(evt);
            }
        });
        jPanel13.add(txtLastname);

        jSplitPane2.setRightComponent(jPanel13);

        PanelBasicInfo.add(jSplitPane2);

        jSplitPane3.setDividerLocation(110);
        jSplitPane3.setDividerSize(0);

        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.GridLayout(2, 0));
        jPanel14.add(jLabel24);

        jLabel25.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel25.setText("MiddleName:");
        jPanel14.add(jLabel25);

        jSplitPane3.setLeftComponent(jPanel14);

        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.GridLayout(2, 0));

        jLabel26.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel15.add(jLabel26);

        txtMiddlename.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMiddlenameFocusLost(evt);
            }
        });
        jPanel15.add(txtMiddlename);

        jSplitPane3.setRightComponent(jPanel15);

        PanelBasicInfo.add(jSplitPane3);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        jSplitPane4.setDividerLocation(110);
        jSplitPane4.setDividerSize(0);

        jPanel16.setOpaque(false);
        jPanel16.setLayout(new java.awt.GridLayout(2, 0));

        jLabel27.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel27.setText("ex: jr, II,III");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel16.add(jLabel27);

        txtExtension.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtExtensionFocusLost(evt);
            }
        });
        jPanel16.add(txtExtension);

        jSplitPane4.setRightComponent(jPanel16);

        jPanel17.setOpaque(false);
        jPanel17.setLayout(new java.awt.GridLayout(2, 0));
        jPanel17.add(jLabel28);

        jLabel29.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel29.setText("Name Extension:");
        jPanel17.add(jLabel29);

        jSplitPane4.setLeftComponent(jPanel17);

        jPanel4.add(jSplitPane4);

        jSplitPane5.setDividerLocation(110);
        jSplitPane5.setDividerSize(0);

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.GridLayout(2, 0));
        jPanel18.add(jLabel30);

        jLabel31.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel31.setText("Gender:");
        jPanel18.add(jLabel31);

        jSplitPane5.setLeftComponent(jPanel18);

        jPanel19.setOpaque(false);
        jPanel19.setLayout(new java.awt.GridLayout(2, 0));

        gender_warning.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        gender_warning.setForeground(new java.awt.Color(255, 0, 0));
        gender_warning.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        gender_warning.setText("*");
        gender_warning.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel19.add(gender_warning);

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select Gender-", "Male", "Female" }));
        cmbGender.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbGenderFocusLost(evt);
            }
        });
        jPanel19.add(cmbGender);

        jSplitPane5.setRightComponent(jPanel19);

        jPanel4.add(jSplitPane5);

        PanelBasicInfo.add(jPanel4);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        jSplitPane6.setDividerLocation(110);
        jSplitPane6.setDividerSize(0);

        jPanel20.setOpaque(false);
        jPanel20.setLayout(new java.awt.GridLayout(2, 0));
        jPanel20.add(jLabel33);

        jLabel34.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel34.setText("BirthDate:");
        jPanel20.add(jLabel34);

        jSplitPane6.setLeftComponent(jPanel20);

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new java.awt.GridLayout(2, 3, 10, 0));

        jLabel35.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel35.setText("Month");
        jLabel35.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel21.add(jLabel35);

        jLabel12.setText("Day");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel21.add(jLabel12);

        jLabel53.setText("Year");
        jLabel53.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel21.add(jLabel53);

        txtMonth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtMonth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMonth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMonthFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMonthFocusLost(evt);
            }
        });
        txtMonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMonthKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonthKeyReleased(evt);
            }
        });
        jPanel21.add(txtMonth);

        txtDay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtDay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDayFocusLost(evt);
            }
        });
        txtDay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDayKeyPressed(evt);
            }
        });
        jPanel21.add(txtDay);

        txtYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtYear.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtYearFocusLost(evt);
            }
        });
        jPanel21.add(txtYear);

        jSplitPane6.setRightComponent(jPanel21);

        jPanel5.add(jSplitPane6);

        jSplitPane9.setDividerLocation(110);
        jSplitPane9.setDividerSize(0);

        jPanel24.setOpaque(false);
        jPanel24.setLayout(new java.awt.GridLayout(2, 0));
        jPanel24.add(jLabel39);

        jLabel40.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel40.setText("Position:");
        jPanel24.add(jLabel40);

        jSplitPane9.setLeftComponent(jPanel24);

        jPanel25.setOpaque(false);
        jPanel25.setLayout(new java.awt.GridLayout(2, 0));

        position_warning.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        position_warning.setForeground(new java.awt.Color(255, 0, 0));
        position_warning.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        position_warning.setText("*");
        jPanel25.add(position_warning);

        cmbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPosition.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPositionItemStateChanged(evt);
            }
        });
        cmbPosition.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbPositionFocusLost(evt);
            }
        });
        jPanel25.add(cmbPosition);

        jSplitPane9.setRightComponent(jPanel25);

        jPanel5.add(jSplitPane9);

        PanelBasicInfo.add(jPanel5);

        jSplitPane7.setDividerLocation(110);
        jSplitPane7.setDividerSize(0);

        jPanel22.setOpaque(false);
        jPanel22.setLayout(new java.awt.GridLayout(2, 0));
        jPanel22.add(jLabel36);

        jLabel37.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel37.setText("Place of Birth:");
        jPanel22.add(jLabel37);

        jSplitPane7.setLeftComponent(jPanel22);

        jPanel23.setOpaque(false);
        jPanel23.setLayout(new java.awt.GridLayout(2, 0));

        jLabel49.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel49.setForeground(new java.awt.Color(255, 0, 0));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel49.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel23.add(jLabel49);

        txtPlaceOfBirth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPlaceOfBirthFocusLost(evt);
            }
        });
        jPanel23.add(txtPlaceOfBirth);

        jSplitPane7.setRightComponent(jPanel23);

        PanelBasicInfo.add(jSplitPane7);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        jSplitPane8.setDividerLocation(110);
        jSplitPane8.setDividerSize(0);

        jLabel18.setFont(Theme.PRIMARY.FONT.tableFontDefault(12)
        );
        jLabel18.setText("Image");
        jSplitPane8.setLeftComponent(jLabel18);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(1, 3));

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });
        jPanel7.add(btnUpload);
        jPanel7.add(jLabel3);
        jPanel7.add(jLabel6);

        jSplitPane8.setRightComponent(jPanel7);

        jPanel6.add(jSplitPane8);

        PanelBasicInfo.add(jPanel6);

        jPanel32.setOpaque(false);
        jPanel32.setLayout(new java.awt.GridLayout(1, 4));
        jPanel32.add(jLabel10);
        jPanel32.add(jLabel23);
        jPanel32.add(jLabel32);

        PanelBasicInfo.add(jPanel32);

        MainContainer.add(PanelBasicInfo);

        PanelAdditionalInfo.setBackground(new java.awt.Color(204, 0, 204));
        PanelAdditionalInfo.setOpaque(false);
        PanelAdditionalInfo.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(Theme.PRIMARY.COLOR.background_secondary);
        jPanel9.setLayout(new java.awt.GridLayout(10, 0));

        jPanel26.setBackground(new java.awt.Color(204, 204, 255));
        jPanel26.setOpaque(false);
        jPanel26.setLayout(new java.awt.GridLayout(1, 0));

        jLabel38.setText("Additional Information");
        jPanel26.add(jLabel38);

        jPanel9.add(jPanel26);

        jPanel28.setBackground(new java.awt.Color(204, 204, 255));
        jPanel28.setOpaque(false);
        jPanel28.setLayout(new java.awt.GridLayout(1, 2));

        jPanel35.setOpaque(false);
        jPanel35.setLayout(new java.awt.GridLayout(2, 0));

        jLabel7.setText("Citizenship");
        jPanel35.add(jLabel7);

        txtCitizenship.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCitizenshipFocusLost(evt);
            }
        });
        jPanel35.add(txtCitizenship);

        jPanel28.add(jPanel35);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(2, 2));

        jLabel5.setText("Civil Status");
        jPanel2.add(jLabel5);

        jLabel56.setText("Blood Type");
        jPanel2.add(jLabel56);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Single", "Married" }));
        cmbStatus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbStatusFocusLost(evt);
            }
        });
        jPanel2.add(cmbStatus);

        txtBloodType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBloodTypeFocusLost(evt);
            }
        });
        jPanel2.add(txtBloodType);

        jPanel28.add(jPanel2);

        jPanel9.add(jPanel28);

        jPanel29.setBackground(new java.awt.Color(204, 204, 255));
        jPanel29.setOpaque(false);
        jPanel29.setLayout(new java.awt.GridLayout(1, 2));

        jPanel36.setOpaque(false);
        jPanel36.setLayout(new java.awt.GridLayout(2, 2));

        jLabel9.setText("Height");
        jPanel36.add(jLabel9);

        jLabel11.setText("Weight");
        jPanel36.add(jLabel11);

        txtHeight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHeightFocusLost(evt);
            }
        });
        jPanel36.add(txtHeight);

        txtWeight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtWeightFocusLost(evt);
            }
        });
        jPanel36.add(txtWeight);

        jPanel29.add(jPanel36);

        jPanel37.setOpaque(false);
        jPanel37.setLayout(new java.awt.GridLayout(2, 2));
        jPanel37.add(jLabel13);
        jPanel37.add(jLabel14);

        jPanel29.add(jPanel37);

        jPanel9.add(jPanel29);

        jPanel30.setBackground(new java.awt.Color(204, 204, 255));
        jPanel30.setOpaque(false);
        jPanel30.setLayout(new java.awt.GridLayout(1, 2));

        jPanel27.setOpaque(false);
        jPanel27.setLayout(new java.awt.GridLayout(2, 0));

        jLabel15.setText("GSIS");
        jPanel27.add(jLabel15);

        txtGsis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGsisFocusLost(evt);
            }
        });
        jPanel27.add(txtGsis);

        jPanel30.add(jPanel27);

        jPanel38.setOpaque(false);
        jPanel38.setLayout(new java.awt.GridLayout(2, 0));

        jLabel16.setText("SSS");
        jPanel38.add(jLabel16);

        txtSss.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSssFocusLost(evt);
            }
        });
        jPanel38.add(txtSss);

        jPanel30.add(jPanel38);

        jPanel9.add(jPanel30);

        jPanel39.setBackground(new java.awt.Color(204, 204, 255));
        jPanel39.setOpaque(false);
        jPanel39.setLayout(new java.awt.GridLayout(1, 2));

        jPanel40.setOpaque(false);
        jPanel40.setLayout(new java.awt.GridLayout(2, 0));

        jLabel17.setText("Philhealth");
        jPanel40.add(jLabel17);

        txtPhilhealth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhilhealthFocusLost(evt);
            }
        });
        jPanel40.add(txtPhilhealth);

        jPanel39.add(jPanel40);

        jPanel41.setOpaque(false);
        jPanel41.setLayout(new java.awt.GridLayout(2, 0));

        jLabel42.setText("Pag-Ibig");
        jPanel41.add(jLabel42);

        txtPagibig.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPagibigFocusLost(evt);
            }
        });
        jPanel41.add(txtPagibig);

        jPanel39.add(jPanel41);

        jPanel9.add(jPanel39);

        jPanel42.setBackground(new java.awt.Color(204, 204, 255));
        jPanel42.setOpaque(false);
        jPanel42.setLayout(new java.awt.GridLayout(1, 2));

        jPanel43.setOpaque(false);
        jPanel43.setLayout(new java.awt.GridLayout(2, 0));

        jLabel43.setText("Tin");
        jPanel43.add(jLabel43);

        txtTin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTinFocusLost(evt);
            }
        });
        jPanel43.add(txtTin);

        jPanel42.add(jPanel43);

        jPanel44.setOpaque(false);
        jPanel44.setLayout(new java.awt.GridLayout(2, 0));
        jPanel42.add(jPanel44);

        jPanel9.add(jPanel42);

        jPanel45.setBackground(new java.awt.Color(204, 204, 255));
        jPanel45.setOpaque(false);
        jPanel45.setLayout(new java.awt.GridLayout(1, 2));

        jPanel46.setOpaque(false);
        jPanel46.setLayout(new java.awt.GridLayout(2, 2));

        jLabel44.setText("Cellphone");
        jPanel46.add(jLabel44);

        jLabel46.setText("Telephone");
        jPanel46.add(jLabel46);

        txtCellphone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCellphoneFocusLost(evt);
            }
        });
        jPanel46.add(txtCellphone);

        txtTelephone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelephoneFocusLost(evt);
            }
        });
        jPanel46.add(txtTelephone);

        jPanel45.add(jPanel46);

        jPanel47.setOpaque(false);
        jPanel47.setLayout(new java.awt.GridLayout(2, 0));

        jLabel45.setText("Email");
        jPanel47.add(jLabel45);

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        jPanel47.add(txtEmail);

        jPanel45.add(jPanel47);

        jPanel9.add(jPanel45);

        jPanel33.setBackground(new java.awt.Color(204, 204, 255));
        jPanel33.setOpaque(false);
        jPanel33.setLayout(new java.awt.GridLayout(2, 0));

        jLabel47.setText("Current Address");
        jPanel33.add(jLabel47);

        txtCurrent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCurrentFocusLost(evt);
            }
        });
        jPanel33.add(txtCurrent);

        jPanel9.add(jPanel33);

        jPanel48.setBackground(new java.awt.Color(204, 204, 255));
        jPanel48.setOpaque(false);
        jPanel48.setLayout(new java.awt.GridLayout(2, 0, 30, 0));

        jLabel48.setText("Permanent Address");
        jPanel48.add(jLabel48);

        txtPermanent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPermanentFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPermanentFocusLost(evt);
            }
        });
        txtPermanent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPermanentActionPerformed(evt);
            }
        });
        jPanel48.add(txtPermanent);

        jPanel9.add(jPanel48);

        jPanel49.setOpaque(false);
        jPanel49.setLayout(new java.awt.GridLayout(1, 4, 50, 0));
        jPanel49.add(jLabel41);
        jPanel49.add(jLabel55);
        jPanel49.add(jLabel57);

        jPanel50.setOpaque(false);
        jPanel50.setLayout(new java.awt.GridLayout(1, 0));

        jButton3.setBackground(new java.awt.Color(0, 153, 0));
        jButton3.setFont(Theme.PRIMARY.FONT.tableFontDefault(17)
        );
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel50.add(jButton3);

        jPanel49.add(jPanel50);

        jPanel9.add(jPanel49);

        PanelAdditionalInfo.add(jPanel9, java.awt.BorderLayout.CENTER);

        MainContainer.add(PanelAdditionalInfo);

        add(MainContainer, java.awt.BorderLayout.CENTER);

        jPanel31.setBackground(Theme.PRIMARY.COLOR.background_primary);
        jPanel31.setForeground(new java.awt.Color(0, 153, 0));
        jPanel31.setLayout(new java.awt.GridLayout(1, 4));

        jLabel51.setBackground(Theme.PRIMARY.COLOR.background_primary);
        jLabel51.setFont(Theme.PRIMARY.FONT.tableFontDefault(15)
        );
        jLabel51.setForeground(Theme.PRIMARY.COLOR.background_secondary);
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Personal Info");
        jLabel51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel51.setOpaque(true);
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel51MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel51MouseExited(evt);
            }
        });
        jPanel31.add(jLabel51);

        jLabel50.setBackground(Theme.PRIMARY.COLOR.background_primary);
        jLabel50.setFont(Theme.PRIMARY.FONT.tableFontDefault(15)
        );
        jLabel50.setForeground(Theme.PRIMARY.COLOR.background_secondary);
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Other Info");
        jLabel50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel50.setOpaque(true);
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel50MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel50MouseExited(evt);
            }
        });
        jPanel31.add(jLabel50);
        jPanel31.add(jLabel52);

        lblId.setFont(new java.awt.Font("AnjaliOldLipi", 0, 18)); // NOI18N
        lblId.setForeground(Theme.PRIMARY.COLOR.background_secondary);
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblId.setText(" ");
        jPanel31.add(lblId);

        add(jPanel31, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPermanentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPermanentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPermanentActionPerformed

    private void cmbPositionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPositionItemStateChanged

    }//GEN-LAST:event_cmbPositionItemStateChanged

    private void jLabel51MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseEntered
        jLabel51.setFont(Theme.PRIMARY.FONT.tableFontBig(15));
    }//GEN-LAST:event_jLabel51MouseEntered

    private void jLabel51MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseExited
        jLabel51.setFont(Theme.PRIMARY.FONT.tableFontDefault(15));
    }//GEN-LAST:event_jLabel51MouseExited

    private void jLabel50MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseEntered
        jLabel50.setFont(Theme.PRIMARY.FONT.tableFontBig(15));
    }//GEN-LAST:event_jLabel50MouseEntered

    private void jLabel50MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseExited
        jLabel50.setFont(Theme.PRIMARY.FONT.tableFontDefault(15));
    }//GEN-LAST:event_jLabel50MouseExited

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        activeLabel(jLabel51);
        PanelBasicInfo.setVisible(true);
        PanelAdditionalInfo.setVisible(false);
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        activeLabel(jLabel50);
        PanelBasicInfo.setVisible(!true);
        PanelAdditionalInfo.setVisible(!false);
    }//GEN-LAST:event_jLabel50MouseClicked

    private void txtFirstnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstnameFocusLost
        try {
           employee.setFirstName(validation.checkFirstname(txtFirstname.getText()));

            warning_firstname.setText("*");
        } catch (InvalidInputException iie) {
            warning_firstname.setText("*" + iie.getMessage());
        }
    }//GEN-LAST:event_txtFirstnameFocusLost

    private void txtMonthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonthKeyPressed
        if (Character.isDigit(evt.getKeyChar())) {
            monthPressCount++;
        }
        if (monthPressCount == 2) {
            txtDay.requestFocus();
        }


    }//GEN-LAST:event_txtMonthKeyPressed

    private void txtDayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDayKeyPressed
        if (Character.isDigit(evt.getKeyChar())) {
            dayPressCount++;
        }

        if (dayPressCount == 2) {
            txtYear.requestFocus();
        }


    }//GEN-LAST:event_txtDayKeyPressed

    private void txtMonthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMonthFocusLost
        monthPressCount = 0;

        txtMonth.setText(String.valueOf(validation.checkMonth(txtMonth.getText())));

        employee.setBirthDate(validation.getDate());

    }//GEN-LAST:event_txtMonthFocusLost

    private void txtDayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDayFocusLost
        dayPressCount = 0;
        txtDay.setText(String.valueOf(validation.checkDay(txtDay.getText())));

        employee.setBirthDate(validation.getDate());

    }//GEN-LAST:event_txtDayFocusLost

    private void txtMonthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMonthFocusGained

    }//GEN-LAST:event_txtMonthFocusGained

    private void txtDayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDayFocusGained
        txtDay.selectAll();
    }//GEN-LAST:event_txtDayFocusGained

    private void txtLastnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastnameFocusLost
        try {
            employee.setLastName(validation.checkLastname(txtLastname.getText()));

            warning_lastname.setText("*");
        } catch (InvalidInputException iie) {
            warning_lastname.setText("*" + iie.getMessage());
        }
    }//GEN-LAST:event_txtLastnameFocusLost

    private void txtMiddlenameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMiddlenameFocusLost

     
    }//GEN-LAST:event_txtMiddlenameFocusLost

    private void cmbGenderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbGenderFocusLost

        try {

           validation.checkGender(cmbGender);
            gender_warning.setText("*");
        } catch (InvalidInputException iie) {
            employee.setGender(null);
            gender_warning.setText("*" + iie.getMessage());
        }
    }//GEN-LAST:event_cmbGenderFocusLost

    private void cmbPositionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbPositionFocusLost
        int index = cmbPosition.getSelectedIndex();
        try {
            employee.setPosition(validation.checkPosition(index, positions));

           
            position_warning.setText("*");

        } catch (InvalidInputException iie) {
            employee.setPosition(null);
            position_warning.setText("*" + iie.getMessage());
        }


    }//GEN-LAST:event_cmbPositionFocusLost

    private void txtMonthKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonthKeyReleased

    }//GEN-LAST:event_txtMonthKeyReleased

    private void txtYearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtYearFocusLost
        txtYear.setText(String.valueOf(validation.checkYear(txtYear.getText())));

        employee.setBirthDate(validation.getDate());
    }//GEN-LAST:event_txtYearFocusLost

    private void txtPlaceOfBirthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlaceOfBirthFocusLost
     
    }//GEN-LAST:event_txtPlaceOfBirthFocusLost

    private void txtExtensionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtExtensionFocusLost
     
    }//GEN-LAST:event_txtExtensionFocusLost

    private void txtCitizenshipFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCitizenshipFocusLost
     
    }//GEN-LAST:event_txtCitizenshipFocusLost

    private void cmbStatusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbStatusFocusLost
         
    }//GEN-LAST:event_cmbStatusFocusLost

    private void txtBloodTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBloodTypeFocusLost
        // TODO add your handling code here:
     
    }//GEN-LAST:event_txtBloodTypeFocusLost

    private void txtHeightFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHeightFocusLost
        // TODO add your handling code here:
     
    }//GEN-LAST:event_txtHeightFocusLost

    private void txtWeightFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtWeightFocusLost
     
    }//GEN-LAST:event_txtWeightFocusLost

    private void txtGsisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGsisFocusLost
        // TODO add your handling code here:
     
    }//GEN-LAST:event_txtGsisFocusLost

    private void txtSssFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSssFocusLost
     


    }//GEN-LAST:event_txtSssFocusLost

    private void txtPhilhealthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhilhealthFocusLost
     
    }//GEN-LAST:event_txtPhilhealthFocusLost

    private void txtPagibigFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPagibigFocusLost
     
    }//GEN-LAST:event_txtPagibigFocusLost

    private void txtTinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTinFocusLost
     
    }//GEN-LAST:event_txtTinFocusLost

    private void txtCellphoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCellphoneFocusLost
     
    }//GEN-LAST:event_txtCellphoneFocusLost

    private void txtTelephoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelephoneFocusLost
     
    }//GEN-LAST:event_txtTelephoneFocusLost

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
     
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtCurrentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCurrentFocusLost
     
    }//GEN-LAST:event_txtCurrentFocusLost

    private void txtPermanentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPermanentFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPermanentFocusGained

    private void txtPermanentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPermanentFocusLost
        
    }//GEN-LAST:event_txtPermanentFocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            setEmployee();
            if (onEdit) {
                employeeController.updateEmployee(employee);
                JOptionPane.showMessageDialog(this, employee.getId() + " Updated");
                listener.onEditEmployeeListener("", null);
                listener.onFinishProfileEdit(employee.getId());
                
               
               
                
            } else {
                if (employeeController.addEmployee(employee) == 1) {
                   
                    JOptionPane.showMessageDialog(this, employee.getId() + " Added");
                    //reset
                    employee = null;
                    personalInfo = null;
                    init();
                    resetFields();

                } else {
                    throw new InvalidInputException("Please fill required fields");
                }
            }
            
            if (imageSource != null);
            ImageHandler.copyToTargetFolder(imageSource, employee.getImage());
            
            editButton.setText("Edit");
            imageLabel.setIcon(ImageHandler.getImage(150, 150, employee));


           
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (InvalidInputException iie) {
            JOptionPane.showMessageDialog(null, iie.getMessage());
        } catch(IOException ioe){
            
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
       try{
           imageSource = ImageHandler.upload();
           ImageIcon imgIcon = ImageHandler.getImage(50, 50, employee);
           employee.setImage(ImageHandler.getName(id));
           
           
           btnUpload.setIcon(imgIcon);
           
       }catch(NullPointerException npe){
           
          //do nothing
       }
    }//GEN-LAST:event_btnUploadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainContainer;
    private javax.swing.JPanel PanelAdditionalInfo;
    private javax.swing.JPanel PanelBasicInfo;
    private javax.swing.JButton btnUpload;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbPosition;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel gender_warning;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
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
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JSplitPane jSplitPane5;
    private javax.swing.JSplitPane jSplitPane6;
    private javax.swing.JSplitPane jSplitPane7;
    private javax.swing.JSplitPane jSplitPane8;
    private javax.swing.JSplitPane jSplitPane9;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel position_warning;
    private javax.swing.JTextField txtBloodType;
    private javax.swing.JTextField txtCellphone;
    private javax.swing.JTextField txtCitizenship;
    private javax.swing.JTextField txtCurrent;
    private javax.swing.JFormattedTextField txtDay;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtExtension;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtGsis;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtMiddlename;
    private javax.swing.JFormattedTextField txtMonth;
    private javax.swing.JTextField txtPagibig;
    private javax.swing.JTextField txtPermanent;
    private javax.swing.JTextField txtPhilhealth;
    private javax.swing.JTextField txtPlaceOfBirth;
    private javax.swing.JTextField txtSss;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtTin;
    private javax.swing.JTextField txtWeight;
    private javax.swing.JFormattedTextField txtYear;
    private javax.swing.JLabel warning_firstname;
    private javax.swing.JLabel warning_lastname;
    // End of variables declaration//GEN-END:variables

    private int dayPressCount;
    private int monthPressCount;
    private JLabel activeLabel;

    private void activeLabel(JLabel label) {
        if (activeLabel != null) {
            activeLabel.setBackground(Theme.PRIMARY.COLOR.background_primary);
            activeLabel.setForeground(Theme.PRIMARY.COLOR.foreground_primary);
        }
        label.setBackground(Theme.PRIMARY.COLOR.background_secondary);
        label.setForeground(Theme.PRIMARY.COLOR.foregroundOnTop);
        activeLabel = label;
    }

}
