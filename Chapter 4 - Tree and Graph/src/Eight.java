
public class Eight {
	/*
	 * 
	 * First Common Ancestor: Design an algorithm and write code to find the first
	 * common ancestor of two nodes in a binary tree. Avoid storing additional 
	 * nodes in a data structure. NOTE: this is not necessarily a binary search tree.
	 * 
	 */

	private static boolean findBranch(BinaryTreeNode root, BinaryTreeNode node) {
		if (root == null) return false;
		if (root == node) return true;
		return findBranch(root.getLeft(), node) || findBranch(root.getRight(), node);
	}
	
	/*
	 * 
	 * Brute force approach
	 * 
	 */
	public static BinaryTreeNode findCommonAncestorBruteFore (
			BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right) {
		if (!findBranch(root, left) && !findBranch(root, right)) return null;
		return findCommonAncestorBruteForeHelper(root, left, right);
	}
	public static BinaryTreeNode findCommonAncestorBruteForeHelper (
			BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right) {
		boolean onLeftBranch = findBranch(root.getLeft(), left);
		boolean onRightBranch = findBranch(root.getRight(), right);
		if 		(onLeftBranch && onRightBranch) return root;
		else if (onLeftBranch) 					return findCommonAncestorBruteFore(root.getLeft(), left, right);
		else if (onRightBranch)					return findCommonAncestorBruteFore(root.getRight(), left, right);
		return root;
	}
	
	/*
	 * 
	 * Book's optimal approach: still don't understand
	 * 
	 */
	private static class Result {
		public BinaryTreeNode node;
		public boolean isAncestor;
		public Result(BinaryTreeNode node, boolean isAnc) {
			this.node = node;
			this.isAncestor = isAnc;
		}
	}
	
	public static Result commonAncestor(
			BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
		Result r = commonAncestorHelper(root, p, q);
		if (r.isAncestor) return r;
		return null;
	}
	
	private static Result commonAncestorHelper(BinaryTreeNode root,
			BinaryTreeNode p, BinaryTreeNode q) {
		if (root == null) return new Result(null, false);
		
		if (root == p && root == q) return new Result(root, true);
		
		Result rx = commonAncestorHelper(root.getLeft(), p, q);
		if (rx.isAncestor) return rx; // found common ancestor
		
		Result ry = commonAncestorHelper(root.getRight(), p, q);
		if (ry.isAncestor) return ry; // found common ancestor
		
		if (rx.node != null && ry.node != null)
			return new Result(root, true); // this is the common ancestor
		else if (root == p || root == q) {
			boolean isAncestor = rx.node != null || ry.node != null;
			return new Result(root, isAncestor);
		} else {
			return new Result(rx.node != null ? rx.node : ry.node, false);
		}
			
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
		BinaryTreeNode node = findCommonAncestorBruteFore(a, g, d);
		BinaryTreeNode node2 = commonAncestor(a, b, c).node;
		System.out.println(node.getLabel());
		System.out.println(node2.getLabel());
	}
}
