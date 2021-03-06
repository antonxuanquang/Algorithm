package introduction;

import java.util.ArrayList;

public class QuickSort extends Sort {
	
	public static <T extends Comparable<T>> void sort(ArrayList<T> array) {
		quickSort(array, 0, array.size() - 1);
	}
	
	private static <T extends Comparable<T>> void quickSort(
			ArrayList<T> array, int left, int right) {
		int pivot = partition(array, left, right);
		if (left < pivot - 1) quickSort(array, left, pivot - 1);
		if (pivot < right) quickSort(array, pivot, right);
	}
	
	private static <T extends Comparable<T>> int partition(
			ArrayList<T> array, int left, int right) {
		T pivot = array.get((left + right) / 2);
		while (left <= right) {
			while (array.get(left).compareTo(pivot) < 0) left++;
			while (array.get(right).compareTo(pivot) > 0) right--;
			if (left <= right) swap(array, left++, right--);
		}
		return left;
	}
}
