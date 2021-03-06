import java.util.ArrayList;


public class BTNode<T extends Comparable<T>> {
	private T data;
	private int height;
	private BTNode<T> left;
	private BTNode<T> right;
	
	public BTNode(T data) {
		this.data = data;
	}
	
	public void setLeft(BTNode<T> item) {
		this.left = item; 
	}

	public BTNode<T> getLeft() {
		return this.left; 
	}

	public void setRight(BTNode<T> item) {
		this.right = item; 
	}
	
	public BTNode<T> getRight() {
		return this.right; 
	}
	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public static int getHeight(BTNode root) {
		if (root == null) return 0;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public ArrayList<T> infix() {
		ArrayList<T> result = new ArrayList<T>();
		infixTraverse(result, this);
		return result;
	}
	
	private void infixTraverse(ArrayList<T> array, BTNode<T> root) {
		if (root.left != null) infixTraverse(array, root.left);
		array.add(root.data);
		if (root.right != null) infixTraverse(array, root.right);
	}
}
