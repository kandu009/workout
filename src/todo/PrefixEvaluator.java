package todo;
/*
public class PrefixEvaluator {

	private static int calculate(int i, int j, char op) {
		int result = -1;
		switch(op) {
			case '+' : { result = i + j; break; }
			case '-' : { result = i - j; break; }
			case '*' : { result = i * j; break; }
			case '/' : { result = i / j; break; }
			default: {
				break;
			}
		}
		return result;
	}
	
	private static int calculatePrefixExpression(String exp) {
		
		if(exp.isEmpty()) {
			return -1;
		}
		
		char op = exp.charAt(0);
		int left = 0;
		int right = 0;
		
		
		if(op == '(') {
			return calculatePrefixExpression(exp.substring(1, exp.indexOf(')')));
		}
		
		switch(op) {
			case '+' : 
			case '-' :
			case '*' :
			case '/' : {
				// do nothing
			}
			default: {
				break;
			}
		}
	
		if(left != 0 && right != 0) {
			return calculate(left, right, op);
		}
		if(0 == left) {
			return (0 == right) ? Integer.parseInt(exp) : right;
		}
		
	}
	
	public static void main(String[] args) {

	}

}
*/