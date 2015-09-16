package strings;

/**
 * https://www.hackerrank.com/challenges/anagram
 * 
 * Find the minimum number of characters of the first string (s1) which needs to
 * change to make it an anagram of the second string (s2). Strings s1 and s2 are
 * selected in such a way that | len(s1) - len(s2) | <= 1
 * 
 * Solution:
 * 
 * Since we just need a count of the number of edits, we can generate an array
 * from string which stores the alphabets and its counts like {(a,1), (b,2),
 * (c,3) } etc. Since these arrays are already sorted, we can directly
 * accumulate the difference in counts of these arrays to get the final minimum
 * number of edits.
 * 
 * @author Ravali
 *
 */
public class MinimumStringEditToMakeAnagramOfString2 {

	private static void initCountArray(int[] countArr, String string) {
		if(string == null || string.isEmpty()) {
			return;
		}
		for(int i = 0; i < string.length(); ++i) {
			countArr[string.charAt(i)]++;
		}
	}
	
	public static int getMinimumEdits(String s1, String s2) {
		
		int[] countArr1 = new int[256];
		int[] countAarr2 = new int[256];
		
		initCountArray(countArr1, s1);
		initCountArray(countAarr2, s2);
		
		int numOfEdits = 0;
		for(int i = 0; i < countArr1.length; ++i) {
			numOfEdits += Math.abs(countArr1[i]-countAarr2[i]);
		}
		
		return numOfEdits;
	}
	
	public static void main(String[] args) {

		String s1 = new String("abc");
		String s2 = new String("mnop");
		
		System.out.println(getMinimumEdits(s1, s2));
		
	}

}
