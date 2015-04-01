package dp;

public class MaximumContiguousProduct {

	public static void main(String[] args) {
		
//		int[] array = { 15, 2, 3, 1, 8, 0, 100 };
//		int[] array = { 1, -2, 3, 4, -5, 0, 2, 5, 1, 0, 8, -3, 1, 0, 0, 1, 3, -5, 7, -6, 2, -2, 2 };
//		int[] array = { -100, 2, 25, -1, 8, -5, 22 };
		int[] array = { -150, 25, -3, 15, 8, 10, -1, 5, 25 };
		System.out.println(findMaxProduct(array, 0, array.length));
		
	}

	private static int findMaxProduct(int[] array, int start, int end) {
		
		int negCount = 0;
		int zeroCount = 0;
		int zeroIndex = 0;
		
		// find number of negative numbers and number of zeroes
		for(int i = start; i < end; ++i) {
			if(array[i] == 0) {
				zeroCount++; 
				zeroIndex = i;
			}
			negCount = array[i] < 0 ? negCount+1 : negCount;
		}
		
		// if there are zeroes then find the subProduct of left and right subArrays
		if(zeroCount > 0) {
			int left = findMaxProduct(array, start, zeroIndex);
			int right = findMaxProduct(array, zeroIndex+1, end);
			return (left > right) ? left : right;
		}
		
		// if there are no or even negatives, then we can just find the product of all elements in array
		if(negCount%2 == 0) {
			int product = 1;
			for(int i  = 0; i < end; ++i) {
				product *= array[i];
			}
			return product;
		}
		
		// this means we have odd number of negatives.
		
		int fp = 1;
		int bp = 1;
		int fInd = start;
		int bInd = end;

		// since we need a contiguous max product, the result will be higher if
		// we exclude the product from one of the ends until we find a negative
		// number which is lower
		for(int i = start; i < end; ++i) {		// forward product
			fp *= array[i];
			if(array[i] < 0) {
				fInd = i;
				break;
			}
		}
		
		for(int i = end-1; i >= start; --i) {	// backward product
			bp *= array[i];
			if(array[i] < 0) {
				bInd = i;
				break;
			}
		}

		// eg:[ -3 ].......[ -6 ]
		// since -(-6) will be greater than -(-3), we eliminate -3 which is
		// actually greater than -6

		int product = 1;
		int pfInd = (fp > bp) ? fInd+1 : start;
		int pbInd = (fp > bp) ? end : bInd;
		for(int i = pfInd; i < pbInd; ++i) {
			product *= array[i];
		}
		
		return product;
	}

}
