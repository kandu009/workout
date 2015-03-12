package dp;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * 
 * @author rkandur
 *
 */

public class LongestIncreasingSequenceArray {

	public static int longestIncSequence(int[] A) {
		
		int[] table = new int[A.length];
		int ret = 1;
		
		for(int i = 0; i < table.length; ++i) {
			table[i] = 1;
		}
		
		for(int i = 1; i < A.length; ++i) {
			for(int j = 0; j < i; ++j) {
				if(A[i] > A[j]) {
					table[i] = Math.max(table[i], table[j]+1);
					ret = (ret > table[i]) ? ret : table[i];
				}
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {1, -2, 4, 10, 7, 19, -3};
		System.out.println(longestIncSequence(A));
	}

}
