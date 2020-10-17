import java.awt.BorderLayout;
import java.awt.Container;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;
import java.awt.Color;

public class CovidPlotter {
	
	

	/**\
	 * This program stores the contents of the file in a LinkedHashMap for the countries and deaths.
	 * @param fsc the file it will read.
	 * @returns the name of the countries and total deaths 
	 */
	public static LinkedHashMap<String, double[]> readData(Scanner fsc) {
		LinkedHashMap<String, double[]> result = new LinkedHashMap<String, double[]>();
		fsc.hasNextLine(); // clears the first line
		String country; //name of the country.
		String line; // the line we will read.
		String[] parts; // stores the countries in an array.
		double[] deaths; // stores deaths in an array.
		while(fsc.hasNextLine()) {
			line = fsc.nextLine();
			parts = line.split("\t");
			country = parts[0];
			deaths = new double[parts.length-1];
			for (int i= 1; i < parts.length; i++ ) { // get total deaths in deaths.
				deaths[i-1] = Double.parseDouble(parts[i]);				
			}
			result.put(country,deaths);
		}
		return result; // returns all countries deaths.
	}
	
	/**
	 * This function will print out a banner to greet the user.
	 */
	public static void printBanner() {
		System.out.println("***********************************************************");
		System.out.println("* \t INTERNATIONAL COVID-19 MORTALITY RATES \t *");
		System.out.println("***********************************************************");
		System.out.println(" ");
	}
	
	/**
	 *This function will get the cumulative data of all the deaths in the countries
	 * @param total the number of deaths
	 * @return the deaths
	 */
	public static double[] getCumulative(int total) {
		double[] result = new double[total]; // setting the total into an array.
		for (int i = 0; i<total; i++) {
			result[i] = i;
		}
		return result; // returns cumulative total of deaths for the given day.
	}
				
	/**
	 * This function will show the graph for the cumulative deaths by day.
	 * @param plot
	 */
	public static void showPlotForCumulative(Plot2DPanel plot) {
		plot.addLegend("SOUTH"); // where to put the legend
		plot.setAxisLabels("Day","Deaths"); //x and y axis
		BaseLabel title = new BaseLabel("Cumulative Deaths",Color.RED,0.5,1.1); // set our title
		plot.addPlotable(title); // make our title come alive 
		//creating the frame.
		JFrame frm = new JFrame();
		frm.setTitle("Cumulative Deaths"); // set the window title
		frm.setBounds(100,100,500,500); // set the window bounds
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // get rid of memory
		Container c = frm.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(plot,BorderLayout.CENTER);
		frm.setVisible(true);
	}
	/**
	 * This function will plot the data for the daily deaths.
	 * @param plot
	 */
	public static void showPlotForDaily(Plot2DPanel plot) {
		plot.addLegend("SOUTH");
		plot.setAxisLabels("Day","Deaths");
		BaseLabel title = new BaseLabel("Daily Deaths",Color.RED,0.5,1.1);
		plot.addPlotable(title);
		//creating the frame.
		JFrame frm = new JFrame();
		frm.setTitle("Daily Deaths");
		frm.setBounds(100,100,500,500);
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // get rid of memory
		Container c = frm.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(plot,BorderLayout.CENTER);
		frm.setVisible(true);
	}
	
	public static void main(String[] args) {
		printBanner();
		LinkedHashMap<String, double[]> data;
		String enteredCountries;
		String[] countries;
		Scanner sc = new Scanner(System.in);
		double[] deaths;
		String choice;
		try {
			System.out.print("Enter the name of the covid file: ");
			String fname = sc.nextLine(); //stores the name of the file into fname.
			Scanner fsc = new Scanner(new File(fname));
			data = readData(fsc); //reads contents of the file.
		} catch(Exception ex) {
			data = null; //Couldn't read data
			ex.printStackTrace();
		}
		if (data == null) {
			System.out.println("Couldn't read the file. ");
		}
		else {
			//Repeatedly ask the user which countries they want to see
			//Ask them if they want to see the daily deaths or cumulative deaths.
			do {
				System.out.print("Enter countries seperated by commas to plot: (or quit to end) ");
				enteredCountries = sc.nextLine();
				if (!enteredCountries.equalsIgnoreCase("quit")) {
					System.out.printf("[D]aily or [C]umulative? ");
					choice = sc.nextLine();
					Plot2DPanel plot = new Plot2DPanel();
					countries = enteredCountries.split(",");
					for (String country : countries) { 
						country = country.trim(); //removes leading space.
						if (!data.containsKey(country)) {
							System.out.printf("%s is not in the data set.\n", country);
						}
						else {
							if (choice.equalsIgnoreCase("c")) {
								deaths = data.get(country);
								plot.addLinePlot(country,getCumulative(deaths.length), deaths);
								showPlotForCumulative(plot);
							}
							else if(choice.equalsIgnoreCase("d")) {
								deaths = data.get(country);
								int noOfDeaths = deaths.length;
								double[] difference = new double[noOfDeaths];
								for(int i = 0; i < noOfDeaths-1; i++) {
									difference[i+1] = deaths[i+1] - deaths[i]; // current day of deaths = current day total - previous day total.
								}
								plot.addLinePlot(country,difference);
								showPlotForDaily(plot);
							}
						} 
					}
				}
			} while (!enteredCountries.equalsIgnoreCase("quit"));
			System.out.println("Please wear a mask. Thank you");
		} 
	}
	
}



