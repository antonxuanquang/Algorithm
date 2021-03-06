import java.util.ArrayList;
import java.util.HashMap;


public class Twelve {
	/*
	 * 
	 * Paths wit Sum: you are given a binary tree in which each node contains 
	 * an integer value (which might be positive or negative). Design an 
	 * algorithm to count the number of paths that sum to a given value.
	 * The path does not need to start or end at the root or a leaf, but it
	 * must go downwards (traveling only from parent nodes to child nodes) 
	 * 
	 */
	
	private static class Result {
		ArrayList<Integer> sum;
		int count;
		
		public Result(ArrayList<Integer> sum, int count) {
			this.sum = sum;
			this.count = count;
		}
	}
	
	public static int pathWithSum(BTNode<Integer> node, int number) {
		Result result = pathWithSumHelper(node, number);
		return result.count;
	}

	private static Result pathWithSumHelper(BTNode<Integer> node, int number) {
		if (node == null) return new Result(new ArrayList<Integer>(), 0);
		
		Result leftSum = pathWithSumHelper(node.getLeft(), number);
		Result rightSum = pathWithSumHelper(node.getRight(), number);
		
		ArrayList<Integer> sumArray = new ArrayList<Integer>();
		sumArray.add(node.getData());
		for (int left: leftSum.sum) {
			sumArray.add(left + node.getData());
		}
		for (int right: rightSum.sum) {
			sumArray.add(right + node.getData());
		}
		int count = 0;
		for (int sum: sumArray) 
			if (sum == number) count++;
		return new Result(sumArray, count + leftSum.count + rightSum.count);		
	}
	
	/*
	 * 
	 * Book's solution
	 * 
	 */
	public static int countPathsWithSum(BTNode<Integer> node, int targetSum) {
		return countPathsWithSum(node, targetSum, 0, new HashMap<Integer, Integer>());
	}
	
	
	private static int countPathsWithSum(BTNode<Integer> node, int targetSum,
			int runningSum, HashMap<Integer, Integer> pathCount) {
		if (node == null) return 0; // base case
		
		/* Count paths with sum ending at the current node */
		runningSum += node.getData();
		int sum = runningSum - targetSum;
		int totalPaths = pathCount.getOrDefault(sum, 0);
		
		/* If runningSum equals targetSum, then one additional path starts at root.
		 * Add in this path.
		 */
		if (runningSum == targetSum) totalPaths++;
		
		/* Increment pathCount, recurse, then decrement pathCount */
		incrementHashTable(pathCount, runningSum, 1);
		totalPaths += countPathsWithSum(node.getLeft(), targetSum, runningSum, pathCount);
		totalPaths += countPathsWithSum(node.getRight(), targetSum, runningSum, pathCount);
		incrementHashTable(pathCount, runningSum, -1);
		
		return totalPaths;
	}

	private static void incrementHashTable(HashMap<Integer, Integer> pathCount,
			int runningSum, int delta) {
		int newCount = pathCount.getOrDefault(runningSum, delta);
		if (newCount == 0) 	pathCount.remove(runningSum);
		else 				pathCount.put(runningSum, newCount);
	}

	public static void main(String[] args) {
		BTNode<Integer> a = new BTNode<Integer>(6);
		BTNode<Integer> b = new BTNode<Integer>(7);
		BTNode<Integer> c = new BTNode<Integer>(8);
		BTNode<Integer> d = new BTNode<Integer>(-5);
		BTNode<Integer> e = new BTNode<Integer>(3);
		BTNode<Integer> f = new BTNode<Integer>(2);
		BTNode<Integer> g = new BTNode<Integer>(5);
		BTNode<Integer> h = new BTNode<Integer>(-4);
		BTNode<Integer> i = new BTNode<Integer>(2);

		a.setLeft(b);
		a.setRight(h);
		b.setLeft(c);
		b.setRight(d);
		h.setLeft(e);
		h.setRight(g);
		e.setLeft(f);
		e.setRight(i);
		
		System.out.println(pathWithSum(a, 11) + " 11");
		System.out.println(pathWithSum(a, 6) + " 6");
		System.out.println(pathWithSum(a, 8) + " 8");
		System.out.println(pathWithSum(a, 13) + " 13");
		System.out.println(pathWithSum(a, 5) + " 5");
//		System.out.println(pathWithSum(a, 7) + " 7");
//		System.out.println(pathWithSum(a, 4) + " 4");
//		System.out.println(pathWithSum(a, 3) + " 3");
//		System.out.println(pathWithSum(a, 2) + " 2");
//		System.out.println(pathWithSum(a, 1) + " 1");
		System.out.println();
//		System.out.println(countPathsWithSum(a, 11) + " 11");
		System.out.println(countPathsWithSum(a, 6) + " 6");
//		System.out.println(countPathsWithSum(a, 8) + " 8");
//		System.out.println(countPathsWithSum(a, 13) + " 13");
//		System.out.println(countPathsWithSum(a, 5) + " 5");
	}
}
