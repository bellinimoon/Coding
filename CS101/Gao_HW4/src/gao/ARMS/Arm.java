package gao.ARMS;

import gao.ENUM.Limb;
import gao.ENUM.Side;
import gao.PAD.FootPad;

public abstract class Arm {
	private String serialNumber;
	private Side side;
	private Limb upper;
	private Limb lower;
	private FootPad pad;

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

	public Limb getUpper() {
		return upper;
	}

	public void setUpper(Limb upper) {
		this.upper = upper;
	}

	public Limb getLower() {
		return lower;
	}

	public void setLower(Limb lower) {
		this.lower = lower;
	}

	public FootPad getPad() {
		return pad;
	}

	public void setPad(FootPad pad) {
		this.pad = pad;
	}

	public Arm() {
	}

	public Arm(String serialNumber) {
		super();
		this.serialNumber = serialNumber;
	}
	public abstract boolean armCheck();
}
