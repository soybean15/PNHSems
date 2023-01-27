
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author root
 */

class Music{
    String title;
    String artist;
    
    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
        
    }
    
    
}

public class TestClass {
    public static void main(String[] args) {
       
        ArrayList<Object> arr = new ArrayList<>();
        
        arr.add(1);
        arr.add(2);
        arr.add(new int[]{1,2,3});
        
        System.out.println(arr);
       
        
    }
}
