package introduction;

import java.util.ArrayList;

public abstract class Sort {
	
	protected static <T extends Comparable<T>> void swap(ArrayList<T> array, int from, int to) {
		T temp = array.get(from);
		array.set(from, array.get(to));
		array.set(to, temp);
	}
	
	protected static <T extends Comparable<T>> void swap(T[] array, int from, int to) {
		T temp = array[from];
		array[from] = array[to]; 
		array[to] = temp;
	}
	
}
