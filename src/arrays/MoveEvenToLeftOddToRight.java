package arrays;

/**
 * http://www.careercup.com/question?id=19388662
 * 
 * You can also keep two pointers (start and end) for tracking the elements on
 * left which are odd and elements on right which are even. When you find such a
 * pair, swap the elements.
 * 
 * This is a very simple solution. Keep a tail pointer which holds the next
 * position for an even number to go. Traverse through the array, When you find
 * an even number in the array, swap with this tail index.
 * 
 * @author Ravali
 *
 */
public class MoveEvenToLeftOddToRight {

	public static void swap(int[] arr, int ind1, int ind2) {
		if(ind1 > arr.length || ind2 > arr.length || ind1 < 0 || ind2 < 0 || (ind1 == ind2)) {
			return;
		}
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	
	public static void arrangeEvelToLeftOddToRight(int[] arr) {
		
		int actualEvenIndex = 0;
		int nextEvenIndex = 0;
		
		for(; nextEvenIndex < arr.length; ++nextEvenIndex) {
			if(arr[nextEvenIndex]%2 == 0) {
				swap(arr, nextEvenIndex, actualEvenIndex);
				++actualEvenIndex;
			}
		}
		
		for(int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static void main(String[] args) {

		int[] arr = new int[] { 1, 3, 2, 5, 4, 6, 7, 12, 14, 17 };
		arrangeEvelToLeftOddToRight(arr);
		
	}

}
