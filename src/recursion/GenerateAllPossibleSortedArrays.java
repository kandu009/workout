package recursion;

import java.util.ArrayList;

/**
 * http://www.geeksforgeeks.org/generate-all-possible-sorted-arrays-from-alternate-elements-of-two-given-arrays/
 * 
 * Given two sorted arrays A and B, generate all possible arrays such that first
 * element is taken from A then from B then from A and so on in increasing order
 * till the arrays exhausted. The generated arrays should end with an element
 * from B.
 * 
 * @author Ravali
 *
 */
public class GenerateAllPossibleSortedArrays {

	// List with all the generated sorted arrays from A and B.
	public static ArrayList<String> allPossibleSortedArrays_ = new ArrayList<String>();
	
	// Array which keeps a track of the current sorted array combination produced from A and B.
	public static int[] currentCombination = null;

	/**
	 * @param A
	 * @param currentAIndex
	 *            Current index in A from which we need to consider as start
	 *            index
	 * @param B
	 * @param currentBIndex
	 *            Current index in B from which we need to consider as start
	 *            index
	 * @param currentArrayIndex
	 *            next index at which the next element in combined sorted array
	 *            should go.
	 * @param isNextA
	 *            Flag which says if A's element should go next ot B's.
	 */
	public static void generateAllSortedArrays(int[] A, int currentAIndex, int[] B,
			int currentBIndex, int currentArrayIndex, boolean isNextA) {
		
		if(isNextA) {

			// We should only consider printing the exisitng combined array oly
			// when we have both A's and B's elements in equal proportion.
			if(currentArrayIndex >= 2) {
				int length = currentArrayIndex;
				// This means, after we added A's element, there are no more B's left. 
				// So we need not consider that extra element from A.
				if(currentBIndex > B.length) {
					length = currentArrayIndex-1;
				}
				StringBuilder temp = new StringBuilder();
				for(int i = 0; i < length; ++i) {
					temp.append(currentCombination[i]).append(",");
				}
				allPossibleSortedArrays_.add(temp.toString());
			}
			
			int actualArrayIndex = currentArrayIndex;
			for(int i = currentAIndex; i < A.length;) {
				// After trying on combination, we need to start using the same
				// CombinedArray for another sorted array now.
				// So we need to start from the actual start index.
				currentArrayIndex = actualArrayIndex;
				// For the very first element.
				if(currentArrayIndex == 0) {
					currentCombination[currentArrayIndex++] = A[i++];
					generateAllSortedArrays(A, i, B, currentBIndex, currentArrayIndex, !isNextA);
				} else {
					// Make sure we have another element from A which is greater
					// than the last greater element chosen from B.
					while(i < A.length && A[i] <= currentCombination[currentArrayIndex-1]) {
						++i;
					}
					if(i < A.length) {
						currentCombination[currentArrayIndex++] = A[i++];
						generateAllSortedArrays(A, i, B, currentBIndex, currentArrayIndex, !isNextA);
					}
				}
			}
		} else {
			int actualArrayIndex = currentArrayIndex;
			for(int i = currentBIndex; i < B.length;) {
				// After trying on combination, we need to start using the same
				// CombinedArray for another sorted array now.
				// So we need to start from the actual start index.
				currentArrayIndex = actualArrayIndex;
				// Make sure we have another element from B which is greater
				// than the last greater element chosen from A.
				while(i < B.length && B[i] <= currentCombination[currentArrayIndex-1]) {
					++i;
				}
				if(currentBIndex < B.length) {
					currentCombination[currentArrayIndex++] = B[i++];
					generateAllSortedArrays(A, currentAIndex, B, i, currentArrayIndex, !isNextA);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {

		int[] A = new int[]{10, 15, 25};
		int[] B = new int[] {1, 5, 20, 30};
		
		currentCombination = new int[A.length+B.length];
		
		generateAllSortedArrays(A, 0, B, 0, 0, true);
		
		for(String p: allPossibleSortedArrays_) {
			System.out.println(p);
		}
		
	}

}
