package arrays;

/**
 * http://www.careercup.com/question?id=5692698000359424
 * 
 * we check if the number of elements that are actually in there (meaning the
 * highest value minus the lowest value) matches the number of element of that
 * sub array. If so (meaning the difference is zero) the function will do
 * nothing. otherwise, we check if we got array that has a pair arr[i],arr[i+1]
 * which has difference > 1
 * 
 * **/

public class FindMissingNumbers {

	public static void findMissingNumbers(int[] input) {
		findMissingNumbers(input, 0, input.length-1);
	}
	
	public static void findMissingNumbers(int[] a, int low, int high) {

		if(low+1 == high) {
			if(low+1 != a[low]) {
				System.out.println(a[low]+1);
			} else {
				System.out.println(a[high]-1);
			}
			return;
		}
		
		int mid = (low + high)/2;
		if((a[mid]-a[low]) != (mid-low)) {
			findMissingNumbers(a, low, mid);
		} 
		if((a[high]-a[mid]) != (high-mid)) {
			findMissingNumbers(a, mid, high);
		}
		
	}
	
	public static void main(String[] args) {
		int[] input = {1,2,4,5,6,8,9};
		findMissingNumbers(input);
	}
	
}
