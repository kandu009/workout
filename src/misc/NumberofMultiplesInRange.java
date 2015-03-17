package misc;

public class NumberofMultiplesInRange {

	
	public static void main(String[] args) {
	
		int a = 2;
		int b = 500;
		int n = 49;
		int i = a;
		
		for(; i<=b; ++i) {
			if(i%n == 0) {
				break;
			}
		}
		
		System.out.println(((b-i)/n)+1);
		
	}


}
