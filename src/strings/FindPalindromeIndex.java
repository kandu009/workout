package strings;

/**
 * https://www.hackerrank.com/challenges/palindrome-index 
 * 
 * You are given a string
 * of lower case letters. Your task is to figure out the index of the character
 * on whose removal it will make the string a palindrome. There will always be a
 * valid solution.
 * 
 * @author Ravali
 *
 */
public class FindPalindromeIndex {

	public static boolean isPalindrome(String input) {
		for(int i = 0, j = input.length()-1; i <= j; ++i, --j) {
			if(input.charAt(i) != input.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
	public static int getIndex(String input) {
		
		int i = 0; int j = input.length()-1;
		
		// since it is given that there is always a valid solution, if we see an
		// occurence of mismatch,
		// then that will be our candidate index to make the string a
		// palindrome.
		for(; i <= j; ++i, --j) {
			if(input.charAt(i) != input.charAt(j)) {
				break;
			}
		}
		
		if(i >= j) {
			System.out.println("Already Palindrome");
			return -1;
			// this means that the string without character at i could be a palindrome.
		} else if(isPalindrome(input.substring(0, i)+input.substring(i+1))) {
			return i;
			// this means that the string without character at j could be a palindrome.
		} else if(isPalindrome(input.substring(0, j)+input.substring(j+1))) {
			return j;
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {

		String input = new String("bcbcb");
		System.out.println(getIndex(input));
		
	}

}
