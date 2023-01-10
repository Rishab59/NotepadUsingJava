/*
 * Developer's Name : Rishab.H
 * "FunctionFile" class contains :
  		- Constructor.
  		- newFile() method => functionality of "New" MenuItem.
  		- open() method => functionality of "Open" MenuItem.
  		- save() method => functionality of "Save" MenuItem.
  		- saveAs() method => functionality of "SaveAs" MenuItem.
  		- exit() method => functionality of "Exit" MenuItem.
 */


import java.awt.FileDialog ;
import java.io.BufferedReader ;
import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.IOException ;


public class FunctionFile 
{
	
	GUI gui ;
	String fileName ;
	String fileLocation ;
	
	public FunctionFile(GUI gui)
	{
		this.gui = gui ;
	}
	
	public void newFile()
	{
		gui.textArea.setText("") ;
		gui.window.setTitle("New Notepad File By Rishab's Notepad") ;
		fileName = null ;
		fileLocation = null ;
	}
	
	public void open()
	{
		FileDialog fd = new FileDialog(gui.window, "Open option from Rishab's Notepad", FileDialog.LOAD) ;
		fd.setVisible(true) ;
		
		if((fd.getFile()) != null)
		{
			fileName = fd.getFile() ;
			fileLocation = fd.getDirectory() ;
			
			gui.window.setTitle(fileName + " is opened in Rishab's Notepad") ;
		}
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(fileLocation + fileName)) ; 
			// Address to read a file
			
			gui.textArea.setText("") ;
			String line = null ;
			
			while((line = br.readLine()) != null)
			{
				gui.textArea.append(line + "\n") ;
			}
			
			br.close() ;
		}
		
		catch(IOException e)
		{
			System.out.println("Error in Opening the file") ;
		}
	}
	
	public void save()
	{
		if(fileName == null)
		{
			saveAs() ;
		}
		
		else
		{
			try
			{
				FileWriter fw = new FileWriter(fileLocation + fileName) ;
				fw.write(gui.textArea.getText()) ;
				gui.window.setTitle(fileName + " is opened in Rishab's Notepad") ;
				fw.close() ;
			}
			
			catch(Exception e)
			{
				System.out.println(e.getMessage()) ;
			}
		}
	}
	
	public void saveAs()
	{
		FileDialog fd = new FileDialog(gui.window, "SaveAs option from Rishab's Notepad", FileDialog.SAVE) ;
		fd.setVisible(true) ;
		
		if((fd.getFile()) != null)
		{
			fileName = fd.getFile() ;
			fileLocation = fd.getDirectory() ;
			
			gui.window.setTitle(fileName + " is opened in Rishab's Notepad") ;
		}
		
		try
		{
			FileWriter fw = new FileWriter(fileLocation + fileName) ;
			fw.write(gui.textArea.getText()) ;
			
			fw.close() ;
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage()) ;
		}
	}
	
	public void exit()
	{
		System.exit(0) ;
	}
	
}
