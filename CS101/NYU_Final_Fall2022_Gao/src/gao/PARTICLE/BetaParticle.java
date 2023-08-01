package gao.PARTICLE;

import gao.ENUMS.Charge;
import gao.ENUMS.Spin;
import gao.INTERFACE.Polymerize;

public class BetaParticle extends ImperialParticle {

	public BetaParticle() {
		super("Beta", "BP", Polymerize.BETA_MASS, Polymerize.BETA_POWER, Charge.Negative, Spin.Right);
	}

	@Override
	public void displayParticle() {
		System.out.println(getpType() + " Particle");
		System.out.println("Symbol: " + getSymbol());
		System.out.println("Mass: " + getMass());
		System.out.println("Power: " + getPower());
		System.out.println("Charge: " + getCharge());
		System.out.println("Spin: " + getSpin());
		System.out.println();
	}

}
