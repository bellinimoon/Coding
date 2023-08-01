package gao_ISD;

import gao_BAY.FBay;
import gao_BAY.PBay;
import gao_BAY.SBay;
import gao_DECK.Deck;
import gao_ENGINE.Engine;
import gao_ENUMS.Status;
import gao_ENUMS.TieFighter;
import gao_HULL.Hull;
import gao_INTERFACES.Docks;
import gao_INTERFACES.Launchers;
import gao_INTERFACES.Maneuver;

public class Imperial_I extends StarDestroyer implements Maneuver, Docks, Launchers{
	public Imperial_I(String shpNumber, String shpName) {
		super(shpNumber, shpName);
		setShpCrew(9000);
		setShpClass("Imperial_I");
		Hull hull = new Hull("H1", "Imperial_I");
		Engine engine = new Engine("E1", "Imperial_I");
		Deck deck = new Deck("D1", "Imperial_I");
		SBay sb = new SBay("Starboard Bay", "SB-1");
		FBay fb = new FBay("Forward Bay", "FB-1");
		PBay pb = new PBay("Port Bay", "PB-1");
		setShpHulls(hull);
		setShpEngines(engine);
		setShpDecks(deck);
		setStarboardBay(sb);
		setPortBay(pb);
		setForwardBay(fb);

	}
	
	@Override
	public void navigatesToPosition(String p) {
		System.out.println("Moves" + p + "away.");

	}
	@Override
	public boolean docks(String D) {
		return true;
	}
	@Override
	public boolean undocks(String D) {
		return false;
	}
	@Override
	public boolean launchFighters() {
		if (TieFighter.TieFighter_S.getTF_status() == Status.READY && TieFighter.TieFighter_H.getTF_status() == Status.READY && TieFighter.TieFighter_I.getTF_status() == Status.READY) {
			return true;
		}else {
			return false;
		}
	

	}
	
	public void displayInfo() {
		System.out.println();
		System.out.println("____Ship Specifications____");
		System.out.println("Ship Number: " + getShpNumber() + "   Ship Type: " + getShpType() + "   Ship Name: " + getShpName()
		+ "   Ship Class: " + getShpClass() + "   Ship Crew: " + getShpCrew());
		getShpHulls().displayHullSpecs();	
		getShpDecks().displayDeckSpecs();
		getShpEngines().displayEngineSpecs();
		getStarboardBay().displayBayInfo();
		getPortBay().displayBayInfo();
		getForwardBay().displayBayInfo();
	
	}
}
