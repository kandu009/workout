package trees;

import java.util.Stack;



/**
 * 
 * http://www.geeksforgeeks.org/print-leftmost-and-rightmost-nodes-of-a-binary-
 * tree/
 * 
 * Given a Binary Tree, Print the corner nodes at each level. The node at the
 * leftmost and the node at the rightmost.
 *
 */
public class PrintCornerNodes {

	private static class Node {
		int data_;
		Node left_;
		Node right_;
		
		public Node(int data) {
			data_ = data;
			left_ = null;
			right_ = null;
		}
	}
	
	/**
	 * Just like the traditional zigzag printing, we can use two stacks and do a
	 * level order traversal. In the level order traversal, print every first/last
	 * node.
	 */
	private static void printCorderNodes(Node root, Stack<Node> s1, Stack<Node> s2) {
		
		while(!s1.isEmpty() || !s2.isEmpty()) {
			Node lastNode1 = null;
			Node firstNode = null;			
			while(!s1.isEmpty()) {
				if(lastNode1 == null) lastNode1 = s1.peek();
				firstNode = s1.pop();
				if(firstNode.right_ != null) s2.push(firstNode.right_); 
				if(firstNode.left_ != null) s2.push(firstNode.left_);
			}
			if(lastNode1 != null && firstNode != null) {
				System.out.println(firstNode.data_);
				if(firstNode != lastNode1) System.out.println(lastNode1.data_);
			}
			
			lastNode1 = null;
			firstNode = null;
			while(!s2.isEmpty()) {
				if(firstNode == null) firstNode = s2.peek();
				lastNode1 = s2.pop();
				if(lastNode1.left_ != null) s1.push(lastNode1.left_);
				if(lastNode1.right_ != null) s1.push(lastNode1.right_); 
			}
			if(lastNode1 != null && firstNode != null) {
				System.out.println(firstNode.data_);
				if(firstNode != lastNode1) System.out.println(lastNode1.data_);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(15);
		Node two = new Node(10);
		Node three = new Node(20);
		Node four = new Node(8);
		Node five = new Node(12);
		Node six = new Node(16);
		Node seven = new Node(25);

		root.left_ = two;
		root.right_ = three;

		two.left_ = four;
		two.right_ = five;

		three.left_ = six;
		three.right_ = seven;
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		
		printCorderNodes(root, s1, s2);
		
	}

}
