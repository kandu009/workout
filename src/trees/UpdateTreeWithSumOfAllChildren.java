package trees;



/**
 * http://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 * 
 * Given a Binary Tree where each node has positive and negative values. Convert
 * this to a tree where each node contains the sum of the left and right sub
 * trees in the original tree. The values of leaf nodes are changed to 0.
 * 
 * Check the page for correct example and explanation of what needs to be done.
 * 
 * @author Ravali
 *
 */

public class UpdateTreeWithSumOfAllChildren {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}
	
	public static int populateChildrenSumTree(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int oldData = root.data_;
		int newLeftData = populateChildrenSumTree(root.left_);
		int newRightData = populateChildrenSumTree(root.right_);
		root.data_ = newLeftData+newRightData;
		
		return root.data_+oldData;
		
	}
	
	public static void printInOrder(Node root, StringBuilder sb) {
		
		if(root == null) {
			return;
		}
		
		printInOrder(root.left_, sb);
		sb.append(root.data_).append(" ");
		printInOrder(root.right_, sb);
		
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
		
		populateChildrenSumTree(root1);
		StringBuilder sb = new StringBuilder();
		printInOrder(root1, sb);
		System.out.println(sb.toString());
		
	}

}
