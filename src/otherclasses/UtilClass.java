/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otherclasses;

import data.model.EmployeeServiceCredit;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import java.util.List;

/**
 *
 * @author root
 */
public class UtilClass {

    public static LocalDate currentDate = LocalDate.now();

    public static int splitId(String id) {
        String[] idNum = id.split("-");

        return Integer.parseInt(cut(idNum[1])) + 1;

    }
    
     public static int splitRefNum(String id) {
    

        return Integer.parseInt(id.substring(4, id.length()))+1;

    }
    
    public static String getPrefix(String id){
        LocalDate localDate = LocalDate.now();
        int day = localDate.getDayOfMonth();
        
        String lastTwo = id.substring(id.length()-2);
        
        //String dayStr = String.valueOf(day).substring(0, 2);
        String dayStr = String.valueOf(day);
        System.out.println("prefix>>>"+ lastTwo+dayStr);
        return lastTwo;
    }

    private static String cut(String str) {

        return String.valueOf(currentDate.getYear()).substring(2, 4)
                + str.substring(2, str.length());
    }

    public static String checkValue(String str) {
        if (str == null || str.replace(" ", "").length() == 0) {
            return "--";
        }
        return str;
    }

    public static String convertDate(Date date) {
        DateFormat df = new SimpleDateFormat("MMMM dd, YYYY");
          

        return df.format(date);
    }
    
    public static int splitDate(String date, int index){
        String[] split = date.split("-");
        
        return Integer.parseInt(split[index]);
        
    }
    
    public static String getCurrent(){
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, YYYY");
       return String.valueOf(formatter.format(currentDate));
    }
    
      
    public static java.sql.Date getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       
       return java.sql.Date.valueOf(formatter.format(currentDate));
       
    }
    
    
    
    public static int getTotalCredits( List<EmployeeServiceCredit> serviceCredits){
        int total = 0;
        
        for(EmployeeServiceCredit item:serviceCredits){
           
            total+=item.getNo_of_days();
        }
        
        return total;
        
    }
    
    public static int getTotalUsedCredits( List<EmployeeServiceCredit> serviceCredits){
        int total = 0;
        
        for(EmployeeServiceCredit item:serviceCredits){
           
            total+=item.getDays_used();
        }
        
        return total;
        
    }
    
    
    public static String convertToSqlDate(String date){
        String[] arr =date.split("/");
        
        return arr[2]+"-"+arr[1]+"-"+arr[0];
    }
   
        
    public static java.sql.Date getSQLDate(Calendar calendar) {
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH + 1);
//        int day = calendar.get(Calendar.DATE);
        return new  java.sql.Date(calendar.getTimeInMillis());
    }
   

}
