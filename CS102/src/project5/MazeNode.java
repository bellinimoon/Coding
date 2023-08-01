package project5;

/**
 * <p>
 * This class is the homework of the project 5 in csci102, spring 2023 semester.
 * 
 * <p>
 * This class represents the points in the maze at which our hero can collect
 * life-points and at which they need to make a decisions as to which way to
 * continue. It's capable of storing the label of the node and the number of
 * possible life points our hero can collect at this maze node.
 * 
 * @author Annabeth Gao
 * @version 04/29/2023
 */
public class MazeNode implements Comparable<MazeNode> {
	private Integer point;
	private String label;

	/**
	 * Constructs a new MazeNode.
	 * 
	 * @param label the alphabet represents the label of the mazeNode;
	 * @param point point represents the points the hero can gain at the node;
	 */
	public MazeNode(String label, Integer point) {
		this.point = point;
		this.label = label;
	}

	/**
	 * Overwrite the toString method because we only want the label of the nodes.
	 */
	@Override
	public String toString() {
		return this.label + " " + this.point;
	}

	/**
	 * Overwrite the compareTo method because we only want to compare the label of
	 * the points, not the points of the nodes.
	 */
	@Override
	public int compareTo(MazeNode other) {
		return this.label.compareTo(other.label);
	}

	/**
	 * getter method to get the point of the node.
	 */
	protected Integer getPoint() {
		return point;
	}

	/**
	 * getter method to get the label of the node.
	 */
	protected String getLabel() {
		return label;
	}

}
