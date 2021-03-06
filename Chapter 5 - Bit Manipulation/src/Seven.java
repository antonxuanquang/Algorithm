
public class Seven {
	/*
	 * 
	 * Pairwise Swap: Write a program to swap odd and even bits in an integer
	 * with as few in instructions as possible (e.g.: bit 0 and 1 are swapped,
	 * bit 2 and 3 are swapped and so on)
	 * 
	 */
	public static int swapOddEvenBits(int n) {
		return (((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1));
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(swapOddEvenBits(
				Integer.parseInt("1001001010", 2))));
	}
}
