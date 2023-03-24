/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pnhsems;


import frames.LoginFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class PNHSEMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       // TempData.start();
       try{
                   
        LoginFrame main = new LoginFrame();
     
        main.show();
      
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage());
       }
  

    }

}
