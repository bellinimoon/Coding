package gao.DROID;

import gao.ARMS.LeftArm;
import gao.ARMS.RightArm;
import gao.COMPONENT.Chasis;
import gao.COMPONENT.SensorDome;
import gao.ENUM.Battery;
import gao.ENUM.Status;
import gao.INTERFACES.Droid;

public class R3 extends AstromechDroid implements Droid {
	private Status R3Status;
	private Battery R3Battery;
	

	public R3() {
	}

	public R3(String serialNumber) {
		super(serialNumber);
		this.setSerialNumber(serialNumber);
		this.R3Status = Status.ONLINE;
		this.R3Battery = Battery.R3;

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

	public Status getR3Status() {

		return R3Status;
	}

	public void setR3Status(Status r3Status) {
		R3Status = r3Status;
	}

	public Battery getR3Battery() {
		return R3Battery;
	}

	public void setR3Battery(Battery r3Battery) {
		R3Battery = r3Battery;
	}

	@Override
	public void displayDroid() {
		System.out.println("R3 Astromech");
		System.out.println("Serial Number: " + getSerialNumber());
		System.out.println("Status: " + getR3Status());
		System.out.println("Battery: " + getR3Battery().getType());
		System.out.println("Sensor Dome Serial Number: " + getDome().getSerialNumber());
		System.out.println("Chasis Serial Number: " + getChasis().getSerialNumber());
		System.out.println("Left Arm Serial Number: " + getLeftArm().getSerialNumber());
		System.out.println("Right Arm Serial Number: " +getRightArm().getSerialNumber());
	}

	@Override
	public void checkStatus() {
		if (getDome().getStatus() == Status.ONLINE && getChasis().getStatus() == Status.ONLINE && getLeftArm().getStatus() == Status.ONLINE && getRightArm().getStatus() == Status.ONLINE) {
			setR3Status(Status.ONLINE);
			System.out.println("R3 Astromech is ONLINE");
		}
		else {
			setR3Status(Status.OFFLINE);
			System.out.println("R3 Astromech is OFFLINE");
		}

	}


}
