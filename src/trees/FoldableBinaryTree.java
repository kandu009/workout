package trees;

import trees.RootToLeafPathSumEqualToNumber.Node;


/**
 * http://www.geeksforgeeks.org/foldable-binary-trees/
 * 
 * Given a binary tree, find out if the tree can be folded or not.
 * 
 * A tree can be folded if left and right subtrees of the tree are structure
 * wise mirror image of each other. 
 * An empty tree is considered as foldable.
 * 
 * Solution:
 * Start with the children of the root
 * In parallel, return true if one of these is true recursively
 * 1) If both trees are empty then return true.
 * 2) If one of them is empty and other is not then return false.
 * 3) Return true if following conditions are met
 *    a) n1->left is mirror of n2->right
 *    b) n1->right is mirror of n2->left
 * 
 * return false otherwise
 * 
 * @author Ravali
 *
 */
public class FoldableBinaryTree {
	
	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}
	
	private static boolean isFoldableTreeUtil(Node root1, Node root2) {

		if(root1 == null && root2 == null) {
			return true;
		}
		if((root1 == null && root2 != null) || (root2 == null && root1 != null)) {
			return false;
		}		
		return (isFoldableTreeUtil(root1.left_, root2.right_) && 
				isFoldableTreeUtil(root1.right_, root2.left_));
	}
	
	public static boolean isFoldableTree(Node root) {
		if(root == null) {
			return true;
		}
		return isFoldableTreeUtil(root.left_, root.right_);
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

		if(isFoldableTree(root1)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	}

}
