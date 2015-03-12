package dp;

import java.util.TreeSet;

/**
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * 
 * table[i] = Math.min(table[i], table[i-c]+1);
 *
 */
public class MinCoinsForSum {

	private static int findMinCoins(int sum, TreeSet<Integer> coins) {

		int[] table = new int[sum+1];
		table[0] = 0;
		for(int i = 1; i <= sum; ++i) {
			if(coins.contains(i)) {
				table[i] = 1;
			} else {
				table[i] = Integer.MAX_VALUE;
				for(int c : coins) {
					if(i-c > 0) {
						table[i] = Math.min(table[i], table[i-c]+1);
					}
				}
			}
		}
		
		return table[sum];
	}
	
	public static void main(String[] args) {

		int sum = 17;
		TreeSet<Integer> coins = new TreeSet<Integer>();
		coins.add(1);
		coins.add(2);
		coins.add(3);
		coins.add(5);

		System.out.println(findMinCoins(sum, coins));
	}

}
