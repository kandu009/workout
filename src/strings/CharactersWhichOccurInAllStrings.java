package strings;

import java.util.HashSet;

/**
 * https://www.hackerrank.com/challenges/gem-stones
 * 
 * Input is a set of strings which contain only lower case english alphabets.
 * Find the count of set of characters which are present atleast once in all the
 * input strings.
 * 
 * Solution: Since the input ranges only from 'a' to 'z', we can use a bitset
 * variable to represent/track the characters occurred in each string. i.e.,
 * since 26 alphabets, maximum bits needed is 26 to represent this. We can AND
 * these values per string to determine the number of characters present in all
 * strings.
 * 
 * @author Ravali
 *
 */
public class CharactersWhichOccurInAllStrings {

	public static int getCountOfCommonCharacters(HashSet<String> input) {
		
		if(input == null || input.size() <= 0) {
			return 0;
		}
		
		int globalBitset = -1;
		for(String s : input) {
			int localBitset = 0;
			if(s != null) {
				for(char c : s.toCharArray()) {
					// This means, we shift 1 'n' times where n =
					// <character>-'a', i.e., kind of number of the alphabet
					// from a.
					// This will set a bit in localBitset for that alphabet
					// since we OR the value from above step to localBitSet.
					// This way all unique characters in this String will have
					// bit set to 1 in localBitSet.
					localBitset |= 1 << (c-'a');
				}
			}
			globalBitset &= localBitset;
		}
		
		return Integer.bitCount(globalBitset);
	}
	
	public static void main(String[] args) {

		HashSet<String> input = new HashSet<String>();
		input.add("abc");
		input.add("baccd");
		input.add("eeabg");
		
		System.out.println(getCountOfCommonCharacters(input));
		
	}

}
