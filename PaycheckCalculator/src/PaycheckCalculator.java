/**
 *This program calculates the paycheck for an hourly 
 * @author Jonathan Rayo
 *
 *
 */
import java.util.Scanner;
public class PaycheckCalculator {
	public static double calculateGrossPay(double rate, double hours) {
		double result = rate * hours;
		return result;
	}
	public static void main(String[] args) {
		double payRate
		double hoursWorked;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter pay rate: ");
		
		double gross = calculateGrossPay(payRate, hoursWorked);
		gross =Math.ceil(gross);
		System.out.printf("You worked %.2f hours at a rate of $%.2f.\n", hoursWorked, payRate);
		System.out.printf("Pay is $%.2f", gross);
	}

}
