import java.util.Arrays;
import java.util.Random;


public class Eight {
	
	/*
	 * 
	 * Find Duplicates: You have an array with all the numbers from 1 to N, 
	 * where N is at most 32,000. The array may have duplicate entries and 
	 * you do not know what N is. With only 4 kilobytes of memory available,
	 * how would you print all duplicates elements in array?
	 * 
	 */
	
	public static void findDuplicates(int[] array, int max) {
		BitSet bs = new BitSet(max);
		
		for (int i = 0; i < array.length; i++) {
			int number = array[i] - 1;
			if (bs.get(number)) {
				System.out.println(array[i]);
			} else {
				bs.set(number);
			}
		}
		
	}
	
	private static class BitSet {
		int[] bitSet;
		
		public BitSet(int size) {
			bitSet = new int[(size >> 5) + 1];
		}
		
		public boolean get(int pos) {
			int workNumber = (pos >> 5);
			int bitNumber = (pos % 0x1f);
			return (bitSet[workNumber] & (1 << bitNumber)) != 0;
		}
		
		public void set(int pos) {
			int workNumber = (pos >> 5);
			int bitNumber = (pos % 0x1f);
			bitSet[workNumber] |= (1 << bitNumber);
		}
	}
	
	public static void main(String[] args) {
		int max = 30;
		int[] array = new int[max];
		Random random = new Random();
		for (int i = 0; i < max; i++) {
			array[i] = random.nextInt(max) + 1;
		}
		findDuplicates(array, max);
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
