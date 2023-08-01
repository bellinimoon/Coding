package gao.MAIN;

import java.text.DecimalFormat;

public class GaoHW1 {

	public static void main(String[] args) {
		// array of coordinates of the points
		int [] ST1 = {1,5};
		int [] ST2 = {2,4};
		int [] ST3 = {1,3};
		int [][] ST = {ST1,ST2,ST3};

		int [] A = {3,1};
		int [] B = {4,3};
		int [] C = {5,5};
		int [] D = {7,3};
		int [] E = {6,1};
		int [] F = {9,5};
		int [] G = {8,1};	
		int [] R1 = {11,5};
		int [] R2 = {10,1};
		int [][] POINT2 = {A,B,C,D,E,F,G};	
		int [][] POINT = {A,B,C,D,E,F,G,R1,R2};	
		int [][] R = {R1,R2};
		//values reserved for calculations	
		//distance
		double ST1C = 0;
		double ST2B = 0;
		double ST3A = 0;
		double CD = 0;
		double DF = 0;
		double FR1 = 0;
		double BE = 0;
		double EG = 0;
		double GR2 = 0;
		double AD = 0;
		//time
		double ST1C_t = 0;
		double ST2B_t = 0;
		double ST3A_t = 0;
		double CD_t = 0;
		double DF_t = 0;
		double FR1_t = 0;
		double BE_t = 0;
		double EG_t = 0;
		double GR2_t = 0;
		double AD_t = 0;
		
		//print title for task 1
		String space = String.format("%"+30+"s", "");
		System.out.format("TEAM"+ space +"DIRECT EUCLIDEAN DISTANCE AND TIME TO\n", "");
		//Point names	
		String [] POST = {"CP A","CP B","CP C","CP D","CP E","CP F","CP G","R1 "," R2 ",};
		for (String name : POST) {
			space = String.format("%"+10+"s", "");
			System.out.format(space + name, "");
		}
		
		//Loops from ST to other points
		for(int n = 0; n<3; n++) {
			//distance	
			System.out.print("\nST"+(n+1) + "       ");
			int counter = 0;
			for (int[]i : POINT) {	
				double distanceXsqr = Math.pow(ST[n][0]- i[0], 2);
				double distanceYsqr = Math.pow(ST[n][1]- i[1], 2);
				double distance = Math.sqrt(distanceXsqr + distanceYsqr);
				space = String.format("%"+6+"s", "");
				System.out.format(String.format("%-5.2f",distance)+ " km" + space, "");
				//Calculate distance between certain points
				if (n == 0 && counter == 2) {
					ST1C = Double.parseDouble(String.format("%-5.2f",distance));
				}
				if (n == 1 && counter == 1) {
					ST2B = Double.parseDouble(String.format("%-5.2f",distance));
				}
				if (n == 2 && counter == 0) {
					ST3A = Double.parseDouble(String.format("%-5.2f",distance));
				}
				counter ++;
			}
			//time
			System.out.print("\n          ");
			int counter2 = 0;
			for (int[]i : POINT) {
				double distanceXsqr = Math.pow(ST[n][0]- i[0], 2);
				double distanceYsqr = Math.pow(ST[n][1]- i[1], 2);
				double distance = Math.sqrt(distanceXsqr + distanceYsqr);
				space = String.format("%"+6+"s", "");
				long time = Math.round(distance * 20);
				System.out.format(String.format("%-3d",time)+ " mins" + space, "");
				// calculate specified values for the routes
				if (n == 0 && counter2 == 2) {
					ST1C_t = Double.parseDouble(String.format("%-3d",time));

				}
				if (n == 1 && counter2 == 1) {
					ST2B_t = Double.parseDouble(String.format("%-3d",time));
				}
				if (n == 2 && counter2 == 0) {
					ST3A_t = Double.parseDouble(String.format("%-3d",time));
				}
				counter2 ++;
			}	
			System.out.print("\n\n");
			}
		
		//print title for second task
		space = String.format("%"+30+"s", "");
		System.out.format("\nCHECKPOINT"+ space +"EUCLIDEAN DISTANCE AND MOVEMENT TIME TO\n", "");	
		//Point names
		String [] POST2 = {"CP A","CP B","CP C","CP D","CP E","CP F","CP G"};
		for (String name : POST2) {
			space = String.format("%"+10+"s", "");
			System.out.format(space + name, "");
		}
		//From a point to other points
		for(int n = 0; n< POINT2.length; n++) {
			//distance	
			System.out.print("\n"+POST2[n] + "      ");
			int counter3 = 0;
			for (int[]i : POINT2) {
				double distanceXsqr = Math.pow(POINT2[n][0]- i[0], 2);
				double distanceYsqr = Math.pow(POINT2[n][1]- i[1], 2);
				double distance = Math.sqrt(distanceXsqr + distanceYsqr);
				space = String.format("%"+6+"s", "");
				System.out.format(String.format("%-5.2f",distance)+ " km" + space, "");
				if (n == 2 && counter3 == 3) {
					CD = Double.parseDouble(String.format("%-5.2f",distance));
				}
				if (n == 3 && counter3 == 5) {
					DF = Double.parseDouble(String.format("%-5.2f",distance));
				}
				if (n == 1 && counter3 == 4) {
					BE = Double.parseDouble(String.format("%-5.2f",distance));
				}
				if (n == 4 && counter3 == 6) {
					EG = Double.parseDouble(String.format("%-5.2f",distance));
				}
				if (n == 0 && counter3 == 3) {
					AD = Double.parseDouble(String.format("%-5.2f",distance));
				}
				counter3 ++;
			}
			//time
			System.out.print("\n          ");
			int counter4 = 0;
			for (int[]i : POINT2) {
				double distanceXsqr = Math.pow(POINT2[n][0]- i[0], 2);
				double distanceYsqr = Math.pow(POINT2[n][1]- i[1], 2);
				double distance = Math.sqrt(distanceXsqr + distanceYsqr);
				space = String.format("%"+6+"s", "");
				long time = Math.round(distance * 20);
				System.out.format(String.format("%-3d",time)+ " mins" + space, "");
				if (n == 2 && counter4 == 3) {
					CD_t = Double.parseDouble(String.format("%-3d",time));
				}
				if (n == 3 && counter4 == 5) {
					DF_t = Double.parseDouble(String.format("%-3d",time));
				}
				if (n == 1 && counter4 == 4) {
					BE_t = Double.parseDouble(String.format("%-3d",time));
				}
				if (n == 4 && counter4 == 6) {
					EG_t = Double.parseDouble(String.format("%-3d",time));
				}
				if (n == 0 && counter4 == 3) {
					AD_t = Double.parseDouble(String.format("%-3d",time));
				}
				counter4 ++;
			}
			System.out.print("\n");
		}
		
		//from points to enemy
		for(int x = 0; x< R.length; x++) {
			//distance	
			int counter5 = 0;
			for (int[]i : POINT2) {
				double distanceXsqr = Math.pow(R[x][0]- i[0], 2);
				double distanceYsqr = Math.pow(R[x][1]- i[1], 2);
				double distance = Math.sqrt(distanceXsqr + distanceYsqr);
				space = String.format("%"+6+"s", "");
				if (x == 0 && counter5 == 5) {
					FR1 = Double.parseDouble(String.format("%-5.2f",distance));
				}
				if (x == 1 && counter5 == 6) {
					GR2 = Double.parseDouble(String.format("%-5.2f",distance));
				}
				counter5 ++;
			}	
			//time
			int counter6 = 0;
			for (int[]i : POINT2) {
				double distanceXsqr = Math.pow(R[x][0]- i[0], 2);
				double distanceYsqr = Math.pow(R[x][1]- i[1], 2);
				double distance = Math.sqrt(distanceXsqr + distanceYsqr);
				space = String.format("%"+6+"s", "");
				long time = Math.round(distance * 20);
				if (x == 0 && counter6 == 5) {
					FR1_t = Double.parseDouble(String.format("%-3d",time));
				}
				if (x == 1 && counter6 == 6) {
					GR2_t = Double.parseDouble(String.format("%-3d",time));
				}
				counter6 ++;
			}
		System.out.print("\n");
		}

		
		//task 3
		//controlling the decimals
		DecimalFormat df = new DecimalFormat("#.##");
		space = String.format("%"+15+"s", ""); 
		System.out.format("\nTEAM" + space + "ROUTE"+ space + "TOTAL DISTANCE" + space + "TOTAL TIME\n", "");
		space = String.format("%"+16+"s", ""); 
		System.out.print("ST1"+ space +"C to D to F to R1");
		System.out.print("   " +df.format(ST1C+CD+DF+FR1)+" km"+space+"     "+(ST1C_t+CD_t+DF_t+FR1_t)+ " mins\n");
		System.out.print("ST2"+ space +"B to E to G to R2");
		System.out.print("   " + df.format(ST2B+BE+EG+GR2)+" km"+space+"      "+(ST2B_t+BE_t+EG_t+GR2_t)+ " mins\n");
		System.out.print("ST3"+ space +"A to D to F to R1");
		System.out.print("   " +df.format(ST3A+AD+DF+FR1)+" km"+space+"     "+(ST3A_t+AD_t+DF_t+FR1_t)+ " mins\n");
		
	}

}
