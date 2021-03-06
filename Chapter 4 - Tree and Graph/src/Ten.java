import java.util.ArrayList;
import java.util.LinkedList;


public class Ten {
	/*
	 * 
	 * Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2.
	 * Create an algorithm to determine if T2 is a subtree of T1.
	 * 
	 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of 
	 * n is identical to T2. That is, if you cut off the tree at node n, the two trees would
	 * be identical 
	 * 
	 */
	
	private static class Result {
		boolean found;
		boolean isIdentity;
		
		public Result(boolean found, boolean isIdentity) {
			this.found = found;
			this.isIdentity = isIdentity;
		}
	}
	
	public static boolean checkSubtree(BinaryTreeNode root, BinaryTreeNode node) {
		if (node == null) return true;
		Result result = checkSubtreeHelper(root, node);
		if (result.found) return result.isIdentity;
		return false;
	}
	
	private static Result checkSubtreeHelper(BinaryTreeNode root, BinaryTreeNode node) {
		if (root == null) return new Result(false, true);
		if (root.getLabel() == node.getLabel()) return new Result(true, isIdentity(root, node));
		
		Result left = checkSubtreeHelper(root.getLeft(), node);
		Result right = checkSubtreeHelper(root.getRight(), node);
		return new Result(left.found || right.found, left.isIdentity && right.isIdentity);
	}
	
	private static boolean isIdentity(BinaryTreeNode root, BinaryTreeNode node) {
		if (root == null && node == null) return true;
		if (!root.getLabel().equals(node.getLabel())) return false;
		boolean left = isIdentity(root.getLeft(), node.getLeft());
		boolean right = isIdentity(root.getRight(), node.getRight());
		return left && right;
	}
	
	/*
	 * 
	 * Book's approach
	 * 
	 */
	public static boolean containsTree(BinaryTreeNode t1, BinaryTreeNode t2) {
		if (t2 == null) return true;
		return subTree(t1, t2);
	}
	
	private static boolean subTree(BinaryTreeNode t1, BinaryTreeNode t2) {
		if (t1 == null) return false;
		if (t1.getLabel().equals(t2.getLabel()) && matchTree(t1, t2)) return true;
		return subTree(t1.getLeft(), t2) || subTree(t1.getRight(), t2);
	}
	
	

	private static boolean matchTree(BinaryTreeNode t1, BinaryTreeNode t2) {
		if (t1 == null && t2 == null) return true;
		else if (t1 == null || t2 == null) return false;
		else if (!t1.getLabel().equals(t2.getLabel())) return false;
		else return matchTree(t1.getLeft(), t2.getLeft()) 
				&& matchTree(t1.getRight(), t2.getRight());
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
		
		BinaryTreeNode i = new BinaryTreeNode("e");
		BinaryTreeNode k = new BinaryTreeNode("f");
		BinaryTreeNode l = new BinaryTreeNode("g");
		BinaryTreeNode m = new BinaryTreeNode("h");
		
		a.setLeft(b);
		a.setRight(h);
		b.setLeft(c);
		b.setRight(d);
//		c.setRight(h);
		h.setLeft(e);
		h.setRight(g);
		e.setLeft(f);
		
		m.setLeft(i);
		m.setRight(l);
		i.setLeft(k);
		
		System.out.println(checkSubtree(a, m));
		System.out.println(containsTree(a, m));
	}
}
