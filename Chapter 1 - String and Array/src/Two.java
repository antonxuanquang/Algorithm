
public class Two {
	public static void main(String args[]) {
		System.out.println(checkTwoPermutation("ababdfasasdfba", "abasbdfasbdfba")); 
	}
	
	static boolean checkTwoPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		int [] list = new int[128];
		for (int i = 0; i < str1.length(); i++) {
			int val = str1.charAt(i);
			list[val]++;
		}
		
		
		for (int i = 0; i < str2.length(); i++) {
			int val = str2.charAt(i);
			if (list[val] == 0) return false;
			else {
				list[val]--;
			}
		}
		
		return true;
	}
}
