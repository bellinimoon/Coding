package gao.ENUMS;

import gao.INTERFACES.Pilotable;

public enum TiePilot implements Pilotable {
	PilotTieBomber("Bomber Pilot" ,"Veteran"),
	PilotTieInterceptor("Interceptor Pilot" ,"Elite");
	
	private String pilotType;
	private String pilotRating;
	
	public String getPilotType() {
		return pilotType;
	}

	public void setPilotType(String pilotType) {
		this.pilotType = pilotType;
	}

	public String getPilotRating() {
		return pilotRating;
	}

	public void setPilotRating(String pilotRating) {
		this.pilotRating = pilotRating;
	}

	private TiePilot(String pilotType, String pilotRating) {
		this.pilotType = pilotType;
		this.pilotRating = pilotRating;
	}

}
