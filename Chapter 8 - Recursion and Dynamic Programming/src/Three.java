public class Three {

	/*
	 * 
	 * Magic Index: A magix index in an array A[0...n-1] is defined to be an
	 * index such that A[i] = i. Given a sorted array of distinct integers,
	 * write a method to find a magic index, if one exists, in array A.
	 * 
	 * FOLLOW UP: What if the values are not distinct?
	 */

	// O(n) algorithm
	public static int magicIndex(int[] array) {
		int index = 0;
		int value;
		while (index < array.length) {
			if (index == array[index])
				return index;
			index = array[index];
		}
		return -1;
	}

	// O(log n): mimic binary search
	public static int magicIndex2(int[] array) {
		return magicIndex2(array, 0, array.length - 1);
	}

	private static int magicIndex2(int[] array, int start, int end) {
		if (end < start) return -1;
		
		int mid = (start + end) / 2;
		int midValue = array[mid];
		if (mid == midValue) return mid;
		
		int leftIndex = Math.min(mid - 1, midValue);
		int left = magicIndex2(array, start, leftIndex);
		if (left >=0) return left;
		
		int rightIndex = Math.max(mid + 1, midValue);
		int right = magicIndex2(array, rightIndex, end);
		return right;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 5, 5, 6, 6, 7, 10 };
		System.out.println(magicIndex2(array));
	}

}
