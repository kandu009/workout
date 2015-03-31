package misc;

/**
 * http://www.careercup.com/question?id=24094664
 * 
 * f(619) = 6 * f(99) + f(19) + 100 {Remainder: 13, 100 for 200 - 299} 
 * 
 * so, we are trying to find the number of 2's possible in the highest significant number
 * then, further find the number of 2's in the rest of the number.
 * 
 * @author rkandur
 *
 */
public class Count2sUntilNumber {

	public static int count2s(int n) {
		// Base case
		if (n == 0)
			return 0;

		// 513 into 5 * 100 + 13. [Power = 100; First = 5; Remainder = 13]
		int power = 1;
		while (10 * power < n) {
			power *= 10;
		}
		
		int first = n / power;
		int remainder = n % power;

		// Counts 2s from first digit
		int nTwosFirst = 0;
		if (first > 2)
			nTwosFirst += power;
		else if (first == 2)
			nTwosFirst += remainder + 1;

		// Count 2s from all other digits
		int nTwosOther = first * count2s(power - 1) + count2s(remainder);

		return nTwosFirst + nTwosOther;

	}
	
	public static void main(String[] args) {

		System.out.println(count2s(2));
		
	}

}
