package gao.INTERFACES;

public interface Pilotable {
	public default void piloting() {
		System.out.println("I am a Tie Pilot");
	}
}
