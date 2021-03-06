import java.util.HashMap;


public class Anagram {
	
	public static boolean anagramHash(String string, String string2) {
		if (string.length() != string2.length()) return false;
		
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		
		for (int i = 0; i < string.length(); i++) {
			if (hash.containsKey(string.charAt(i))) {
				int count = hash.get(string.charAt(i));
				hash.put(string.charAt(i), count++);
			} else {
				hash.put(string.charAt(i), 1);
			}
		}
		
		for (int i = 0; i < string2.length(); i++) {
			if (hash.containsKey(string2.charAt(i))) {
				int count = hash.get(string2.charAt(i));
				count--;
				if (count < 0) return false;
				hash.put(string2.charAt(i), count);
			}
		}
		return true;
	}
	
	
	public static boolean anagramBruteForce(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		
		int i = 0;
		while (i < s1.length()) {
			for (int j = 0; j < s2.length(); j++) {
				if (s2.charAt(j) == s1.charAt(i)) {
					s2 = s2.substring(0,j) + s2.substring(j + 1, s2.length());
				}
			}
			i++;
		}
		return s2.isEmpty();
	}
	
	public static boolean anagramArray(String s1, String s2) {
		int[] hash = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			hash[s1.charAt(i)]++;
		}
		
		for (int i = 0; i < s2.length(); i++) {
			hash[s2.charAt(i)]--;
			if (hash[s2.charAt(i)] < 0) return false;
		}
		
		return true;
	}
	
	public static void main (String[] args) {
		System.out.println(anagramHash("rate", "ater"));
		System.out.println(anagramBruteForce("rate", "ater"));
		System.out.println(anagramArray("asdf", "fdsa"));
	}

}
