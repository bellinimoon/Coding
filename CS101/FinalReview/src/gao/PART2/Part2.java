package gao.PART2;

public class Part2 {
	//task3
	public static String  columnsToString(char[][] inputArray) {
		String output = "";
		int i = inputArray.length-1;

		while(i>=0) {
			int i2 = inputArray[i].length-1;
			while(i2>=0) {
				output += (i2==inputArray[i].length-1 || i2 == 0)?inputArray[i][i2]:"";
				i2--;
				
			}

			i--;
		}
		return output;
	}
	//task2
	public static String getCenterCorners(char[][] inputArray) {
		String output = "";
		int i = 0;
		while(i<inputArray.length) {
			int i2 = 0;
			while(i2<inputArray[i].length) {
				output += ((i2+1)%2 != 0 && (i ==0 || i == inputArray.length-1) )?inputArray[i][i2]: "";
				output += (i2 == (inputArray[i].length-1)/2 && i == (inputArray.length-1)/2)?inputArray[i][i2]:"";
				i2++;
			}
			i++;
		}
		return output;
	}
	//task1
	 public static int[] getRowProduct(int[][] inputArray) {
		 int half = (inputArray.length - 1)/2;
		 int[] product = new int[inputArray.length];
		 if(inputArray.length % 2 == 0) {
			 System.out.println("input Matrix length must be odd");
			 System.exit(0);
		 }
		 int i = 0;
		 while(i< inputArray.length) {
			 if (inputArray[i].length != 3) {
				 System.out.println("input Matrix row length must be 3");
				 System.exit(0);
			 } 
			 int pro = 1;
			 int i2 = 0;
			 while(i2 < inputArray[i].length) {
				 int half2 = (inputArray[i].length-1)/2;
				 pro *= ( i == half && i2 == half2) ? 1: inputArray[i][i2];
				 i2++;
			 }
			 product[i] = pro;
			 i++;
			 
		 }
		return product;

	 }



}
