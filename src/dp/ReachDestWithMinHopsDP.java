package dp;

/**
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * Jumps[i] = Min(Jumps[i], Jumps[j]+1)
 */
	
public class ReachDestWithMinHopsDP {

	private static int minJumps(int[] A) {
		
		if(A == null || A.length == 0) {
			return Integer.MAX_VALUE;
		}
		
		int[] jumps = new int[A.length];
		
		jumps[0] = 0;
		for(int i = 1; i < jumps.length; ++i) {
			jumps[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < A.length; ++i) {
			for(int j = 0; j < i; ++j) {
				if(i <= j+A[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
					break;
				}
			}
		}
		
		return jumps[jumps.length-1];
	}
	
	public static void main(String[] args) {
		int A[] = new int[] { 4, 2, 1, 4};
		System.out.println(minJumps(A));
	}

}