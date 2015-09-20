package recursion;

/**
 * http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
 * 
 * Add additional pointers to a Node which keeps a 
 * track of in-order predecessor and successor.
 * 
 * Solution:
 * construct the left child DLL recursively
 * Link left to root
 * construct the right child DLL recursively
 * Link right to root
 * 
 * @author Ravali
 *
 */
public class BinaryTreeToLinkedList {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		Node predecessor_;
		Node successor_;
		
		Node(int data) {
			data_ = data;
		}
	}

	public static Node convertBinaryTreeToDLL(Node root) {
		
		if(root == null) {
			return root;
		}
		
		Node left = null;
		if(root.left_ != null) {
			left = convertBinaryTreeToDLL(root.left_);
			for(; left.successor_ != null; left = left.successor_);		// This is what I could have done @Google !!!!!
			left.successor_ = root;
			root.predecessor_ = left;
		}
		
		Node right = null;
		if(root.right_ != null) {
			right = convertBinaryTreeToDLL(root.right_);
			for(; right.predecessor_ != null; right = right.predecessor_); // This is what I could have done @Google !!!!!
			right.predecessor_ = root;
			root.successor_ = right;
		}
		
		return root;
		
	}
	
	public static void printTree(Node root) {
		if(root == null) {
			return;
		}
		if(root.left_ != null) {
			printTree(root.left_);
		}
		
		StringBuilder msg = new StringBuilder();
		msg.append(root.data_);
//		if(root.predecessor_ != null) {
//			msg.append(root.predecessor_.data_);
//		}
//		if(root.successor_ != null) {
//			msg.append(root.successor_.data_);
//		}
		System.out.println(msg);
		
		if(root.right_ != null) {
			printTree(root.right_);
		}
	}
	
	public static void main(String[] args) {
		Node six = new Node(6);
		Node three = new Node(3);
		Node one = new Node(1);
		Node five = new Node(5);
		Node eight = new Node(8);
		Node seven = new Node(7);
		Node nine = new Node(9);
		Node eleven = new Node(11);
		Node thirteen = new Node(13);
		
		six.left_ = three;
		three.left_ = one;
		three.right_ = five;
		
		six.right_ = eight;
		eight.left_ = seven;
		eight.right_ = eleven;
		
		eleven.left_ = nine;
		eleven.right_ = thirteen;
		
		convertBinaryTreeToDLL(six);

		printTree(six);
		
	}

}
