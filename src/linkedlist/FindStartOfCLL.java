package linkedlist;


/**
 * 
 * Cracking the coding Interview
 * 
 * Given a circular linked list, implement an algorithm which returns 
 * the node at the beginning of the ring.
 * 
 * The LinkedList could have a starting 'k' nodes as the tail and the CLL 
 * starts from there.
 * 
 * Solution:
 * take a slow and fast pointer (n1 and n2).
 * n1 moves one step at a time and n2 moves two steps at a time.
 * if there is a loop, then they should both meet. if they don't, then throw an error
 * 
 * After they meet, we need to find the start of the loop.
 * if there are 'k' nodes before the loop starts, then by the time
 * at some instance, n2 will have a head start of k nodes in the loop, which means,
 * they meet k nodes before the start of the loop.
 * 
 * So once we know where they meet, we could move n1 to head and move both n1 and 
 * n2 until they meet. This would be our start of the CLL.
 * 
 * @author Ravali
 *
 */

public class FindStartOfCLL {

	public static class ListNode {

		ListNode m_next;
		int m_data;

		public ListNode(int data) {
			m_data = data;
			m_next = null;
		}

	}
	
	public static int getCLLStartingNode(ListNode head) {
		
		ListNode n1 = head;
		ListNode n2 = head;
		
		// Find the meeting point
		while(n2 != null && n2.m_next != null) {
			n1 = n1.m_next;
			n2 = n2.m_next.m_next;
			if(n1 == n2) {
				break;
			}
		}
		
		// This means there is no CLL.
		if(n2 == null || n2.m_next == null) {
			return -1;
		}
		
		// Now move k steps from both the head of the LL and the meeting point
		// in the CLL to get the actual start of CLL.
		n1 = head;
		while(n1 != n2) {
			n1 = n1.m_next;
			n2 = n2.m_next;
		}
		return n1.m_data;
	}
	
	public static void main(String[] args) {

		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		ListNode seven = new ListNode(7);
		ListNode eight = new ListNode(8);
		
		one.m_next = two;
		two.m_next = three;
		three.m_next = four;
		four.m_next = five;
		five.m_next = six;
		six.m_next = seven;
		seven.m_next = eight;
		eight.m_next = four;
		
		System.out.println(getCLLStartingNode(one));
		
	}

}
