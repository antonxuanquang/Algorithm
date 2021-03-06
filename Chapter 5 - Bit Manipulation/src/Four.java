
public class Four {
	/*
	 * 
	 * Next Number: Given a positive integer, print the next smallest and the next
	 * largest number that have the same number of 1 bits in their binary
	 * representation.
	 * 
	 */
	
	public static void nextNumberBruteForce(int a) {
		int numberOf1s = count1s(a);
		
		int smallest = a;
		do {
			smallest--;
		} while (count1s(smallest) != numberOf1s);
		
		int largest = a;
		do {
			largest++;
		} while (count1s(largest) != numberOf1s);
		
		System.out.println(Integer.toBinaryString(smallest));
		System.out.println(Integer.toBinaryString(largest));
	}
	
	public static void nextNumber(int n) {
		System.out.println(Integer.toBinaryString(getNext(n)));
		System.out.println(Integer.toBinaryString(getPrev(n)));
	}
	
	private static int getPrev(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		if (c == 0) return -1;
		
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>=1;
		}		
		
		return n - (1 << c1) - (1 << (c0 - 1)) + 1;
	}

	private static int getNext(int n) {
		int c = n;
		int c1 = 0;
		int c0 = 0;
		
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>=1;
		}
		
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		return n + (1 << c0) + (1 << (c1 - 1)) - 1;
	}

	private static int count1s(int a) {
		int result = 0;
		while (a != 0) {
			if ((a & 1) == 1) result++;
			a >>>= 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		nextNumber(Integer.parseInt("01101010", 2));
		System.out.println();
		nextNumber(Integer.parseInt("01110011", 2));
		System.out.println();
		nextNumber(Integer.parseInt("01110111", 2));
	}
}
