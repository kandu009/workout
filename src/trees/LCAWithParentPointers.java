package trees;

import java.util.HashSet;

/**
 * http://leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-ii.html
 * 
 * As we move upwards from two nodes, we keep adding to a hashset When we come
 * across a node that is already in the set, it will be LCA.
 * 
 * This is like, finding intersection of two linked list. After intersection,
 * both paths should merge
 * 
 */
public class LCAWithParentPointers {

	public static class Node {
		int data_;
		Node parent_;

		Node(int data) {
			data_ = data;
			parent_ = null;
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
		
		if(null == root || null == p || null == q) {
			return new Node(-1);
		}
		
		HashSet<Node> visited = new HashSet<Node>();
		
		while(p != null || q != null) {
			
			if(p != null) {
				if(visited.contains(p)) {
					return p;		// this means, we have already encountered p in some other path via q. This means its an ancestor
				}
				visited.add(p);
				p = p.parent_;
			}
			if(q != null) {
				if(visited.contains(q)) {
					return q;		// this means, we have already encountered p in some other path via q. This means its an ancestor
				}
				visited.add(q);
				q = q.parent_;
			}
			
		}
		
		return null; 	// if there is no common ancestor, which should happen only
						// when there is something wrong
						// i.e., one of p q is not in the tree. otherwise, they
						// should in the worst case, converge @root
	}
	
	public static void main(String[] args) {

		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		two.parent_ = root;
		three.parent_ = root;

		four.parent_ = two;
		five.parent_ = two;
		
		six.parent_ = three;
		seven.parent_ = three;
		
		Node n = findLCA(root, seven, new Node(-1));
		System.out.println(n != null ? n.data_ : "null");
		
	}

}
