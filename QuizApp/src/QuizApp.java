import java.util.ArrayList;
import java.util.Scanner;
/**
 * This the Object-Oriented programming quiz application.
 * This program asks the user whether they want to take a quiz or see questions and answers.
 * This program relies on multiple controller classes including: QuestionReader,QuestionPrinter, and Quizzer.
 * @author Jonathan Rayo
 *
 */
public class QuizApp {
	/*
	 * Greets the user with a list of choices in formatted menu. 
	 */
	public static void printMenu() {
		System.out.println("Here are your choices:");
		System.out.println("1. Take a quiz.");
		System.out.println("2. See Questions and answers.");
		System.out.println("3. Exit");
		System.out.print("Enter your choice: ");
	}
	/*
	 * Greets the user when they first run the program.
	 */
	public static void  printHeader() {
		System.out.println("*********************************************************************************");
		System.out.println("    *                   OOP Theory and Concept Questions                   *");
		System.out.println("*********************************************************************************");
	}
	/*
	 * Ends the program with a quick thanks to Dr. Klump.
	 */
	public static void printFooter() {
		System.out.println("*********************************************************************************");
		System.out.println("  *                   Thank you for teaching me CPSC 24500                   *");
		System.out.println("*********************************************************************************");
		
	}
	/*
	 * Main Function
	 */
	public static void main(String[] args) {
		Quizzer q = new Quizzer();
		Question question = new Question();
		QuestionPrinter qp = new QuestionPrinter();
		QuestionReader qr = new QuestionReader();
		int problem_count;
		int choice;
		int correct;
		boolean correcto;
		String answer;
		ArrayList<Question> questions = new ArrayList<Question>();
		Scanner sc = new Scanner(System.in);
		//Start of the main program
		printHeader();
		System.out.print("Enter the name of the file containing questions: ");
		String fname = sc.nextLine();
		questions = qr.readFromJSON(fname);
		if (questions == null) {
			System.out.println("Unable to read the file.");
		}else {
			System.out.println("");
			do {
				printMenu();
				try {
					choice = sc.nextInt();
					if (choice <= 0 || choice > 3) {
						System.out.println("That is an invalid choice.");
					}
				} catch (Exception ex) {
					System.out.println("You needed to enter a 1, 2, or 3");
					sc.nextLine(); // clears the input channel
					choice = 0;
				}
				if (choice == 1) { // take quiz
					correct = 0;
					System.out.println("");
					System.out.print("How many questions would you like? ");
					try { 
						problem_count = sc.nextInt();
						if (problem_count <=0 || problem_count > questions.size()) {
							System.out.println("That is an invalid choice.");
							sc.nextLine();
							problem_count = 0;
						}
					} catch (Exception ex) {
						System.out.println("You needed to enter an int.");
						sc.nextLine(); // clears the input channel
						problem_count = 0;
					}
					System.out.println("");
					for (int i = 0; i <problem_count; i ++) {
						question = q.randomQuestion(questions);
						System.out.print("Type the letter of your choice: ");
						answer = sc.next();
						if (answer.equals(question.getAnswer())) {
							correcto = true;
							System.out.println("Correct!\n");
						} else {
							correcto = false;
							System.out.printf("Sorry. The correct answer is %s.\n", question.getAnswer());
							System.out.println("");
						}
						correct = q.checkCorrect(correcto, correct);
					}
					System.out.printf("You answered %d out of %d correctly\n", correct, problem_count);
				}
				else if  (choice == 2) { // show the questions and answers
					System.out.println("Here are the answers.");
					System.out.println("");
					qp.printQuestions(questions);
				}
				System.out.println("");
			} while (choice != 3);
			sc.close();
			System.out.println("");
			printFooter();
		}
	}

}
