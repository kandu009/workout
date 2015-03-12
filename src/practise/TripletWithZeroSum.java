package practise;

import java.util.HashSet;

/** http://www.careercup.com/question?id=5736292639834112 **/

public class TripletWithZeroSum {

	public static void main(String[] args) {
		
		int[] input = new int[] {10, -2, 2};
		findTripletWithZeroSum(input);
		
	}

	private static void findTripletWithZeroSum(int[] input) {
		HashSet<Integer> store = new HashSet<Integer>();
		for(int i = 0; i < input.length; ++i) {
			if(input[i] == 0) {
				System.out.println("Found triplet <" + input[i] +", " + input[i] + ", " + input[i] + ">");
				return;
			}
			store.add(input[i]);
		}
		
		for(int i = 0; i < input.length; ++i) {
			for(int j = i; j < input.length; ++j) {
				if(store.contains(-(input[i]+input[j]))) {
					System.out.println("Found triplet <" + input[i] + ", "
							+ input[j] + ", " + -(input[i] + input[j]) + ">");
					return;
				}
			}
		}
	}

}
