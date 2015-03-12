package dp;

/**
 *	http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 *  
 *   A[n] = Array of numbers (input)
 *   Table[Sum][n] => i = Sum, n = subArray till nth index which has subArray with sum = Sum
 *		Table[i][j] = Table[i][j-1]
 *		if(i >= A[j]) {
 *			Table[i][j] = Table[i-A[j]][j-1];
 *		} else {
 *			Table[i][j] = Table[i][j-1];
 *		} 	 
 */
public class SubArrayWithGivenSum {

	public static Boolean subArrayWithSumExists(int[] A, int sum) {
	
		boolean[][] Table = new boolean [sum+1][A.length+1];
		
		for(int i = 0; i <= A.length; ++i) {
			Table[0][i] = true;
		}
		for(int i = 1; i <= sum; ++i) {
			Table[i][0] = false;
		}
		
		for(int i = 1; i <= sum; ++i) {
			for(int j  = 1; j <= A.length; ++j) {
				Table[i][j] = Table[i][j-1];		// if sum exists in subArray j-1, it means it exists for subArray j too.
				if(i >= A[j-1]) {
					Table[i][j] = Table[i][j] || Table[i-A[j-1]][j-1];
				} else {
					Table[i][j] = Table[i][j] || Table[i][j-1];
				}
			}
		}
		
		return Table[sum][A.length];
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {3, 34, 4, 12, 5, 2};
		int sum = 9;
		if(subArrayWithSumExists(A, sum)) {
			System.out.println("Exists");
		} else {
			System.out.println("Doesnt exist");
		}
	}

}
