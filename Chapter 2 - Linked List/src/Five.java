
public class Five {
	/*
	 * 
	 * You have two numbers represented by a linked list, where each node contains
	 * a single digit. The digits are stored in reverse order, such that the 1's digit
	 * digit is at the head of the list. Write a function that adds the two numbers
	 * and returns the sum as a linked list.
	 * FOLLOW UP: suppose the digits are stored in forward order. Repeat the above 
	 * algorithm
	 * 
	 */
	
	public static void main(String args[]) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.addToTail(9);
		linkedList.addToTail(9);
		linkedList.addToTail(6);
		linkedList.addToTail(3);
		linkedList.addToTail(6);
		linkedList.addToTail(5);
		linkedList.addToTail(3);
		linkedList.addToTail(9);
		linkedList.addToTail(9);
		
		SinglyLinkedList linkedList2 = new SinglyLinkedList();
		linkedList2.addToTail(4);
		linkedList2.addToTail(1);
		linkedList2.addToTail(5);
		linkedList2.addToTail(1);
		linkedList2.addToTail(2);
		linkedList2.addToTail(3);
		linkedList2.addToTail(7);
		
		SinglyLinkedList sum = sumTwoLinkedList2(linkedList, linkedList2);
		System.out.println(linkedList);
		System.out.println(linkedList2);
		System.out.println(sum);
	}
	
	
	/*
	 * 
	 * The linked list is in reverse order: iterative, O(n) time complexity, 
	 * O(1) space complexity;
	 * 
	 */
	private static SinglyLinkedList sumTwoLinkedList(SinglyLinkedList linkedList, 
													SinglyLinkedList linkedList2) {
		return sumTwoLinkedList(linkedList.head, linkedList2.head);
	}

	private static SinglyLinkedList sumTwoLinkedList(Node head, Node head2) {
		SinglyLinkedList sum = new SinglyLinkedList();
		Node runner1 = head;
		Node runner2 = head2;
		int carry = 0;
		int digit = 0;
		while (runner1 != null || runner2 != null) {
			if (runner1 == null) {
				addToTailWithCarryBit(sum, runner2, carry);
				// return sum
				return sum;
			} else if (runner2 == null) {
				addToTailWithCarryBit(sum, runner1, carry);
				// return sum
				return sum;
			} else {
				int temp = runner1.data + runner2.data + carry;
				carry = temp / 10;
				digit = temp % 10;
				sum.addToTail(digit);
				runner1 = runner1.next;
				runner2 = runner2.next;
			}
		}
		return sum;
	}
	
	private static void addToTailWithCarryBit(SinglyLinkedList sum,
			Node runner, int carry) {
		// add runner to tail of sum
		if (carry == 0) sum.addToTail(runner);
		else {
			// add carry bit if needed
			while (runner != null) {
				int temp = runner.data + carry;
				carry = temp / 10;
				int digit = temp % 10;
				sum.addToTail(digit);
				runner = runner.next;
			}
			if (carry != 0) sum.addToTail(carry);
		}
	}
	
	
	/*
	 * 
	 * The linked list is in normal order: recursive approach, O(n) time
	 * complexity, O(n) space complexity
	 * 
	 */
	private static SinglyLinkedList sumTwoLinkedList2(SinglyLinkedList linkedList, 
			SinglyLinkedList linkedList2) {
		int l1 = linkedList.length;
		int l2 = linkedList2.length;
		
		if (l1 > l2) 		padZeros(linkedList2, l1 - l2);
		else if (l2 > l1) 	padZeros(linkedList, l2 - l1);
		
		SinglyLinkedList sum = new SinglyLinkedList();
		int carry = sumTwoLinkedList2(linkedList.head, linkedList2.head, sum);
		if (carry > 0) sum.addToHead(carry);
		return sum;
		 
	}
	
	private static void padZeros(SinglyLinkedList linkedList, int length) {
		for (int i = 0; i < length; i++) {
			linkedList.addToHead(0);
		}
	}

	private static int sumTwoLinkedList2(
			Node head, Node head2, SinglyLinkedList sum) {
		if (head.next == null && head2.next == null) {
			sum.addToHead((head.data + head2.data) % 10);
			return (head.data + head2.data) / 10;
		}
		int tempSum = head.data + head2.data 
				+ sumTwoLinkedList2(head.next, head2.next, sum);
		sum.addToHead(tempSum % 10);
		return tempSum / 10;
	}
}
