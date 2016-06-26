
public class Six {
	/*
	 * 
	 * Write an algorithm to find the "next" node (i.e. in-order successor) of a given 
	 * node in a binary search tree. You may assume that each node has a link to its 
	 * parent.
	 * 
	 */
	
	/*
	 * 
	 * Answer:
	 * Node inorderSuccessor(Node n) {
	 * 	if (n has a right subtree) {
	 * 		return leftmost child of right subtree
	 * 	} else {
	 * 		while (n is a right child of n.parent)
	 * 			n = n.parent
	 * 		return n.parent
	 * 	}
	 * }
	 * 
	 */
}
