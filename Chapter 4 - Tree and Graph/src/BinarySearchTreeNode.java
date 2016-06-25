
public class BinarySearchTreeNode {
	private String label;
	private int height;
	private BinarySearchTreeNode left;
	private BinarySearchTreeNode right;
	
	public BinarySearchTreeNode(String label) {
		this.label = label;
	}
	
	public void setLeft(BinarySearchTreeNode item) {
		this.left = item; 
	}

	public BinarySearchTreeNode getLeft() {
		return this.left; 
	}

	public void setRight(BinarySearchTreeNode item) {
		this.right = item; 
	}
	
	public BinarySearchTreeNode getRight() {
		return this.right; 
	}
	

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public static int getHeight(BinarySearchTreeNode root) {
		if (root == null) return 0;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public String infix() {
		StringBuilder result = new StringBuilder();
		infixTraverse(result, this);
		return result.toString();
	}
	
	private void infixTraverse(StringBuilder builder, BinarySearchTreeNode root) {
		if (root.left != null) infixTraverse(builder, root.left);
		builder.append(root.label + "\n");
		if (root.right != null) infixTraverse(builder, root.right);
	}
	
	
}
