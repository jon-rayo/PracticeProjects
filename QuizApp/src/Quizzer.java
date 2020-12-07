import java.util.ArrayList;
import java.util.Random;
/**
 * The Quizzer class will serve two purposes. Randomize each question from the ArrayList to return one single question based on the size of the ArrayList.
 * That will be accomplished from the randomQuestion function.
 * The checkCorrect function takes in the boolean correcto and an int correct.
 * The paramters are if the question is correct then correct will set to true and 1 will be added to correct.
 * This will be used in the main application.
 * @author Jonathan Rayo
 *
 */
public class Quizzer {
	private Question question;
	private Random rnd;
	
	public int checkCorrect(boolean correcto, int correct) {
		if (correcto == true) {
			correct++;
		}
		return correct;
	}
		
	public Question randomQuestion(ArrayList<Question> questions) {
		rnd = new Random();
		question = questions.get(rnd.nextInt(questions.size()));
		System.out.println(question.toString());
    	return question;
	}
}
