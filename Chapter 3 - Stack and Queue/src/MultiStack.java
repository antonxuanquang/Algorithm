import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MultiStack {
	
	// this array stores stacks' head index
	private int [] stackHeads;
	
	// this array stores all three smaller stacks inside
	private MultiStackNode[] stack;
	
	// this keep track of previous slot has just used
	private int previouSlot = 0;
	
	private class MultiStackNode {
		private int data;
		private int next;

		public MultiStackNode(int data) {
			this.data = data;
			next = -1;
		}
	}
	
	public MultiStack (int numberOfStack, int sizeOfStack) {
		stackHeads = new int [numberOfStack];
		stack = new MultiStackNode[sizeOfStack];
		for (int i = 0; i < numberOfStack; i++) 
			stackHeads[i] = -1;
		for (int i = 0; i < sizeOfStack; i++) 
			stack[i] = null;
	}
	
	private int nextAvailable() {
		for (int i = 0; i < stack.length; i++) {
			// this helps to make a wrap around index
			int slot = (i + previouSlot) % stack.length;
			if (stack[slot] == null) {
				// update previousSlot
				previouSlot = slot;
				return slot;
			}
		}
		return -1;
	}
	
	public void push(int item, int stackNumber) {
		// invalid stack number
		if (stackNumber >= stackHeads.length) throw new NullPointerException();
		
		// the stack is full
		int nextSlot = nextAvailable();
		if (nextSlot == -1) throw new NoSuchElementException();
		
		// add node to the head
		MultiStackNode node = new MultiStackNode(item);
		stack[nextSlot] = node;
		node.next = stackHeads[stackNumber];
		
		// change head index of stackNumber
		stackHeads[stackNumber] = nextSlot;
	}
	
	public int peek(int stackNumber) {
		// invalid stack number
		if (stackNumber >= stackHeads.length) throw new NullPointerException();
		return stack[stackHeads[stackNumber]].data;
	}
	
	
	public int pop(int stackNumber) {
		// invalid stack number
		if (stackNumber >= stackHeads.length) throw new NullPointerException();
		
		// stack is empty
		if (isEmpty(stackNumber)) throw new NoSuchElementException();
		
		// save the result first
		int result = stack[stackHeads[stackNumber]].data;
		
		// save the old head index
		int oldHead = stackHeads[stackNumber];
		
		// change new head index
		stackHeads[stackNumber] = stack[oldHead].next;
		
		// nullify the old head
		stack[oldHead] = null;
		
		return result;
	}
	
	public boolean isEmpty(int stackNumber) {
		// invalid stack number
		if (stackNumber >= stackHeads.length) throw new NullPointerException();
		return stackHeads[stackNumber] == -1;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int stackNumber = 0; stackNumber < stackHeads.length; stackNumber++) {
			result.append("Stack " + stackNumber + "\n");
			int runner = stackHeads[stackNumber];
			while (runner != -1) {
				result.append(stack[runner].data + " -> ");
				runner = stack[runner].next;
			}
			result.append("null \n");
		}
		return result.toString();
	}
}
