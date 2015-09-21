package trees;


/**
 * http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
 * 
 * Given a Binary Tree, find vertical sum of the nodes that are in same vertical
 * line. Print all sums through different vertical lines.
 * 
 * Solution:
 * 1. First find how wide (i.e. max distance of left most and right most nodes) from root node.
 * 2. Using this range, construct an array to accommodate left+1+right limit.
 * 3. recursively cumulate the sum of the values to the #2 array based on the current nodes distance. 
 * 
 * @author Ravali
 *
 */
public class VerticalSumInBinaryTree {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}
	
	public static int[] getLeftRightDistancesFromRoot(Node root, int distanceFromRoot) {
		
		if(root.left_ == null && root.right_ == null) {
			return new int[] {distanceFromRoot, distanceFromRoot};
		}
		
		int[] leftBounds = new int[2];
		if(root.left_ != null) {
			leftBounds = getLeftRightDistancesFromRoot(root.left_, distanceFromRoot-1);
		}
		int[] rightBounds = new int[2];
		if(root.right_ != null) {
			rightBounds = getLeftRightDistancesFromRoot(root.right_, distanceFromRoot+1);
		}
		
		return new int[] { Math.min(leftBounds[0], rightBounds[0]), Math.max(leftBounds[1], rightBounds[1])};
	}
	
	public static void computeVerticalSum(Node root, int[] verticalSum, int distanceToRoot) {
		
		if(root == null) {
			return;
		}
		
		verticalSum[distanceToRoot] += root.data_;
		computeVerticalSum(root.left_, verticalSum, distanceToRoot-1);
		computeVerticalSum(root.right_, verticalSum, distanceToRoot+1);
		
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
		
		int[] bounds = getLeftRightDistancesFromRoot(root1, 0);

		// This array will hold the vertical sum.
		int[] verticalSums = new int[bounds[1]-bounds[0]+1];
		computeVerticalSum(root1, verticalSums, Math.abs(bounds[0]));
		for(int i = 0; i < verticalSums.length; ++i) {
			System.out.println(verticalSums[i]);
		}
		
	}

}
