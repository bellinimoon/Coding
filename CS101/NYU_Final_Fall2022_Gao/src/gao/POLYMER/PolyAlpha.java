package gao.POLYMER;

import gao.CLUSTER.Boson;
import gao.CLUSTER.Gluon;
import gao.CLUSTER.Meson;
import gao.CLUSTER.Trion;
import gao.INTERFACE.Polymerize;

public class PolyAlpha extends ImperialPolymer {

	public PolyAlpha(String ID) {
		super(ID);
		Meson[] MS = new Meson[1];
		for(int i=0; i < MS.length; i++) {
			MS[i] = new Meson();
		}
		Boson[] BS = new Boson[1];
		for(int i=0; i < BS.length; i++) {
			BS[i] = new Boson();
		}
		Gluon[] GU = new Gluon[2];
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
	public void displayAlpha() {
		System.out.println("Poly Alpha");
		System.out.println("Mass:" + getMass());
		System.out.println();
		displayPolymer();

		
	}

}
