package todo;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * http://www.careercup.com/question?id=5721462438625280
 * 
 * do an inorder traversal and keep a track of parent nodes for these swapping
 * nodes. once you find two parents, swap their positions wrt parents.
 * 
 * faulty cases : 
 * 
 * 1. when one of the nodes to be swapped is root (this can be
 * solved using the first check in swapTwoNodes method 
 * 2. when one is a parent of
 * the other. (this can be solved by stopping pushing of children when a node is
 * encountered)
 * 
 * @author rkandur
 *
 */
public class SwapNodesInTree {

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
	
	private static void swapTwoNodesHelper(Node n1, Node n2, ArrayBlockingQueue<Node> queue) {
		
		Node parent1 = null;
		Node parent2 = null;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			if(n1 == current.left_ || n1 == current.right_) {
				parent1 = current;
			}
			if(n2 == current.left_ || n1 == current.right_) {
				parent2 = current;
			}
			
			if(parent1 == null || parent2 == null) {
				if(current.left_ != null && current.left_ != n1 && current.left_ != n2) {
					queue.offer(current.left_);
				} 
				if (current.right_ != null && current.right_ != n1 && current.right_ != n2){
					queue.offer(current.right_);
				}
			} else {
				break;
			}
		}
		
		if(parent1 == null || parent2 == null) {
			System.out.println("Cannot be swapped !!!!");
			return;
		}
		
		if(parent1.left_ == n1) {
			parent1.left_ = n2;
		} else {
			parent1.right_ = n2;
		}
		
		if(parent2.left_ == n2) {
			parent2.left_ = n1;
		} else {
			parent2.right_ = n1;
		}
		
		System.out.println("Swapped nodes successfully !!!");
		
	}
	
	private static void swapTwoNodes(Node n1, Node n2, Node root) {
		
		if(n1 == root || n2 == root) {
			System.out.println("Cannot be swapped !!!");
			return;
		} 
		ArrayBlockingQueue<Node> queue = new ArrayBlockingQueue<Node>(3);
		queue.offer(root);
		swapTwoNodesHelper(n1, n2, queue);
		
	}
	
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		root.left_ = two;
		root.right_ = three;

		two.left_ = four;
		two.right_ = five;

		three.left_ = six;
		three.right_ = seven;
		
		swapTwoNodes(two, four, root);
		
	}

}
