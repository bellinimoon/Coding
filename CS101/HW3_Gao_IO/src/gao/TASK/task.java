package gao.TASK;
import gao.HELPER.helper;
import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException; 

public class task {
	public static void processFile_B(String filename) throws IOException {
		String path = "/Users/gaomengxian/eclipse-workspace/HW3_Gao_IO/src/gao/DATA/" + filename;
		BufferedReader BR = new BufferedReader(new FileReader (path));
		String line = "";
		int count = 0;
		while((line = BR.readLine())!= null) {
			if (count%2 == 0) {
			String[] word = helper.separate(line);
			String[] nameSet = helper.name(word);
			String[] numberSet = helper.printNum(helper.seperateNum(word));
			int countNum = helper.countln(word);
			System.out.print("* ");
			for (int n = 0; n < word.length; n++) {
				System.out.print(nameSet[n] + " " + numberSet[n] + " ");
				}
			System.out.print("***" + countNum + "\n");
			}
			count ++ ;
		}
		BR.close();
	}
}
