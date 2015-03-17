package misc;

/**
 * http://www.careercup.com/question?id=5680043955060736
 * 
 * @author rkandur
 *
 */
public class PrintNumbersInStringComparisonOrder {

	static void printNumbers(String str, int n){
		
		if(Integer.parseInt(str) > n) {
			return;
		}
		
		System.out.println(str);
		for(int i=0;i<10;i++) {
			printNumbers(str+i,n);
		}
		
	}

	public static void main(String[] args) {

		int n = 1000;
    	for(int i = 1; i <= 10; ++i) {
    		printNumbers(""+i, n);
    	}
    	
	}

}
