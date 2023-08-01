package project4;
import java.util.Scanner;

/**
 * <p>This class is the homework of the project 4 in csci102, spring 2023 
 * semester. 
 * 
 * <p>This class parses and validates the use of brackets in code programs.
 * Valid bracket pairs are (), [], and {}, and the input String could be any sequence of 
 * characters in any length
 * 
 * @author Annabeth Gao
 * @version 04/14/2023
 */
public class ParsingBrackets {
	
	/** 
	 * The method that handles the input data and calls another method to 
	 * validates the use of brackets; 
	 * It generates two strings containing valid brackets for comparison;
	 * @param input string that contains the string with brackets that need verification.
	 */
	public static void handleInput(String input) {
		int index = 1;
		// valid brackets
		String validBrackets = "{[(";
		String validotherBrackets = "}])";
		String temp = "";
		System.out.println(VerifyBrackets(input, validBrackets, validotherBrackets, index, temp));
	}
	
	/** 
	 * The method that validates the use of brackets. 
	 * It mimics a stack structure(which i should probably use. 	 
	 * It compares the input right brackets with the brackets in record.
	 * @param input string contains the brackets to be compared
	 * @param brackets string containing valid left brackets
	 * @param otherBrackets string containing valid right brackets
	 * @param index int recording the current index and report it when needed
	 * @param temp string that temporarily keeps track of the right brackets that need to be closed
	 * @return string denoting the validity of the brackets in the string
	 */
	public static String VerifyBrackets(String input, String brackets, String otherBrackets, int index, String temp){
		// if we reached the end of the array
		if(input.length() == 0) {
			//everything is marked
			if(temp == "") {
				return "YES";
			}else {
				//something hasn't been closed properly
				return "NO " + index;
			}
		}
		// a left bracket is detected
		if(brackets.indexOf(input.charAt(0)) != -1) {
			// record the corresponding right bracket
			temp = otherBrackets.charAt(brackets.indexOf(input.charAt(0))) + temp;
		}
		// a right bracket is detected
		if(otherBrackets.indexOf(input.charAt(0)) != -1)
			// if there's no corresponding left bracket or it's the wrong bracket
			if(temp == "" || input.charAt(0) != temp.charAt(0)){
				return "NO " + index;
			}else {
				//erase the bracket record in temp
				temp = temp.substring(1);
			}
		//move to the next digit
		index++;
		return VerifyBrackets(input.substring(1), brackets, otherBrackets, index, temp);
	}
	
	/**
	 * Main method to read the input from the console using scanner. 
	 * @param args input of a string
	 */
	public static void main(String[] args) {
		//scanner takes input
	    Scanner in = new Scanner(System.in); 
	    //use nextLine() to avoid skipping because of blank space
	    String input = in.nextLine();
	    handleInput(input);
	    in.close();
	}
}
