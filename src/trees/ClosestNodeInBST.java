package trees;

/**
 * http://algorithmsgeek.blogspot.com/2013/06/algo7-closest-value-search-in-binary.html
 * 
 * 1. Find difference of the key with root. 2. If key is smaller than root, find
 * closest value on left side 3. If key is larger than root, find closest value
 * on right side 4. Find the closest of all the above three and return.
 * 
 * @author rkandur
 *
 */
public class ClosestNodeInBST {

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
	
	private static Node findClosestNode(Node root, int key) {
		
		if(root == null) {
			return root;
		}
		if(root.data_ == key) {
			return root;
		}
		
		Node nearestNode = root;
		if(root.left_ != null && key < root.data_) {
			Node leftNode = findClosestNode(root.left_, key);
			nearestNode = (Math.abs(nearestNode.data_-key) < Math.abs(leftNode.data_-key)) ? nearestNode : leftNode;
		}
		if(root.right_ != null && key > root.data_) {
			Node rightNode = findClosestNode(root.right_, key);
			nearestNode = (Math.abs(nearestNode.data_-key) < Math.abs(rightNode.data_-key)) ? nearestNode : rightNode;
		}

		return nearestNode;
	}
	
	public static void main(String[] args) {

		Node root = new Node(53);
		Node two = new Node(23);
		Node three = new Node(69);
		Node four = new Node(1);
		Node five = new Node(28);
		Node six = new Node(60);
		Node seven = new Node(73);

		root.left_ = two;
		root.right_ = three;

		two.left_ = four;
		two.right_ = five;

		three.left_ = six;
		three.right_ = seven;
		
		Node n = findClosestNode(root, 64);
		System.out.println(n== null ? " None !!!" : n.data_);
		
	}

}
