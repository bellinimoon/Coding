package gao.DROID;

import gao.ARMS.LeftArm;
import gao.ARMS.RightArm;
import gao.COMPONENT.Chasis;
import gao.COMPONENT.SensorDome;
import gao.ENUM.Battery;
import gao.ENUM.Radar;
import gao.ENUM.Status;
import gao.INTERFACES.Droid;

public class R4 extends AstromechDroid implements Droid {
	private Status R4Status;
	private Battery R4Battery;
	private Radar R4Radar;

	public R4() {
	}

	public R4(String serialNumber) {
		super(serialNumber);
		this.R4Status = Status.ONLINE;
		this.R4Battery = Battery.R4;
		this.R4Radar = Radar.R4R;
		SensorDome sd = new SensorDome(serialNumber);
		setDome(sd);
		Chasis c = new Chasis(serialNumber);
		setChasis(c);		
		LeftArm la = new LeftArm(getSerialNumber());
		setLeftArm(la);
		RightArm ra = new RightArm(getSerialNumber());
		setRightArm(ra);
		setHeight(sd.getHeight() + c.getHeight());
		setWeight(sd.getHeight() + c.getHeight());
	}

	@Override
	public void displayDroid() {
		System.out.println("R4 Astromech");
		System.out.println("Serial Number: " + getSerialNumber());
		System.out.println("Status: " + getR4Status());
		System.out.println("Battery: " + getR4Battery().getType());
		System.out.println("Sensor Dome Serial Number: " + getDome().getSerialNumber());
		System.out.println("Chasis Serial Number: " + getChasis().getSerialNumber());
		System.out.println("Left Arm Serial Number: " + getLeftArm().getSerialNumber());
		System.out.println("Right Arm Serial Number: " +getRightArm().getSerialNumber());

	}

	public Status getR4Status() {
		return R4Status;
	}

	public void setR4Status(Status r4Status) {
		R4Status = r4Status;
	}

	public Battery getR4Battery() {
		return R4Battery;
	}

	public void setR4Battery(Battery r4Battery) {
		R4Battery = r4Battery;
	}

	public Radar getR4Radar() {
		return R4Radar;
	}

	public void setR4Radar(Radar r4Radar) {
		R4Radar = r4Radar;
	}

	@Override
	public void checkStatus() {
		if (getDome().getStatus() == Status.ONLINE && getChasis().getStatus() == Status.ONLINE && getLeftArm().getStatus() == Status.ONLINE && getRightArm().getStatus() == Status.ONLINE) {
			setR4Status(Status.ONLINE);
			System.out.println("R4 Astromech is ONLINE");
		}
		else {
			setR4Status(Status.OFFLINE);
			System.out.println("R4 Astromech is OFFLINE");
		}
	}

}
