import javax.print.attribute.standard.Sides;


public class Four {
	/*
	 * 
	 * Sorted Search, No Size: you are given an array-like data structure Listy
	 * which lacks a size method. It does, however, have an elementAt(i) method 
	 * that returns the element at index i in O(1) time. If i is beyond the bounds 
	 * of the data structures, it returns -1. (For this reason, the data structure
	 * only supports positive integers). Given a Listy which contains sorted, positive
	 * integers, find the index at which an element x occurs. If x occurs multiple times,
	 * you may return any index.
	 * 
	 */
	
	
	/*
	 * 
	 * My approach: fibonacci search
	 * 
	 */
	public static <T extends Comparable<T>> int noSizeSearch(T[] array, T item) {
		
		int power = findNearestPower(array);
		int index = (int) Math.pow(2, power) - 1;
		power--;
		while (power >= 0) {
			if (index > array.length - 1) {
				index -= (int) Math.pow(2, power);
			} else {
				if (array[index].compareTo(item) == 0) return index;
				else if (array[index].compareTo(item) > 0) 
					index -= (int) Math.pow(2, power);
				else if (array[index].compareTo(item) < 0)
					index += (int) Math.pow(2, power);
			}
			
			power--;
		}
		if (array[index].compareTo(item) == 0) return index;
		return -1;
	}
	
	private static <T extends Comparable<T>> int findNearestPower(T[] array) {
		int power = 0;
		while (Math.pow(2, power) < array.length) power++;
		return power - 1;
	}
	
	/*
	 * 
	 * Book's approach: binary search, find the nearest largest power of two thw greater than 
	 * array's size
	 * 
	 * 
	 */
	public static <T extends Comparable<T>> int noSizeSearch2(T[] array, T item) {
		int index = 1;
		while (index < array.length && array[index].compareTo(item) < 0) index *= 2;
		return binarySearch(array, index / 2, index, item);
	}
	
	private static <T extends Comparable<T>> int binarySearch(
			T[] array, int left, int right, T item) {
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (mid > array.length || array[mid].compareTo(item) > 0) {
				right = mid - 1;
			} else if (array[mid].compareTo(item) < 0) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Integer[] array = {1,3,4,6,7,8,9,22,53,74,172};
		System.out.println(noSizeSearch(array, 53));
		System.out.println(noSizeSearch(array, 2));
		System.out.println(noSizeSearch(array, 22));
		System.out.println(noSizeSearch(array, 1));
		
		System.out.println(noSizeSearch2(array, 53));
		System.out.println(noSizeSearch2(array, 2));
		System.out.println(noSizeSearch2(array, 22));
		System.out.println(noSizeSearch2(array, 1));
		
		
	}
}
