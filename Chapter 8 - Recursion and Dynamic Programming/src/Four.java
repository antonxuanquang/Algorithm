import java.util.ArrayList;
import java.util.Arrays;


public class Four<T> {
	
	/*
	 * 
	 * Power Set: write a method to return all subsets of a set
	 * 
	 */
	
	public static <T> ArrayList<ArrayList<T>> powerSet(ArrayList<T> array) {
		ArrayList<ArrayList<T>> result = new ArrayList<ArrayList<T>>();
		powerSet(array, result, -1);
		return result;
	}
	
	private static <T> void powerSet(ArrayList<T> array,
			ArrayList<ArrayList<T>> result, int hidePosition) {
		if (hidePosition >= 0) array.remove(hidePosition);
		
		if (!result.contains(array)) result.add(array);
		
		for (int i = 0; i < array.size(); i++) {
			powerSet(new ArrayList<T>(array), result, i);
		}
	}
	
	/*
	 * 
	 * Book's approach: without duplicates, O(n2^n) time and O(n2^n) space
	 * 
	 */
	public static <T> ArrayList<ArrayList<T>> getSubsets(ArrayList<T> array) {
		return getSubsets(array, 0);
	}
	
	private static <T> ArrayList<ArrayList<T>> getSubsets(ArrayList<T> set, int index) {
		ArrayList<ArrayList<T>> allSubsets;
		if (set.size() == index) {
			allSubsets = new ArrayList<ArrayList<T>>();
			allSubsets.add(new ArrayList<T>());
		} else {
			allSubsets = getSubsets(set, index + 1);
			T item = set.get(index);
			ArrayList<ArrayList<T>> moreSubsets = new ArrayList<ArrayList<T>>();
			for (ArrayList<T> subset: allSubsets) {
				ArrayList<T> newSubset = new ArrayList<T>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}
	
	public static void main (String[]strings) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		array.add(3);
		
		ArrayList<ArrayList<Integer>> result = powerSet(array);
		for (ArrayList<Integer> list: result) {
			System.out.println(list);
		}
		System.out.println();
		result = getSubsets(array);
		for (ArrayList<Integer> list: result) {
			System.out.println(list);
		}
	}
}
