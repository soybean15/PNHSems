/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pnhsems;

import config.Config;
import otherclasses.UtilClass;
import data.controllers.EmployeeController;
import data.controllers.LeaveFormController;
import data.controllers.ServiceCreditController;
import data.database.DbConnection;
import static data.database.DbConnection.dropDatabase;
import static data.database.DbConnection.getConnection;
import data.model.Employee;
import data.model.Employee_PersonalInfo;
import data.model.Position;
import data.model.User;
import data.dao.implement.UserDaoImplement;
import data.model.EmployeeServiceCredit;
import data.model.LeaveType;
import data.model.ServiceCredit;
import frames.LoginFrame;
import frames.MainFrame;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import themes.Colour;
import themes.Theme;

/**
 *
 * @author root
 */
public class PNHSEMS {

    /**
     * @param args the command line arguments
     */
    static int counter;

    static void start() {
        DbConnection.dropDatabase();
        DbConnection.getConnection();
        User user = new User("Marlon", "user123", "user@gmail.com", "password123", false);
        User user2 = new User("George", "george123", "george@gmail.com", "george123", false);
        User user3 = new User("Maymay", "Maymay123", "Maymay@gmail.com", "Maymay123", false);
        User user4 = new User("TobeDeleted1", "TobeDeleted1", "To be Deleted", "To be Deleted", false);
        User user5 = new User("TobeDeleted2", "TobeDeleted2", "To be Deleted", "To be Deleted", false);
        UserDaoImplement userImp = new UserDaoImplement();
        try {
            userImp.add(user);
            userImp.add(user2);
            userImp.add(user3);
            userImp.add(user4);
            userImp.add(user5);

            userImp.createSuperAdmin("user123");

            System.out.println("User" + user.getName() + " added");

        } catch (SQLException e) {

            e.printStackTrace();

        }
        addPositions();
        addEmployee();
        addEmployee();
        addEmployee();
    }

    static void addServiceCredit() {

        ServiceCreditController controller = new ServiceCreditController();
        ServiceCredit serviceCredit = new ServiceCredit();

        serviceCredit.setMemorandum("Division Memorandum No. 2 S. 2022");
        serviceCredit.setOrderNo("SO-1 Series 2022");
        serviceCredit.setTitle("Brigada Eskwela");
        serviceCredit.setNumberOfDays(5);

        ServiceCredit serviceCredit2 = new ServiceCredit();

        serviceCredit2.setMemorandum("Deped Memo No. 5 s. 2022");
        serviceCredit2.setOrderNo("SO-2");
        serviceCredit2.setTitle("Brigada Eskwela");
        serviceCredit2.setNumberOfDays(10);

        try {
            controller.addServiceCredit(serviceCredit);
            controller.addServiceCredit(serviceCredit2);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }

    }

    static void addServiceCreditOnEmployee() {
        EmployeeController employeeController = new EmployeeController();
        try {
            employeeController.addServiceCredit("PEN-220001", 1);
            employeeController.addServiceCredit("PEN-220002", 1);
            employeeController.addServiceCredit("PEN-220003", 1);
            employeeController.addServiceCredit("PEN-220002", 2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static public void showServiceCredits() {
        EmployeeController employeeController = new EmployeeController();
        try {
            List<EmployeeServiceCredit> serviceCredits = employeeController.getEmployeeServiceCredits("PEN-220002");

            for (EmployeeServiceCredit item : serviceCredits) {
                System.out.println(item.getNo_of_days());
                System.out.println(item.getServiceCredit().getMemorandum());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static void addEmployee() {

        EmployeeController employeeController = new EmployeeController();
        try {
            Position position = employeeController.getPosition(1);

            LocalDate bday = LocalDate.of(2000, 1, 29);

            String id = employeeController.generateId();
            Employee employee = new Employee();
            employee.setId(id);
            employee.setFirstName("Marlon");
            employee.setLastName("Padilla");
            employee.setMiddleName("Tampos");
            employee.setBirthDate(java.sql.Date.valueOf(bday));
            employee.setGender("Male");
            employee.setNameExtension("Jr.");
            if (counter == 1) {
                employee.setNameExtension(null);
                employee.setMiddleName(null);
            }

            employee.setPlaceOfBirth("");
            employee.setImage(null);
            employee.setPosition(position);

            Employee_PersonalInfo personalInfo = new Employee_PersonalInfo();

            personalInfo.setEmployeeId(id);
            personalInfo.setCitizenship("");
            personalInfo.setCivilStatus("");
            personalInfo.setGsis("");
            personalInfo.setHeight("");
            personalInfo.setWeight("");
            personalInfo.setSss("");
            personalInfo.setPhilHealth("");
            personalInfo.setPagIbig("");
            personalInfo.setTin("");
            personalInfo.setCellphoneNumber("");
            personalInfo.setTelephoneNumber("");
            personalInfo.setEmail("");
            personalInfo.setCurrentAddress("");
            personalInfo.setPermanentAddress("");

            employee.setPersonalInfo(personalInfo);

            employeeController.addEmployee(employee);
            System.out.println(employee.getId() + " added");

            counter++;

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//       
     // start();
     //  addServiceCredit();
      // addServiceCreditOnEmployee();
        // showServiceCredits();
      //addLeaveType();
//       
//       
//            
//       LoginFrame main = new LoginFrame();
//       main.show();
//      

    }

    public static void addLeaveType() {
        LeaveFormController controller = new LeaveFormController();

        LeaveType leaveType1 = new LeaveType();
        leaveType1.setName("Vacation Leave");
        leaveType1.setReference("Sec. 51 Rule XVI, Omnibus Rule Implementing E.O. No. 292");

        LeaveType leaveType2 = new LeaveType();
        leaveType2.setName("Mandatory/Force Leave");
        leaveType2.setReference("Sec. 25 Rule XVI, Omnibus Rules Implementing E.O. No.292");

        LeaveType leaveType3 = new LeaveType();
        leaveType3.setName("Sick Leave");
        leaveType3.setReference("Sec. 43 Rule XVI, Omnibus Rules Implementing E.O. No.292");

        LeaveType leaveType4 = new LeaveType();
        leaveType4.setName("Maternity Leave");
        leaveType4.setReference("R.A. No. 11210/IRR issued by CSC, DOLE and SSS");
        
        LeaveType leaveType5 = new LeaveType();
        leaveType5.setName("Paternity Leave");
        leaveType5.setReference("R.A. No. 8187/CSC MC No. 71, s. 1998, as amended");
        
        LeaveType leaveType6 = new LeaveType();
        leaveType6.setName("Special Privelege Leave");
        leaveType6.setReference("Sec 21, Rule XVI, Omnibus Rules Implementing E.O. No.292");
          
        LeaveType leaveType7 = new LeaveType();
        leaveType7.setName("Solo Parent Leave");
        leaveType7.setReference("R.A.8972/CSC MC No.8, s.2004");
        
          
        LeaveType leaveType8 = new LeaveType();
        leaveType8.setName("Study Leave");
        leaveType8.setReference("Sec. 68, Rule XVI, Omnibus Rules Implementing E.O. No.292");
        
        LeaveType leaveType9 = new LeaveType();
        leaveType9.setName("10-Day VAWC Leave");
        leaveType9.setReference("R.A. 9262/CSC MC No.15, s. 2005");
        
        LeaveType leaveType10 = new LeaveType();
        leaveType10.setName("Rehabilitation Privelege");
        leaveType10.setReference("Sec. 55, Rule XVI, Omnibus Rules Implementing E.O. No.292");
        
        LeaveType leaveType11= new LeaveType();
        leaveType11.setName("Special Leave Benefits for Women");
        leaveType11.setReference("R.A. No. 9710/CSC MC No.25, s.2010");
        
        LeaveType leaveType12= new LeaveType();
        leaveType12.setName("Special Emergency (Calamaity) Leave");
        leaveType12.setReference("CSC MC No.2, s.2012 as amended");
        
        LeaveType leaveType13= new LeaveType();
        leaveType13.setName("Adoption Leave");
        leaveType13.setReference("R.A. No. 8552");
        
        
        try {
            controller.addLeaveType(leaveType1);
            controller.addLeaveType(leaveType2);
            controller.addLeaveType(leaveType3);
            controller.addLeaveType(leaveType4);
            controller.addLeaveType(leaveType5);
            controller.addLeaveType(leaveType6);
            controller.addLeaveType(leaveType7);
            controller.addLeaveType(leaveType8);
            controller.addLeaveType(leaveType9);
            controller.addLeaveType(leaveType10);
            controller.addLeaveType(leaveType11);
            controller.addLeaveType(leaveType12);
            controller.addLeaveType(leaveType13);
           

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addPositions() {
        EmployeeController employeeController = new EmployeeController();
        try {

            Position position1 = new Position();
            position1.setName("Teacher");
            position1.setCategory("Teaching");

            Position position2 = new Position();
            position2.setName("Registrar");
            position2.setCategory("Non-Teaching");

            employeeController.addPosition(position1);

            employeeController.addPosition(position2);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
