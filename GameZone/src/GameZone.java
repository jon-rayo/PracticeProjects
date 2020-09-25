import java.util.Scanner;
import java.util.Random;
/**
 * This is the Game Zone!. Where you have a choice to play either 21 or Rock Paper Scissors. Enjoy!
 * @author Jonathan Rayo
 *
 */
public class GameZone {
	static Scanner sc = new Scanner(System.in);
	static Random rnd = new Random();
	
	/**
	 * This function welcomes the user to the game zone.
	 * Also, includes an empty space to make menu look cleaner.
	 */
	public static void printBanner() {
		System.out.println("*********************************");
		System.out.println("   Welcome to the Game Zone!   ");
		System.out.println("*********************************");
		System.out.println(" ");
	}
	
	/**
	 * This function presents the user with the menu of options of the games they can play.
	 * They also have the option to quit out the program.
	 */
	public static void printMenu() {
		System.out.println("What would you like to play?");
		System.out.println("1. Twenty-one");
		System.out.println("2. Rock Paper Scissors");
		System.out.println("3. Neither - I'm done!");
	}
	
	/**
	 * This function take the game of 21.
	 * If the user gets more points than the computer then the user wins.
	 * If the computer gets more points than the user then the computer wins.
	 * This function has a do while loop and asks the user if they want to draw another card to get more points.
	 * If the user gets more points than 21, they lose the game. 
	 * @player is set to random from numbers 1 through 11.
	 * @dealer is set to random from 13 through 20.
	 * @total starts at 0 and every time the player draws a card it gets added it to the total.
	 * @param choice what the user chose.
	 */
	public static void twentyOne(int choice) {
		int player;
		int dealer = 13 + rnd.nextInt(20-13);
		int total = 0; 
		String doAgain;
		do {
			player = 1+rnd.nextInt(11);
			total = total +player;
			System.out.printf("You drew a " + player + ". \n");
			System.out.printf("Your current total is " + total  + ". \n" );
			if (total >= 21) {
				break;
			}
			System.out.println("Do you want another card? ");
			doAgain = sc.next();
		} while (doAgain.equalsIgnoreCase("y"));
		System.out.println(" ");
		if (total > 21) {
			System.out.println("You drew more than 21. You lost.");
		}
		else if (total == 21) {
			System.out.println("Your drew exactly 21. You win!");
		}
		else if (total > dealer) {
			System.out.printf("The computer drew " + dealer +"\n");
			System.out.println("You won!");
		}
		else if (total<dealer) {
			System.out.printf("The computer drew " + dealer +"\n");
			System.out.println("You lost.");
		}
		else if(total == dealer) {
			System.out.printf("You both drew " + total +"\n");
			System.out.println("It's a tie.");
		}
	}
		
	/** This is the way the rock paper scissors game would work.
	 * We are just using if, else if statements.
	 * @rock has been set to 0.
	 * @paper has been set to 1.
	 * @scissors has been set to 2.
	 * @param what the user chose.
	 * These parameters have been set to the values because the variables player and computer are set to random with max of 3 ints.
	 * In java, 0 is the first position so rock must be 0 rather than 1.
	 * 
	 */
	public static void rockPaperScissors(int choice) {
		int rock = 0;
		int paper = 1;
		int scissors= 2;
		int comp = rnd.nextInt(3);
		int player = rnd.nextInt(3);
		if (comp == rock && player == comp) {
			System.out.println("You and the computer picked rock. It is a tie.");
		}
		else if (comp == paper && player == comp) {
			System.out.println("You and the computer picked paper. It is a tie.");
		}
		else if (comp == scissors && player == comp) {
			System.out.println("You and the computer picked scissors. It is a tie.");

		}
		else if (comp == rock && player == paper) {
			System.out.println("The computer picked rock. You picked paper. You win!");
		}
		else if (comp == paper && player == scissors) {
			System.out.println("The computer picked paper. You picked scissors. You win.");
		}
		else if (comp == scissors && player == rock) {
			System.out.println("The computer picked scissors. You picked rock. You win.");
		}
		else if (player == rock && comp == paper) {
			System.out.println("The computer picked paper. You picked rock. You lost.");
		}
		else if (player == paper && comp == scissors) {
			System.out.println("The computer picked scissors. You picked paper. You lost.");
		}
		else if (player == scissors && comp == rock) {
			System.out.println("The computer picked rock. You picked scissors. You lost.");
		}
	}
	
	public static void main(String [] args) { // Start of the main code
			printBanner(); // Welcomes the user to the game.
			int choice; 
			System.out.println(" ");
			do {
				printMenu(); // Will print the choices out to the user.
				try { // Take the user choice and checks if it is correct
					choice = sc.nextInt();
					if (choice <= 0 || choice >3) {
						System.out.println("That is an invalid choice.");
					}
				} catch (Exception ex) {
					System.out.println("You needed to enter a 1, 2, or 3. ");
					sc.nextLine(); // clears the input channel.
					choice = 0;
				}
				System.out.println(" ");
				if (choice == 1) {
					System.out.println(" ");
					twentyOne(choice);
					System.out.println(" ");
				}
				else if (choice == 2) {
				System.out.println(" ");
				rockPaperScissors(choice);
				System.out.println(" ");
			} 
		} while (choice != 3);
		System.out.println("Thank you for playing");
	}
}
