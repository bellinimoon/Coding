package gao.CLUSTER;

import gao.PARTICLE.AlphaParticle;
import gao.PARTICLE.BetaParticle;
import gao.PARTICLE.GammaParticle;
import gao.PARTICLE.ImperialParticle;

public class Trion extends ImperialCluster {
	private String Tname = "Trion";

	public Trion() {
		AlphaParticle[] AP = new AlphaParticle[1];
		for(int i=0; i < AP.length; i++) {
			AP[i] = new AlphaParticle();
		}
		BetaParticle[] BP = new BetaParticle[1];
		for(int i=0; i < BP.length; i++) {
			BP[i] = new BetaParticle();
		}
		GammaParticle[] CP = new GammaParticle[2];
		for(int i=0; i < CP.length; i++) {
			CP[i] = new GammaParticle();
		}
		setaParts(AP);
		setbParts(BP);
		setcParts(CP);
	}
	@Override
	public void displayCluster() {
		if(getaParts() != null){
			for (ImperialParticle A: (getaParts())){
				A.displayParticle();
			}
		}
		if(getbParts() != null){
			for (ImperialParticle B: (getbParts())){
				B.displayParticle();
			}
		}
		if(getcParts() != null){
			for (ImperialParticle C: (getcParts())){
				C.displayParticle();
			}
		}

	}

	@Override
	public double getTotalMass() {
		double mass = 0.0;
		if(getaParts() != null){
			for (ImperialParticle A: getaParts()){
				mass += A.getMass();
				
			}
		}
		if(getbParts() != null){
			for (ImperialParticle B: getbParts()){
				mass += B.getMass();
			}
		}
		if(getcParts() != null){
			for (ImperialParticle C: getcParts()){
				mass += C.getMass();
			}
		}

		return mass;
	}
	
	public String getTname() {
		return Tname;
	}

	public void setTname(String tname) {
		Tname = tname;
	}

	

}
