import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyStack<T> implements Iterable<T> {
	private StackNode<T> top;
	
	private class StackNode<T> {
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
		
		public StackNode<T> getNext() {
			return next;
		}
	}
	
	public T pop() {
		if (top == null) throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}
	
	public void push (T item) {
		StackNode<T> newItem = new StackNode<T>(item);
		newItem.next = top;
		top = newItem;
	}
	
	public T peek() {
		if (top == null) throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public Iterator<T> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<T> {
		private StackNode<T> node;
		
		public StackIterator () {
			this.node = top;
		}

        public boolean hasNext() {
            return node != null;
        }

        public T next() {
        	if (!hasNext()) throw new NoSuchElementException();
        	T res = node.data;
        	node = node.next;
        	return res;
        }
	}
	
	
	
	// client code
	public static void main(String[]strings) {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(2);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(5);
		
		for (int item: stack) {
			System.out.println(item);
		}
	}
	
	
	
	
}
