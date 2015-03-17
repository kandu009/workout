package misc;

/**
 * http://www.careercup.com/question?id=5454925876166656
 * 
 * In a^b = n
 * Use log(n)/log(a) to see if the value is an integer ~= b
 * 
 */
public class PerfectPower {

	private static boolean isPerfectPower(int n) {
		
		if(n == 1) {
			return true;
		}
		
		double dn = Math.log(n);
		double temp = 0;
		for(int i = 2; i < Math.sqrt(n); ++i) {
			 temp = dn/Math.log(i);
			 if(Math.abs(Math.round(temp) - temp) < 0.000001) {
				 return true;
			 }
		}
		return false;
		
	}
	
	public static void main(String[] args) {

		if(isPerfectPower(124)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
