package hackerrank;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast 
 * 
 * Print the largest 'Decent Number' having n digits. 
 * If no such number exists, print -1.
 * 
 * A Decent Number has the following properties:
 * 
 * - 3, 5, or both as its digits. No other digit is allowed. 
 * - Number of times 3 appears is divisible by 5. 
 * - Number of times 5 appears is divisible by 3.
 * 
 * @author Ravali
 *
 */
public class FindHighestDecentNumber {

	public static void printHighestDecentNumber(int n) {

		if(n <= 2) {
			System.out.println("-1");
		}
		
		int numberOf3s = 0;
        int numberOf5s = 0;
        while(true) {
            if(n%3 == 0) {
                numberOf5s += n;
                break;
            }
            if(n%5 == 0) {
                numberOf3s += n;
                break;
            }
            n = n-3;
            if(n%5 == 0) {
                numberOf3s += n;
                numberOf5s += 3;
                break;
            }
            n = n+3-5;
            if(n%3 == 0) {
                numberOf5s += n;
                numberOf3s += 5;
                break;
            }
        }
        
        StringBuilder out = new StringBuilder();
        if(numberOf3s == 0 && numberOf5s == 0) {
            out.append("-1");
        } else  {
            for(int i = 0; i < numberOf5s; ++i) {
                out.append("5");
            }
            for(int i = 0; i < numberOf3s; ++i) {
                out.append("3");
            }
        }
        System.out.println(out);
	}
	
    public static void main(String[] args) {

    	int numberOfDigits = 11;
    	printHighestDecentNumber(numberOfDigits);
    	
    }

}
