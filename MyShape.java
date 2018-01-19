
import java.awt.Color;
import java.awt.Graphics;
/**
 * Declaration of abstract class MyShape.
 */
public abstract class MyShape 
{
   private int x1; // x coordinate of first endpoint
   private int y1; // y coordinate of first endpoint
   private int x2; // x coordinate of second endpoint
   private int y2; // y coordinate of second endpoint
   private Color myColor; // color of this shape
   
      /**
	 * MyShape  constructor initializes private vars with default values
	 */
    public MyShape()
   {
      this(0, 0, 0, 0, Color.BLACK); // call constructor
    }
       
     /**
	 * MyShape constructor with input values
	 *@param x1 x coordinate of first endpoint
	 *@param y1 y coordinate of first endpoint
	 *@param x2 x coordinate of second endpoint
	 *@param y2 y coordinate of second endpoint
	 *@param myColor the color of the shape
	 */
   public MyShape(int x1, int y1, int x2, int y2, Color myColor)
   {
      this.x1 = (x1 >= 0 ? x1 : 0);
      this.y1 = (y1 >= 0 ? y1 : 0);
      this.x2 = (x2 >= 0 ? x2 : 0);
      this.y2 = (y2 >= 0 ? y2 : 0);
      this.myColor = myColor; 
   } 

    /**
	 * setX1 method set the x-coordinate of the first point
	 * @param x1  x coordinate of first endpoint
	 */
   public void setX1(int x1)
   {
      this.x1 = (x1 >= 0 ? x1 : 0);
   } 


       /**
	 * getX1 method get the x-coordinate of the first point
	 * @return  x coordinate of first endpoint
	 */
   public int getX1()
   {
      return x1;
   } 


    /**
	 * setX2 method  set the x-coordinate of the second point
	 * @param x2  x coordinate of second endpoint
	 */
   public void setX2(int x2)
   {
      this.x2 = (x2 >= 0 ? x2 : 0);
   } 


     /**
	 * getX2 method get the x-coordinate of the second point
	 * @return  x coordinate of second endpoint
	 */
   public int getX2()
   {
      return x2;
   } 

    /**
	 * setY1 method  set the y-coordinate of the first point
	 * @param y1  y coordinate of first endpoint
	 */
   public void setY1(int y1)
   {
      this.y1 = (y1 >= 0 ? y1 : 0);
   } 

   /**
	 * getY1 method get the y-coordinate of the first point
	 * @return  y coordinate of first endpoint
	 */
   public int getY1()
   {
      return y1;
   }


   /**
	 * setY2 method  set the y-coordinate of the second point
	 * @param y2  y coordinate of second endpoint
	 */
   public void setY2(int y2)
   {
      this.y2 = (y2 >= 0 ? y2 : 0);
   } 


   /**
	 * getY2 method get the y-coordinate of the second point
	 * @return  y coordinate of second endpoint
	 */
   public int getY2()
   {
      return y2;
   }


   /**
	 * setColor method  set the color
	 * @param myColor  color of shape
	 */
   public void setColor(Color myColor)
   {
       this.myColor = myColor;
   } 


   /**
	 * getColor method  get the color
	 * @return color of shape
	 */
   public Color getColor()
   {
      return myColor;
   } 

   /**
	 * draw abstract method   draws an shape in the specified color
	 * @param g  Graphics shape
	 */
   public abstract void draw(Graphics g);
 
   
}