package trees;

/**
 * http://www.careercup.com/question?id=6293602384740352
 * 
 * An array which is a Post order traversal of a Binary Tree. Write a function
 * to check if the Binary Tree formed from the array is a Binary Search Tree.
 * 
 * 
 * Eg: 2 1 3
 * 
 * The array given as input would be 1 3 2. Write a function to say if the tree
 * formed is a Binary Search Tree.
 * 
 * Example 2: 4 is root. 0 is left child of 1 , 1 is left child of 2 and 2 is
 * left child of 4. 5 is right child of 4 and 6 is right child of 5. 4 2 5 1 6 0
 * 
 * 0 1 2 6 5 4 is the input array.
 * 
 * @author Ravali
 *
 */
public class IsPostOrderRepresentationBST {

	public static class Node {
		Node left_;
		Node right_;
		int data_;

		public Node(int data) {
			data_ = data;
		}
	}

	public static boolean isBST(int[] arr, int start, int end) {

		if (end - start < 2) {
			return true;
		}

		int pivot = end - 1;
		for (int i = start; i < end - 1; ++i) {
			if (arr[i] > arr[i + 1]) {
				pivot = i;
				break;
			}
		}

		for (int j = pivot; j < end; ++j) {
			if (arr[j] < arr[end - 1]) {
				return false;
			}
		}

		return isBST(arr, start, pivot - 1) && isBST(arr, pivot, end - 1);

	}

	public static void main(String[] args) {

		Node zero = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);

		four.left_ = two;
		two.left_ = one;
		one.left_ = zero;
		four.right_ = five;
		five.right_ = six;

		int[] arr = new int[] { 0, 1, 2, 6, 5, 4 };

		if (isBST(arr, 0, arr.length - 1)) {
			System.out.println("Yes !!!");
		} else {
			System.out.println("No !!!");
		}

	}

}
