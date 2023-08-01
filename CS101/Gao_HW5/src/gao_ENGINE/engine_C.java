package gao_ENGINE;

public class engine_C extends ShipEngine {

	public engine_C() {
	}

	public engine_C(String starDestroyerType) {
		super("C", starDestroyerType, 225, 75, (int)Math.round(15*Math.pow(10, 6)), 125);
		if (starDestroyerType != "Imperial_I") {
			this.setLength(275);
			this.setHeight(80);
			this.setPower((int)Math.round(17*Math.pow(10, 6)));
		}
	}

}
