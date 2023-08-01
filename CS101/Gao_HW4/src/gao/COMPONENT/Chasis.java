package gao.COMPONENT;

import gao.ENUM.Status;

public class Chasis {
	private String serialNumber;
	private double height;
	private double weight;
	private Status status;
	
	
	public Chasis() {
	}
	public Chasis(String serialNumber) {
		super();
		this.serialNumber = serialNumber;
		this.status = Status.ONLINE;
		if (serialNumber.charAt(1) == '3') {
			setHeight(4);
			setWeight(400);
		}
		else if (serialNumber.charAt(1) == '4') {
			setHeight(5);
			setWeight(500);
		}
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public boolean chasisCheck() {
		if (status == Status.ONLINE) {
			return true;
		}
		return false;
	}




}
