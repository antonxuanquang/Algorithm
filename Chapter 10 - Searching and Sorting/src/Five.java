
public class Five {
	
	/*
	 * 
	 * Sparse Search: given a sorted array of strings that is interspersed with empty strings,
	 * write a method to find the location of a given string
	 * 
	 * Example: 
	 * 	+ Input: ball, {"at", "", "", "", "ball", "", "", "car", "", "", 
	 * "", "dad", "", ""}
	 * 	+ Output: 4
	 * 
	 */

	public static int sparseSearch(String[] array, String string) {
		int mid, left = 0, right = array.length - 1;
		
		while (left < right) {
			while (array[left].equals("")) left++;
			while (array[right].equals("")) right--;
			mid = (left + right) / 2;
			while (array[mid].equals("")) mid--;

			if (string.compareTo(array[mid]) < 0) {
				right = mid - 1;
			} else if (string.compareTo(array[mid]) > 0) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String[] array = {"at", "", "", "", "ball", "", "", 
				"car", "", "", "", "", "compareTo", "", "", "", "", 
				"dad", "", "", "left", "", "", "", "mid", "", "", 
				"", "", "", "", "right", "", "", "", "string", "", "", ""};
		System.out.println(sparseSearch(array, "Left"));
	}
}
