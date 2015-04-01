package trees;

class Node {
	Node m_left;
	Node m_right;
	int m_data;
	
	public Node(int data) {
		m_data = data;
		m_left = m_right = null;
	}
	
	public void setLeft(Node left) {
		m_left = left;
	}
	
	public void setRight(Node right) {
		m_right = right;
	}
	
	public Node getLeft() {
		return m_left;
	}
	
	public Node getRight() {
		return m_right;
	}
	
}

/**
 *	assuming that both nodes are present in the tree
 */
public class LeastCommonAncestor {

	public static Node getCommonAncestor(Node root, Node n1, Node n2) {
		
		if(root == null) {
			return null;
		} 
		if(root.m_data == n1.m_data) {
			return n1;
		} 
		if(root.m_data == n2.m_data) {
			return n2;
		}
		
		Node left = getCommonAncestor(root.m_left, n1, n2);
		Node right = getCommonAncestor(root.m_right, n1, n2);
		
		if(left != null && right != null) {
			return root;
		}
		
		return (left != null) ? left : (right != null) ? right : null;
		
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(10);
		
		Node nn1 = new Node(8);
		root.setLeft(nn1);
		Node nn2 = new Node(13);
		root.setRight(nn2);
		
		/*Node nn3 = new Node(7);
		Node nn4 = new Node(9);
		nn1.setLeft(nn3);
		nn1.setRight(nn4);
		
		Node nn5 = new Node(11);
		Node nn6 = new Node(14);
		nn2.setLeft(nn5);
		nn2.setRight(nn6);*/
		
		/*Node nn7 = new Node(16);
		nn6.setRight(nn7);
		
		Node nn8 = new Node(18);
		nn7.setRight(nn8);*/
		
		Node n1 = new Node(17);
		Node n2 = new Node(8);
		
		System.out.println(getCommonAncestor(root, n1, n2).m_data);
	}

}
 