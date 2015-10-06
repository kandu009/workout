package trees;


/**
 * 
 * http://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/
 * 
 * Given an array ‘pre[]’ that represents Preorder traversal of a spacial binary
 * tree where every node has either 0 or 2 children. One more array ‘preLN[]’ is
 * given which has only two possible values ‘L’ and ‘N’. The value ‘L’ in
 * ‘preLN[]’ indicates that the corresponding node in Binary Tree is a leaf node
 * and value ‘N’ indicates that the corresponding node is non-leaf node. Write a
 * function to construct the tree from the given two arrays.
 * 
 * Solution:
 * 1. if the corresponding node value in the LN array is L, then it means that
 * 		there are no child nodes and we can just return the corresponding node 
 * 		from the preOrder array.
 * 2. if the corresponding node value in the LN array is N, then, recursively
 * 		call for the left and right nodes and join left, root, right.
 * 
 * @author Ravali
 *
 */

public class ConstructSpecialBTFromPreOrder {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}
	
	public static class NodeIndexPair {
		
		Node node_;
		int index_;
		
		public NodeIndexPair(Node node, int i) {
			node_ = node;
			index_ = i;
		}
		
	}

	public static void printInOrder(Node root, StringBuilder sb) {
		
		if(root == null) {
			return;
		}
		
		if(root.left_ != null) {
			printInOrder(root.left_, sb);
		}
		sb.append(root.data_).append(" ");
		if(root.right_ != null) {
			printInOrder(root.right_, sb);
		}
		
	}

	private static NodeIndexPair constructSpecialBT(Node[] preOrder, char[] leafNodeNonLeafNode, int index) {
		
		if(index >= leafNodeNonLeafNode.length) {
			return null;
		}
		
		if(leafNodeNonLeafNode[index] == 'L') {
			return new NodeIndexPair(preOrder[index], index);
		}
		
		Node root = preOrder[index];
		NodeIndexPair leftPair = constructSpecialBT(preOrder, leafNodeNonLeafNode, index+1);
		root.left_ = leftPair.node_;
		NodeIndexPair rightPair = constructSpecialBT(preOrder, leafNodeNonLeafNode, leftPair.index_+1);
		root.right_ = rightPair.node_;
		
		return new NodeIndexPair(root, rightPair.index_);
	}
	
	public static void main(String[] args) {

		Node ten = new Node(10);
		Node thirty = new Node(30);
		Node twenty = new Node(20);
		Node five = new Node(5);
		Node fifteen = new Node(15);

		Node[] preOrder = new Node[] { ten, thirty, twenty, five, fifteen };
		char[] leafNodeNonLeafNode = new char[] { 'N', 'N', 'L','L', 'L' };
		
		NodeIndexPair root = constructSpecialBT(preOrder, leafNodeNonLeafNode, 0);
		StringBuilder sb = new StringBuilder();
		printInOrder(root.node_, sb);
		System.out.println(sb.toString());
		
	}

}
