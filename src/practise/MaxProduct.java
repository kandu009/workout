package practise;

public class MaxProduct {

	public static void main(String[] args) {

		int[] a = {1, 3, 5, 2, 8, 0, -1, 3};
		
		int firstMax = a[0];
		int secondMax = a[0];
		int thirdMax = a[0];
		
		int firstMin = a[0];
		int secondMin = a[0];
		
		for(int i = 0; i < a.length; ++i) {
			
			if(a[i] == 0) {
				continue;
			}
			
			if(a[i] < thirdMax && a[i] > secondMin) {
				continue;
			} else if(a[i] < firstMin) {
				secondMin = firstMin;
				firstMin = a[i];
			} else if(a[i] > firstMax) {
				if(thirdMax < firstMin) {
					secondMin = firstMin;
					firstMin = thirdMax;
				}
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = a[i];
			} else if (a[i] < firstMax && a[i] > secondMax) {
				if(thirdMax < firstMin) {
					secondMin = firstMin;
					firstMin = thirdMax;
				}
				thirdMax = secondMax;
				secondMax = a[i];
			} else if (a[i] < secondMax && a[i] > thirdMax) {
				if(thirdMax < firstMin) {
					secondMin = firstMin;
					firstMin = thirdMax;
				}
				thirdMax = a[i];
			} else if(a[i] > firstMin && a[i] < secondMin) {
				secondMin = a[i];
			} else {
				continue;
			}
		}
		
		System.out.println("First Min = " + firstMin);
		System.out.println("Second Min = " + secondMin);
		System.out.println("First Max = " + firstMax);
		System.out.println("Second Max = " + secondMax);
		System.out.println("Third Max  = " + thirdMax);
		
		System.out.println("Max Product = " + Math.max(firstMax*secondMax*thirdMax, firstMax*firstMin*secondMin));
		
	}

}
