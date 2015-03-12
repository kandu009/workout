package practise;

/**
 * Method 1 (Simple) Following is a simple algorithm where we first find the
 * middle node of list and make it root of the tree to be constructed.
 * 
 * 1) Get the Middle of the linked list and make it root. 2) Recursively do same
 * for left half and right half. a) Get the middle of left half and make it left
 * child of the root created in step 1. b) Get the middle of right half and make
 * it right child of the root created in step 1.
 * 
 * Time complexity: O(nLogn) where n is the number of nodes in Linked List.
 * 
 * See this forum thread for more details.
 * 
 * Method 2 (Tricky) The method 1 constructs the tree from root to leaves. In
 * this method, we construct from leaves to root.
 * 
 * The idea is to insert nodes in BST in the same order as the appear in Linked
 * List, so that the tree can be constructed in O(n) time complexity. We first
 * count the number of nodes in the given Linked List. Let the count be n. After
 * counting nodes, we take left n/2 nodes and recursively construct the left
 * subtree. After left subtree is constructed, we allocate memory for root and
 * link the left subtree with root. Finally, we recursively construct the right
 * subtree and link it with root. While constructing the BST, we also keep
 * moving the list head pointer to next so that we have the appropriate pointer
 * in each recursive call.
 * 
 */

/**
 * Method 2 is Implemented
 *
 */
class BSTFromSortedList {
	
	class ListNode {
		
		ListNode m_next;
		int m_data;
		
		public ListNode(int data) {
			m_data = data;
			m_next = null;
		}
		
	}
	
	class TreeNode {

		int m_data;
		TreeNode m_left;
		TreeNode m_right;
		
		public TreeNode(int data) {
			m_data = data;
			m_left = m_right = null;
		}
		
	}
	
	static ListNode m_sortedList;
	
	public int getLength(ListNode head) {
		
		int len = 0;
		
		ListNode temp = head;
		while(temp != null) {
			++len;
			temp = temp.m_next;
		}
		
		return len;
	}

	public TreeNode getBSTFromSortedList(ListNode head) {
		
		if(head == null) {
			return null;
		}
		
		int length = getLength(head);
		if(length <= 0) {
			return null;
		}
		
		return getBSTFromSortedListHelper(head, length);
		
	}

	private TreeNode getBSTFromSortedListHelper(ListNode head, int length) {

		TreeNode left = getBSTFromSortedListHelper(head, length/2);
		
		TreeNode root = new TreeNode(head.m_data);
		
		head = head.m_next;
		
		TreeNode right = getBSTFromSortedListHelper(head, length-length/2-1);
		
		root.m_left = left;
		root.m_right = right;
		
		return root;
	}
	
}