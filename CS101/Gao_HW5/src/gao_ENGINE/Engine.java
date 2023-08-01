package gao_ENGINE;

public class Engine {
	private String IDNumber;
	private ShipEngine[] Engines;


	public Engine(String iDNumber, String StarDestroyerType) {
		this.IDNumber = iDNumber;
		this.Engines = new ShipEngine[3];
		Engines[0] = new engine_S(StarDestroyerType);
		Engines[1] = new engine_C(StarDestroyerType);
		Engines[2] = new engine_S(StarDestroyerType);
	}
	 
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public ShipEngine[] getEngines() {
		return Engines;
	}
	public void setEngines(ShipEngine[] engines) {
		Engines = engines;
	}
	
	
	public void displayEngineSpecs() {
		System.out.println("");
		System.out.println("____Engine Specifications____");
		System.out.println("ENGINES: " + getIDNumber());
		System.out.println("Starboard Engine: Engine Type: " + getEngines()[0].getEngineType()+ "   Length: " + getEngines()[0].getLength()+ "   Height: " + getEngines()[0].getHeight() 
				+ "   Width: " +  getEngines()[0].getPower() + "   Weight: " +  getEngines()[0].getWeight());
		System.out.println("Center Engine: Engine Type: " + getEngines()[1].getEngineType()+ "   Length: " + getEngines()[1].getLength()+ "   Height: " + getEngines()[1].getHeight() 
				+ "   Power: " +  getEngines()[1].getPower() + "   Weight: " +  getEngines()[1].getWeight());
		System.out.println("Port Engine: Engine Type: " + getEngines()[0].getEngineType()+ "   Length: " + getEngines()[0].getLength()+ "   Height: " + getEngines()[0].getHeight() 
				+ "   Power: " +  getEngines()[0].getPower() + "   Weight: " +  getEngines()[0].getWeight());
		
	}

}
