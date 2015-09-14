package trees;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * http://www.careercup.com/question?id=6056099308371968
 * 
 * You are given a sorted skewed binary tree. How can you create a binary search
 * tree of minimum height from it?
 * 
 * Solution:
 * 
 * 1. By using extra space, do an inorder traversal, and write the elements
 * 	  to the array. Since Tree is sorted, array should also be sorted. 
 * 2. Use binary search to find the middle element of the array and make it the root. 
 * 3. Recursively invoke binary search on the left half and right half of the array 
 * 	  to create left subtree and right subtree.
 * 
 * @author Ravali
 *
 */
public class SortedSkewedBinaryTreeToBST {

	public static int SIZE_OF_TREE = 7;
	
	public static class Node {
		int data_;
		Node left_;
		Node right_;
		
		public Node(int data) {
			data_ = data;
		}
	}
	
	// Note: Assuming 10 is the size of node array.
	// If not, we can do a inorder traversal first to check the size and then
	// initialize the node array.
	public static Node[] sortedNodes = new Node[SIZE_OF_TREE];
	
	public static void getSortedInorderTraversal(Node root) {
		
		if(root == null) {
			return;
		}
		if(root.left_ == null && root.right_ == null) {
			sortedNodes[0] = root;
			return;
		}
		ArrayBlockingQueue<Node> queue = new ArrayBlockingQueue<Node>(10);
		queue.offer(root);
		int i = 0;
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(curr.left_ != null) {
				queue.offer(curr.left_);
			}
			if(curr.right_ != null) {
				queue.offer(curr.right_);
			}
			sortedNodes[i++] = curr;
		}
		
	}
	
	public static Node getBSTFromSortedArray(int start, int end) {
		
		if(start > end) {
			return null;
		}
		if(start == end) {
			return sortedNodes[start];
		}
		
		int mid = start+(end-start)/2;
		Node root = sortedNodes[mid];
		root.left_ = getBSTFromSortedArray(start, mid-1);
		root.right_ = getBSTFromSortedArray(mid+1, end);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		root.left_ = two;
		root.right_ = three;

		two.left_ = four;
		two.right_ = five;

		three.left_ = six;
		three.right_ = seven;
		
		getSortedInorderTraversal(root);
//		for(int i = 0; i < sortedNodes.length; ++i) {
//			System.out.println(sortedNodes[i].data_);
//		}
		
		getBSTFromSortedArray(0, sortedNodes.length-1);
		
		
	}

}
