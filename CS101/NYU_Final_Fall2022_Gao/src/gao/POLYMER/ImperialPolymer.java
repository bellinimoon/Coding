package gao.POLYMER;

import gao.CLUSTER.Boson;
import gao.CLUSTER.Gluon;
import gao.CLUSTER.Meson;
import gao.CLUSTER.Trion;
import gao.INTERFACE.Polymerize;

public abstract class ImperialPolymer implements Polymerize {
	private String ID;
	private Meson[ ] mesons;
	private Boson[ ] bosons;
	private Gluon[ ] gluons;
	private Trion[ ] trions;
	private double mass;

	public ImperialPolymer(String iD) {
		super();
		ID = iD;
	}
	
	public void displayPolymer() {
		if(getMesons() != null){
			for (Meson M: getMesons()){
				M.displayCluster();
			}
		}
		if(getBosons() != null){
			for (Boson B: getBosons()){
				B.displayCluster();
			}
		}
		if(getGluons() != null){
			for (Gluon G: getGluons()){
				G.displayCluster();
			}
		}
		if(getTrions() != null){
			for (Trion T: getTrions()){
				T.displayCluster();
			}
		}
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Meson[] getMesons() {
		return mesons;
	}
	public void setMesons(Meson[] mesons) {
		this.mesons = mesons;
	}
	public Boson[] getBosons() {
		return bosons;
	}
	public void setBosons(Boson[] bosons) {
		this.bosons = bosons;
	}
	public Gluon[] getGluons() {
		return gluons;
	}
	public void setGluons(Gluon[] gluons) {
		this.gluons = gluons;
	}
	public Trion[] getTrions() {
		return trions;
	}
	public void setTrions(Trion[] trions) {
		this.trions = trions;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	

}
