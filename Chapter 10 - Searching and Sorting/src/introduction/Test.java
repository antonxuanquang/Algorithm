package introduction;

import java.util.ArrayList;

public class Test {
	
	public static void main(String []args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(4);
		array.add(5);
		array.add(1);
		array.add(2);
		array.add(7);
		array.add(3);
		array.add(10);
		array.add(6);
		array.add(8);
		array.add(9);
		
		System.out.println(array);
		HeapSort.sort(array);
		System.out.println(array);
	}

}
