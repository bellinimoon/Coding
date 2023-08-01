package gao.PARTICLE;

import gao.ENUMS.Charge;
import gao.ENUMS.Spin;
import gao.INTERFACE.Polymerize;

public class AlphaParticle extends ImperialParticle {
	

	public AlphaParticle() {
		super("Alpha", "AP", Polymerize.ALPHA_MASS, Polymerize.ALPHA_POWER, Charge.Positive, Spin.Left);
		
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
