/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author root
 */
public class TestClass {
    public static void main(String[] args) {
        
       String words = "hello WORLD";
       
       StringBuilder sb = new StringBuilder();
       
       for(int i=0; i<words.length();i++){
           if(Character.isLowerCase(words.charAt(i))){
               sb.insert(i, Character.toLowerCase(words.charAt(i)));
           }
           else if(Character.isUpperCase(words.charAt(i))){
               sb.insert(i, Character.toUpperCase(words.charAt(i)));
           }
           else{
               sb.insert(i, ' ');
           }
       }
       
        System.out.println(sb);
    }
}
