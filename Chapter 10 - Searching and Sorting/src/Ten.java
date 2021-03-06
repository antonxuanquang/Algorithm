
public class Ten {
	
	/*
	 * 
	 * Rank from Stream: Imagine you are reading in a stream of integers. Periodically, 
	 * you wish to be able to look up the rank of a number x (the number of values less
	 * than or equal to x). Implement the data structures and algorithms to support 
	 * these operations. That is, implement the method track(int x), which is called 
	 * when each number is generated, and the method getRankOfNumber(int x), which returns
	 * the number of values less than or equal to x (not including x itself).
	 * 
	 * Example: 
	 * 	+ Stream (in order of appearances): 5, 1, 4, 4, 5, 9, 7, 13, 3
	 * 	+ getRankOfNumber(1) = 0
	 *  + getRankOfNumber(3) = 1
	 *  + getRankofNumber(4) = 3
	 * 
	 */
	
	private static class BSTNode {
		private int value;
		private int size;
		private BSTNode left;
		private BSTNode right;
		
		public BSTNode(int value) {
			this.value = value;
		}
		

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public BSTNode getLeft() {
			return left;
		}

		public void setLeft(BSTNode left) {
			this.left = left;
		}

		public BSTNode getRight() {
			return right;
		}

		public void setRight(BSTNode right) {
			this.right = right;
		}
		
		public int getSize() {
			if (left == null && right == null) return 1;
			int leftSize = 0, rightSize = 0;
			if (left != null) leftSize = left.getSize();
			if (right != null) rightSize = right.getSize();
			return leftSize + rightSize + 1;
		}
		
		public void infix() {
			if (left != null) left.infix();
			System.out.println(this.getValue());
			if (right != null) right.infix();
		}
	}
	
	private static class StreamTree {
		BSTNode root;
		
		public void track(int value) {
			if (root == null) {
				root = new BSTNode(value);
				return;
			}
			
			BSTNode runner = root;
			BSTNode previous = null;
			while (runner != null) {
				previous = runner;
				if (value >= runner.getValue()) {
					runner = runner.getRight();
				} else {
					runner = runner.getLeft();
				}
			}
			
			if (value >= previous.getValue()) {
				previous.setRight(new BSTNode(value));
			} else {
				previous.setLeft(new BSTNode(value));
			}
		}
		
		public int getRankOfNumber(int value) {
			int rank = 0;
			BSTNode runner = root;
			while (runner != null) {
				if (runner.getValue() == value) {
					int left = 0;
					if (runner.getLeft() != null) left = runner.getLeft().getSize();
					rank += left;
					if (runner.getRight() != null && runner.getRight().getValue() == value) {
						rank++;
						runner = runner.getRight();
					} else {						
						return rank;
					}
				} else if (value < runner.getValue()) {
					runner = runner.getLeft();
				} else if (value >= runner.getValue()){
					if (runner.getLeft() != null) rank += runner.getLeft().getSize();
					rank++;
					runner = runner.getRight();
				}
			}
			return -1;
		}
		
		public void infix() {
			root.infix();
		}
	}
	
	/*
	 * 
	 * Book's approach
	 * 
	 */
	
	private static RankNode root = null;
	
	private static class RankNode {
		public int left_size = 0;
		public RankNode left, right;
		public int data;
		
		public RankNode(int data) {
			this.data = data;
		}
		
		public void insert(int value) {
			if (value <= data) {
				if (left != null) left.insert(value);
				else left = new RankNode(value);
				left_size++;
			} else {
				if (right != null) right.insert(value);
				else right = new RankNode(value);
			}
		}
		
		public int getRank(int value) {
			if (value == data) {
				return left_size;
			} else if (value <= data) {
				if (left == null) return -1;
				else return left.getRank(value);
			} else {
				int right_rank = right == null ? -1 : right.getRank(value);
				if (right_rank == -1) return -1;
				else return right_rank + 1 + left_size;
			}
		}
	}
	
	public static void track(int number) {
		if (root == null) {
			root = new RankNode(number);
		} else {
			root.insert(number);
		}
	}
	
	public static int getRankOfNumber(int number) {
		return root.getRank(number);
	}
	
	public static void main(String[]args) {
		StreamTree tree = new StreamTree();
		tree.track(5);
		tree.track(1);
		tree.track(4);
		tree.track(4);
		tree.track(5);
		tree.track(9);
		tree.track(7);
		tree.track(13);
		tree.track(3);
		
		
		track(5);
		track(1);
		track(4);
		track(4);
		track(5);
		track(9);
		track(7);
		track(13);
		track(3);
		
		System.out.println(tree.getRankOfNumber(1));
		System.out.println(tree.getRankOfNumber(9));
		System.out.println(tree.getRankOfNumber(5));
		System.out.println(tree.getRankOfNumber(2));
		
		System.out.println(getRankOfNumber(1));
		System.out.println(getRankOfNumber(9));
		System.out.println(getRankOfNumber(5));
		System.out.println(getRankOfNumber(2));
	}
}
