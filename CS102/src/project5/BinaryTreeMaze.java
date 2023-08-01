package project5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * <p>
 * This class is the homework of the project 5 in csci102, spring 2023 semester.
 * 
 * <p>
 * This class is responsible for parsing and validating the command line
 * arguments(A alphabet and a number), reading and parsing the input file,
 * producing any error messages accordingly, and handling any exceptions thrown
 * by other classes, and producing output.
 * 
 * 
 * @author Annabeth Gao
 * @version 04/28/2023
 */
public class BinaryTreeMaze {
	public static void main(String[] args) throws IOException {
		// create the new empty maze
		Maze newMaze = new Maze();
		// read from command line arguments
		File file = new File(args[0]);
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String[] input = sc.nextLine().split(" ");
			// only read when there's more than two elements
			if (input.length >= 2) {
				// handling exception if the arguments' invalid
				try {
					// parse to string and integer
					MazeNode mn = new MazeNode(input[0], Integer.valueOf(input[1]));
					// add to the tree
					newMaze.add(mn);
				} catch (Exception e) {
					System.err.print("invalid input file");
					System.exit(0);
				}
			}
		}
		// close the file
		sc.close();
		// try to generate path
		try {
			System.out.print(newMaze.findPath().toString());
		} catch (Exception e) {
			System.err.print("empty maze");
		}
	}
}
