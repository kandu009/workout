package trees;

import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * http://www.careercup.com/question?id=5633261887815680
 */

public class TransformBinaryTree {

	private static Node DUMMY_NODE = new Node(-1);

	public static class Node {
		int data_;
		Node left_;
		Node right_;

		Node(int data) {
			data_ = data;
			left_ = null;
			right_ = null;
		}

		public boolean equals(Object obj) {
			if (obj instanceof Node) {
				if (((Node) obj).data_ == this.data_) {
					return true;
				}
			}
			return false;
		}
	}

	private static Node transform(Node root) {

		if (null == root) {
			System.out.println("Cannot transform an invalid tree !!!");
			return root;
		}

		ConcurrentLinkedQueue<Node> queue = new ConcurrentLinkedQueue<Node>();
		Stack<Node> stack = new Stack<Node>();

		queue.offer(root);
		queue.offer(DUMMY_NODE);

		while (!queue.isEmpty()) {

			if (queue.size() == 1 && queue.peek().equals(DUMMY_NODE)) {
				stack.push(DUMMY_NODE);
				break;
			}

			Node n = queue.poll();
			if (DUMMY_NODE.equals(n)) {
				stack.push(n);
				queue.offer(n);
			} else {
				if (n.right_ != null) {
					queue.offer(n.right_);
				}
				if (n.left_ != null) {
					queue.offer(n.left_);
				}
				stack.push(n);
			}
		}

		return transformHelper(stack);
	}

	private static Node transformHelper(Stack<Node> stack) {

		Node previous = null;
		Node current = null;
		Node levelCurrent = null;

		while (!stack.isEmpty()) {
			Node n = stack.pop();
			if (DUMMY_NODE.equals(n)) {
				previous = levelCurrent;
				current = null;
			} else {
				if (current == null) {
					levelCurrent = n;
					current = n;
					current.left_ = previous;
					current.right_ = null;
				} else {
					current.right_ = n;
					n.left_ = null;
					current = current.right_;
				}

			}
		}

		return levelCurrent;

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

		Node result = transform(root);

	}

}
