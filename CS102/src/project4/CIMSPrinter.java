package project4;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * <p>This class is the homework of the project 4 in csci102, spring 2023 
 * semester. 
 * 
 * <p>This class attempts to figure out the time required for a given job to 
 * be printed assuming some knowledge of all the jobs sent to the printer. 
 * It assumes that there are no additional print jobs added to the queue, 
 * printing a single job takes exactly one minute, and the queue operations 
 * happen instantly.
 * 
 * 
 * @author Annabeth Gao
 * @version 04/15/2023
 */
public class CIMSPrinter {
	
	/** 
	 * The method that handles the input data and calls another method to 
	 * calculate the printing time in regard of its priorities in the queue. 
	 * It changes the input string to an two queues and(one unsorted and one sorted)
	 * @param jobNum string the number of printing jobs
	 * @param pos string the position of the document we are concerned in the queue
	 * @param priority string displaying the priority of all the documents
	 */
	public static void HandleInput(String jobNum, String pos, String priority) {
		// split the string to get a string array
		String[] priorities = priority.split(" ");
		// a reversed sorted queue
		Queue<Integer> sorted = new PriorityQueue<Integer>(Collections.reverseOrder());
		//add information into the sorted queue
		for(int i = 0; i < priorities.length; i++) {
			sorted.add(Integer.parseInt(priorities[i]));
		}
		// construct the unsorted queue
		Queue<Integer> priorQueue = new LinkedList<Integer>();;
		for(int i = 0; i < priorities.length; i++) {
			priorQueue.add(Integer.parseInt(priorities[i]));
		}
		//change the string to int for easier comparison
		int jobNumInt = Integer.parseInt(jobNum);
		int posInt = Integer.parseInt(pos);
		int time = 0;
		System.out.print(PrintTime(priorQueue, jobNumInt, posInt, sorted, time) + "\n");
	}
	
	/** 
	 * The method calculate the printing time of a document in regard of its priorities 
	 * in the queue. It assumes each printing job takes a minute to complete, jobs with 
	 * lower priority will be moved to the end of the array
	 * @param priorities queue showing the unsorted queue of priorities 
	 * @param jobNum integer number of jobs left to be completed
	 * @param pos integer the current position of the document we want to calculate for
	 * @param sorted queue showing the order to be printed as showed by the priorities
	 * @param time int the time passed for printing
	 * @return time int showing the required time for the job to be printed
	 */
	public static int PrintTime(Queue<Integer> priorities, int jobNum, int pos, Queue<Integer> sortedPrior, int time) {
		//if the priority is different with the priority which should be printed 
		if(priorities.peek()!= sortedPrior.peek()) {
			// add the front job to the back of the queue
			priorities.add(priorities.poll());
			//the job was the one, pos moves to the back of the queue
			if(pos == 0) {
				pos = jobNum - 1;
			}else {
				//else our document moves one pos ahead
				pos --;
			}
		}else{
			//only one job is presented, print rightaway
			if(jobNum == 1 && pos <= 0) {
				time ++;
				return time;
			}
			//something should be printed as the priorities match
			time ++;
			//if our document is the one being printed
			if(pos <= 0) {
				return time;
			}
			//else our document passed one ahead
			pos --;
			//the document gets printed so removed from both queue
			sortedPrior.poll();
			priorities.poll();
			//the jobnum decreases by one
			jobNum --;		
		}	
		return PrintTime(priorities, jobNum, pos, sortedPrior, time);
		
	}
	
	/**
	 * Main method to read the input from the console using scanner. 
	 * @param args input of strings on three different lines  
	 */
	public static void main(String[] args) {
		//scanner takes input
	    Scanner in = new Scanner(System.in); 
	    //read two values from one line
	    String jobsNumber = in.next();
	    //need to change lines but also trim the space in the front
	    String pos = in.nextLine().trim();
	    String priority = in.nextLine();
	    HandleInput(jobsNumber, pos, priority);
	    in.close();
	}
}
