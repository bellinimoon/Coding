package gao.ENUMS;

import java.io.Serializable;

public enum Wing implements Serializable {
	AssaultWing("Assault Drone Wing",4200,18000),
	StrikeWing("Strike Drone Wing",4250,18100),
	ReconWing("Recon Drone Wing",4300,18200);
	
	private String wingType;
	private int wingLength;
	private int wingCost;
	private Wing(String wingType, int wingLength, int wingCost) {
		this.wingType = wingType;
		this.wingLength = wingLength;
		this.wingCost = wingCost;
	}
	
	public String getWingType() {
		return wingType;
	}
	public void setWingType(String wingType) {
		this.wingType = wingType;
	}
	public int getWingLength() {
		return wingLength;
	}
	public void setWingLength(int wingLength) {
		this.wingLength = wingLength;
	}
	public int getWingCost() {
		return wingCost;
	}
	public void setWingCost(int wingCost) {
		this.wingCost = wingCost;
	}
	
	public String showSpecs() {
		return wingType;
		
	}
	
}
