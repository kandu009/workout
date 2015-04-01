package misc;

/**
 * http://www.careercup.com/question?id=5092486548553728
 */
public class CheckIfEditDistanceIsOne {

	// assuming s1's length is <= s2's length
	public static boolean hasEditDistanceEqualToOne(String s1, String s2) {
		
		if(Math.abs(s2.length()-s1.length()) > 1) {
			return false;
		}
		
		for(int i = 0; i < s1.length(); ++i) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(s1.length() == s2.length()) {
					return s1.substring(i+1).equals(s2.substring(i+1));
				} 
				return s1.substring(i).equals(s2.substring(i+1));
			}
		}
		
		return s1.length() != s2.length();
	}
	
	public static void main(String[] args) {
		if(hasEditDistanceEqualToOne("abc", "abec")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
