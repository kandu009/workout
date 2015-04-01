package todo;

import java.util.Arrays;
import java.util.HashSet;

/**
 * ab(cd)e(fg)h
 * @author rkandur
 *
 */
public class ExpressionExpansionFlipkart {
	
	public static class MyInteger {
		
		Integer i_;
		
		public MyInteger(int i) {
			i_ = i;
		}
		
		public void increment() {
			++i_;
		}
	}
	
	private static HashSet<String> gResult = new HashSet<String>();

	private static HashSet<String> computeProduct(HashSet<String> set1, HashSet<String> set2) {
		HashSet<String> newSet = new HashSet<String>();
		for(String s1 : set1) {
			for(String s2 : set2) {
				newSet.add(s1+s2);
			}
		}
		return newSet;
	}
	
	private static HashSet<String> computeProduct(HashSet<String> set1, char s2) {
		if(set1.isEmpty()) {
			return new HashSet<String>(Arrays.asList(""+s2));
		}
		HashSet<String> newSet = new HashSet<String>();
		for(String s1 : set1) {
			newSet.add(s1+s2);
		}
		return newSet;
	}
	
	private static HashSet<String> parser(String input, MyInteger index, HashSet<String> result) {
		while(index.i_ < input.length()) {
			if(input.charAt(index.i_) == '(') {
				index.increment();
				HashSet<String> set = parser(input, index, result);
				result = computeProduct(result, set);
			} else if(input.charAt(index.i_) == ')') {
				index.increment();
				gResult.addAll(result);
				result.clear();
				return gResult;
			} else {
				result = computeProduct(result, input.charAt(index.i_));
			}
			index.increment();
		}
		return result;
	}
	
	public static void main(String[] args) {

		String s = "ab(cd)ef(gh)i";
		HashSet<String> result = new HashSet<String>();
		result = parser(s, new MyInteger(0), result);
		System.out.println(result.toString());
		
	}

}
