/*
 * Developer's Name : Rishab.H
 * "KeyHandler" class contains :
  		- Constructor.
  		- keyTyped() method.
  		- keyPressed() method.
  		- keyReleased() method.
 * keyTyped() and keyReleased() methods are empty because it is actually not needed but if we havn't defined them then an error is display and even the keyPressed() is not called.
 */


import java.awt.event.KeyEvent ;
import java.awt.event.KeyListener ;


public class KeyHandler implements KeyListener
{

	GUI gui ;
	
	public KeyHandler(GUI gui)
	{
		this.gui = gui ;
	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		// Alt + F => File Menu Click
		if((e.isAltDown()) && (e.getKeyCode() == KeyEvent.VK_F))
		{
			gui.menuFile.doClick() ;
		}
		
		// Ctrl + N => Open a new file
		if((e.isControlDown()) && (e.getKeyCode() == KeyEvent.VK_N))
		{
			gui.file.newFile() ;
		}
		
		// Ctrl + O => Open a new file 
		if((e.isControlDown()) && (e.getKeyCode() == KeyEvent.VK_O))
		{
			gui.file.open() ;
		}
		
		// Ctrl + S => Save a file
		if((e.isControlDown()) && (e.getKeyCode() == KeyEvent.VK_S))
		{
			gui.file.save() ;
		}
		
		// Ctrl + Shift + S => SaveAs a file
		if((e.isShiftDown()) && (e.isControlDown()) && (e.getKeyCode() == KeyEvent.VK_S))
		{
			gui.file.saveAs() ;
		}
		
		// Alt + F4 => Close the Notepad
		if((e.isAltDown()) && (e.getKeyCode() == KeyEvent.VK_F4))
		{
			gui.file.exit() ;
		}
		
		// Alt + E => Edit Menu Click
		if((e.isAltDown()) && (e.getKeyCode() == KeyEvent.VK_E))
		{
			gui.menuEdit.doClick() ;
		}
		
		// Ctrl + Z => Undo Option
		if((e.isControlDown()) && (e.getKeyCode() == KeyEvent.VK_Z))
		{
			gui.edit.undo() ;
		}
		
		// Ctrl + R => Redo Option
		if((e.isControlDown()) && (e.getKeyCode() == KeyEvent.VK_R))
		{
			gui.edit.redo() ;
		}
		
		// Alt + O => Format Menu Click
		if((e.isAltDown()) && (e.getKeyCode() == KeyEvent.VK_O))
		{
			gui.menuFormat.doClick() ;
		}
		
		// Alt + C => Color Menu Click
		if((e.isAltDown()) && (e.getKeyCode() == KeyEvent.VK_C))
		{
			gui.menuColor.doClick() ;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
			
	}
	
}
