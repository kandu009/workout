package trees;

import java.util.ArrayList;

/**
 * http://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
 * 
 * Given a binary tree, print out all of its root-to-leaf paths one per line.
 * 
 * @author Ravali
 *
 */
public class PrintAllRootToLeafPathsOfTree {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}

	public static void printPaths(ArrayList<Node> previousNodes, Node root) {
		
		// base case, when the node is leaf node. print the path !
		if(root.left_ == null && root.right_ == null) {
			StringBuilder sb = new StringBuilder();
			for(Node n : previousNodes) {
				sb.append(n.data_).append(" ");
			}
			sb.append(root.data_);
			System.out.println(sb.toString());
			return;
		}
		
		// Add the current node to the path and keep looking for paths with its children.
		previousNodes.add(root);
		printPaths(previousNodes, root.left_);
		printPaths(previousNodes, root.right_);
		// Remove the node, once this path is done.
		previousNodes.remove(previousNodes.size()-1);
		
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
		
		ArrayList<Node> paths = new ArrayList<Node>();
		printPaths(paths, root1);
	}

}
