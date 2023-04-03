/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames.components.printerForms;

import data.controllers.LeaveFormController;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.LeaveForm;
import data.model.LeaveType;
import data.model.Personnel;
import data.model.ServiceCredit;
import frames.components.LeaveTypeRadioButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import otherclasses.ImageHandler;
import otherclasses.PanelPrintable;
import otherclasses.UtilClass;

/**
 *
 * @author root
 */
public class Form extends javax.swing.JFrame {

    /**
     * Creates new form Form
     */
    LeaveForm form;
    LeaveFormController controller = new LeaveFormController();

    List<LeaveType> leaveTypes;
    List<Personnel> personnels;

    boolean isBlank;

    public Form() {
        initComponents();

        ///root/NetBeansProjects/PNHSEMS/src/img/app_img/deped-logo.jpg
        try {
            this.leaveTypes = controller.getLeaveTypes();
            this.personnels = controller.getPersonnels();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        header();
        setPersonnels();
    }

    private String getName(Employee employee) {

        if (employee.getFirstName() == null) {
            return null;
        } else {
            return employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName();
        }
    }

    private void setPersonnels() {
        //     String str =  personnels.get(0).getEmployee()==null ? "___________________________________": getName(personnels.get(0).getEmployee());

        lblAdmin4.setText(personnels.get(0).getEmployee() == null ? "" : getName(personnels.get(0).getEmployee()));
        lblAdmin4_2.setText(personnels.get(1).getEmployee() == null ? "" : getName(personnels.get(1).getEmployee()));
        lblPrincipal.setText(personnels.get(2).getEmployee() == null ? "" : getName(personnels.get(2).getEmployee()));
        lblAdmin5.setText(personnels.get(3).getEmployee() == null ? "" : getName(personnels.get(3).getEmployee()));
    }

    private void header() {
        lblLogo.setIcon(ImageHandler.getImage(80, 80, ImageHandler.getIconPath("/img/app_img/deped-logo.png")));
        headerContent1.setText("<html>CSC Form No.6<br>Revised 1984</html>");

    }

    public void setLeaveForm(LeaveForm form, boolean isBlank) {
        

        this.form = form;
        

        this.isBlank = isBlank;

        showLeaveTypes();
        header();
        setDetails();

    }

    private void setDetails() {
        if(!isBlank)lblDateFiled.setText(form.getDateFiled().toString());
        lblFirstName.setText(form.getEmployee().getFirstName());
        lblLastName.setText(form.getEmployee().getLastName());
        lblMiddleName.setText(form.getEmployee().getMiddleName() == null ? "" : form.getEmployee().getMiddleName());
        lblPosition.setText(form.getEmployee().getPosition().getName());
       
        
       int totalUsed=0;
       String _title= "<html>";
       
        for(EmployeeServiceCredit service: form.getServiceCredit()){
              
            System.out.println(service.getNo_of_days());
            _title+="("+service.getServiceCredit().getMemorandum()+")<br>";
            
            
            totalUsed+= service.getNo_of_days();
            
        }
        _title +="</html>";
        title.setText(_title);
        int earned = form.getCreditUsed()+totalUsed;

       label1.setText(earned+"");
       
       label2.setText(form.getCreditUsed()+"");
       label3 .setText(earned -form.getCreditUsed()+"" );
       
       tlabel1.setText(earned+"");
       
       tlabel2.setText(form.getCreditUsed()+"");
       tlabel3 .setText(earned -form.getCreditUsed()+"" );
       
       
        if (!isBlank) {
            lblDaysApplied.setText("" + form.getCreditUsed());
            lblStart.setText(form.getInclusiveDate_start().toString());
            lblEnd.setText(form.getInclusiveDate_end().toString());
            
            UtilClass.setDetailsButton(abroad, form.getDetails(), "Abroad");
            UtilClass.setDetailsButton(withinPh, form.getDetails(), "Within the Philippines");
            UtilClass.setDetailsButton(inHospital, form.getDetails(), "In Hospital");
            UtilClass.setDetailsButton(outPatient, form.getDetails(), "Out Patient");
            UtilClass.setDetailsButton(masters, form.getDetails(), "Completion of Master's Degree");
            UtilClass.setDetailsButton(bar, form.getDetails(), "BAR/Board Examination");
            UtilClass.setDetailsButton(monetize, form.getDetails(), "Monetization of Leave");
            UtilClass.setDetailsButton(terminal, form.getDetails(), "Terminal Leave");

        }

    }

//    private int subtractDate(java.sql.Date start, java.sql.Date end) {
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.setTime(start);
//        Calendar calendar2 = Calendar.getInstance();
//        calendar2.setTime(end);
//        long milliseconds1 = calendar1.getTimeInMillis();
//        long milliseconds2 = calendar2.getTimeInMillis();
//        long diff = milliseconds1 - milliseconds2;
//        return (int) diff / (24 * 60 * 60 * 1000);
//    }
    public void showLeaveTypes() {
        int row = leaveTypes.size() + 1;
        ButtonGroup btnGroupLeaveType = new ButtonGroup();

        leaveTypeList.setLayout(new GridLayout(row, 0));

        for (LeaveType leaveType : leaveTypes) {
            LeaveTypeRadioButton radio = new LeaveTypeRadioButton(leaveType);
            radio.setOpaque(false);

            String text = "<html><b>" + leaveType.getName() + "</b>(" + leaveType.getReference() + ")</font></html>";

            if (form.getLeaveType() !=null && form.getLeaveType().getId() == leaveType.getId()) {
                radio.setSelected(true);
            }
            radio.setText(text);
            radio.setFont(new Font("Liberation Sans 10 Plain", Font.PLAIN, 7));
            leaveTypeList.add(radio);
            btnGroupLeaveType.add(radio);

        }

        JRadioButton others = new JRadioButton();
        others.setText("Others");
        others.setFont(new Font("Liberation Sans 10 Plain", Font.BOLD, 7));
        btnGroupLeaveType.add(others);
        others.setOpaque(false);
        leaveTypeList.add(others);

//        radioOthers.addItemListener((ItemEvent e) -> {
//            if (e.getStateChange() == ItemEvent.SELECTED) {
//
//                specifyPanel.setVisible(true);
//                selectedLeaveType =null;
//                selectedDetails = radioOthers.getText();
//                System.out.println(selectedDetails);
//              
//                if(activeDetailPanel!=null)activeDetailPanel.setVisible(false);
//            } else {
//                specifyPanel.setVisible(false);
//
//            }
//        });
//
//        btnGroupLeaveType.add(radioOthers);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        formContainer = new javax.swing.JPanel();
        container = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        headerContent1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblDateFiled = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblMiddleName = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lblPosition = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        lblDateFiled2 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        leaveTypeList = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        withinPh = new javax.swing.JCheckBox();
        abroad = new javax.swing.JCheckBox();
        jPanel57 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        inHospital = new javax.swing.JCheckBox();
        outPatient = new javax.swing.JCheckBox();
        jPanel59 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        masters = new javax.swing.JCheckBox();
        bar = new javax.swing.JCheckBox();
        jPanel63 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        monetize = new javax.swing.JCheckBox();
        terminal = new javax.swing.JCheckBox();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lblDaysApplied = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        lblStart = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        lblEnd = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        tlabel1 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        tlabel2 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        tlabel3 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        lblAdmin4 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        lblAdmin4_2 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jPanel48 = new javax.swing.JPanel();
        lblPrincipal = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        lblAdmin5 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 723));
        setResizable(false);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, java.awt.BorderLayout.NORTH);

        formContainer.setPreferredSize(new java.awt.Dimension(600, 850));
        formContainer.setLayout(new java.awt.BorderLayout());

        container.setPreferredSize(new java.awt.Dimension(600, 723));
        container.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setPreferredSize(new java.awt.Dimension(80, 80));
        jPanel2.add(lblLogo, java.awt.BorderLayout.NORTH);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        headerContent1.setFont(new java.awt.Font("Liberation Sans", 2, 8)); // NOI18N
        headerContent1.setText("CSC Form No. 6");
        headerContent1.setToolTipText("");
        headerContent1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(headerContent1);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(5, 0));

        jLabel1.setFont(new java.awt.Font("MathJax_Fraktur", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Republic of the Philippines");
        jPanel4.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("MathJax_Fraktur", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Department of Education");
        jPanel4.add(jLabel2);

        jLabel4.setFont(new java.awt.Font("MathJax_Main", 0, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Schools Division of Nueva Ecija");
        jPanel4.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("MathJax_Main", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sta. Rosa, Nueva Ecija");
        jPanel4.add(jLabel5);

        jPanel1.add(jPanel4);
        jPanel1.add(jLabel3);

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        container.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(148, 15));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 10)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("APPLICATION FORM");
        jPanel6.add(jLabel7);

        jPanel5.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel8.setOpaque(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(250, 70));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel9.setOpaque(false);
        jPanel9.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel6.setText("1. OFFICE/DEPARTMENT:");
        jPanel9.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 8)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("<html>DEPED - PENARANDA NATIONAL HIGH SCHOOL<br>\nSchool Division of Nueva Ecija\n\n</html>");
        jPanel9.add(jLabel8, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel9, java.awt.BorderLayout.NORTH);

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel9.setText("3. DATE OF FILING: ");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel10.add(jLabel9, java.awt.BorderLayout.WEST);

        lblDateFiled.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
        lblDateFiled.setAutoscrolls(true);
        jPanel10.add(lblDateFiled, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel8, java.awt.BorderLayout.WEST);

        jPanel11.setOpaque(false);
        jPanel11.setPreferredSize(new java.awt.Dimension(300, 70));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel12.setOpaque(false);
        jPanel12.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.GridLayout(1, 4));

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel13.setText("2. NAME");
        jPanel14.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel14.setText("(Last)");
        jPanel14.add(jLabel14);

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel10.setText("(First)");
        jPanel14.add(jLabel10);

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel15.setText("(Middle)");
        jPanel14.add(jLabel15);

        jPanel12.add(jPanel14, java.awt.BorderLayout.PAGE_START);

        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.GridLayout(1, 4));

        jLabel16.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        jPanel15.add(jLabel16);

        lblLastName.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblLastName.setText("Padilla");
        jPanel15.add(lblLastName);

        lblFirstName.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblFirstName.setText("Marlon");
        jPanel15.add(lblFirstName);

        lblMiddleName.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblMiddleName.setText("Tampos");
        jPanel15.add(lblMiddleName);

        jPanel12.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel12, java.awt.BorderLayout.NORTH);

        jPanel16.setOpaque(false);
        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel13.setOpaque(false);
        jPanel13.setPreferredSize(new java.awt.Dimension(200, 13));
        jPanel13.setLayout(new java.awt.BorderLayout());

        lblPosition.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblPosition.setAutoscrolls(true);
        jPanel13.add(lblPosition, java.awt.BorderLayout.CENTER);

        jLabel21.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel21.setText("4. Position");
        jLabel21.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel13.add(jLabel21, java.awt.BorderLayout.WEST);

        jPanel16.add(jPanel13, java.awt.BorderLayout.WEST);

        jPanel17.setOpaque(false);
        jPanel17.setLayout(new java.awt.BorderLayout());

        jLabel20.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel20.setText("5. Salary");
        jLabel20.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel17.add(jLabel20, java.awt.BorderLayout.WEST);

        lblDateFiled2.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
        lblDateFiled2.setAutoscrolls(true);
        jPanel17.add(lblDateFiled2, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel17, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel16, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.BorderLayout());

        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel19.setOpaque(false);
        jPanel19.setPreferredSize(new java.awt.Dimension(171, 15));
        jPanel19.setLayout(new java.awt.GridLayout(1, 0));

        jLabel22.setFont(new java.awt.Font("Liberation Sans", 1, 10)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("6. DETAILS OF APPLICATION");
        jPanel19.add(jLabel22);

        jPanel18.add(jPanel19, java.awt.BorderLayout.PAGE_START);

        jPanel20.setMinimumSize(new java.awt.Dimension(50, 13));
        jPanel20.setOpaque(false);
        jPanel20.setPreferredSize(new java.awt.Dimension(656, 240));
        jPanel20.setLayout(new java.awt.BorderLayout());

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel21.setPreferredSize(new java.awt.Dimension(350, 100));
        jPanel21.setLayout(new java.awt.BorderLayout());

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel11.setText("6. A TYPE OF LEAVE TO BE AVAIL OF");
        jPanel21.add(jLabel11, java.awt.BorderLayout.PAGE_START);

        leaveTypeList.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.add(leaveTypeList, java.awt.BorderLayout.CENTER);

        jPanel20.add(jPanel21, java.awt.BorderLayout.WEST);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel22.setLayout(new java.awt.BorderLayout());

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel12.setText("6. B DETAILS OF LEAVE");
        jPanel22.add(jLabel12, java.awt.BorderLayout.PAGE_START);

        jPanel54.setOpaque(false);
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel55.setLayout(new java.awt.BorderLayout());

        jLabel38.setFont(new java.awt.Font("Calibri", 2, 8)); // NOI18N
        jLabel38.setText("In case of Vacation Special Privelege Leave");
        jPanel55.add(jLabel38, java.awt.BorderLayout.NORTH);

        jPanel56.setOpaque(false);
        jPanel56.setLayout(new java.awt.GridLayout(2, 0));

        withinPh.setBackground(new java.awt.Color(255, 255, 255));
        withinPh.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        withinPh.setText(" Within the Philippines  ________________________________________________");
        withinPh.setOpaque(true);
        jPanel56.add(withinPh);

        abroad.setBackground(new java.awt.Color(255, 255, 255));
        abroad.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        abroad.setText("Abroad      (Specify)       ________________________________________________");
        abroad.setOpaque(true);
        jPanel56.add(abroad);

        jPanel55.add(jPanel56, java.awt.BorderLayout.CENTER);

        jPanel54.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 2, -1, 37));

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel57.setLayout(new java.awt.BorderLayout());

        jLabel43.setFont(new java.awt.Font("Liberation Sans", 2, 8)); // NOI18N
        jLabel43.setText("In case of Sick Leave");
        jPanel57.add(jLabel43, java.awt.BorderLayout.NORTH);

        jPanel58.setOpaque(false);
        jPanel58.setLayout(new java.awt.GridLayout(2, 0));

        inHospital.setBackground(new java.awt.Color(255, 255, 255));
        inHospital.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        inHospital.setText("In Hospital   (Specify Illness)   __________________________________________");
        inHospital.setOpaque(true);
        jPanel58.add(inHospital);

        outPatient.setBackground(new java.awt.Color(255, 255, 255));
        outPatient.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        outPatient.setText("Out Patient      (Specify Illness)  _________________________________________");
        outPatient.setOpaque(true);
        jPanel58.add(outPatient);

        jPanel57.add(jPanel58, java.awt.BorderLayout.CENTER);

        jPanel54.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 40, -1, 37));

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));
        jPanel59.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel59.setLayout(new java.awt.BorderLayout());

        jLabel51.setFont(new java.awt.Font("Calibri", 2, 8)); // NOI18N
        jLabel51.setText("In Case of Special Leave Benefits for Women");
        jPanel59.add(jLabel51, java.awt.BorderLayout.NORTH);

        jPanel60.setOpaque(false);
        jPanel60.setLayout(new java.awt.GridLayout(2, 0));

        jLabel66.setBackground(new java.awt.Color(255, 255, 255));
        jLabel66.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jLabel66.setText("(Specify Illness) ___________________________________________________________");
        jLabel66.setOpaque(true);
        jPanel60.add(jLabel66);

        jLabel67.setBackground(new java.awt.Color(255, 255, 255));
        jLabel67.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel67.setText("_________________________________________________________________________");
        jLabel67.setOpaque(true);
        jPanel60.add(jLabel67);

        jPanel59.add(jPanel60, java.awt.BorderLayout.CENTER);

        jPanel54.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 77, -1, 37));

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));
        jPanel61.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel61.setLayout(new java.awt.BorderLayout());

        jLabel68.setFont(new java.awt.Font("Liberation Sans", 2, 8)); // NOI18N
        jLabel68.setText("In Case Of Study");
        jPanel61.add(jLabel68, java.awt.BorderLayout.NORTH);

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));
        jPanel62.setLayout(new java.awt.GridLayout(2, 0));

        masters.setBackground(new java.awt.Color(255, 255, 255));
        masters.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        masters.setText("Completion of Master's Degree");
        masters.setOpaque(true);
        jPanel62.add(masters);

        bar.setBackground(new java.awt.Color(255, 255, 255));
        bar.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        bar.setText("BAR/Board Examination Review");
        bar.setOpaque(true);
        jPanel62.add(bar);

        jPanel61.add(jPanel62, java.awt.BorderLayout.CENTER);

        jPanel54.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 115, -1, 37));

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));
        jPanel63.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel63.setLayout(new java.awt.BorderLayout());

        jLabel69.setFont(new java.awt.Font("Liberation Sans", 2, 8)); // NOI18N
        jLabel69.setText("Other Purposes");
        jPanel63.add(jLabel69, java.awt.BorderLayout.NORTH);

        jPanel64.setOpaque(false);
        jPanel64.setLayout(new java.awt.GridLayout(2, 0));

        monetize.setBackground(new java.awt.Color(255, 255, 255));
        monetize.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        monetize.setText("Monetization of Leave Credits");
        monetize.setOpaque(true);
        jPanel64.add(monetize);

        terminal.setBackground(new java.awt.Color(255, 255, 255));
        terminal.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        terminal.setText("Terminal Leave");
        terminal.setOpaque(true);
        jPanel64.add(terminal);

        jPanel63.add(jPanel64, java.awt.BorderLayout.CENTER);

        jPanel54.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 150, -1, 37));

        jPanel22.add(jPanel54, java.awt.BorderLayout.CENTER);

        jPanel20.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel18.add(jPanel20, java.awt.BorderLayout.CENTER);

        jPanel27.setOpaque(false);
        jPanel27.setPreferredSize(new java.awt.Dimension(426, 40));
        jPanel27.setLayout(new java.awt.BorderLayout());

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel28.setOpaque(false);
        jPanel28.setPreferredSize(new java.awt.Dimension(350, 50));
        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel26.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel26.setText("6. C NUMBER OF WORKING DAYS APPLIED FOR");
        jPanel28.add(jLabel26, java.awt.BorderLayout.PAGE_START);

        jPanel29.setOpaque(false);
        jPanel29.setLayout(new java.awt.GridLayout(3, 0));

        jPanel30.setOpaque(false);
        jPanel30.setLayout(new java.awt.BorderLayout());

        jLabel27.setFont(new java.awt.Font("Liberation Sans", 0, 7)); // NOI18N
        jLabel27.setText("Working Day(s) applied for :");
        jPanel30.add(jLabel27, java.awt.BorderLayout.LINE_START);

        lblDaysApplied.setFont(new java.awt.Font("Liberation Sans", 0, 9)); // NOI18N
        lblDaysApplied.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDaysApplied.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel30.add(lblDaysApplied, java.awt.BorderLayout.CENTER);

        jPanel29.add(jPanel30);

        jPanel31.setOpaque(false);
        jPanel31.setLayout(new java.awt.BorderLayout());

        jLabel28.setFont(new java.awt.Font("Liberation Sans", 0, 7)); // NOI18N
        jLabel28.setText("Inclusive date(start) :");
        jPanel31.add(jLabel28, java.awt.BorderLayout.LINE_START);

        lblStart.setFont(new java.awt.Font("Liberation Sans", 0, 9)); // NOI18N
        lblStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStart.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel31.add(lblStart, java.awt.BorderLayout.CENTER);

        jPanel29.add(jPanel31);

        jPanel32.setOpaque(false);
        jPanel32.setLayout(new java.awt.BorderLayout());

        jLabel29.setFont(new java.awt.Font("Liberation Sans", 0, 7)); // NOI18N
        jLabel29.setText("Inclusive date(end)  :");
        jLabel29.setToolTipText("");
        jPanel32.add(jLabel29, java.awt.BorderLayout.LINE_START);

        lblEnd.setFont(new java.awt.Font("Liberation Sans", 0, 9)); // NOI18N
        lblEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel32.add(lblEnd, java.awt.BorderLayout.CENTER);

        jPanel29.add(jPanel32);

        jPanel28.add(jPanel29, java.awt.BorderLayout.CENTER);

        jPanel27.add(jPanel28, java.awt.BorderLayout.WEST);

        jPanel33.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel33.setOpaque(false);
        jPanel33.setLayout(new java.awt.BorderLayout());

        jLabel33.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel33.setText("6. D COMMUTATION");
        jPanel33.add(jLabel33, java.awt.BorderLayout.PAGE_START);

        jPanel34.setOpaque(false);
        jPanel34.setLayout(new java.awt.GridLayout(2, 0));

        jLabel34.setFont(new java.awt.Font("Liberation Sans", 0, 9)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("_________________________");
        jLabel34.setToolTipText("");
        jLabel34.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel34.add(jLabel34);

        jLabel35.setFont(new java.awt.Font("Liberation Sans", 0, 9)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("(Signature of Applicant)");
        jLabel35.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel34.add(jLabel35);

        jPanel33.add(jPanel34, java.awt.BorderLayout.CENTER);

        jPanel27.add(jPanel33, java.awt.BorderLayout.CENTER);

        jPanel18.add(jPanel27, java.awt.BorderLayout.SOUTH);

        jPanel3.add(jPanel18, java.awt.BorderLayout.CENTER);

        container.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel23.setMinimumSize(new java.awt.Dimension(150, 37));
        jPanel23.setPreferredSize(new java.awt.Dimension(200, 190));
        jPanel23.setLayout(new java.awt.BorderLayout());

        jPanel24.setOpaque(false);
        jPanel24.setPreferredSize(new java.awt.Dimension(235, 15));
        jPanel24.setLayout(new java.awt.GridLayout(1, 0));

        jLabel23.setFont(new java.awt.Font("Liberation Sans", 1, 10)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("7. DETAILS OF ACTION ON APPLICATION");
        jPanel24.add(jLabel23);

        jPanel23.add(jPanel24, java.awt.BorderLayout.PAGE_START);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel25.setMinimumSize(new java.awt.Dimension(300, 13));
        jPanel25.setOpaque(false);
        jPanel25.setPreferredSize(new java.awt.Dimension(350, 100));
        jPanel25.setLayout(new java.awt.BorderLayout());

        jLabel24.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel24.setText("7. A CERTIFICATION OF LEAVE CREDITS");
        jPanel25.add(jLabel24, java.awt.BorderLayout.PAGE_START);

        jPanel35.setOpaque(false);
        jPanel35.setLayout(new java.awt.GridLayout(4, 0));

        jPanel37.setOpaque(false);
        jPanel37.setLayout(new java.awt.GridLayout(1, 4));

        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel37.add(jLabel37);

        jLabel39.setFont(new java.awt.Font("Calibri", 1, 8)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("<html><div style='text-align: center;'>Vacation Leave</div></html>");
        jLabel39.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel37.add(jLabel39);

        jLabel36.setFont(new java.awt.Font("Calibri", 1, 8)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("<html><div style='text-align: center;'>Sick Leave</div></html>");
        jLabel36.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel37.add(jLabel36);

        jLabel65.setFont(new java.awt.Font("Calibri", 1, 8)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("<html><div style='text-align: center;'>Total Days</div></html>");
        jLabel65.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel37.add(jLabel65);

        jPanel35.add(jPanel37);

        jPanel39.setOpaque(false);
        jPanel39.setLayout(new java.awt.GridLayout(1, 4));

        jLabel44.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Total earned");
        jLabel44.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel39.add(jLabel44);

        jLabel45.setFont(new java.awt.Font("Liberation Sans", 1, 9)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel39.add(jLabel45);

        label1.setFont(new java.awt.Font("Liberation Sans", 0, 7)); // NOI18N
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel39.add(label1);

        tlabel1.setFont(new java.awt.Font("Liberation Sans", 1, 9)); // NOI18N
        tlabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tlabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel39.add(tlabel1);

        jPanel35.add(jPanel39);

        jPanel40.setOpaque(false);
        jPanel40.setLayout(new java.awt.GridLayout(1, 4));

        jLabel48.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("<html><div style='text-align: center;'>Less this application</div></html>");
        jLabel48.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel40.add(jLabel48);

        jLabel49.setFont(new java.awt.Font("Liberation Sans", 1, 9)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel40.add(jLabel49);

        label2.setFont(new java.awt.Font("Liberation Sans", 0, 7)); // NOI18N
        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel40.add(label2);

        tlabel2.setFont(new java.awt.Font("Liberation Sans", 1, 9)); // NOI18N
        tlabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tlabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel40.add(tlabel2);

        jPanel35.add(jPanel40);

        jPanel38.setOpaque(false);
        jPanel38.setLayout(new java.awt.GridLayout(1, 4));

        jLabel40.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Balance");
        jLabel40.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel38.add(jLabel40);

        jLabel41.setFont(new java.awt.Font("Liberation Sans", 1, 9)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel38.add(jLabel41);

        label3.setFont(new java.awt.Font("Liberation Sans", 0, 7)); // NOI18N
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel38.add(label3);

        tlabel3.setFont(new java.awt.Font("Liberation Sans", 1, 9)); // NOI18N
        tlabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tlabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel38.add(tlabel3);

        jPanel35.add(jPanel38);

        jPanel25.add(jPanel35, java.awt.BorderLayout.CENTER);

        jPanel49.setOpaque(false);
        jPanel49.setPreferredSize(new java.awt.Dimension(100, 45));
        jPanel49.setLayout(new java.awt.GridLayout(1, 2));

        jPanel50.setOpaque(false);
        jPanel50.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel50.setLayout(new java.awt.GridLayout(3, 0));

        title.setFont(new java.awt.Font("Liberation Sans", 0, 6)); // NOI18N
        title.setText("<html>sample text  here sample text  here sample text  here sample text  here sample text  here sample text  here sample text  here sample text  here sample text  here sample text  here </html>");
        jPanel50.add(title);

        lblAdmin4.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        lblAdmin4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdmin4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel50.add(lblAdmin4);

        jLabel62.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Administrative Officer IV");
        jLabel62.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel50.add(jLabel62);

        jPanel49.add(jPanel50);

        jPanel51.setOpaque(false);
        jPanel51.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel51.setLayout(new java.awt.GridLayout(3, 0));
        jPanel51.add(jLabel81);

        lblAdmin4_2.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        lblAdmin4_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdmin4_2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel51.add(lblAdmin4_2);

        jLabel64.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Administrative Officer IV");
        jLabel64.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel51.add(jLabel64);

        jPanel49.add(jPanel51);

        jPanel25.add(jPanel49, java.awt.BorderLayout.SOUTH);

        jPanel23.add(jPanel25, java.awt.BorderLayout.WEST);

        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel26.setMinimumSize(new java.awt.Dimension(120, 100));
        jPanel26.setOpaque(false);
        jPanel26.setPreferredSize(new java.awt.Dimension(120, 90));
        jPanel26.setLayout(new java.awt.BorderLayout());

        jLabel25.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel25.setText("7. B DETAILS OF LEAVE");
        jPanel26.add(jLabel25, java.awt.BorderLayout.PAGE_START);

        jPanel42.setOpaque(false);
        jPanel42.setLayout(new java.awt.GridLayout(2, 0));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Calibri", 0, 9)); // NOI18N
        jCheckBox1.setText("For Approval");
        jCheckBox1.setOpaque(true);
        jPanel42.add(jCheckBox1);

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Calibri", 0, 9)); // NOI18N
        jCheckBox2.setText("<html>For disapproval due to:________________________________________________</html>");
        jCheckBox2.setOpaque(true);
        jPanel42.add(jCheckBox2);

        jPanel26.add(jPanel42, java.awt.BorderLayout.CENTER);

        jPanel48.setOpaque(false);
        jPanel48.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel48.setLayout(new java.awt.GridLayout(2, 0));

        lblPrincipal.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        lblPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel48.add(lblPrincipal);

        jLabel60.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("School Principal IV");
        jLabel60.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel48.add(jLabel60);

        jPanel26.add(jPanel48, java.awt.BorderLayout.SOUTH);

        jPanel23.add(jPanel26, java.awt.BorderLayout.CENTER);

        jPanel43.setOpaque(false);
        jPanel43.setPreferredSize(new java.awt.Dimension(100, 80));
        jPanel43.setLayout(new java.awt.BorderLayout());

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setMinimumSize(new java.awt.Dimension(300, 13));
        jPanel44.setOpaque(false);
        jPanel44.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel44.setLayout(new java.awt.BorderLayout());

        jLabel52.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel52.setText("7. D DISSAPROVE DUE TO");
        jPanel44.add(jLabel52, java.awt.BorderLayout.PAGE_START);

        jPanel46.setOpaque(false);
        jPanel46.setLayout(new java.awt.GridLayout(3, 0));

        jLabel54.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("_________________________________");
        jPanel46.add(jLabel54);

        jLabel55.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("_________________________________");
        jPanel46.add(jLabel55);

        jLabel56.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("_________________________________");
        jPanel46.add(jLabel56);

        jPanel44.add(jPanel46, java.awt.BorderLayout.CENTER);

        jPanel43.add(jPanel44, java.awt.BorderLayout.CENTER);

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setMinimumSize(new java.awt.Dimension(300, 13));
        jPanel45.setOpaque(false);
        jPanel45.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel45.setLayout(new java.awt.BorderLayout());

        jLabel53.setFont(new java.awt.Font("Liberation Sans", 0, 8)); // NOI18N
        jLabel53.setText("7. C APPROVED FOR");
        jPanel45.add(jLabel53, java.awt.BorderLayout.PAGE_START);

        jPanel36.setOpaque(false);
        jPanel36.setLayout(new java.awt.GridLayout(3, 0));

        jPanel41.setOpaque(false);
        jPanel41.setLayout(new java.awt.GridLayout(1, 2));

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("___________");
        jPanel41.add(jLabel18);

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 9)); // NOI18N
        jLabel17.setText("Day(s) with Pay");
        jPanel41.add(jLabel17);

        jPanel36.add(jPanel41);

        jPanel52.setOpaque(false);
        jPanel52.setLayout(new java.awt.GridLayout(1, 2));

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("___________");
        jPanel52.add(jLabel19);

        jLabel30.setFont(new java.awt.Font("Calibri", 0, 9)); // NOI18N
        jLabel30.setText("Day(s) without Pay");
        jPanel52.add(jLabel30);

        jPanel36.add(jPanel52);

        jPanel53.setOpaque(false);
        jPanel53.setLayout(new java.awt.GridLayout(1, 2));

        jLabel31.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("___________");
        jPanel53.add(jLabel31);

        jLabel32.setFont(new java.awt.Font("Calibri", 0, 9)); // NOI18N
        jLabel32.setText("Other(s) (specify)");
        jPanel53.add(jLabel32);

        jPanel36.add(jPanel53);

        jPanel45.add(jPanel36, java.awt.BorderLayout.CENTER);

        jPanel43.add(jPanel45, java.awt.BorderLayout.WEST);

        jPanel47.setOpaque(false);
        jPanel47.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel47.setLayout(new java.awt.GridLayout(3, 0));
        jPanel47.add(jLabel82);

        lblAdmin5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblAdmin5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel47.add(lblAdmin5);

        jLabel58.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Administrative Officer V");
        jLabel58.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel47.add(jLabel58);

        jPanel43.add(jPanel47, java.awt.BorderLayout.SOUTH);

        jPanel23.add(jPanel43, java.awt.BorderLayout.SOUTH);

        container.add(jPanel23, java.awt.BorderLayout.SOUTH);

        formContainer.add(container, java.awt.BorderLayout.CENTER);

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));
        jPanel65.setPreferredSize(new java.awt.Dimension(731, 140));
        jPanel65.setLayout(new java.awt.BorderLayout());

        jPanel66.setOpaque(false);
        jPanel66.setPreferredSize(new java.awt.Dimension(731, 60));
        jPanel66.setLayout(new java.awt.GridLayout(5, 0));

        jLabel57.setFont(new java.awt.Font("Liberation Serif", 0, 10)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("GUIDELINES ON THE FILING OF APPLICATION");
        jPanel66.add(jLabel57);

        jLabel59.setFont(new java.awt.Font("Liberation Serif", 0, 10)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("FOR VACATION/SICK LEAVE OF ABSENCE");
        jPanel66.add(jLabel59);

        jLabel61.setFont(new java.awt.Font("Liberation Serif", 0, 10)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("(MECS ORDER NO. 26, s. 1985)");
        jPanel66.add(jLabel61);

        jLabel63.setFont(new java.awt.Font("Liberation Serif", 0, 14)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel66.add(jLabel63);

        jLabel70.setFont(new java.awt.Font("Liberation Serif", 0, 10)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("INSTRUCTION");
        jPanel66.add(jLabel70);

        jPanel65.add(jPanel66, java.awt.BorderLayout.NORTH);

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));
        jPanel67.setPreferredSize(new java.awt.Dimension(731, 80));
        jPanel67.setLayout(new java.awt.GridLayout(5, 0));

        jLabel71.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jLabel71.setText("<html>         1. Application for vacation or sick Leave for one(1) full day or more shall be made on this Form, and to accomplished at least in duplicate.</html>");
        jPanel67.add(jLabel71);

        jLabel72.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jLabel72.setText("<html>         2. Application for vacation Leave shall filed in advance or whenever possible five(5) days before going on such leave.</html>");
        jPanel67.add(jLabel72);

        jLabel73.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jLabel73.setText("<html>         3. Application for sick leave filed in advace or exceeding five(5) days shall be accomplished by a medical certificate. In case medical consultation was not availed of, an affidavit should be executed by the applicant.</html>");
        jPanel67.add(jLabel73);

        jLabel74.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jLabel74.setText("<html>         4. An employee who is absent without approved leave shall not entitled to receive salary corresponding to the period of his unautorized leave of absence.</html>");
        jPanel67.add(jLabel74);

        jLabel75.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jLabel75.setText("<html>        5.An application for leave of absence for thirty(30) calendar days or more shall accompanied by a clearance from money and property accountabilities.</html>");
        jPanel67.add(jLabel75);

        jPanel65.add(jPanel67, java.awt.BorderLayout.CENTER);

        jLabel76.setText("       ");
        jPanel65.add(jLabel76, java.awt.BorderLayout.WEST);

        jLabel77.setText("       ");
        jPanel65.add(jLabel77, java.awt.BorderLayout.EAST);

        formContainer.add(jPanel65, java.awt.BorderLayout.SOUTH);

        jLabel78.setBackground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("     ");
        jLabel78.setOpaque(true);
        formContainer.add(jLabel78, java.awt.BorderLayout.EAST);

        jLabel79.setBackground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("     ");
        jLabel79.setOpaque(true);
        formContainer.add(jLabel79, java.awt.BorderLayout.WEST);

        jScrollPane1.setViewportView(formContainer);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel68.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel68, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Form");

        PageFormat pf = job.defaultPage();

        Paper paper = pf.getPaper();
        double width = formContainer.getWidth();
        double height = formContainer.getHeight();
        // paper.setSize(595.0, 842.0); // Set size to A4\
        paper.setSize(8.5 * 72, 13.0 * 72);
        paper.setImageableArea(0, 0, width, height);
        pf.setPaper(paper);

        job.setPrintable(new PanelPrintable(formContainer), pf);

        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                // Handle print job exception
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox abroad;
    private javax.swing.JCheckBox bar;
    private javax.swing.JPanel container;
    private javax.swing.JPanel formContainer;
    private javax.swing.JLabel headerContent1;
    private javax.swing.JCheckBox inHospital;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
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
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
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
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel lblAdmin4;
    private javax.swing.JLabel lblAdmin4_2;
    private javax.swing.JLabel lblAdmin5;
    private javax.swing.JLabel lblDateFiled;
    private javax.swing.JLabel lblDateFiled2;
    private javax.swing.JLabel lblDaysApplied;
    private javax.swing.JLabel lblEnd;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMiddleName;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblPrincipal;
    private javax.swing.JLabel lblStart;
    private javax.swing.JPanel leaveTypeList;
    private javax.swing.JCheckBox masters;
    private javax.swing.JCheckBox monetize;
    private javax.swing.JCheckBox outPatient;
    private javax.swing.JCheckBox terminal;
    private javax.swing.JLabel title;
    private javax.swing.JLabel tlabel1;
    private javax.swing.JLabel tlabel2;
    private javax.swing.JLabel tlabel3;
    private javax.swing.JCheckBox withinPh;
    // End of variables declaration//GEN-END:variables
}
