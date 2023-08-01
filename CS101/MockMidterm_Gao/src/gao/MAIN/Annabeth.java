package gao.MAIN;

public class Annabeth {
	public static char st = ' ';
	public static int bool = 0;
	
	public static String[] toOneD(String[][]inputString) {
		String[] sep = new String[inputString.length * inputString[0].length];
		int count = 0;
		for(int n = 0; n<inputString[0].length; n++) {
			for(String[] s:inputString) {
				sep[count] = s[n];
				count++;
			}
		}
		for (String s: sep) {
			System.out.println(s);
			}
		
		return sep;
	}
	
	public static boolean allSame(String s){
	    int n = s.length();
	    for (int i = 1; i < n; i++) {
	        if (s.charAt(i) != s.charAt(0))
	            return false;
	    }
	    return true;
	}
	
	public static boolean allSameArray(String[] s){
		boolean bl = true;
	    for (int i = 1; i < s.length; i++) {
	        if (s[i] != s[0])
		    	
	            bl = false;
	    }
	    return bl;
	}	
	
	public static boolean dia(String[][] inputString) {
		boolean b = false;
		String select ="";
		String select2 ="";
		for(int i = 0; i< inputString.length; i++) {
			for(int j = 0; j < inputString[0].length; j++) {
				if (i == j) {
				select += inputString[i][j];
				select2 += inputString[i][(inputString[0].length-1)-j];
				}
			}
		}
		if (allSame(select)) {
			b = true; 
			st = select.charAt(0);
		}
		else if(allSame(select2)) {
			b = true; 
			st = select2.charAt(0);
		}
		return b;
	}
	
	public static boolean row(String[][] inputString) {
		boolean b_final2 = false;
		int i = 0;
		for (String[] s: inputString) {
			if (allSameArray(s) != true) {
			}
			else{
				i++;
				st = s[0].charAt(0);
				b_final2 = true;
			}
		}
		if (i > 1) {
			bool = 1;
		}
		return b_final2;
	}
	
	public static boolean col(String[][] inputString) {
		boolean b = true;
		boolean b_final = false;
		int turns = 0;
		for (int i = 0; i<inputString.length; i++) {
			b = true;
			for (int j = 0; j<inputString[0].length; j++) {
				if(inputString[j][i] != inputString[0][i]) {
					b = false;			
					}
				}
			if(b) {
				turns++;
				
				st = inputString[i][0].charAt(0);
				b_final = true;
			}
		}
		if (turns>1) {

			bool = 1;
		}
		return b_final;
	}
	
	public static String evaluateBoard(String[][]inputString) {
		col(inputString); 
		row (inputString); 
		dia(inputString);
		String eva = "";
			if (bool == 1) {
					eva = "Game Error";
				}
			else if ( !col(inputString) && !row (inputString) && !dia(inputString)){
					eva = "DRAW";
				}
			else if(col(inputString) || row (inputString) || dia(inputString)) {
				if(st == 'X') {
					eva = "X wins";
				}
				else if (st =='O') {
					eva = "O wins";
				}
			}

		System.out.println(eva);
	return eva;
	}
	
	public static String evaluateBoards(String[][][] input) {
		String out ="";
		String result = "";
		int x = 0;
		int o = 0;
		int error = 0;
		int draw = 0;
		for (String[][] s : input) {
			out = evaluateBoard(s);
			if (out == "X wins") {
				x ++;
			}
			else if (out == "O wins") {
				o ++;
			}
			else if (out == "DRAW") {
				draw ++;
			
			}
			else if (out == "Game Error") {
				error++;
			}
		}
		result = "O wins:" + String.valueOf(o) + "  X wins:" + String.valueOf(x) +"  Draws: " + String.valueOf(draw)+"  Game Error: " + String.valueOf(error);
		System.out.println(result);
		return result;
	}
	
	
	public static void main(String[] args) {
	String[][] A = {{"X","O","X"},{"X","X","O"},{"X","O","X"}};//X
	String[][] C = {{"O","O","O"},{"X","X","O"},{"X","O","X"}};//O
	String[][] D = {{"X","O","O"},{"X","X","O"},{"O","O","X"}};//X
	String[][] E = {{"X","O","O"},{"X","O","O"},{"O","X","X"}};//O
	String[][] F = {{"X","X","O"},{"O","O","X"},{"X","X","O"}};//DRAW
	String[][] G = {{"X","X","X"},{"O","O","O"},{"X","X","X"}};//ERR
	String[][] H = {{"X","O","X"},{"X","O","X"},{"X","O","X"}};//ERR

	String[][][] B = {A,C,D,E,F,G,H};
	evaluateBoards(B);

	

		

	}

}
