package project3;
/**
 * <p>This class is the homework of the project 3 in csci102, spring 2023 
 * semester. 
 * 
 * <p>This class represents a location. It should store information about 
 * city, state, country, and zip code for a location. The class defines new methods
 * that override equals and compareTo methods in the object class. This class can be used 
 * directly and are also being used as part of the class Record.
 * 
 * 
 * @author Annabeth Gao
 * @version 03/20/2023
 */
public class Location extends Object implements Comparable<Location> {
	private String city;
	private String state;
	private String country;
	private String zip;
	/**
	 * Constructs a new Location object. Modify the zipcode to a five digit format.
	 * @param city single string representing the city name of the location; 
	 * @param state single string representing the state name of the location; 
	 * @param country single string representing the country name of the location; 
	 * @param zip code single string representing the zip code of the location; 
	 * @throws IllegalArgumentException if the city name is null.
	 * @throws IllegalArgumentException if the zip code is invalid
	 * (when it exceeds digit number or contains invalid characters).
	 */
	public Location(String city, String state, String country, String zip) {
		// a string to record the modified zip
		String newZip = "";
		// throws exception when city is null
		if (city == null || city == "") {
            throw new IllegalArgumentException("City cannot be null or empty");
		}
		// throws exception when zipcode has non digit characters
	    for (int i = 0; i < zip.length(); i++) {
	        if (!Character.isDigit(zip.charAt(i))) {
	        	throw new IllegalArgumentException("Zip Code is invalid");
	        }
	    }
	    // throws exception when the length of the parameter is illegal
	    //(exceeds 5 or shorter or equal to 0)
		if(zip.length()> 5 || zip.length() <= 0) {
			throw new IllegalArgumentException("Zip Code is invalid");
		}else if(zip.length() == 5) {
			//if the zip has five digit, we don't need to modify it anymore
			newZip = zip;
		}else {
			// add 0s in the front to make a five digit zip
			for(int i = 0; i < 5 - zip.length(); i++) {
				newZip += "0" ;
			}
			newZip += zip;
		}
		this.zip = newZip;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	/** Check whether an object is a location and equals another one. 
	 * @param obj an unknown object.
	 * @return a boolean showing the result. Two Location objects are equal if all of their 
	 * variables are the same. We skipped the comparison when one or both of the variable 
	 * is null.
	 */
	@Override 
	public boolean equals(Object obj) {
		//set up booleans to compare between variables
		boolean zipComp = true;
		boolean cityComp = true;
		boolean stateComp = true;
		boolean countryComp = true;
		Location locCompare = null;
		//to check whether obj is an instance of location
		if (obj instanceof Location) { 
		}else {
			return false;
		}
		//cast
		locCompare = (Location)obj;
		//if they are not the same by the method compareTo, return false
		if(this.compareTo(locCompare) != 0) {
			return false;
		}
		// if the zip do not equal return false
		if(locCompare.zip.equals(this.zip)) {
		}else {
			zipComp = false;
		}
		// if the city names (case insensitive) do not equal each other, 
		//record result with the boolean
		if(locCompare.city != this.city) {
			if(locCompare.city != null && this.city != null) {
				cityComp = locCompare.city.equalsIgnoreCase(this.city);
			}
		}
		// if the state names (case insensitive) do not equal each other, 
		//record result with the boolean	
		if(locCompare.state != this.state) {
			if(locCompare.state != null && this.state != null) {
				stateComp = locCompare.state.equalsIgnoreCase(this.state);
			}
		}
		// if the country names (case insensitive) do not equal each other, 
		//record result with the boolean
		if(locCompare.country != this.country) {
			if(locCompare.country != null && this.country != null) {
			countryComp = locCompare.country.equalsIgnoreCase(this.country);
			}
		}
		// returns true only when all of these variables are equal
		if(zipComp && cityComp && stateComp && countryComp) {
			return true;
		}
		//else return false
		return false;
		
	}
	/** Compares this object with another for order. 
	 * @param newLoc a location to compare.
	 * @return a integer showing the result: a negative integer if this object's value
	 * is strictly smaller than the value of other, a positive integer if this object's 
	 * value is strictly greater than the value of other, and a zero if two values are 
	 * the same.  
	 * If one of the objects has a null variable, the comparison skipped that variable.
	 */
	@Override
	public int compareTo(Location newLoc) {
		//set up a initial value to avoid having null values.
		int stateCompare;
		int cityCompare;
		int zipCompare;
		int countryCompare;
		// compare the zip
		if(newLoc.zip != this.zip && newLoc.zip != null && this.zip != null) {
			zipCompare = this.zip.compareTo(newLoc.zip);
			// returns if they don't equal, else we compare the next variable
			if (zipCompare != 0) {
				return zipCompare;
			}
		}
		// compare the city name
		if(newLoc.city != this.city && newLoc.city != null && this.city != null) {
			// change them to lower case only when they are both not null
			cityCompare = this.city.toLowerCase().compareTo(newLoc.city.toLowerCase());
			// returns if they don't equal, else we compare the next variable
			if (cityCompare != 0) {
				return cityCompare;
			}
		}
		// compare the state name
		if(newLoc.state != this.state && newLoc.state != null && this.state != null) {
			// change them to lower case only when they are both not null
			stateCompare = this.state.toLowerCase().compareTo(newLoc.state.toLowerCase());
			// returns if they don't equal, else we compare the next variable
			if (stateCompare != 0) {
				return stateCompare;
			}
		}
		//compare the country name
		if(newLoc.country != this.country && newLoc.country != null && this.country != null) {
			// change them to lower case only when they are both not null
			countryCompare = this.country.toLowerCase().compareTo(newLoc.country.toLowerCase());
			// returns if they don't equal, else we can say the two objects are equal
			if (countryCompare != 0) {
				return countryCompare;
			}
		}
		// the objects are equal since all of their variables are equal
		return 0;
	}
	//getters
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public String getZip() {
		return zip;
	}
	
}
