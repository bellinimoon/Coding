package gao_MAIN;


import gao_FACTORY.ISD1_Factory;
import gao_FACTORY.ISDFactory;
import gao_ISD.StarDestroyer;

public class Annabeth {

	public static void main(String[] args) {

		ISDFactory fac = new ISD1_Factory("Star Destroyer");
		fac.buildISDs(1);
		for(StarDestroyer st: fac.getDryDock()) {
			st.displayInfo();
		}


	}

}
