package misc;


public class PassingCars {

	/*public static int getCountOfPassingCars(int[] A) {
		
		int[] B = new int[A.length];

		for(int i = A.length-1; i >= 0; --i) {
			
			if(A[i] == 1) {
				if(i == A.length-1) {
					B[i] = 1;
				} else {
					B[i] = B[i+1] + 1;
				}
			} else if(A[i] == 0) {
				B[i] = B[i+1];
			} else {
				// do nothing
			}
			
		}
		
		int count = 0;
		for(int j = 0; j < A.length; ++j) {
			if(A[j] == 0) {
				count += B[j];
			}
		}
		
		return count > 10000000 ? -1 : count;
	}*/

	public static int getCountOfPassingCars(int[] A) {
		
		int currentCount = 0;
		int resCount = 0;
		
		for(int i = A.length-1; i >= 0; --i) {
			
			if(A[i] == 1) {
				++currentCount;
			} else if(A[i] == 0) {
				resCount += currentCount;
			} else {
				// do nothing
			}
			
		}
		
		return resCount > 10000000 ? -1 : resCount;
	}
	
	public static void main(String[] args) {
		
		int[] A = new int[] {1, 0, 1, 1, 0, 1, 1};
		System.out.println(getCountOfPassingCars(A));
	}

}
