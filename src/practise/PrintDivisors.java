package practise;

public class PrintDivisors {

	static void printDivisors(int n){
		System.out.println("1*" + n);
		printDivisors("",1,n);
	}
	
	static void printDivisors(String prefix,int prev,int n) {
		if(n<2)
			return;
		int s = (int) Math.ceil(Math.sqrt(n));
		for(int i = 2;i<=s;i++){
			if(n%i == 0){
				if(i>=prev && n/i>=i){			// awesome condition
					System.out.println(prefix + i + "*" + n/i);
					printDivisors(prefix+i+"*", i, n/i);
				}
			}
				
		}
	}
	
	public static void main(String[] args) {

		printDivisors(12);
	}

}
