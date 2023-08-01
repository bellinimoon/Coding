package project4;

import java.util.Scanner;
import java.util.Stack;


public class ParsingBrackets2 {
	
	/** 
	 * The method that handles the input data and calls another method to 
	 * validates the use of brackets; 
	 * It generates two strings containing valid brackets for comparison;
	 * @param input string that contains the string with brackets that need verification.
	 */
	public static void handleInput(String input) {
		int index = 1;
		// valid brackets
		Stack<Character> leftBrackets = new Stack<Character>();
		Stack<Character> rightBrackets = new Stack<Character>();
		//leftBrackets.push("{");
		//leftBrackets.push("[");
		//leftBrackets.push("(");
		//rightBrackets.push("}");
		//rightBrackets.push("]");
		//rightBrackets.push(")");
		String validBrackets = "{[(";
		String validotherBrackets = "}])";
		int temp = input.length();
		System.out.println(VerifyBrackets(input, leftBrackets, rightBrackets, index, temp));
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
	public static String VerifyBrackets(String input, Stack<Character> lBrackets, Stack<Character> rBrackets, int index, int temp){
		// if we reached the end of the array
		System.out.println(rBrackets);
		if(index == temp) {

			//everything is marked
			if(rBrackets.size()==0) {
				return "YES";
			}else {
				//something hasn't been closed properly
				return "NO " + index;
			}
		}
		// a left bracket is detected
		if(input.charAt(0) == '{') {
			rBrackets.push('}');
			// record the corresponding right bracket
		}else if(input.charAt(0) == '(') {
			rBrackets.push(')');
		}else if(input.charAt(0) == '[') {
			rBrackets.push(']');
		}
		
		if(input.charAt(0) == '}') {
			if(rBrackets.pop() != '}') {
				return "NO " + index;
			}
			// record the corresponding right bracket
		}else if(input.charAt(0) == ')') {
			if(rBrackets.pop() != ')') {
				return "NO " + index;
			}
		}else if(input.charAt(0) == ']') {
			if(rBrackets.pop() != ']') {
				return "NO " + index;
			}
		}
		// a right bracket is detected
//		if(otherBrackets.indexOf(input.charAt(0)) != -1)
//			// if there's no corresponding left bracket or it's the wrong bracket
//			if(temp == "" || input.charAt(0) != temp.charAt(0)){
//				return "NO " + index;
//			}else {
//				//erase the bracket record in temp
//				temp = temp.substring(1);
//			}
		//move to the next digit
		index++;
		return VerifyBrackets(input.substring(1), lBrackets, rBrackets, index, temp);
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
