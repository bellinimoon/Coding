package gao.PARTICLE;

import gao.ENUMS.Charge;
import gao.ENUMS.Spin;

public abstract class ImperialParticle {
	private String pType;
	private String symbol;
	private double mass;
	private double power;
	private Charge charge;
	private Spin spin;
	
	public ImperialParticle(String pType, String symbol, double mass, double power, Charge charge, Spin spin) {
		super();
		this.pType = pType;
		this.symbol = symbol;
		this.mass = mass;
		this.power = power;
		this.charge = charge;
		this.spin = spin;
	}
	public abstract void displayParticle();
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	public Charge getCharge() {
		return charge;
	}
	public void setCharge(Charge charge) {
		this.charge = charge;
	}
	public Spin getSpin() {
		return spin;
	}
	public void setSpin(Spin spin) {
		this.spin = spin;
	}
	


}
