/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pnhsems;

import data.controllers.EmployeeController;
import data.controllers.LeaveFormController;
import data.controllers.ServiceCreditController;
import data.dao.implement.UserDaoImplement;
import data.database.Database;
import data.database.DbConnection;
import data.model.Department;
import data.model.Employee;
import data.model.EmployeeServiceCredit;
import data.model.Employee_PersonalInfo;
import data.model.LeaveType;
import data.model.Position;
import data.model.ServiceCredit;
import data.model.User;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author root
 */
public class TempData {

    static int counter;

    static void start() {
        Database.dropDatabase();
        DbConnection.getConnection();
      
        addUsers();
        addDepartment();
        addPositions();
        addEmployee();
        addEmployee();
        addEmployee();
        
        addServiceCredit();
        addServiceCreditOnEmployee();
        addLeaveType();
    }
    
    static void addUsers(){
        User user = new User("Joy Miranda", "joymiranda", "user@gmail.com", "admin", false);
       
        UserDaoImplement userImp = new UserDaoImplement();
        try {
            userImp.add(user);

            userImp.createSuperAdmin("joymiranda");

            System.out.println("User" + user.getName() + " added");

        } catch (SQLException e) {

            e.printStackTrace();

        }
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
            System.out.println(serviceCredit.getMemorandum()+" Added");
            controller.addServiceCredit(serviceCredit2);
              System.out.println(serviceCredit2.getMemorandum()+" Added");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }

    }

    static void addServiceCreditOnEmployee() {
        EmployeeController employeeController = new EmployeeController();
        try {
            employeeController.addServiceCredit("PEN-230001", 1);
            System.out.println("ServiceCredit on PEN-230001 added");
            employeeController.addServiceCredit("PEN-230002", 1);
            System.out.println("ServiceCredit on PEN-230002 added");
            employeeController.addServiceCredit("PEN-230003", 1);
            System.out.println("ServiceCredit on PEN-230003 added");
            employeeController.addServiceCredit("PEN-230002", 2);
            System.out.println("ServiceCredit on PEN-230002 added");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static public void showServiceCredits() {
        EmployeeController employeeController = new EmployeeController();
        try {
            List<EmployeeServiceCredit> serviceCredits = employeeController.getEmployeeServiceCredits("PEN-230002");

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
            Department department = new Department();
            department.setId(1);
            
            employee.setDepartment(department);

            employeeController.addEmployee(employee);
            System.out.println(employee.getId() + " added");

            counter++;

        } catch (SQLException e) {
            e.printStackTrace();
        }

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

        LeaveType leaveType11 = new LeaveType();
        leaveType11.setName("Special Leave Benefits for Women");
        leaveType11.setReference("R.A. No. 9710/CSC MC No.25, s.2010");

        LeaveType leaveType12 = new LeaveType();
        leaveType12.setName("Special Emergency (Calamaity) Leave");
        leaveType12.setReference("CSC MC No.2, s.2012 as amended");

        LeaveType leaveType13 = new LeaveType();
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
            
            System.out.println("LeaveTypes added");

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

            Position position3 = new Position();
            position3.setName("Administrative Officer IV");
            position3.setCategory("Non-Teaching");

            Position position4 = new Position();
            position4.setName("Administrative Officer V");
            position4.setCategory("Non-Teaching");

            Position position5 = new Position();
            position5.setName("School Principal IV");
            position5.setCategory("Non-Teaching");



            employeeController.addPosition(position1);

            employeeController.addPosition(position2);

            employeeController.addPosition(position3);

            employeeController.addPosition(position4);

            employeeController.addPosition(position5);
            
            
            System.out.println("Positions Added");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
   static void addDepartment(){
       EmployeeController controller = new EmployeeController();
       try{
           Department department3 = new Department();
           department3.setName("Filipino");
           controller.addDepartment(department3);
           
           
           Department department1 = new Department();
           department1.setName("English");
           controller.addDepartment(department1);
           
           Department department2 = new Department();
           department2.setName("Mathematics");
           controller.addDepartment(department2);
           
           Department department4 = new Department();
           department4.setName("Science");
           controller.addDepartment(department4);
           
           Department department5 = new Department();
           department5.setName("Araling Panlipunan");
           controller.addDepartment(department5);
           
           
           Department department6 = new Department();
           department6.setName("Edukasyon sa Pagpapakatao");
           controller.addDepartment(department6);
           
           Department department7 = new Department();
           department7.setName("MAPEH");
           controller.addDepartment(department7);
           
                      
           Department department8 = new Department();
           department8.setName("Technology and Livelihood Education (TLE)");
           controller.addDepartment(department8);
           
           
       }catch(SQLException e){
           
       }
   }

}
