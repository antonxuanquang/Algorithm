package introduction;

import java.util.ArrayList;

public class HeapSort extends Sort {

	public static <T extends Comparable<T>> void sort(ArrayList<T> array) {
		int size = array.size() - 1;
		for (int k = size / 2; k >= 0; k--) {
			heapify(array, k, size);
		}
		while (size > 0) {
			swap(array, 0, size--);
			heapify(array, 0, size);
		}
	}

	private static <T extends Comparable<T>> void heapify(ArrayList<T> array,
			int startPoint, int size) {
		int left = 2 * startPoint;
		int right = 2 * startPoint + 1;
		int largest;

		if (left <= size
				&& array.get(left).compareTo(array.get(startPoint)) > 0) {
			largest = left;
		} else {
			largest = startPoint;
		}

		if (right <= size && array.get(right).compareTo(array.get(largest)) > 0) {
			largest = right;
		}

		if (largest != startPoint) {
			swap(array, startPoint, largest);
			heapify(array, largest, size);
		}
	}

}
