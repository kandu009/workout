package recursion;

/**
 * http://www.geeksforgeeks.org/print-increasing-sequences-length-k-first-n-natural-numbers/
 * 
 * Given two positive integers n and k, print all increasing sequences of length
 * k such that the elements in every sequence are from first n natural numbers
 * 
 * Solution: Starting from the first number, loop until the last number possible
 * = n-k+1 For each such selection recursively find the next part of the
 * sequence. Base case: When length of sequence == k, then print the sequence.
 * 
 * @author Ravali
 *
 */
public class PrintAllIncreasingSequences {

	public static int[] currentSequence = null;
	
	public static void printIncreasingSequence(int n, int currentNumber, int currentLength, int requiredLength) {
		
		if(requiredLength <= 0) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < currentSequence.length; ++i) {
				sb.append(currentSequence[i]);
			}
			System.out.println(sb.toString());
			return;
		}
		
		int actualCurrentLength = currentLength;
		for(int i = currentNumber; i <= n-requiredLength+1;) {
			// We need to know which is the index that is treated as the first
			// index for this call.
			// After fetching one combination, we need to find other
			// combinations from the index after the prefix index.
			currentLength = actualCurrentLength;
			currentSequence[currentLength++] = i++;
			printIncreasingSequence(n, i, currentLength, requiredLength-1);
		}
		
	}
	
	public static void main(String[] args) {

		int k = 3;
		int n = 5;
		
		currentSequence = new int[k];
		printIncreasingSequence(n, 1, 0, k);
		
	}

}
