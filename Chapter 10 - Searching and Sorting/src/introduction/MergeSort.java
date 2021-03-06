package introduction;

import java.util.ArrayList;

public class MergeSort extends Sort{
	
	public static <T extends Comparable<T>> void sort (ArrayList<T> array) {
		sort(array, 0, array.size() - 1);
	}
	
	private static <T extends Comparable<T>> void sort (ArrayList<T> array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(array, left, mid);
			sort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}
	
	private static <T extends Comparable<T>> void merge (
			ArrayList<T> array, int left, int mid, int right) {
		ArrayList<T> helper = new ArrayList<T>();
		
		int leftRunner = left;
		int rightRunner = mid + 1;
		
		while (leftRunner <= mid && rightRunner <= right) {
			if (array.get(leftRunner).compareTo(array.get(rightRunner)) <= 0) {
				helper.add(array.get(leftRunner++));
			} else {
				helper.add(array.get(rightRunner++));
			}
		}
		
		while (leftRunner <= mid) {
			helper.add(array.get(leftRunner++));
		}
		
		while (rightRunner <= right) {
			helper.add(array.get(rightRunner++));
		}
		
		int runner = left;
		for (T temp: helper) {
			array.set(runner++, temp);
		}
	}
}
