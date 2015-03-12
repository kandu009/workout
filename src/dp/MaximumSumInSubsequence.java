package dp;

public class MaximumSumInSubsequence {

	// With DP
	private static void getMaximumSumInSubsequenceWithDP(int[] A) {
		
		int[][] table = new int[A.length][A.length];
		for(int i = 0; i < table.length; ++i) {
			table[i][i] = A[i];
		}
		
		for(int i = 0; i < table.length-1; ++i) {
			table[i][i+1] = A[i]+A[i+1];
		}
		
		for(int len = 3; len <= A.length; ++len) {
			for(int i = 0; i < A.length-len; ++i) {
				int j = i+len-1;
				table[i][j] = table[i][j-1]+A[j];
			}
		}
		
		int gI = 0, gJ = 0;
		int gSum = table[0][0];
		for(int i = 0; i < table.length; ++i) {
			for(int j = 0; j < table.length; ++j) {
				if(gSum < table[i][j]) {
					gSum = table[i][j];
					gI = i;
					gJ = j;
				}
			}
		}
		
		for(int i = gI; i <= gJ; ++i) {
			System.out.println(A[i]);
		}
		
	}
	
	// regular way without dp
	public static int getMaximumSumInSubsequence(int[] A) {
		
		int globalSum = A[0];
		int localSum = A[0];
		
		for(int i = 1; i < A.length; ++i) {
			localSum += A[i];
			if(localSum > globalSum) {
				globalSum = localSum;
			} else if(localSum < 0) {
				localSum = 0;
			}
		}
		
		return globalSum;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		//System.out.println(getMaximumSumInSubsequence(A));
		getMaximumSumInSubsequenceWithDP(A);
	}

}
