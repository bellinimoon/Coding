package gao.PAD;

import gao.ENUM.Side;
import gao.ENUM.Status;

public class RightFootPad extends FootPad {

	private Status rightPadStatus;



	public RightFootPad() {
	}

	public RightFootPad(String serialNumber) {
		super(serialNumber);
		setSerialNumber("RFP-2");
		setSide(Side.RIGHT);
		this.rightPadStatus = Status.ONLINE;
	}
	
	public Status getRightPadStatus() {
		return rightPadStatus;
	}

	public void setRightPadStatus(Status Status) {
		rightPadStatus = Status;
	}

	@Override
	public boolean padCheck() {
		if(rightPadStatus == Status.ONLINE) {
			return true;
		}
		else {
			rightPadStatus = Status.OFFLINE;
			return false;
		}
	}

}
