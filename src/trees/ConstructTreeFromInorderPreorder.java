package trees;

/**
 * 
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * 
 * Construct Tree from given Inorder and Preorder traversals Let us consider the
 * below traversals:
 * 
 * Inorder sequence: D B E A F C 
 * Preorder sequence: A B D E C F
 * 
 * In a Preorder sequence, leftmost element is the root of the tree.
 * So we know ‘A’ is root for given sequences. 
 * By searching ‘A’ in Inorder sequence, we can find out all elements on 
 * left side of ‘A’ are in left subtree and elements on right are in right subtree. 
 * 
 * So we know below structure now. Do this recursively.
 * 
 * @author Ravali
 *
 */
public class ConstructTreeFromInorderPreorder {

	public static class Node {
		char data_;
		Node left_;
		Node right_;
		
		public Node(char d) {
			data_ = d;
			left_ = null;
			right_ = null;
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
	
	public static int findRootIndexFromInOrderArray(Node[] inOrder, Node root){
		
		for (int i = 0; i < inOrder.length; ++i) {
			if(inOrder[i].data_ == root.data_) {
				return i;
			}
		}
		return -1;
	}

	public static Node getTreeFromInorderPreorder(
			Node[] inOrder, Node[] preOrder, int inOrderStartIndex, int inOrderEndIndex, int preOrderIndex) {
		
		if(preOrderIndex >= preOrder.length || inOrderStartIndex >= inOrder.length || inOrderEndIndex >= inOrder.length) {
			return null;
		}

		if(inOrderStartIndex > inOrderEndIndex) {
			return null;
		}
		if(inOrderStartIndex == inOrderEndIndex) {
			return inOrder[inOrderStartIndex];
		}
		
		Node root = preOrder[preOrderIndex++];
		int rootIndexInorder = findRootIndexFromInOrderArray(inOrder, root);
		Node leftChild = getTreeFromInorderPreorder(inOrder, preOrder, 
				inOrderStartIndex, rootIndexInorder-1, preOrderIndex);
		Node rightChild = getTreeFromInorderPreorder(inOrder, preOrder, 
				rootIndexInorder+1, inOrderEndIndex, rootIndexInorder+preOrderIndex);
		root.left_ = leftChild;
		root.right_ = rightChild;
		
		return root;
	}
	
	public static void main(String[] args) {

		Node a = new Node('a');
		Node b = new Node('b');
		Node c = new Node('c');
		Node d = new Node('d');
		Node e = new Node('e');
		Node f = new Node('f');
		
		Node[] inOrder = new Node[6];
		inOrder[0] = d;
		inOrder[1] = b;
		inOrder[2] = e;
		inOrder[3] = a;
		inOrder[4] = f;
		inOrder[5] = c;
		
		Node[] preOrder = new Node[6];
		preOrder[0] = a;
		preOrder[1] = b;
		preOrder[2] = d;
		preOrder[3] = e;
		preOrder[4] = c;
		preOrder[5] = f;
		
		if(inOrder.length != preOrder.length) {
			System.out.println("Incorrect pre and in order sequences");
		}
		
		Node root = getTreeFromInorderPreorder(inOrder, preOrder, 0, inOrder.length-1, 0);
		
		StringBuilder sb = new StringBuilder();
		printInOrder(root, sb);
		System.out.println(sb.toString());
		
	}

}
