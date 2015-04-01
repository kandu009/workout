package trees;


/** http://www.careercup.com/question?id=5156120807079936
 * 
 * we should follow an inorder traversal to create a DLL, then link the head and tail
 * to create a circular linked list 
 * 						10
 * 				12				15
 * 			25		30		36
 * 
 * 	-->	25 <-> 12 <-> 30 <-> 10 <-> 36 <-> 15 <--
 * 	|											 |
 * 	---------------------------------------------	
 *  
 *  **/

public class BinaryTreeToCircularLinkedList {

	public static TreeNode head, prev = null;
	
	class TreeNode {

		int m_data;
		TreeNode m_left;
		TreeNode m_right;
		
		public TreeNode(int data) {
			m_data = data;
			m_left = m_right = null;
		}
		
	}
	
	public static void convertBinaryTreeToCLL(TreeNode root) {
		if(root == null) {
			return;
		}
		convertBinaryTreeToCLL(root.m_left);
		if(prev == null) {
			head = root;
		} else {
			prev.m_right = root;
			root.m_left = prev;
		}
		prev = root;
		convertBinaryTreeToCLL(root.m_right);
		if(prev.m_right == null) {
			head.m_left = prev;
			prev.m_right = head;
		}
	}
	
	public static void main(String[] args) {

	}

}
