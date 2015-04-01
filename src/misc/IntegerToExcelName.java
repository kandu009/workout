package misc;


public class IntegerToExcelName {

	private static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for(int j = s.length()-1; j >= 0; --j) {
			sb.append(s.charAt(j));
		}
		return sb.toString();
	}
	
	private static String getAlphaNameFor(int n) {
		if(n < 0 || n > 25) {
			return "NOOP";
		}
		char c = (char) (n + 65);
		return new StringBuilder().append(c).toString();
	}
	
	public static String getExcelName(int n) {
		int temp = n;
		StringBuilder sb = new StringBuilder();
		while(temp > 25) {
			sb.append(getAlphaNameFor(temp%26));
			temp = temp/26-1;
		}
		sb.append(getAlphaNameFor(temp));
		
		return reverse(sb.toString());
	}
	
	public static void main(String[] args) {
		System.out.println(getExcelName(6766));
	}
}
