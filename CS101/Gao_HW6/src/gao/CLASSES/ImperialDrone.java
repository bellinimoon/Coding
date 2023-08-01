package gao.CLASSES;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import gao.ENUMS.Engine;
import gao.ENUMS.Fuselage;
import gao.ENUMS.Wing;
import gao.INTERFACES.DroneOperations;

public abstract class ImperialDrone implements DroneOperations, Serializable{
	private static final long serialVersionUID = -2026552431935453467L;
	private String droneID;
	private String droneType;
	private Fuselage fuselage;
	private Wing wings;
	private Engine engine;
	
	public ImperialDrone(String droneID, String droneType) {
		this.droneID = droneID;
		this.droneType = droneType;
	}
	
	public void displayDroneSpecs() {
		System.out.println("___STRIKE DRONE___");
		System.out.println("drone ID: " + getDroneID());
		System.out.println("drone type: " + getDroneType());
		System.out.println("Fuselage\n" + "      " + "Fuselage Type: " + Fuselage.StrikeFuselage.getFuselageType() +  
				"      " + "Fuselage Length: " + NumberFormat.getNumberInstance(Locale.US).format(Fuselage.StrikeFuselage.getFuselageLength()) +
				"      " + "Fuselage Cost: " + NumberFormat.getNumberInstance(Locale.US).format(Fuselage.StrikeFuselage.getFuselageCost()));
		System.out.println("Wings\n" + "      " + "Wing Type: " + Wing.StrikeWing.getWingType() +  
				"      " + "Wing Length: " + NumberFormat.getNumberInstance(Locale.US).format(Wing.StrikeWing.getWingLength()) +
				"      " + "Wing Cost: " + NumberFormat.getNumberInstance(Locale.US).format(Wing.StrikeWing.getWingCost()));
		System.out.println("Engines\n" + "      " + "Engine Type: " + Engine.StrikeEngine.getEngineType() +  
				"      " + "Engine HP: " + NumberFormat.getNumberInstance(Locale.US).format(Engine.StrikeEngine.getEngineHP()) +
				"      " + "Engine Cost: " + NumberFormat.getNumberInstance(Locale.US).format(Engine.StrikeEngine.getEngineCost()));
		
	}
	
	
	public String getDroneID() {
		return droneID;
	}
	public void setDroneID(String droneID) {
		this.droneID = droneID;
	}
	public String getDroneType() {
		return droneType;
	}
	public void setDroneType(String droneType) {
		this.droneType = droneType;
	}
	public Fuselage getFuselage() {
		return fuselage;
	}
	public void setFuselage(Fuselage fuselage) {
		this.fuselage = fuselage;
	}
	public Wing getWings() {
		return wings;
	}
	public void setWings(Wing wings) {
		this.wings = wings;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

}
