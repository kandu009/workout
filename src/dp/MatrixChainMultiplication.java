package dp;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 * 
 * Base case, Multiplying a single matrix = 0, as no multiplication needs to be done
 * Do the multiplication for Length = 2 to n
 * table[i][j] = Math.min(table[i][k] + table[k+1][j] + (m[i-1]*m[k]*m[j]), table[i][j]);
 *
 * **************** & Not Working & ********************
 */
public class MatrixChainMultiplication {

	public static int getOptimalMultiplicationCost(int[] m) {
		
		int size = m.length;
		int[][] table = new int[size][size];
		
		for(int i = 1; i < size; ++i) {
			table[i][i] = 0;
		}
		
		for(int L = 2; L < size; ++L) {
			for(int i = 1; i < size-L+1; ++i) {
				int j = i+L-1;
				table[i][j] = Integer.MAX_VALUE;
				for(int k = i; k <= j-1; ++k) {
					table[i][j] = Math.min(table[i][k] + table[k+1][j] + (m[i-1]*m[k]*m[j]), table[i][j]);
				}
				
			}
		}
		
		return table[1][size-1];
	}
	
	
	public static void main(String[] args) {

		int[] p = new int[] { 10, 20, 30, 40, 30 };
		System.out.println(getOptimalMultiplicationCost(p));
		
	}

}
