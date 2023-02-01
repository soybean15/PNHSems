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
        int num = 5;
        int end = 500;
       int row = 12;
        
    
        int counter = 0;
        for (int i=num;i<=end;i+=num){
         
            counter++;
           
        }
        
        int col =counter/row;
        int n=0;
        for (int i = 1; i<counter; i++){
            System.out.print((n+=num)+"    ");
            if(i%col==0){
                System.out.println("");
            }
        }
        
      
                
    }
    
}
