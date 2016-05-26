
public class SinglyLinkedList {
	Node head = null;
	
	public SinglyLinkedList () {}
		
	public SinglyLinkedList(Node node){
		head = node;
	}
	
	void addToTail(int d) {
		Node end = new Node(d);
		if (head == null) {
			head = end;
			return;
		}
		
		Node node = head;
		while (node.next != null) {
			node = node.next;
		}

		node.next = end;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		Node head = this.head;
		
		if (head == null) throw new NullPointerException("You have a null linked list");
		
		Node runnerNode = head.next;
		
		stringBuilder.append(head.data);
		
		while (runnerNode != null) {
			stringBuilder.append(" -> " + runnerNode.data);
			runnerNode = runnerNode.next;
		}
		
		return stringBuilder.toString();
	}
}
