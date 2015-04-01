package dp;

/**
 * http://www.careercup.com/question?id=5728188153987072
 *
 * You are given an array of non-negative integers (0, 1, 2 etc). The value in
 * each element represents the number of hops you may take to the next
 * destination. Write a function that determines when you start from the first
 * element whether you will be able to reach the last element of the array.
 * 
 * if a value is 3, you can take either 0, 1, 2 or 3 hops.
 * 
 * For eg: for the array with elements 1, 2, 0, 1, 0, 1, any route you take from
 * the first element, you will not be able to reach the last element.
 */

public class ReachDestinationGivenHops {

	static int numOfHops = Integer.MAX_VALUE;
	
	public static int isReachable(int[] A, int start, int end, int hopCount) {
		
		int maxHops = A[start];
		if(start+maxHops >= end) {
			numOfHops = numOfHops > hopCount ? hopCount : numOfHops;
			return numOfHops;
		}
		
		while(maxHops > 0) {
			if(isReachable(A, start+maxHops, end, ++hopCount) != -1) {
				return numOfHops;
			}
			maxHops--;
		}

		return -1;
	}
	
	public static void main(String[] args) {

		int A[] = new int[] { 4, 2, 1, 4};
		
		if(-1 != isReachable(A, 0, A.length-1, 0)) {
			System.out.println("Reachable");
			System.out.println("Min Hop Count = " + ++numOfHops);
		} else {
			System.out.println("Not Reachable");
		}
		
	}

}
