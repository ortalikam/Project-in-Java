import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.BorderLayout;
import java.awt.Color;
/**
 * DrawFrame class constitutes the main window of the application
 * (extends {@link javax.swing.JFrame}). This class is responsible
 * for creating all the GUI elements and organize them.
 */
public class DrawFrame extends JFrame
{
	private JButton undoButton, clearButton; 
	private JComboBox<String> colorChoices, shapeChoices;
	private JCheckBox filledCheckBox;
	private JPanel buttons; //   buttons in north side
	private JLabel statusLabel; // South side of frame
	private DrawPanel  drawArea; // center Jpanel for drawing
	 private static final String[] shapeName = { "Line", "Oval", "Rectangle"};
	 private static final String[] colorNames = {"Black", "Blue", "Cyan",
		      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
		      "Orange", "Pink", "Red", "White", "Yellow"};
	 private static final Color[] colors = {Color.BLACK, Color.BLUE,
		      Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
		      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
		      Color.RED, Color.WHITE, Color.YELLOW};
	ButtonHandler handler;
	ItemHandler IHandler;
		      
	/**
	 * default Constructor initializes the frame GUI section and buttons handlers. 
	 */	      
	DrawFrame()
	{

		super("Shape Drawings"); //the text in the up bar
		setLayout(new BorderLayout());//set frame layout
		//init the buttons
		buttons = new JPanel();
		undoButton=new JButton ("Undo");
		buttons.add(undoButton);
		clearButton=new JButton ("Clear");
		buttons.add(clearButton);
		colorChoices=new JComboBox<String>  (colorNames);
		buttons.add(colorChoices);
		shapeChoices=new JComboBox<String>  (shapeName);
		buttons.add(shapeChoices);
		filledCheckBox=new JCheckBox ("Filled");
		buttons.add(filledCheckBox);
		add(buttons, BorderLayout.NORTH); // add  buttons to north size
		statusLabel=new JLabel("(0,0)");
		add(statusLabel,BorderLayout.SOUTH);
		drawArea=new DrawPanel(statusLabel); 
		add(drawArea, BorderLayout.CENTER); // add  buttons to north size
		///////////////////
		 handler =new ButtonHandler();
		undoButton.addActionListener(handler);
		clearButton.addActionListener(handler);
		////////////////////////
		IHandler = new ItemHandler();
		filledCheckBox.addItemListener(IHandler);
		colorChoices.addItemListener(IHandler);
		shapeChoices.addItemListener(IHandler);
	}
	
/**
 * listener for color, shape and filled sections and uses set functions of {@link DrawPanel}.
 * 
 */
private class ItemHandler implements ItemListener
{
	 @Override
	public void itemStateChanged(ItemEvent event) 
	{
		if(event.getSource()== filledCheckBox)
			drawArea.setFilledShape(filledCheckBox.isSelected());
		else if (event.getSource() == colorChoices)
			drawArea.setCurrentColor(colors[colorChoices.getSelectedIndex()]);
		else if (event.getSource() == shapeChoices)
			drawArea.setShapeType(shapeChoices.getSelectedIndex());
	 }
}

 /**
  * check if undo or clear was pressed and using {@link DrawPanel} methodes
  *  {@link DrawPanel#undo()} and {@link DrawPanel#clear()}.
 */
	private class ButtonHandler implements ActionListener
	{
		//handle button event
		 @Override
		public void actionPerformed (ActionEvent event)
		{
			if (event.getSource()==undoButton)
				drawArea.undo();
			else if (event.getSource()==clearButton)
				drawArea.clear();
		
			
		 }                                   
	}
	
}