package trees;

/**
 * http://leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-i.html
 * 
 * If root == p or q, return root
 * 
 * At every node, we check if p and q are found on either side of root respectively
 * If yes, return root
 * 
 * If not, they lie on same side, so proceed further
 * 
 */

public class LCAWithoutParentNodes {

	public static class Node {
		int data_;
		Node left_;
		Node right_;

		Node(int data) {
			data_ = data;
			left_ = null;
			right_ = null;
		}

		public boolean equals(Object obj) {
			if (obj instanceof Node) {
				if (((Node) obj).data_ == this.data_) {
					return true;
				}
			}
			return false;
		}
	}
	
	private static Node findLCA(Node root, Node p, Node q) {
		
		if(root == null) {
			return root;
		}
		
		if(root == p || root == q) {
			return root;
		}
		
		Node left = findLCA(root.left_, p, q);
		Node right = findLCA(root.right_, p, q);
		
		if(left != null && right != null) {
			return root;
		}
		
		return left != null ? left : right;
		
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
		
		Node n = findLCA(root, seven, six);
		System.out.println(n != null ? n.data_ : "null");
		
	}

}
