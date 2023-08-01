package gao_ISD;

import gao_BAY.FBay;
import gao_BAY.PBay;
import gao_BAY.SBay;
import gao_DECK.Deck;
import gao_ENGINE.Engine;
import gao_HULL.Hull;

public abstract class StarDestroyer {
	private String ShpNumber;
	private String ShpType;
	private String ShpName;
	private String ShpClass;
	private int ShpCrew;
	private Hull ShpHulls;
	private Deck ShpDecks;

	private Engine ShpEngines;
	private SBay StarboardBay;
	private PBay PortBay;
	private FBay ForwardBay;
	
	public StarDestroyer(String shpNumber, String shpName) {
		ShpNumber = shpNumber;
		ShpName = shpName;
		this.ShpType = "Star Destroyer";

	}
	
	public String getShpType() {
		return ShpType;
	}
	public void setShpType(String shpType) {
		ShpType = shpType;
	}
	public String getShpNumber() {
		return ShpNumber;
	}
	public void setShpNumber(String shpNumber) {
		ShpNumber = shpNumber;
	}
	public String getShpName() {
		return ShpName;
	}
	public void setShpName(String shpName) {
		ShpName = shpName;
	}
	public String getShpClass() {
		return ShpClass;
	}
	public void setShpClass(String shpClass) {
		ShpClass = shpClass;
	}
	public int getShpCrew() {
		return ShpCrew;
	}
	public void setShpCrew(int shpCrew) {
		ShpCrew = shpCrew;
	}
	public Hull getShpHulls() {
		return ShpHulls;
	}
	public void setShpHulls(Hull shpHulls) {
		ShpHulls = shpHulls;
	}
	public Deck getShpDecks() {
		return ShpDecks;
	}
	public void setShpDecks(Deck shpDecks) {
		ShpDecks = shpDecks;
	}
	public Engine getShpEngines() {
		return ShpEngines;
	}
	public void setShpEngines(Engine shpEngines) {
		ShpEngines = shpEngines;
	}
	public void setStarboardBay(SBay starboardBay) {
		StarboardBay = starboardBay;
	}

	public PBay getPortBay() {
		return PortBay;
	}

	public void setPortBay(PBay portBay) {
		PortBay = portBay;
	}

	public FBay getForwardBay() {
		return ForwardBay;
	}

	public void setForwardBay(FBay forwardBay) {
		ForwardBay = forwardBay;
	}
	public SBay getStarboardBay() {
		return StarboardBay;
	}
	public void displayInfo() {
	}
	

}
