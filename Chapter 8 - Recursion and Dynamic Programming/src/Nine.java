import java.util.ArrayList;
import java.util.HashSet;


public class Nine {
	
	/*
	 * 
	 * Parens: Implement an algorithm to print all valid (e.g., properly opened and closed)
	 * combinations of n pairs of parentheses
	 * 
	 * Input: 3
	 * Output: ((())), (()()), (())(), ()()(), ()(())
	 * 
	 */
	
	/*
	 * 
	 * Brute force approach
	 * 
	 */
	public static ArrayList<String> parensBruteForce(int input) {
		ArrayList<String> result = new ArrayList<String>();
		if (input == 0) result.add("");
		else if (input == 1) result.add("()");
		else {
			ArrayList<String> subParens = parensBruteForce(input - 1);
			HashSet<String> memmo = new HashSet<String>();
			for (String paren: subParens) {
				for (int i = 0; i < paren.length(); i++) {
					if (paren.charAt(i) == '(') {
						String s = paren.substring(0,i + 1) + "()" + paren.substring(i + 1, paren.length());
						if (!memmo.contains(s)) {
							result.add(s);
							memmo.add(s);
						}
					}
				}
				result.add(paren + "()");
			}
		}
		return result;
	}
	
	/*
	 * 
	 * Build from scratch approach
	 * 
	 */
	public static ArrayList<String> parens (int count) {
		char [] characters = new char[count * 2];
		ArrayList<String> list = new ArrayList<String>();
		parens(list, count, count, characters, 0);
		return list;
	}
	
	private static void parens(ArrayList<String> list, int left, int right,
			char[] characters, int index) {
		if (left < 0 || right < left) return;
		
		if (left == 0 && right == 0) list.add(String.copyValueOf(characters));
		else {
			characters[index] = '(';
			parens(list, left - 1, right, characters, index + 1);
			
			characters[index] = ')';
			parens(list, left, right - 1, characters, index + 1);
		}
	}

	public static void main (String[] args) {
		// can't do more than 15 for bruteForce
		// can't do more than 17 for 2nd approach
		ArrayList<String> parens = parens(17);
		for (String paren: parens) System.out.println(paren);
	}
}
