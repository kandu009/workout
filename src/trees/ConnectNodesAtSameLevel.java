package trees;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 
 * http://www.geeksforgeeks.org/connect-nodes-at-same-level/
 * 
 * Write a function to connect all the adjacent nodes at the same level in a
 * binary tree. Structure of the given Binary
 *
 * Solution: 
 * Extending the regular LevelOrderTraversal using queue. When a node
 * is pushed, we also push the level of the node. Each time when we pop an
 * element, we will keep updating the nextRight of the nodes as long as the
 * level is the same.
 * 
 * @author Ravali
 *
 */
public class ConnectNodesAtSameLevel {

	public static class Node {
		int data_;
		Node left_;
		Node right_;
		Node nextRight_;
		
		Node(int data) {
			data_ = data;
		}
	}

	public static class QueueNode {
		Node node_;
		int level_;
		public QueueNode(Node node, int level) {
			node_ = node;
			level_ = level;
		}
	}
	
	public static void connectNodes(Node root) {
		
		ArrayBlockingQueue<QueueNode> queue = new ArrayBlockingQueue<QueueNode>(20);
		
		queue.offer(new QueueNode(root, 0));
		
		Node levelCurrentRight = null;
		int currentLevel = 0;
		int newNodeLevel = 1;
		
		while(!queue.isEmpty()) {
			
			QueueNode qc = queue.poll();
			if(currentLevel != qc.level_) {
				++newNodeLevel;
				currentLevel = qc.level_;
				levelCurrentRight = null;
			}
			
			if(levelCurrentRight == null) {
				levelCurrentRight = qc.node_;
			} else {
				levelCurrentRight.nextRight_ = qc.node_;
				levelCurrentRight = qc.node_;
			}
			
			if(qc.node_.left_ != null) {
				queue.offer(new QueueNode(qc.node_.left_, newNodeLevel));
			}
			if(qc.node_.right_ != null) {
				queue.offer(new QueueNode(qc.node_.right_, newNodeLevel));
			}
			
		}
		
	}
	
	public static void printRightNodes(Node root) {
		
		// Need to change this.
		Node temp = root;
		StringBuilder sb = new StringBuilder();
		do {
			sb.append(temp.data_).append(" ");
			temp = temp.nextRight_;
		} while(temp != null);
		System.out.println(sb.toString());
		
		if(root.left_ != null) {
			printRightNodes(root.left_);
		}
		
	}
	
	public static void main(String[] args) {

		Node root1 = new Node(6);
		Node three1 = new Node(3);
		Node one1 = new Node(1);
		Node five1 = new Node(5);
		Node eight1 = new Node(8);
		Node seven1 = new Node(7);
		Node nine1 = new Node(9);
		Node eleven1 = new Node(11);
		Node thirteen1 = new Node(13);
		
		root1.left_ = three1;
		three1.left_ = one1;
//		three1.right_ = five1;
		
		root1.right_ = eight1;
		eight1.left_ = seven1;
		eight1.right_ = eleven1;
		
		eleven1.left_ = nine1;
		eleven1.right_ = thirteen1;
		
		connectNodes(root1);
		
		printRightNodes(root1);
		
	}

}
