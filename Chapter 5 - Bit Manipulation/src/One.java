
public class One {
	/*
	 * 
	 * Insertion: You are given two 32-bit numbers, N and M, and two bit
	 * positions, i and j. Write a method to insert M into N such that M 
	 * starts at bit j and ends at bit i. You can assume that the bits j 
	 * through i have enough space to fit all of M. That is if M = 10011,
	 * you can assume that there are at least 5 bits between j and i. You 
	 * would not, for example have j = 3 and i = 2, because M could not fully 
	 * fit between bit 3 and bit 2.
	 * 
	 * Example:
	 * 	+ input: N = 10000000000, M = 10011, i = 2, j = 6
	 *  + output: N = 10001001100
	 * 
	 */
	
	/*
	 * 
	 * brute force approach
	 * 
	 */
	public static int insertionBruteForce(int N, int M, int i, int j) {
		for (int counter = 0; counter <= (j - i); counter++) {
			boolean toogle = BitTasks.getBit(M, counter);
			if (toogle) N = BitTasks.setBit(N, i + counter);
			else 		N = BitTasks.clearBit(N, i + counter);
		}
		return N;
	}
	
	/*
	 * 
	 * bit manipulation approach
	 * 
	 */
	public static int insertion(int N, int M, int i, int j) {
		
		int leftMask = ((1 << (i)) - 1) & -1;
		int rightMask = (-1 << (j + 1));
		int mask = leftMask | rightMask;
		
		// shift to the right position
		M <<= i;
		
		// clear bits in insertion regions
		N &= mask;
		M &= ~mask;
		
		return N | M;
	}
	
	public static void main(String[] args) {
		int result = insertionBruteForce(Integer.parseInt("10000011100", 2), 
				Integer.parseInt("11011", 2), 2, 4);
		System.out.println(Integer.toBinaryString(result));
		result = insertion(Integer.parseInt("10000000000", 2), 
				Integer.parseInt("11011", 2), 2, 4);
		System.out.println(Integer.toBinaryString(result));
	}
}
