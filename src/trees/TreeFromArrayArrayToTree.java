package trees;

/**
 * http://www.careercup.com/question?id=6486564775395328
 * 
 * Important thing is that the
 * 
 * startChildIndex = index*k - (k-2); 
 * where 
 * index = index of the node in the
 * tree k = k'Ary tree
 * 
 * @author rkandur
 *
 */
public class TreeFromArrayArrayToTree {

	private static class Node {
		
		int data_;
		Node[] children_;
		
		public Node(int data) {
			data_ = data;
			children_ = null;
		}
	
	}
	
	private static Node createKAryTreeFromArray(Node[] A, int index, int k) {
		
		if(index > A.length) {
			return null;
		}
		if(A[index-1] == null) {
			return null;
		}
		
		Node n = A[index-1];
		int startChildIndex = index*k - (k-2);
		n.children_ = new Node[k];
		for(int i = 0; i < k; ++i) {
			n.children_[i] = createKAryTreeFromArray(A, startChildIndex+i, k);
		}
		
		return n;
	}
	
	private static void createArrayFromNAryTree(Node root, int k, int[] result, int index) {
		
		if(root == null) {
			return;
		}
		
		if(root.children_[0] != null) {
			for(int j = 0; j < k; ++j) {
				result[index] = root.children_[j].data_;
				index++;
			}
			for(int j = 0; j < k; ++j) {
				createArrayFromNAryTree(root.children_[j], k, result, index);
			}
		}
		
	}
	
	public static void main(String[] args) {

		Node root = new Node(1);
		
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		
		Node ten = new Node(10);
		Node eleven = new Node(11);
		Node twelve = new Node(12);
		Node thirteen = new Node(13);
		
		Node fourteen = new Node(14);
		Node fifteen = new Node(15);
		Node sixteen = new Node(16);
		Node seventeen = new Node(17);
		
		Node eighteen = new Node(18);
		Node ninteen = new Node(19);
		Node twenty = new Node(20);
		Node twentyone = new Node(21);

		Node[] nodes = new Node[] { root, two, three, four, five, six, seven,
				eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen,
				sixteen, seventeen, eighteen, ninteen, twenty, twentyone };
		
		int k = 4;
		Node tree = createKAryTreeFromArray(nodes, 1, k);
		
		int[] result = new int[21];
		result[0] = root.data_;
		createArrayFromNAryTree(tree, k, result, 1);
		
		for(int i = 0; i < result.length; ++i) {
			System.out.println(result[i]);
		}
	}

}
