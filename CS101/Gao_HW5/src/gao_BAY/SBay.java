package gao_BAY;

import gao_ENUMS.TieFighter;

public class SBay extends FighterBay {
	private int Capacity = 36;

	public SBay() {
	}

	public SBay(String bayName, String bayID) {
		super(bayName, bayID);
		setBayType("Tie Fighter S");
	}
	
	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public void displayBayInfo() {
		System.out.println("");
		System.out.println("____Fighter Bay Specifications____");
		System.out.println("Starboard Fighter Bay ID: " + getBayID());
		System.out.println(getBayName());
		System.out.println(getBayID());
		System.out.println(getBayType());
		System.out.println("Fighter Capacity: " + getCapacity());
	}

	@Override
	public void displayTieFighters() {
		System.out.println("Tie Fighter");
		System.out.println("Fighter Type: " + TieFighter.TieFighter_H. getTF_type());
		System.out.println("Length: " + TieFighter.TieFighter_H.getTF_length());
		System.out.println("Width: " + TieFighter.TieFighter_H.getTF_width());
		System.out.println("Status: " + TieFighter.TieFighter_H.getTF_status());
	}

}
