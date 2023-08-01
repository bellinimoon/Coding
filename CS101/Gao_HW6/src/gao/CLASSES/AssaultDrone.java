package gao.CLASSES;

public class AssaultDrone extends ImperialDrone{
	
	private static final long serialVersionUID = 1L;
	private String assaultCode;
	private String ADV;

	public AssaultDrone(String droneID) {
		super(droneID, "Assault");
	}
	public String getAssaultCode() {
		return assaultCode;
	}
	public void setAssaultCode(String assaultCode) {
		this.assaultCode = assaultCode;
	}
	public String getADV() {
		return ADV;
	}
	public void setADV(String aDV) {
		ADV = aDV;
	}
	public void displayDroneSpecs() {
		super.displayDroneSpecs();
	}
}
