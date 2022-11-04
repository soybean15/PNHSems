/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.controllers.form;

/**
 *
 * @author root
 */
public class ServiceCreditValidation {
    
    public String checkField(String text){
        if(text.replace(" ", "").length()==0){
            return null;
        }
        return text;
    }
    
    public int checkInt(String num){
        try{
            
            return Integer.parseInt(num);
        }catch(NumberFormatException nfe){
            return -1;
        }
    }
    
}
