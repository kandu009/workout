package todo;

import java.util.LinkedHashSet;
import java.util.Set;

import javafx.util.Pair;

/**
 * http://www.careercup.com/question?id=5090137058836480
 * 
 * show the recurring part of the decimal in brackets as shown below
 * 
 * 1, 3 = 0,(3)
 * 2, 4 = 0.5 (0)
 * 22, 7 = 3.(1415)
 * 
 *TODO : Not working ************************************
 * @author rkandur
 *
 */
public class DecimalRepresentationOfRationalNumbers {

	private static Pair<Integer, Integer> getDividentRemainder(int num, int denom) {
		return new Pair<Integer, Integer>(num/denom, num%denom);
	}
	
	private static String getDecimalRepresentation(int num, int denom) {
		
		Integer character = num/denom;
		Integer remainder = num%denom; 
		Set<Integer> remainders = new LinkedHashSet<Integer>();
		StringBuilder decimal = new StringBuilder();

		StringBuilder result = new StringBuilder();
		result.append(character).append(".");
		
		while(remainder != 0) {
			if(remainders.contains(remainder)) {
				decimal.append("(").append(decimal.toString());
				break;
			} else {
				remainders.add(remainder);
			}
			remainder *= 10;
			Pair<Integer, Integer> dr = getDividentRemainder(remainder, denom);
			remainder = dr.getValue();
			decimal.append(dr.getKey());
		}
		
		if(remainder != 0) {
			result.append(decimal).append(")");
		}
		
		return result.toString();
	}
	
	private static Object toString(Set<Integer> remainders) {
		StringBuilder sb = new StringBuilder();
		for(Integer i : remainders) {
			sb.append(i);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getDecimalRepresentation(1, 3));
	}

}
