import java.lang.annotation.Retention;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyQueue<T> implements Iterable<T> {
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;
		
		public QueueNode (T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void enqueue (T item) {
		QueueNode<T> node = new QueueNode<T>(item);
		if (last != null) {
			last.next = node;
		}
		
		last = node;
		
		if (first == null) {
			first = last;
		}
	}
	
	public T dequeue() {
		if (first == null) throw new NoSuchElementException();
		T data = first.data;
		first = first.next;
		
		if (first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek () {
		if (first == null) throw new NoSuchElementException();
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public Iterator<T> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<T> {
		private QueueNode<T> node;
		
		public QueueIterator() {
			node = first;
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
}
