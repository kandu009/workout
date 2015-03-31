package arrays;

/**
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * 
 * 1) m1, m2 be medians of A1[], A2[]
 * 2) if(m1 == m2) { return m1; }
 * 3) if(m1 > m2)
 * 		a) From first element of A1 to m1 (A1[0...|_n/2_|]) 
 * 		b) From m2 to last element of A2 (A2[|_n/2_|...n-1]) 
 * 4) if(m2 > m1) , then median is present in one of the below two subarrays. 
 * 		a) From m1 to last element of A1 (A1[|_n/2_|...n-1]) 
 * 		b) From first element of A2 to m2 (A2[0...|_n/2_|]) 
 * 5) Repeat until size of sub arrays = 2 
 * 6) If size of the two arrays is 2 then 
 * 		Median = (max(A1[0], A2[0]) + min(A1[1], A2[1]))/2
 */
public class MedianOfTwoSortedArrays2 {
	
	private static int computeMedian(int[] A, int s, int e) {
		int length = e-s+1;
		if(length == 1) {
			return A[s];
		}
		if(length == 2) {
			return (A[s]+A[e])/2;
		}
		if(length%2 == 0) {
			return (A[s+(length/2)]+A[s+(length/2)-1])/2;
		} 
		return A[s+(length/2)];
	}
	
	private static int computeMedian(int[] A1, int[] A2, int s1, int e1, int s2, int e2) {
		
		if(e1-s1 < 0) {
			return -1;
		}
		if(e1-s1 == 0) {
			return (A1[s1]+A2[s2])/2;
		}
		if(e1-s1 == 1) {
			return (Math.max(A1[s1], A2[s2]) + Math.min(A1[e1], A2[e2]))/2 ;
		}
		
		int m1 = computeMedian(A1, s1, e1);
		int m2 = computeMedian(A2, s2, e2);
		if(m1 == m2) {
			return m1;
		}
		if(m1 < m2) {
			if((e1-s1+1) %2 == 0) {
				return computeMedian(A1, A2, s1+(e1-s1+1)/2-1, e1, s2, s2+(e1-s2+1)/2);
			} else {
				return computeMedian(A1, A2, s1+(e1-s1+1)/2, e1, s2, s2+(e2-s2+1)/2);
			}
		} 
		
		if((e1-s1+1) %2 == 0) {
			return computeMedian(A1, A2, s1, s1+(e1-s1+1)/2, s2+(e2-s2+1)/2-1, e2);
		} else {
			return computeMedian(A1, A2, s1, s1+(e1-s1+1)/2, s2+(e2-s2+1)/2, e2);
		}
	}

	public static void main(String[] args) {

		int[] A1 = new int[] {1, 2, 3, 6};
		int[] A2 = new int[] {4, 6, 8, 10};
		
		System.out.println(computeMedian(A1, A2, 0, A1.length-1, 0, A2.length-1));

	}

}
