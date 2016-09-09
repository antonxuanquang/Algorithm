import java.util.Stack;


public class Six {
	
	/*
	 * 
	 * Towers of Hanoi: In the class problem of Towers of Hanoi, you have 
	 * 3 towers and N disks of different sizes which can slide onty any tower.
	 * The puzzle starts with disks sorted in ascending order of size from
	 * top to bottom (i.e, each disk sits on top of an even larger one). You
	 * have the following constraints:
	 * 	(1) Only one disk can be move at a time.
	 * 	(2) A disk is slid off the top of one tower onto another tower
	 * 	(3) A disk cannot be placed on top of a smaller disk
	 * Write a program to move the disks from the first tower to the last
	 * using stacks
	 * 
	 */
	
	/*
	 * 
	 * Brute force, O(2^n)
	 * 
	 */
	public static <T> void towerOfHanoi(Stack<T> left, Stack<T> middle, Stack<T> right) {
		towerOfHanoi(left.size(), left, middle, right);
	}
	
	private static <T> void towerOfHanoi(int size, Stack<T> left, Stack<T> middle, Stack<T> right) {
		if (size == 1) {
			right.push(left.pop());
		} else {
			towerOfHanoi(size - 1, left, right, middle);
			right.push(left.pop());
			towerOfHanoi(size - 1, middle, left, right);
		}
	}
	
	public static void main (String[] args) {
		Stack<Integer> inStack = new Stack<Integer>();
		int counter = 1;
		while (true) {
			inStack.removeAllElements();
			for (int i = counter; i >= 0; i--) {
				inStack.push(i);
			}
			Stack<Integer> outStack = new Stack<Integer>();
			towerOfHanoi(inStack, new Stack<Integer>(), outStack);
			System.out.println(outStack);
			counter *= 2;
		}
		
	}

}
