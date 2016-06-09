import java.net.Socket;
import java.util.Stack;


public class Five {
	
	/*
	 * 
	 * Write a program to sort a stack such that the smallest items are on the top.
	 * You can use an additional temporary stack, but you may not copy the elements
	 * into any other data structure (such as array). The stacks supports the following
	 * operations: push, pop, peek, and isEmpty
	 * 
	 */
	
	/*
	 * 
	 * first approach: using 2 temporary stacks
	 * 
	 */
	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) return stack;
		
		Stack<Integer> tempStack = new Stack<Integer>();
		Stack<Integer> sortedStack = new Stack<Integer>();
		
		sortedStack.push(stack.pop());
		
		while (!stack.isEmpty()) {
			if (stack.peek() <= sortedStack.peek()) {
				sortedStack.push(stack.pop());
			} else {
				do {
					tempStack.push(sortedStack.pop());
				}
				while (!sortedStack.isEmpty() && sortedStack.peek() <= stack.peek());
				sortedStack.push(stack.pop());
				while (!tempStack.isEmpty()) sortedStack.push(tempStack.pop());
			}
		}		
		return sortedStack;
	}
	
	/*
	 * 
	 * 2nd approach: use 1 stack only
	 * 
	 */
	public static void sortStack2(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int value = stack.pop();
			while (!temp.isEmpty() && temp.peek() > value)
				stack.push(temp.pop());
			temp.push(value);
		}
		while (!temp.isEmpty()) stack.push(temp.pop());
	}
	
	
	public static void main (String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(7);
		stack.push(2);
		stack.push(5);
		stack.push(2);
		stack.push(5);
		stack.push(1);
		stack.push(4);
		stack.push(3);
		stack = sortStack(stack);
		System.out.println(stack);
		System.out.println(stack.peek());
		
		Stack<Integer> stack2 = new Stack<Integer>();
		stack2.push(7);
		stack2.push(2);
		stack2.push(5);
		stack2.push(2);
		stack2.push(5);
		stack2.push(1);
		stack2.push(4);
		stack2.push(3);
		sortStack2(stack2);
		System.out.println(stack2);
		System.out.println(stack2.peek());
	}
}
