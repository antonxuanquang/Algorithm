import java.util.Stack;


public class Six {
	/*
	 * 
	 * Implement a function to check if a linked list is a palindrome
	 * 
	 */
	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.addToTail(9);
		linkedList.addToTail(4);
		linkedList.addToTail(6);
		linkedList.addToTail(3);
		linkedList.addToTail(0);
		linkedList.addToTail(3);
		linkedList.addToTail(6);
		linkedList.addToTail(4);
		linkedList.addToTail(9);
		System.out.println(linkedList);
		
		System.out.println(isPalindrome(linkedList.head));
		
	}
	
	/*
	 * 
	 * Book's approach: iterative, O(n) time complexity, O(n/2) space complexity
	 * 
	 */
	private static boolean isPalindrome(Node head) {
		Node runner = head;
		Node faster = runner;
		Stack<Integer> stack = new Stack<Integer>();
		while (faster != null && faster.next != null) {
			stack.push(runner.data);
			runner = runner.next;
			faster = faster.next.next;
		}
		
		// skip the middle node if length is odd
		if (faster != null) runner = runner.next;
		
		while (runner != null) {
			if (stack.pop() != runner.data) return false;
			runner = runner.next;
		}
		
		return true;
	}
	
	/*
	 * 
	 * Book's approach: recursive, O(n) time complexity, O(n/2) space complexity
	 * 
	 */
	private static boolean isPalindrome2(Node head) {
		
		
		return true;
	}
	
	
}
