package trees;


/**
 * http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
 * 
 * @author Ravali
 *
 */
public class RecursivePrintLevelOrderSpiral {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}
	
	public static void printLevel(Node root, int level, boolean leftToRight, StringBuilder sb) {
		if(root == null) {
			return;
		}
		if(level == 1) {
			sb.append(root.data_).append(" ");
			return;
		}
		if(leftToRight) {
			printLevel(root.left_, level-1, leftToRight, sb);
			printLevel(root.right_, level-1, leftToRight, sb);
		} else {
			printLevel(root.right_, level-1, leftToRight, sb);
			printLevel(root.left_, level-1, leftToRight, sb);
		}
	}
	
	public static int heightOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = heightOfTree(root.left_);
		int rightHeight = heightOfTree(root.right_);
		return 1+leftHeight+rightHeight;
	}
	
	public static void printLevelOrderRecursive(Node root) {
		
		int height = heightOfTree(root);
		boolean leftToRight = true;
		for(int i = 1; i <= height; ++i) {
			StringBuilder sb = new StringBuilder();
			printLevel(root, i, leftToRight, sb);
			System.out.println(sb.toString());
			leftToRight = !leftToRight;
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
		
		printLevelOrderRecursive(root1);
		
	}

}
