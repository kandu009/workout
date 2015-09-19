package recursion;

import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 * 
 * Reverse a stack using recursion You are not allowed to use loop constructs
 * like while, for..etc, and you can only use the following ADT functions on
 * Stack S: isEmpty(S) push(S) pop(S)
 * 
 * Solution: When a new insert comes, pop the current top recursively until no
 * more elements are left in the stack. Then when stack is empty, push new
 * element, then recursively push back the earlier top elements.
 * 
 * @author Ravali
 *
 */
public class StackWithBottomInsert {

	public static Stack<Integer> insertAtBottom(int newElement, Stack<Integer> s) {
		
		if(s == null || s.isEmpty()) {
			s = (s==null) ? new Stack<Integer>() : s;
			s.push(newElement);
			return s;
		}
		
		// pop current top.
		int topElement = s.pop();
		// insert the new element at bottom recursively
		insertAtBottom(newElement, s);
		// push back previous top.
		s.push(topElement);
		return s;
	}
	
	public static void printStack(Stack<Integer> s) {
		Stack<Integer> ns = new Stack<Integer>();
		ns.addAll(s);
		while(!ns.isEmpty()) {
			System.out.println(ns.pop());
		}
	}
	
	public static void main(String[] args) {

		Stack<Integer> s = null;
		s = insertAtBottom(4, s);
//		printStack(s);
		
		s = insertAtBottom(3, s);
//		printStack(s);
		
		s = insertAtBottom(2, s);
//		printStack(s);
		
		s = insertAtBottom(1, s);
		printStack(s);
		
	}

}
