package practise;

public class ReverseSentenceString {

	public static void main(String[] args) {
		String str = "I wish you a merry Christmas";
		System.out.println(getReverseSentenceString(str.toCharArray()));
		
	}

	private static char[] getReverseSentenceString(char[] input) {
		
		int size = input.length; 
		for(int i = 0; i < size/2; ++i) {
			swap(input, i, size-i-1);
		}
		
		int start = 0;
		int end = 0;
		for(int j = 0; j < size; ++j) {
			if(input[j] == ' ') {
				end = j-1;
				reverse(input, start, end);
				start = j+1;
			}
		}
		
		return input;

	}

	private static void reverse(char[] input, int start, int end) {
		
		if(start == end) {
			return;
		}
		
		for(int i = start, j =end; i<j;  ++i, --j) {
			swap(input, i, j);
		}
	}

	private static void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
