package gao.FACILITY;

import java.io.IOException;
import java.util.TreeMap;

import gao.CLASSES.ImperialDrone;
import gao.INTERFACES.DroneOperations;

public class DroneWharehouse {
	private String whName;
	private String storeFilePath;
	private TreeMap<String, ImperialDrone> storageBin;
	
	public DroneWharehouse(String whName, String storeFilePath) {
		super();
		this.whName = whName;
		this.storeFilePath = storeFilePath;
	}
	public boolean persistStoreDrone() {
		DroneFactory DF = new DroneFactory("Gao_FAC",DroneOperations.dir2+"DroneData",DroneOperations.dir2+"CleanDroneData");
		try {
			setStorageBin(DF.manufactureDrones());
		} catch (IOException e) {
			e.printStackTrace();
		}
        for(int i =0; i < getStorageBin().size() ; i++){
        	String key = String.valueOf(i);
            getStorageBin().get(key).storeDrone(getStoreFilePath());
        } 
        //return binary file?
		return true;
		
		
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getStoreFilePath() {
		return storeFilePath;
	}
	public void setStoreFilePath(String storeFilePath) {
		this.storeFilePath = storeFilePath;
	}
	public TreeMap<String, ImperialDrone> getStorageBin() {
		return storageBin;
	}
	public void setStorageBin(TreeMap<String, ImperialDrone> storageBin) {
		this.storageBin = storageBin;
	}
	


}
