package memoization;

/**
 * 
 * http://www.geeksforgeeks.org/count-total-number-of-n-digit-numbers-such-that-the-difference-between-the-sum-of-even-digits-and-odd-digits-is-1/
 * 
 * Count total number of N digit numbers such that the difference between sum of
 * even and odd digits is 1 Given a number n, we need to count total number of n
 * digit numbers such that the sum of even digits is 1 more than the sum of odd
 * digits. Here even and odd means positions of digits are like array indexes,
 * for example, the leftmost (or leading) digit is considered as even digit, next
 * to leftmost is considered as odd and so on.
 * 
 * @author Ravali
 *
 */

public class NDigitNumbersWithEvenOddSumDiffEqualsOne {

//	public static int[][][][] table = new int[100][5000][5000][2];
	public static int[][][][] table = new int[10][50][50][2];
	
	public static int getCountUtil(int n, int evenSum, int oddSum, int isOddDigit) {
		
		if(n == 0) {
			if(evenSum - oddSum == 1) {
				System.out.println(evenSum +" "+oddSum);
				return 1;
			}
			return 0;
		}
		
		if(table[n][evenSum][oddSum][isOddDigit] != -1) {
			return table[n][evenSum][oddSum][isOddDigit];
		}
		
		int count = 0;
		if(isOddDigit == 0) {
			for(int i = 0; i <=9; ++i) {
				count += getCountUtil(n-1, evenSum, oddSum+i, 1);
			}
		} else {
			for(int i = 0; i <=9; ++i) {
				count += getCountUtil(n-1, evenSum+i, oddSum, 0);
			}
		}
		
		table[n][evenSum][oddSum][isOddDigit] = count;
		
		return count;
		
	}
	
	public static int getCount(int n) {
		
		int count = 0;
		for(int i = 1; i <=9; ++i) {
			count += getCountUtil(n-1, i, 0, 0);
		}
		return count;
		
	}
	
	public static void main(String[] args) {

		int n = 3;
		for(int i = 0; i < 10; ++i) {
			for(int j = 0; j < 50; ++j) {
				for(int k = 0; k < 50; ++k) {
					for(int l = 0; l < 2; ++l) {
						table[i][j][k][l] = -1;
					}
				}
			}
		}
		
		System.out.println(getCount(n));
		
	}

}
