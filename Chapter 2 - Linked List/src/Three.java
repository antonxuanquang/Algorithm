
public class Three {
	public static void main(String args[]) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.addToTail(3);
		linkedList.addToTail(6);
		linkedList.addToTail(3);
		linkedList.addToTail(3);
		linkedList.addToTail(6);
		linkedList.addToTail(5);
		linkedList.addToTail(2);
		linkedList.addToTail(3);
		linkedList.addToTail(4);
		
		System.out.println(linkedList);
		removeMiddleNode(linkedList.head);
		System.out.println(linkedList);
		
	}

	private static void removeMiddleNode(Node head) {
		Node current = head;
		Node runner = current;
		
		// case: when linked list have only 2 nodes
		if (runner.next.next == null) return;
		
		while (runner != null) {
			runner = runner.next;
			try {
				runner = runner.next;
			} catch (NullPointerException e) {
				break;
			}
			if (runner != null && runner.next != null) current = current.next;
		}
		current.next = current.next.next;
	}
}
