package trees;


/**
 * http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
 * 
 * Given two binary trees, check if the first tree is subtree of the second one.
 * A subtree of a tree T is a tree S consisting of a node in T and all of its
 * descendants in T.
 * 
 * Solution: Check for one interesting corner case (above link). We can add an
 * additional special characters '$' when we see a null element in the tree.
 * 
 * If it is a subTree, then inorder and pre/post-order string representation of
 * the input tree should be a sub string of the actual tree.
 * 
 * @author Ravali
 *
 */

public class CheckSubstringBinaryTree {

	public static final String SPECIAL_DELIM = "$";
	
	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}
	
	public static void getInorderNotation(Node root, StringBuilder sb) {
		
		if(root == null) {
			sb.append(SPECIAL_DELIM);
			return;
		}
		
		getInorderNotation(root.left_, sb);
		sb.append(root.data_);
		getInorderNotation(root.right_, sb);
	}
	
	public static void getPreorderNotation(Node root, StringBuilder sb) {
		
		if(root == null) {
			sb.append(SPECIAL_DELIM);
			return;
		}
		
		sb.append(root.data_);
		getPreorderNotation(root.left_, sb);
		getPreorderNotation(root.right_, sb);
	}	
	
	public static void main(String[] args) {
		
		Node subTree = new Node(24);
		Node one1 = new Node(1);
		Node two1 = new Node(2);
		Node three1 = new Node(3);
		
		subTree.left_ = one1;
		subTree.right_ = two1;
		one1.right_ = three1;
		
		Node actualTree = new Node(26);
		Node tw4 = new Node(24);
		Node one2 = new Node(1);
		Node two2 = new Node(2);
		Node three2 = new Node(3);
		Node five = new Node(5);
		Node eleven = new Node(11);
		
		actualTree.left_ = tw4;
		actualTree.right_ = five;
		tw4.left_ = one2;
		tw4.right_ = two2;
		one2.right_ = three2;
		five.right_ = eleven;
		
		StringBuilder inOrderActual = new StringBuilder();
		StringBuilder preOrderActual = new StringBuilder();
		getInorderNotation(actualTree, inOrderActual);
		getPreorderNotation(actualTree, preOrderActual);
		
		StringBuilder inOrderSub = new StringBuilder();
		StringBuilder preOrderSub = new StringBuilder();
		getInorderNotation(subTree, inOrderSub);
		getPreorderNotation(subTree, preOrderSub);
		
		if(preOrderActual.toString().indexOf(preOrderSub.toString()) != -1 && 
				inOrderActual.toString().indexOf(inOrderSub.toString()) != -1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
		
	}

	
}
