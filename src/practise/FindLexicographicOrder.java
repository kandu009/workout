package practise;

import java.util.ArrayList;

public class FindLexicographicOrder {

	public static int MAX_LENGTH = 4;
	public static void main(String[] args) {

		ArrayList<String> words = new ArrayList<String>();
		words.add("abef");
		words.add("acef");
		words.add("acfg");
		words.add("achi");
		words.add("bcd");
		words.add("bed");
		words.add("bgk");
		
		/*char[][] words = new char[][] 	
				{
					{'b','e','z','a','m'},
					{'b','e','z','a','n'},
					{'b','e','z','a','o'},
					{'b','e','z','a','p'},
					{'a','s','d','s','a'},
					{'a','s','d','s','b'},
					{'a','s','d','s','c'},
					{'z','a','d','s','a'},
					{'d','e','a','x','z'}
				};
*/
		ArrayList<ArrayList<Character>> individualOrders = generateIndividualOrders(words);
		
		lexiOrderFinder(individualOrders, 0);
	}
	
	private static ArrayList<ArrayList<Character>> generateIndividualOrders(ArrayList<String> words) {
		
		ArrayList<ArrayList<Character>> al = new ArrayList<ArrayList<Character>>();
		
		ArrayList<Character> temp = new ArrayList<Character>();
		
		for(int i = 0; i < MAX_LENGTH; ++i) {
		
			temp = new ArrayList<Character>();
			String prevWord = new String();
			Character prevChar = null;
			
			for(String w : words) {
				
				if(i >= w.length()) {
				
					prevWord = "";
					prevChar = null;
					
					if(temp.size() > 1) {
						al.add(temp);
						temp.clear();
					} else {
						temp.clear();
					}
					
					continue;
				}
				
				if(i == 0) {
					if(prevChar == null || prevChar != w.charAt(i)) {
						temp.add(w.charAt(i));
						prevChar = w.charAt(i);
					}
					
				} else {
					
					if(prevWord.isEmpty()) {
						temp.add(w.charAt(i));
						prevWord = w;
						prevChar = w.charAt(i);
						continue;
					}
					
					if(prevWord.length() < i) {
						
						prevWord = "";
						prevChar = null;
						
						if(temp.size() > 1) {
							al.add(temp);
							temp.clear();
						} else {
							temp.clear();
						}
						
						continue;
						
					}
					
					if(w.substring(0, i).equals(prevWord.substring(0, i))) {
						
						if(prevChar == null || prevChar != w.charAt(i)) {
							temp.add(w.charAt(i));
						}
						prevWord = w;
						prevChar = w.charAt(i);
						
					} else {
											
						if(temp.size() > 1) {
							al.add(temp);
							temp.clear();
						} else {
							temp.clear();
						}
						
						if(i < w.length()) {
							temp.add(w.charAt(i));
							prevWord = w;
							prevChar = w.charAt(i);
							continue;
						} else {
							prevWord = "";
							prevChar = null;
						}
						
					}
				}
			}
			if(temp.size() > 1) {
				al.add(temp);
			}
			
		}
		
		return al;
		
	}

	private static void lexiOrderFinder(ArrayList<ArrayList<Character>> individualOrders, int index) {
		
		/*char[] A = new char[individualOrders.length];
		int k = 0;
		
		for(int i = 0; i < individualOrders.length && k < individualOrders.length; ++i) {
			if(A[k-1] != individualOrders[i][0]) {
				A[k] = individualOrders[i][0];
				++k;
			}
		}
		
		for(int j = 0; j < A.length; ++j) {
			System.out.println(A[j]);
		}*/
	}

}
