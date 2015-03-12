package practise;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/** http://stackoverflow.com/questions/8964279/coding-a-basic-pretty-printer-for-trees-in-java **/

class TreeNode {

	int m_data;
	TreeNode m_left;
	TreeNode m_right;
	
	public TreeNode(int data) {
		m_data = data;
		m_left = m_right = null;
	}
	
}

// For a given level. 'level', formula for 
// indent: 2^(max level - level) - 1 
// spacing: 2^(max level - level + 1) - 1
public class PrintTreeWithIndentation {
	
	public static int max_level = 3;
	public static Queue<TreeNode> q1 = new ArrayBlockingQueue<TreeNode>(100);
	public static Queue<TreeNode> q2 = new ArrayBlockingQueue<TreeNode>(100);
	public static TreeNode DUMMY = new TreeNode(-1);
	
	public static void printLevelOrder(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		q1.add(root);
		q1.add(DUMMY);
		
		q2.add(root);
		q2.add(DUMMY);
		boolean multipleOccurence = false;
		
		while(!q1.isEmpty()) {
			
			TreeNode node = q1.poll();

			if(node == DUMMY) {
				if(multipleOccurence) {
					break;
				}
				multipleOccurence = true;
				q1.add(DUMMY);
				q2.add(DUMMY);
				continue;
			}
			if(node.m_left != null) {
				multipleOccurence = false;
				q1.add(node.m_left);
				q2.add(node.m_left);
			}
			if(node.m_right != null) {
				multipleOccurence = false;
				q1.add(node.m_right);
				q2.add(node.m_right);
			}
		}
		
	}
 	
	private static void printLevelOrder1(Queue<TreeNode> q22) {

		int level = 1;
		double spacing = 0;
		double indent = Math.pow(2, (max_level-level))-1;
		StringBuilder sb = new StringBuilder();
		while(indent > 0) {
			sb.append(" ");
			--indent;
		}
		
		while(!q22.isEmpty()) {
			TreeNode node = q22.poll();
			if(node == DUMMY) {
				System.out.println(sb.toString());
				sb = new StringBuilder();
				++level;
				indent = Math.pow(2, (max_level-level))-1;
				while(indent > 0) {
					sb.append(" ");
					--indent;
				}
				continue;
			}
			
			sb.append(node.m_data);
			spacing = Math.pow(2, (max_level-level+1))-1;
			while(spacing > 0) {
				sb.append(" ");
				--spacing;
			}
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		root.m_left = n1;
		root.m_right = n2;
		
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		n1.m_left = n3;
		n1.m_right = n4;
		
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(7);
		n2.m_left = n5;
		n2.m_right = n6;
		
		printLevelOrder(root);
		printLevelOrder1(q2);
		
	}

}
