/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dao.implement;

import data.dao.EmployeeDao;
import data.model.Employee;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
import data.database.DbConnection;
import data.model.Employee_PersonalInfo;
import data.model.Personnel;
import data.model.Position;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImplement implements EmployeeDao {

    Connection conn = DbConnection.getConnection();

    @Override
    public int add(Employee employee) throws SQLException {
        // String query="Start transaction;\n";
        int n =0;
        try {
            conn.setAutoCommit(false);
            String query = "Insert into employee("
                    + "id,"
                    + "firstname,"
                    + "lastname,"
                    + "middlename,"
                    + "name_extension,"
                    + "gender,"
                    + "birthdate,"
                    + "place_of_birth,"
                    + "image,"
                    + "position_id"
                    + ") values(?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, employee.getId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setString(4, employee.getMiddleName());
            ps.setString(5, employee.getNameExtension());
            ps.setString(6, employee.getGender());
            ps.setDate(7, employee.getBirthDate());
            ps.setString(8, employee.getPlaceOfBirth());
            ps.setString(9, employee.getImage());
            ps.setInt(10, employee.getPosition().getId());

            ps.executeUpdate();

            String query2 = "insert into employee_info("
                    + "employee_id,"
                    + "civil_status,"
                    + "citizenship,"
                    + "height,"
                    + "weight,"
                    + "blood_type,"
                    + "gsis,"
                    + "sss,"
                    + "phil_health,"
                    + "pag_ibig,"
                    + "tin,"
                    + "cellphone_no,"
                    + "telephone_no,"
                    + "email,"
                    + "current_address,"
                    + "permanent_address"
                    + ") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);\n";
            // query =query.concat("Commit;");

            ps = conn.prepareStatement(query2);

            Employee_PersonalInfo personalInfo = employee.getPersonalInfo();

            ps.setString(1, personalInfo.getEmployeeId());
            ps.setString(2, personalInfo.getCivilStatus());
            ps.setString(3, personalInfo.getCitizenship());
            ps.setString(4, personalInfo.getHeight());
            ps.setString(5, personalInfo.getWeight());
            ps.setString(6, personalInfo.getBloodType());
            ps.setString(7, personalInfo.getGsis());
            ps.setString(8, personalInfo.getSss());
            ps.setString(9, personalInfo.getPhilHealth());
            ps.setString(10, personalInfo.getPagIbig());
            ps.setString(11, personalInfo.getTin());
            ps.setString(12, personalInfo.getCellphoneNumber());
            ps.setString(13, personalInfo.getTelephoneNumber());
            ps.setString(14, personalInfo.getEmail());
            ps.setString(15, personalInfo.getCurrentAddress());
            ps.setString(16, personalInfo.getPermanentAddress());

            n = ps.executeUpdate();

            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            conn.rollback();
        }
       
        return n;
    }

    @Override
    public int update(Employee employee) throws SQLException {
        int n =0;
        try {
            conn.setAutoCommit(false);
            String query = "update employee set "
                    + "firstname=?,"
                    + "lastname=?,"
                    + "middlename=?,"
                    + "name_extension=?,"
                    + "gender=?,"
                    + "birthdate=?,"
                    + "place_of_birth=?,"
                    + "image=?,"
                    + "position_id=?,"
                    + " updated_at = CURRENT_TIMESTAMP where id =?";

            PreparedStatement ps = conn.prepareStatement(query);
        
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getMiddleName());
            ps.setString(4, employee.getNameExtension());
            ps.setString(5, employee.getGender());
            ps.setDate(6, employee.getBirthDate());
            ps.setString(7, employee.getPlaceOfBirth());
            ps.setString(8, employee.getImage());
            ps.setInt(9, employee.getPosition().getId());
             ps.setString(10, employee.getId());

            ps.executeUpdate();

            String query2 = "update employee_info set "
                    + "civil_status=?,"
                    + "citizenship=?,"
                    + "height=?,"
                    + "weight=?,"
                    + "blood_type=?,"
                    + "gsis=?,"
                    + "sss=?,"
                    + "phil_health=?,"
                    + "pag_ibig=?,"
                    + "tin=?,"
                    + "cellphone_no=?,"
                    + "telephone_no=?,"
                    + "email=?,"
                    + "current_address=?,"
                    + "permanent_address=?"
                    + " where employee_id=?";
            // query =query.concat("Commit;");

            ps = conn.prepareStatement(query2);

            Employee_PersonalInfo personalInfo = employee.getPersonalInfo();

            
            ps.setString(1, personalInfo.getCivilStatus());
            ps.setString(2, personalInfo.getCitizenship());
            ps.setString(3, personalInfo.getHeight());
            ps.setString(4, personalInfo.getWeight());
            ps.setString(5, personalInfo.getBloodType());
            ps.setString(6, personalInfo.getGsis());
            ps.setString(7, personalInfo.getSss());
            ps.setString(8, personalInfo.getPhilHealth());
            ps.setString(9, personalInfo.getPagIbig());
            ps.setString(10, personalInfo.getTin());
            ps.setString(11, personalInfo.getCellphoneNumber());
            ps.setString(12, personalInfo.getTelephoneNumber());
            ps.setString(13, personalInfo.getEmail());
            ps.setString(14, personalInfo.getCurrentAddress());
            ps.setString(15, personalInfo.getPermanentAddress());
            ps.setString(16, personalInfo.getEmployeeId());

            n = ps.executeUpdate();

            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            conn.rollback();
        }
       
        return n;
    }

    @Override
    public int delete(Employee employee) throws SQLException {
        String id = employee.getId();
        int n=0;
        
        try {
            conn.setAutoCommit(false);
            String query = "delete from employee where id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, id);
            n = pst.executeUpdate();
            
            
            query = "delete from employee_info where employee_id = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            n = pst.executeUpdate();
            
            query = "delete from employee_and_service_credits where employeeId = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            n = pst.executeUpdate();
            
            query = "delete from employee_leave where employeeId = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            
            n = pst.executeUpdate();
            
            conn.commit();
        } catch (SQLException e) {
            
        }
        return n;
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        
        String query ="select * from employee , employee_info WHERE employee.id = employee_info.employee_id limit 20";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
      
        return mapEmployees(rs);
    }

    @Override
    public Employee getEmployee(String id) throws SQLException {
      String query = "select * from employee INNER JOIN employee_info on employee.id = employee_info.employee_id WHERE employee.id =?";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      
    
      if(rs.next()){
            Employee employee = new Employee();
           String employee_id =rs.getString("id");
            
            //basic info
            employee.setId(employee_id);
            employee.setFirstName(rs.getString("firstname"));
            employee.setLastName(rs.getString("lastname"));
            employee.setMiddleName(rs.getString("middlename"));
            employee.setNameExtension(rs.getString("name_extension"));
            employee.setGender(rs.getString("gender"));
            employee.setBirthDate(rs.getDate("birthdate"));
            employee.setPlaceOfBirth(rs.getString("place_of_birth"));
            employee.setImage(rs.getString("image"));
           
            employee.setCreated_at(rs.getTimestamp("created_at"));
            employee.setLast_updated(rs.getTimestamp("updated_at"));
            
          
            Position position = getPosition(rs.getInt("position_id"));
            employee.setPosition(position);
            
            
            //additional info
            Employee_PersonalInfo personalInfo = new Employee_PersonalInfo();
                   
            personalInfo.setEmployeeId(employee_id);
            personalInfo.setPositionId(rs.getInt("position_id"));
            personalInfo.setCivilStatus(rs.getString("civil_status"));
            personalInfo.setCitizenship(rs.getString("citizenship"));
            personalInfo.setHeight(rs.getString("height"));
            personalInfo.setWeight(rs.getString("weight"));
            personalInfo.setBloodType(rs.getString("blood_type"));
            personalInfo.setGsis(rs.getString("gsis"));
            personalInfo.setSss(rs.getString("sss"));
            personalInfo.setPhilHealth(rs.getString("phil_health"));
            personalInfo.setPagIbig(rs.getString("pag_ibig"));
            personalInfo.setTin(rs.getString("tin"));
            personalInfo.setCellphoneNumber(rs.getString("cellphone_no"));
            personalInfo.setTelephoneNumber(rs.getString("telephone_no"));
            personalInfo.setEmail(rs.getString("email"));
            personalInfo.setCurrentAddress(rs.getString("current_address"));
            personalInfo.setPermanentAddress(rs.getString("permanent_address"));
            
            employee.setPersonalInfo(personalInfo);
            return employee;
      }
      return null;
    }

    @Override
    public String getLastId() throws SQLException {
        String query = "select id from employee order by id desc limit 1";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        return rs.next() ? rs.getString("id") : null;
    }

    @Override
    public int addPosition(Position position) throws SQLException {
        try {
            conn.setAutoCommit(false);
            String query = "insert into positions(name, category) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, position.getName());
            ps.setString(2, position.getCategory());

            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
        }

        return 0;
    }

    @Override
    public Position getPosition(int id) throws SQLException {
        String query = "Select * from positions where id =?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        Position position = new Position();
        rs.next();
            position.setId(id);
            position.setName(rs.getString("name"));
            position.setCategory(rs.getString("category"));
            
        return position;
    }

    @Override
    public List<Position> getPositions() throws SQLException {
        String query = "Select  * from positions";
        PreparedStatement pst  = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        
        List<Position> positions = new ArrayList<>();
        while(rs.next()){
            Position position = new Position();
            position.setId(rs.getInt("id"));
            position.setName(rs.getString("name"));
            position.setCategory(rs.getString("category"));
            
            positions.add(position);
        }
        
        return positions;
    }
    
    
    private List<Employee> mapEmployees(ResultSet rs) throws SQLException{
      List<Employee> employees = new ArrayList<>();
        
        
       
        while( rs.next()){
            Employee employee = new Employee();
            String employee_id =rs.getString("id");
            
            //basic info
            employee.setId(employee_id);
            employee.setFirstName(rs.getString("firstname"));
            employee.setLastName(rs.getString("lastname"));
            employee.setMiddleName(rs.getString("middlename"));
            employee.setNameExtension(rs.getString("name_extension"));
            employee.setGender(rs.getString("gender"));
            employee.setBirthDate(rs.getDate("birthdate"));
            employee.setPlaceOfBirth(rs.getString("place_of_birth"));
            employee.setImage(rs.getString("image"));
            employee.setCreated_at(rs.getTimestamp("created_at"));
            employee.setLast_updated(rs.getTimestamp("updated_at"));
            
          
            Position position = getPosition(rs.getInt("position_id"));
            employee.setPosition(position);
            
            
            //additional info
            Employee_PersonalInfo personalInfo = new Employee_PersonalInfo();
                   
            personalInfo.setEmployeeId(employee_id);
            personalInfo.setPositionId(rs.getInt("position_id"));
            personalInfo.setCivilStatus(rs.getString("civil_status"));
            personalInfo.setCitizenship(rs.getString("citizenship"));
            personalInfo.setHeight(rs.getString("height"));
            personalInfo.setWeight(rs.getString("weight"));
            personalInfo.setBloodType(rs.getString("blood_type"));
            personalInfo.setGsis(rs.getString("gsis"));
            personalInfo.setSss(rs.getString("sss"));
            personalInfo.setPhilHealth(rs.getString("phil_health"));
            personalInfo.setPagIbig(rs.getString("pag_ibig"));
            personalInfo.setTin(rs.getString("tin"));
            personalInfo.setCellphoneNumber(rs.getString("cellphone_no"));
            personalInfo.setTelephoneNumber(rs.getString("telephone_no"));
            personalInfo.setEmail(rs.getString("email"));
            personalInfo.setCurrentAddress(rs.getString("current_address"));
            personalInfo.setPermanentAddress(rs.getString("permanent_address"));
            
            employee.setPersonalInfo(personalInfo);
            
            employees.add(employee);
           
            
        }
        return employees;
    }

    @Override
    public List<Employee> search(String item) throws SQLException {
        String query = "select * from employee INNER join"
                + " employee_info on employee_info.employee_id = employee.id WHERE " 
                +"employee.id = ? or employee.firstname like ? or employee.lastname like ? limit 5";
        
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, item);
        ps.setString(2, item+"%");
        ps.setString(3, item+"%");
        ResultSet rs = ps.executeQuery();
      
        
        return mapEmployees(rs);
    }

  


 


}
