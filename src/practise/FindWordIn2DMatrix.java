package practise;

import java.util.HashSet;
import java.util.Iterator;

import javafx.util.Pair;

/** www.careercup.com/question?id=5137694256529408 **/

public class FindWordIn2DMatrix {
	
	private static boolean isWithinBounds(int i, int j, int length) {
		if((i >= 0 && i < length) && (j >= 0 && j < length)) {
			return true;
		}
		return false;
	}

	public static HashSet<Pair<Integer, Integer>> getAdjacentItemsFor(char[][] A, int i, int j,  char c) {
		
		HashSet<Pair<Integer, Integer>> hs = new HashSet<Pair<Integer,Integer>>();
		
		if(isWithinBounds(i-1, j-1, A.length) && A[i-1][j-1] == c) {
			hs.add(new Pair<Integer, Integer>(i-1, j-1));
		}
		if(isWithinBounds(i-1, j, A.length) && A[i-1][j] == c) {
			hs.add(new Pair<Integer, Integer>(i-1, j));
		}
		if(isWithinBounds(i-1, j+1, A.length) && A[i-1][j+1] == c) {
			hs.add(new Pair<Integer, Integer>(i-1, j+1));
		}
		if(isWithinBounds(i, j-1, A.length) && A[i][j-1] == c) {
			hs.add(new Pair<Integer, Integer>(i, j-1));
		}
		if(isWithinBounds(i, j+1, A.length) && A[i][j+1] == c) {
			hs.add(new Pair<Integer, Integer>(i, j+1));
		}
		if(isWithinBounds(i+1, j-1, A.length) && A[i+1][j-1] == c) {
			hs.add(new Pair<Integer, Integer>(i+1, j-1));
		}
		if(isWithinBounds(i+1, j, A.length) && A[i+1][j] == c) {
			hs.add(new Pair<Integer, Integer>(i+1, j));
		}
		if(isWithinBounds(i+1, j+1, A.length) && A[i+1][j+1] == c) {
			hs.add(new Pair<Integer, Integer>(i+1, j+1));
		}
		
		return hs;
	}
	
	public static HashSet<Pair<Integer, Integer>> getLocationsOfChar(char[][] A, char c) {
		
		HashSet<Pair<Integer, Integer>> hs = new HashSet<Pair<Integer,Integer>>();
		for(int i = 0; i < A.length; ++i) {
			for(int j = 0; j < A.length; ++j) {
				if(A[i][j] == c) {
					hs.add(new Pair<Integer, Integer>(i, j));
				}
			}
		}
		return hs;
	}
	
	public static boolean findWord(String word, char[][] A) {
		
		Iterator<Pair<Integer, Integer>> it = getLocationsOfChar(A, word.charAt(0)).iterator();
		while(it.hasNext()) {
			Pair<Integer, Integer> loc = it.next();
			HashSet<Pair<Integer, Integer>> path = new HashSet<Pair<Integer, Integer>>();
			path.add(new Pair<Integer, Integer>(loc.getKey(), loc.getValue()));
			if(findWordHelper(word.substring(1), A, path, loc.getKey(), loc.getValue())) {
				return true;
			}
		}
		
		return false;
	}
	
	private static boolean findWordHelper(String word, char[][] a, HashSet<Pair<Integer, Integer>> path, Integer key, Integer value) {
		
		if(word.isEmpty()) {
			return true;
		}
		
		HashSet<Pair<Integer, Integer>> adj = getAdjacentItemsFor(a, key, value, word.charAt(0));
		if(adj.isEmpty()) {
			return false;
		}
		
		Iterator<Pair<Integer, Integer>> it = adj.iterator();
		while(it.hasNext()) {
			Pair<Integer, Integer> loc = it.next();
			if(path.contains(loc)) {
				continue;
			}
			path.add(new Pair<Integer, Integer>(loc.getKey(), loc.getValue()));
			if(findWordHelper(word.substring(1), a, path, loc.getKey(), loc.getValue())) {
				return true;
			}
		}
		
		return false;
	}
	

	public static void main(String[] args) {
		
		char[][] A = new char[][] {
				{'S', 'T', 'F', 'M'}, 
				{'R', 'U', 'N', 'G'}, 
				{'T', 'A', 'M', 'N'},
				{'E', 'O', 'N', 'I'}};
		
		if(findWord("ARA", A)) {
			System.out.println("Found Word");
		} else {
			System.out.println("Word Not Found");
		}
	}

}
