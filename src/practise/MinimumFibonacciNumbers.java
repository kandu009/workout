package practise;

import java.util.ArrayList;

/** http://www.careercup.com/question?id=5090409931866112 **/

public class MinimumFibonacciNumbers {

	public static void main(String[] args) {
		int sum = 9;
		System.out.println(findMinimumNumberOfFiboNumbersFor(sum));
	}

	private static int findMinimumNumberOfFiboNumbersFor(int sum) {
		
		ArrayList<Integer> fiboNumbers = new ArrayList<Integer>();
		int a = 0;
		int b = 1;
		int c = 1;
		fiboNumbers.add(b);
		fiboNumbers.add(c);
		while(true) {
			c = a+b;
			if(c <= sum) {
				fiboNumbers.add(c);
			} else {
				break;
			}
			a = b;
			b = c;
		}
		
		System.out.println(fiboNumbers.toString());
		
		int[] minFiboNumbers = new int[sum+1];
		minFiboNumbers[0] = 0;
		
		for(int i = 1; i <= sum; ++i) {
			minFiboNumbers[i] = Integer.MAX_VALUE;
			for(Integer f : fiboNumbers) {
				if(f <= i) {
					minFiboNumbers[i] = Math.min(minFiboNumbers[i], minFiboNumbers[i-f]+1);
				} else {
					break;
				}
			}
		}
		
		return minFiboNumbers[sum];
	}

}
