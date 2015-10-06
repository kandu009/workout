package dp;

/**
 * http://www.geeksforgeeks.org/maximum-weight-transformation-of-a-given-string/
 * 
 * 
 * Given a string consisting of only A’s and B’s. We can transform the given
 * string to another string by toggling any character. Thus many transformations
 * of the given string are possible. The task is to find Weight of the maximum
 * weight transformation.
 * 
 * Weight of string = Weight of total pairs + weight of single characters -
 * Total number of toggles.
 * 
 * Two consecutive characters are considered as pair only if they are different.
 * Weight of a single pair (both character are different) = 4 
 * Weight of a single character = 1
 * 
 * @author Ravali
 *
 */
public class StringMaximumWeightTransformation {

	public static int[] table = null;
	
	public static int getMaxWeight(char[] input, int startIndex) {
		
		if(startIndex >= input.length) {
			return 0;
		}
		
		int maxWeight = 1 + getMaxWeight(input, startIndex+1);
		if(startIndex+1 < input.length) {
			if(input[startIndex] != input[startIndex+1]) {
				maxWeight = Math.max(maxWeight, 4+getMaxWeight(input, startIndex+2));
			} else {
				maxWeight = Math.max(maxWeight, 3+getMaxWeight(input, startIndex+2));
			}
		}
		table[startIndex] = maxWeight;
		
		return maxWeight;
	}

	public static void main(String[] args) {

		char[] input = new String("AAB").toCharArray();
		table = new int[input.length];
		
		System.out.println(getMaxWeight(input, 0));
		
	}

}
