package gao.ARMS;

import gao.ENUM.Limb;
import gao.ENUM.Side;
import gao.ENUM.Status;
import gao.PAD.RightFootPad;

public class RightArm extends Arm {
	private Status status;
//	private String serialNumber;
//	private Side side;
//	private Limb upper;
//	private Limb lower;
	private RightFootPad pad;

	public RightArm() {
	}

	public RightArm(String serialNumber) {
		super(serialNumber);
		this.status = Status.ONLINE;
		setSerialNumber("RA-02");
		setSide(Side.RIGHT);
		RightFootPad newrf = new RightFootPad(serialNumber);
		this.pad = newrf;
		setUpper(Limb.Upper);
		setLower(Limb.Lower);
		
	}


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public RightFootPad getPad() {
		return pad;
	}

	public void setPad(RightFootPad pad) {
		this.pad = pad;
	}

	@Override
	public boolean armCheck() {
		if(pad.getRightPadStatus() == Status.ONLINE && status == Status.ONLINE) {
			return true;
		}
		else {
			status = Status.OFFLINE;
			return false;
		}
	}
}
