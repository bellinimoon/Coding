package prep2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RandomNumber {

	public static void main(String[] args) throws IOException {
		int max = 1000;
		int min = 0;
		int rand = (int)(Math.random()*(max-min) + min);
		int rand2 = (int)(Math.random()*10+1);
		
		String fn = "/Users/gaomengxian/eclipse-workspace/Midterm_prep/src/prep2/file.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fn));
		
		for(int n = 0; n<100; n++) {
			rand = (int)(Math.random()*1000);
			rand2 = (int)(Math.random()*10+1);
			char ch = (char)rand;
			String line = Character. toString(ch);
			bw.write(line.repeat(rand2)+ "\n");
		}
		bw.close();
	}

}
