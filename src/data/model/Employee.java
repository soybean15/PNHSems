/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model;


import java.sql.Date;
import java.util.List;


/**
 *
 * @author root
 */
public class Employee {
    
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String nameExtension;
    private String gender;
    private Date birthDate;
    private String placeOfBirth;
    private String image;
    private Position position;
    private Employee_PersonalInfo personalInfo;
    private java.sql.Timestamp created_at;
    private java.sql.Timestamp last_updated;

    
   

    public String getId() {
        return id;
    }

    public Employee setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName)  {
 
            this.firstName = firstName;
       
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName)  {
        this.lastName =lastName;
    }

    public String getMiddleName() {
        return middleName == null?"":middleName ;
    }

    public void setMiddleName(String middleName) {
       
            this.middleName = middleName;
     
    }

    public String getNameExtension() {
        return  nameExtension == null ? "" :nameExtension;
    }

    public void setNameExtension(String nameExtension) {
        this.nameExtension = nameExtension;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
       
        this.birthDate = birthDate;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Employee_PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(Employee_PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public java.sql.Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(java.sql.Timestamp created_at) {
        this.created_at = created_at;
    }

    public java.sql.Timestamp getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(java.sql.Timestamp last_updated) {
        this.last_updated = last_updated;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    
    public boolean validate(){
        
        return firstName !=null &&
                lastName !=null &&
                gender !=null &&
                position !=null &&
                birthDate !=null;
        
    }
    
    public String getFullname(){
        
        String _middleName = middleName!=null ? ", "+middleName.substring(0,1)+".":"";
        String _nameExtension = nameExtension==null?" ": " "+nameExtension+", ";
        
        return lastName+_nameExtension+firstName + _middleName;
    }
   
}
