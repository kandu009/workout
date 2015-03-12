package zillow;

/**
 * 
 * @author rkandur
 * 
 *         Class which is used to insert and delete from a Trinary Tree
 *
 */
public class TrinaryTree {
	
	/**
	 * Underlying Node Structire of the Trinary Tree Nodes
	 */
	class Node {

		public Node(int data) {
			setData(data);
			setLeft(null);
			setMiddle(null);
			setRight(null);
		}
		
		public int getData() {
			return m_data;
		}
		
		public void setData(int m_data) {
			this.m_data = m_data;
		}

		public Node getLeft() {
			return m_left;
		}

		public void setLeft(Node m_left) {
			this.m_left = m_left;
		}

		public Node getMiddle() {
			return m_middle;
		}

		public void setMiddle(Node m_middle) {
			this.m_middle = m_middle;
		}

		public Node getRight() {
			return m_right;
		}

		public void setRight(Node m_right) {
			this.m_right = m_right;
		}
		
		private int m_data;
		private Node m_left;
		private Node m_middle;
		private Node m_right;
		
	}

	public TrinaryTree() {
		setRoot(null);
	}
	
	public TrinaryTree(Node root) {
		setRoot(root);
	}
	
	/**
	 * Method to insert data into Trinary tree
	 */
	public void insert(int data) {
		
		if(m_root == null) {
			m_root = new Node(data);
			return;
		}
		
		Node current = m_root;
		Node previous = null;
		
		// goto the node where new node needs to be inserted
		while(current != null) {
			previous = current;
			if(data < current.getData()) {
				current = current.getLeft();
			} else if (data == current.getData()) {
				current = current.getMiddle();
			} else {
				current = current.getRight();
			}
		}
		
		// insert the new node in left/middle/right node depending on its value
		// when compared to current node
		if(data < previous.getData()) {
			previous.setLeft(new Node(data));
		} else if (data == previous.getData()) {
			previous.setMiddle(new Node(data));
		} else {
			previous.setRight(new Node(data));
		}

	}
	
	/**
	 * Method used to delete given data from the Trinary tree
	 * 
	 * @return true if success, false otherwise
	 */
	public boolean delete(int data) {
		
		if(m_root == null) {
			return false;
		}
		
		Node current = m_root;
		Node previous = null;
		
		// goto the node where the deletion should be done
		while(current != null) {
			if(data < current.getData()) {
				previous = current;
				current = current.getLeft();
			} else if (data > current.getData()) {
				previous = current;
				current = current.getRight();
			} else {
				break;
			}
		}
		
		// if the node to be deleted is not found, return false
		if(current == null) {
			return false;
		}
		
		// if there are multiple elements in the middle level, delete the one in
		// the lowest level
		while(current.getMiddle() != null) {
			previous = current;
			current = current.getMiddle();
		}
	
		// if the node to be deleted is a leaf node
		if(current.getLeft() == null && current.getRight() == null) {
			
			if(current == m_root) {
				m_root = null;
			} else if(previous.getLeft() == current) {
				previous.setLeft(null);
			} else if(previous.getMiddle() == current) {
				previous.setMiddle(null);
			} else {
				previous.setRight(null);
			}
			
		} else if(current.getLeft() == null) {
			// if the node to be deleted has only right child
			
			if(current == m_root) {
				m_root = m_root.getRight();
			} else if(previous.getLeft() == current) {
				previous.setLeft(current.getRight());
			} else {
				previous.setRight(current.getRight());
			}
			
		} else if(current.getRight() == null) {
			// if the node to be deleted has only left child
			
			if(current == m_root) {
				m_root = m_root.getLeft();
			} else if(previous.getLeft() == current) {
				previous.setLeft(current.getLeft());
			} else {
				previous.setRight(current.getLeft());
			}
			
		} else { // if the node to be deleted has both left and right child
			
			// find the lowest value node on the right sub tree and replace it
			// with the current node without altering the tree structure
            Node rightLowestChild = getRightLowestNode(current.getRight());

            // delete the old node
            boolean shouldDelete = deleteOldNode(current.getRight());
            if(shouldDelete) {
            	current.setRight(null);
            }
            
            if(current == m_root) {
            	current.setData(rightLowestChild.getData());
            } else {
            	if(previous.getLeft() == current) {
	            	previous.getLeft().setData(rightLowestChild.getData());
	            } else {
	            	previous.getRight().setData(rightLowestChild.getData());
	            }
            }
            
		}
		
		return true;
	
	}
	
	/**
	 * Gets the lowest value node in the given tree with starting with root = right
	 */
	private Node getRightLowestNode(Node right) {
		
		Node rightLowestChild = right;
		while (right.getLeft() != null) {
            right = right.getLeft();
            rightLowestChild = right;
        }
		return rightLowestChild;
		
	}
	
	private boolean deleteOldNode(Node right) {
		
		Node previous = null;
		while (right.getLeft() != null) {
        	previous = right;
            right = right.getLeft();
        }
        
        if(previous != null) {
        	previous.setLeft(null);
        	return false;
        }
        
        return true;
	}

	
	public void printTree() {
		printTreeHelper(m_root);
	}
	
	public void printTreeHelper(Node node) {

		if(node == null) {
			return;
		}
		System.out.println(node.getData());
		printTreeHelper(node.getLeft());
		printTreeHelper(node.getMiddle());
		printTreeHelper(node.getRight());
		
	}
	
	private Node m_root;
	
	public Node getRoot() {
		return m_root;
	}

	public void setRoot(Node m_root) {
		this.m_root = m_root;
	}

	public static void main(String[] args) {
		
		TrinaryTree tt = new TrinaryTree();
		tt.insert(5);		// insert when root = null
		tt.insert(4);
		tt.insert(9);
		tt.insert(5);		// insert a child with same value as root
		tt.insert(7);
		tt.insert(2);
		tt.insert(2);
//		tt.printTree();
		
		tt.insert(11);		// growing the tree further to cover all test scenarios
		tt.insert(10);
		tt.insert(13);
		tt.insert(12);
		tt.insert(14);
//		tt.printTree();
		
		tt.delete(11);		// delete when both left and right children are present which are more than 1 level 
		tt.delete(13);		// delete when only right child exists which are more than 1 level 
		tt.delete(14);		// delete a leaf node 
		tt.delete(12);		// delete a node which has only left child
		tt.delete(9);		// delete when both left and right children are present just 1 level below node
		tt.delete(10);
		tt.delete(7);
//		tt.printTree();
		
		tt.delete(20);		// delete a node which is not present
//		tt.printTree();
		
		tt.delete(4);		
		tt.delete(5);		// delete a middle element which is present in multiple levels
		tt.delete(5);		// delete the current root and replace with a new root
		tt.delete(2);
		tt.delete(2);
//		tt.printTree();
		
	}
	
}


