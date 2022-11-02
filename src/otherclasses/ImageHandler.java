/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otherclasses;

import config.Config;
import java.awt.Image;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author root
 */
public class ImageHandler {
   

    public static String upload()throws NullPointerException {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png"));


        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        return f.getAbsolutePath();

    }
    
     public static void copyToTargetFolder(String sourcePath, String name)throws IOException {
        Path source = Paths.get(sourcePath);
        Path targetDir = Paths.get(Config.getImagePath());
        Files.createDirectories(targetDir);

        Path target = targetDir.resolve(name);// create new path ending with `name` content
        System.out.println("copying into " + target);
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
     
    public static String getName(String id){
        return "employee_"+id;
    }
    
    public static String getImagePath(String name){
        return Config.getImagePath()+"/"+name;
    }
     
     
     
     public static ImageIcon getImage(int width, int height,String path){
        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)); //100, 100 add your own size
     }

    static String delete() {
        return "";
    }

    public static void main(String[] args) {
        try{
             System.out.println(upload());
        }catch(NullPointerException e){
            
        }
       

    }

}
