package project4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>This class is the homework of the project 4 in csci102, spring 2023 
 * semester. 
 * 
 * <p>This class creates a simple number game. 
 * It selects two numbers from the given pool whose sum is equal to the 
 * target value. If there are more than one such pairs, the program 
 * prints a pair for which the absolute value is the smallest.
 * The class takes three lines of input. The first line is a count of 
 * numbers in the pool, 0 <= N <= 10, 000;
 * the second line contains white space separated pool of N number, 
 * each value is a positive number less than or equal to 1, 000, 000;
 * the third line contains the target value.
 * 
 * 
 * @author Annabeth Gao
 * @version 04/14/2023
 */
public class WelcomeToNYU {
	
	/** 
	 * The method that handles the input data and calls another method to 
	 * select two numbers from the given pool whose sum is equal to the 
	 * target value. 
	 * It changes the input string to an integer string and sort the array
	 * @param count integer the count of elements from the input
	 * @param num integer contains white space separated pool of N number
	 * @param target integer the targeted sum
	 */
	public static void Handle(String count, String num, String target) {
		//split the string by blanks into a string array 
		String[] nums = num.split(" ");
		//create a new integer array
		int[] numsInt = new int[nums.length];
		//transfer the strings into integers and put them into the new array
		for(int i = 0; i < nums.length; i++) {
			numsInt[i] = Integer.parseInt(nums[i]);
		}
		// sort the array
		Arrays.sort(numsInt);
		int targetNum = Integer.parseInt(target);
		//two censors pointing to the front and the back of the array
		int countNum = Integer.parseInt(count)-1;
		int start = 0;
		//numbers reserved to be the return value
		int num1 = 0;
		int num2 = nums.length-1;
		System.out.println(GamePrediction(countNum, numsInt, targetNum, start, num1, num2));
	}
	
	/** 
	 * The method that select two numbers from the given pool whose sum is equal to the 
	 * target value. 
	 * It keeps track of two censors that screens the sorted integer array from both ends
	 * @param count int the censor pointing to the end of the array
	 * @param nums integer array representing the pool of numbers
	 * @param target integer the targeted sum
	 * @param start int the censor pointing to the start of the array
	 * @param num1 int the first number returned
	 * @param num2 int the second number returned
	 * @return String containing the two numbers sums up to be the target
	 */
	public static String GamePrediction(int count, int[] nums, int target, int start, int num1, int num2){
		if(count - start <= 0) {
			String result = num1 + " " + num2;
			return result;
		}
		if (nums[start] + nums[count] > target){
			count --;
		}else if(nums[start] + nums[count] < target) {
			start ++;
		}else {
			num1 = nums[start];
			num2 = nums[count];
			count --;
			start ++;
		}
		return GamePrediction(count, nums, target, start, num1, num2);
		
	}

	/**
	 * Main method to read the input from the console using scanner. 
	 * @param args input of strings on three different lines  
	 */
	public static void main(String[] args) {
		//scanner takes input
	    Scanner in = new Scanner(System.in); 
	    //after retrieving the string move on to the next line
	    String count = in.nextLine();
	    String num = in.nextLine();
	    String target = in.nextLine();
	    Handle(count, num, target);
	    in.close();
	}

}
