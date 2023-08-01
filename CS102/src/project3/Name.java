package project3;

/**
 * <p>
 * This class is the homework of the project 3 in csci102, spring 2023 semester.
 * 
 * <p>
 * This class represents a person's name. It should store information about
 * first name, last name, and the middle initial of a person. The class defines
 * new methods that override equals and compareTo methods in the object class.
 * This class can be used directly and are also being used as part of the class
 * Record.
 * 
 * 
 * @author Annabeth Gao
 * @version 03/20/2023
 */

public class Name extends Object implements Comparable<Name> {
	// Initializing null variables
	private String lastName = null;
	private String firstName = null;
	private char middleInitial = '\u0000';

	/**
	 * Constructs a new Name object.
	 * 
	 * @param nameLast single string representing the last name of the person; only
	 *                 takes a single element.
	 * @throws IllegalArgumentException if the last name is null.
	 */
	public Name(String nameLast) {
		// throws exception when the parameter is null
		if (nameLast == null || nameLast == "") {
			throw new IllegalArgumentException("Last name cannot be null or empty");
		}
		this.lastName = nameLast;
	}

	/**
	 * Constructs a new Name object.
	 * 
	 * @param nameLast  single string representing the last name of the person;
	 * @param nameFirst single string representing the first name of the person;
	 * @throws IllegalArgumentException if the last name is null.
	 */
	public Name(String nameLast, String nameFirst) {
		// throws exception when the parameter is null
		if (nameLast == null || nameLast == "") {
			throw new IllegalArgumentException("Last name cannot be null or empty");
		}
		this.lastName = nameLast;
		this.firstName = nameFirst;
	}

	/**
	 * Constructs a new Name object.
	 * 
	 * @param nameLast   single string representing the last name of the person;
	 * @param nameFirst  single string representing the first name of the person;
	 * @param nameMiddle single character representing the middle initial of the
	 *                   person;
	 * @throws IllegalArgumentException if the last name is null.
	 */
	public Name(String nameLast, String nameFirst, char nameMiddle) {
		// throws exception when the parameter is null
		if (nameLast == null || nameLast == "") {
			throw new IllegalArgumentException("Last name cannot be null or empty");
		}
		this.lastName = nameLast;
		this.firstName = nameFirst;
		this.middleInitial = nameMiddle;
	}

	/**
	 * Check whether an object is a name and equals another one.
	 * 
	 * @param obj an unknown object.
	 * @return a boolean showing the result. Two Name objects are equal if all of
	 *         their variables are the same. We skipped the comparison when one or
	 *         both of the variable is null.
	 */
	@Override
	public boolean equals(Object obj) {
		Name nameCompare = null;
		// variables indicate whether individual variable equals each other
		boolean mid = false;
		boolean last = false;
		boolean first = false;
		// verify whether obj is an instance of the object name
		if (obj instanceof Name) {
		} else {
			return false;
		}
		// cast
		nameCompare = (Name) obj;
		// if they are not the same by the method compareTo, return false
		if (this.compareTo(nameCompare) != 0) {
			return false;
		}
		// to test the middle initial, if they equals each other, return true for the
		// variable
		if (nameCompare.middleInitial == this.middleInitial) {
			mid = true;
		} else {
			// change them to lower case if they are both not null
			if (nameCompare.middleInitial != '\u0000' && this.middleInitial != '\u0000') {
				mid = Character.toLowerCase(this.middleInitial) == Character.toLowerCase(nameCompare.middleInitial);
			}
		}
		// to test the first name, if they equals each other, return true for the
		// variable
		if (nameCompare.firstName == this.firstName) {
			first = true;
		} else {
			// use the equalsIgnoreCase method only if they are both not null
			if (nameCompare.firstName != null && this.firstName != null) {
				// first defines the boolean whether the firstName for both objects are the same
				first = nameCompare.firstName.equalsIgnoreCase(this.firstName);
			}
		}
		// to test the first name, if they equals each other, return true for the
		// variable
		if (nameCompare.lastName == lastName) {
			last = true;
		} else {
			// use the equalsIgnoreCase method only if they are both not null
			if (nameCompare.lastName != null && lastName != null) {
				last = nameCompare.lastName.equalsIgnoreCase(lastName);
			}
		}
		// if all three variables return true, the object is the same, return true
		if (mid && first && last) {
			return true;
		}
		// return false for other scenarios
		return false;
	}

	/**
	 * Compares this object with another for order.
	 * 
	 * @param newName a name to compare.
	 * @return a integer showing the result: a negative integer if this object's
	 *         value is strictly smaller than the value of other, a positive integer
	 *         if this object's value is strictly greater than the value of other,
	 *         and a zero if two values are the same. If one of the objects has a
	 *         null variable, the comparison skipped that variable.
	 */
	@Override
	public int compareTo(Name newName) {
		// set up a initial value to avoid having null values.
		int mid;
		int last;
		int first;
		// compare the lastName first
		if (newName.lastName != this.lastName && newName.lastName != null && this.lastName != null) {
			// use the compareTo method from the string class
			// return the integer only when they are not null
			last = this.lastName.toLowerCase().compareTo(newName.lastName.toLowerCase());
			if (last != 0) {
				return last;
			}
		}
		// compare the firstName next
		if (newName.firstName != this.firstName) {
			if (newName.firstName != null && this.firstName != null) {
				// use the compareTo method from the string class
				// return the integer only when they are not null
				first = this.firstName.toLowerCase().compareTo(newName.firstName.toLowerCase());
				// return the integer if they passed through the last condition and equals each
				// other
				if (first != 0) {
					return first;
				}
			}
		}
		// compare the middle initial last
		if (newName.middleInitial != this.middleInitial && newName.middleInitial != '\u0000'
				&& this.middleInitial != '\u0000') {
			// to check the middle initial, change them to lower case only when they are not
			// null
			mid = (String.valueOf(this.middleInitial).toLowerCase())
					.compareTo(String.valueOf(newName.middleInitial).toLowerCase());
			// return 0 if the last comparison returns 0, return another number if they
			// don't
			if (mid != 0) {
				return mid;
			}
		}
		// if in every condition they equals each other, return 0
		return 0;
	}

	// getters
	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public char getMiddleInitial() {
		return middleInitial;
	}

}
