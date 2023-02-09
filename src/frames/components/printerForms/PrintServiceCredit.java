/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames.components.printerForms;

import data.controllers.EmployeeController;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import frames.components.EmployeeServiceCreditItem;
import java.awt.GridLayout;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;
import otherclasses.ImageHandler;
import otherclasses.PanelPrintable;
import otherclasses.UtilClass;

/**
 *
 * @author root
 */
public class PrintServiceCredit extends javax.swing.JFrame {

    /**
     * Creates new form PrintServiceCredit
     */
    
     List<EmployeeServiceCredit> employeesWithServiceCredits;
     EmployeeController controller = new EmployeeController();
    public PrintServiceCredit() {
        
        initComponents();
      
    }
    
    public void setPrintServiceCredit(  List<EmployeeServiceCredit> employeesWithServiceCredits){
        header();
        this.employeesWithServiceCredits = employeesWithServiceCredits;
        display();
        
          if(!employeesWithServiceCredits.isEmpty()){
              diplayInfo();
          }
        
    }
    
    private void diplayInfo(){
       
            Employee employee = getEmployee(employeesWithServiceCredits.get(0).getEmployeeId());
            lblName.setText(employee.getFullname());
            lblPosition.setText(employee.getPosition().getName());
            lblId.setText(employee.getId());
            lblDate.setText(UtilClass.getCurrent());
        
      
        
    
    }
    
    private Employee getEmployee(String id){
        
        try{
            return controller.getEmployee(id);
        }catch(java.sql.SQLException e){
            return null;
        }
        
    } 
    
    private void header(){
         lblLogo.setIcon(ImageHandler.getImage(80, 80, ImageHandler.getIconPath("/img/app_img/deped-logo.png")));
        headerContent1.setText("<html>Service Credits</html>");

    }
    
    
     private void display() {
        container.removeAll();
        container.repaint();
        container.revalidate();
        int size = employeesWithServiceCredits.size();
        int row = size;
        if (row < 9) {
            row = 8;
        }
        container.setLayout(new GridLayout(row, 0));

        int index = 0;
        for (EmployeeServiceCredit item : employeesWithServiceCredits) {
            container.add(new EmployeeServiceCreditItem( index, item));
            index++;
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        headerContent1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblDepartment = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(731, 643));
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setPreferredSize(new java.awt.Dimension(80, 80));
        jPanel3.add(lblLogo, java.awt.BorderLayout.NORTH);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        headerContent1.setFont(new java.awt.Font("Liberation Sans", 2, 11)); // NOI18N
        headerContent1.setText("CSC Form No. 6");
        headerContent1.setToolTipText("");
        headerContent1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(headerContent1);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(4, 0));

        jLabel1.setFont(new java.awt.Font("MathJax_Fraktur", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Republic of the Philippines");
        jPanel5.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("MathJax_Fraktur", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Department of Education");
        jPanel5.add(jLabel2);

        jLabel4.setFont(new java.awt.Font("MathJax_Main", 0, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Schools Division of Nueva Ecija");
        jPanel5.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("MathJax_Main", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sta. Rosa, Nueva Ecija");
        jPanel5.add(jLabel5);

        jPanel4.add(jPanel5);
        jPanel4.add(jLabel3);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel6.setPreferredSize(new java.awt.Dimension(300, 168));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(7, 0));

        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.BorderLayout());
        jPanel13.add(jLabel13, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel13);

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel6.setText("Date :");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 17));
        jPanel9.add(jLabel6, java.awt.BorderLayout.WEST);

        lblDate.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jPanel9.add(lblDate, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel9);

        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.BorderLayout());
        jPanel15.add(jLabel16, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel15);

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.BorderLayout());

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel14.setText("Employee Id:");
        jLabel14.setPreferredSize(new java.awt.Dimension(100, 17));
        jPanel18.add(jLabel14, java.awt.BorderLayout.WEST);

        lblId.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jPanel18.add(lblId, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel18);

        jPanel11.setOpaque(false);
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel8.setText("Name");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 17));
        jPanel11.add(jLabel8, java.awt.BorderLayout.WEST);

        lblName.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jPanel11.add(lblName, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel11);

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel10.setText("Position:");
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 17));
        jPanel12.add(jLabel10, java.awt.BorderLayout.WEST);

        lblPosition.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jPanel12.add(lblPosition, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel12);

        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel12.setText("Department:");
        jLabel12.setPreferredSize(new java.awt.Dimension(100, 17));
        jPanel14.add(jLabel12, java.awt.BorderLayout.WEST);

        lblDepartment.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jPanel14.add(lblDepartment, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel14);

        jPanel6.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new java.awt.GridLayout(2, 0));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.add(jLabel17);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Service Credits");
        jPanel17.add(jLabel15);

        jPanel8.add(jPanel17, java.awt.BorderLayout.PAGE_START);

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setLayout(new java.awt.BorderLayout());
        jPanel8.add(container, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(30, 112));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel10, java.awt.BorderLayout.WEST);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(731, 200));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setOpaque(false);
        jPanel19.setLayout(new java.awt.GridLayout(2, 0));

        jLabel7.setText("Prepared by:");
        jPanel19.add(jLabel7);

        jLabel9.setText("____________________________");
        jPanel19.add(jLabel9);

        jPanel16.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 210, 50));

        jPanel20.setOpaque(false);
        jPanel20.setLayout(new java.awt.GridLayout(2, 0));

        jLabel11.setText("Requested by:");
        jPanel20.add(jLabel11);

        jLabel18.setText("____________________________");
        jPanel20.add(jLabel18);

        jPanel16.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 50));

        jPanel1.add(jPanel16, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Form");
      

        PageFormat pf = job.defaultPage();
        
        Paper paper = pf.getPaper();
        double width = jPanel1.getWidth();
        double height = jPanel1.getHeight();
       // paper.setSize(595.0, 842.0); // Set size to A4\
       paper.setSize(8.5* 72, 13.0* 72);
        paper.setImageableArea(0, 0, width, height);
        pf.setPaper(paper);
        
        
        job.setPrintable(new PanelPrintable(jPanel1), pf);
      
        
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
            java.util.logging.Logger.getLogger(PrintServiceCredit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintServiceCredit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintServiceCredit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintServiceCredit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintServiceCredit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JLabel headerContent1;
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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPosition;
    // End of variables declaration//GEN-END:variables
}
