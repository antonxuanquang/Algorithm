import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Eight {
	
	/*
	 * 
	 * Permutations with Dups: Write a method to compute all permutation
	 * of a string whose characters are not necessarily unique. The list
	 * of permutations should not have duplicates
	 * 
	 */
	
	public static ArrayList<String> permutation(String string) {
		ArrayList<String> result = new ArrayList<String>();
		if (string.length() == 0) {
			result.add("");
			return result;
		}else {
			int[] memmo = new int[256]; 
			for (int i = 0; i < string.length(); i++) {
				char firstChar = string.charAt(i);
				if (memmo[firstChar] == 0) memmo[firstChar]++;
				else continue;
				String subString = string.substring(0, i) + string.substring(i + 1, string.length());
				ArrayList<String> permutations = permutation(subString);
				for (String sub: permutations) {
					String s = firstChar + sub;
					result.add(s);
				}
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		ArrayList<String> permutation = permutation("lalala");
		for (String string: permutation) System.out.println(string);
	}
}
