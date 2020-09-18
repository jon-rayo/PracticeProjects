import java.util.Random;

public class RandomSumAndProduct {
	
	/** 
	 This function simply presents a banner that welcomes the user.
	 
	 */
	
	public static void welcomeUser() {
		System.out.println("********");
		System.out.println("      Randomness v1.0");
		System.out.println("**********");
	}
	/**
	 This function computes the sum of 3 integers
	 @param a The first of the three nums to be added
	 @param b the second of the three numbers to be added
	 @param c the last num to be added
	 @return the sum of a,b,c
	 */
	public static int computSum(int a, int b, int c) {
		int total = a + b + c;
		return total;
	}
	/**
	 This function computes the sum of 3 integers
	 @param a The first of the three nums to be mult
	 @param b the second of the three numbers to be mult
	 @param c the last num to be mult
	 @return the product of a, b, c
	 */
	public static int computProduct(int a, int b, int c) {
		int product = a*b*c;
		return product;
	}
	public static void main(String[] args) {
		welcomeUser();
		Random rnd = new Random();
		int x1, x2, x3;
		x1 = rnd.nextInt(25);
		x2 = rnd.nextInt(25);
		x3 = rnd.nextInt(25);
		int sum = computSum(x1,x2,x3);
		int prod = computProduct(x1,x2,x3);
		System.out.printf("The sum of %d, %d and %d is %d.\n", x1, x2, x3, sum);
		System.out.println("The product is "+ prod + ".");
	}
}
