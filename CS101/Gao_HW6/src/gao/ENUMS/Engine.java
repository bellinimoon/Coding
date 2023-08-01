package gao.ENUMS;

import java.io.Serializable;

public enum Engine implements Serializable{
	AssaultEngine("Assault Drone Engine",1000,3000),
	StrikeEngine("Strike Drone Engine",1200,3100),
	ReconEngine("Recon Drone Engine",1400,3200);
	
	private String engineType;
	private int engineHP;
	private int engineCost;
	
	private Engine(String engineType, int engineHP, int engineCost) {
		this.engineType = engineType;
		this.engineHP = engineHP;
		this.engineCost = engineCost;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public int getEngineHP() {
		return engineHP;
	}

	public void setEngineHP(int engineHP) {
		this.engineHP = engineHP;
	}

	public int getEngineCost() {
		return engineCost;
	}

	public void setEngineCost(int engineCost) {
		this.engineCost = engineCost;
	}
	
	public String showSpecs() {
		return engineType;
	}
	
	
}
