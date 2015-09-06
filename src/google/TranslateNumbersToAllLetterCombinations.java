package google;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * http://www.careercup.com/question?id=19300678
 *
 * If a=1, b=2, c=3,....z=26. 
 * Given a string, find all possible codes that string can generate. Give
 * a count as well as print the strings.
 *
 * Example:
 * 
 * Input: "1123". You need to general all valid alphabet codes from this string.
 * 
 * aabc //a = 1, a = 1, b = 2, c = 3
 * kbc // since k is 11, b = 2, c= 3
 * alc // a = 1, l = 12, c = 3
 * aaw // a= 1, a =1, w= 23
 * kw // k = 11, w = 23
 *
 * Solution:
 * Scan through the characters in the string recursively, 
 * Always decoding one/two characters (where possible).
 *
 */
public class TranslateNumbersToAllLetterCombinations {
  
  public static void printAllCombinations(String input, ArrayList<Character> charArray, int index) {
    
    if(index >= input.length()) { // Base case, we reached end of the string.
      ++count_;
      StringBuilder s = new StringBuilder();
      for(char c : charArray) {
         s.append(c);
      }
      System.out.println(s.toString()); 
    } else { // We have more characters to go until we reach the end.
      
      // This is the possibility to consider just the number at the current 
      // index as the valid number to represent a character in the decoded 
      // string. We update the final charArray for current index and recursive
      // work on the next part of the input.
      Character c1 = intToCharMap_.get(Integer.parseInt(input.charAt(index)+""));
      charArray.add(c1);
      printAllCombinations(input, charArray, index+1);
      
      // remove the previous decoded character, for considering a character
      // which could be formed using 2 digits.
      charArray.remove(charArray.size()-1);
      if(index+1 < input.length()) {
        // Get the character representing the 2 digit number.         
        int nextCode = Integer.parseInt(input.substring(index, index+2));
        // If < 26, then we have our next decoded character, then move forward.
        if(nextCode <= 26) {
          Character c2 = intToCharMap_.get(nextCode);
          charArray.add(c2);
          printAllCombinations(input, charArray, index+2);
          // Remove the last decoded character.  
          charArray.remove(charArray.size()-1);
        }
      }
    }   
  }
  
  private static void init() {
    Character alphabet = 'a';
    for(int i = 1; i <=26; ++i) {
      intToCharMap_.put(i, alphabet);
      ++alphabet;
    }
  }
  
  public static int count_ = 0;
  public static TreeMap<Integer, Character> intToCharMap_ = new TreeMap<Integer, Character>();
  
  public static void main(String[] args) {
    
    init();
    
    String input = new String("1123");
    ArrayList<Character> charArray = new ArrayList<Character>(input.length());
    int index=0;
    
    printAllCombinations(input, charArray, index);
    
    System.out.println("Number of combinations: " + count_); 
    
  }

}

