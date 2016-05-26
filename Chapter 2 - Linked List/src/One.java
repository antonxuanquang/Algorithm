import java.util.HashSet;
import java.util.Hashtable;


public class One {
	/*
	 * 
	 * Write code to remove duplicates from an unsorted linked list.
	 * Follow up: How would you solve this problem if a temporary buffer is not allowed?
	 * 
	 */
	
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
//		removeDup(linkedList.head);
		removeDupWithoutBuff(linkedList.head);
		System.out.println(linkedList);
	}
	
	
	/*
	 * 
	 * Answer with buffer, i.e. the HashSet containing unique data
	 * 
	 */
	static void removeDup(Node head) {
		HashSet set = new HashSet();
		
		Node runnerNode = head;
		Node preNode = null;
		while (runnerNode != null) {
			if (set.contains(new Integer(runnerNode.data))) {
				preNode.next = runnerNode.next;
			} else {
				set.add(new Integer(runnerNode.data));
				preNode = runnerNode;
			}
			runnerNode = runnerNode.next;
		}
	}
	
	/*
	 * 
	 * Book's answer: without buffer
	 * 
	 */
	static void removeDupWithoutBuff(Node head) {
		Node current = head;
		while (current != null) {
			// remove all future nodes that have the same value
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) 
					runner.next = runner.next.next;
				else 
					runner = runner.next;
			}
			current = current.next;
		}
	}
	
}


