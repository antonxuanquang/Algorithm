import java.util.ArrayList;
import java.util.Random;

import javax.swing.tree.TreeNode;


public class Eleven {
	/*
	 * 
	 * Random Node: You are implementing a binary tree class from scratch which,
	 * in addition to insert, find, and delete, has a method getRandomNode() which
	 * returns a random node from the tree. All nodes should be equally likely 
	 * to be chosen. Design and implement an algorithm for getRandomNode, and
	 * explain how you would implement the rest of the methods
	 * 
	 */
	
	/*
	 * 
	 * Book's solution
	 * 
	 */
	private static class TreeNode<T extends Comparable<T>> {
		private T data;
		public TreeNode left;
		public TreeNode right;
		private int size;
		
		public TreeNode(T item) {
			data = item;
			size = 1;
		}
		
		public TreeNode getIthNode(int i) {
			int leftSize = left == null ? 0 : left.size();
			if (i < leftSize) {
				return left.getIthNode(i);
			} else if (i == leftSize) {
				return this;
			} else {
				return right.getIthNode(i - (leftSize + 1));
			}
		}
		
		public void insertInOrder(T item) {
			if (item.compareTo(data) <= 0) {
				if (left == null) {
					left = new TreeNode<T>(item);
				} else {
					left.insertInOrder(item);
				}
			} else {
				if (right == null) {
					right = new TreeNode<T>(item);
				} else {
					right.insertInOrder(item);
				}
			}
			size++;
		}
		
		public int size() { return size;}
		public T data() { return data;}
		
		public TreeNode<T> find(T item) {
			if (item.equals(data)) {
				return this;
			} else if (item.compareTo(data) <= 0) {
				return left.find(item);
			} else if (item.compareTo(data) > 0) {
				return right.find(item);
			}
			return null;
		}
	}
	
	private static class Tree<T extends Comparable<T>> {
		TreeNode<T> root = null;
		
		public int size() {
			return root == null ? 0 : root.size();
		}
		
		public TreeNode<T> getRandomNode() {
			if (root == null) return null;
			
			Random random = new Random();
			int i = random.nextInt(size());
			
			return root.getIthNode(i);
		}
		
		public void insertInOrder(T item) {
			if (root == null) root = new TreeNode<T>(item);
			else root.insertInOrder(item);
		}
		
		public ArrayList<T> inorderTraversal() {
			ArrayList<T> result = new ArrayList<T>();
			inorderTraversal(result, root);
			return result;
		}

		private void inorderTraversal(ArrayList<T> result, TreeNode<T> node) {
			if (node != null) {
				inorderTraversal(result, node.left);
				result.add(node.data());
				inorderTraversal(result, node.right);
			}
		}
	}
	
	public static void main(String[] args) {
		Tree<String> tree = new Tree<String>();
		tree.insertInOrder("c");
		tree.insertInOrder("b");
		tree.insertInOrder("a");
		tree.insertInOrder("s");
		tree.insertInOrder("f");
		tree.insertInOrder("d");
		
		System.out.println(tree.getRandomNode().data());
		ArrayList<String> traverse = tree.inorderTraversal();
		for (String string: traverse) {
			System.out.println(string);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
