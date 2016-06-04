import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class One {
	/*
	 * 
	 * Three in One: Describe how you could use a single array to implement three stacks
	 * 
	 */
	
	
	public static void main (String[] args) {
		/*
		 * 
		 * This stack implementation is able to divide a stack into multiple sub-stack,
		 * depending user input. This stack is implement a fixed size array.
		 * Limitation:
		 * 	- stack is not resizable
		 * 	- stack is only generic
		 * 	- whenever insert a new item, there is a counter that search for next available
		 * slot in stack array. Likely, there is a empty space. However, the worst case is 
		 * O(n) in time complexity where n is the size of stack array.
		 * 
		 */
		MultiStack stack = new MultiStack(5, 10);
		
		stack.push(2, 0);
		stack.push(5, 0);
		stack.pop(0);
		stack.push(1, 0);
		
		stack.push(10, 1);
		stack.push(6, 1);
		stack.push(2, 1);
		stack.pop(1);
		stack.pop(1);
		stack.push(3, 1);
		
		stack.push(3, 2);
		stack.push(10, 2);
		stack.push(0, 2);
		stack.push(5, 2);
		
		stack.push(2, 4);
		stack.push(5, 4);
		stack.pop(4);
		stack.push(1, 4);
		
		System.out.println(stack);
	}
}
