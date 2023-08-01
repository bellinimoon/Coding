package gao_BAY;

import java.util.ArrayList;

import gao_ENUMS.TieFighter;

public abstract class FighterBay extends Bay {
	private ArrayList<TieFighter> Slots;

	public FighterBay() {
	}
	
	public FighterBay(String bayName, String bayID) {
		super(bayName, bayID, "Tie Fighter");
	}

	public ArrayList<TieFighter> getSlots() {
		return Slots;
	}

	public void setSlots(ArrayList<TieFighter> slots) {
		Slots = slots;
	}
	
	public abstract void displayTieFighters();

	@Override
	public abstract void displayBayInfo();
}
