package memoization;

/**
 * 
 * http://www.geeksforgeeks.org/count-of-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum/
 * 
 * Given two integers ‘n’ and ‘sum’, find count of all n digit numbers with sum
 * of digits as ‘sum’. Leading 0’s are not counted as digits. 1 <= n <= 100 and
 * 1 <= sum <= 50000
 * 
 * @author Ravali
 *
 */

public class NDigitNumbersWithGivenSum {

	public static int[][] table;
	
	public static int getCountUtil(int n, int sum) {
		
		if(n == 0) {
			return (sum == 0) ? 1 : 0;
		}
		
		if(table[n][sum] != -1) {
			return table[n][sum];
		}
		
		int count = 0;
		for(int i = 0; i <= 9; ++i) {
			count += getCountUtil(n-1, sum-i);
		}
		table[n][sum] = count;
		
		return count;
		
	}
	
	public static int getCount(int n, int sum) {
		
		if(n == 0) {
			return 0;
		}
		
		int count = 0;
		for(int i = 1; i <= 9; ++i) {
			count += sum-i >= 0 ? getCountUtil(n-1, sum-i) : 0;
		}
		return count;
		
	}
	
	public static void main(String[] args) {

		int n = 2;
		int sum = 5;
		table = new int[n][sum];
		
		for(int i = 0; i < table.length; ++i) {
			for(int j = 0; j < table[0].length; ++j) {
				table[i][j] = -1;
			}
		}
		
		System.out.println(getCount(n, sum));
		
	}

}
