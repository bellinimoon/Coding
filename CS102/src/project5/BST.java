package project5;

import java.util.*;

/**
 * <p>
 * This class is the homework of the project 5 in csci102, spring 2023 semester.
 * 
 * <p>
 * An implementation of a binary search tree. The elements are ordered using
 * their natural ordering. This implementation provides guaranteed O(H) time
 * cost for the basic operations (add, remove and contains). The specification
 * is similar to the one for TreeSet class provided by Java libraries.
 * 
 * @author Annabeth Gao
 * @version 04/30/2023
 */
public class BST<E extends Comparable<E>> extends Object implements Iterable<E> {
	// the overall size of the tree
	private int size;
	// record the highest level of the tree
	protected int height;
	// comparator used to address the ordering
	private Comparator<E> comparator;
	// the root reference
	protected Node root;
	// boolean used for the add and remove methods
	private boolean found;
	private boolean added;

	/**
	 * Constructs a new, empty tree, sorted according to the natural ordering of its
	 * elements.
	 */
	protected class Node implements Comparable<Node> {
		E data;
		Node left;
		Node right;
		int level;

		protected Node(E data) {
			this.data = data;
		}

		protected Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		protected void setHeight(int i) {
			// set the height of the node
			this.level = i;
		}

		@Override
		public int compareTo(BST<E>.Node other) {
			// Constructs a new, empty tree, sorted according to the specified comparator.
			if (BST.this.comparator == null)
				return this.data.compareTo(other.data);
			else
				return comparator.compare(this.data, other.data);
		}
	}

	/**
	 * Constructs a new BST object with size set to 0.
	 */
	public BST() {
		size = 0;
		root = null;
		comparator = null;
	}

	/**
	 * Constructs a new BST object completed with the input genetic array. It's a
	 * self-balancing binary search tree
	 * 
	 * @param collections a sorted generic array
	 */
	public BST(E[] collections) {
		this.root = null;
		this.BSTCollectionHelper(collections, this);
	}

	/**
	 * Helper method to construct a new BST object completed with the input genetic
	 * array. It's self balanced because it always attempt to add the middle element
	 * of a sorted array I assume the input generic array is sorted
	 * 
	 * @param collections a generic array
	 * @param newBst      the new BST created
	 */
	private BST<E> BSTCollectionHelper(E[] collection, BST<E> newBst) {
		// divide the array to half
		int mid = collection.length / 2;
		// reached the left of each section
		if (mid < 1) {
			newBst.add(collection[0]);
			return newBst;
		}
		// add the middle value
		newBst.add(collection[mid]);
		// process the left
		BSTCollectionHelper(Arrays.copyOfRange(collection, 0, mid), newBst);
		// and the right
		BSTCollectionHelper(Arrays.copyOfRange(collection, mid, collection.length), newBst);
		return newBst;
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		if (root == null) {
			return 0;
		}
		return size;
	}

	/**
	 * Adds the specified element to this tree if it is not already present. If this
	 * tree already contains the element, the call leaves the tree unchanged and
	 * returns false.
	 * 
	 * @param data element to be added to this tree
	 * @return true if this tree did not already contain the specified element
	 * @throws NullPointerException if the specified element is null
	 */
	public boolean add(E data) {
		// not added before the recursion
		added = false;
		if (data == null) {
			throw new NullPointerException("null value found");
		}
		// replace root with the reference to the tree after the new
		root = add(data, root);
		// value is added
		if (added) {
			// size of the tree increases
			size++;
		}
		return added;
	}

	/**
	 * Actual recursive implementation of add.
	 *
	 * This function returns a reference to the subtree in which the new value was
	 * added.
	 *
	 * @param data element to be added to this tree
	 * @param node node at which the recursive call is made
	 */
	private Node add(E data, Node node) {
		// if the tree is empty
		if (node == null) {
			added = true;
			// create new node
			Node newRoot = new Node(data);
			// level starts at 1
			newRoot.level = 1;
			// update level
			if (height < newRoot.level) {
				height = newRoot.level;
			}
			return newRoot;
		}
		// decide how comparisons should be done
		int comp = 0;
		if (comparator == null) // use natural ordering of the elements
			comp = data.compareTo(node.data);
		else // use the comparator
			comp = comparator.compare(data, node.data);
		// find the location to add the new value
		if (comp < 0) { // add to the left subtree
			node.left = add(data, node.left);
			// increase the level of the node
			node.left.setHeight(node.level + 1);
			if (node.left.level > height) {
				// if it's bigger than the one in record
				height = node.left.level;
			}
		} else if (comp > 0) { // add to the right subtree
			node.right = add(data, node.right);
			node.right.setHeight(node.level + 1);
			if (node.right.level > height) {
				height = node.right.level;
			}
		} else { // duplicate found, do not add
			added = false;
			// return node;
		}
		return node;
	}

	/**
	 * Removes the specified element from this tree if it is present. Returns true
	 * if this tree contained the element (or equivalently, if this tree changed as
	 * a result of the call). (This tree will not contain the element once the call
	 * returns.)
	 * 
	 * @param target object to be removed from this tree, if present
	 * @return true if this set contained the specified element
	 * @throws NullPointerException if the specified element is null
	 */
	@SuppressWarnings("unchecked")
	public boolean remove(Object o) {
		E nodeToRemove;
		if (o == null) {
			throw new NullPointerException("can't remove null objects");
		}
		nodeToRemove = (E) o;
		root = recRemove(nodeToRemove, root);
		if (found)
			size--;
		return found;
	}

	/**
	 * Actual recursive implementation of remove method: find the node to remove.
	 *
	 * This function recursively finds and eventually removes the node with the
	 * target element and returns the reference to the modified tree to the caller.
	 * 
	 * @param target object to be removed from this tree, if present
	 * @param node   node at which the recursive call is made
	 */
	private Node recRemove(E target, Node node) {
		if (node == null) { // value not found
			found = false;
			return node;
		}
		int comp = 0;
		// decide how comparisons should be done
		try {
			if (comparator == null) // use natural ordering of the elements
				comp = target.compareTo(node.data);
			else // use the comparator
				comp = comparator.compare(target, node.data);
		} catch (ClassCastException e) {
			throw new ClassCastException("can't compare");
		}

		if (comp < 0) // target might be in a left subtree
			node.left = recRemove(target, node.left);
		else if (comp > 0) // target might be in a right subtree
			node.right = recRemove(target, node.right);
		else { // target found, now remove it
			node = removeNode(node);
			found = true;
		}
		return node;
	}

	/**
	 * Actual recursive implementation of remove method: perform the removal.
	 *
	 * @param target the item to be removed from this tree
	 * @return a reference to the node itself, or to the modified subtree
	 */
	private Node removeNode(Node node) {
		E data;
		if (node.left == null) // handle the leaf and one child node with right subtree
			return node.right;
		else if (node.right == null) // handle one child node with left subtree
			return node.left;
		else { // handle nodes with two children
			data = getPredecessor(node.left);
			node.data = data;
			node.left = recRemove(data, node.left);
			return node;
		}
	}

	/**
	 * Returns the information held in the rightmost node of subtree
	 *
	 * @param subtree root of the subtree within which to search for the rightmost
	 *                node
	 * @return returns data stored in the rightmost node of subtree
	 */
	private E getPredecessor(Node subtree) {
		if (subtree == null) // this should not happen
			throw new NullPointerException("getPredecessor called with an empty subtree");
		Node temp = subtree;
		// go to the right until it's null
		while (temp.right != null)
			temp = temp.right;
		return temp.data;
	}

	/**
	 * Clear the tree as the root null and is now not linked to any node
	 */
	public void clear() {
		root = null;
	}

	/**
	 * Returns true if this set contains the specified element. It validates the
	 * input
	 *
	 * @param o object to be checked for containment in this set
	 * @throws ClassCastException   if the specified object cannot be compared with
	 *                              the elements currently in the set
	 * @throws NullPointerException if the specified element is null and this set
	 *                              uses natural ordering, or its comparator does
	 *                              not permit null elements
	 * @return true if this set contains the specified element
	 */
	@SuppressWarnings("unchecked")
	public boolean contains​(Object o) {
		E nodeToCheck;
		if (o == null) {
			throw new NullPointerException("can't remove null objects");
		}
		nodeToCheck = (E) o;
		return containsHelper(root, nodeToCheck);

	}

	/**
	 * Helper method to check whether this set contains the specified element
	 *
	 * @param root the root of the subtree
	 * @param E    the generic we need to check
	 * @return true if this set contains the specified element
	 */
	private boolean containsHelper(Node root, E node) {
		if (root == null)
			// we didn't find it
			return false;
		int comp = 0;
		if (comparator == null) // use natural ordering of the elements
			comp = node.compareTo(root.data);
		else // use the comparator
			comp = comparator.compare(node, root.data);
		// we find it
		if (comp == 0)
			return true;
		else if (comp < 0) {
			// it's on the left cuz it's smaller
			return containsHelper(root.left, node);
		} else {
			// on the right! it's bigger
			return containsHelper(root.right, node);
		}
	}

	/**
	 * Check to see if this tree is empty
	 *
	 * @return true if this set contains no elements.
	 */
	public boolean isEmpty() {
		if (root == null) {
			// it's empty because the root is null
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calculates the height of the tree
	 *
	 * @return the height of this tree.
	 */
	public int height() {
		return height;
	}

	/**
	 * Returns the element at the specified position in this tree. This
	 * implementation is not O(H) sadly
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in this tree.
	 * @throws IndexOutOfBoundsException if the index is out of range.
	 */
	public E get​(int index) {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException("invalid index");
		}
		return this.toArrayInorder().get(index);
	}

	/**
	 * Returns the least element in this tree greater than or equal to the given
	 * element, or null if there is no such element.
	 *
	 * @param e the value to match
	 * @throws NullPointerException if the specified element is null
	 * @throws ClassCastException   if the specified element cannot be compared with
	 *                              the elements currently in the set
	 * @return the least element in this tree greater than or equal to the given
	 *         element.
	 */
	public E ceiling​(E e) {
		E ceil;
		if (e == null) {
			throw new NullPointerException("can't remove null objects");
		}
		// if we can have the value
		try {
			ceil = ceilingHelper(e, root);
		} catch (Exception ex) {
			throw new ClassCastException("cannot be compared");
		}
		return ceil;
	}

	/**
	 * Helper method for the ceiling method to loop over the tree
	 *
	 * @param target  the target value to match
	 * @param current the root of the subtree
	 * @return E the element at the specified position in this tree.
	 */
	private E ceilingHelper(E target, Node current) {
		int comp = 0;
		E ceil = null;

		while (current != null) {
			try {
				if (comparator == null) // use natural ordering of the elements
					comp = target.compareTo(current.data);
				else // use the comparator
					comp = comparator.compare(target, current.data);
			} catch (ClassCastException e) {
				throw new ClassCastException("can't compare");
			}
			if (comp == 0) {
				return current.data;
			} else if (comp < 0) {// if the value is bigger
				ceil = current.data;
				// going to the left to make the value smaller
				current = current.left;
			} else {
				// smaller so go to the right to make it bigger
				current = current.right;
			}
		}
		return ceil;
	}

	/**
	 * Returns the greatest element in this set less than or equal to the given
	 * element, or null if there is no such element.
	 *
	 * @param e the value to match
	 * @throws NullPointerException if the specified element is null
	 * @throws ClassCastException   if the specified element cannot be compared with
	 *                              the elements currently in the set
	 * @return the greatest element in this set less than or equal to the given
	 *         element
	 */
	public E floor​(E e) {
		E fl;
		if (e == null) {
			throw new NullPointerException("can't remove null objects");
		}
		try {
			fl = floorHelper(e, root);
		} catch (Exception ex) {
			throw new ClassCastException("cannot be compared");
		}
		return fl;
	}

	/**
	 * Helper method for the floor method to loop over the tree
	 *
	 * @param target  the target value to match
	 * @param current the root of the subtree
	 * @return E the element at the specified position in this tree.
	 */
	private E floorHelper(E target, Node current) {
		int comp = 0;
		E fl = null;
		while (current != null) {
			try {
				if (comparator == null) // use natural ordering of the elements
					comp = target.compareTo(current.data);
				else // use the comparator
					comp = comparator.compare(target, current.data);
			} catch (ClassCastException e) {
				throw new ClassCastException("can't compare");
			}
			// we find the same value
			if (comp == 0) {
				return current.data;
			} else if (comp < 0) {
				// if the value's too big
				current = current.left;
			} else {
				// record the value and move right if there's a bigger value
				fl = current.data;
				current = current.right;
			}
		}
		return fl;
	}

	/**
	 * Returns the first (lowest) element currently in this tree. or null if there
	 * is no such element.
	 *
	 * @throws NoSuchElementException if this set is empty
	 * @return the first (lowest) element currently in this tree.
	 */
	public E first() {
		if (root == null) {
			throw new NoSuchElementException("The tree is empty");
		}
		Node current = root;
		while (current.left != null) {
			// the leftist node
			current = current.left;
		}
		return current.data;
	}

	/**
	 * Returns the last (highest) element currently in this tree.. or null if there
	 * is no such element.
	 *
	 * @throws NoSuchElementException if this set is empty
	 * @return the last (highest) element currently in this tree..
	 */
	public E last() {
		if (root == null) {
			throw new NullPointerException("The tree is empty");
		}
		Node current = root;
		while (current.right != null) {
			// the rightest node
			current = current.right;
		}
		return current.data;
	}

	/**
	 * Returns the greatest element in this set strictly less than the given
	 * element, or null if there is no such element.
	 *
	 * @param e the value to match
	 * @throws NullPointerException if the specified element is null
	 * @throws ClassCastException   if the specified element cannot be compared with
	 *                              the elements currently in the set
	 * @return the greatest element less than e, or null if there is no such element
	 */
	public E lower​(E e) {
		if (e == null) {
			throw new NullPointerException("can't remove null objects");
		}
		return lowerHelper(e, root);
	}

	/**
	 * Helper method to find the greatest element in this set
	 *
	 * @param target  the value to match
	 * @param current current node
	 * @return the greatest element less than e, or null if there is no such element
	 */
	private E lowerHelper(E target, Node current) {
		// record the compare result
		int comp = 0;
		// the E to be returned
		E low = null;
		while (current != null) {
			try {
				if (comparator == null) // use natural ordering of the elements
					comp = target.compareTo(current.data);
				else // use the comparator
					comp = comparator.compare(target, current.data);
			} catch (ClassCastException e) {
				throw new ClassCastException("can't compare");
			}
			if (comp <= 0) {
				// too big, go left
				current = current.left;
			} else {
				// go right if there's a bigger one
				low = current.data;
				current = current.right;
			}
		}
		return low;
	}

	/**
	 * Returns the least element in this tree strictly greater than the given
	 * element, or null if there is no such element.
	 *
	 * @param e the value to match
	 * @throws NullPointerException if the specified element is null
	 * @throws ClassCastException   if the specified element cannot be compared with
	 *                              the elements currently in the set
	 * @return the least element higher than e, or null if there is no such element
	 */
	public E higher(E e) {
		if (e == null) {
			throw new NullPointerException("can't remove null objects");
		}
		return higherHelper(e, root);
	}

	/**
	 * Helper method to find the least element in this set
	 *
	 * @param target  the value to match
	 * @param current current node
	 * @return the least element bigger than e, or null if there is no such element
	 */
	private E higherHelper(E target, Node current) {
		int comp = 0;
		E hi = null;
		while (current != null) {
			try {
				if (comparator == null) // use natural ordering of the elements
					comp = target.compareTo(current.data);
				else // use the comparator
					comp = comparator.compare(target, current.data);
			} catch (ClassCastException e) {
				throw new ClassCastException("can't compare");
			}
			if (comp < 0) {
				// the value is ok, but sees if there's a smaller one
				hi = current.data;
				current = current.left;
			} else {
				// too big
				current = current.right;
			}
		}
		return hi;
	}

	/**
	 * Compares the specified object with this tree for equality.
	 * 
	 * @param obj object to be compared for equality with this tree
	 * @return true if the given object is also a tree, the two trees have the same
	 *         size, and every member of the given tree is contained in this tree. t
	 */
	@Override
	public boolean equals(Object obj) {
		// verify if object is null
		if (obj == null)
			return false;
		// check if object is equal to this
		if (obj == this)
			return true;
		// check if object is a BST
		if (!(obj instanceof BST))
			return false;
		// cast object to BST type
		BST<?> bst = (BST<?>) obj;
		// iterate through both trees and compare elements
		// one by one
		// check the size
		if (this.size() != bst.size())
			return false;
		// get lists for both trees
		ArrayList<E> thisList = this.toArrayInorder();
		ArrayList<?> bstList = bst.toArrayInorder();
		for (int i = 0; i < thisList.size(); i++) {
			if (!thisList.get(i).equals(bstList.get(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * The string representation consists of a list of the tree's elements in the
	 * order they are returned by its iterator (inorder traversal), enclosed in
	 * square brackets ("[]"). Adjacent elements are separated by the characters ",
	 * " (comma and space).
	 * 
	 * @return a string representation of this collection t
	 */
	@Override
	public String toString() {
		// new string builder
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			// if the tree is empty
			return null;
		}
		sb.append("[");
		ArrayList<E> list = new ArrayList<E>();
		// inorder traversal
		inorder(list, root);
		// loop over the arraylist
		for (E e : list) {
			sb.append(e + ", ");
		}
		// remove the extra blank space
		sb.deleteCharAt(sb.length() - 1);
		// remove the extra comma
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Produces tree like string representation of this tree. Each node is shown in
	 * its own line with the indentation showing the depth of the node in this tree.
	 * The root is printed on the first line, followed by its left subtree, followed
	 * by its right subtree.
	 * 
	 * @return a string representation of this tree in a tree-like format.
	 *
	 */
	public String toStringTreeFormat() {
		StringBuffer sb = new StringBuffer();
		toStringTree(sb, root, 0);
		return sb.toString();
	}

	/**
	 * Helper method to print a tree
	 * 
	 */
	// uses preorder traversal to display the tree
	// WARNING: will not work if the data.toString returns more than one line
	private void toStringTree(StringBuffer sb, Node node, int level) {
		// display the node
		if (level > 0) {
			for (int i = 0; i < level - 1; i++) {
				sb.append("   ");
			}
			sb.append("|--");
		}
		if (node == null) {
			sb.append("->\n");
			return;
		} else {
			sb.append(node.data + "\n");
		}

		// display the left subtree
		toStringTree(sb, node.left, level + 1);
		// display the right subtree
		toStringTree(sb, node.right, level + 1);
	}

	/**
	 * Append to an arraylist the result of a inorder traversal
	 */
	private void inorder(ArrayList<E> list, Node node) {
		if (node == null) {
			return;
		}
		// go left
		inorder(list, node.left);
		// process the node
		list.add(node.data);
		// go right
		inorder(list, node.right);

	}

	/**
	 * Use the inorder traversal and return the result arraylist
	 */
	public ArrayList<E> toArrayInorder() {
		if (root == null)
			return null;
		ArrayList<E> list = new ArrayList<E>();
		inorder(list, root);
		return list;
	}

	/**
	 * Append to an arraylist the result of a preorder traversal
	 */
	private void preorder(ArrayList<E> list, Node node) {
		if (node == null) {
			return;
		}
		// process the node
		list.add(node.data);
		// go left
		inorder(list, node.left);
		// go right
		inorder(list, node.right);

	}

	/**
	 * Use the preorder traversal and return the result arraylist
	 */
	public ArrayList<E> toArrayPreorder() {
		if (root == null)
			return null;
		ArrayList<E> list = new ArrayList<E>();
		preorder(list, root);
		return list;
	}

	/**
	 * Append to an arraylist the result of a postorder traversal
	 *
	 */
	private void postorder(ArrayList<E> list, Node node) {
		if (node == null) {
			return;
		}
		// go left
		inorder(list, node.left);
		// go right
		inorder(list, node.right);
		// process the node
		list.add(node.data);
	}

	/**
	 * Use the postorder traversal and return the result arraylist
	 */
	public ArrayList<E> toArrayPostorder() {
		if (root == null)
			return null;
		ArrayList<E> list = new ArrayList<E>();
		postorder(list, root);
		return list;
	}

	/**
	 * A iterator over a tree using inorder traversal
	 *
	 * @return iterator over the elements in this tree in ascending order.
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	/**
	 * The iterator method adding restrictions and other implementations
	 *
	 * @return iterator over the elements in this tree in ascending order.
	 */
	private class MyIterator implements Iterator<E> {
		ArrayList<E> list;
		int current;

		MyIterator() {
			list = BST.this.toArrayInorder();
			current = 0;
		}

		public boolean hasNext() {
			return current < list.size();
		}

		public E next() {
			return list.get(current++);
		}

		// we could not use remove over a iterator
		public void remove() {
			throw new UnsupportedOperationException("You cannot use the remove method");
		}
	}

	/**
	 * A iterator over a tree using preorder traversal
	 *
	 * @return n iterator over the elements in this tree in ascending order.
	 */
	public Iterator<E> preorderIterator() {
		return new MypreorderIterator();
	}

	/**
	 * The iterator method adding restrictions and other implementations
	 *
	 * @return iterator over the elements in this tree in ascending order.
	 */
	private class MypreorderIterator implements Iterator<E> {
		ArrayList<E> list;
		int current;

		MypreorderIterator() {
			list = BST.this.toArrayPreorder();
			current = 0;
		}

		public boolean hasNext() {
			return current < list.size();
		}

		public E next() {
			return list.get(current++);
		}

		// remove prohibited
		public void remove() {
			throw new UnsupportedOperationException("You cannot use the remove method");
		}
	}

	/**
	 * A iterator over a tree using postorder traversal
	 *
	 * @return n iterator over the elements in this tree in ascending order.
	 */
	public Iterator<E> postorderIterator() {
		return new MyPostorderIterator();
	}

	/**
	 * The iterator method adding restrictions and other implementations
	 *
	 * @return iterator over the elements in this tree in ascending order.
	 */
	private class MyPostorderIterator implements Iterator<E> {
		ArrayList<E> list;
		int current;

		MyPostorderIterator() {
			list = BST.this.toArrayPostorder();
			current = 0;
		}

		public boolean hasNext() {
			return current < list.size();
		}

		public E next() {
			return list.get(current++);
		}

		// remove prohibited
		public void remove() {
			throw new UnsupportedOperationException("You cannot use the remove method");
		}
	}

}