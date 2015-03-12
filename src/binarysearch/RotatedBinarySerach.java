package binarysearch;


/**
 *
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * 
 * find the pivot where the rotation happens and then do 2 binary searches
 * separately
 *
 */
public class RotatedBinarySerach {

	public static int findPivot(int[] a, int low, int high) {
		
		if(low > high) {
			return -1;
		}
		if(low == high) {
			return low;
		}
		
		int mid = (low+high)/2;
		if(low < mid && a[mid] < a[mid-1]) {
			return mid;
		} 
		if(mid < high && a[mid] > a[mid+1]) {
			return mid+1;
		}
		
		if(low < mid && a[low] < a[mid])
			return findPivot(a, mid+1, high);
		else 
			return findPivot(a, low, mid-1);
		
	}
	
	public static int binarySearch(int[] a, int low, int high, int n) {
		
		if(low > high) {
			return -1;
		}
		int mid = (low+high)/2;
		if(n == a[mid]) {
			return mid;
		}
		
		if(a[low] <= n && a[mid] > n) {
			return binarySearch(a, low, mid-1, n);
		} 
		if(a[mid] < n && n <= a[high]) {
			return binarySearch(a, mid+1, high, n);
		}
		
		return -1;
	}
	
	public static void main(String[] args) {

		int[] A = new int[] {3,4,5,6,1,2};
		int n = 1;
		
//		find the pivot where the rotation starts
		int pivot = findPivot(A, 0, A.length-1);
		if(n == A[pivot]) {
			System.out.println("Found element at " + pivot);
			return;
		}
		
//		do 2 binary searches separately on 2 parts around the pivot
		int left = binarySearch(A, 0, pivot-1, n);
		if(-1 == left) {
			int right = binarySearch(A, pivot, A.length-1, n);
			if(-1 != right) {
				System.out.println("Found element at " + right);
			} else {
				System.out.println("Element Not Found");
			}
		} else {
			System.out.println("Found element at " + left);
		}
		
	}

}
