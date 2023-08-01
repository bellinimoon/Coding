package gao.MAIN;
import java.util.Arrays;


public class Task {
	
	public static String[] part_e(String[][] input) {
		String[] newSt = new String[10];
		int index = 0;
		for(int n=0; n<20; n+=2) {
			int length = input[n][0].length();
			newSt[index] = "" + input[n][0].charAt(0)+input[n][0].charAt(length-1);
			index++;
		}
		return newSt;
		}
	
	public static String[] part_d(String[][] input) {
		String[] newSt = new String[10];
		int index = 0;
		for(int n=0; n<20; n+=2) {
			newSt[index] = input[n][5]+ input[n][5].charAt(0)+input[n][5].charAt(1)+input[n][5].charAt(2);
			index++;
		}

		return newSt;
		}
	
	
	public static String[] part_c(String[][] input) {
		String[] newSt = new String[10];
		
		int index = 0;
		for(int n=0; n<20; n+=2) {
			newSt[index] = input[n][2]+"***" +input[n][3]+"***" +input[n][4]+"***" ;
			index++;
		}

		return newSt;
	}
	
	public static String[] part_b(String[][] input){
		String[] newSt = new String[10];
		String[] returnSt = new String[10];
		int index = 0;
		for(int n=0; n<20; n+=2) {
			newSt[index] = input[n][1];
			index++;
		}
		int index2 = 0;
		for(String i:newSt) {
			returnSt[index2] = ""+ i.charAt(1) + " " + i.charAt(5) + " " + i.charAt(9);
			index2++;
		}

		return returnSt;
	}
	
	public static String[] part_f(String[][]input) {
		String[] line_num = new String[10];
		for(int n=0; n<10; n++) {
			line_num[n] = "...Line_"+String.valueOf(n);
		}
		return line_num;
		
	}
	

	public static String[] part_a() {
		String[] line_num = new String[10];
		for(int n=0; n<10; n++) {
			line_num[n] = "Line_"+String.valueOf(n);
		}
		return line_num;
		
	}
//	public static String[][] copy(String[][] input) {
//	    String[][] dst = new String[input.length][input[0].length];
//	    for (int i = 0; i < input.length; i++) {
//	        dst[i] = Arrays.copyOf(input[i], input[i].length);
//	    }
//	    return dst;
//	}
	
	public static void version_8(String[][]input) {
		int index = 0;
//		String[][] copy1 = copy(input);
//		String[][] copy2 = copy(copy1);
//		String[][] copy3 = copy(input);
		for(int n = 0; n<10; n++) {
			System.out.print("Line_"+String.valueOf(n)+"\t");
			System.out.print(part_b(input)[n]+"\t");
			System.out.print(part_c(input)[n]+"\t");
			System.out.print(part_d(input)[n]+"\t");
			System.out.print(part_e(input)[n]+"\t");
			System.out.print(part_f(input)[n]+"\t");
			System.out.print("\n");
		}
}	
		
	

}
