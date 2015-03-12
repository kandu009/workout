package practise;

import java.util.ArrayList;
import java.util.HashSet;

public class FindPair {

	static boolean hasPairWithSum(ArrayList<Integer> arr, int sum) {
		
		if(arr == null || arr.size() <= 0) {
			return false;
		}
		
		HashSet<Integer> tempSet = new HashSet<Integer>();
		tempSet.addAll(arr);
		for(int a : arr) {
			if(tempSet.contains(sum-a) && (sum-a) != a) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(3);
		a.add(5);
		a.add(8);
		a.add(2);
		a.add(6);
		int sum = 16;
		
		if(hasPairWithSum(a, sum)) {
			System.out.println("Found Pair");
		} else {
			System.out.println("Pair Not Found");
		}
		
	}

}
