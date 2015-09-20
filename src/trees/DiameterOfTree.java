package trees;


/**
 * 
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * 
 * The diameter of a tree (sometimes called the width) is the number of nodes on
 * the longest path between two leaves in the tree. The diagram below shows two
 * trees each with diameter nine, the leaves that form the ends of a longest
 * path are shaded (note that there is more than one path in each tree of length
 * nine, but no path longer than nine nodes).
 * 
 * Solution:
 * For every node, the possible candidates for max diameter would be
 * 1. Left Subtree height + Right Subtree height + 1
 * 2. Longest Diameter of the left subtree 
 * 		(i.e., some of its right children have #1 more than current node)
 * 3. Longest Diameter of the right subtree 
 * 		(i.e., some of its right children have #1 more than current node) 
 * 
 * @author Ravali
 *
 */
public class DiameterOfTree {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}
	
	public static int heightOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = heightOfTree(root.left_);
		int rightHeight = heightOfTree(root.right_);
		return 1+Math.max(leftHeight,rightHeight);
	}
	
	public static int diameterOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = heightOfTree(root.left_);
		int rightHeight = heightOfTree(root.right_);
		
		int leftDiameter = diameterOfTree(root.left_);
		int rightDiameter = diameterOfTree(root.right_);
		return Math.max(1+leftHeight+rightHeight, Math.max(leftDiameter, rightDiameter));
		
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

		System.out.println(diameterOfTree(root1));
		
	}

}
