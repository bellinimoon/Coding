package project5;

/**
 * <p>
 * This class is the homework of the project 5 in csci102, spring 2023 semester.
 * 
 * <p>
 * It represents the maze itself. It constructs the possible paths in the maze
 * based on the points of the node and the points of our hero.
 * 
 * @author Annabeth Gao
 * @version 04/28/2023
 */
public class Maze extends BST<MazeNode> {
	// the collection of paths
	protected StringBuilder paths = new StringBuilder();

	/**
	 * Constructs a new Maze object. It inherits from the BST class
	 */
	protected Maze() {
		super();
	}

	/**
	 * Wrapper method to Construct possible path base on the structure maze(itself).
	 * 
	 * @return paths the StringBuilder that holds the collection of all the routes
	 */
	protected StringBuilder findPath() {
		// a new hero
		Hero hero = new Hero(0);
		// represents every single path
		String singlePath = "";
		findPath(this.root, hero, singlePath);
		return paths;
	}

	/**
	 * Constructs paths and append them to the string.
	 * 
	 * @param node       node represents the point in the maze and hold its points;
	 * @param hero       the hero in the maze, it holds its points of value;
	 * @param singlePath the string that represents each single path;
	 */
	private void findPath(Node node, Hero hero, String singlePath) {
		if (node == null) {
			// if we reach a leaf(incorrect height)
			return;
		}

		if (hero.getPoint() < 0) {
			// the hero runs out of points
			return;
		}
		// we get the gets of the node and give them to the hero
		hero.updatePoint(node.data.getPoint());
		// add the name of the node to the path
		singlePath += node.data.getLabel();
		// if we reach the desired height
		if (node.level == this.height()) {
			//append our single path to the collection
			paths.append(singlePath);
			//change line for the next possible path
			paths.append("\n");
			return;
		}
		//separate each node with a blank space
		singlePath += " ";
		//deduct the point because of traveling
		hero.travel();
		//move the next node, we use clone because we want the heros to travel on different paths
		findPath(node.left, hero.cloneHero(), singlePath);
		findPath(node.right, hero.cloneHero(), singlePath);

	}
}
