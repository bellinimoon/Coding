package gao.CLASSES;

public class StrikeDrone extends ImperialDrone {
	private static final long serialVersionUID = 1L;
	private String strikeCode;
	private String SDV;
	
	public StrikeDrone(String droneID) {
		super(droneID, "Strike");
	}
	
	public String getStrikeCode() {
		return strikeCode;
	}

	public void setStrikeCode(String strikeCode) {
		this.strikeCode = strikeCode;
	}

	public String getSDV() {
		return SDV;
	}

	public void setSDV(String sDV) {
		SDV = sDV;
	}


	public void displayDroneSpecs() {
		super.displayDroneSpecs();
	}

}
