package dp;

/**
 * http://www.careercup.com/question?id=5931067269709824 
 * if a[ i ] == b[ j ] then 
 * 		M[ i ][ j ] = max (1 + M[ i-1 ][ j-1], M[ i - 1 ][ j ], M[ i ][ j-1 ])
 * otherwise 
 * 		M[ i ][ j ] = max (M[ i - 1 ][ j ], M[ i ][ j-1 ]). The value of
 * 
 * longest common subsequence = M[ len(a) -1 ][ len(b) - 1]
 */

public class LongestCommonSubSequence {

	public static int findLongestCommonSequence(String a, String b) {
		
		int[][] M = new int[a.length()][b.length()];
		
		for(int i = 0; i < a.length(); ++i) {
			if(a.charAt(i) == b.charAt(0)) {
				M[i][0] = 1;
			} else {
				if( i == 0 ) {
					M[i][0] = 0;
				} else {
					M[i][0] = M[i-1][0];
				}
			}
		}
		
		for(int i = 0; i < b.length(); ++i) {
			if(b.charAt(i) == a.charAt(0)) {
				M[0][i] = 1;
			} else {
				if( i == 0 ) {
					M[0][i] = 0;
				} else {
					M[0][i] = M[0][i-1];
				}
			}
		}
		
		for(int i = 1; i < a.length(); ++i) {
			for(int j = 1; j < b.length(); ++j) {
				if(a.charAt(i) == b.charAt(j)) {
					M[i][j] = Math.max(Math.max(1+M[i-1][j-1], M[i-1][j]), M[i][j-1]);
				} else {
					M[i][j] = Math.max(M[i-1][j], M[i][j-1]);
				}
			}
		}
		return M[a.length()-1][b.length()-1];
	}
	
	public static void main(String[] args) {
		String a = "abcdabed";
		String b = "lkzasdlkjbwedx";
		System.out.println(findLongestCommonSequence(a, b));
	}

}
