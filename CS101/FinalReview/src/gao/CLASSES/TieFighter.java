package gao.CLASSES;

import java.io.Serializable;

import gao.ENUMS.TiePilot;

public abstract class TieFighter implements Serializable{
	private String id;
	private TiePilot pilot;

	public TieFighter(String id, TiePilot pilot) {
		this.id = id;
		this.pilot = pilot;
	}

	public static void displayPilotInfo(TiePilot p) {	
		System.out.println("Pilot Type: " + p.getPilotType()+ "   Pilot Rating: " + p.getPilotRating());
		
	}
	public abstract void serializeMe(String filepath);
	public abstract TieFighter deserializeMe(String filepath);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TiePilot getPilot() {
		return pilot;
	}

	public void setPilot(TiePilot pilot) {
		this.pilot = pilot;
	}

}
