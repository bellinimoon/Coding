package gao_BAY;

import gao_ENUMS.TieFighter;

public class FBay extends FighterBay {
	private int Capacity = 96;

	public FBay() {
	}

	public FBay(String bayName, String bayID) {
		super(bayName, bayID);
		setBayType("Tie Fighter F");
	}
	
	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public void displayBayInfo() {
		System.out.println("");
		System.out.println("Forward Fighter Bay ID: " + getBayID());
		System.out.println(getBayName());
		System.out.println(getBayID());
		System.out.println(getBayType());
		System.out.println("Fighter Capacity: " + getCapacity());
	}
	
	@Override
	public void displayTieFighters() {
		System.out.println("Tie Fighter");
		System.out.println("Fighter Type: " + TieFighter.TieFighter_S. getTF_type());
		System.out.println("Length: " + TieFighter.TieFighter_S.getTF_length());
		System.out.println("Width: " + TieFighter.TieFighter_S.getTF_width());
		System.out.println("Status: " + TieFighter.TieFighter_S.getTF_status());

	}

}
