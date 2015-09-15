package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * http://www.careercup.com/question?id=6318635089920000
 * 
 * Given a keyboard with every letter maps a digit from 0 to 9, return all
 * possible permutation of given a n digit number.
 * 
 * eg. 
 * 		0 <- z,a,q,x,s,w 
 * 		1 <- c,d,e 
 * 		2 <- v,f,r 
 * 		3 <- b,g,t ... 
 * Then permutation of num 1230 will be: 
 * cvbz 
 * cvba 
 * cvbq
 * ...
 * 
 * Solution:
 * 
 * We take a character array which will be used to store all the 
 * combinations one by one. i.e., we keep replacing the characters 
 * of that array for every new combination that we generate.
 * This will only use a constant space.
 * 
 * @author Ravali
 *
 */
public class NumberToAllLetterCombinations {

	public static ArrayList<String> result_ = new ArrayList<String>();
	
	public static HashMap<Integer, ArrayList<Character>> numberToCharMap_ = new HashMap<Integer, ArrayList<Character>>();
	
	public static void init() {
		numberToCharMap_.put(0, new ArrayList<Character>(Arrays.asList('z','a','q','x','s','w')));
		numberToCharMap_.put(1, new ArrayList<Character>(Arrays.asList('c','d','e')));
		numberToCharMap_.put(2, new ArrayList<Character>(Arrays.asList('v','f','r')));
		numberToCharMap_.put(3, new ArrayList<Character>(Arrays.asList('b','g','t')));
	}
	
	public static void getAllCombinations(int[] input, int index, Character[] combination) {
		// if the entire input is scanned for this combination.
		// just print/store the value.
		if(index >= input.length) {
			if(combination != null && combination.length != 0) {
				String comb = new String();
				for(int i = 0; i < combination.length; ++i) {
					comb = comb.concat(""+combination[i]);
				}
				result_.add(comb);
			}
			return;
		}
		// for the current digit in input, use all the combinations
		// of characters.
		for(Character c : numberToCharMap_.get(input[index])) {
			// Fill the current digit character and generate the other combinations.
			combination[index] = c;
			getAllCombinations(input, index+1, combination);
		}
	}
	
	public static void main(String[] args) {

		init();
		
		int[] input = new int[] { 1,  2, 3, 0 };
		Character[] combination = new Character[input.length];
		
		getAllCombinations(input, 0, combination);
		
		for(String s : result_) {
			System.out.println(s);
		}
		
	}

}
