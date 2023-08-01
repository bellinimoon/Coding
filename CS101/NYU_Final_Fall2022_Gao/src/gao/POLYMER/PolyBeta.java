package gao.POLYMER;

import gao.CLUSTER.Boson;
import gao.CLUSTER.Gluon;
import gao.CLUSTER.Meson;
import gao.CLUSTER.Trion;
import gao.INTERFACE.Polymerize;

public class PolyBeta extends ImperialPolymer {

	public PolyBeta(String ID) {
		super(ID);
		Meson[] MS = new Meson[2];
		for(int i=0; i < MS.length; i++) {
			MS[i] = new Meson();
		}
		Boson[] BS = new Boson[2];
		for(int i=0; i < BS.length; i++) {
			BS[i] = new Boson();
		}
		Gluon[] GU = new Gluon[1];
		for(int i=0; i < GU.length; i++) {
			GU[i] = new Gluon();
		}
		Trion[] TI = new Trion[1];
		for(int i=0; i < TI.length; i++) {
			TI[i] = new Trion();
		}
		setMesons(MS);
		setBosons(BS);
		setGluons(GU);
		setTrions(TI);
		Polymerize.calculateMass (this);
	}
	public void displayBeta(){
		System.out.println("Poly Beta");
		System.out.println("Mass:" + getMass());
		System.out.println();
		displayPolymer();
		
	}

}
