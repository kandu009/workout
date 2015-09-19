package recursion;

/**
 * http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 * 
 * Given an array of size n, generate and print all possible combinations of r
 * elements in array. For example, if input array is {1, 2, 3, 4} and r is 2,
 * then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
 * 
 * @author Ravali
 *
 */
public class PrintAllSubSequences {
	
	public static int[] currentSeq = null;
	
	
	/**
	 * Method 1: We fix i'th number in the sequence and fill in i+1, i+2'th indices and so on.
	 */
	public static void printAllSubSequences1(int[] input, 
			int requiredLength, int startIndex, int seqCurrIndex) {
		
		if(requiredLength == 0) {
			StringBuilder sb = new StringBuilder();
			for(int s:currentSeq) {
				sb.append(s);
			}
			System.out.println(sb.toString());
			return;
		}
		
		int actualSeqCurrIndex = seqCurrIndex;
		for(int i = startIndex; i <= input.length-requiredLength; ) {
			seqCurrIndex = actualSeqCurrIndex;
			currentSeq[seqCurrIndex++] = input[i++];
			printAllSubSequences1(input, requiredLength-1, i, seqCurrIndex);
		}
		
	}
	
	/**
	 * Method 2: We either include the current element in input array or exclude it.
	 */
	public static void printAllSubSequences2(int[] input, 
			int requiredLength, int startIndex, int seqCurrIndex) {
		
		if(requiredLength == 0) {
			StringBuilder sb = new StringBuilder();
			for(int s:currentSeq) {
				sb.append(s);
			}
			System.out.println(sb.toString());
			return;
		}
		
		if(startIndex >= input.length) {
			return;
		}
		
		// include
		currentSeq[seqCurrIndex] = input[startIndex];
		printAllSubSequences2(input, requiredLength-1, startIndex+1, seqCurrIndex+1);
		
		// exclude
		printAllSubSequences2(input, requiredLength, startIndex+1, seqCurrIndex);
		
	}

	public static void main(String[] args) {

		int[] input = new int[] {1,2,3,4};
		int k = 3;
		currentSeq = new int[k];
		
		printAllSubSequences2(input, k, 0, 0);
		
	}

}
