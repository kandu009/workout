package trees;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * http://www.careercup.com/question?id=5650673746051072
 * 
 * Solution: 
 * We can use the binary heap implementation concept using array here.
 * i.e., for k'th index, its children are found in 2k+1 and 2k+2 locations.
 * 
 * @author Ravali
 *
 */

public class SerializeDeserializeBinaryTree {

	public static Node DUMMY = new Node(-1);
	
	private static class Node {
		
		int data_;
		Node left_;
		Node right_;
		
		public Node(int data) {
			data_ = data;
			left_ = null;
			right_ = null;
		}
	
	}

//	Use a queue to do a BFS and fill out the array.
//	If there is no children, then we are using -1 as the null representation.
	public static int[] serializeTree(Node root, int length) {
		
		if (root == null) {
			return null;
		}
		
		int[] result = new int[length];
		int index = 0;
		
		ArrayBlockingQueue<Node> queue = new ArrayBlockingQueue<Node>(length);
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(curr == DUMMY) {
				++index;
				continue;
			}
			result[index] = curr.data_;
			queue.offer(curr.left_ == null ? DUMMY : curr.left_);
			queue.offer(curr.right_ == null ? DUMMY : curr.right_);
			++index;
		}
		
		return result;
	}
	
//	Use the array from 0th index and start constructing the children
//	Then do a DFS to first set the children for the leaf nodes
//	and then keep tracking back to the root.
	public static Node deserialize(int[] arr, int index) {
		
		if(arr == null) {
			return null;
		}
		
		if(index >= arr.length) {
			return null;
		}
		
		Node curr = null;
		if(arr[index] != 0) {
			curr = new Node(arr[index]);
			curr.left_ = deserialize(arr, 2*index+1);
			curr.right_ = deserialize(arr, 2*index+2);
		}
		
		return curr;
	}
	
	
	public static void main(String[] args) {

		Node root = new Node(1);
		
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		
		root.left_ = two;
		root.right_ = three;
		
		two.left_ = four;
		two.right_ = five;
		
		three.left_ = six;
		three.right_ = seven;
		
		four.left_ = eight;
		
		seven.right_ = nine;
		
		int[] treeArray = serializeTree(root, 15);
		
		for(int i = 0; i < treeArray.length; ++i) {
			System.out.println(treeArray[i]);
		}
		
		deserialize(treeArray, 0);
		
	}

}
