package heartjframe;

//import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

public class ImgJPainel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double escala = 50; //escala de 50 pixels para cada unidade do universo
	private Polygon poly;
	private Polygon polytr;
	private Polygon polyes;
	private Polygon polyrot;
	//marks number
	public int getXint(double x) {
    	return (int) (20 + ( x * escala ));
    }
    		
    public int getYint(double y) {
    	return (int) (460 - ( y * escala ));
    }
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);

		//1a quest
		//vertical line
		g.setColor(Color.BLACK);
		g.drawLine(320,0, 320,480);
		
		//horizontal line
		g.setColor(Color.BLACK);
		g.drawLine(0,240, 640,240);

		//marks
		for (int i = 20; i < 640; i=i+50) {
			g.drawLine(i,235 , i, 245);
		}
    
	    for (int i = 40; i < 480; i=i+50) {
	    	g.drawLine(315, i, 325, i);
	    }
    
		//y and x axis numbers
	    
	    for (int i = 0; i < ((this.getWidth()/2)/escala); i++)
	    	g.drawString(""+i, getXint(i-0.2), getYint(-0.3));
	    for (int i = 1; i < ((this.getWidth()/2)/escala); i++) 
	    	g.drawString(""+i, getXint(-0.3), getYint(i));
	    for (int i = -1; i > -((this.getWidth()/2)/escala); i--)
	    	g.drawString(""+i, getXint(i-0.2), getYint(-0.3));
	    for (int i = -1; i > -((this.getWidth()/2)/escala); i--) 
	    	g.drawString(""+i, getXint(-0.3), getYint(i));

		
		//2a quest
		//polygon with 11 sides	
		int xPoly[] = {174,254,264,254,208,174,150,124,104,114,174};
		int yPoly[] = {254,200,150,120,115,140,115,120,150,200,254};
        poly = new Polygon(xPoly, yPoly, xPoly.length);
        
        g.setColor(Color.GREEN);
        g.drawPolygon(poly);
        
        
        
        //3a quest - a)
        //rotation	
		for(int i = 0; i < xPoly.length; i++) {
        	xPoly[i] = (int) Math.abs(((xPoly[i] * Math.cos(60)) - (yPoly[i] * Math.sin(60))));
        	yPoly[i] = (int) Math.abs(((yPoly[i] * Math.cos(60)) + (xPoly[i] * Math.sin(60))));
        }
		
		polyrot = new Polygon(xPoly, yPoly, xPoly.length);
		g.setColor(Color.BLACK);
        g.drawPolygon(polyrot);
				
        
        
        //translation
        for(int i = 0; i < xPoly.length; i++) {
        	xPoly[i] += (3 * escala);
        	yPoly[i] -= (2 * escala);
        }
        
		polytr = new Polygon(xPoly, yPoly, xPoly.length);
		
		g.setColor(Color.PINK);
        g.drawPolygon(polytr);
				
        
        
        //scale
        for(int i = 0; i < xPoly.length; i++) {
        	xPoly[i] *= 2;
        	yPoly[i] *= 2;
        }

        
		polyes = new Polygon(xPoly, yPoly, xPoly.length);
		
		g.setColor(Color.ORANGE);
        g.drawPolygon(polyes);
       
	}
}
