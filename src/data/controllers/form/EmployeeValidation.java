/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.controllers.form;

import data.model.Department;
import otherclasses.UtilClass;
import data.model.Position;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JComboBox;
import pnhsems.InvalidInputException;

/**
 *
 * @author root
 */
public class EmployeeValidation {
    

    int day ;
    int month ;
    int year ;
    
    public String checkLastname(String lastName) throws InvalidInputException{
        if (lastName.replace(" ", "").length() == 0) {
           throw new InvalidInputException("Lastname cannot be empty");
        } else {
            return lastName;
            
        }
    }
    
    public String checkFirstname(String firstName) throws InvalidInputException{
        if (firstName.replace(" ", "").length() == 0) {
           throw new InvalidInputException("Firstname cannot be empty");
        } else {
            return firstName;
            
        }
    }

    public int checkDay(String day) {

        try {

            this.day = Integer.parseInt(day);
        } catch (NumberFormatException nfe) {
            this.day = 1;
        }

        boolean isFeb = this.month == 2 && this.day > 28;
        boolean has31
                = this.month == 1
                || this.month == 3
                || this.month == 5
                || this.month == 7
                || this.month == 8
                || this.month == 10
                || this.month == 12;

        if (isFeb) {
            this.day = 28;
        } else if (has31 && this.day > 31) {
            this.day = 31;
        } else if (this.day > 30) {
            this.day = 30;
        }

        return this.day;

    }

    public int checkMonth(String month) {

        try {
            this.month = Integer.parseInt(month);
        } catch (NumberFormatException nfe) {
            this.month = 1;

        }

        if (this.month > 12) {
            this.month = 12;
        }
        return this.month;
    }

    public int checkYear(String year) {

        try {
            this.year = Integer.parseInt(year);
        } catch (NumberFormatException nfe) {
            this.year = 2000;
        }

        if (this.year < 1900 || this.year > UtilClass.currentDate.getYear()) {

            this.year = UtilClass.currentDate.getYear() - 20;
        }
        return this.year;
    }
    
    public Date getDate() {
        if (year == 0 || month == 0 || day == 0) {
            return null;
        }

        LocalDate bday = LocalDate.of(year, month, day);
        return Date.valueOf(bday);

    }
    
    
    public String checkGender(JComboBox comboBox) throws InvalidInputException {
        if (comboBox.getSelectedIndex() <= 0) {

            throw new InvalidInputException("Please Select a Gender");
        }
        System.out.println(comboBox.getSelectedItem().toString());
        return comboBox.getSelectedItem().toString();
    }
    
    public Position checkPosition(int index,List< Position> positions) throws InvalidInputException  {
        
         if (index < 1) {
              
                throw new InvalidInputException("Please Select a Position");
               
            }
         
         return positions.get(index-1);
        
    }
    
     public Department checkDepartment(int index,List< Department> departments) throws InvalidInputException  {
        
         if (index < 1) {
              
                throw new InvalidInputException("Please Select a Department");
               
            }
         
         return departments.get(index-1);
        
    }
    
    
    public String checkField(String text){
        if (text.replace(" ", "").length() ==0){
            return null;
        } 
        return text;
    }

}
