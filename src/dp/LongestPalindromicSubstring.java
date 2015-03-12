package dp;

/**
 *  http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 *  
 *   All 1 length strings are palindromes
 *   Check for 2 lengths too. These serve as base case
 *   
 *   Now check for all lengths >= 3
 *   if(A[j] == A[k] && table[j+1][k-1] == 1) {
		table[j][k] = 1;
	 }else {
	 	table[j][k] = 0;
	 }
 *
 */

public class LongestPalindromicSubstring {

	public static String getLongestPalindromeSubsequence(char[] A) {
		
		int table[][] = new int[A.length][A.length];
		
		int startIndex = 0;
		int endIndex = 0;
		
		// all strings of length 1 is a palindrome
		for(int i = 0; i < A.length; ++i) {
			table[i][i] = 1;
		}
		
		// check for strings of length = 2
		for(int i = 0; i < table[0].length-1; ++i) {
			if(A[i] == A[i+1]) {
				table[i][i+1] = 1;
				startIndex = i;
				endIndex = i+1;
			}
		}
		
		//check for length >=3
		for(int i = 3; i < A.length; ++i) {
			for(int j = 0; j < A.length-i+1; ++j) {
				int k = j+i-1;
				if(A[j] == A[k] && table[j+1][k-1] == 1) {
					table[j][k] = 1;
					if(k-j > endIndex-startIndex) {
						startIndex = j;
						endIndex = k;
					}
				} else {
					table[j][k] = 0;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = startIndex; i <= endIndex; ++i) {
			sb.append(A[i]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		char A[] = new char[] {'a', 'b', 'c', 'c', 'b', 'd', 'd', 'b', 'c'};
		System.out.println(getLongestPalindromeSubsequence(A));
	}

}
