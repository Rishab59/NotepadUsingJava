/*
 * Developer's Name : Rishab.H
 * This Notepad is developed using Eclipse IDE
 * Description :
  		- This is a fully functional Notepad and also has Shortcuts like a regular Notepad to use without mouse.
  		- The ScrollPane will appear only if it is needed.
 * ShortCuts :
  		- Alt + F => File Menu Click
  		- Ctrl + N => Open a new file
  		- Ctrl + O => Open a new file
  		- Ctrl + S => Save a file
  		- Ctrl + Shift + S => SaveAs a file
  		- Alt + F4 => Close the Notepad
  		- Alt + E => Edit Menu Click
  		- Ctrl + Z => Undo Option
  		- Ctrl + R => Redo Option
  		- Alt + O => Format Menu Click
  		- Alt + C => Color Menu Click
 * By Default Ctrl + X, Ctrl + C, Ctrl + V will work for Cut, Copy, Paste text , so no need to explicitly define them.
 * By default :
		- The window size is 800 x 600 px.
        - The font will be "Consolas".
        - The font size will be 16.
   		- The word wrap will be turned on. 
    	- Background Color will be "White" with Font Color as "Black".
 * Purpose of each class :
 		- "GUI" class => This is the main class (it contains main() method), it creates the GUI template and the structure and calls the corresponding methods in different classes as per different actions. 
 		- "FunctionFile" class => This class contains methods the performs actions of "File" menu's items.
 		- "FunctionFormat" class => This class contains methods the performs actions of "Format" menu's items.
 		- "FunctionColor" class => This class contains methods to change the background color and font color.
 		- "FunctionEdit" class => This class contains methods the performs actions of "Edit" menu's items.
 		- "KeyHandler" class => This is a class that contains Keyboard Event Handler to listen to keyboard shortcuts and call appropriate methods to perform the required action.
 */

/*
 * "GUI" class contains :
 		- Constructor.
 		- createWindow() method.
 		- createTextArea() method.
 		- createMenuBar() method.
 		- createFileMenu() method.
 		- createFormatMenu() method.
 		- createColorMenu() method.
 		- createEditMenu() method.
 		- actionPerformed() method => Listens to various events and calls the appropriate methods in different classes.
 		- main() method.
 */


import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.undo.UndoManager ;
import javax.swing.event.UndoableEditEvent ;
import javax.swing.event.UndoableEditListener ;


public class GUI implements ActionListener
{

	JFrame window ;
	
	// TextArea Components
	JTextArea textArea ;
	JScrollPane scrollPane ;
	
	// Top Menu Components
	JMenuBar menuBar ;
	JMenu menuFile, menuEdit, menuFormat, menuColor ;
	
	// File Menu Components
	JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit ;
	
	// Format Menu Components
	JMenuItem itemWrap, itemFontArial, itemFontCSMS, itemFontConsolas, itemFontTNR, itemFontSize8, itemFontSize12, itemFontSize16, itemFontSize20, itemFontSize24, itemFontSize28 ;
	JMenu menuFont, menuFontSize ;
	boolean wordWrapOn = false ;
	
	// Color Menu Components
	JMenuItem itemColorWhite, itemColorBlack, itemColorRed ;
	
	// Edit Menu Components
	JMenuItem itemUndo, itemRedo ;
	
	// Creating Objects for the classes to access them
	FunctionFile file = new FunctionFile(this) ;
	FunctionFormat format = new FunctionFormat(this) ;
	FunctionColor bgColor = new FunctionColor(this) ;
	FunctionEdit edit = new FunctionEdit(this) ;
	
	// Used to monitor undo & redo
	UndoManager um = new UndoManager() ; 
	// "UndoManager" class is present in javax.swing.undo
	
	// Additional Features (Shortcuts)
	KeyHandler kHandler = new KeyHandler(this) ;
	
	int titleChecking = 0 ;
		
	
	public GUI()
	{
		createWindow() ;
		createTextArea() ;
		createMenuBar() ;
		createFileMenu() ;
		createFormatMenu() ;
		createColorMenu() ;
		createEditMenu() ;
		
		format.selectedFont = "Consolas" ;
		format.createFont(16) ;
		format.wordWrap() ;
		
		bgColor.changeColor("White") ;
		
		/*
		 * By default :
		 	   - The window size is 800 x 600 px.
		       - The font will be "Consolas".
		       - The font size will be 16.
		       - The word wrap will be turned on. 
		       - Background Color will be "White" and the font color will be "Black".
		 */
		
		window.setVisible(true) ;		
	}
	
	public void createWindow()
	{
		window = new JFrame ("Notepad By Rishab") ;
		window.setSize(800, 600) ;
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
	}
	
	public void createTextArea()
	{
		textArea = new JTextArea() ;
		textArea.setFont(format.consolas) ;
		
		textArea.addKeyListener(kHandler) ;
		
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener()
					{
						public void undoableEditHappened(UndoableEditEvent e)
						{
							um.addEdit(e.getEdit()) ;
							
							if (titleChecking == 0)
							{
								window.setTitle('*' + window.getTitle()) ;
								titleChecking++ ;
							}
						}
					}
				) ;
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED) ;
		// ScrollPane will be activated only if it is needed.
		scrollPane.setBorder(BorderFactory.createEmptyBorder()) ;
		// Remove Border of the textArea
		
		window.add(scrollPane) ;
	}
	
	public void createMenuBar()
	{
		menuBar = new JMenuBar() ;
		window.setJMenuBar(menuBar) ;
	
		menuFile = new JMenu("File") ;
		menuBar.add(menuFile) ;
		
		menuEdit = new JMenu("Edit") ;
		menuBar.add(menuEdit) ;
		
		menuFormat = new JMenu("Format") ;
		menuBar.add(menuFormat) ;
		
		menuColor = new JMenu("Color") ;
		menuBar.add(menuColor) ;
	}
	
	public void createFileMenu()
	{
		itemNew = new JMenuItem("New") ;
		itemNew.addActionListener(this) ;
		itemNew.setActionCommand("New") ;
		menuFile.add(itemNew) ;
		
		itemOpen = new JMenuItem("Open") ;
		itemOpen.addActionListener(this) ;
		itemOpen.setActionCommand("Open") ;
		menuFile.add(itemOpen) ;
		
		itemSave = new JMenuItem("Save") ;
		itemSave.addActionListener(this) ;
		itemSave.setActionCommand("Save") ;
		menuFile.add(itemSave) ;
		
		itemSaveAs = new JMenuItem("SaveAs") ;
		itemSaveAs.addActionListener(this) ;
		itemSaveAs.setActionCommand("SaveAs") ;
		menuFile.add(itemSaveAs) ;
		
		itemExit = new JMenuItem("Exit") ;
		itemExit.addActionListener(this) ;
		itemExit.setActionCommand("Exit") ;
		menuFile.add(itemExit) ;
	}
	
	public void createFormatMenu()
	{
		itemWrap = new JMenuItem("Word Wrap : off") ;
		itemWrap.addActionListener(this) ;
		itemWrap.setActionCommand("WordWrap") ;
		menuFormat.add(itemWrap) ;
		
		menuFont = new JMenu("Font") ;
		menuFormat.add(menuFont) ;
		
		itemFontArial = new JMenuItem("Arial") ;
		itemFontArial.addActionListener(this) ;
		itemFontArial.setActionCommand("Arial") ;
		menuFont.add(itemFontArial) ;

		itemFontCSMS = new JMenuItem("Comic Sans MS") ;
		itemFontCSMS.addActionListener(this) ;
		itemFontCSMS.setActionCommand("Comic Sans MS") ;
		menuFont.add(itemFontCSMS) ;
		
		itemFontConsolas = new JMenuItem("Consolas") ;
		itemFontConsolas.addActionListener(this) ;
		itemFontConsolas.setActionCommand("Consolas") ;
		menuFont.add(itemFontConsolas) ;
		
		itemFontTNR = new JMenuItem("Times New Roman") ;
		itemFontTNR.addActionListener(this) ;
		itemFontTNR.setActionCommand("Times New Roman") ;
		menuFont.add(itemFontTNR) ;
		
		menuFontSize = new JMenu("Font Size") ;
		menuFormat.add(menuFontSize) ;
		
		itemFontSize8 = new JMenuItem("8") ;
		itemFontSize8.addActionListener(this) ;
		itemFontSize8.setActionCommand("size8") ;
		menuFontSize.add(itemFontSize8) ;
		
		itemFontSize12 = new JMenuItem("12") ;
		itemFontSize12.addActionListener(this) ;
		itemFontSize12.setActionCommand("size12") ;
		menuFontSize.add(itemFontSize12) ;
		
		itemFontSize16 = new JMenuItem("16") ;
		itemFontSize16.addActionListener(this) ;
		itemFontSize16.setActionCommand("size16") ;
		menuFontSize.add(itemFontSize16) ;
		
		itemFontSize20 = new JMenuItem("20") ;
		itemFontSize20.addActionListener(this) ;
		itemFontSize20.setActionCommand("size20") ;
		menuFontSize.add(itemFontSize20) ;
		
		itemFontSize24 = new JMenuItem("24") ;
		itemFontSize24.addActionListener(this) ;
		itemFontSize24.setActionCommand("size24") ;
		menuFontSize.add(itemFontSize24) ;
		
		itemFontSize28 = new JMenuItem("28") ;
		itemFontSize28.addActionListener(this) ;
		itemFontSize28.setActionCommand("size28") ;
		menuFontSize.add(itemFontSize28) ;

	}
	
	public void createColorMenu()
	{
		itemColorWhite = new JMenuItem("White") ;
		itemColorWhite.addActionListener(this) ;
		itemColorWhite.setActionCommand("White") ;
		menuColor.add(itemColorWhite) ;
		
		itemColorBlack = new JMenuItem("Black") ;
		itemColorBlack.addActionListener(this) ;
		itemColorBlack.setActionCommand("Black") ;
		menuColor.add(itemColorBlack) ;
		
		itemColorRed = new JMenuItem("Red") ;
		itemColorRed.addActionListener(this) ;
		itemColorRed.setActionCommand("Red") ;
		menuColor.add(itemColorRed) ;
	}
	
	public void createEditMenu()
	{
		itemUndo = new JMenuItem("Undo") ;
		itemUndo.addActionListener(this) ;
		itemUndo.setActionCommand("Undo") ;
		menuEdit.add(itemUndo) ;
		
		itemRedo = new JMenuItem("Redo") ;
		itemRedo.addActionListener(this) ;
		itemRedo.setActionCommand("Redo") ;
		menuEdit.add(itemRedo) ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand() ;
		
		switch(command)
		{
			case "New" :
				file.newFile() ;
				break ;
			case "Open" :
				file.open() ;
				break ;
			case "SaveAs" :
				file.saveAs() ;
				break ;
			case "Save" :
				file.save() ;
				break ;
			case "Exit" :
				file.exit() ;
				break ;
			case "WordWrap" :
				format.wordWrap() ;
				break ;
			case "Arial" :
				format.setFont(command) ;
				break ;
			case "Comic Sans MS" :
				format.setFont(command) ;
				break ;
			case "Consolas" :
				format.setFont(command) ;
				break ;
			case "Times New Roman" :
				format.setFont(command) ;
				break ;
			case "size8" :
				format.createFont(8) ;
				break ;
			case "size12" :
				format.createFont(12) ;
				break ;
			case "size16" :
				format.createFont(16) ;
				break ;
			case "size20" :
				format.createFont(20) ;
				break ;
			case "size24" :
				format.createFont(24) ;
				break ;
			case "size28" :
				format.createFont(28) ;
				break ;
			case "White" :
				bgColor.changeColor(command);
				break ;
			case "Black" :
				bgColor.changeColor(command) ;
				break ;
			case "Red" :
				bgColor.changeColor(command) ;
				break ;
			case "Undo" :
				edit.undo() ;
				break ;
			case "Redo" :
				edit.redo() ;
				break ;
		}
	}
	
	
	public static void main(String [] array) 
	{
		new GUI () ;
	}
	
}
