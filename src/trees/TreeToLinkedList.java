package trees;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * http://www.careercup.com/question?id=5762018378252288
 *
 */
public class TreeToLinkedList {

	private static Node DUMMY = new Node(-1);
	
	public static class Node {
		int data_;
		Node left_;
		Node right_;

		Node(int data) {
			data_ = data;
			left_ = null;
			right_ = null;
		}
	}

	public static class LinkedListNode {
		int data_;
		LinkedListNode next_;

		LinkedListNode(int data) {
			data_ = data;
			next_ = null;
		}
	}
	
	private static ArrayList<LinkedListNode> convertTreeToLinkedList(Node root) {
		
		ConcurrentLinkedQueue<Node> q1 = new ConcurrentLinkedQueue<Node>();
		
		q1.add(root);
		q1.offer(DUMMY);
		
		ArrayList<LinkedListNode> ll = new ArrayList<LinkedListNode>();

		LinkedListNode head = null;
		LinkedListNode current = null;

		while(!q1.isEmpty()) {
			
			if (q1.size() == 1 && q1.peek() == DUMMY) {
				ll.add(head);
				break;
			}
			
			Node n = q1.poll();
			if(n == DUMMY) {
				q1.offer(n);
				ll.add(head);
				head = null;
				current = null;
			} else {
				
				if(n.left_ != null) {
					q1.offer(n.left_);
				}
				if(n.right_ != null) {
					q1.offer(n.right_);
				}
				
				if(head == null) {
					head = new LinkedListNode(n.data_);
					current = new LinkedListNode(n.data_);
				} else {
					current.next_ = new LinkedListNode(n.data_);
					current = current.next_;
				}
			}
		}

		return ll;
		
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

		for(LinkedListNode ls : convertTreeToLinkedList(root)) {
			// printList(ls); may be add a method to print this
		}
		
	}

}
