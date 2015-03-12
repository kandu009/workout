package dp;


/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 * 
 * bottom up approach first computer the max profit for the lower lengths, use
 * these results for higher lengths.
 * 
 * table[len] = Math.max(table[len], costs[i-1]+table[len-i]);
 * 
 */
public class CuttingRod {

	private static int getMaxProfit(int[] costs) {
		
		int[] table = new int[costs.length+1];
		table[0] = 0;
		
		for(int len = 1; len <= costs.length; ++len) {
			for(int i = 1; i <= len; ++i) {
				if(len-i >= 0) {
					table[len] = Math.max(table[len], costs[i-1]+table[len-i]);
				}
			}
		}
		
		return table[table.length-1];
	}
	
	public static void main(String[] args) {
		
		int[] costs = new int[] {1,5,8,9,10,17,17,20};
		System.out.println(getMaxProfit(costs));
		
	}

}
