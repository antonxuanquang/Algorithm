import java.util.ArrayList;
import java.util.LinkedList;

public class Three {
	/*
	 * 
	 * Given a binary tree, design an algorithm which creates a linked list of
	 * all the nodes at each depth (e.g., if you have a tree with depth D,
	 * you'll have D linked lists)
	 */
	
	
	/*
	 * 
	 * My approach: create a linked list (current linked list) of first level, 
	 * then add child node to another linked list, then, after all, point current
	 * linked list to the newly created linked list.
	 * This approach is breadth first search approach
	 * 
	 */
	public static ArrayList<LinkedList<BinaryTreeNode>> createLevelLinkedList(
			BinaryTreeNode root) {
		if (root == null) return null;
		LinkedList<BinaryTreeNode> currentLevel = new LinkedList<BinaryTreeNode>();
		ArrayList<LinkedList<BinaryTreeNode>> levelLinkedLists = new ArrayList<LinkedList<BinaryTreeNode>>();
		currentLevel.add(root);
		levelLinkedLists.add(currentLevel);
		while (!currentLevel.isEmpty()) {
			LinkedList<BinaryTreeNode> newLevel = new LinkedList<BinaryTreeNode>();
			for (BinaryTreeNode node : currentLevel) {
				if (node.getLeft() != null) newLevel.add(node.getLeft());
				if (node.getRight() != null) newLevel.add(node.getRight());
			}
			currentLevel = newLevel;
			if (newLevel.size() > 0) levelLinkedLists.add(newLevel);
		}
		return levelLinkedLists;
	}
	
	/*
	 * 
	 * Book's approach: recursive call, following the concept of depth-first search
	 * 
	 * 
	 */
	
	public static ArrayList<LinkedList<BinaryTreeNode>> createLevelLinkedListbyDFS(
			BinaryTreeNode root) {
		ArrayList<LinkedList<BinaryTreeNode>> lists = new ArrayList<LinkedList<BinaryTreeNode>>();
		createLevelLinkedListbyDFS(root, lists, 0);
		return lists;
	}
	
	private static void createLevelLinkedListbyDFS(BinaryTreeNode root, 
			ArrayList<LinkedList<BinaryTreeNode>> lists, int level) {
		if (root == null) return; // base case
		LinkedList<BinaryTreeNode> list;
		if (lists.size() == level) {
			list = new LinkedList<BinaryTreeNode>(); // level not contained in list
			/*
			 * Levels are always traversed in order. So, if this is the first time we've visited
			 * level i, we must have seen levels 0 through i - 1. We can therefore safely
			 * add the level at the end.
			 */
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedListbyDFS(root.getLeft(), lists, level + 1);
		createLevelLinkedListbyDFS(root.getRight(), lists, level + 1);
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
		
		ArrayList<LinkedList<BinaryTreeNode>> levelLinkedLists = createLevelLinkedList(a);
		for (LinkedList<BinaryTreeNode> currentLevel: levelLinkedLists) {
			for (BinaryTreeNode node: currentLevel) {
				System.out.println(node.getLabel());
			}
			System.out.println("---------");
		}
		System.out.println(levelLinkedLists.size());
		ArrayList<LinkedList<BinaryTreeNode>> levelLinkedListsbyDFS = createLevelLinkedListbyDFS(a);
		for (LinkedList<BinaryTreeNode> currentLevel: levelLinkedListsbyDFS) {
			for (BinaryTreeNode node: currentLevel) {
				System.out.println(node.getLabel());
			}
			System.out.println("---------");
		}
		System.out.println(levelLinkedListsbyDFS.size());
	}
}
