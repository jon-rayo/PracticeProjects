import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * This is the QuestionReader class.\
 * 
 * This class reads in data from a JSON file that contains
 * the questions, choices, and answers.
 * After reading the data it returns an ArrayList of questions that can then be used in a variety of other classes.
 * @author Jonathan Rayo
 *
 */
public class QuestionReader {
	public ArrayList<Question> readFromJSON(String fname) {
		try {
			ArrayList<Question> questions = new ArrayList<Question>();
			FileReader reader = new FileReader(new File(fname));
			JSONParser parser = new JSONParser();
			JSONObject all = (JSONObject)parser.parse(reader);
			JSONArray arr = (JSONArray)all.get("questions");
			Iterator itr = arr.iterator();
			JSONObject questionObject;
			String a,b,c,d, question, answer;
			while (itr.hasNext()) {
				questionObject = (JSONObject)itr.next();
				question = questionObject.get("question").toString();
				a = questionObject.get("a").toString();
				b = questionObject.get("b").toString();
				c = questionObject.get("c").toString();
				d = questionObject.get("d").toString();
				answer = questionObject.get("answer").toString();
				questions.add(new Question(question,a,b,c,d,answer));
			}
			reader.close();
			return questions; // returned an ArrayList of questions so the file was read successfully.
		} catch (Exception ex) {
			return null; // null means we couldn't read the file.
		}
	}
}
