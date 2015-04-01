package dp;

import javafx.util.Pair;

/** consecutive elements difference should not be more than 6 **/

public class MaximumSumInArray {

	public static Pair<Integer, Integer> getSubArrayWithMaximumSum(int[] A) {
		
		if(A.length < 1) {
			return new Pair<Integer, Integer>(-1,-1);
		}
		
		int sumGlobal = A[0];
		int gs = 0;
		int ge = 0;
		
		int sumLocal = A[0];
		int ls = 0;
		int le = 0;
		
		int prevLocal = sumLocal;
		
		for(int i = 1; i < A.length; ++i) {
			
			if(Math.abs(A[i] - A[i-1]) > 6) {
				++ls;
				i = ls;
				le = ls;
				sumLocal = A[ls];
				if(sumLocal > sumGlobal) {
					sumGlobal = sumLocal;
					gs = ls;
					ge = le;
				}
			} else {
				
				prevLocal = sumLocal;
				sumLocal += A[i];
				
				if(prevLocal > sumLocal) {
					++ls;
					i = ls;
					le = ls;
					sumLocal = A[ls];
					if(sumLocal > sumGlobal) {
						sumGlobal = sumLocal;
						gs = ls;
						ge = le;
					}
				} else {
					if(sumLocal > sumGlobal) {
						le = i;
						sumGlobal = sumLocal;
						gs = ls;
						ge = le;
					}
				}
			}
		}
		
		return new Pair<Integer, Integer>(gs, ge);
	}
	
	public static void main(String[] args) {

		int[] A = new int[] { -3, -1, 2, 4, 6, -2, -4, -6, 1, 3, 5, 7, 8, -6, -15 };
		System.out.println(getSubArrayWithMaximumSum(A).toString());
		
	}

}
