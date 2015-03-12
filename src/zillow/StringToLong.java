package zillow;

/**
 * 
 * @author rkandur
 * 
 *         Class which converts a string to long
 *
 */
public class StringToLong {
	/**
	 * Method to convert from string to long
	 * 
	 * @param s
	 *            : input string
	 * @return: long form of input
	 * @throws NumberFormatException
	 *             when input is not in correct format
	 */
	static long stringToLong(String s) throws NumberFormatException {

		// check if the input has something in it
		if(s.isEmpty()) {
			throw new NumberFormatException("Empty string cannot be converted to a long !!!");
		} 
		// string with just '+' or '-' are invalid
		if (1 == s.length() && (s.startsWith("+") || s.startsWith("-"))) {
			throw new NumberFormatException("Invalid long value specified in the string {" + s + "}.");
		} 
		
		long result = 0;	
		boolean startsWithSign = (s.startsWith("+") || s.startsWith("-"));
		int power =  startsWithSign ? s.length()-2 : s.length()-1;	// adjust the length based on the first character i.e., digit or a sign
		
		for(int i = startsWithSign ? 1 : 0; i < s.length(); ++i) {
			
			char c = s.charAt(i);
			if(c < 48 || c > 57) {
				// characters other than 0 to 9
				throw new NumberFormatException("Invalid digit specified in the given string {" + s + "}.");
			}
			
			int currDigit = c - 48;
			result += currDigit*(pow(10,power));
			--power;
		}
		
		// negate the result if necessary
		return startsWithSign && s.startsWith("-") ? -result : result;
		
	}

	
	/**
	 * Helper method to calculate the base^exponent value
	 * 
	 * @param base
	 * @param exponent
	 * @return base^exponent value
	 */
	private static long pow(int base, int exponent) {
		
		if(0 == exponent) {
			// anything to power of 0 = 1
			return 1;
		}
		if(0 == base) {
			// 0 power to anything is a 0 
			return 0;
		}
		
		long result = 1;
		while(exponent > 0) {
			result *= base;
			--exponent;
		}
		
		return result;
	}


	static void test() {

//		 all the test cases that i used are mentioned below
		
		long i = stringToLong("123"); 						// checked against 123
//		long i = stringToLong("+123");						// checked against +123
//		long i = stringToLong("-123");						// checked against -123
//		long i = stringToLong("+");							// throws exception
//		long i = stringToLong("-");							// throws exception
//		long i = stringToLong("+0");						// checked against 0, +0, -0
//		long i = stringToLong("-0");						// checked against 0, +0, -0
//		long i = stringToLong("+a1");						// throws exception
//		long i = stringToLong("-0a");						// throws exception
//		long i = stringToLong("1j1");						// throws exception
//		long i = stringToLong("-1ks");						// throws exception
//		long i = stringToLong("-1jsa");						// throws exception
//		long i = stringToLong("a12");						// throws exception
//		long i = stringToLong("");							// throws exception
//		long i = stringToLong("9223372036854775807");		// throws exception
//		long i = stringToLong("-9223372036854775807");		// throws exception
//		long i = stringToLong("+9223372036854775807");		// throws exception
//		long i = stringToLong("9223372036854775808");		// this will give a value equal to -9223372036854775808 because of overflow
//		long i = stringToLong("-9223372036854775808");		// compared against -9223372036854775808
//		long i = stringToLong("+9223372036854775808");		// this will give a value equal to -9223372036854775808 because of overflow
		
		 if (i == 123) {
			 System.out.println("SUCCESS");
		 } else {
			 System.out.println("FAILED");
		 }
	}
	
	public static void main(String[] args) {
		test();
	}

}
