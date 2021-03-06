import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;


public class Nine {
	/*
	 * 
	 * BST Sequence: A binary search tree was created by traversing through an 
	 * array from left to right and inserting each element. Given a binary search
	 * tree with distinct elements, print all possible arrays that could have 
	 * led to this tree. 
	 * 
	 */
	 
	
	/*
	 * 
	 * Fail to implement this
	 * 
	 */
	public static ArrayList<ArrayList<String>> BSTSequence(BinaryTreeNode root) {
		ArrayList<ArrayList<String>> arrays = new ArrayList<ArrayList<String>>();
		BSTSequenceHelper(root, arrays, null);
		return arrays;
	}
	
	private static void BSTSequenceHelper(
			BinaryTreeNode root, ArrayList<ArrayList<String>> result, ArrayList<String> current) {
		if (root == null) return;		
		BSTSequenceHelper(root.getLeft(), result, current);
		BSTSequenceHelper(root.getRight(), result, current);
		if (current == null) {
			current = new ArrayList<String>();
			result.add(current);
		}
		for (ArrayList<String> list: result) {
			list.add(root.getLabel());
		}
	}
	
	private static ArrayList<String> duplicate(ArrayList<String> current) {
		ArrayList<String> result = new ArrayList<String>();
		for (String string: current) result.add(string);
		return result;
	}
	
	
	/*
	 * 
	 * Book's solution
	 * 
	 */
	public static ArrayList<LinkedList<String>> allSequences(BinaryTreeNode root) {
		ArrayList<LinkedList<String>> result = new ArrayList<LinkedList<String>>();
		
		if (root == null) {
			result.add(new LinkedList<String>());
			return result;
		}
		
		LinkedList<String> prefix = new LinkedList<String>();
		prefix.add(root.getLabel());
		
		ArrayList<LinkedList<String>> leftSeq = allSequences(root.getLeft());
		ArrayList<LinkedList<String>> rightSeq = allSequences(root.getRight());
		
		for (LinkedList<String> left: leftSeq) {
			for (LinkedList<String> right: rightSeq) {
				ArrayList<LinkedList<String>> weaved = 
						new ArrayList<LinkedList<String>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		
		return result;
	}
	
	
	
	private static void weaveLists(LinkedList<String> first, LinkedList<String> second,
			ArrayList<LinkedList<String>> results, LinkedList<String> prefix) {
		/*
		 * One list is empty. Add remainder to [a cloned] prefix and store result
		 */
		
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<String> result = (LinkedList<String>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		/*
		 * Recurse with head of first added to the prefix. Removing the head
		 * will damage first, so we'll need to put it back where we found it afterwards
		 */
		String headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		/*
		 * Do the same thing with second, damaging and then restoring the list
		 */
		String headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.add(headSecond);
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
		
		ArrayList<LinkedList<String>> result = allSequences(a);
		for (LinkedList<String> array: result) {
			for (String string: array) {
				System.out.print(string + " ");
			}
			System.out.println();
		}
	}
}
