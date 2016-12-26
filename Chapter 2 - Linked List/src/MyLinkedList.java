import javax.swing.tree.TreeNode;

public class MyLinkedList<E> {
	
	private class Node<E>{
		
		E data;
		public Node next;
		
		public Node(E data) {
			this.data = data;
		}
		
		
		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		public String toString() {
			return data.toString();
		}

	}
	
	Node<E> head = null;
	Node<E> tail = null;
	int length = 0;

	void addToHead(E data) {
		Node<E> first = new Node<E>(data);
		if (head == null) {
			head = first;
			tail = first;
			return;
		}
		first.next = head;
		head = first;

		length++;
	}

	void addToTail(E data) {
		Node<E> first = new Node<E>(data);
		if (head == null) {
			head = first;
			tail = first;
			return;
		}
		tail.next = first;
		while (tail.next != null) {
			length++;
			tail = tail.next;
		}
		length++;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		Node<E> head = this.head;

		if (head == null)
			throw new NullPointerException("You have a null linked list");

		Node<E> runnerNode = head.next;

		stringBuilder.append(head.data);

		while (runnerNode != null) {
			stringBuilder.append(" -> " + runnerNode.toString());
			runnerNode = runnerNode.next;
		}

		return stringBuilder.toString();
	}

	public void debug() {
		System.out.println(this);
	}

	public static void main(String[] args) {
		MyLinkedList<String> linkedList = new MyLinkedList<String>();
		linkedList.addToHead("String1");
		linkedList.addToHead("String2");

		System.out.println(linkedList);
	}
}


