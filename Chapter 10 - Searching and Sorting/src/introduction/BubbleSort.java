package introduction;

import java.util.ArrayList;

public class BubbleSort extends Sort {

	public static <T extends Comparable<T>> void sort(ArrayList<T> array) {
		int length = array.size();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (array.get(j).compareTo(array.get(j + 1)) > 0) {
					swap(array, j, j + 1);
				}
			}
		}
	}
}
