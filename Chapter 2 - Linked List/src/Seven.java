
public class Seven {
	/*
	 * 
	 * Given two (singly) linked lists, determine if the two lists intersect.
	 * Return the intersecting node. NOte that the intersection is defined 
	 * based on reference, not value. That is, if the k-th node of the first 
	 * linked list is the exact same node (by reference) as the j-th node of
	 * the second linked list, the they are intersecting.
	 * 
	 */
	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.addToTail(9);
		linkedList.addToTail(9);
		linkedList.addToTail(6);
		Node intersectedNode = new Node(3222);
		linkedList.addToTail(intersectedNode);
		linkedList.addToTail(6);
		linkedList.addToTail(5);
		linkedList.addToTail(3);
		linkedList.addToTail(2);
		linkedList.addToTail(5);
		
		SinglyLinkedList linkedList2 = new SinglyLinkedList();
		linkedList2.addToTail(5);
		linkedList2.addToTail(3);
		linkedList2.addToTail(2);
		linkedList2.addToTail(8);
		linkedList2.addToTail(2);
		linkedList2.addToTail(1);
		linkedList2.addToTail(intersectedNode);
		
		System.out.println(linkedList);
		System.out.println(linkedList2);
		
		System.out.println(linkedList.length);
		System.out.println(linkedList2.length);
		
		System.out.println(isIntersected(linkedList, linkedList2).data);
		
	}

	/*
	 * 
	 * First approach: recursive, O(a + b) time, O(1) space
	 * 
	 */
	private static Node isIntersected(SinglyLinkedList link1, SinglyLinkedList link2) {
		int l1 = link1.length;
		int l2 = link2.length;
		
		if (l1 > l2) 		addZeros(link2, l1 - l2);
		else if (l2 > l1) 	addZeros(link1, l2 - l1);
		
		Node runner1 = link1.head;
		Node runner2 = link2.head;
		
		while (runner1 != null && runner2 != null) {
			
			if (runner1 == runner2) return runner1;
			
			runner1 = runner1.next;
			runner2 = runner2.next;
		}
		
		return null;
	}

	private static void addZeros(SinglyLinkedList link, int difference) {
		for (int i = 0; i < difference; i++) 
			link.addToHead(0);
	}
	
	
}
