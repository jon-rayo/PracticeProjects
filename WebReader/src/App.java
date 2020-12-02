import java.net.URL;
import java.util.Scanner;

/**
 * This program foes to the department webpage and grabs the data 
 * that is there - all the html code that makes that page look the 
 * way it does.
 * @author Jonathan Rayo
 *
 */
public class App {
	public static void main(String [] args) {
		try {
			URL link = new URL("https://www.cs.lewisu.edu");
			Scanner fsc = new Scanner(link.openStream());
					while(fsc.hasNextLine()) {
						System.out.println(fsc.nextLine());
					}
		} catch (Exception ex) {
			System.out.println("Couldn't connect to website.");
		}
		
	}
}
