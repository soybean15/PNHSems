
import java.net.URL;
import java.util.LinkedList;
import otherclasses.ImageHandler;
import otherclasses.UtilClass;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author root
 */
public class Sample {
    
    public static void main(String[] args) {
        
        for(String str :UtilClass.parseDetails("Abroad{details: Going vacation}")){
             System.out.println(str);
        }
        
          
    }
    
}
