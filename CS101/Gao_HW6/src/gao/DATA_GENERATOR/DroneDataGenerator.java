
package gao.DATA_GENERATOR;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class DroneDataGenerator {
	private String genName;
	private String storeDirectory;
	private String storeFile;

	public DroneDataGenerator(String genName, String storeDirectory, String storeFile) {
		super();
		this.genName = genName;
		this.storeDirectory = storeDirectory;
		this.storeFile = storeFile;
	}
	
	public String getGenName() {
		return genName;
	}

	public void setGenName(String genName) {
		this.genName = genName;
	}

	public String getStoreDirectory() {
		return storeDirectory;
	}

	public void setStoreDirectory(String storeDirectory) {
		this.storeDirectory = storeDirectory;
	}

	public String getStoreFile() {
		return storeFile;
	}

	public void setStoreFile(String storeFile) {
		this.storeFile = storeFile;
	}

	public String generateAssaultDroneString(int sn, int code, int value) {
        String st_value = String.format("%03d", value);
        String st_code = String.format("%03d", code);
		String st = "Assault Drone,";
		st += "Drone ID:, AD-" + sn;
		st += ",Assault Code:, AS-" + st_code;
		st += ",ADV:, A0" + st_value;
		return st;
	}
	public String generateStrikeDroneString(int sn, int code, int value) {
        String st_value = String.format("%03d", value);
        String st_code = String.format("%03d", code);
		String st = "Strike Drone,";
		st += "Drone ID:, SD-" + sn;
		st += ",Strike Code:, SS-" + st_code;
		st += ",SDV:, S0" + st_value;
		return st;
	}
	public String generateReconDroneString(int sn, int code, int value) {
        String st_value = String.format("%03d", value);
        String st_code = String.format("%03d", code);
		String st = "Recon Drone,";
		st += "Drone ID:, RD-" + sn;
		st += ",Recon Code:, RS-" + st_code;
		st += ",RDV:, R0" + st_value;
		return st;
	}
	
//	while(countTemp <= count) {
//        int value = rd.nextInt(1000);
//        int code = rd.nextInt(1000);
//        int value2 = rd.nextInt(1000);
//        int code2 = rd.nextInt(1000);
//        int value3 = rd.nextInt(1000);
//        int code3 = rd.nextInt(1000);
//        ct++;
//   		bw.write(generateAssaultDroneString(ct, code, value) + "\n");
//   		countTemp++;
//   		ct++;
//   		bw.write(generateStrikeDroneString(ct, code2, value2) + "\n");
//   		countTemp++;
//   		ct++;
//   		bw.write(generateReconDroneString(ct, code3, value3) + "\n");
//   		countTemp++;
//		}
	public void generateDroneData(int count) {
		Random rd = new Random();  
		int ct = 0;
	    try (FileWriter loc = new FileWriter(getStoreDirectory()+getStoreFile());
	       		BufferedWriter bw = new BufferedWriter(loc)) {
	    		for(int i = 0; i < count; i ++) {
	    	        int value = rd.nextInt(1000);
	    	        int code = rd.nextInt(1000);
	    	        int value2 = rd.nextInt(1000);
	    	        int code2 = rd.nextInt(1000);
	    	        int value3 = rd.nextInt(1000);
	    	        int code3 = rd.nextInt(1000);
	    	        ct++;
		       		bw.write(generateAssaultDroneString(ct, code, value) + "\n");
		       		bw.write(generateStrikeDroneString(ct, code2, value2) + "\n");
		       		bw.write(generateReconDroneString(ct, code3, value3) + "\n");
		    		}
	       	} catch (IOException e) {
	       		return;
	       	}
			
		}
	}

