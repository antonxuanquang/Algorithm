import java.util.HashMap;

public class Fourteen {

	/*
	 * 
	 * Boolean Evaluation: Given a boolean expression consisting of the symbols
	 * 0 (false), 1 (true), & (AND), | (OR), and ^ (XOR), and a desired boolean
	 * result value result, implement a function to count the number of ways of
	 * parenthesizing the expression such that it evaluates to result. The
	 * expression should be fully parenthesized (e.g., (0)^(1)) but not
	 * extraneously (e.g., (((0))^(1))))
	 * 
	 * Example: 
	 * 		countEval("1^0|0|1", false) -> 2 
	 * 		countEval("0&0&0&1^1|0", true) -> 10
	 * 
	 */

	/*
	 * 
	 * Book's solution
	 * 
	 */
	
	private static int countEval(String s, boolean result) {
		return countEval(s, result, new HashMap<String, Integer>());
	}

	public static int countEval(String s, boolean result, 
			HashMap<String, Integer> memo) {
		if (s.length() == 0) return 0;
		if (s.length() == 1) return s.equals("1") == result ? 1 : 0;
		if (memo.containsKey(result + s)) return memo.get(result + s);

		int ways = 0;

		for (int i = 1; i < s.length(); i += 2) {
			char c = s.charAt(i);
			String leftSub = s.substring(0, i);
			String rightSub = s.substring(i + 1, s.length());

			int leftFalse = countEval(leftSub, false, memo);
			int leftTrue = countEval(leftSub, true, memo);
			int rightFalse = countEval(rightSub, false, memo);
			int rightTrue = countEval(rightSub, true, memo);

			int total = (leftFalse + leftTrue) * (rightFalse + rightTrue);

			int totalTrue = 0;
			if (c == '&') {
				totalTrue = leftTrue * rightTrue;
			} else if (c == '|') {
				totalTrue = (leftFalse * rightTrue) + (leftTrue * rightFalse)
						+ (leftTrue * rightTrue);
			} else if (c == '^') {
				totalTrue = (leftFalse * rightTrue) + (leftTrue * rightFalse);
			}

			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}

		memo.put(result + s, ways);
		return ways;
	}

	public static void main(String args[]) {
		System.out.println(countEval("1^0|0|1", false));
		System.out.println(countEval("0&0&0&1^1|0", true));
	}

}
