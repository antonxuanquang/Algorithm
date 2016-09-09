import java.util.ArrayList;


public class Seven {
	
	/*
	 * 
	 * Permutations without Dups: Write a method to compute all permutation
	 * of a string of unique characters
	 * 
	 */
	
	public static ArrayList<String> permutation(String string) {
		ArrayList<String> result = new ArrayList<String>();
		if (string.length() == 0) {
			result.add("");
			return result;
		}else {
			for (int i = 0; i < string.length(); i++) {
				char firstChar = string.charAt(i);
				String subString = string.substring(0, i) + string.substring(i + 1, string.length());
				ArrayList<String> permutations = permutation(subString);
				for (String sub: permutations) {
					result.add(firstChar + sub);
				}
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		ArrayList<String> permutation = permutation("abcde");
		for (String string: permutation) System.out.println(string);
	}

}
