package arrays;

/**
 * 
 * http://www.careercup.com/question?id=6262507668766720
 * 
 * You are given a binary array with N elements: d[0], d[1], ... d[N - 1]. You
 * can perform AT MOST one move on the array: choose any two integers [L, R],
 * and flip all the elements between (and including) the L-th and R-th bits. L
 * and R represent the left-most and right-most index of the bits marking the
 * boundaries of the segment which you have decided to flip.
 * 
 * What is the maximum number of '1'-bits (indicated by S) which you can obtain
 * in the final bit-string?
 * 
 * Solution:
 * 
 * At any point, we need to check the contiguous array which has maximum
 * 'numberOfZeroes-numberOfOnes'. Such that, when we flip, we have more 1's in
 * the overall array.
 * 
 * This would be same as find array with max contiguous sum kind of logic.
 * 
 * @author Ravali
 *
 */

public class MaximumOnesAfterFlipping {

	public static int getMaximumOnes(int[] arr) {
		
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		// if there is only one element, then it is obvious.
		if(arr.length == 1) {
			if(arr[0] == 0) {
				System.out.println("Start = 0 and End = 0");
				return 1;
			} else {
				System.out.println("Start = 0 and End = 0");
				return 0;
			}
		}
		
		int global_flip_sum = Integer.MAX_VALUE;
		int global_flip_start = 0;
		int global_flip_end = 0;
		
		int local_flip_sum = 0;
		int local_flip_start = 0;
		int local_flip_end = 0;
		
		// number of ones which are in the original array until the local_end
		int num_of_ones = 0;
		// total number of elements
		int num_of_elements = arr.length;
		
		for(;local_flip_start < num_of_elements && local_flip_end < num_of_elements;) {
			if(arr[local_flip_end] == 1) { 
				num_of_ones += 1; 
			}
			local_flip_sum += (arr[local_flip_end] == 0) ? -1 : 1;
			if(local_flip_sum < global_flip_sum) {
				global_flip_sum = local_flip_sum;
				global_flip_start = local_flip_start;
				global_flip_end = local_flip_end;
				local_flip_end++;
				// This means, we have a contiguous array where number of ones
				// are more than num of zeroes.
				// This will not help us as once we flip, this contiguous array
				// will clearly reduce the maximum number of ones.
			} else if(local_flip_sum > 0) {
				local_flip_start = local_flip_end+1;
				local_flip_end = local_flip_end+1;
				local_flip_sum = 0;
			} else {
				local_flip_end++;
			}
		}
		
		System.out.println("flip from " + global_flip_start + " to " + global_flip_end);
		return num_of_ones - global_flip_sum;
	}
	
	public static void main(String[] args) {

		//int[] arr = new int[] { 1, 1, 1, 0, 1, 1, 1, 0 };
		//int[] arr = new int[] { 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1 };
		int[] arr = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		System.out.println(getMaximumOnes(arr));

	}

}
