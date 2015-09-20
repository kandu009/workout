package trees;

import trees.FoldableBinaryTree.Node;

/**
 * 
 * http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
 * 
 * Given a root of a tree, and an integer k. Print all the nodes which are at k
 * distance from root.
 * 
 * @author Ravali
 *
 */
public class PrintNodesAtKDistanceFromRoot {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}
	
	public static void getAllNodesAtDistanceFromRoot(
			Node root, int distance, StringBuilder sb, int currentDistance) {
		
		if(root == null) {
			return;
		}
		
		if(currentDistance == distance) {
			sb.append(root.data_).append(" ");
		}
		
		getAllNodesAtDistanceFromRoot(root.left_, distance, sb, currentDistance+1);
		getAllNodesAtDistanceFromRoot(root.right_, distance, sb, currentDistance+1);
		
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

		StringBuilder sb = new StringBuilder();
		int distance = -1;
		getAllNodesAtDistanceFromRoot(root1, distance, sb, 0);
		System.out.println(sb.toString());
		
	}

}
