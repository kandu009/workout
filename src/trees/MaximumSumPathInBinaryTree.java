package trees;


/**
 * http://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
 * 
 * Given a Binary Tree, find the maximum sum path from a leaf to root. 
 * 
 * Solution:
 * 1. First recursively find the leaf which gives max sum
 * 2. Use this leaf node to select the specific path to root and print it.
 * 
 * @author Ravali
 *
 */

public class MaximumSumPathInBinaryTree {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}
	
	public static int maxSum = Integer.MIN_VALUE;
	public static Node maxSumLeaf = null;
	
	public static void findRootWithMaximumSum(Node root, int pathSum) {
		
		pathSum += root.data_;
		if(root.left_ == null && root.right_ == null) {
			if(pathSum > maxSum) {
				maxSum = pathSum;
				maxSumLeaf = root;
			}
		}
		
		if(root.left_ != null) {
			findRootWithMaximumSum(root.left_, pathSum);
		}
		if(root.right_ != null) {
			findRootWithMaximumSum(root.right_, pathSum);
		}

	}

	public static boolean printMaxSumPath(Node root) {
		
		if(root == null) {
			return false;
		}
		
		if(root == maxSumLeaf || printMaxSumPath(root.left_) || printMaxSumPath(root.right_)) {
			System.out.println(root.data_);
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		Node root1 = new Node(6);
		Node three1 = new Node(3);
		Node one1 = new Node(1);
		Node eight1 = new Node(8);
		Node seven1 = new Node(7);
		Node nine1 = new Node(9);
		Node eleven1 = new Node(11);
		Node thirteen1 = new Node(13);
		
		root1.left_ = three1;
		three1.left_ = one1;
		
		root1.right_ = eight1;
		eight1.left_ = seven1;
		eight1.right_ = eleven1;
		
		eleven1.left_ = nine1;
		eleven1.right_ = thirteen1;
		
		findRootWithMaximumSum(root1, 0);
//		System.out.println(maxSum + " " + maxSumLeaf.data_);

		printMaxSumPath(root1);
		
	}

}
