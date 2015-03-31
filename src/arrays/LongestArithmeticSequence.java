package arrays;

/**
 * http://www.careercup.com/question?id=16436689
 * 
 * @author rkandur
 *
 */
public class LongestArithmeticSequence {

	public static int findMaxLength(int[] A) {
		
		int maxLength = Integer.MIN_VALUE;
		
		if(A.length == 1) {
			return 0;
		} 
		if(A.length == 2) {
			return 2;
		}
		
		int difference = A[1] - A[0];
		int currLength = 2;
		
		for(int i = 1; i < A.length-1; ++i) {
			System.out.println( A[i+1]);
			System.out.println( A[i]);
			int currDiff = A[i+1]-A[i];
			if(currDiff == difference) {
				currLength++;
			} else {
				difference = currDiff;
				currLength = 2;
			}
			
			if(currLength > maxLength) {
				maxLength = currLength;
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {

		int[] A = new int[] { -1, 1, 3, 7, 11, 15, 19, 20, 21, 22 };
		System.out.println(findMaxLength(A));
	}

}
