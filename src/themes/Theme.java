/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package themes;

import java.awt.Color;


/**
 *
 * @author root
 */

public class Theme{
  public Colour COLOR;
  
  public AppFont FONT;
  
  public Theme ( Colour COLOR,AppFont FONT){
      this.COLOR = COLOR;
      this.FONT =FONT;
  }
  
  
  
  public static Theme PRIMARY = new Theme(
          Colour.primary,
          AppFont.primary
  );
    
            
}
