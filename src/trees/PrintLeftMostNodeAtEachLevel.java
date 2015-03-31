package trees;



/**
 * http://www.careercup.com/question?id=24094664
 * 
 * @author rkandur
 *
 */
public class PrintLeftMostNodeAtEachLevel {

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
	
	public static int visitedLevel = -1;
	
	public static void printLeftMostNode(Node root, int level) {
		if(root != null) {
			if(visitedLevel < level) {
				System.out.println("Level: " + level + " left most node: " + root.data_);
				visitedLevel = level;
			}
			printLeftMostNode(root.left_, level+1);
			printLeftMostNode(root.left_, level+1);
		}
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
		
		printLeftMostNode(root, 0);
		
	}

}
