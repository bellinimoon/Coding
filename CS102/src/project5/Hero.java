package project5;

/**
 * <p>
 * This class is the homework of the project 5 in csci102, spring 2023 semester.
 * 
 * <p>
 * This class represent our hero traveling in the maze. It keeps track of all
 * the life points that our hero possesses at any given time. The information
 * are updated as the hero travels along the different potential paths through
 * the maze by making a copy of the hero.
 * 
 * @author Annabeth Gao
 * @version 04/28/2023
 */
public class Hero {
	// the point a hero possesses at any time
	private int point;

	/**
	 * Constructs a new Hero object.
	 * 
	 * @param point, the point possesses by the hero; only takes a single element.
	 */
	protected Hero(int point) {
		this.point = point;
	}

	/**
	 * Clone the hero so that it can travel along different paths.
	 * 
	 * @return a copy of the hero
	 */
	protected Hero cloneHero() {
		return new Hero(point);
	}

	/**
	 * method that set the point of a hero.
	 * 
	 * @param point, the point gained at the node, should be add to the point of the
	 *               hero;
	 */
	protected void updatePoint(int point) {
		this.point += point;
	}

	/**
	 * method that reduces the point of the hero whenever the hero travels.
	 */
	protected void travel() {
		this.point--;
	}

	/**
	 * a getter method to retrieve the points of the hero as point is a private
	 * field
	 */
	protected int getPoint() {
		return point;
	}
}
