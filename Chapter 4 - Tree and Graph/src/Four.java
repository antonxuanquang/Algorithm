
public class Four {
	/*
	 * 
	 * Implement a function to check if a binary tree is balanced. For the purpose 
	 * of this question, a balanced tree is defined to be a tree such that the 
	 * heights of the two subtrees of any node never differ by more than one.
	 */
	
	/*
	 * 
	 * First approach: time complexity N log N, space complexity
	 * 
	 */
	public static boolean isBalanced(BinaryTreeNode root) {
		if (root == null) return true; // base case
		int leftHeight = getHeight(root.getLeft());
		int rightHeight = getHeight(root.getRight());
		int diff = Math.abs(leftHeight - rightHeight);
		
		if (diff > 1) return false;
		else return isBalanced(root.getLeft()) && isBalanced(root.getRight());
	}
	
	private static int getHeight(BinaryTreeNode root) {
		if (root == null) return 0;
		return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
	}
	
	/*
	 * 
	 * Second approach: check balanced along with height
	 * 
	 */
	public static boolean isBalanced2(BinaryTreeNode root) {
		return getHeight2(root) != Integer.MIN_VALUE;
	}
	
	private static int getHeight2(BinaryTreeNode root) {
		if (root == null) return 0;
		int leftHeight = getHeight2(root.getLeft());
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int rightHeight = getHeight2(root.getRight());
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int diff = Math.abs(leftHeight - rightHeight);
		if (diff > 1) return Integer.MIN_VALUE;
		else return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode a = new BinaryTreeNode("a");
		BinaryTreeNode b = new BinaryTreeNode("b");
		BinaryTreeNode c = new BinaryTreeNode("c");
		BinaryTreeNode d = new BinaryTreeNode("d");
		BinaryTreeNode e = new BinaryTreeNode("e");
		BinaryTreeNode f = new BinaryTreeNode("f");
		BinaryTreeNode g = new BinaryTreeNode("g");
		BinaryTreeNode h = new BinaryTreeNode("h");

		a.setLeft(b);
		a.setRight(h);
		b.setLeft(c);
		b.setRight(d);
//		c.setRight(h);
		h.setLeft(e);
		h.setRight(g);
		e.setLeft(f);
		
		System.out.println(isBalanced(a));
		System.out.println(isBalanced2(a));
	}
}
