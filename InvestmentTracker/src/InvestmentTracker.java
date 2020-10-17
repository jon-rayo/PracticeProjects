import java.awt.BorderLayout;
import java.awt.Container;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;

public class InvestmentTracker {
	
	public static LinkedHashMap<String, double[]> readData(Scanner fsc) {
		LinkedHashMap<String, double[]> result = new LinkedHashMap<String, double[]>();
		fsc.hasNextLine(); //gets rid of first line
		String name; // name of person
		String line; // line we read
		String[] parts;
		double[] values;
		while(fsc.hasNextLine()) {
			line=fsc.nextLine();
			parts = line.split("\t");
			name = parts[0];
			values = new double[parts.length-1];
			//fill the values with investment totals
			for (int i = 1; i< parts.length; i++) {
				values[i-1] = Double.parseDouble(parts[i]);
			}
			//now I have the name and investment values.
			//put them in the result map
			result.put(name,values);
		}
		//all the accounts info will now be returned
		return result;
	}
	


	public static double[] getDays(int howMany) {
		double[] result=new double[howMany];
		for (int i = 0; i<howMany; i++) {
			result[i] = i;
		}
		return result;
	}
	
	public static void setUpAndShowPlot(Plot2DPanel plot) {
		JFrame frm = new JFrame();
		frm.setBounds(100,100,500,500);
		frm.setTitle("Investment Curves");
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // get rid of memory
		Container c = frm.getContentPane();
		c.setLayout(new BorderLayout());
		plot.addLegend("SOUTH");
		plot.setAxisLabels("Day","Value");
		c.add(plot,BorderLayout.CENTER);
		frm.setVisible(true);
		
	}

	public static void main(String[] args) {
		LinkedHashMap<String, double[]> accounts;
		String inputtedNames;
		String[] names;
		Scanner sc = new Scanner(System.in);
		double[] investmentValues;
		try {
			Scanner fsc = new Scanner(new File("investments.txt"));
			accounts = readData(fsc);
		} catch(Exception ex) {
			accounts = null; //I wasn't able to read data
		}
		if (accounts ==  null) {
			System.out.println("Couldn't read the file.");
		} else {
			//Repeatedly ask for the user names of people
			//who they wanna see.
			do {
				System.out.print("Enter the name of ppl seperated by commas: " );
				inputtedNames = sc.nextLine();
				if (!inputtedNames.equalsIgnoreCase("exit")) {
					Plot2DPanel plot = new Plot2DPanel();
					// try to plot the data.
					names = inputtedNames.split(",");
					for (String name : names) {
						name = name.trim(); // remove any leading space
						if (!accounts.containsKey(name)) {
							System.out.printf("%s is not in the data.\n", name);
						} else {
							investmentValues = accounts.get(name);
							plot.addLinePlot(name, getDays(investmentValues.length), investmentValues);
						}
					}
					setUpAndShowPlot(plot);
				}
			} while (!inputtedNames.equalsIgnoreCase("exit"));
		}System.out.println("Thanks for using this program.");
	}

}
