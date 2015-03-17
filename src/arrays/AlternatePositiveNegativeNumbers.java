package arrays;

/**
 * http://www.careercup.com/question?id=5741006670528512
 * 
 * we keep an index (for next element to be updated in Array) and flag
 * (fillPositive) 
 * 
 * if(fillPositive) then 
 * 	we will fill the element at index with nextPositive number 
 * else
 *  we will fill the element at index with nextNegative number
 * 
 * @author rkandur
 *
 */
public class AlternatePositiveNegativeNumbers {

	private static void modifyArray(int[] A) {

		if(A == null || A.length == 1) {
			return;
		}
		
		boolean fillPositive = (A[0] < 0);
		
		int fp = findNextPositiveIndex(A, 0); 
		int fn = findNextNegativeIndex(A, 0);
		
		if(fillPositive) {
			fn = findNextNegativeIndex(A, 1);
		} else {
			fp = findNextPositiveIndex(A, 1);
		}
		
		int index = 1;
		for(;index < A.length && fp > 0 && fn > 0 && fp < A.length && fn < A.length;) {
			
			if(fillPositive) {
				rotate(A, index, fp);
				fp = findNextPositiveIndex(A, index+1);
				fn = findNextNegativeIndex(A, index+1);
			} else {
				rotate(A, index, fn);
				fn = findNextNegativeIndex(A, index+1);
				fp = findNextPositiveIndex(A, index+1);
			}
			++index;
			fillPositive = !fillPositive;

		}
		
	}
	
	private static int findNextNegativeIndex(int[] A, int start) {
		for(int i = start; i < A.length; ++i) {
			if(A[i] < 0) {
				return i;
			}
		}
		return -1;
	}
	
	private static int findNextPositiveIndex(int[] A, int start) {
		for(int i = start; i < A.length; ++i) {
			if(A[i] > 0) {
				return i;
			}
		}
		return -1;
	}
	
	private static void rotate(int[] A, int start, int end) {
		if(start >= end) {
			return;
		}
		int temp = A[end];
		for(int i = end; i > start; --i) {
			A[i] = A[i-1];
		}
		A[start] = temp;
	}

	public static void main(String[] args) {

		int[] A = new int[] {-6, -5, -4, -3, 2, 1, 1, 2 };
		
		modifyArray(A);
		
		for(int i = 0; i < A.length; ++i) {
			System.out.println(A[i]);
		}
		
	}

}
