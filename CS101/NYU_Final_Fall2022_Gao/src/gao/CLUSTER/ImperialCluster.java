package gao.CLUSTER;

import gao.PARTICLE.AlphaParticle;
import gao.PARTICLE.BetaParticle;
import gao.PARTICLE.GammaParticle;

public abstract class ImperialCluster {
	private AlphaParticle[ ] aParts;
	private BetaParticle[ ] bParts;
	private GammaParticle[ ] cParts;

	public ImperialCluster() {
	}
	public abstract void displayCluster();
	public abstract double getTotalMass();
	
	public AlphaParticle[] getaParts() {
		return aParts;
	}
	public void setaParts(AlphaParticle[] aParts) {
		this.aParts = aParts;
	}
	public BetaParticle[] getbParts() {
		return bParts;
	}
	public void setbParts(BetaParticle[] bParts) {
		this.bParts = bParts;
	}
	public GammaParticle[] getcParts() {
		return cParts;
	}
	public void setcParts(GammaParticle[] cParts) {
		this.cParts = cParts;
	}


}
