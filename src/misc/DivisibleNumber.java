package misc;

/**
 * http://www.careercup.com/question?id=6017875829587968
 * 
 * start with 0, 1 in the array check if they are divisible by n, if not
 * increment the values in the array by 10
 *
 */
public class DivisibleNumber {

	private static int findDivisibleNumber(int n) {
		
		int[] nextSet = new int[] { 0, 1 };
		
		for(int i = 10; i < Integer.MAX_VALUE; i = i * 10) {
			
			for(int ind = 0; ind < nextSet.length; ++ind) {
				if(nextSet[ind] != 0 && nextSet[ind]%n == 0) {
					return nextSet[ind];
				}
			}
			
			for(int ind = 0; ind < nextSet.length; ++ind) {
				nextSet[ind] = nextSet[ind]+i;
			}
			
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {

		System.out.println(findDivisibleNumber(6));
		
	}

}
