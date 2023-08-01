package gao_ENGINE;

public class engine_S extends ShipEngine {

	public engine_S(String starDestroyerType) {
		super("S", starDestroyerType, 100, 50, (int)Math.round(8*Math.pow(10, 6)), 100);
		if (starDestroyerType != "Imperial_I") {
			this.setLength(115);
			this.setHeight(60);
			this.setPower((int)Math.round(9*Math.pow(10, 6)));
		}
	}

}
