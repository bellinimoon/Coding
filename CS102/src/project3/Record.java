package project3;
/**
 * <p>This class is the homework of the project 3 in csci102, spring 2023 
 * semester. 
 * 
 * <p>This class represents a record. The Record class stores information about 
 * a particular record/row from the input file. The class defines new methods
 * that override equals and compareTo methods in the object class. 
 * 
 * 
 * @author Annabeth Gao
 * @version 03/20/2023
 */
public class Record extends Object implements Comparable<Record> {
	private Name name;
	private String business;
	private Location location;
	/**
	 * Constructs a new Record object. 
	 * @param name single Name representing information related to the person in the record; 
	 * @param business single string representing the business in the record; 
	 * @param location single Location representing location information in the record; 
	 */
	public Record(Name name, String business, Location location) {
		this.name = name;
		this.business = business;
		this.location = location;
	}
	/** Check whether an object is a record and equals another one. 
	 * @param obj an unknown object.
	 * @return a boolean showing the result. Two Record objects are equal if all of their 
	 * variables are the same. We skipped the comparison when one or both of the variable 
	 * is null.
	 */
	@Override 
	public boolean equals(Object obj) {
		Record recCompare = null;
		boolean busComp = false;
		//to check whether obj is an instance of record
		if (obj instanceof Record) { 
		}else {
			return false;
		}
		//cast
		recCompare = (Record)obj;
		//if they are not the same by the method compareTo, return false
		if(recCompare.compareTo(this) != 0) {
			return false;
		}
		// return true if the business equals
		if(recCompare.business.equals(business)){
			busComp = true;
		}else {
			//if they don't equal and both are not null. compare them again case insensitively
			if(recCompare.business != null && business != null) {
				busComp = recCompare.business.equalsIgnoreCase(business);
				//return only if they are not equal
				if(!busComp) {
					return false;
				}
			}else {
				// if they don't equal and one may contains value, returns false
				return false;
			}
		}
		// return true if the name and location equals, also the boolean we got from comparing 
		//the entries for business for both object need to be true.
		if(recCompare.name.equals(this.name) && 
				recCompare.location.equals(this.location) && busComp) {
			return true;
		}
		// return false if one or more conditions are not met
		return false;
		
	}
	/** Compares this object with another for order. 
	 * @param newRecord a Record to compare.
	 * @return a integer showing the result: a negative integer if this object's value
	 * is strictly smaller than the value of other, a positive integer if this object's 
	 * value is strictly greater than the value of other, and a zero if two values are 
	 * the same.  
	 * If one of the objects has a null variable, the comparison skipped that variable.
	 */
	@Override
	public int compareTo(Record newRecord) {
		int nameComp;
		int locComp;
		//use the new compareTo method in the name class and compare two Name classes
		nameComp = this.name.compareTo(newRecord.name);
		// return only if nameComp does not equal each other
		if(nameComp != 0) {
			return nameComp;
		}
		// use the new compareTo method in the location class and compare two location classes
		locComp = this.location.compareTo(newRecord.location);
		// return only if locComp does not equal each other
		if(locComp != 0) {
			return locComp;
		}
		// else they are the same
		return 0;
	}
	/** Produce a two-line string displaying the information in the record. 
	 * @return a string in a declared format displaying all the information in the record.
	 * 
	 */
	@Override
	public String toString(){
		String st = "";
		// add the extracted information to the new string
		st += this.name.getLastName() + "," + this.name.getFirstName() + "," + this.name.getMiddleInitial() + "\t" +
		this.business + "," + this.location.getCity() + "," + this.location.getState() + "," + 
				this.location.getCountry() + "," + this.location.getZip(); 
		return st;	
	}
	/** Getter methods to get the name in the record. 
	 * @return the name object stored in the record.
	 */
	public Name getName() {
		return name;
	}
	/** Getter methods to get the business in the record. 
	 * @return the besiness information stored in the record.
	 */
	public String getBusiness() {
		return business;
	}
	/** Getter methods to get the location in the record. 
	 * @return the location object stored in the record.
	 */
	public Location getLocation() {
		return location;
	}
}
