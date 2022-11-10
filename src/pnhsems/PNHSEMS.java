/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pnhsems;

import config.Config;
import otherclasses.UtilClass;
import data.controllers.EmployeeController;
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
    
static    int counter;
  

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

            System.out.println("User"+user.getName() + " added");

        } catch (SQLException e) {

            e.printStackTrace();

        }
        addPositions();
        addEmployee();
        addEmployee();
        addEmployee();
    }
    
    static void addServiceCredit(){
        
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
        
        try{
              controller.addServiceCredit(serviceCredit);
              controller.addServiceCredit(serviceCredit2);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(InvalidInputException e){
            e.printStackTrace();
        }
        
        
        
      
        
    }
    static void addServiceCreditOnEmployee(){
            EmployeeController employeeController = new EmployeeController();
            try{
                employeeController.addServiceCredit("PEN-220001", 1);
                employeeController.addServiceCredit("PEN-220002", 1);
                employeeController.addServiceCredit("PEN-220003", 1);
                employeeController.addServiceCredit("PEN-220002", 2);
            }catch(SQLException e){
                e.printStackTrace();
            }
        
    }
    
    static public void showServiceCredits(){
         EmployeeController employeeController = new EmployeeController();
         try{
             List<EmployeeServiceCredit> serviceCredits = employeeController.getEmployeeServiceCredits("PEN-220002");
             
             for(EmployeeServiceCredit item :serviceCredits){
                 System.out.println(item.getNo_of_days());
                 System.out.println(item.getServiceCredit().getMemorandum());
             }
         }catch(SQLException e){
             e.printStackTrace();
         }
        
    }

    static void addEmployee() {
       

        EmployeeController employeeController = new EmployeeController();
        try {
            Position position =employeeController.getPosition(1);
          
            LocalDate bday =  LocalDate.of(2000,1,29);

            String id = employeeController.generateId();
            Employee employee = new Employee();
            employee.setId(id);
            employee.setFirstName("Marlon");
            employee.setLastName("Padilla");
            employee.setMiddleName("Tampos");
            employee.setBirthDate( java.sql.Date.valueOf(bday));
            employee.setGender("Male");
            employee.setNameExtension("Jr.");
            if(counter ==1){
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
      //start();
       //addServiceCredit();
     // addServiceCreditOnEmployee();
       showServiceCredits();
//       
//       
//            
//       LoginFrame main = new LoginFrame();
//       main.show();
//      

      // Config.createImageDIR(Config.getImagePath()+"/asset/employee_image");
       
    }

    static void addPositions() {
        EmployeeController employeeController = new EmployeeController();
        try {

            Position position1 = new Position();
            position1.setName("Teacher" );
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
