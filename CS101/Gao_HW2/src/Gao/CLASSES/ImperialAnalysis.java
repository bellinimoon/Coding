
package Gao.CLASSES;

public class ImperialAnalysis {
	public static void displayMissionData(String[][] data) {
		System.out.println("__________Imperial Tie Fighter Pilot Status Report__________");
		System.out.println("                                             ***************KILLS*************************");
		System.out.println("Pilot        Call Sign         Missions        Fighter     "
				+ "    Bomber          Assault Fighter");
	
		for (String[] p : data) {
			String[] split = p[0].split("_");
			p[0] = split[0]+"         "+split[1];

			for (String s : p) {
				System.out.print(String.format("%-2s",s) + "              ");
			}
			System.out.println("");
			int sumOfKiller = (int)(convertToDouble(p[2])+convertToDouble(p[3])+convertToDouble(p[4]));
			int mission = (int)(convertToDouble(p[1]));
			double missionskills = missionsKillsRatio(sumOfKiller,mission);
			double missionskills_r = Double.valueOf(String.format("%-3.2f",missionskills));
			double fighter = fighterKillPoints(convertToDouble(p[2]));
			double bomber = bomberKillPoints(convertToDouble(p[3]));
			double assault = assaultFighterPoints(convertToDouble(p[4]));
			double[] Points = {fighter,bomber, assault};
			String pilotValue = pilotValue(missionskills_r, Points);
			
			
			System.out.print("                               "
					+ "Mission Kill Ratio: ");
			System.out.print(String.format("%-3.2f",missionskills));
			System.out.print("\n                               "
					+ "Fighter Kill Points: ");
			System.out.print(fighter);
			System.out.print(" Bomber Kill Points: " + bomber+
					" Assault Fighter Kill Points: " + assault + "\n");
			System.out.println("                               "
					+ "Total kill Points: " + (fighter + bomber + assault));
			System.out.println("                               "
					+ "Pilot Value: " + pilotValue);
			System.out.println("                               "
					+ "Pilot rating: " + pilotRating(Double.valueOf(pilotValue)));
			System.out.println("\n");
		}

	}
	
	public static String pilotRating(double pv) {
		String rating = "";
		if (pv > 20) {
			rating = "Elite";
		}
		else if(pv > 12 && pv <= 20) {
			rating = "Veteran";
		}
		else if(pv <= 12) {
			rating = "Standard";
		}
		return rating;
	}
	
	public static String pilotValue(double mkRatio, double[] killPoints){
		double sum = 0;
		for (double n: killPoints) {
			sum += n;
		}
		double d = mkRatio * sum;
		String s = String.format("%-3.2f", d);
		return s;
	}
	
	public static double missionsKillsRatio(int kills, int missions) {
		double killsD = Double.valueOf(kills);
		double missionsD = Double.valueOf(missions);
		double d = killsD / missionsD;
		return d;
	}
	
	public static double assaultFighterPoints(double kills) {
		double d = kills * 1.25;
		return d;
	}
	
	public static double bomberKillPoints(double kills) {
		double d = kills * 1.5;
		return d;
	}
	
	public static double fighterKillPoints(double kills) {
		double d = kills * 1.75;
		return d;
	}

	public static double convertToDouble(String s) {
		double d = 0;
	    try {
	        d = Double.parseDouble(s);
	    } 
	    catch (NumberFormatException nfe) {
	        System.out.println("The number is not valid.");
	    }
		return d;
	}

}
