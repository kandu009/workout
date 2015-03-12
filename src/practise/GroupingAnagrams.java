package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/** 
 * http://www.careercup.com/question?id=5723872416497664 
 * Given a list of strings, return a list of lists of strings that groups all anagrams.
 * Ex. given {trees, bike, cars, steer, arcs}
 * return { {cars, arcs}, {bike}, {trees, steer} } 
**/
public class GroupingAnagrams {

	/**
	 * idea here for the hash function is run length encoding with a twist of
	 * course: "ABCAGR" MAPS to "A2B1C1G1R1" and so is "RABCAG". Order of the
	 * letters does not matter as we generate the hash code in alphabetical
	 * order The way to approach to this is to use a temporary character counter
	 * array and use that counter to generate the hash.
	 */
	private static String computeHash(String word) {

		int[] charCount = new int[26];
		char[] chr = word.toCharArray();
		
		for(int i = 0; i < chr.length; ++i) {
			charCount[chr[i] - 'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < charCount.length; ++i) {
			sb.append((char) (i + 'a') + "" + charCount[i]);
		}
		
		return sb.toString();
	}
	
	private static void groupAnagrams(ArrayList<String> input) {
		
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		for(String i : input) {
			String hc = computeHash(i);
			if(hm.containsKey(hc)) {
				ArrayList<String> temp = hm.get(hc);
				temp.add(i);
				hm.put(hc, temp);
			} else {
				hm.put(hc, new ArrayList<String>(Arrays.asList(i)));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(String hc : hm.keySet()) {
			sb.append("{");
			for(String v : hm.get(hc)) {
				sb.append(v).append(",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("}");
		}
		sb.append("}");
		
		System.out.println(sb.toString());
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> input = new ArrayList<String>();
		input.add("trees");
		input.add("cars");
		input.add("bike");
		input.add("arcs");
		input.add("steer");
		
		groupAnagrams(input);
	}

}
