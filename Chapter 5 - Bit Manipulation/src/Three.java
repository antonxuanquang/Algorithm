
public class Three {
	/*
	 * 
	 * Flip Bit to Win: You have an integer and you can flip exactly one bit from 
	 * a 0 to a 1. Write code to find the length of the longest sequence of 1s you
	 * could create.
	 * 
	 * Example:
	 *  + input: 1775 (or: 11011101111)
	 *  + output: 8
	 * 
	 */
	public static int flipBits(int a) {
		if (~a == 0) return Integer.BYTES * 8;
		
		int maxLength = 1;
		int previousLength = 0;
		int currentLength = 0;
		while (a != 0) {
			if ((a & 1) == 1) {
				currentLength++;
			} else if ((a & 1) == 0) {
				previousLength = (a & 2) == 0 ? 0 : currentLength;
				currentLength = 0;
			}
			maxLength = Math.max(previousLength + currentLength + 1, maxLength);
			a >>>= 1;
		}
		return maxLength;
	}
	
	public static void main (String[] args) {
		System.out.println(flipBits(Integer.parseInt("101110111101", 2)));
		System.out.println(flipBits(Integer.parseInt("011110111101", 2)));
		System.out.println(flipBits(Integer.parseInt("11011101111", 2)));
	}
}
