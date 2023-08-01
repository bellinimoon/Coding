package gao.FACTORY;

import java.util.ArrayList;

import gao.DROID.AstromechDroid;
import gao.INTERFACES.Displayable;

public abstract class DroidFactory implements Displayable {
	private String factoryID;
	private ArrayList<AstromechDroid> droidStorage;
	
	public DroidFactory() {
	}
	

	public DroidFactory(String factoryID) {
		super();
		this.factoryID = factoryID;
		this.droidStorage = new ArrayList<>();
	}
	
	public String getFactoryID() {
		return factoryID;
	}


	public void setFactoryID(String factoryID) {
		this.factoryID = factoryID;
	}


	public ArrayList<AstromechDroid> getDroidStorage() {
		return droidStorage;
	}


	public void setDroidStorage(AstromechDroid droidStorage) {
		this.droidStorage.add(droidStorage);
	}


	public abstract boolean buildDroids(int count);
	

}
