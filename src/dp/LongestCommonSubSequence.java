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

	public static int[][] M;
	
	public static int findLongestCommonSequence(String a, String b) {
		
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
	
	/**
	 * The value M[i][j] contains length of LCS. Create a character array
	 * result[] of length equal to the length of LCS.
	 * 
	 * Traverse the 2D array starting from M[m][n]. 
	 * If characters (in s1 and s2) corresponding to M[i][j] are same, then 
	 * 	include this character in result.
	 * Else 
	 * 	compare values of M[i-1][j] and M[i][j-1] and 
	 * 	go in direction of greater value.
	 */
	public static void printLCS(String s1, String s2, int lengthOfLCS) {
		
		char[] result = new char[lengthOfLCS];
		int index = result.length-1;
		
		int i = M.length-1;
		int j = M[0].length-1;
		
		while(i >= 0 && j >= 0 && index >= 0) {
			if(s1.charAt(i) == s2.charAt(j)) {
				result[index] = s1.charAt(i);
				--i;
				--j;
				--index;
			} else if(M[i-1][j] > M[i][j-1]) {
				--i;
			} else {
				--j;
			}
		}

		StringBuilder sRes = new StringBuilder();
		for(int k = 0; k < result.length; ++k) {
			sRes.append(result[k]);
		}
		System.out.println(sRes.toString());
		
	}
	
	public static void main(String[] args) {
		String a = "abcdabed";
		String b = "lkzasdlkjbwedx";
		M = new int[a.length()][b.length()];
		int lengthofLCS = findLongestCommonSequence(a, b);
		System.out.println(lengthofLCS);
		printLCS(a, b, lengthofLCS);
	}

}
