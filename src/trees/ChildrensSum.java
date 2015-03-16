package trees;

/**
 * http://www.careercup.com/question?id=5630160432791552
 * 
 * Given a tree, replace a node’s value with the sum of all its children values,
 * considering only those children whose value is less than than the root node’s
 * value
 * 
 * This can be done in O(n) time ***************
 * 
 * @author rkandur
 *
 */
public class ChildrensSum {

	public static class Node {
		int data_;
		Node left_;
		Node right_;

		Node(int data) {
			data_ = data;
			left_ = null;
			right_ = null;
		}
	}

	private static void printTree(Node root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data_);
		printTree(root.left_);
		printTree(root.right_);
	}

	/**
	 * In every step, after you modify the current nodes value, return the old
	 * node value that will be used in the higher level to compare the original
	 * children value with the current root.
	 * 
	 * This way, we will use the previous values for comparison and update each
	 * node with cumulative sum in one iteration
	 */
	private static int findChildSumTree(Node root) {
		
		if(root.left_ == null && root.right_ == null) {
			return root.data_;
		}
		
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		if(root.left_ != null) {
			left = findChildSumTree(root.left_);
		}
		if(root.right_ != null) {
			right = findChildSumTree(root.right_);
		}
		
		int sum = Integer.MIN_VALUE;
		if(left < root.data_) {
			sum = (sum == Integer.MIN_VALUE) ? root.left_.data_ : sum+root.left_.data_;
		}
		if(right < root.data_) {
			sum = (sum == Integer.MIN_VALUE) ? root.right_.data_ : sum+root.right_.data_;
		}

		int ret = root.data_;
		root.data_ = sum == Integer.MIN_VALUE ? root.data_ : sum;
		
		return ret;
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(7);
		Node two = new Node(6);
		Node three = new Node(5);
		Node four = new Node(4);
		Node five = new Node(3);
		Node six = new Node(2);
		Node seven = new Node(1);

		root.left_ = two;
		root.right_ = three;

		two.left_ = four;
		two.right_ = five;

		three.left_ = six;
		three.right_ = seven;
		
		printTree(root);
		findChildSumTree(root);
		printTree(root);
		
	}
}
