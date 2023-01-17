# Notepad Using Java

**i] This is a fully functional Notepad and also has Shortcuts like a regular notepad to use without mouse.**
<br>

**ii] This Notepad is developed using Eclipse IDE.**
<br> 

**iii] The ScrollPane will appear only if it is needed.**
<br>

**iv] ShortCuts :**

* Alt + F => File Menu Click
* Ctrl + N => Open a new file
* Ctrl + O => Open a new file
* Ctrl + S => Save a file
* Ctrl + Shift + S => SaveAs a file
* Alt + F4 => Close the Notepad
* Alt + E => Edit Menu Click
* Ctrl + Z => Undo Option
* Ctrl + R => Redo Option
* Alt + O => Format Menu Click
* Alt + C => Color Menu Click
<br>


**v] By Default Ctrl + X, Ctrl + C, Ctrl + V will work for Cut, Copy, Paste text, so no need to explicitly define them.**
<br>


**vi] By default :**

* The window size is 800 x 600 px.
* The font will be "Consolas".
* The font size will be 16.
* The word wrap will be turned on. 
* Background Color will be "White" with Font Color as "Black".
<br>


**vii] Purpose of each class :**

* "GUI" class => This is the main class (it contains main() method), it creates the GUI template and the structure and calls the corresponding methods in different classes as per different actions. 
* "FunctionFile" class => This class contains methods the performs actions of "File" menu's items.
* "FunctionFormat" class => This class contains methods the performs actions of "Format" menu's items.
* "FunctionColor" class => This class contains methods to change the background color and font color.
* "FunctionEdit" class => This class contains methods the performs actions of "Edit" menu's items.
* "KeyHandler" class => This is a class that contains Keyboard Event Handler to listen to keyboard shortcuts and call appropriate methods to perform the required action.

<br>

---

<br>

**"GUI" class contains :**

* Constructor.
* createWindow() method.
* createTextArea() method.
* createMenuBar() method.
* createFileMenu() method.
* createFormatMenu() method.
* createColorMenu() method.
* createEditMenu() method.
* actionPerformed() method => Listens to various events and calls the appropriate methods in different classes
* main() method.

<br>

---

<br>

**"FunctionFile" class contains :**

* Constructor.
* newFile() method => functionality of "New" MenuItem.
* open() method => functionality of "Open" MenuItem.
* save() method => functionality of "Save" MenuItem.
* saveAs() method => functionality of "SaveAs" MenuItem.
* exit() method => functionality of "Exit" MenuItem.

<br>

---

<br>

**"FunctionFormat" class contains :**

* Constructor.
* wordWrap() method.
* createFont() method.
* setFont() method. 

<br>

---

<br>

**"FunctionColor" class contains :**

* Constructor.
* changeColor() method.

<br>

**Three Background colors are available :**

* Background color "White" with Font color "Black".
* Background color "Black" with Font color "White".
* Background color "Red" with Font color "Orange".

<br>

---

<br>


**"FunctionEdit" class contains :**

* Constructor.
* undo() method.
* redo() method.

<br>

---

<br>

**"KeyHandler" class contains :**

* Constructor.
* keyTyped() method.
* keyPressed() method.
* keyReleased() method.

<br>

<u> **Note :** </u>
<br>

<p>
    <strong>
        &nbsp &nbsp &nbsp &nbsp keyTyped() and keyReleased() methods are empty because it is actually not needed but if we haven't defined them, then an error occurs and even the keyPressed() is not executed(keyPressed() method contains the actionListener for the shortcuts).
    </strong>    
</p>

---

<br>

<p style = "text-align : center ;"> 
    <strong>Thank You !!</strong> 
</p>

<br>

---