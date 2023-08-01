package prep;

import java.util.Arrays;

public class MAIN {
	public static boolean raggedMatrix(int[][] inputMatrix){
		boolean cond = true;
		int[] nums = new int[inputMatrix.length];
		int count = 0;
		for (int[] line : inputMatrix) {
			nums[count] = line.length;
			count ++;
		}
		for (int num : nums) {
			if (num != nums[0]) {
				System.out.println("Argument is not a matrix");
				cond = false;
			}
		}
		return cond;		
	}
	
	public static double median(int[] input) {
		double median = 0;
		if (input.length % 2 == 0) {	
			median = (Double.valueOf(input[input.length/2]) + Double.valueOf(input[(input.length/2) - 1]))/2;
		}
		else {
			median = input[(input.length-1)/2];
		}
		return median;
	}
	
	public static double[] medianMatrix(int[][] inputMatrix) {

		double[] medianNums = new double[inputMatrix.length + inputMatrix[0].length];
		
		if(raggedMatrix(inputMatrix) == false) {
			medianNums = new double [5];
		}
		else {		
			int[][] col = new int[inputMatrix[0].length][inputMatrix.length];
			int ct1 = 0;
			for(int i = 0; i < (inputMatrix[0].length); i++) {
				for (int[] row : inputMatrix) {
					col[i][ct1] = row[i];
					ct1++;
				}
				ct1 = 0;
			}
			
			for(int[] line : col) {
				Arrays.sort(line);
			}
			
			//sort for row
			for(int[] line : inputMatrix) {
				Arrays.sort(line);
			}
			int count = 0;
			for (int[] row :inputMatrix) {
				medianNums[count] = median(row);
				count++;
			}	
			for(int[] row : col) {
				medianNums[count] = median(row);
				count++;
			}

		}
		for (double n : medianNums) {
			System.out.print(n + " ");
		}
		return medianNums;
	}
	
	//task2
	public static int[] line (int[][] inputMatrix) {
		int[] row = new int[inputMatrix[0].length*inputMatrix.length];
		int count = 0;
		for (int[] i : inputMatrix) {
			for (int j : i) {
				row[count] = j;
				count++;
			}
		}
		Arrays.sort(row);
		return row;
	}
	
	public static int modeMatrix(int[][] inputMatrix) {
		int returnNum = 0;
		int num_temp = 0;
		int num_temp2 = 0;
		int num_mode = 0;
		int count_higher = 0;
		int count2 = 0;
		if(raggedMatrix(inputMatrix) == false) {
			System.out.println("Argument is not a Matrix");
		}
		else {
			int[] row = line(inputMatrix);

			for(int i = 0; i < row.length-1; i++) {
				num_temp = row[i];
				num_temp2 = row[i+1];
				
				if (num_temp == num_temp2) {
					count2 ++;
				}
				else {
					count2 = 0;
				}
				if (count_higher < count2) {
					count_higher = count2;
					num_mode = row[i];
				}		
			}
		}

		System.out.println(num_mode);
		return num_mode;
	}

	public static void main(String[] args) {
		int[][] A = {{1,7,5,3},{2,8,6,4},{3,2,1,4},{8,7,5,6},{4,7,1,2}};
		int[][] B = {{7,7,5,3},{2,8,6,4},{3,2,1,4},{8,7,5,6},{4,7,1,2}};
		int[][] C = {{1,2,3},{4,5}};
		medianMatrix(A);
		System.out.print("\n");
		modeMatrix(B);

	}

}
