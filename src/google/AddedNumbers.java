package google;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * http://www.careercup.com/question?id=5717521992777728
 * I came across this problem online.
 * > Given an integer:N and an array int arr[], you have to add some
 * > elements to the array so that you can generate from 1 to N by using
 * > (add) the elements in the array.
 * 
 * you can only use each element in the array once when generating a  
 * certain x (1<=x<=N). Return the count of the least adding numbers.
 * 
 * For example:
 * N=6, arr = [1, 3]
 * 1 is already in arr.
 * add 2 to the arr.
 * 3 is already in arr
 * 4 = 1 + 3
 * 5 = 2 + 3
 * 6 = 1 + 2 + 3
 * So we return 1 since we only need to add one element which is 2.
 */

public class AddedNumbers {

  private static int getAddedNumbers(ArrayList<Integer> inputList, int lastNumber) {
    
     ArrayList<Integer> addedNumbers = new ArrayList<Integer>();
     int cumulativeSum = 0;
     int numberofAddedNumbers = 0;
     int size = inputList.size();
     int i = 0;
     
     /**
      * We are assuming the input array is sorted.
      * The main logic is that, Sort the numbers and traverse from 
      * starting keeping a cumulative sum of numbers found so far
      * (including numbers added). 
      * 
      * At any point the cumulative sum value means that we can 
      * generate numbers up to cumulative sum with the numbers so far present 
      * in the set.
      */
     
     // If the lastNumber given falls within cumulative value, we return.
     while( i < size || cumulativeSum < lastNumber ) {
        
       // If the next array element is higher than cumulative, then we add a 
       // number +1 higher than cumulative to set and add this to cumulativeSum.
       if ( i >= size || inputList.get(i) > cumulativeSum+1 ) {
         // we only add numbers, when either array elements are over
         // or the next array element is higher than cumulativeSum.
         int numAdded = cumulativeSum+1;
         addedNumbers.add(numAdded);
         cumulativeSum +=  numAdded;
         numberofAddedNumbers++;
       } else {
         // If the next array element is smaller than cumulativeSum, then we just
         // add the value to cumulativeSum and proceed forward in the array.
         cumulativeSum += inputList.get(i);
         ++i;
       }
     }
     
     StringBuilder numbers = new StringBuilder();
     for(int a : addedNumbers) {
        numbers.append(a).append(",");
     }
     System.out.println("Added numbers are: " + numbers.toString()); 
     
     return numberofAddedNumbers;
    
  }  
  
  public static void main(String[] args) {
  
     int lastNumber = 10;
     ArrayList<Integer> inputList = new ArrayList<Integer>(Arrays.asList(1, 3));
     System.out.println(getAddedNumbers(inputList, lastNumber)); 
    
  }

}

