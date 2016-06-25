import java.util.ArrayList;


public class Two {
	/*
	 * 
	 * Given a sorted (incresing order) array with unique integer elements, 
	 * write an algorithm to create a binary search tree with minimum height
	 * 
	 */
	public static BinarySearchTreeNode buildTree(int[] input) {
		BinarySearchTreeNode tree = new BinarySearchTreeNode(null);
		tree = buildTree(input, 0, input.length - 1);
		return tree;
	}
	
	private static BinarySearchTreeNode buildTree(int[] input, int start, int end) {
		if (start > end) return null; 
		if (start == end) return new BinarySearchTreeNode("" + input[start]);
		int mid = (start + end) / 2;
		BinarySearchTreeNode root = new BinarySearchTreeNode("" + input[mid]);
		root.setLeft(buildTree(input, start, mid - 1));
		root.setRight(buildTree(input, mid + 1, end));
		return root;
	}
	
	public static void main (String[] args) {
		int [] input = {1,2,4,5,6,9,10,12,15,16,22,25,26,29,30,31};
		BinarySearchTreeNode root = buildTree(input);
		System.out.println(root.infix());
		System.out.println(BinarySearchTreeNode.getHeight(root));
		
		
//		BinarySearchTreeNode a = new BinarySearchTreeNode("a");
//		BinarySearchTreeNode b = new BinarySearchTreeNode("b");
//		BinarySearchTreeNode c = new BinarySearchTreeNode("c");
//		BinarySearchTreeNode d = new BinarySearchTreeNode("d");
//		BinarySearchTreeNode e = new BinarySearchTreeNode("e");
//		BinarySearchTreeNode f = new BinarySearchTreeNode("f");
//		BinarySearchTreeNode g = new BinarySearchTreeNode("g");
//		BinarySearchTreeNode h = new BinarySearchTreeNode("h");
//		
//		a.setLeft(b);
//		a.setRight(h);
//		b.setLeft(c);
//		b.setRight(d);
////		c.setRight(h);
//		h.setLeft(e);
//		h.setRight(g);
//		e.setLeft(f);
//		System.out.println(BinarySearchTreeNode.getHeight(a));
	}
}
