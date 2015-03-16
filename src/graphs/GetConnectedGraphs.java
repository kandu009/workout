package graphs;

import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * http://www.careercup.com/question?id=6558888935555072
 * 
 * Input is a series like shown below, we need to group them into parts such
 * that all elements within groups are connected and different groups form
 * disconnected graphs.
 * 
 * Input: (1,2) (2,3) (5,6) (2,9)
 * 
 * Output: [1,2,,3,9] [5,6]
 * 
 * @author rkandur
 *
 */
public class GetConnectedGraphs {

	public static class Node {
		int data_;
		HashSet<Node> adj_;
		public Node(int data) {
			data_ = data;
			adj_ = new HashSet<Node>();
		}
	}
	
	//TODO: can be improved in terms of space complexity
	private static HashSet<HashSet<Node>> findPartitionsOfGraph(HashSet<Node> input) {
		HashSet<HashSet<Node>> res = new HashSet<HashSet<Node>>();
		for(Node n : input) {
			HashSet<Node> s = new HashSet<Node>(); 
			ArrayBlockingQueue<Node> queue = new ArrayBlockingQueue<Node>(10);
			queue.offer(n);
			while(!queue.isEmpty()) {
				for(Node a : queue.peek().adj_) {
					queue.offer(a);
				}
				s.add(queue.poll());
			}
			mergeCommonSets(res,s); 
		}
		return res;
	}
	
	private static void mergeCommonSets(HashSet<HashSet<Node>> res, HashSet<Node> s) {
		boolean hasCommon = false;
		for(HashSet<Node> r : res) {
			HashSet<Node> t1 = new HashSet<Node>(r);
			HashSet<Node> t2 = new HashSet<Node>(s);
			t1.retainAll(t2);
			if(!t1.isEmpty()) {
				hasCommon = true;
				r.addAll(s);
			}
		}
		if(!hasCommon) {
			res.add(s);
		}
	}

	public static void main(String[] args) {
	
		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node five = new Node(5);
		Node six = new Node(6);
		Node nine = new Node(9);
		
		root.adj_.add(two);
		two.adj_.add(three);
		two.adj_.add(nine);
		five.adj_.add(six);
		
		HashSet<Node> input = new HashSet<Node>();
		input.add(root);
		input.add(two);
		input.add(three);
		input.add(five);
		input.add(six);
		input.add(nine);
		
		HashSet<HashSet<Node>> reslt = findPartitionsOfGraph(input);
		for(HashSet<Node> l : reslt) {
			StringBuilder sb = new StringBuilder();
			for(Node ns : l) {
				sb.append(ns.data_).append(" ");
			}
			System.out.println(sb.toString());
		}
	}

}
