package cloudera;

import java.util.Stack;

public class Problem2 {

	public static int INT_MAXIMUM = 4095;
	
	public static int solution(String S) {
		
		Stack<Integer> stack = new Stack<Integer>();

		for(char c : S.toCharArray()) {
			
			if(c >= '0' && c <= '9') {
				stack.push(c-'0');
			} else if('+' == c) {
				
				if(stack.size() < 2) {
					return -1;
				}
				int a1 = stack.pop();
				int a2 = stack.pop();
				
				int result = a1 + a2;
				if(result > INT_MAXIMUM) {
					return -1;
				}
				stack.push(result);
				
			} else if('*' == c) {
				
				if(stack.size() < 2) {
					return -1;
				}
				int a1 = stack.pop();
				int a2 = stack.pop();
				
				int result = a1 * a2;
				if(result > INT_MAXIMUM) {
					return -1;
				}
				stack.push(result); 
				
			} else {
				return -1;
			}
		}
		
		return stack.empty() ? -1 : stack.pop();

	}
	
	public static void main(String[] args) {
		System.out.println(solution("22*2*2*2*2*2*2*2*2*2*2*"));
//		System.out.println(solution(""));
	}

}
