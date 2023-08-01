package gao.INTERFACE;


import gao.CLUSTER.Boson;
import gao.CLUSTER.Gluon;
import gao.CLUSTER.Meson;
import gao.CLUSTER.Trion;
import gao.POLYMER.ImperialPolymer;

public interface Polymerize {
	public static final double ALPHA_POWER = 1.5 * Math.pow(10, 6);
	public static final double BETA_POWER = 2.5 * Math.pow(10, 6);
	public static final double GAMMA_POWER = 3 * Math.pow(10, 6);
	public static final double ALPHA_MASS = 5 * Math.pow(10, -2);
	public static final double BETA_MASS = 10 * Math.pow(10, -2);
	public static final double GAMMA_MASS = 15 * Math.pow(10, -2);
	
	public static void calculateMass (ImperialPolymer p) {
		double mass = 0.0;
		if(p.getMesons() != null){
			for (Meson M: p.getMesons()){
				mass += M.getTotalMass();
			}
		}
		if(p.getBosons() != null){
			for (Boson B: p.getBosons()){
				mass += B.getTotalMass();
			}
		}
		if(p.getGluons() != null){
			for (Gluon G: p.getGluons()){
				mass += G.getTotalMass();
			}
		}
		if(p.getTrions() != null){
			for (Trion T: p.getTrions()){
				mass += T.getTotalMass();
			}
		}
//		DecimalFormat DF = new DecimalFormat("0.#");
//		double massClean = Double. parseDouble(DF.format(mass));
		p.setMass(mass);
	}

}
