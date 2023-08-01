package project4;
import java.util.Scanner;
/**
 * <p>This class is the homework of the project 4 in csci102, spring 2023 
 * semester. 
 * 
 * <p>This class creates a method to representing each number using just 
 * a single digit. 
 * It takes a single line input and recursively add all the digits in the 
 * number until there's only one digit left. 
 * 
 * @author Annabeth Gao
 * @version 04/14/2023
 */

public class AllTheDigits {
	
	/** 
	 * The wrapper method that takes the string input and prints out 
	 * the calculated result
	 * @param num String representing the number we want to calculate
	 */
	public static void Brujec(String num) {
		//sum is zero before we start to add the digits
		int sum = 0;
		System.out.print(Brujec(num, sum) + "\n");
	}
	
	/** 
	 * The method that calculates the Brujec number by adding each digit
	 * recursively
	 * @param num the string represents the number with decimals we want to add together
	 * @param sum integer represents the sum of the digits
	 * @return brujec number after calculation
	 */
	public static int Brujec(String num, int sum) {
		//when we are at the end of the string
		if(num.length() == 0) {
			//single digit, then just return it
			if(sum < 10) {
				return sum;
			}else {
				//preparing to re-enter the recursion
				num = Integer.toString(sum);
				sum = 0;
			}
		}
		//add the first char in the string
		sum += Character.getNumericValue(num.charAt(0));
		// move on without the first letter
		return Brujec(num.substring(1), sum);
	}
	
	/**
	 * Main method to read the input from the console using scanner. 
	 * @param args input of a single integer 
	 */
	public static void main(String[] args) {
		//scanner takes input
	    Scanner num = new Scanner(System.in); 
	    //use string cuz int only takes up to 10 digit
	    String st = num.next();
	    Brujec(st);
	    num.close();
	}
}

