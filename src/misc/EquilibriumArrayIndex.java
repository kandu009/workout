package misc;

/*
 * http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 * 
 * index i such that leftSum == rightSum
 * 
 * 1. iterate once and find total sum
 * 2. at each index, 
 * 		leftSum = cumulative sum until i'th index
 * 		rightSum = sum - summ till a[i]
 * 3. if leftSum == rightSum return i
 * 
 */

public class EquilibriumArrayIndex {

	private static int getEquilibriumIndex(int[] A) {
		
		int sum = 0;
		for(int i = 0; i < A.length; ++i) {
			sum += A[i];
		}
		
		int leftSum = 0;
		for(int i = 0; i < A.length; ++i) {
			sum -= A[i];
			if(leftSum == sum) {
				return i;
			}
			leftSum += A[i];
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {-7, 1, 5, 2, -4, 3, 0};
		System.out.println(getEquilibriumIndex(A));
	}

}
