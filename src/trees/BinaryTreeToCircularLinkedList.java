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
 *  Solution:
 *  
 *  At every recursive level, 
 *  	create a DLL of the left tree, 
 *  	create DLL of right tree
 *  	create links for left <--> root <--> right
 *  
 *  Link the leftmost (head) and rightmost (tail) nodes to make it circular DLL.
 *  
 *  **/

public class BinaryTreeToCircularLinkedList {

	public static Node head_, tail_ = null;
	
	public static class Node {

		int data_;
		Node left_;
		Node right_;
		
		public Node(int data) {
			data_ = data;
			left_ = right_ = null;
		}
		
	}
	
	public static Node binaryTreeToAscendingCLL(Node root) {
		
		binaryTreeToAscendingCLLUtil(root);
		
		// link head and  tail.
		if(head_ != null && tail_ != null) {
			head_.left_ = tail_;
			tail_.right_ = head_;
		}
		
		return root;
	}
	
	public static Node binaryTreeToAscendingCLLUtil(Node root) {
		
		if(root == null) {
			return null;
		}
		
		Node left = null;
		// recursively create left tree as DLL.
		if(root.left_ != null) {
			left = binaryTreeToAscendingCLLUtil(root.left_);
			for(; left.right_ != null; left = left.right_);
			left.right_ = root;
			root.left_ = left;
			if(head_ == null) {
				head_ = left;
			}
		}

		// this is to keep a track a right most element.
		// This should be out of the next if condition. else
		// while unwinding the recursion tree, we will end up with a wrong right
		// most node.
		tail_ = root;
		Node right = null;
		// recursively create right tree as DLL.
		if(root.right_ != null) {
			right = binaryTreeToAscendingCLLUtil(root.right_);
			for(; right.left_ != null; right = right.left_);
			right.left_ = root;
			root.right_ = right;
		}
		
		return root;
	}
	
	public static void printTree() {
		
		Node start = head_;
		for(; start != tail_; start = start.right_) {
			System.out.println(start.data_);
		}
		System.out.println(tail_.data_);
		
	}
	
	public static void main(String[] args) {

		Node root1 = new Node(6);
		Node three1 = new Node(3);
		Node one1 = new Node(1);
		Node five1 = new Node(5);
		Node eight1 = new Node(8);
		Node seven1 = new Node(7);
		Node nine1 = new Node(9);
		Node eleven1 = new Node(11);
		Node thirteen1 = new Node(13);
		
		root1.left_ = three1;
		three1.left_ = one1;
		three1.right_ = five1;
		
		root1.right_ = eight1;
		eight1.left_ = seven1;
		eight1.right_ = eleven1;
		
		eleven1.left_ = nine1;
		eleven1.right_ = thirteen1;
		
		binaryTreeToAscendingCLL(root1);
		
		printTree();
		
	}

}
