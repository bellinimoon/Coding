package gao.MAIN;

import java.io.IOException;
import gao.CLASSES.ImperialDrone;
import gao.DATA_GENERATOR.DroneDataGenerator;
import gao.FACILITY.DroneFactory;
import gao.FACILITY.DroneWharehouse;
import gao.FACILITY.ImperialDroneFacility;
import gao.INTERFACES.DroneOperations;

public class Annabeth {

	public static void main(String[] args) throws IOException {
		DroneDataGenerator DG = new DroneDataGenerator("Gao_1",DroneOperations.dir2, "DroneData");
		DroneFactory DF= new DroneFactory("Gao_FAC",DroneOperations.dir2+"DroneData",DroneOperations.dir2+"CleanDroneData");
		DroneWharehouse DWH = new DroneWharehouse("Gao_WH",DroneOperations.dir+"DStore");
		
		ImperialDroneFacility IDF = new ImperialDroneFacility("Gao_IDF", DF, DWH, DG);
		IDF.ProduceAndStoreDrones(100);
		
		
		ImperialDrone ID = DroneOperations.retrieveDrone(IDF.getFacilityWharehouse().getStoreFilePath());
		ID.displayDroneSpecs();
		
		
		
		
	}

}
