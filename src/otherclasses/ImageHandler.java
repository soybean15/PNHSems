/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otherclasses;

import config.Config;
import data.model.Employee;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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

    URL im = this.getClass().getClassLoader().getResource("img/app_img/male-default-img.jpg");
    //app images
//    private final ImageIcon male_default = new ImageIcon(this.getClass().getClassLoader().getResource("img/app_img/male-default-img.jpg"));
//    private final ImageIcon female_default = new ImageIcon(this.getClass().getClassLoader().getResource("img/app_img/female-default-img.jpg"));
//    private final ImageIcon app_logo = new ImageIcon(this.getClass().getClassLoader().getResource("img/app_img/pnhs_logo.png"));

    
     private final ImageIcon male_default = new ImageIcon(getIconPath("/img/app_img/male-default-img.jpg"));
    private final ImageIcon female_default = new ImageIcon(getIconPath("/img/app_img/female-default-img.jpg"));
    private final ImageIcon app_logo = new ImageIcon(getIconPath("/img/app_img/pnhs_logo.png"));

    public static ImageIcon getDefault(int width, int height) {
        ImageHandler ih = new ImageHandler();
        return new ImageIcon(ih.male_default.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }

    public static ImageIcon getLogo(int width, int height) {
        ImageHandler ih = new ImageHandler();
        return new ImageIcon(ih.app_logo.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }

    public static String upload() throws NullPointerException {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png"));

        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        System.out.println( f.getAbsolutePath());
        return f.getAbsolutePath();

    }

    public static void copyToTargetFolder(String sourcePath, String name) throws IOException {
        Path source = Paths.get(sourcePath);
  
        Path targetDir = Paths.get(Config.getImagePath());
        Files.createDirectories(targetDir);

        Path target = targetDir.resolve(name);// create new path ending with `name` content
        System.out.println("copying into " + target);
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }



    public static String getImagePath(String name) {
        return Config.getImagePath() + "/" + name;
    }

    public static ImageIcon getImage(int width, int height, Employee employee) {
        File file = new File(getImagePath(employee.getImage()));

        if (file.exists()) {
            return new ImageIcon(new ImageIcon(getImagePath(employee.getImage())).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)); //100, 100 add your own size
        }

        return getDefaultImage(width, height, employee.getGender());

    }

    public static ImageIcon getImage(int width, int height, String path) {

        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)); //100, 100 add your own size
    }

    public static ImageIcon getDefaultImage(int width, int height, String gender) {
        ImageHandler ih = new ImageHandler();
      
      
        if (gender == null || gender.equals("Male")) {
            return new ImageIcon(ih.male_default.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        } else {
            return new ImageIcon(ih.female_default.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        }

    }
    
    public static String getIconPath(String iconPath){
        String path = System.getProperty("user.dir");
        return path+"/src"+iconPath;
    }

}
