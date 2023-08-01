package gao.MAIN;

import gao.POLYMER.PolyAlpha;
import gao.POLYMER.PolyBeta;
import gao.POLYMER.PolyGamma;

public class Annabeth {

	public static void main(String[] args) {

		PolyAlpha pa = new PolyAlpha("Annabeth_Alpha");
		pa.displayAlpha();
		System.out.println();
		
		PolyBeta ba = new PolyBeta("Annabeth_Beta");
		ba.displayBeta();
		System.out.println();
	
		PolyGamma pg = new PolyGamma("Annabeth_Gamma");
		pg.displayGamma();
		System.out.println();
		

	}

}
