package dp;

import java.util.HashMap;

/**
 * http://www.careercup.com/question?id=5638113330200576
 * S1 : string for which we need to check if its anagram is present in S2
 * S2 : source string
 * 
 * 1. create a hashmap (hm1) of character vs count from S1
 * 2. For every k length string (l = size of S1), create hashmap (hm2), 
 * 		then compare with hm1. If they are equal, then S2 has an anagram of S1
 * 3. After we get hm2 for first k length (0 to k-1) of S2, for the next k length,
 * 		subtract the (0) and add (k) for (1 to k) of S2 
 */
public class CheckIfAnagramIsSubset {

	private static boolean hasAnagram(String s1, String s2) {
		
		if(s1.isEmpty() || s2.length() < s1.length()) {
			return false;
		}
		
		HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
		for(int i = 0; i < s1.length(); ++i) {
			if(hm1.containsKey(s1.charAt(i))) {
				hm1.put(s1.charAt(i), hm1.get(s1.charAt(i))+1);
			} else {
				hm1.put(s1.charAt(i), 1);
			}
		}
		
		int sizeOfS1 = s1.length();
		boolean checkForEq = false;
		HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
		
		for(int i  = 0; i < s2.length(); ++i) {
			
			if(hm2.containsKey(s2.charAt(i))) {
				hm2.put(s2.charAt(i), hm2.get(s2.charAt(i))+1);
			} else {
				hm2.put(s2.charAt(i), 1);
			}
			
			if(i >= sizeOfS1-1) {
				checkForEq = true;
			}
			
			if(i >= sizeOfS1) {
				int count = hm2.get(s2.charAt(i-sizeOfS1))-1;
				if(count == 0) {
					hm2.remove(s2.charAt(i-sizeOfS1));
				} else {
					hm2.put(s2.charAt(i-sizeOfS1), count);
				}
			}
			
			if(checkForEq && hm1.equals(hm2)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {

		String s1 = "abcd";
		String s2 = "asasabdc";
		
		if(hasAnagram(s1, s2)) {
			System.out.println("Anagram Exists");
		} else {
			System.out.println("Anagram doesn't exist !!!");
		}
		
	}

}
