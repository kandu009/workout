package todo;


//TODO : do without creating strings i.e with character array
public class PermutationsOfString {

	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	private static void permutationConstantSpace(char[] string, int start, int end) {
		
		if(start == end) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < string.length; ++i) {
				sb.append(string[i]);
			}
			System.out.println(sb.toString());
			return;
		}
		
		for(int i = start; i <= end; ++i) {
			swap(string, start, i);
			permutationConstantSpace(string, start+1, end);
			swap(string, start, i);
		}
		
	}
	
	private static void swap(char[] string, int start, int i) {

		char temp = string[start];
		string[start] = string[i];
		string[i] = temp;
		
	}

	// constant space
	private static void permutationConstantSpace(String string) {
		permutationConstantSpace(string.toCharArray(), 0, string.length()-1);
	}
	
	public static void main(String[] args) {
//		permutation("abcde");
		permutationConstantSpace("abc");
	}

}
