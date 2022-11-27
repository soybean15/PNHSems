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
public class Colour {

    public Color background_primary;
    public Color foreground_white;
    public Color background_secondary;
    public Color foreground_black;
    public Color backgroundOnTop;
    public Color foregroundOnTop;
    public Color disable_gray = new Color(102,102,102);
    public Color enable_green = new Color(4,154,16);

    // public AppColor(){}
    public Colour(Color background_primary, Color foreground_primary, Color background_secondary, Color foreground_secondary ) {
        this.background_primary = background_primary;
        this.foreground_white = foreground_primary;
        this.background_secondary = background_secondary;
        this.foreground_black = foreground_secondary;
    }

    public Colour setColorOnTop(Color backgroundOnTop, Color foregroundOnTop) {
        this.backgroundOnTop = backgroundOnTop;

        this.foregroundOnTop = foregroundOnTop;

        return this;

    }

    public static Colour primary = new Colour(
            new Color(4, 65, 8),//green bg primary
            new Color(255, 255, 255),//white fg primary
            new Color(255, 255, 255),//white gb secondary
            new Color(30, 30, 30)//black fg secondary
    ).setColorOnTop(new Color(4, 115, 40), new Color(208, 91, 5));

}
