import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * This is our controller.
 * Takes the data from our Model (Article) and writes it to our view (JSON file)
 * on our hard drive
 * @author Jonathan Rayo
 *
 */
public class ArticleWriter {
	public boolean writeToJSON(String fname, ArrayList<Article> articles) {
		try {
			File f = new File(fname);
			/*
			 * JSON is written to text files.
			 * To write to a text file, you need a PrintWriter
			 * Create JSONArray
			 * Then, for each article, create a JSONObject for it and add it to the JSONArray
			 * After that, create the outer JSONObject. It will have just one value in it,
			 * the array of article objects you filled.
			 * Then write that one outer object to the PrintWriter.
			 */
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			JSONObject jobj;
			JSONArray arr = new JSONArray();
			for (Article art : articles) {
				jobj = new JSONObject();
				jobj.put("title",art.getTitle());
				jobj.put("author",art.getAuthor());
				jobj.put("text",art.getText());
				arr.add(jobj);
			}
//			{"articles":[{"title":"whatever","author":"whoever","text":"meh"},{ }]}
			JSONObject all = new JSONObject();
			all.put("articles",arr);
			pw.println(all.toJSONString());
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}

