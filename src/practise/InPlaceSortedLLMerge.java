package practise;


public class InPlaceSortedLLMerge {

	class ListNode {

		ListNode m_next;
		int m_data;

		public ListNode(int data) {
			m_data = data;
			m_next = null;
		}

	}
	
	public ListNode mergeLists(ListNode l1, ListNode l2) {
		
		if(l1 == null) {
			return l2;
		} 
		
		if(l2 == null) {
			return l1;
		}
		
		ListNode previous = null;
		while(true) {
			if(l1 == null) {
				previous.m_next = l2;
				break;
			}
			if(l2 == null) {
				break;
			}
			if(l1.m_data < l2.m_data) {
				previous = l1;
				l1 = l1.m_next;
			} else {
				ListNode temp = l1;
				previous.m_next = l2;
				l2 = l2.m_next;
				previous.m_next.m_next = temp;
				previous = temp;
			}
		}
		
		return l1;
		
	}

}
