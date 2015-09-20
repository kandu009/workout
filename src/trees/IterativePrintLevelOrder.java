package trees;

import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
 * 
 * Using two stacks s1 and s2.
 * s1 will have its elements pushed from left -> right
 * s2 will have its elements pushed from right -> left
 * we alternate pushing the children from s1 to s2 and vice versa.
 * 
 * @author Ravali
 *
 */
public class IterativePrintLevelOrder {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}
	
	public static void printLevelOrderIterative(Node root) {
		
		if(root == null) {
			return;
		}
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.push(root);
		
		while(!s1.isEmpty() || !s2.isEmpty()) {

			StringBuilder sb = new StringBuilder();
			while(!s1.isEmpty()) {
				Node c = s1.pop();
				sb.append(c.data_).append(" ");
				
				if(c.left_ != null) {
					s2.push(c.left_);
				}
				if(c.right_ != null) {
					s2.push(c.right_);
				}
			}
			System.out.println(sb.toString());
			
			sb = new StringBuilder();
			while(!s2.isEmpty()) {
				Node c = s2.pop();
				sb.append(c.data_).append(" ");
				
				if(c.right_ != null) {
					s1.push(c.right_);
				}
				if(c.left_ != null) {
					s1.push(c.left_);
				}
				
			}
			System.out.println(sb.toString());
			
		}
			
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
		
		printLevelOrderIterative(root1);
		
	}

}
