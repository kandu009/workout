package vmware;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Find kth lexicographically shorter path to reach from (0,0) to (n,m) in a
 * matrix. Given that we can either move horizontally (H) or vertically (V) from
 * a given point.
 * 
 * For example (0,0) to (2,2), the paths are HHVV HVHV HVVH VVHH Second
 * lexicographically shorter path = HVHV
 * 
 * @author Ravali
 *
 */

public class FindKthLexicographicShortestPath {


	public static TreeSet<String> permutations = new TreeSet<String>();
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) { 
	    	permutations.add(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	public static String[] gridLand(String[] inp) {
		
		String[] ret = new String[inp.length];
		int index = 0;
		
		for(String s : inp) {
			
			String[] toks = s.split(" ");
			
			StringBuilder in = new StringBuilder();
			for(int i = 0; i < Integer.parseInt(toks[0]); ++i) {
				in.append("V");
			}
			for(int j  =0; j < Integer.parseInt(toks[1]); ++j) {
				in.append("H");
			}
			
			permutation(in.toString());
			
			int count = 0;
			System.out.println(permutations.toString());
			Iterator<String> i = permutations.iterator();
			
			while(i.hasNext()) {
				if(count == Integer.parseInt(toks[2])) {
					ret[index] = i.next();
					break;
				}
				++count;
				i.next();
			}
			
			permutations.clear();
			++index;
		}
		
		return ret;
		
    }
	
	public static void main(String[] args) {
		
		String[] inp = new String[] { "5 5 3", "2 2 1"};
		
		String[] ret = gridLand(inp);
		
		for(String s : ret) {
			System.out.println(s);
		}
		
		
	}

}
