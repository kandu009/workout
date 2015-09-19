package recursion;

/**
 * http://www.geeksforgeeks.org/print-all-combinations-of-given-length/
 * 
 * Given a set of characters and a positive integer k, print all possible
 * strings of length k that can be formed from the given set. Repetition of
 * characters is allowed.
 * 
 * @author Ravali
 *
 */
public class PrintAllPossibleStrings {

	public static char[] currentString = null;
	public static void printAllStrings(char[] input, int currentStringIndex, int requiredLength) {
		
		if(requiredLength <= 0) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < currentString.length; ++i) {
				sb.append(currentString[i]);
			}
			System.out.println(sb.toString());
			return;
		}
		
		int acutalCurrentStringIndex = currentStringIndex;
		for(int i = 0; i < input.length;) {
			currentStringIndex = acutalCurrentStringIndex;
			currentString[currentStringIndex++] = input[i++];
			printAllStrings(input, currentStringIndex, requiredLength-1);
		}
		
	}
	
	public static void main(String[] args) {

		char[] input = new char[] {'a', 'b'};
		int k = 3;
		
		currentString = new char[k];
		printAllStrings(input, 0, k);
		
	}

}
