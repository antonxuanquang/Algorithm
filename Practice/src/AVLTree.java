// Java program for insertion in AVL Tree
class Node {
	int key, height;
	Node left, right;

	Node(int d) {
		key = d;
		height = 1;
	}
}

class AVLTree {

	Node root;

	// A utility function to get height of the tree
	int height(Node N) {
		if (N == null)
			return 0;
		return N.height;
	}

	// A utility function to get maximum of two integers
	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// A utility function to right rotate subtree rooted with y
	// See the diagram given above.
	Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		x.right = y;
		y.left = T2;

		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		return x;
	}

	// A utility function to left rotate subtree rooted with x
	// See the diagram given above.
	Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;
		
		y.left = x;
		x.right = T2;
		
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		
		return y;
	}

	// Get Balance factor of node N
	int getBalance(Node N) {
		return height(N.left) - height(N.right);
	}

	Node insert(Node node, int key) {
		if (node == null) return new Node(key);
		
		if (key < node.key) node.left = insert(node.left, key);
		else if (node.key < key) node.right = insert(node.right, key);
		else return node;
		
		node.height = max(height(node.left), height(node.right)) + 1;
		
		int balanceFactor = getBalance(node);
		
		if (balanceFactor > 1 && key < node.left.key) {
			return rightRotate(node);
		} else if (balanceFactor > 1 && node.left.key < key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		} else if (balanceFactor < -1 && node.right.key < key) {
			return leftRotate(node);
		} else if (balanceFactor < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
		return node;
	}

	// A utility function to print preorder traversal
	// of the tree.
	// The function also prints height of every node
	void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.key + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		/* Constructing tree given in the above figure */
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 25);

		/*
		 * The constructed AVL Tree would be 30 / \ 20 40 / \ \ 10 25 50
		 */
		System.out.println("Preorder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
	}
}
// This code has been contributed by Mayank Jaiswal