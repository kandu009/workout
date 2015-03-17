package misc;
import java.util.Stack;

/**
 * http://www.careercup.com/question?id=5964523655659520
 * 
 * @author rkandur
 *
 * Imagine all items are organized into two stacks, 
 * draw them facing each other where face is where you 
 * put and peek:
 * 
 * 1,2,3,4-><-5,6,7,8
 * 
 * TODO: Can this be improved by using more than a pair of stacks ?
 *
 */
public class DoubleLinkedListFromStack {

	public static class Node {
		int data_;
		public Node(int data) {
			data_ = data;
		}
		public Node(Node node) {
			data_ = node.data_;
		}
	}
	
	public static class DLLFromStack {
		
		Node head_;
		Node tail_;
		Stack<Node> leftStack_ = new Stack<Node>();
		Stack<Node> rightStack_ = new Stack<Node>();
		
		public DLLFromStack() {
			head_ = null;
			tail_ = null;
		}
		
		public void addInTheFront(Node node) {
			if(head_ == null && tail_ == null) {
				head_ = new Node(node);
				tail_ = head_;
				leftStack_.push(head_);
				return;
			}
			while(!leftStack_.isEmpty()) {
				rightStack_.push(leftStack_.pop());
			}
			head_ = new Node(node);
			leftStack_.push(head_);
		}
		
		public Node removeFromTheFront() {
			
			if(head_ == null && tail_ == null) {
				return null;
			} 

			Node removed = null;
			if(head_ == tail_) {
				removed = new Node(head_);
				head_ = null;
				tail_ = null;
				leftStack_.clear();
				rightStack_.clear();
			} else if(leftStack_.isEmpty()) {
				removed = rightStack_.pop();
				head_ = rightStack_.peek();
			} else { 
				while(leftStack_.size() > 1) {
					rightStack_.push(leftStack_.pop());
				}
				removed = leftStack_.pop();
				head_ = rightStack_.peek();
			}
			return removed;
			
		}
		
		public void addAtTheTail(Node node) {
			if(head_ == null && tail_ == null) {
				head_ = new Node(node);
				tail_ = head_;
				rightStack_.push(head_);
				return;
			}
			while(!rightStack_.isEmpty()) {
				leftStack_.push(rightStack_.pop());
			}
			tail_ = new Node(node);
			rightStack_.push(tail_);
		}
		
		public Node removeFromTheTail() {
			
			if(head_ == null && tail_ == null) {
				return null;
			} 

			Node removed = null;
			if(head_ == tail_) {
				removed = new Node(head_);
				head_ = null;
				tail_ = null;
				leftStack_.clear();
				rightStack_.clear();
			} else if(rightStack_.isEmpty()) {
				removed = leftStack_.pop();
				tail_ = leftStack_.peek();
			} else { 
				while(rightStack_.size() > 1) {
					leftStack_.push(rightStack_.pop());
				}
				removed = rightStack_.pop();
				head_ = leftStack_.peek();
			}
			return removed;
			
		}
		
		public int size() {
			return leftStack_.size() + rightStack_.size();
		}

	}
	
	public static void main(String[] args) {
		
		DLLFromStack dll = new DLLFromStack();
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		
		dll.addAtTheTail(n1);
		dll.addInTheFront(n2);
		dll.addAtTheTail(n3);
		dll.addAtTheTail(n4);
		dll.addInTheFront(n5);
		dll.addInTheFront(n6);
		dll.addAtTheTail(n7);
		dll.addInTheFront(n8);
		
		System.out.println(dll.removeFromTheTail().data_);
		System.out.println(dll.removeFromTheFront().data_);
		System.out.println(dll.removeFromTheFront().data_);
		System.out.println(dll.removeFromTheTail().data_);
		System.out.println(dll.removeFromTheTail().data_);
		System.out.println(dll.removeFromTheFront().data_);
		System.out.println(dll.removeFromTheFront().data_);
		System.out.println(dll.removeFromTheFront().data_);
		
	}

}
