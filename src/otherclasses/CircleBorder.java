/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otherclasses;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.border.AbstractBorder;

public class CircleBorder extends AbstractBorder{
    private final Color color;
    private BasicStroke stroke = null;
    private final RenderingHints hints;
    /** Constructor*/
    CircleBorder() {        
        color = Color.BLACK;
        stroke = new BasicStroke(1);
        hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    }
   public CircleBorder( Color color, int value) {        
        this.color = color;
        stroke = new BasicStroke(value);     
        hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }        

    @Override
    public void paintBorder(Component c,Graphics g,int x, int y, int width, int height) {

        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle2D = new Ellipse2D.Double();//java2d

        if( stroke.getLineWidth()==0 )
        {
            circle2D.setFrameFromCenter( 
                    new Point(x+width/2,y+height/2), //rata tengah 
                    new Point( width , height) //lebar dan tinggi
                    );            
        }
        else
        {
            circle2D.setFrameFromCenter( 
                    new Point(x+width/2,y+height/2), 
                    new Point( width-(int)stroke.getLineWidth() , height-(int) stroke.getLineWidth())
                    );            
        }                
        Polygon pointer = new Polygon();
        Area area = new Area(circle2D);        
        area.add(new Area(pointer));
        g2.setRenderingHints(hints);

        //set warna background berdasarkan latar belakang parent
        Component parent  = c.getParent();
        if (parent!=null) {
            Color bg = parent.getBackground();
            Rectangle rect = new Rectangle(0,0,width, height);
            Area borderRegion = new Area(rect);
            borderRegion.subtract(area);
            g2.setClip(borderRegion);
            g2.setColor(bg);
            g2.fillRect(0, 0, width, height);
            g2.setClip(null);
        }                 
        if( stroke.getLineWidth()>0 )
        {
            g2.setColor(color);
            g2.setStroke(stroke);            
        }        
        g2.draw(area);
    }
}