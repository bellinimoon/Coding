package project2;


/**
 * <p>This class is the homework of the project 2 in csci102, spring 2023 
 * semester. 
 * 
 * <p>This program use linked link to represent numbers entered by the user in 
 * order to perform math plus and multiply operations. It also compare between 
 * numbers. This class cannot be used directly; Users access this class by the
 * class LongNumbers.
 * 
 * 
 * @author Annabeth Gao
 * @version 02/23/2023
 */

public class Number extends Object implements Comparable<Number>{
	Node head, tail;
	int size;
	private class Node{
	    int data;
	    Node next;
        Node(int data){ 
        	this.data = data; 
        	this.next = null;
        }
	}
	
	/**
	 * Constructs a new Number object. 
	 * @param number single string representing the number to be used for this Number; 
	 * only takes a single element.
	 * @throws IllegalArgumentException if the number is null.
	 * @throws IllegalArgumentException if the number contains invalid characters.
	 */
	public Number(String number) throws IllegalArgumentException, NullPointerException{
		if(number == null) {
			throw new NullPointerException("The number is null");
		}
		// set up single digit to be past into
		int digit = 0;
		String numReversed = reverseString(number);
		//first check for validity, then mapping into number by this constructor.
		for (int i = 0; i < numReversed.length(); i++) {
		    try{
		        digit = Integer.parseInt(String.valueOf(numReversed.charAt(i)));
		    } catch (IllegalArgumentException ex){
		    	throw new IllegalArgumentException("The number is not valid");
		    }
		    this.setMyNumber(this, digit);
		    //increase the size of the number
	        this.size++;
		}
	
	}
	
	/** Implement individual digits into the Number Object in the form of Node. 
	 * I discussed some part of this method with Rena Wang.
	 * @param d a single integer representing part of the number.
	 * @param num the Number object the digit is inserting into.
	 * @return a Number object with the digit being added.
	 */
	private Number setMyNumber(Number num, int d){
		//set up node with the digit passed in
        Node createNode = new Node(d);
        //pointer in the object number
		Node current;
		//pass the digit into the end of the objectnumber
	    if (num.head == null) { 
	    	num.head = createNode;
	    }else {
	    	current = num.head;
	    	while(current.next!= null) {
		    	current = current.next;
	    	}
	    	current.next = createNode;
	    	num.tail = current.next;
	    } 
	    return num;
	}
	
	/** Calculate the length of the object number. 
	 * @return a integer representing the length.
	 */
	public int length(){
		int length = 0;
		// iterating the nodes inside the number object, and count them
		for(Node current = head; current != null; current= current.next) {
			length += 1;
		}
		return length;
	}
	
	/** Reverse the String. 
	 * @param A string to reverse.
	 * @return a new string that reversed the string as parameter.
	 */
	private String reverseString(String str){
		//set up a new string to record the reversed string
		String output = "";
		char ch;
		//rotating the string
		for (int i = str.length() - 1; i >= 0; i--){
	        ch = str.charAt(i);
	        output += ch; 
	      }
		return output;
	}
	
	/** Transfer the values of the number object to a String. 
	 * @return a string contains the values of the number object.
	 */	
	public String toString(){
		String str = "";
		//pointer for iteration
		Node current;
		current = this.head;
        while (current != null){
        	//record the value of each node in the string
            str += current.data;
            current = current.next;
        }
        //reverse it back because all numbers are represented backward
		str = reverseString(str);
		return str;
	}
	
	/** Calculate the surplus after an add operation in terms of base 10. 
	 * @param a one of the integer for the calculation.
	 * @param b one of the integer for the calculation.
	 * @return an integer represents the surplus after the calculation 
	 * in the base of 10.
	 */
	private int addSurplus(int a, int b) {
		if(a+b >= 10) {
			//as the highest number is 18 the highest surplus is 1, in the base of 10
			return 1;
		}
		return 0;
	}
	
	/** Calculate the remainder after an add operation in terms of base 10. 
	 * @param a one of the integer for the calculation.
	 * @param b one of the integer for the calculation.
	 * @return an integer represents the remainder after the calculation 
	 * in the base of 10.
	 */
	private int addRemainder(int a, int b) {
		if(a + b >= 10) {
			//the remainder on the same digit after the calculation
			return a + b - 10;
		}
		return a + b;
	}
	
	/** Calculate the result of the value of two object number added together. 
	 * @param other the number object being added.
	 * @return a number object representing the sum of the original Number and the 
	 * one being added.
	 * @throws NullPointerException if the number being added is null.
	 */
	public Number add​(Number other) throws NullPointerException{
		if (other == null) 
			throw new NullPointerException();
		//pointer to iterate the number other
		Node current2;
		//pointer to iterate the number
		Node current;
		//pointer to iterate the new number
		Node sum;
		// a new number to represent the result
		Number sumNum = new Number("");
		//the surplus received after the sum added with the previous surplus
		int addSur;
		int digit = 0;
		//the value of the nodes before performing calculations
		int temp1 = 0;
		//the value of the nodes before performing calculations
		int temp2 = 0;
		current = this.head;
		current2 = other.head;
		while(true) {
			//record the data to avoid potential alteration happening through the calculation
			temp1 = current.data;
			temp2 = current2.data;
			//record the surplus received after the sum added with the previous surplus
			addSur = addSurplus(addRemainder(current.data, current2.data), digit);
			// add the remaining digit to the number object after adding the it 
			//with the surplus from the last digit.
			current.data = addRemainder(addRemainder(current.data, current2.data), digit);
		    if (sumNum.head == null) { 
		    	sumNum.head = new Node(current.data);
		    }else {
		    	sum = sumNum.head;
		    	while(sum.next!= null) {
			    	sum = sum.next;		    	}
		    	sum.next = new Node(current.data);	
		    	sumNum.tail = sum.next;
		    } 
		    // the surplus that need to be add to the next node value
			digit = addSurplus(temp1, temp2) + addSur;
			//create empty node to avoid termination or exception
			if(current.next == null && current2.next == null && digit == 0){
				//terminates when no surplus is left and both number ends
				this.tail = current.next;
				break;
			}else if(current.next == null && current2.next == null){
				//same surplus is left but both numbers has reached the end
				current.next = new Node(0);
				current2.next = new Node(0);
				this.tail = current.next;
			}else if(current.next == null) {
				//one number ends and the other still has value
				current.next = new Node(0);
				this.tail = current.next;
			}else if(current2.next == null) {
				//one number ends and the other still has value
				current2.next = new Node(0);
				other.tail = current.next;
			}
			//shift to the next node
			current = current.next;
			current2 = current2.next;
		}
		return sumNum;
	}
	
	/** Calculate the surplus after an multiply operation in terms of base 10. 
	 * @param a one of the integer for the calculation.
	 * @param b one of the integer for the calculation.
	 * @return an integer represents the surplus after the calculation 
	 * in the base of 10.
	 */
	private int mulSurplus(int a, int b) {
		if(a * b < 10) {
			return 0;
		}else {
		//record the number of surplus, in the base of ten
			return (a * b - (a * b % 10)) / 10;
		}
	}
	
	/** Calculate the remainder after an multiply operation in terms of base 10. 
	 * @param a one of the integer for the calculation.
	 * @param b one of the integer for the calculation.
	 * @return an integer represents the remainder after the calculation 
	 * in the base of 10.
	 */
	private int mulRemainder(int a, int b) {
		//less than 10 then it's a single digit
		if(a * b < 10) {
			return a * b;
		}else {
		//will have surplus to higher digit but only needs the remainder
			return a * b % 10;
		}
	}
	
	/** Calculate the result of the Object Number being multiplied by a single digit. 
	 * @param digit the digit to multiply, has to be positive and less than ten.
	 * @return a number representing the number after the calculation.
	 * @throws IllegalArgumentException when the number is illegal
	 * (less than 0 and bigger than 10).
	 */
	public Number multiplyByDigit​(int digit) {
	    if (digit < 0){
	        throw new IllegalArgumentException("the digit:" + digit + "must be greater than zero");
	    }else if (digit >= 10) {
	    	throw new IllegalArgumentException("the digit:" + digit + "must be a single digit");
	    }
	    //empty number to record the result
		Number resultNum = new Number("");
		// set up surplus after the calculation
		int sur = 0;
		//set up digit to be implement into the number 
		int digitAfter = 0;
		// the sum of the result digit and the surplus
		int addSur = 0;
		Node current;
		Node newNode;
		current = this.head;
		if(digit == 0) {
			//when digit is 0 the result number is 0;
			resultNum.head = new Node(0);
			resultNum.tail = resultNum.head;
			return resultNum;
		}else {
			// start adding values to the new number
			while(true) {
				//final value to be implement to the node
				digitAfter = addRemainder(mulRemainder(current.data, digit), sur);
				// remaining value to be pass to the next digit
				addSur = addSurplus(mulRemainder(current.data, digit), sur);
				//first node
			    if (resultNum.head == null) { 
			    	resultNum.head = new Node(mulRemainder(current.data, digit));
			    }else {
			    	//other nodes
			    	newNode = resultNum.head;
			    	while(newNode.next!= null) {
			    		newNode = newNode.next;
			    	}
			    	newNode.next = new Node(digitAfter);
			    	resultNum.tail = newNode.next;
			    } 
			    //surplus for the next digit
			    sur = mulSurplus(current.data, digit) + addSur;
			    //prevent the program to terminate when one of the number ends
		    	if(current.next == null && sur == 0) {
		    		break;
		    	}else if(current.next == null) {
		    		current = new Node(0);
		    	}else {
		    		current = current.next;
		    	}
			}
		return resultNum;
		}	
	}
	
	/** shifts the nodes by adding zeroes in the head as the is reversed. 
	 * @param d the number we want the Number to shift by adding zeros.
	 * @return a number representing the number after shifting the digit.
	 */
	private Number carryOver(int d) {
		if(d <= 0) {
			return this;
		}else {
			// to shift the digit to the desired position by adding adequate number of zeros
			for(int i = 0; i < d; i++) {
				this.carryOverOne();
			}
			return this;
		}
	}
	
	/** shifts the nodes by adding 1 zero in the head(it's actually the end as the 
	 * number is reversed. 
	 * @return a number representing the number after shifting the digit by 1.
	 */
	private Number carryOverOne() {
		Node newNode = new Node(0);  
		Node current = this.head;
		//add a new 0 zero to the head as the numbers are reversed.
		this.head = newNode;  
		this.head.next = current; 
		return this;
	}
	
	/** Calculate the result of the value of two object number multiply together. 
	 * @param other the number object being multiplied.
	 * @return a number object representing the product of the original Number and the 
	 * one being multiplied.
	 * @throws NullPointerException if the number being multiplied is null.
	 */
	public Number multiply​(Number other){
		int i = 0;
		if (other == null) 
			throw new NullPointerException();
		Node current;
		// productNum should be made up by many productNumSub:
		Number productNumSub = new Number("");
		Number productNum = new Number("0");	
		current = other.head;
		while(current != null) {
			//every circle the result of the productNumSub has to extend 
			//one digit as it increases by 10
			productNumSub = this.multiplyByDigit​(current.data).carryOver(i);
			productNum = productNum.add​(productNumSub);
			current = current.next;
			i++;
		}
		return productNum;
	}
	
	/** Check whether an object is a number and equals another one. 
	 * @param obj an unknown object.
	 * @return a boolean showing the result. Two Number objects are equal if all of their 
	 * digits are the same and in the same order, and if they have the same number of digits. 
	 */
	@Override
	public boolean equals (Object obj) {
		Number other;
		Node current;
		Node current2;
		//test whether the object is empty
		if (obj == null) {
			return false;
		}		
		//test whether the object is a number
		if (obj instanceof Number) { 
			other = (Number)obj;
		}else {
			return false;
		}
		//test whether they have the same length
		if(other.length() != this.length()) {
			return false;
		}
		//test whether they have the same value
		if(this.compareTo(other) != 0) {
			return false;
		}
		//iterating both number to compare between individual nodes
		//probably don't need this because the comparTo() is doing the same thing
		current = this.head;
		current2 = other.head;
		while (current.next != null){
			if(current.data != current2.data) {
				return false;
			}
			current = current.next;
			current2 = current2.next;		
			}
		return true;
	}
	
	/** Compares this object with other for order. 
	 * @param other a number to compare.
	 * @return a integer showing the result.:a negative integer if this object's value
	 * is strictly smaller than the value of other, a positive integer if this object's 
	 * value is strictly greater than the value of other, and a zero if two values are 
	 * the same.  
	 * @throws NullPointerException if the number passed in as parameter is null.
	 */
	@Override
	public int compareTo(Number other) throws NullPointerException{
		Node current;
		Node current2;
		if (other == null){
			throw new NullPointerException("We can't compare to a null number");
		}
		//reverse the numbers cause we want to compare the its last node first
		Number reverseThis = new Number(reverseString(this.toString()));
		Number reverseOther = new Number(reverseString(other.toString()));	
		// if one number is longer than the other, return the result
		if(this.length() < other.length()) {
			return -1;
		}else if (this.length() > other.length()) {
			return 1;
		}else {
			//same length, so compare the value of individual nodes	
			current = reverseThis.head;
			current2 = reverseOther.head;
			while (current != null){
				if(current.data < current2.data) {
					return -1;
				}else if(current.data > current2.data) {
					return 1;
				}
			current = current.next;
			current2 = current2.next;		
			}
		}
		// if else they are the same
		return 0;
	}
}
