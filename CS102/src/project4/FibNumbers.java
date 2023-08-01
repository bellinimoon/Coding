package project4;
import java.util.Scanner;

/**
 * <p>This class is the homework of the project 4 in csci102, spring 2023 
 * semester. 
 * 
 * <p>This class calculates Fibonacci number using recursion based on memorization. 
 * It takes a single integer input and compiles the Fibonacci number up to
 * the input integer in an array.
 * 
 * @author Annabeth Gao
 * @version 04/13/2023
 */
public class FibNumbers {
	
	/** 
	 * The wrapper method that constructs a array with the length of the input number. 
	 * Calls the other method to calculate the numbers into the array.
	 * @param N integer the nth fibonacci number we want to calculate
	 */
	public static void fib(int N) {
		//create an array to store the fib numbers;
		int[]fs = new int[N];
		fib(fs, N);
		//output
		System.out.print(fs[N-1] + "\n");
	}
	
	/** 
	 * The method that calculates up to the nth fib numbers
	 * @param N integer the nth fibonacci number we want to calculate
	 * @param fibSeq the array where we store the numbers 
	 * @return int the calculated fibonacci number
	 */
	public static int fib(int[]fibSeq, int N) {
		// base case to compile the first fib number which is 1.
		// base case when it goes beyond the digit
		if(N == 0 || N == 1) {
			fibSeq[0] = 1;
			return 1;
		}
		//base case to compile the second fib number which is 1 again;
		if(N == 2) {
			fibSeq[1] = 1;
			return 1;
		}		
		//if we don't have the number, enter the recursion
        if(fibSeq[N-1] == 0){
            fibSeq[N-1] = fib(fibSeq, N-1) + fib(fibSeq, N-2);
            return fibSeq[N-1];
        }else{
        	//when we have the number just use it;
            return fibSeq[N-1];
        }
	}
	
	/**
	 * Main method to read the input from the console using scanner. 
	 * @param args input of a single integer between [1,40]
	 */
	public static void main(String[] args) {
	    Scanner num = new Scanner(System.in);
	    //read the input
	    int i = num.nextInt();
	    fib(i);
	    num.close();
	}

}
