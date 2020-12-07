/**
 * The Question class is our model class. It stores the question, four possible answers, and correct answer. 
 * It has get and set functions, constructors, and functions that return strings that can be used conveniently in other parts of the program.
 * The Question class introduces a toString function to be used for the quiz.
 * The Question class also contains a toCorrectString function that will return the correct answers next to the questions
 * for when the user chooses to see the questions and answers.
 * @author Jonathan Rayo
 *
 */
public class Question {
	private String a,b,c,d;
	private String question;
	private String answer;
	
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Question(String question, String a, String b, String c, String d, String answer) {
		setQuestion(question);
		setA(a);
		setB(b);
		setC(c);
		setD(d);
		setAnswer(answer);
	}

	public Question() {
		question = getQuestion();
		a = getA();
		b = getB();
		c = getC();
		d = getD();
		answer = getAnswer();
	}
	@Override
	public String toString() {
		return String.format("%s\n a. %s\n b. %s\n c. %s\n d. %s", question,a,b,c,d);
	}
	public String toCorrectString() {
		return String.format("%s %s", getAnswer(), getQuestion());
	}


}
