import java.util.Arrays;


public class One {
	
	/*
	 * 
	 * Triple Step: A child is running up a staircase with n steps
	 * and can hop either 1 step, 2 steps, or 3 steps at a time. 
	 * Implement a method to count how many possible ways the child
	 * can run up the stairs
	 * 
	 */
	
	public static int tripleStep(int n) {
		return tripleStep(n, new int[n + 1]);
	}

	private static int tripleStep(int n, int[] memo) {
		if (n < 0) return 0;
		else if (n <= 0) return 1;
		else if (memo[n] == 0) {
			memo[n] = tripleStep(n - 1, memo) + tripleStep(n - 2, memo)
					+ tripleStep(n - 3, memo);
		}
		
		return memo[n];
	}
	
	/*
	 * 
	 * Book's approach
	 * 
	 */
	public static int countWays(int n) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return countWays(n, memo);
	}
	
	private static int countWays(int n, int[] memo) {
		if (n < 0) return 0;
		else if (n == 0) return 1;
		else if (memo[n] > -1) return memo[n];
		else {
			memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo)
					+ countWays(n - 3, memo);
			return memo[n];
		}
	}

	public static void main (String[] args) {
		System.out.println(tripleStep(1));
		System.out.println(tripleStep(2));
		System.out.println(tripleStep(3));
		System.out.println(tripleStep(37));
		
		System.out.println(countWays(1));
		System.out.println(countWays(2));
		System.out.println(countWays(3));
		System.out.println(countWays(37));
	}

}
