package gao.PAD;

import gao.ENUM.Side;
import gao.ENUM.Status;

public class LeftFootPad extends FootPad {

	private Status leftPadStatus;

	public LeftFootPad() {
	}

	public LeftFootPad(String serialNumber) {
		super(serialNumber);
		setSerialNumber("LFP-1");
		setSide(Side.LEFT);
		this.leftPadStatus = Status.ONLINE;
	}

	@Override
	public boolean padCheck() {
		if(leftPadStatus == Status.ONLINE) {
			return true;
		}
		else {
			leftPadStatus = Status.OFFLINE;
			return false;
		}
	}

	public Status getLeftPadStatus() {
		return leftPadStatus;
	}

	public void setLeftPadStatus(Status leftPadStatus) {
		this.leftPadStatus = leftPadStatus;
	}

}
