package trees;

/**
 * 
 * http://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
 * 
 * Given Inorder Traversal of a Special Binary Tree in which key of every node
 * is greater than keys in left and right children, construct the Binary Tree
 * and return root.
 * 
 * Solution:
 * 
 * We find the maximum value of the node from the given inOrder array, that will
 * be the root. The left half will become the left sub tree and right half will
 * become the right sub tree. This continues recursively.
 * 
 * @author Ravali
 *
 */

public class ConstructBTWithMaxHeapPropertyFromInorder {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		Node(int data) {
			data_ = data;
		}
	}

	public static int getMaxIndex(Node[] inOrder, int startIndex, int endIndex) {
		
		int maxIndex = -1;
		int maxValue = Integer.MIN_VALUE;
		
		for(int i = startIndex; i <= endIndex; ++i) {
			if(maxValue < inOrder[i].data_) {
				maxIndex = i;
				maxValue = inOrder[i].data_;
			}
		}
		
		return maxIndex;
		
	}
	
	public static Node constructHeapLikeBT(Node[] inOrder, int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		int maxIndex = getMaxIndex(inOrder, start, end);
		Node root = inOrder[maxIndex];
		Node left = constructHeapLikeBT(inOrder, start, maxIndex-1);
		Node right = constructHeapLikeBT(inOrder, maxIndex+1, end);
		
		root.left_ = left;
		root.right_ = right;
		
		return root;
		
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
	
	public static void main(String[] args) {

		Node forty = new Node(40);
		Node ten = new Node(10);
		Node thirty = new Node(30);
		Node five = new Node(5);
		Node twentyeight = new Node(28);
		Node one = new Node(1);
		Node fifteen = new Node(15);
		Node twenty = new Node(20);
		
		Node[] inOrder = new Node[] { one, five, ten, forty, thirty, fifteen, twentyeight, twenty };
		Node root = constructHeapLikeBT(inOrder, 0, 7);
		StringBuilder sb = new StringBuilder();
		printInOrder(root, sb);
		System.out.println(sb.toString());
	}

}
