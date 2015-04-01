package arrays;

/**
 * http://www.careercup.com/question?id=2245664
 * http://www.careercup.com/question?id=5080405046722560
 * 
 * Sort an array of 0, 1, 2 elements only
 */
public class DutchNationalFlag {

	public static void sortArray(int[] A) {
		int low = 0;
		int high = A.length-1;
		int mid = 0;
		
		while(mid <= high) {
			switch(A[mid]) {
				case 0:
				{
					int temp = A[low]; 
					 A[low] = A[mid];
					 A[mid] = temp;
					 ++low;
					 ++mid;
					break;
				}
				case 1:
				{
					++mid;
					break;
				}
				case 2:
				{
					int temp = A[mid]; 
					 A[mid] = A[high];
					 A[high] = temp;
					 --high;
					break;
				}
				default: 
				{
					break;
				}
			}
		}
		
		for(int i = 0; i < A.length; ++i) {
			System.out.println(A[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] A = new int[] { 2, 0, 1, 1, 2, 0, 2, 2, 0, 1, 1, 2, 1, 0, 2 };
		sortArray(A);
	}

}
