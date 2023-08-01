package gao.MAIN;

import java.util.ArrayList;

import gao.CLASSES.TieBomber;
import gao.CLASSES.TieFighter;
import gao.CLASSES.TieInterceptor;
import gao.ENUMS.TiePilot;
import gao.PART2.Part2;

public class Gao {

	public static void main(String[] args) {
		//PART 1
		ArrayList <TieFighter> TF = new ArrayList<TieFighter>();
		TieFighter TB = new TieBomber("TB-1", TiePilot.PilotTieBomber);
		TieFighter TI = new TieInterceptor("TI-1", TiePilot.PilotTieInterceptor);
		TF.add(TB);
		TF.add(TI);
		TieFighter TFf = TF.get(1);
		TieFighter.displayPilotInfo(TFf.getPilot());
		TFf.serializeMe("/Users/gaomengxian/eclipse-workspace/FinalReview/src/gao/STORAGE/TFStorage");
		TieFighter TFn = TFf.deserializeMe("/Users/gaomengxian/eclipse-workspace/FinalReview/src/gao/STORAGE/TFStorage");
		TieFighter.displayPilotInfo(TFn.getPilot());
		
		//PART 2
		int[][] inp = {{1,3,5},{6,5,7},{2,1,3}};
		int[][] inp2 = {{1,3,5},{6,5,7},{2,10,3},{3,5,2},{6,2,1}};
		char[][] inp3 = {{'a','x','w'},{'q','d','s'},{'z','c','v'}};
		char[][] inp4 = {{'a','x','w'},{'q','d','s'},{'z','c','v'},{'y','u','p'},{'m','j','k'}};
//		int[] result = Part2.getRowProduct(inp2);
//		String result = Part2.getCenterCorners(inp4);
		String result = Part2.columnsToString(inp3);
		
		System.out.println(result);
//		for(int i: result) {
//			System.out.println(i);
//			}
	}

}
