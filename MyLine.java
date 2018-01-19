
import java.awt.Color;
import java.awt.Graphics;
/**
 * this class Declaration of class MyLine.
 */
public class MyLine extends MyShape 
{

   /**
	 * MyLine  constructor  initializes private vars with default values
	 */
   public MyLine()
   {
     super(); // call constructor to set values
   } // end MyLine no-argument constructor

   /**
	 * MyLine  constructor  initializes private vars with input values
	 *@param x1 x coordinate of first endpoint
	 *@param y1 y coordinate of first endpoint
	 *@param x2 x coordinate of second endpoint
	 *@param y2 y coordinate of second endpoint
	 *@param myColor the color of the shape
	 */
   public MyLine(int x1, int y1, int x2, int y2, Color myColor)
   {
      super(x1,y1,x2,y2,myColor);
   } 


     /**
	 * draw method draw the line in the specified color
	 * @param g Graphics shape
	 */
   public void draw(Graphics g)
   {
      g.setColor(super.getColor());
      g.drawLine(super.getX1(), super.getY1(), super.getX2(), super.getY2());
   } 
} // end class MyLine
