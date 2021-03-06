
public class Three {
	
	/*
	 * 
	 * Search in Rotated Array: Given a sorted array of n integers that
	 * has been rotated an unknown number of times, write code to find an element
	 * in the array. You may assume that the array was originally sorted in 
	 * increasing order.
	 * 
	 */
	
	
	public static <T extends Comparable<T>> int rotatedArraySearch(
			T[] array, int left, int right, T searchItem) {
		int mid = (left + right) / 2;
		if (array[mid] == searchItem) return mid;
		if (left < right) return -1;
		
		//left half is sorted
		if (array[left].compareTo(array[mid]) < 0) {
			if (array[left].compareTo(searchItem) <= 0 && 
					searchItem.compareTo(array[mid]) > 0) {
				// search left
				return rotatedArraySearch(array, left, mid - 1, searchItem);
			} else {
				// search right
				return rotatedArraySearch(array, mid + 1, right, searchItem);
			}
		// right half is sorted
		} else if (array[left].compareTo(array[mid]) > 0) {
			if (array[mid].compareTo(searchItem) < 0 &&
					searchItem.compareTo(array[right]) <= 0) {
				// search left
				return rotatedArraySearch(array, mid + 1, right, searchItem);
			} else {
				// search right
				return rotatedArraySearch(array, left, mid - 1, searchItem);
			}
		// too many duplicate
		} else if (array[left].compareTo(array[mid]) == 0){
			if (array[mid].compareTo(array[right]) == 0) {
				return rotatedArraySearch(array, mid + 1, right, searchItem);
			} else {
				// search left
				int result = rotatedArraySearch(array, left, mid - 1, searchItem);
				if (result == -1) {
				// search right
					return rotatedArraySearch(array, mid + 1, right, searchItem);
				} else {
					return result;
				}
			}
		}
		return -1;
	}

}
