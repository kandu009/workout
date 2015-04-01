package misc;

public class CountSeries {
	
	public static char DUMMY = 'X';

	public static String generateCountSeries(int n) {
		
		if(n == 0) {
			return "1";
		}
		
		String pattern = generateCountSeries(n-1);
		char previous = DUMMY;
		int count = 0;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < pattern.length(); ++i) {
			char current = pattern.charAt(i);
			if(previous != current) {
				if(previous != DUMMY) {
					sb.append(count).append(previous);
				}
				previous = current;
				count = 1;
			} else {
				++count;
			}
		}
		
		sb.append(count).append(previous);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(generateCountSeries(5));
	}

}
