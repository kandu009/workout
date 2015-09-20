package trees;



/**
 * http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-
 * identical/
 * 
 * Determine if Two Trees are Identical Two trees are identical when they have
 * same data and arrangement of data is also same.
 * 
 * To identify if two trees are identical, we need to traverse both trees
 * simultaneously, and while traversing we need to compare data and children of
 * the trees.
 * 
 * Algorithm:
 * 
 * 1. If both trees are empty then return true. 
 * 2. Else If
 * 		both trees are non -empty 
 * 		(a) Check data of the root nodes (tree1->data == tree2->data) 
 * 		(b) Check left subtrees recursively i.e., call sameTree(tree1->left_subtree, tree2->left_subtree) 
 * 		(c) Check right subtrees recursively i.e., call sameTree( tree1->right_subtree, tree2->right_subtree)
 * 		(d) If a,b and c are true then return true. 
 * 3 Else return 0 (one is empty and other is not)
 * 
 * @author Ravali
 *
 */
public class IdenticalTrees {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}

	public static boolean areIdenticalTrees(Node root1, Node root2) {
		
		if(root1 == null && root2 == null) {
			return true;
		}
		
		if((root1 == null && root2 != null) ||
		  (root1 != null && root2 == null)) {
			return false;
		}
		
		boolean rootStatus = root1.data_ != root2.data_ ? false : true;
		boolean leftStatus = areIdenticalTrees(root1.left_, root2.left_);
		boolean rightStatus = areIdenticalTrees(root1.right_, root2.right_);
		
		return (leftStatus && rootStatus && rightStatus);
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
		
		Node root2 = new Node(6);
		Node three2 = new Node(3);
		Node one2 = new Node(1);
		Node five2 = new Node(5);
		Node eight2 = new Node(8);
		Node seven2 = new Node(7);
		Node nine2 = new Node(9);
		Node eleven2 = new Node(11);
		Node thirteen2 = new Node(13);
		
		root2.left_ = three2;
		three2.left_ = one2;
		three2.right_ = five2;
		
		root2.right_ = eight2;
		eight2.left_ = seven2;
		eight2.right_ = eleven2;
		
		eleven2.left_ = nine2;
		eleven2.right_ = thirteen2;
		
		if(areIdenticalTrees(root1, root2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	}

}
