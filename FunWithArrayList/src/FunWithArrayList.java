import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class FunWithArrayList {
	public static void printNames(ArrayList<String> names) {
		/*for (int i = 0; 1< names.size(); i++) {
			System.out.println(names.get(i));
		}
		*/
		for (String name: names) {
			System.out.println(name);
		}
	}

	public static void main(String [] args) {
		ArrayList<String> names = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		names.add("Me");
		names.add("cat");
		names.add("isy");
		names.add("nela");
		names.add("cena");
		System.out.println("Which slot do you want me to import: ");
		int pos = sc.nextInt();
		String target = names.get(pos);
		System.out.println("That name is " +target);
		System.out.println("Here is the list of names: ");
		printNames(names);
		System.out.print("Enter a new name to add & where: ");
		String newName = sc.next();
		pos = sc.nextInt();
		names.add(pos,newName);
		System.out.println("Here is the list of names sorted");
		Collections.sort(names);
		printNames(names);
		System.out.println("Now removing me: ");
		names.remove("Me");
		printNames(names);
		System.out.println("Now will remove the item at location 1: ");
		names.remove(1);
		printNames(names);
	}
						
}
