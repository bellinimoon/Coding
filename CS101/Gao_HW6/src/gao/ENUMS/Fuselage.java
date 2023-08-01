package gao.ENUMS;

import java.io.Serializable;

public enum Fuselage implements Serializable{
	AssaultFuselage("Assault Drone Fuselage",200,8000),
	StrikeFuselage("Strike Drone Fuselage",250,8100),
	ReconFuselage("Recon Drone Fuselage",150,8200);
	
	private String fuselageType;
	private int fuselageLength;
	private int fuselageCost;
	
	
	private Fuselage(String fuselageType, int fuselageLength, int fuselageCost) {
		this.fuselageType = fuselageType;
		this.fuselageLength = fuselageLength;
		this.fuselageCost = fuselageCost;
	}

	public String getFuselageType() {
		return fuselageType;
	}
	public void setFuselageType(String fuselageType) {
		this.fuselageType = fuselageType;
	}
	public int getFuselageLength() {
		return fuselageLength;
	}
	public void setFuselageLength(int fuselageLength) {
		this.fuselageLength = fuselageLength;
	}
	public int getFuselageCost() {
		return fuselageCost;
	}
	public void setFuselageCost(int fuselageCost) {
		this.fuselageCost = fuselageCost;
	}
	
	public String showSpecs() {
		return fuselageType;
		
	}
	

}
