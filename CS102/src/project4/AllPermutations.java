package project4;

import java.util.Scanner;

/**
 * <p>
 * This class is the homework of the project 4 in csci102, spring 2023 semester.
 * 
 * <p>
 * This class generates all binary sequences with lengths up to N. It takes a
 * single integer input and generates the sequences based on recursion. It uses
 * StringBuilder as to increase processing speed.
 * 
 * @author Annabeth Gao
 * @version 04/13/2023
 */
public class AllPermutations {

	/**
	 * The wrapper method that calls another method to generate the sequence which
	 * is stored in the stringBuilder Prints the StringBuilder.
	 * 
	 * @param N  integer the digit limit of the sequence
	 * @param sb StringBuilder an empty StringBuilder to store the string
	 */
	public static void Permutations(StringBuilder sb, int N) {
		// call the method
		Permutations(sb, "", N);
		// print the StringBuilder
		System.out.println(sb);
	}

	/**
	 * The method that generate the sequence to to the Nth digit
	 * 
	 * @param N   the integer shows the digit limit of the sequence
	 * @param sb  empty StringBuilder to store the string
	 * @param str a String that stores previous digit before generating the final
	 *            result
	 */
	public static void Permutations(StringBuilder sb, String str, int N) {
		if (str.length() == N) {
			// return when the length equals the input N
			return;
		}
		// add additional digit
		String s1 = str + "0";
		// append the result to the StringBuilder
		// use a blank space to separate different numbers
		sb.append(" " + s1);
		Permutations(sb, s1, N);
		// add 1 instead of 0
		String s2 = str + "1";
		// append the result to the StringBuilder
		sb.append(" " + s2);
		Permutations(sb, s2, N);
	}

	/**
	 * Main method to read the input from the console using scanner
	 * 
	 * @param args input of a single integer between [0,30)
	 */
	public static void main(String[] args) {
		// scanner takes input
		Scanner num = new Scanner(System.in);
		int i = num.nextInt();
		// create an empty StringBuilder
		StringBuilder sb = new StringBuilder();
		Permutations(sb, i);
		num.close();
	}

}
