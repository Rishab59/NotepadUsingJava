/*
 * Developer's Name : Rishab.H
 * This Notepad is developed using Eclipse IDE
 * "FunctionColor" class contains :
 		- Constructor.
 		- changeColor() method.
 * Three Background colors are available :
 		- Background color "White" with Font color "Black".
 		- Background color "Black" with Font color "White".
 		- Background color "Red" with Font color "Orange".
 */


import java.awt.Color ;


public class FunctionColor 
{
	
	GUI gui ;
	
	public FunctionColor(GUI gui)
	{
		this.gui = gui ;
	}
	
	public void changeColor(String currentBgColor)
	{
		switch (currentBgColor)
		{
			case "White" :
				gui.window.getContentPane().setBackground(Color.white) ;
				gui.textArea.setBackground(Color.white) ;
				gui.textArea.setForeground(Color.black) ; 
				// Foreground means Font Color
				break ;
			case "Black" :
				gui.window.getContentPane().setBackground(Color.black) ;
				gui.textArea.setBackground(Color.black) ;
				gui.textArea.setForeground(Color.white) ;
				break ;
			case "Red" :
				gui.window.getContentPane().setBackground(Color.red) ;
				gui.textArea.setBackground(Color.red) ;
				gui.textArea.setForeground(Color.orange) ;
				break ;
		}
		
	}
	
}
