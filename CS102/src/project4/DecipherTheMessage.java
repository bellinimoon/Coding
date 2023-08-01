package project4;
import java.util.Scanner;

/**
 * <p>This class is the homework of the project 4 in csci102, spring 2023 
 * semester. 
 * 
 * <p>This class constructs a decipher method includes reverse and delete
 * It accepts a key and a string containing the message to be deciphered
 * The message is modified regarding the key and finally deciphered.
 * 
 * 
 * @author Annabeth Gao
 * @version 04/14/2023
 */
public class DecipherTheMessage {
	
	/** 
	 * The wrapper method that prints out the deciphered message
	 * based on the output from the Decipher class
	 * @param String key contains the key decipher the message
	 * @param String message to be deciphered
	 */	
	public static void Handle(String key, String message) {
		System.out.println(Decipher(key, message));
	}
	
	/** 
	 * The method that handles the a message with a key. The key consists of two 
	 * letters, D and R, meaning delete and reverse respectively
	 * @param String key contains the key decipher the message
	 * @param String message to be deciphered
	 * @return string the message after being deciphered
	 */
	public static String Decipher(String key, String message) {
		//key ends, print the message
		if(key.length() == 0) {
			return message;
		}
		//if the key is D
		if (key.charAt(0) == 'D') {
			try{
				//keeps the substring(remove the first char)
				message = message.substring(1);
			}catch (Exception e) {
				// catch the error when the message is an empty string
				return "error";
			}
		}else if(key.charAt(0) == 'R') {
			//reverse the string with the help of the string builder
			message = new StringBuilder(message).reverse().toString();
		}else {
			//if the key reads something else, there's an error
			return "error";
		}
		//recall the remaining keys
		return Decipher(key.substring(1), message);
		
	}
	
	/**
	 * Main method to read the input from the console using scanner. 
	 * @param args input of strings on two different lines  
	 */
	public static void main(String[] args) {
		//scanner takes input
	    Scanner in = new Scanner(System.in); 
	    //after retrieving the string move on to the next line
	    String key = in.nextLine();
	    String message = in.nextLine();
	    Handle(key, message);
	    in.close();
	}
}
