package trees;
import java.util.Stack;


public class InOrderTraversalIterative {

	public static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}
	
	private static void printInorder(Node root) {
		
		if(root == null) {
			return;
		}
		
		Stack<Node> s = new Stack<Node>();
		
		while(s.size() > 0 || root != null) {
			
			if(root == null) {
				root = s.pop();
				System.out.println(root.data);
				root = root.right;
			} else {
				s.push(root);
				root = root.left;
			}
		}
		
	}
	
	public static void main(String[] args) {

		Node root = new Node(8);
		Node l1 = new Node(7);
		Node r1 = new Node(12);
		root.left = l1;
		root.right = r1;
		
		Node l11 = new Node(5);
		Node l12 = new Node(6);
		l1.left = l11;
		l1.right = l12;
		
		Node l13 = new Node(11);
		Node l14 = new Node(13);
		r1.left = l13;
		r1.right = l14;
		
		printInorder(root);
		
	}

}
