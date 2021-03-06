import java.util.Arrays;


public class Eleven {
	
	/*
	 * 
	 * Peaks and Valleys: In an array of integers, a "peak" is an element
	 * which is greater than or equal to the adjacent integers and a "valley"
	 * is an element which is less than or equal to the adjacent integers. 
	 * For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks 
	 * and {5, 2} are valleys. Given an array of integers, sort the array 
	 * into an alternating sequence of peaks and valleys.
	 * 
	 * EXAMPLE:
	 *  + input: {5, 3, 1, 2, 3}
	 *  + output: {5, 1, 3, 2, 3}
	 * 
	 */
	
	/*
	 * 
	 * Book's approach
	 * 
	 */
	public static void peaksAndValleys(int[] array) {
		for (int i = 1; i < array.length; i += 2) {
			int maxIndex = maxIndex(i - 1, i, i + 1, array);
			if (i != maxIndex) {
				swap(array, i, maxIndex);
			}
			System.out.println(Arrays.toString(array));
		}
	}
	
	private static void swap(int[] array, int i, int maxIndex) {
		int temp = array[i];
		array[i] = array[maxIndex];
		array[maxIndex] = temp;
	}

	private static int maxIndex(int left, int mid, int right, int[] array) {
		int len = array.length;
		int leftValue 	= left 	>= 0 && left 	< len ? array[left] 	: Integer.MIN_VALUE;
		int midValue 	= mid 	>= 0 && mid 	< len ? array[mid] 		: Integer.MIN_VALUE;
		int rightValue 	= right >= 0 && right 	< len ? array[right] 	: Integer.MIN_VALUE;
		int max = Math.max(leftValue, Math.max(midValue, rightValue));
		if (max == leftValue) return left;
		else if (max == midValue) return mid;
		else return right;
	}
	
	public static void main (String[] args) {
//		int[] array = {5, 3, 2, 1, 2, 2, 3, 4};
//		int[] array = {1,2,3,4,5,6,7,8,9};
		int[] array = {9,8,7,6,5,4,3,2,1};
		peaksAndValleys(array);
		System.out.println(Arrays.toString(array));
	}
}
