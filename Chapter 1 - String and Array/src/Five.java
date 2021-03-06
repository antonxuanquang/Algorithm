
public class Five {
	public static void main(String args[]) {
//		System.out.println(isOneAway("pale", "ple"));
//		System.out.println(isOneAway("pales", "pale"));
//		System.out.println(isOneAway("pale", "bale"));
//		System.out.println(isOneAway("psale", "pale"));
//		System.out.println(isOneAway("pale", "bake"));
//		System.out.println(isOneAway("bale", "able"));
//		System.out.println(isOneAway("bale", "bble"));
		
		
//		System.out.println(isOneAway1("pale", "ple"));
//		System.out.println(isOneAway1("pales", "pale"));
//		System.out.println(isOneAway1("pale", "bale"));
//		System.out.println(isOneAway1("psale", "pale"));
//		System.out.println(isOneAway1("pale", "bake"));
//		System.out.println(isOneAway1("bale", "able"));
//		System.out.println(isOneAway1("bale", "bble"));
		
		System.out.println(isOneAway2("pale", "ple"));
		System.out.println(isOneAway2("pales", "pale"));
		System.out.println(isOneAway2("pale", "bale"));
		System.out.println(isOneAway2("psale", "pale"));
		System.out.println(isOneAway2("pale", "bake"));
		System.out.println(isOneAway2("bale", "able"));
		System.out.println(isOneAway2("bale", "bble"));
	}
	
	/*
	 * 
	 * My answer
	 * 
	 */

	private static boolean isOneAway(String left, String right) {
		int left_length = left.length();
		int right_length = right.length();
		if (Math.abs(left_length - right_length) > 1) return false;
		
		int error = 0;
		int shorter = Math.min(left_length, right_length);
		int left_counter = 0;
		int right_counter = 0;
		
		while(left_counter < shorter || right_counter < shorter) {
			try {
				if (left.charAt(left_counter) != right.charAt(right_counter)) {	
					if (left.charAt(left_counter + 1) == right.charAt(right_counter)) {
						left_counter++;
					} else if (left.charAt(left_counter) == right.charAt(right_counter + 1)) {
						right_counter++;
					}
					error++;
				}
			} catch (Exception e) {}
			left_counter++;
			right_counter++;
		}
		
		return error <= 1;
	}
	
	
	/*
	 * 
	 * The book's answer: module approach
	 * 
	 */
	private static boolean isOneAway1(String first, String second) {
		if (first.length() == second.length()) 
			return oneEditReplace(first, second);
		else if (first.length() + 1 == second.length())
			return oneEditInsert(first, second);
		else if (first.length() - 1 == second.length()) 
			return oneEditInsert(second, first);
		return false;
	}

	private static boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDifference) return false;
				else foundDifference = true;
			}
		}
		
		return true;
	}

	// check if can insert a character into sString
	private static boolean oneEditInsert(String lString, String sString) {
		int lIndex = 0;
		int sIndex = 0;
		
		while (lIndex < lString.length() && sIndex < sString.length()) {
			if (lString.charAt(lIndex) != sString.charAt(sIndex)) {
				if (lIndex == sIndex) sIndex++;
				else return false;
			} else {
				lIndex++;
				sIndex++;
			}
		}
		
		return true;
	}
	
	/*
	 * 
	 * The book's answer: compact approach
	 * 
	 */
	
	private static boolean isOneAway2(String first, String second) {
		// length checking
		if (Math.abs(first.length() - second.length()) > 1) return false;
		
		// getting shorter and longer string
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;
		
		int index1 = 0;
		int index2 = 0;
		
		boolean foundDifference = false;
		while (index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				
				// ensure that this is the first difference found
				if (foundDifference) return false;
				foundDifference = true;
				
				// on replace, move shorter pointer
				if (s1.length() == s2.length()) index1++;
			} else index1++; // if matching, move shorter pointer
			
			// always move longer pointer
			index2++;
		}
		
		return true;		
	}
}
