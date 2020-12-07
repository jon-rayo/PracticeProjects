import java.util.ArrayList;
/**
 * The QuestionPrinter class prints the questions and the answers when the user selects the "see questions and answers" option.
 * A for loop is used to loop through each question with the toCorrectString function which displays the correct answer then the question.
 * printQuestions takes in an ArrayList of questions which is read from the readFromJSON function. 
 * @author Jonathan Rayo
 *
 */
public class QuestionPrinter {
	public void printQuestions(ArrayList<Question> questions) {
		for (Question question : questions) {
			System.out.println(question.toCorrectString());
		}
	}
}
