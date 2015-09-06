package google;

/**
 * http://www.careercup.com/question?id=5668664122540032
 * 
 * Given n light bulbs, write two methods. 
 * 
 * isOn(i)              -> to determine if i'th light bulb is on
 * toggle(start, end)   -> toggle all the light bulbs in the range
 * 
 * *********** toggle should take < O(n) ******************
 * 
 * Solution:
 * 
 * When we need to toggle range (s,e), 
 *   add +1 to cell s, and -1 to cell e+1.
 * To check state of i'th cell, we need to know the cumulative sum from 1 to i.
 *  If sum is even, then the bulb is toggled even number of times => OFF
 *  If sum is odd, then the bulb is toggled odd number of times => ON
 * 
 */
public class ToggleBulbs {
  
  // Assuming that we have a max number of bulbs given.
  public static int maxBulbs_ = 10;
  public static int[] bulbs_ = new int[maxBulbs_];
  
  private static void init() {
    for(int i = 0; i < maxBulbs_; ++i) {
      bulbs_[i] = 0;
    }
  }
  
  public static boolean isOn(int iBulb) {
    int leftSum = 0;
    for (int i = 0; i < iBulb; ++i) {
      leftSum += bulbs_[i];
    }
    if(leftSum%2 == 1) {
      System.out.println("True"); 
      return true;
    }
    System.out.println("False");
    return false;
  }
  
  public static void toggle(int startBulb, int endBulb) throws Exception {
    
    bulbs_[startBulb-1] += 1;
    if(endBulb > maxBulbs_) {
      throw new Exception("Useless !!!");
    }
    if(endBulb < maxBulbs_) {
      bulbs_[endBulb] -= 1;
    }
    
  }
  
  public static void main(String[] args) {
    init();
    try {
      toggle(3, 9);
      toggle(2, 5);
      toggle(1, 4);
      toggle(1, 10);
      
      isOn(3);
      isOn(10);
      isOn(7);
      isOn(2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
}

