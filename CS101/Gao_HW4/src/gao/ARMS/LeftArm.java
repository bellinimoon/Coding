package gao.ARMS;

import gao.ENUM.Limb;
import gao.ENUM.Side;
import gao.ENUM.Status;
import gao.PAD.LeftFootPad;

public class LeftArm extends Arm {
//	
//	private String serialNumber;
//	private Side side;
//	private Limb upper;
//	private Limb lower;
//	private FootPad pad;
	private Status status;
	private LeftFootPad pad;

	public LeftArm() {
	}

	public LeftArm(String serialNumber) {
		super(serialNumber);
		this.status = Status.ONLINE;
		setSerialNumber("LA-01");
		setSide(Side.LEFT);
		LeftFootPad newlf = new LeftFootPad(serialNumber);
		this.pad = newlf;
		setUpper(Limb.Upper);
		setLower(Limb.Lower);
		
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public boolean armCheck() {
		if(pad.getLeftPadStatus() == Status.ONLINE && status == Status.ONLINE) {
			return true;
		}
		else {
			status = Status.OFFLINE;
			return false;
		}
	}



}
