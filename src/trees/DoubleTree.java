package trees;


/**
 * 
 * http://www.geeksforgeeks.org/double-tree/
 * 
 * Write a program that converts a given tree to its Double tree. To create
 * Double tree of the given tree, create a new duplicate for each node, and
 * insert the duplicate as the left child of the original node.
 * 
 * Solution: 
 * For every node, create a duplicate node, recursively call its left
 * and right sub trees until you come to child node. At the lowest recursion,
 * set the duplicate node as the left child of original child and then unwind
 * recursion.
 * 
 * @author Ravali
 *
 */
public class DoubleTree {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}
	
	public static void createDoubleTree(Node root) {
		
		if(root.left_ == null && root.right_ == null) {
			Node duplicate = new Node(root.data_);
			root.left_ = duplicate;
			return;
		}
		
		Node duplicate = new Node(root.data_);
		if(root.left_ != null ) { 
			createDoubleTree(root.left_);
		}
		if(root.right_ != null ) { 
			createDoubleTree(root.right_);
		}
		Node temp = root.left_;
		root.left_ = duplicate;
		duplicate.left_ = temp;
		
	}
	
	public static void printInOrder(Node root, StringBuilder sb) {
		
		if(root == null) {
			return;
		}
		
		if(root.left_ != null) {
			printInOrder(root.left_, sb);
		}
		sb.append(root.data_).append(" ");
		if(root.right_ != null) {
			printInOrder(root.right_, sb);
		}
		
	}
	
	public static void main(String[] args) {

		Node two = new Node(2);
		Node one = new Node(1);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		
		one.left_ = two;
		one.right_ = three;

		two.left_ = four;
		two.right_ = five;
		
		createDoubleTree(one);
		
		StringBuilder sb = new StringBuilder();
		printInOrder(one, sb);
		System.out.println(sb.toString());
		
	}

}
