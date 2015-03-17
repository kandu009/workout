package arrays;

/**
 * http://www.careercup.com/question?id=5642196904574976
 * 
 * <p> can be done in O(logN) using modified binary search. </p>
 * 
 * steps :
 * 1. find mid1 and mid2 which are mid indexes for A1 and A2 </p>
 * 2. check if number of elements n1+n2/2 > n, </p>
 * 		if(A1[mid1] > A2[mid2]) => median cannot lie in the right half of A1 </p>
 * 		if(A2[mid2] > A1[mid1]) => median cannot lie in the right half of A2 </p>
 * 3. if n1+n2/2 <= n </p>
 * 		if(A1[mid1] < A2[mid2]) => median cannot lie in the left half of A1 </p>
 * 		if(A2[mid2] < A1[mid1]) => median cannot lie in the left half of A2 </p>
 * 4. break the above loop until one of left1 !< right! or left2 != right2 </p>
 * 5. Then A[left+n-1] would be our value </p>
 *   
 * @author rkandur
 *
 */
public class MedianOfTwoSortedArrays {

	private static int getNthElement(int[] A1, int[] A2, int n) {
		
		int left1 = 0; int left2 = 0;
		int right1 = A1.length-1; int right2 = A2.length-1;
		
		while(left1 <= right1 && left2 <= right2) {
			int mid1 = (left1+right1)/2;
			int mid2 = (left2+right2)/2;
			
			int n1 = mid1-left1+1;
			int n2 = mid2-left2+1;
			
			if(n1+n2 > n) {
				if(A1[mid1] > A2[mid2]) {
					right1 = mid1-1;
				} else {
					right2 = mid2-1;
				}
			} else {
				if(A1[mid1] < A2[mid2]) {
					left1 = mid1+1;
					n -= n1;
				} else {
					left2 = mid2+1;
					n -= n2;
				}
			}
		}
		
		if(left1 <= right1) {
			return A1[left1+n-1];
		} else {
			return A2[left2+n-1];
		}
		
	}
	
	public static void main(String[] args) {
		
		int [] A1 = new int[] {1, 12, 14, 16, 18};
		int[] A2 = new int[] {2, 4, 6, 8, 10};
		
		int n1 = getNthElement(A1, A2, (A1.length+A2.length)/2);
		int n2 = getNthElement(A1, A2, ((A1.length+A2.length)/2)+1);
		
		System.out.println((n1+n2)/2);
		
	}

}
