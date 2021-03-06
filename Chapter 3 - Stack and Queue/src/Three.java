import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;


public class Three {
	/*
	 * 
	 * Implement a SetOfStacks should be composed of serveral stacks
	 * and should create a new stack once the previous one exceeds 
	 * capacity. SetOfStacks.push() and SetOfStacks.pop() should 
	 * behave identically to a single stack (that is, pop() should 
	 * return the same values as it would if there were just a single
	 * stack). 
	 * 
	 */
	
	private static class StackWithCapacity extends Stack<Integer>{
		int capacity = 0;
		
		public void increment() {
			capacity++;
		}
		
		public void decrement() {
			capacity--;
		}
	}
	
	private static class SetOfStacks {
		ArrayList<StackWithCapacity> stackList;
		private final int CAPACITY;
		
		public SetOfStacks(int capacity) {
			this.CAPACITY = capacity;
			stackList = new ArrayList<StackWithCapacity>();
			stackList.add(new StackWithCapacity());
		}
		
		public void push(int value) {
			int currentStack = 0;
			
			// get the nearest un-full stack
			while (stackList.get(currentStack) != null && stackCapacity(currentStack) == CAPACITY) {
				currentStack++;
			}
			
			StackWithCapacity stack = stackList.get(currentStack); 
			
			// if stack has not been initialize
			if (stack == null) stack = new StackWithCapacity();
			
			stack.push(value);
			
			// increment volume of a stack
			stackList.get(currentStack).capacity++;
			if (stackList.get(currentStack).capacity == CAPACITY) stackList.add(new StackWithCapacity());
		}
		
		public int pop() {
			if (stackList.get(0) == null) throw new NoSuchElementException();
			int lastStack = stackList.size() - 1;
			StackWithCapacity stack = stackList.get(lastStack);
			while (stack.isEmpty()) {
				stackList.remove(lastStack);
				lastStack--;
				stack = stackList.get(lastStack);
			}
			stack.capacity--;
			return stack.pop();
		}
		
		public int popAt(int stackNumber) {
			// invalid stackNumber
			if (stackNumber >= stackList.size() - 1 || stackNumber < 0) throw new IndexOutOfBoundsException();
			StackWithCapacity stack = stackList.get(stackNumber);
			stack.capacity--;
			if (stack.isEmpty()) stackList.remove(stackNumber);
			return stack.pop();
		}
		
		private int stackCapacity(int stackNumber) {
			return stackList.get(stackNumber).capacity;
		}
		
		public String toString() {
			StringBuilder result = new StringBuilder();
			for (StackWithCapacity stack: stackList) {
				result.append(stack.toString() + "\n"); 
			}
			return result.toString();
		}
	}
	
	public static void main (String[] args) {
		SetOfStacks stacks = new SetOfStacks(4);
		stacks.push(1);
		stacks.push(1);
		stacks.push(1);
		
		stacks.push(2);
		stacks.push(2);
		stacks.push(2);
		
		stacks.push(2);
		stacks.pop();
		stacks.pop();
		stacks.push(3);
		stacks.push(3);
		stacks.push(3);
		
		System.out.println(stacks.toString());
		
		stacks.popAt(1);
		
		System.out.println(stacks.toString());
		
		stacks.push(4);
				
		System.out.println(stacks.toString());
		
		stacks.pop();
		
		System.out.println(stacks.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
