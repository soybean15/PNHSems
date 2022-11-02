/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.io.File;

/**
 *
 * @author root
 */


public class Config {
    private static final String imagePath=null;
   
//    
//    public static String getImagePath(){
//        if (imagePath == null) {
//            if (OsUtils.getOs() == OsUtils.OS.WINDOWS) {
//                return System.getProperty("user.dir")+"/assets/image";
//            } else if (OsUtils.getOs() == OsUtils.OS.LINUX) {
//               return System.getProperty("user.dir");
//            }
//        }
//        
//        return imagePath;
//    }
    
    
        
    public static String getImagePath(){
       
        return System.getProperty("user.dir")+"/assets/image";
           
    }
    public static void createImageDIR(String path){
        System.out.println(path);
        File dir = new File(path);
        if(!dir.isDirectory()){
            dir.mkdirs();
            System.out.println("Directory Created");
        }else{
            System.out.println("Directory not Created");
        }
        
    }
    public static void main(String[] args) {
        createImageDIR(getImagePath());
    }
}
