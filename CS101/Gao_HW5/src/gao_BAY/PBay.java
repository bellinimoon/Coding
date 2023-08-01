package gao_BAY;

import gao_ENUMS.TieFighter;

public class PBay extends FighterBay {
	private int Capacity = 48;

	public PBay() {
	}

	public PBay(String bayName, String bayID) {
		super(bayName, bayID);
		setBayType("Tie Fighter P");
	}
	
	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public void displayBayInfo() {
		System.out.println("");
		System.out.println("Port Fighter Bay ID: " + getBayID());
		System.out.println(getBayName());
		System.out.println(getBayID());
		System.out.println(getBayType());
		System.out.println("Fighter Capacity: " + getCapacity());
	}

	@Override
	public void displayTieFighters() {
		System.out.println("Tie Fighter");
		System.out.println("Fighter Type: " + TieFighter.TieFighter_I. getTF_type());
		System.out.println("Length: " + TieFighter.TieFighter_I.getTF_length());
		System.out.println("Width: " + TieFighter.TieFighter_I.getTF_width());
		System.out.println("Status: " + TieFighter.TieFighter_I.getTF_status());

	}

}
