package dp;

/**
 * http://www.geeksforgeeks.org/minimum-positive-points-to-reach-destination/
 * 
 * @author Ravali
 *
 */

public class MinPointsToReachInMatrix {

	public static int getMinPoints(int[][] input) {
		
		int[][] table = new int[input.length][input[0].length];
		
		int m = table.length;
		int n = table[0].length;
		table[m-1][n-1] = input[m-1][n-1] > 0 ? 1 : Math.abs(input[m-1][n-1])+1;
		
		for(int i = m-2; i >= 0; --i) {
			table[i][n-1] = Math.max(table[i+1][n-1]-input[i][n-1], 1); 
		}
		for(int i = n-2; i >= 0; --i) {
			table[m-1][i] = Math.max(table[m-1][i+1]-input[m-1][i], 1);
		}
		
		for(int i = m-2; i >= 0; --i) {
			for(int j = n-2; j >=0; --j) {
				table[i][j] = Math.max(Math.min(table[i+1][j], table[i][j+1])-input[i][j], 1);
			}
		}
		
		return table[0][0];
	}
	
	public static void main(String[] args) {

		int[][] input = new int[][] {
				{-2,-3,3},
                {-5,-10,1},
                {10,30,-5}	
		};
		
		System.out.println(getMinPoints(input));
	}

}
