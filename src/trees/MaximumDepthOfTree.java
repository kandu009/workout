package trees;


/**
 * http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-
 * height-of-a-tree/
 * 
 * Find the Maximum Depth or Height of a Tree
 * 
 * Solution:
 * 
 * 1. If tree is empty then return 0 
 * 2. Else 
 * (a) Get the max depth of left subtree recursively i.e., call maxDepth( tree->left-subtree) 
 * (b) Get the max depth of right subtree recursively i.e., call maxDepth( tree->right-subtree)
 * (c) Get the max of max depths of left and right subtrees and add 1 to it for the current node. 
 * 		max_depth = max(max dept of left subtree, max depth of right subtree) + 1 
 * (d) Return max_depth
 * 
 * @author Ravali
 *
 */
public class MaximumDepthOfTree {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}

	public static int getMaximumDepth(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int leftDepth = getMaximumDepth(root.left_);
		int rightDepth = getMaximumDepth(root.right_);
		return 1+Math.max(leftDepth, rightDepth);
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

		System.out.println(getMaximumDepth(root1));
		
	}

}
