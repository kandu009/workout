package dp;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 * 
 * minCost(m, n) = cost[m][n] + min (
 * 										minCost(m-1, n-1), 
 * 										minCost(m-1, n), 
 * 										minCost(m, n-1)
 * 									)
 */
public class MinCostPathMatrix {

	private static int getMinCostPath(int[][] cost) {
		
		int[][] table = new int[cost[0].length][cost.length];
		
		table[0][0] = cost[0][0];
		for(int i = 1; i < table[0].length; ++i) {
			table[i][0] = table[i-1][0] + cost[i][0]; 
		}
		for(int i = 1; i < table.length; ++i) {
			table[0][i] = table[0][i-1] + cost[0][i]; 
		}
		
		for(int i = 1; i < table[0].length; ++i) {
			for(int j = 1; j < table.length; ++j) {
				table[i][j] = cost[i][j] + Math.min(Math.min(table[i][j-1], table[i-1][j-1]), table[i-1][j]);
			}
		}
		
		return table[table[0].length-1][table.length-1];
	}
	
	public static void main(String[] args) {
		
		int[][] cost = new int[][] { 
										{1, 2, 3},
										{4, 8, 2},
										{1, 5, 3} 
									};
		System.out.println(getMinCostPath(cost));
		
		
	}

}
