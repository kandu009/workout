package dp;

import practise.LongestCommonSubSequence;

/**
 * http://www.careercup.com/question?id=5931067269709824
 * 
 * Extension of {@link LongestCommonSubSequence} 
 * 
 * We could find the {@link LongestCommonSubSequence} among the 
 * same string and that would be the {@link LongestRepeatingSubSequence}
 * 
 * i != j check is the main difference, this is because, we know that 
 * a[i] == a[j] when i == j as they are same strings.
 * 
 * * if a[ i ] == b[ j ] && i != j then
 * 		 M[ i ][ j ] = max (1 + M[ i-1 ][ j-1], M[ i - 1 ][ j ], M[ i ][ j-1 ])
 * 	 otherwise 
 * 		M[ i ][ j ] = max (M[ i - 1 ][ j ], M[ i ][ j-1 ]). 
 * 
 * The value of longest repeating subsequence = M[ len(a) -1 ][ len(b) - 1]
 */

public class LongestRepeatingSubSequence {

	public static boolean findLongestRepeatingSequence(String a) {
		
		int[][] M = new int[a.length()][a.length()];
		// this is because, minimum length of repeating sequence should be 2
		M[0][0] = 0;
		
		for(int i = 1; i < a.length(); ++i) {
			
			if(a.charAt(i) == a.charAt(0)) {
				M[0][i] = 1;
			} else {
				M[0][i] = M[0][i-1];
			}
			
			if(a.charAt(0) == a.charAt(i)) {
				M[i][0] = 1;
			} else {
				M[i][0] = M[i-1][0];
			}
			
		}
		
		for(int i = 1; i < a.length(); ++i) {
			for(int j = 1; j < a.length(); ++j) {
				if(a.charAt(i) == a.charAt(j) && i !=j ) { // this i != j does the trick for us.
					M[i][j] = Math.max(Math.max(M[i-1][j-1]+1, M[i-1][j]), M[i][j-1]);
				} else {
					M[i][j] = Math.max(M[i][j-1], M[i-1][j]);
				}
			}
		}
		
		return M[a.length()-1][a.length()-1] > 1 ? true : false;
	}
	
	public static void main(String[] args) {
		String a = "abba";
		if(findLongestRepeatingSequence(a)) {
			System.out.println("Sequence Exists");
		} else {
			System.out.println("Sequence does not exist");
		}
	}

}
