import javax.swing.RootPaneContainer;


public class Five {
	/*
	 * 
	 * Implement a function to check if a binary tree is a binary search tree
	 * 
	 */
	public static boolean isBST(BinaryTreeNode root) {
		if (root == null) return true;
		if (root.getLeft() != null) {
			int leftToRoot = root.getLeft().getLabel().compareTo(root.getLabel());
			if (leftToRoot > 0) return false;
		}
		if (root.getRight() != null) {
			int rightToRoot = root.getLabel().compareTo(root.getRight().getLabel());
			if (rightToRoot >= 0) return false;
		}
		return isBST(root.getLeft()) && isBST(root.getRight());
	}
	
	/*
	 * 
	 * Book's approach: Infix traversal concept
	 * 
	 */
	static String last_printed = null;
	public static boolean isBST2(BinaryTreeNode node) {
		if (node == null) return true;
		
		// check recursive left
		if (!isBST(node.getLeft())) return false;
		
		// check current
		if (last_printed != null && last_printed.compareTo(node.getLabel()) > 0) {
			return false;
		}
		
		last_printed = node.getLabel();
		
		// check recursive right
		if (!isBST(node.getRight())) return false;
		
		return true;
	}
	
	/*
	 * 
	 * Boook's approach: use range, as moving to the left, decrease max; moving to right, increase min.
	 * Whichever node fails to satisfy the range, return false.
	 * 
	 */
	
	public static boolean isBST3(BinaryTreeNode node) {
		return isBST3(node, null, null);
	}
	
	private static boolean isBST3(BinaryTreeNode node, String min, String max) {
		if (node == null) return true;
		
		if ((min != null && node.getLabel().compareTo(min) <= 0) 
				|| (max != null && node.getLabel().compareTo(max) > 0)) {
			return false;
		}
		
		if (!isBST3(node.getLeft(), min, node.getLabel()) 
				|| !isBST3(node.getRight(), node.getLabel(), max)) 
			return false;
		
		return true;
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

		// false case
//		a.setLeft(b);
//		a.setRight(h);
//		b.setLeft(c);
//		b.setRight(d);
////		c.setRight(h);
//		h.setLeft(e);
//		h.setRight(g);
//		e.setLeft(f);
//		System.out.println(isBST(a));
		
		// true case
		d.setLeft(b);
		b.setLeft(a);
		b.setRight(c);
		
		d.setRight(f);
		f.setLeft(e);
		f.setRight(g);
		
		g.setRight(h);
//		g.setLeft(h);
		
		
		System.out.println(isBST(d));
		System.out.println(isBST2(d));
		System.out.println(isBST3(d));
	}
}
