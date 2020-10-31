import javax.swing.JFrame;

/**
 * My CustomFRame "is a" JFrame. THat's what "extends" literally means.
 * Can occupy screen real estate.
 * Has all JFrame introduces.
 * Can have it's own attributes.
 * @author Jonathan Rayo
 *
 */

public class MyCustomFrame extends JFrame {
	/* to customize one class so that it differs from its ancestor,
	 * we use constructors. Constructors are functions that don't have
	 * a return type and have the same name as the name of the class.
	 * they set aside enough memory, and they initalize the data
	 * that needs to be initialized to create an object.
	 * example: we are an object of the Human class.
	 * Also, eyeColor and hairColor - those are data members
	 * the constructor that was used to build you.
	 * for JFrames, need to set a title, left, top, width, default
	 */
	/*
	 * there are two types of constructors: default and non-default.
	 * default constructors take in no params and set the data to default values
	 * non-default constructors take in params and use them to set the data members' values
	 * you can have two functions with the same name - function overloading
	 * this is allowed if the two functions differ in the order, type, and/or number of their
	 * parameters (name-mangling)
	 */
	public MyCustomFrame() {
		this("Default Frame", 100,100,500,500, JFrame.EXIT_ON_CLOSE); //delegation passes responsibility to another function.
		
	}
	
	public MyCustomFrame(String title, int left, int top, int width, int height, int closeOp) {
		setTitle(title);
		setBounds(left,top,width,height);
		setDefaultCloseOperation(closeOp);
	}
	
	public void setLook(String title, int left, int top, int width, int height) {
		setTitle(title);
		setBounds(left, top, width, height);
	}
}
