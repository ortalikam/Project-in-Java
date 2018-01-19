# Project-in-Java--painted


This Assignment is based on “MyShape” polymorphic hierarchy of shapes.
create a smart interactive drawing application, allowing the user to choose:
•	The current shape’s type (using a combo box GUI component);
•	The current shape’s color (using a combo box GUI component);
•	And whether the shape is filled or not (using a check box GUI component); 
this option is relevant only for rectangles and ovals and its choice does not affect lines!).

The drawing panel is accumulative: namely, every shape that was drawn on the panel must keep on existing on it until explicitly cleared!
 There are two types of clearance that can be performed by two respective buttons:
•	“Undo” Button – when this button is clicked the last drawn shape should be cleared from the drawing panel, but all the other shapes 
should remain exactly as they were! Clicking this button again will clear the next last shape… and so on. Clicking this button when the panel has 
no shapes will have no effect (at least not with regards to GUI visibility!). 
•	“Clear” Button – when this button is clicked the drawing panel must be cleared of ALL the shapes! The purpose of this button is to clear 
the panel – to be ready for a new drawing session. Clicking this button when the panel has no shapes will have no effect (at least not with regards 
to GUI visibility!). 
Recall that, in effect, whenever the drawing panel is “repainted”, its paintComponent method is invoked. This suggests that the history of the drawn
 shapes (for the current drawing session!) must be preserved. Also recall that any of the shapes in “MyShape” hierarchy knows how to “draw” itself 
polymorphically (according to the data kept in the specific shape object) – this suggests that a polymorphic structure of some sort (say an array of Shapes)
 should keep the history of the drawn shapes. Thus, whenever paintComponent method of the drawing panel is invoked – this structure should be traversed and 
get each shape to draw itself polymorphically!

The maximum number of shapes, allowed to be drawn on the panel is 100. If this maximum is reached, any next attempt to draw any shape should be denied 
and a warning message should be issued, using a Message Dialog Box. 
