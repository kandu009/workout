package misc;

public class LongestIncreasingSequenceNLogN {

	private static int getLongestIncreasingSequence(int[] A) {
		
		int[] table = new int[A.length];
		
		int last = 0;
		int lastButOne = last;
		table[0] = A[0];
		
		for (int i = 1; i < A.length; ++i) {
			
			if(A[i] > table[last]) {
				lastButOne = last;
				last++;
				table[last] = A[i];
				
			} else if(table[lastButOne] < A[i] && A[i] < table[last]) {
				table[last] = A[i];
			}
			
		}
		
		for(int i = 0; i <= last; ++i) {
			System.out.println(table[i]);
		}
		
		return last+1;
		
	}
	
	public static void main(String[] args) {
		int[] A = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		getLongestIncreasingSequence(A);
	}

}
