package gao.FACILITY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

import gao.CLASSES.AssaultDrone;
import gao.CLASSES.ImperialDrone;
import gao.CLASSES.ReconDrone;
import gao.CLASSES.StrikeDrone;

public class DroneFactory {
	private String facName;
	private String dataFilePath;
	private String cleanDataFile;

	public DroneFactory() {
	}
	
	public DroneFactory(String facName, String dataFilePath, String cleanDataFile) {
		super();
		this.facName = facName;
		this.dataFilePath = dataFilePath;
		this.cleanDataFile = cleanDataFile;
	}
	
	public void cleanDataFile() throws IOException {
		String newLoc = getCleanDataFile();
		;
		BufferedReader BR = new BufferedReader(new FileReader (getDataFilePath()));
		String line = "";
		String clean = "";
		while((line = BR.readLine())!= null) {
			line.replaceAll(",","");
		    String[] sep = line.split("[,]", 7);
		    	String combine = "";
		       for(int i = 0; i<sep.length; i+=2) {
		          combine += sep[i];
		       }
			clean += combine + "\n";
		}
		BR.close();
	    try (FileWriter loc = new FileWriter(newLoc);
	       	BufferedWriter bw = new BufferedWriter(loc)) {
		    bw.write(clean);
	       	} catch (IOException e) {
	       		return;
	       	}

	}
	
	public TreeMap< String, ImperialDrone> manufactureDrones() throws IOException{
		TreeMap< String, ImperialDrone> tm = new TreeMap< String, ImperialDrone>();
		BufferedReader BR = new BufferedReader(new FileReader (getCleanDataFile()));
		String line = "";
		int count = 0;
		while((line = BR.readLine())!= null) {
			line.replaceAll(",","");
		    String[] sep = line.split(" "); 
		    if (sep[0].contains("Assault")) {
		    	ImperialDrone newDrone = new AssaultDrone(sep[2]);
		    	tm.put(String.valueOf(count), newDrone);
		    }else if (sep[0].contains("Strike")){
		    	ImperialDrone newDrone = new StrikeDrone(sep[2]);
		    	tm.put(String.valueOf(count), newDrone);
		    }else if(sep[0].contains("Recon")) {
		    	ImperialDrone newDrone = new ReconDrone(sep[2]);
		    	tm.put(String.valueOf(count), newDrone);
		    }
		    count++;
		}
		BR.close();
		
		return tm;
		
	}

	public String getFacName() {
		return facName;
	}

	public void setFacName(String facName) {
		this.facName = facName;
	}

	public String getDataFilePath() {
		return dataFilePath;
	}

	public void setDataFilePath(String dataFilePath) {
		this.dataFilePath = dataFilePath;
	}

	public String getCleanDataFile() {
		return cleanDataFile;
	}

	public void setCleanDataFile(String cleanDataFile) {
		this.cleanDataFile = cleanDataFile;
	}



}
