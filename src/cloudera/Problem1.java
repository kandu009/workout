package cloudera;

import java.util.ArrayList;
import java.util.Collections;

public class Problem1 {

	public static int solution(int[] A, int[] B) {
		
		ArrayList<Integer> lA = new ArrayList<Integer>();
		for(int i : A) {
			lA.add(i);
		}

		ArrayList<Integer> lB = new ArrayList<Integer>();
		for(int i : B) {
			lB.add(i);
		}
		
		Collections.sort(lA);
		Collections.sort(lB);
		
		for(int i = 0, j=0; i < lA.size() && j < lB.size();) {
			
			if(lA.get(i) == lB.get(j)) {
				return lA.get(i);
			} 
			if(lA.get(i) < lB.get(j)) {
				if(i == lA.size()-1) { 
					++j; 
				} else {
					++i;
				}
			} else {
				if(j == lB.size()-1) { 
					++i; 
				} else {
					++j;
				}
			}
		}
		
		return -1;
    }
	
	
	public static void main(String[] args) {
		int[] A = {1, 2};
		int[] B = {2};
		System.out.println(solution(A, B));

	}

}
