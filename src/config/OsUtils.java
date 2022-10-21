/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author root
 */

public  final class OsUtils {
     public enum OS{
        WINDOWS, LINUX, SAMPLE
        
        
  }
   
    
    private static String _OS = null;
    private static OS os =null;
    
    public static OS getOs(){
        if(_OS == null){
            _OS = System.getProperty("os.name");
            if(_OS.contains("win")){
                os = OS.WINDOWS;
            }else if(_OS.contains("nix") || _OS.contains("nux")){
                System.out.println("User: "+System.getProperty("user.dir"));
                os = OS.LINUX;
            }
                
        }
        return os;
    }
    

    public static void main(String[] args) {
        System.out.println(getOs());
    }
    
}
