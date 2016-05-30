
public class Node {
	Node next = null;
	Node previous = null;
	int data;
	
	public Node (int d) {
		data = d;
	}
	
	public void debug() {
		System.out.println(new SinglyLinkedList(this));
	}
}
