
import data.controllers.ServiceCreditController;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author root
 */


public class TestClass {
    String title;
    String artist;
    
    public TestClass(String title, String artist) {
        this.title = title;
        this.artist = artist;
        
    }
    public static void main(String[] args) {
        ServiceCreditController controller = new ServiceCreditController();
        
        try{
          
            System.out.println(  controller.reset());
        }catch(java.sql.SQLException e){
            
        }
    }
}
