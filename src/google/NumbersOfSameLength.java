package google;

import java.util.TreeSet;

/**
 * http://www.careercup.com/question?id=5085262709260288
 */
public class NumbersOfSameLength {
  
  private static int[][] lengthTwoResults = 
    {{ 4,5,6,7,8,9 },
    { 5,6,7,8,9},
    { 6,7,8,9 },
    { 7,8,9 },
    { 0,8,9 },
    { 0,1,9 },
    { 0,1,2 },
    { 0,1,2,3 },
    { 0,1,2,3,4 },
    { 0,1,2,3,4,5 }
    };
  
  private static TreeSet<String> resultSet = new TreeSet<String>();
  private static int[][] dpLength;
  
  public static void getNumbersOfSameLengthRecursive(
      String prefix, int currentDigit, int n) {
    
    if (n <= 0) {
      resultSet.add(prefix);
    } else if(n == 1) {
      for(int i : lengthTwoResults[currentDigit]) {
      resultSet.add(new StringBuilder().append(prefix).append(i).toString());
      }
    } else {
      for(Integer i : lengthTwoResults[currentDigit]) {
        getNumbersOfSameLengthRecursive(prefix.concat(i.toString()), i, n-1);
      }
    }
    
  }

  public static int getCountOfNumbersOfSameLengthRecursion(int currentDigit, int n) {
    
    if (n <= 0) {
      return 1;
    } else if(n == 1) {
      return lengthTwoResults[currentDigit].length;
    } else {
      int count = 0;
      for(Integer i : lengthTwoResults[currentDigit]) {
        count += getCountOfNumbersOfSameLengthRecursion (i, n-1);
      }
      return count;
    }
    
  }
  
  public static int getCountOfNumbersOfSameLengthDP(int prefix, int n) {

    if (n <= 0) {
      return 1;
    } else if(n == 1) {
      return lengthTwoResults[prefix].length;
    }
    
    for (int i = 0; i <= n; ++i) {
      dpLength[0][i] = 0;
    }
    for (int i = 0; i <= 9; ++i) {
      dpLength[i][0] = 1;
    }
    
    int count = 0;
    for(int i = 0; i <= 9; ++i) {
      count += getCountOfNumbersOfSameLengthDP(i, n-1);
    }
    dpLength[prefix][n] = count;
    return count;
    
  }
  
  public static void main(String[] args) {
    
    int length_of_numbers = 3;
    
    dpLength = new int[length_of_numbers+1][10]; 
    
//    for(int i = 1; i <= 9; ++i) {
//      getNumbersOfSameLengthRecursive(new StringBuilder().append(i).toString(), i, length_of_numbers-1);
//      //System.out.println("After digit " + i + "elements are " + resultSet.toString()); 
//    }
//    System.out.println("Total size of the numbers is(using recursion) " + resultSet.size());
//    
//    int count = 0;
//    for(int i = 1; i <= 9; ++i) {
//      count += getCountOfNumbersOfSameLengthRecursion(i, length_of_numbers-1);
//    }
//    System.out.println("Count of the numbers (using Recursion) " + count);
//    
    int count = 0;
    for(int i = 1; i <= 9; ++i) {
      count += getCountOfNumbersOfSameLengthDP(i, length_of_numbers-1);
    }
    System.out.println("Count of the numbers (using DP) " + count);
    
  }
}

