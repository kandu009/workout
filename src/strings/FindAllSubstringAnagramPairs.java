package strings;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 * 
 * Given an input string, get the number of pairs of anagrams possible using the
 * substrings of the string.
 * 
 * Solution: We can pre-process the data such that for each length of the string
 * considered, we have the count of each character. We need to evaluate the
 * count of characters for each of the possible substrings.
 * 
 * @author Ravali
 *
 */
public class FindAllSubstringAnagramPairs {

	public static int[][] characterVsLength_;
	
	public static void init(String input) {
		 characterVsLength_ = new int[26][input.length()+1];
	}
	
	public static void preprocess(String input) {
		
		// Any character count for string of zero length = 0
		for(int i = 0; i <= 'z'-'a'; ++i) {
			characterVsLength_[i][0] = 0;
		}
		
		for(int i = 1; i <= input.length(); ++i) {
			// Since the number of occurrences of each character will be the
			// same as the number of characters for previous length.
			// Plus an additional +1 for the current character.
			for(int j = 0; j < characterVsLength_.length; ++j) {
				characterVsLength_[j][i] = characterVsLength_[j][i-1];
			}
			characterVsLength_[input.charAt(i-1)-'a'][i]++;
		}
	}
	
	public static boolean isAnagram(int start1, int end1, int start2, int end2) {
		
		if(end1 < characterVsLength_[0].length && end2 < characterVsLength_[0].length) {
			for(int j = 0; j < characterVsLength_.length; ++j) {
				if(characterVsLength_[j][end1]-characterVsLength_[j][start1-1] != 
						characterVsLength_[j][end2]-characterVsLength_[j][start2-1]) {
					// Even if any one character count doesn't match, then it
					// cannot be a anagram.
					return false;
				}
				
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String input = new String("abba");
		int resultCount = 0;
		init(input);
		preprocess(input);
		for(int length = 1; length <= input.length(); ++length) {
			for(int start1 = 1; start1 <= input.length()-length+1; ++start1) {
				//start1+1 should be the start, else both substrings 
				//referred by start1 and start2 will be the same.
				for(int start2 = start1+1; start2 <= input.length()-length+1; ++start2) {
					if(isAnagram(start1, start1+length-1, start2, start2+length-1)) {
						++resultCount;
					}
				}
			}
		}
		System.out.println(resultCount);
	}

}
