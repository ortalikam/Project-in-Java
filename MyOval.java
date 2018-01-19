
import java.awt.Color;
import java.awt.Graphics;
/**
 * Declaration of class MyOval.
 */
public class MyOval extends MyBoundedShape 
{


   /**
	 * MyOval  constructor initializes private vars with default values
	 */
   public MyOval()
   {
       super();
   }

   // constructor with input values
      /**
	 * MyOval constructor with input values
	 *@param x1 x coordinate of first endpoint
	 *@param y1 y coordinate of first endpoint
	 *@param x2 x coordinate of second endpoint
	 *@param y2 y coordinate of second endpoint
	 *@param myColor the color of the shape
	 *@param filled if the shape is filled
	 */
   public MyOval(int x1, int y1, int x2, int y2,
      Color myColor, boolean filled)
   {
      super(x1,y1,x2,y2,myColor,filled);

   } 


   

      /**
	 * draw method draws an oval in the specified color
	 * @param g  Graphics shape
	 */
   public void draw(Graphics g)
   {
      g.setColor(super.getColor());
      
      if (isFilled())
         g.fillOval(getUpperLeftX(), getUpperLeftY(),
            getWidth(), getHeight());
      else
         g.drawOval(getUpperLeftX(), getUpperLeftY(),
            getWidth(), getHeight());
   } 
} // end class MyOval
