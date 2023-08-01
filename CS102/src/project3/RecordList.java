package project3;

import java.util.ArrayList;
/**
 * <p>This class is the homework of the project 3 in csci102, spring 2023 
 * semester. 
 * 
 * <p>This class stores all the unique Record objects. This class inherits
 * from the ArrayList<Record> class. This class provides all functionality of the 
 * ArrayList, but adds to it a few functions that are specialized to a list that 
 * is designed to store and work with Record objects. It only returns the records 
 * that passes certain tests
 * 
 * 
 * @author Annabeth Gao
 * @version 03/20/2023
 */
@SuppressWarnings("serial")
public class RecordList extends ArrayList<Record> {
	// a default constructor
	public RecordList(){
	}
	/** search the record list and returns only the one containing the keyword (case insensitive) 
	 * @param keyword the String object that serves as a key.
	 * @return a list of records for which the keyword is a substring of person's last name or first name
	 * @return null if there are no Record objects matching the keyword.
	 * @throws IllegalArgumentException if called with null argument or with an empty string.
	 */
	public RecordList getByName(String keyword) {
		//creates new record list to store the filtered records
		RecordList records = new RecordList();
		// throws exception if the parameter is null
		if (keyword == null || keyword == "") {
			throw new IllegalArgumentException("invalid input name");
		}
		// loop through the record list
		for(Record rc: this) {
			// if the name variable matches the keyword(case insensitive), add it to the new 
			//record list
			if(rc.getName().getFirstName().toLowerCase().contains(keyword.toLowerCase()) || 
					rc.getName().getLastName().toLowerCase().contains(keyword.toLowerCase()) ) {
				records.add(rc);
			}
		}
		// returns null if the new record list is empty
		if (records.size() == 0) {
			return null;
		}
		// returns the record list with the filtered records
		return records;
	}
	/** search the record list and returns only the one containing the keyword (case insensitive) 
	 * @param keyword the String object that serves as a key.
	 * @return a list of records for which the keyword is a substring of the city at which the tax 
	 * preparer is located. 
	 * @return null if there are no Record objects matching the keyword.
	 * @throws IllegalArgumentException if called with null argument or with an empty string.
	 */
	public RecordList getByCity(String keyword) {
		// throws exception if the parameter is null
		if (keyword == null || keyword == "") {
			throw new IllegalArgumentException("invalid input city");
		}
		//creates new record list to store the filtered records
		RecordList records = new RecordList();
		// loop through itself
		for(Record rc: this) {
			if(rc.getLocation().getCity().toLowerCase().contains(keyword.toLowerCase())) {
				// if the name variable matches the keyword(case insensitive), add it to the new 
				//record list 
				records.add(rc);
			}
		}
		// returns null if no records matches the keyword
		if (records.size() == 0)
			return null;
		// returns the filtered records stored in the record list
		return records;
	}
	/** search the record list and returns only the one containing the keyword (case insensitive) 
	 * @param zip the String object that serves as a key.
	 * @return a list of records for which the zip-code (if specified) matches the zip argument exactly.   
	 * @return null if there are no Record objects matching the zip exactly.
	 * @throws IllegalArgumentException if called with null argument, 
	 * @throws IllegalArgumentException if called with a string that does not represent a five 
	 * digit zip code
	 */
	public RecordList getByZip (String zip)  {
		// throws exception if the parameter is invalid(contains non digit characters)
	    for (int i = 0; i < zip.length(); i++) {
	        if (!Character.isDigit(zip.charAt(i))) {
	        	throw new IllegalArgumentException("invalid input zip");
	        }
	    }
	    // throws exception if the parameter in invalid(wrong length)
		if (zip == null || zip.length() != 5) {
			throw new IllegalArgumentException("invalid input zip");
		}
		//creates new record list to store the filtered records
		RecordList records = new RecordList();
		//loop through itself for searching
		for(Record rc: this) {
			//add the records to the record list if it matches the zip
			if(rc.getLocation().getZip().equals(zip)) {
				records.add(rc);
			}
		}
		// if there's no match in the search, return null
		if (records.size() == 0)
			return null;
		// else returns the records 
		return records;
	}
	/** Produce a string displaying the information of the records in the record list. 
	 * @return a String object that is a meaningful representation of the object on which it is called
	 * 
	 */
	@Override
	public String toString(){
		String st = "";
		//loop through the record list itself, utilizing the toString method in the record method
		for(Record rc : this) {
			// line break after each new line
			st += rc.toString() + "\n";
		}
	return st;
	}
}
