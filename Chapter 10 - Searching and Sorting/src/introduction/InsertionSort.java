package introduction;

import java.util.ArrayList;

public class InsertionSort extends Sort{
	
	public static <T extends Comparable<T>> void sort(ArrayList<T> array) {
		int length = array.size();
		for (int stay = 0; stay < length; stay++) {
			int min = stay;
			for (int runner = stay + 1; runner < length; runner++) {
				if (array.get(runner).compareTo(array.get(min)) < 0) {
					min = runner;
				}
			}
			swap(array, min, stay);
			System.out.println(array);
		}
	}
}
