import javax.swing.JFrame;

/**
 * every class so far has had a public static void main
 * this is the runnable part of our application
 * most classes aren't meant to be run - they are meant to be used
 * such classes don't have public static void main
 * most of these classes have few or no static functions in them.
 * (aside - because main is static, any function you called from main had to be static.)
 * Most classes have no static functions.
 * This application will provide our first example of creating our own classes that
 * aren't meant to be run but be used.
 * @author Jonathan Rayo
 * 
 * The Class definition is the prototype - the instructions for building something.
 * The variables - the objects - are built according to the instructions.
 * 
 * Classes gives us the opportunity to reuse functionality across many application.
 * Classes also reduce redundancy
 *
 */
public class FunWithCustomClasses {

	public static void main(String[] args) {
		MyCustomFrame frm = new MyCustomFrame();
		frm.setVisible(true);
		MyCustomFrame frm2 = new MyCustomFrame("A Customized Frame", 200, 300, 700, 400, JFrame.HIDE_ON_CLOSE);
		frm2.setVisible(true);
	}

}
