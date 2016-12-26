import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwapAlgo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// create Tree
		Node root = buildTree(sc);

		// do the swap + print inorder traversal
		doSwap(root, sc);
	}

	private static void doSwap(Node root, Scanner sc) {
		int swapLines = sc.nextInt();
		for (int i = 0; i < swapLines; i++) {
			int level = sc.nextInt();
			swapNode(root, 1, level);
			inOrderTraversal(root);
			System.out.println();
		}
	}

	private static void swapNode(Node root, int currentLevel, int level) {
		if (root == null) return;
		if (currentLevel % level == 0) root.swap();
		swapNode(root.left, currentLevel + 1, level);
		swapNode(root.right, currentLevel + 1, level);
	}

	private static void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);
		}
	}

	private static Node buildTree(Scanner sc) {
		int treeLines = sc.nextInt();
		Node root = new Node(1);
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		for (int i = 0; i < treeLines; i++) {
			Node node = queue.poll();
			int left = sc.nextInt();
			int right = sc.nextInt();
			if (left != -1) {
				Node leftNode = new Node(left);
				node.left = leftNode;
				queue.add(leftNode);
			}
			if (right != -1) {
				Node rightNode = new Node(right);
				node.right = rightNode;
				queue.add(rightNode);
			}
		}
		return root;
	}

	private static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		public void swap() {
			Node leftNode = this.left;
			Node rightNode = this.right;
			this.left = rightNode;
			this.right = leftNode;
		}
	}
}
