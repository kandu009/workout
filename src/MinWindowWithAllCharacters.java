import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * http://www.careercup.com/question?id=5092414932910080
 * 
 * We will first find the first window where all given characters are found
 * Next, we move forward, keeping track of a tail which points to the first
 * character position If we find another index of same character later, we move
 * the minLengthWindow forward.
 * 
 * By the end of string, we have a min window
 * 
 *
 */
public class MinWindowWithAllCharacters {
	
	public static String findMinimumWindow(String string, HashSet<Character> chars) {
		
		int charCount = 0;
		HashMap<Character, Integer> minFinderMap = new HashMap<Character, Integer>();
		
		int minLength = Integer.MAX_VALUE; // minimum window length in which we found all the input characters in the string
		int tail = 0;	// used to track the lowest index of the character occurence in the string for searching in further string
		String result = new String();
		
		int i = 0;
		for(; i < string.length(); ++i) {
			Character c = string.charAt(i);
			if(chars.contains(c)) {
				if(!minFinderMap.containsKey(c)) {
					++charCount;
				}
				minFinderMap.put(c, minFinderMap.get(c)+1);
			}
			while(charCount == chars.size()) {
				if(chars.contains(string.charAt(tail))) {
					int v = minFinderMap.get(string.charAt(tail));
					if(v - 1 == 0) {
						charCount--;
					}
					minFinderMap.put(string.charAt(tail), v-1);
				}
				if(i-tail+1 < minLength) {
					minLength = i-tail+1;
					result = string.substring(tail, tail+minLength);
				}
			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {

		String string = new String("abbcbcba");
		HashSet<Character> chars = new HashSet<Character>();
		chars.add('a');
		chars.add('b');
		chars.add('c');
		System.out.println(findMinimumWindow(string, chars));
		
	}

}
