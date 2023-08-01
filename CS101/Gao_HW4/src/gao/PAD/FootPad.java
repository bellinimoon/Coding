package gao.PAD;

import gao.ENUM.Side;

public abstract class FootPad {
	public String serialNumber;
	public Side side;
	
	public FootPad() {
	}

	public FootPad(String serialNumber) {
		super();
		this.serialNumber = serialNumber;
	}

	public abstract boolean padCheck();

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

}
