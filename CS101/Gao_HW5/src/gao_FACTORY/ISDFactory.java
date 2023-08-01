package gao_FACTORY;

import java.util.ArrayList;

import gao_ISD.StarDestroyer;

public abstract class ISDFactory {
	private String name;
	private String buildType;
	private ArrayList<StarDestroyer> dryDock;

	public ISDFactory() {
	}

	public ISDFactory(String name) {
		super();
		this.name = name;
		this.dryDock = new ArrayList<>();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuildType() {
		return buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	public ArrayList<StarDestroyer> getDryDock() {
		return dryDock;
	}

	public void setDryDock(StarDestroyer dryDock) {
		this.dryDock.add(dryDock);
	}

	public abstract boolean buildISDs(int count);
	public abstract void displayISDs();
}
