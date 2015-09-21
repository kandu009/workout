package trees;

/**
 * http://www.geeksforgeeks.org/populate-inorder-successor-for-all-nodes/
 * 
 * Given a Binary Tree where each node has following structure, write a function
 * to populate next pointer for all nodes. The next pointer for every node
 * should be set to point to inorder successor.
 * 
 * Solution: 
 * 1. Do a reverse inorder traversal. 
 * 2. At every node, store the current node to make it the successor 
 * of the next node in reverse inorder traversal.
 * 
 * @author Ravali
 *
 */

public class UpdateInorderSuccessor {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		Node successor_;
		
		Node(int data) {
			data_ = data;
		}
	}
	
	public static Node successor = null;
	
	public static void updateSuccessor(Node root) {
	
		if(root == null) {
			return;
		}
		
		updateSuccessor(root.right_);
		root.successor_ = successor;
		successor = root;
		updateSuccessor(root.left_);
		
	}
	
	public static void printTree(Node root) {
		
		// this needs to be changed if the tree does not have the left most
		// child as the left children's left most.
		while(root.left_ != null) {
			root = root.left_;
		}
		
		while(root != null) {
			System.out.println(root.data_);
			root = root.successor_;
		}
		
	}
	
	public static void main(String[] args) {

		Node root1 = new Node(6);
		Node three1 = new Node(3);
		Node one1 = new Node(1);
		Node eight1 = new Node(8);
		Node seven1 = new Node(7);
		Node nine1 = new Node(9);
		Node eleven1 = new Node(11);
		Node thirteen1 = new Node(13);
		
		root1.left_ = three1;
		three1.left_ = one1;
		
		root1.right_ = eight1;
		eight1.left_ = seven1;
		eight1.right_ = eleven1;
		
		eleven1.left_ = nine1;
		eleven1.right_ = thirteen1;
		
		updateSuccessor(root1);
		
		printTree(root1);

	}

}
