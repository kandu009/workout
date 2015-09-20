package trees;


/**
 * http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 * 
 * Given a binary tree and a number, return true if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals the given
 * number. Return false if no such path can be found.
 * 
 * Solution: 
 * Compute the sum of the root to node paths, when you have the sum @child
 * node, compare with given sum. If it matches return true. Else go for the
 * other paths and search recursively.
 * 
 * @author Ravali
 *
 */
public class RootToLeafPathSumEqualToNumber {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		public Node(int d) {
			data_ = d;
			left_ = null;
			right_ = null;
		}
	}

	public static boolean isRootToLeafSumEqualTo(Node root, int givenSum, int calculatedSum) {
		
		if(root == null) {
			return (calculatedSum == givenSum);
		}
		
		calculatedSum += root.data_;
		
		if(isRootToLeafSumEqualTo(root.left_, givenSum, calculatedSum)) {
			return true;
		}
		
		return isRootToLeafSumEqualTo(root.right_, givenSum, calculatedSum);
		
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

		if(isRootToLeafSumEqualTo(root1, 14, 0)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	}

}
