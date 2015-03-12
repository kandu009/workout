

import java.util.HashMap;

/**
 * http://www.careercup.com/question?id=5642432622362624
 * 
 * use binary search to calculate the count
 * 
 * if(A[start] == A[end]) {
 * 		count[A[start]] += (end-start)+1;
 * } else {
 * 		count(A, start, start+end/2);
 * 		count(A, start+end/2+1, end);
 * }
 *
 */
public class CountOfSameAge {

	static HashMap<Integer, Integer> ageVsCount_ = new HashMap<Integer, Integer>();
	
	private static void calculateStatisticsHelper(int[] A, int start, int end) {
		
		if(start > end) {
			return;
		}
		
		if(A[start] == A[end]) {
			if(ageVsCount_.containsKey(A[start])) {
				ageVsCount_.put(A[start], ageVsCount_.get(A[start])+(end-start+1));
			} else {
				ageVsCount_.put(A[start], (end-start+1));
			}
		} else {
			calculateStatisticsHelper(A, start, (start+end)/2);
			calculateStatisticsHelper(A, ((start+end)/2)+1, end);
		}
		
	}
	
	private static void calculateStatistics(int[] A) {
		calculateStatisticsHelper(A, 0, A.length-1);
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {0,0,0,1,1,2,2,3,4,5,6,7,7,7,7,8,9,9,10,10,10,10,11};
		calculateStatistics(A);
		for(int i : ageVsCount_.keySet()) {
			System.out.println(i +" = "+ ageVsCount_.get(i));
		}
	}

}
