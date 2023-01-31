/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.controllers.form;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author root
 */
public class UserValidation {

    private static final Pattern VALID_PASSWORD_REGEX
            = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");

    public static boolean validatePasswordOnUpdate(String password) {
        if(checkField(password)==null){
            return true;
        }
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        return matcher.find();
    }
    
    
    public static String checkField(String text){
        if (text.replace(" ", "").length() ==0){
            return null;
        } 
        return text;
    }
    
}
