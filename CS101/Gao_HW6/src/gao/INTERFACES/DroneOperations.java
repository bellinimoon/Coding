
package gao.INTERFACES;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import gao.CLASSES.ImperialDrone;

public interface DroneOperations {
	public static final String dir = "/Users/gaomengxian/eclipse-workspace/Gao_HW6/src/gao/STORAGE/";
	public static final String dir2 = "/Users/gaomengxian/eclipse-workspace/Gao_HW6/src/gao/DATA/";
	
	public default void storeDrone(String filename) {
		try {
			ObjectOutputStream Sout = new ObjectOutputStream(new FileOutputStream(filename));
			Sout.writeObject(this);
			Sout.flush();
			Sout.close();
			//System.out.println("Stromtrooper Stored");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public static ImperialDrone retrieveDrone(String filename) {
		ImperialDrone IP = null;
		try {
			ObjectInputStream Sin = new ObjectInputStream(new FileInputStream(filename));
			IP = (ImperialDrone) Sin.readObject();
			Sin.close();
		}catch(Exception e){
			System.out.println(e);	
			
		}
		return IP;
	}
	public static TreeMap<String, ImperialDrone> buildAllDrones(String filename) {
        TreeMap<String, ImperialDrone> newStorage = new TreeMap<String, ImperialDrone>();
        ImperialDrone newID = retrieveDrone(filename);
        newStorage.put(newID.getDroneType(), newID);
		return newStorage;
	}

}
