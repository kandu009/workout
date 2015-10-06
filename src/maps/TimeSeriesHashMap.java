package maps;

import java.util.HashMap;

/**
 * 
 * http://www.careercup.com/question?id=5689672300756992
 * 
 * Add a third dimension of time to a hashmap, so ur hashmap will look
 * something like this - 
 * 	HashMap<K, t, V> where t is a float value. 
 * 
 * Implement the get and put methods to this map. 
 * The get method should be something like
 * - map.get(K,t) 
 * 		which should give us the value. If t does not exists then map
 * 		should return the closest t' such that t' is smaller than t.
 * 		For example, if
 * 			map contains (K,1,V1) and (K,2,V2) and the user does a get(k,1.5) 
 * 			then the output should be v1 as 1 is the next smallest number to 1.5
 * 
 * @author Ravali
 *
 */
public class TimeSeriesHashMap {

	public static class Node {
		
		Float time_;
		Integer value_;
		Node left_;
		Node right_;
		
		public Node(Float time, Integer value) {
			time_ = time;
			value_ = value;
		}
		
	}
	
	public static class BinarySearchTree {
		
		Node root_;
		
		public BinarySearchTree() {
			root_ = null;
		}
		
		public void insert(Float time, Integer value) {
			
			if(root_ == null) {
				root_ = new Node(time, value);
				return;
			} else {
				
				Node curr = root_;
				
				while(true) {
					
					if(curr.time_ == time) {
						curr.value_ = value;
					}
					if(time < curr.time_) {
						if(curr.left_ == null) {
							curr.left_ = new Node(time, value);
							break;
						} else {
							curr = curr.left_;
						}
					}
					if(time > curr.time_) {
						if(curr.right_ == null) {
							curr.right_ = new Node(time, value);
							break;
						} else {
							curr = curr.right_;
						}
					}
					
				}
			}
		}
		
		public Node get(Float time) {
			
			Node curr = root_;
			
			while(true) {
				
				if(curr.time_ == time) {
					return curr;
				}
				if(time < curr.time_) {
					if(curr.left_ == null) {
						return curr;
					} else {
						curr = curr.left_;
					}
				}
				if(time > curr.time_) {
					if(curr.right_ == null) {
						return curr;
					} else {
						curr = curr.right_;
					}
				}
				
			}
		}
	}
	
	
	public static HashMap<Integer, BinarySearchTree> map_ =  new HashMap<Integer, BinarySearchTree>();
	
	public static Node get(Integer key, Float time) {
		return map_.get(key).get(time);
	}
	
	public static void insert(Integer key, Float time, Integer value) {
		if(!map_.containsKey(key)) {
			map_.put(key, new BinarySearchTree());
		}
		map_.get(key).insert(time, value);
	}
	
	public static void main(String[] args) {

		
		
	}

}
