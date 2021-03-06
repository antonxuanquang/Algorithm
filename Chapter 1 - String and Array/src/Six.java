
public class Six {
	public static void main(String[] args) {
		System.out.println(compressedString("aaabbeecdssssss"));
		System.out.println(compressedString("abeciseot"));
		
		
		System.out.println(compress("aaabbeecdssssss"));
		System.out.println(compress("abeciseot"));
	}

	/*
	 * 
	 * My solution
	 * 
	 */
	
	private static String compressedString(String string) {
		StringBuilder compressedString = new StringBuilder();
		int frequency = 1;
		char current_char = string.charAt(0);
		for (int i = 1 ; i < string.length(); i++) {
			if (string.charAt(i) != current_char) {
				compressedString.append(current_char);
				compressedString.append(frequency);
				frequency = 1;
				current_char = string.charAt(i);
			} else frequency++;
		}
		compressedString.append(current_char);
		compressedString.append(frequency);
		
		return string.length() <= compressedString.length() ? string : compressedString.toString();
	}
	
	
	/*
	 * 
	 * Book's solution
	 * 
	 */
	private static String compress(String string){
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < string.length(); i++) {
			countConsecutive++;
			if (i + 1 >= string.length() || string.charAt(i) != string.charAt(i + 1)) {
				compressed.append(string.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return string.length() < compressed.length() ? string : compressed.toString();
	}
}
