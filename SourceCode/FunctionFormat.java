/*
 * Developer's Name : Rishab.H
 * This Notepad is developed using Eclipse IDE
 * "FunctionFormat" class contains :
 		- Constructor.
 		- wordWrap() method.
 		- createFont() method.
 		- setFont() method. 
 */


import java.awt.Font ;


public class FunctionFormat 
{
	
	GUI gui ;
	Font arial, comicSansMS, consolas, timesNewRoman ;
	
	String selectedFont ;
	
	public FunctionFormat(GUI gui)
	{
		this.gui = gui ;
	}
	
	public void wordWrap()
	{
		if ((gui.wordWrapOn) == false)
		{
			gui.wordWrapOn = true ;
			gui.textArea.setLineWrap(true) ;
			gui.textArea.setWrapStyleWord(true) ;
			gui.itemWrap.setText("Word Wrap : on") ;
		}
		
		else
		{
			gui.wordWrapOn = false ;
			gui.textArea.setLineWrap(false) ;
			gui.textArea.setWrapStyleWord(false) ;
			gui.itemWrap.setText("Word Wrap : off") ;
		}
	}
	
	public void createFont(int fontSize)
	{
		arial = new Font("Arial", Font.PLAIN, fontSize) ;
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize) ;
		consolas = new Font("Consolas", Font.PLAIN, fontSize) ;
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize) ;
		
		setFont(selectedFont) ;
	}
	
	public void setFont(String font)
	{
		selectedFont = font ;
		
		switch (selectedFont)
		{
			case "Arial" :
				gui.textArea.setFont(arial) ;
				break ;
			case "Comic Sans MS" :
				gui.textArea.setFont(comicSansMS) ;
				break ;
			case "Consolas" :
				gui.textArea.setFont(consolas) ;
				break ;
			case "Times New Roman" :
				gui.textArea.setFont(timesNewRoman) ;
				break ;
		}		
	}
	
}
