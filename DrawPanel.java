import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
/**
 * Smart drawing panel that handle mouse and mouseMotion actions.
 */
public class DrawPanel extends JPanel
{
  
   private MyShape[] shapes; // array of Shapes
   private int shapeCount; //status how much Shapes we have
   private MyShape currentShape;
   private int shapeType; // 0 :Line, 1 :Oval, 2: Rectangle
   private Color  CurrentColor;
   private boolean filledShape;
   private JLabel statusText; // String containing shape statistic information
   private boolean newShapeStart;
   	/**
	 * Constructor initializes Characteristics of shape and status Label
	 * @param statusLabel reference of {@link javax.swing.JLabel} for corrdinate updating
	 */
   public DrawPanel(JLabel statusLabel)
   {
      setBackground(Color.WHITE);   
      shapes=new MyShape[100];
      this.statusText=statusLabel;
      setShapeType(0);
      setCurrentColor(Color.BLACK);
      setFilledShape(false);
       MouseHandler handler =new MouseHandler();
       addMouseMotionListener(handler);
       addMouseListener(handler);
      
   }  
      
 




   
   // for each shape array, draw the individual shapes
     /**
	 * paintComponent method  draw the individual shapes for each shape array
	 * @param g  Graphics shape 
	 */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
		for (int i = 0; i < shapeCount; i++)
	        shapes[i].draw(g); 
		if (newShapeStart)
			currentShape.draw(g);
    
   } 
   
   /**
	 * set the type of shape - in this program, using in DrawFrame as a action for buttons selections.
	 * @param shapeType integer (0={@link MyLine}, 1={@link MyOval}, 2={@link MyRectangle}).
	 */
    final public void  setShapeType( int shapeType)
      { this.shapeType=shapeType;
      }
      
      
      /**
	 * set shape color - in this program, using in DrawFrame as a action for buttons selections.
	 * @param CurrentColor {@link java.awt.color} type
	 */
     final public void setCurrentColor( Color CurrentColor)
      { this.CurrentColor=CurrentColor;
      }
      
      /**
	 * set if type is filled (only for {@link MyOval}/{@link MyRectangle}) - in this program, using in DrawFrame as a action for buttons selections.
	 * @param filledShape booleane for isFilled
	 */
     final public void setFilledShape( boolean filledShape)
      { this.filledShape=filledShape;
      }
      
      /**
	 * erase the last shape that was drawed and updates the size of the shape. 
	 */
	public void undo()
	{
		if (shapeCount > 0)
			shapeCount--;
		repaint();
	}
	
	/**
	 * erase all the shapes that was draw. initilaze the size of the to zero.
	 */
	public void clear()
	{
		shapeCount = 0;
		repaint();
	}
	

  
   /**
	 * Define mouse action and motion for draw max 100 shape, using only left click of the mouse.
	 */
    private class MouseHandler extends MouseAdapter implements MouseListener, 
      MouseMotionListener 
   {
 
      // handle event when mouse pressed
      @Override
      public void mousePressed(MouseEvent event)
      {
      	  if (event.getButton() == MouseEvent.BUTTON1){ //  left Button
			if (shapeCount == shapes.length) // limited for array size, in this case - 100
			{
				JOptionPane.showMessageDialog(null, "Cannot exceed the current number of shapes:"+shapeCount,"Capacity Overload", JOptionPane.WARNING_MESSAGE);
				return;
			}
			//there is place foe shape
			newShapeStart = true;
			int x = event.getX();
			int y = event.getY();
			 switch(shapeType)
			 {
			 case 0: currentShape = new MyLine(x, y, x, y, CurrentColor); 
			 	 break;
			 case 1: currentShape = new MyOval(x, y, x, y, CurrentColor, filledShape); 
			 	 break;
			 case 2: currentShape = new MyRectangle(x, y, x, y, CurrentColor, filledShape);
			 	 break;

			
			 }

			}
      }

      // handle event when mouse released 
      @Override
      public void mouseReleased(MouseEvent event)
      {
      	  if (event.getButton() == MouseEvent.BUTTON1) // //  left Button Released
			{
				if (event.getX() != currentShape.getX1() || event.getY() != currentShape.getY1())
				{
					currentShape.setX2(event.getX());
					currentShape.setY2(event.getY());
					shapes[shapeCount] = currentShape; 
					shapeCount++;
					
				}
				newShapeStart=false;
				repaint();
				
			}
      }

      

      // MouseMotionListener event handlers
      // handle event when user drags mouse with button pressed
      @Override
      public void mouseDragged(MouseEvent event)
      {
      	 
      	  if (newShapeStart) 
			{
				currentShape.setX2(event.getX());
				currentShape.setY2(event.getY());
				repaint();
			}
			mouseMoved(event);
      } 

      // handle event when user moves mouse
      @Override
      public void mouseMoved(MouseEvent event)
      {
          statusText.setText(String.format("(%d, %d)", event.getX(), event.getY()));
          
      } 
   } // end inner class MouseHandler
} // end class DrawPanel
