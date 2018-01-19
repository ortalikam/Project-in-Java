
import java.awt.Color;
import java.awt.Graphics;
/**
 * this class Declaration of class MyBoundedShape.
 */
public class MyBoundedShape extends MyShape 
{

   private boolean filled; // whether this shape is filled

    /**
	 * MyBoundedShape  constructor initializes private vars with default values
	 */
   public MyBoundedShape()
   {
   	  
      super();
   } 

     /**
	 * MyBoundedShape constructor with input values
	 *@param x1 x coordinate of first endpoint
	 *@param y1 y coordinate of first endpoint
	 *@param x2 x coordinate of second endpoint
	 *@param y2 y coordinate of second endpoint
	 *@param myColor the color of the shape
	 *@param filled if the shape is filled
	 */
   public MyBoundedShape(int x1, int y1, int x2, int y2,
      Color myColor, boolean filled)
   {
      super(x1,y1,x2,y2,myColor);
      this.filled = filled;
   } 

  

     /**
	 * isFilled method determines whether this shape is filled
	 * @return if shape is filled
	 */
   public boolean isFilled()
   {
      return filled;
   } 


    /**
	 * setFilled method sets whether this shape is filled
	 * @param  filled if shape is filled
	 */
   public void setFilled(boolean filled)
   {
      this.filled = filled;
   }

       /**
	 * getUpperLeftX method get upper left x coordinate
	 * @return  upper left x coordinate
	 */
   public int getUpperLeftX()
   {
      return Math.min(super.getX1(), super.getX2());
   }

     /**
	 * getUpperLeftY method get upper left x coordinate
	 * @return  upper left x coordinate
	 */
   public int getUpperLeftY()
   {
      return Math.min(super.getY1(), super.getY2());
   } 

    /**
	 * getWidth method get shape width
	 * @return  shape width
	 */
   public int getWidth()
   {
      return Math.abs(super.getX2() - super.getX1());
   }

      /**
	 * getHeight method get shape height
	 * @return  shape height
	 */
   public int getHeight()
   {
      return Math.abs(super.getY2() - super.getY1());
   } 
 


    /**
	 * draw method draws an rectangle in the specified color
	 * @param g  Graphics shape
	 */
   public void draw(Graphics g)
   {
      g.setColor(super.getColor());
      
      if (isFilled())
         g.fillRect(getUpperLeftX(), getUpperLeftY(),
            getWidth(), getHeight());
      else
         g.drawRect(getUpperLeftX(), getUpperLeftY(),
            getWidth(), getHeight());
   } 
} // end class MyBoundedShape
