/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package themes;

import java.awt.Font;

/**
 *
 * @author root
 */
public class AppFont {
    private String fontFamily_primary;
    private String fontFamily_content;

    public AppFont(String fontFamily_primary, String fontFamily_tableFont) {
        this.fontFamily_primary = fontFamily_primary;
        this.fontFamily_content = fontFamily_tableFont;
    }
    
 
    
    
    public Font big(int size) {
        return new Font(fontFamily_primary, Font.BOLD, size + 5);
    }

    public Font defaultFont(int size) {
        return new Font(fontFamily_primary, Font.PLAIN, size);
    }
    
    public Font tableFontDefault(int size){
        return new Font(fontFamily_content, Font.PLAIN, size);
    }
    
    public Font tableFontBig(int size){
        return new Font(fontFamily_content, Font.BOLD, size+3);
    }
    
    
    public static AppFont primary = new AppFont("AnjaliOldLipi", "Liberation Mono");
    
  
}
