package practise;


/**
 * http://www.careercup.com/question?id=5268194222669824
 * 
 * The solution that I wrote doesn't work if array has negative numbers
 */
public class FindMaximumOfArithmeticExpression {

	public static int findMaximumValue(int[] a) {
		return findMaximumValue(a, 0, a.length-1);
	}
	
	private static int findMaximumValue(int[] a, int start, int end) {
		
		if(start == end) {
			return a[start];
		}
		
		if(end-start == 1) {
			return Math.max(a[start]*a[end], a[start]+a[end]);
		}
		
		int maxRet = 0;
		for(int i = start+1; i <= end-1; ++i) {
			int left = findMaximumValue(a, start, i);
			int right = findMaximumValue(a, i+1, end);
			maxRet = Math.max(Math.max(left*right, left+right), maxRet);
		}
		
		return maxRet;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, -3, 2, -1};
		System.out.println(findMaximumValue(a));
	}

}
