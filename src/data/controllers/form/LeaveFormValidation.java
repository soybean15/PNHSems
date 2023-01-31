/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.controllers.form;

/**
 *
 * @author root
 */
public class LeaveFormValidation {
    
    
     
    public static String checkField(String radioText, String details) {
        if(details==null || details.replace(" ", "").length()==0){
            return radioText;
        }else{
            return radioText+"{details: "+details+"}" ;
        }
        
    }

    

}
