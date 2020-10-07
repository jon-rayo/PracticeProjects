import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Baseball {

	/**
	 * This function will print the header welcoming the user to the program
	 * There is space to allow for a cleaner look.
	 */
	public static void printHeader() {
		System.out.println("************************************");
		System.out.println("*  Baseball Standings Analyzer  *");
		System.out.println("************************************");
		System.out.println(" ");
	}
	/**
	 * This function prints the list of choices for the user.
	 * @param sc what user enters.
	 * @return the users choice to decide what the user wants to do with the file.
	 * If the user enters a number or string that wasn't in the range it will ask them to try again.
	 */
	public static int printMenuAndGetChoice(Scanner sc) {
		System.out.println("Which standing would you like to see?");
		System.out.println("1. AL East");
		System.out.println("2. AL Central");
		System.out.println("3. AL West");
		System.out.println("4. NL East");
		System.out.println("5. NL Central");
		System.out.println("6. NL West");
		System.out.println("7. Overall");
		System.out.println("8. Exit");
		int choice = sc.nextInt();
		return choice;
	}
	
	/**
	 * Function will attempt to determine the teams that are not in the lead.
	 * Function will return the other teams standings in terms of how many games they're behind.
	 * @param teams
	 * @return
	 */
	
	public static double gamesBehind(ArrayList<String> teams ) {
		String [] parts;
		double	leadTeamWins;
		double leadTeamLoss;
		double otherTeamsWins;
		double otherTeamsLoss;
		double gamesBehind = 0;
		for (String team : teams) {
			parts = team.split("\t");
			leadTeamWins = (Integer.parseInt(parts[1]));
			leadTeamLoss =(Integer.parseInt(parts[2]));
			otherTeamsWins =(Integer.parseInt(parts[1]));
			otherTeamsLoss = (Integer.parseInt(parts[2]));
			double a = leadTeamWins - otherTeamsWins; 
			double b = otherTeamsLoss - leadTeamLoss;
			gamesBehind = a + b /2.0;
		}
		return gamesBehind;
	}

/**
 *Prints out the stats of each team in the league
 *It will print out the teams in a nice formatted table based on teams, wins, losses, percentage, and 'games behind'.
 * @param teams
 */
	public static void printStats(ArrayList<String> teams)  {
		String [] parts;
		double avg;
		double gamesBehind;
		System.out.println("Team	\tWins	Losses	Pct.\tBehind");
		System.out.println("-----------------------------------------------");
		for (String team : teams){
			parts = team.split("\t");
			avg = winningPercent(team);
			gamesBehind = gamesBehind(teams);
			System.out.printf("%-15s%-8s%-8s%-6.2f%6.2f \n",parts[0], parts[1], parts[2], avg, gamesBehind);
		}
	}
	/**
	 * This function will insert all the teams sorted based on winning percentages.
	 *
	 * This is if the user chooses the 7th option.
	 * @param all
	 * @param line
	 */
	public static void insertByWins(ArrayList<String> all, String line) {
		double leadTeam = winningPercent(line);
		double otherTeam;
		int pos = -1; 
		for (int i = 0; i < all.size(); i++) {
			otherTeam = winningPercent(all.get(i));	
			if (leadTeam > otherTeam) {
				pos = i;
				break;
			}
		}
		if (pos < 0) {
			all.add(line); 
		} else {
			all.add(pos,line);  
		}
	}
	
	
	/**
	 * This function finds the winning percentage of the teams in the leagues
	 * @param line Is where the parts splits to reach the int
	 * @return the winning percentage of the teams
	 * 
	 */
	public static double winningPercent(String line) {
		String[] parts = line.split("\t");
		double totalgames = (Integer.parseInt(parts[1])) + (Integer.parseInt(parts[2]));
		double avg = (Integer.parseInt(parts[1]))/ totalgames;
		return avg;
	}
	
		
			
		
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		printHeader();
		System.out.print("This program reads a file that contains\r\n" + 
				"current baseball standings and adds to\r\n" + 
				"more detailed statistics. It also prints\r\n" + 
				"overall standings in the American and \r\n" + 
				"national leagues.\r\n" + 
				"");
		System.out.println(" ");
		System.out.print("Enter the name of the standings file: ");
		String fname = sc.nextLine();
		ArrayList<String> aleast = new ArrayList<String>();
		ArrayList<String> alcentral = new ArrayList<String>();
		ArrayList<String> alwest = new ArrayList<String>();
		ArrayList<String> nleast = new ArrayList<String>();
		ArrayList<String> nlcentral = new ArrayList<String>();
		ArrayList<String> nlwest = new ArrayList<String>();
		ArrayList<String> target = null;
		ArrayList<String> allTeams = new ArrayList<String>();
		String line;
		String[] parts;
		String league;
		boolean fileworks;
		int choice;
		try {
			Scanner fsc = new Scanner(new File(fname));
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split("\t");
				if (parts[0].equalsIgnoreCase("LEAGUE")) {
					league = parts[1].toUpperCase();
					if (league.equalsIgnoreCase("AL EAST")) {
						target = aleast;
					} else if (league.equalsIgnoreCase("AL CENTRAL")) {
						target = alcentral;
					} else if (league.equalsIgnoreCase("AL WEST")) {
						target = alwest;
					} else if (league.equalsIgnoreCase("NL EAST")) {
						target = nleast;
					} else if (league.equalsIgnoreCase("NL CENTRAL")) {
						target = nlcentral;
					} else if (league.equalsIgnoreCase("NL WEST")) {
						target = nlwest;
					} 
				} else {
					target.add(line);
					insertByWins(allTeams,line);
				}
			}
			fsc.close();
			fileworks = true;
		} catch (Exception ex) {
			System.out.println("Couldn't read the file.");
			ex.printStackTrace();
			fileworks = false;
		}
		if (fileworks) {
			do {
				choice = printMenuAndGetChoice(sc);
				if (choice ==1) {
					printStats(aleast);
				} else if (choice ==2) {
					printStats(alcentral);
				} else if (choice ==3) {
					printStats(alwest);
				} else if (choice ==4) {
					printStats(nleast);
				} else if (choice ==5) {
					printStats(nlcentral);
				} else if (choice ==6) {
					printStats(nlwest);
				} else if(choice ==7) {
					System.out.println("Teams \t     Wins \tLoss");
					System.out.println("-----------------------------");
					for (String team : allTeams) {
						System.out.printf("%15s \n",team);
					}
				}
				
			}while(choice != 8);
		}
	}
}

