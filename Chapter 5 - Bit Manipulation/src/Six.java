
public class Six {
	/*
	 * 
	 * Conversion: write a function to determine the number of bits
	 * you would need to flip to convert integer A to integer B
	 * 
	 */
	public static int convertsionBruteForce(int number, int convertedNumber) {
		int numberOfFlips = 0;
		for (int i = 0; i < Integer.BYTES * 8; i++) {
			boolean first = ((1 << i) & number) != 0;
			boolean converted = ((1 << i) & convertedNumber) != 0;
			if (first != converted) numberOfFlips++; 
		}
		
		return numberOfFlips;
	}
	
	public static int convertsion(int first, int second) {
		int numberOfFlips = 0;
		int merge = first ^ second;
		while (merge != 0) {
			if ((merge & 1) == 1) numberOfFlips++;
			merge >>= 1;
		}
		
		return numberOfFlips;
	}
	
	/*
	 * 
	 * Book's solution
	 * 
	 */
	
	public static int convertsion2(int a, int b) {
		int numberOfFlips = 0;
		for (int i = a ^ b; i != 0; i = i & (i - 1)) {
			numberOfFlips++;
		}
		return numberOfFlips;
	}
	
	public static void main(String[] args) {
		System.out.println(convertsionBruteForce(
				Integer.parseInt("11001010", 2), 
				Integer.parseInt("11011101", 2)));
		System.out.println(convertsion(
				Integer.parseInt("11001010", 2), 
				Integer.parseInt("11011101", 2)));
		System.out.println(convertsion2(
				Integer.parseInt("11001010", 2), 
				Integer.parseInt("11011101", 2)));
	}
}
