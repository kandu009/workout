package trees;

import javafx.util.Pair;

/**
 * http://www.careercup.com/question?id=5680793844187136
 * 
 * have a inclusiveSum and exclusiveSum returned at every level. So, at every
 * node, there will be two values 1. Sum including root but excluding children.
 * 2. Sum including children but not root.
 * 
 * then we choose the maximum of these two values to find the maximumSum
 * possible.
 * 
 */
public class MaxPartySumWithoutManagers {

	public static class Node {
	
		int data_;
		Node left_;
		Node right_;
		
		public Node(int data) {
			data_ = data;
			left_ = null;
			right_ = null;
		}
		
	}
	
	// the first component of Pair is inclusiveSum and 
	// second component of Pair is exclusiveSum
	private static Pair<Integer, Integer> getMaxSumHelper(Node root) {
		
		if(root.left_ == null && root.right_ == null) {
			return new Pair<Integer, Integer>(root.data_, 0);
		}
		
		Pair<Integer, Integer> lp = null;
		if(root.left_ != null) {
			lp = getMaxSumHelper(root.left_);
		}
		
		Pair<Integer, Integer> rp = null;
		if(root.right_ != null) {
			rp = getMaxSumHelper(root.right_);
		}
		
		return new Pair<Integer, Integer>(
				lp.getValue()+rp.getValue()+root.data_, 	// root inclusiveSum + sum of children exclusiveSum
				lp.getKey()+rp.getKey());					// root exclusiveSum -> sum of children inclusiveSum
		
	}
	
	public static int getMaxSum(Node root) {
		Pair<Integer, Integer> p = getMaxSumHelper(root);
		return Math.max(p.getKey(), p.getValue());		// choose the maximum of inclusive/exclusive sum's
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
		
		System.out.println(getMaxSum(root));
		
	}

}
