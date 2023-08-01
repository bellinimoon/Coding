package task2to5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;



public class ReportMaker {
	public static void staticvalidateCards (ArrayList<String> al) {
		String[][] validate = new String[al.size()][6];
		for (int i = 0; i <al.size(); i++) {
			validate[i][0] = al.get(i);
			int sum1 = 0;
			for(int i2 = al.get(i).length()-2; i2>= 0 ; i2-=2) {
				int sums = (Character.getNumericValue(al.get(i).charAt(i2))) * 2;
				if (sums >= 10) {
					sums = (sums/10) + (sums-10 * (sums/10));
				}
				sum1 += sums;
			}
			validate[i][1] =  String.valueOf(sum1);
			int sum2 = 0;
			for(int i3 = al.get(i).length()-1; i3> 0 ; i3-=2) {
				int sums = (Character.getNumericValue(al.get(i).charAt(i3))) ;
				sum2 += sums;
			}
			validate[i][2] =  String.valueOf(sum2);
			int sum3 = Integer.parseInt(validate[i][1]) + Integer.parseInt(validate[i][2]);
			validate[i][3] = String.valueOf(sum3);
			validate[i][4] = String.valueOf((float)sum3 /10);
			if(sum3 % 10 == 0) {
				validate[i][5] = "VALID";
			}else {
				validate[i][5] = "INVALID";
			}
			
			
		}
		System.out.println("Card Number" + "         " + "V1" + "    " + "V2" + "    " + "SUM" + "   " + "Div10" + "  " + "VALID");
		for(String[] st:validate) {
			for(String st2: st) {
				System.out.print(st2 +"    ");
			}
			System.out.println();
		}
		
		
	}
	public static void toDecimal(ArrayList<String> al) {
		String[][] binary = new String[al.size()][2];
		for (int i = 0; i < al.size(); i++) {
			int len = al.get(i).length();
			int sum = 0;
	        binary[i][0] = al.get(i);
			for(int i2 = 0; i2<len; i2++) {
				sum += (Character.getNumericValue(al.get(i).charAt(i2)) * Math.pow(2, len-1-i2));
				binary[i][1] = String.valueOf(sum);
			}
		}
		System.out.println("Binary              Decimal");
		for(String[]st: binary) {
			System.out.print(st[0] +  "    " + NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(st[1])) + "\n");
		}
		
	}
	public static void checkDigit(ArrayList<String> al) {
		String[] book = new String[al.size()];
		int count = 0;
		for (int i = 0; i < al.size(); i++) {
            book[count] = al.get(i).substring(0,9); 
			count++;
		}
		String []checkC = new String[book.length];
		int count2 = 0;
		for(String w: book) {
			int check = 0;
			for(int i = 0; i < w.length(); i ++) {
				check += Character.getNumericValue(w.charAt(i)) * (i+1);
			}
			if(check % 11 == 10) {
				checkC[count2] = "x";
			}else {
				checkC[count2] =  String.valueOf(check % 11);
			}
			count2 ++;
		}
		
		System.out.println("ISBN(first 9 digit)           Check Sum Digit");
		for(int i = 0; i<book.length; i++) {
			System.out.println(String.format("%-30s",book[i]) + checkC[i]);
		}
		
	}
	
	
	public static void buildPlayerAnalysisReport(String fn) throws IOException {
		System.out.println("          GO Player vs AI analysis\n\n");
		System.out.println("__________PHASE ANALYSIS__________");
		System.out.println("PHASE 1 Analysis                        PHASE 2 Analysis                        PHASE 3 Analysis                  ");
		String[][]info = buildPlayerDataArray(fn);
		String[][]Sum1 = Arrays.copyOfRange(info, 0, 5);
		String[][]Sum2 = Arrays.copyOfRange(info, 5, 10);
		String[][]Sum3 = Arrays.copyOfRange(info, 10, 15);
		
		System.out.println("Player    Wins      Losses    Ties      Player    Wins      Losses    Ties      Player    Wins      Losses    Ties");
		for(int i=0; i< Sum1.length; i++) {
			for(String st: Sum1[i]) {
				System.out.print(String.format("%-10s",st));
			}
			for(String st: Sum2[i]) {
				System.out.print(String.format("%-10s",st));
			}
			for(String st: Sum3[i]) {
				System.out.print(String.format("%-10s",st));
			}
			System.out.print("\n");	
		}
		System.out.println("__________AGGREGATE PERFORMANCE__________");
		System.out.println("PLAYER         WINS           LOSSES         TIES");


		String[][]perSum = new String[5][4];
		for(String[]st: perSum) {
			Arrays.fill(st, "0");
		}

		perSum[0][0] = "ALPHA PLAYER";
		perSum[1][0] = "BETA PLAYER";
		perSum[2][0] = "GAMMA PLAYER";
		perSum[3][0] = "DELTA PLAYER";
		perSum[4][0] = "AI PLAYER";
		int sumnum = 0;

		for (int i = 0; i< info.length; i++) {	
			if (info[i][0].contains("ALPHA")) {
				for(int i2 =1; i2 <=3; i2++) {
					sumnum =  Integer.parseInt(perSum[0][i2]) +  Integer.parseInt(info[i][i2]);
					perSum[0][i2] = String.valueOf(sumnum);
				}
			}
			else if (info[i][0].contains("BETA")) {
				for(int i2 =1; i2 <=3; i2++) {
					sumnum =  Integer.parseInt(perSum[1][i2]) +  Integer.parseInt(info[i][i2]);
					perSum[1][i2] = String.valueOf(sumnum);
				}
			}
			else if (info[i][0].contains("GAMMA")) {
				for(int i2 =1; i2 <=3; i2++) {
					sumnum =  Integer.parseInt(perSum[2][i2]) +  Integer.parseInt(info[i][i2]);
					perSum[2][i2] = String.valueOf(sumnum);
				}
			}
			else if (info[i][0].contains("DELTA")) {
				for(int i2 =1; i2 <=3; i2++) {
					sumnum =  Integer.parseInt(perSum[3][i2]) +  Integer.parseInt(info[i][i2]);
					perSum[3][i2] = String.valueOf(sumnum);
				}
			}
			else if (info[i][0].contains("AI")) {
				for(int i2 =1; i2 <=3; i2++) {
					sumnum =  Integer.parseInt(perSum[4][i2]) +  Integer.parseInt(info[i][i2]);
					perSum[4][i2] = String.valueOf(sumnum);;
				}
			}
		}
		for(int i=0; i< perSum.length; i++) {
			for(String st: perSum[i]) {
				System.out.print(String.format("%-15s",st));
			}
			System.out.print("\n");	
		}
		System.out.println("____________________________Report Prepared By A Gao");
		
	}
	
	public static int CountLine(String fn) throws IOException {
		String path = fn;
		BufferedReader BR = new BufferedReader(new FileReader (path));
		String line = "";
		int count = 0;
		while((line = BR.readLine())!= null) {		
			count ++ ;
		}
		BR.close();
		return count;
	}
	
	public static String[][] buildPlayerDataArray(String fn) throws IOException{
			String path = fn;
			int lineNum = CountLine(fn);
			BufferedReader BR = new BufferedReader(new FileReader (path));
			String line = "";
			String[][] Array2 = new String[lineNum][4];
			int count = 0;
			while((line = BR.readLine())!= null) {
				String[] splitline = line.split("\\s+");
				String[] cleanLine = new String[4];
				cleanLine[0] = splitline[0];
				int win = 0;
				int lose = 0;
				int tie = 0;		
				for(int i = 0; i < splitline.length; i++) {
					if (splitline[i].contains("W")) {
						win++;
					}else if (splitline[i].contains("L")) {
						lose++;
					}else if ( splitline[i].contains("T")) {
						tie++;
					}
				}
				cleanLine[1] = String.valueOf(win);
				cleanLine[2] = String.valueOf(lose);
				cleanLine[3] = String.valueOf(tie);
				Array2[count] = cleanLine;
				count ++ ;
			}
			BR.close();
			return Array2;
		}
		

	public static void main(String[] args) throws IOException {
//Task 2
//		String id = "/Users/gaomengxian/eclipse-workspace/Gao_HW7/src/PlayerData";
//		buildPlayerAnalysisReport(id);
		
//Task 3
//		ArrayList<String> isbn = new ArrayList<String>();
//		isbn.add("9876543210");
//		isbn.add("334455662");
//		isbn.add("5647382910");
//		isbn.add("1234567890");
//		checkDigit(isbn);
		
//Task 4
//		ArrayList<String> bi = new ArrayList<String>();
//		bi.add("0000010101010101");
//		bi.add("0000010111110101");
//		bi.add("1000010101010101");
//		toDecimal(bi);
		
//Task 5
		ArrayList<String> card = new ArrayList<String>();
		card.add("4388576018402625");
		card.add("4388576018410707");
		card.add("4388576018419797");
		staticvalidateCards(card);
		



		//System.out.print(sum1);
		
	}

}