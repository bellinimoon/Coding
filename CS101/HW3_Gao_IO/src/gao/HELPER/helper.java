package gao.HELPER;

public class helper {
	
	public static String[] separate(String line) {
		String[] word = line.split("-");
		
		return word;
	}
	
	public static String[] name (String[] word) {
		String [] name = new String[word.length];
		int count = 0;
		for (String s: word) {
			name[count] = s.split("#")[1];
			count++;
		}
		return name;
	}
	
	public static String[] seperateNum (String[] word) {
		String [] numbers = new String[word.length];
		int count = 0;
		for (String s: word) {
			numbers[count] = s.split("#")[0];
			count++;
		}
		return numbers;
	}
	
	public static String[] printNum(String [] numbers) {
		int count = 0;
		String newNum = "";
		String[] newNums = new String[numbers.length];
		for (String number: numbers) {
			newNum = "";
			char[] ch = number.toCharArray();
			for(char singleNum: ch) {
				newNum += "-" + singleNum;
			}
			newNums[count] = newNum;
			count++;
		}
		return newNums;
	}
	
	public static int count(String number) {
		char[] ch = number.toCharArray();
		int sum = 0;
		for (char num: ch) {
				int i = num - '0';
				sum += i;
			}
		return sum;
		}
	
	public static int countln(String[] numbers) {
		int all = 0;
		for(String i:seperateNum(numbers)) {
			all+=count(i);
		}
		return all;
	}

}
