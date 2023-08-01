package gao.FACILITY;

import java.io.IOException;

import gao.DATA_GENERATOR.DroneDataGenerator;

public class ImperialDroneFacility {
	private String facilityName;
	private DroneFactory facilityFactory;
	private DroneWharehouse facilityWharehouse;
	private DroneDataGenerator facilityGenerator;
	public ImperialDroneFacility(String facilityName, DroneFactory facilityFactory, DroneWharehouse facilityWharehouse,
			DroneDataGenerator facilityGenerator) {
		super();
		this.facilityName = facilityName;
		this.facilityFactory = facilityFactory;
		this.facilityWharehouse = facilityWharehouse;
		this.facilityGenerator = facilityGenerator;
	}

	public boolean ProduceAndStoreDrones(int count) throws IOException {
		getFacilityGenerator().generateDroneData(count);
		getFacilityFactory().manufactureDrones();
		getFacilityFactory().cleanDataFile();
		getFacilityWharehouse().persistStoreDrone();	
		return getFacilityWharehouse().persistStoreDrone();
		
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public DroneFactory getFacilityFactory() {
		return facilityFactory;
	}
	public void setFacilityFactory(DroneFactory facilityFactory) {
		this.facilityFactory = facilityFactory;
	}
	public DroneWharehouse getFacilityWharehouse() {
		return facilityWharehouse;
	}
	public void setFacilityWharehouse(DroneWharehouse facilityWharehouse) {
		this.facilityWharehouse = facilityWharehouse;
	}
	public DroneDataGenerator getFacilityGenerator() {
		return facilityGenerator;
	}
	public void setFacilityGenerator(DroneDataGenerator facilityGenerator) {
		this.facilityGenerator = facilityGenerator;
	}
	
	

}
