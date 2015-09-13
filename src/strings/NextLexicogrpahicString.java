package strings;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater
 * 
 * I first did O(nlogn), by putting elements after violationIndex to heap to get
 * the sorted order. But aren't they already sorted ? This Awesome solution does
 * that:
 * http://massivealgorithms.blogspot.com/2014/06/yus-coding-garden-leetcode
 * -question-61.html
 * 
 * @author Ravali
 *
 */

public class NextLexicogrpahicString {

	public static String getNextLexicographicString(String str) {
		
		if(str == null || str.isEmpty()) {
			return "";
		}
		
		char[] res = str.toCharArray();

		// From right to left, find the character which is lexicographically
		// smaller than the next element.
		// This means that this is the place from where we can rearrange the
		// letters to get the next
		// biggest lexicographic string.
		int violateIndex = -1;
		for(int i = res.length-2; i >= 0; --i) {
			if(res[i] < res[i+1]) {
				violateIndex = i;
				break;
			}
		}

		// If all the characters are in increasing order from right to left, 
		// then we cannot generate any higher lexicographic string.
		if(violateIndex == -1) {
			return "no answer";
		}
		
		// Now, since we know that the characters are in increasing order from
		// right to left until the violationIndex.
		// We can make use of this to find an element from right to left, which
		// is higher than the violationIndex character.
		// This can be swapped with the violationIndex character to produce the
		// next highest string.
		int swapIndex = -1;
		for(int i = res.length-2; i > violateIndex; --i) {
			if(res[i] > res[violateIndex]) {
				swapIndex = i;
				break;
			}
		}
		
		if(swapIndex == -1) {
			return "no answer";
		}
		
		// swap the chars.
		char temp = res[violateIndex];
		res[violateIndex] = res[swapIndex];
		res[swapIndex] = temp;
		
		// Since we know that the characters are increasing from right to left,
		// we can just reverse the string after violationIndex so that
		// we can get the lowest possible lexicographic string higher than the
		// input string.
		// *************** This is the catch which makes the solution O(n).
		reverse(res, violateIndex+1);
		
		return new StringBuilder().append(res).toString();
	}
	
	private static void reverse(char[] res, int startIndex) {

		if(startIndex >= res.length) {
			return;
		}
		
		for(int i = startIndex, j = res.length-1; i < j; ++i, --j) {
			char temp = res[i];
			res[i] = res[j];
			res[j] = temp;
		}
		
	}

	public static void main(String[] args) {
		
		String input = new String("dkhc");
		System.out.println(getNextLexicographicString(input));
	
	}

}
