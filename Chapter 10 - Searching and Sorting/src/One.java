import java.util.Arrays;


public class One {
	/*
	 * 
	 * Sorted Merge: You are given two sorted arrays, A and B, where A has 
	 * a large enough buffer at the end to hold B. Write a method to merge B
	 * into A in sorted order
	 * 
	 */
	
	public static <T extends Comparable<T>> void sortedMerge(
			T[] longer, T [] shorter, int longRunner) {
		int shortRunner = shorter.length - 1;
		int endPoint = longer.length - 1;
		
		while (shortRunner >= 0) {
			if (longRunner >= 0 && longer[longRunner].compareTo(shorter[shortRunner]) > 0) {
				longer[endPoint] = longer[longRunner];
				longRunner--;
			} else {
				longer[endPoint] = shorter[shortRunner];
				shortRunner--;
			}
			endPoint--;
		}
	}
	
	
	public static void main (String[] args) {
		Integer[] longer = {1,2,4,8,10,0,0,0,0};
		Integer[] shorter = {3,5,6,9};
		
		sortedMerge(longer, shorter, 4);
		System.out.println(Arrays.toString(longer));
	}
}
