package gao.CLUSTER;

import gao.PARTICLE.AlphaParticle;
import gao.PARTICLE.BetaParticle;
import gao.PARTICLE.ImperialParticle;

public class Boson extends ImperialCluster {
	private String Bname = "Boson";

	public Boson() {
		AlphaParticle[] AP = new AlphaParticle[2];
		for(int i=0; i < AP.length; i++) {
			AP[i] = new AlphaParticle();
		}
		BetaParticle[] BP = new BetaParticle[1];
		for(int i=0; i < BP.length; i++) {
			BP[i] = new BetaParticle();
		}
		setaParts(AP);
		setbParts(BP);
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

	public String getBname() {
		return Bname;
	}

	public void setBname(String bname) {
		Bname = bname;
	}
	

}
