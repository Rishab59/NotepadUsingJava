/*
 * Developer's Name : Rishab.H
 * This Notepad is developed using Eclipse IDE
 * "FunctionEdit" class contains :
 		- Constructor.
 		- undo() method.
 		- redo() method.
 */


public class FunctionEdit 
{
	
	GUI gui ;
	
	public FunctionEdit(GUI gui)
	{
		this.gui = gui ;
	}
	
	public void undo()
	{
		gui.um.undo() ;
	}
	
	public void redo()
	{
		gui.um.redo() ;
	}
	
}
