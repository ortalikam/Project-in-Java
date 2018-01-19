
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *  Test application to display a DrawPanel
 */
public class TestDraw
{
	/**
	 * static main method get from the user how much shapes he want and open the window for draw 
    */
    

   public static void main(String[] args)
   {
   	 
   	   
   	   	 DrawFrame application = new DrawFrame();
		 application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(500, 500); 
		application.setResizable(true);
		application.setVisible(true);     
   	  
   	   	  

   } // end main 
} // end class TestDraw
