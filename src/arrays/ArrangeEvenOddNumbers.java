package arrays;

/**
 * 
 * http://www.careercup.com/question?id=5733186694807552
 * 
 * Given the array of integers containing equal number of even and odd numbers.
 * Rearrange the array such that even number is at even place and odd number is
 * at odd place. Example : [2,1,3,4,7,9,24,98] Answer : 1,2,3,4,7,24,9,98
 * 
 * @author Ravali
 *
 */
public class ArrangeEvenOddNumbers {

	public static void swap(int[] evenOddArray, int index1, int index2) {
		int temp = evenOddArray[index1];
		evenOddArray[index1] = evenOddArray[index2];
		evenOddArray[index2] = temp;
	}

	private static void rearrangeArray(int[] evenOddArray) {
		
		if(evenOddArray == null || evenOddArray.length <= 0) {
			return;
		}
		
		if(evenOddArray.length%2 != 0) {
			return;
		}

		int evenIndex = 0;
		int oddIndex = 1;
		
		while(evenIndex < evenOddArray.length && oddIndex < evenOddArray.length) {
			
			while (evenIndex < evenOddArray.length && evenOddArray[evenIndex] % 2 == 0)
			{
				evenIndex += 2;
			}
			while (oddIndex < evenOddArray.length && evenOddArray[oddIndex] % 2 == 1)
			{
				oddIndex += 2;
			}

			if(oddIndex < evenOddArray.length && evenIndex < evenOddArray.length) {
				swap(evenOddArray, evenIndex, oddIndex);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int evenOddArray[] = {2, 5, 8, 6, 11, 23, 18, 1, 9, 10};
		
		rearrangeArray(evenOddArray);
		
		for(int i = 0; i < evenOddArray.length; ++i) {
			System.out.println(evenOddArray[i]);
		}
	}

}
