package practise;

public class MinAvgSlice {

	public static int getMinAvgSliceIndex(int A[]) {
		
		if(A.length < 2) {
			return -1;
		}
		
		int startIndex = 0;
		int endIndex = 1;
		double globalAvg = (A[startIndex] + A[endIndex])/2;

		int ls = startIndex; 
		int le = endIndex; 
		double localAvg = globalAvg;
		
		++le;
		
		while(le < A.length) {
			
			int temp = le-ls;
			localAvg = ((localAvg*temp)+A[le])/(temp+1);
			
			if(localAvg < globalAvg) {
				startIndex = ls;
				endIndex = le;
				globalAvg = localAvg;
			} else {
				ls++;
				le = ls+1;
				localAvg = (A[ls] + A[le])/2;
				if(localAvg < globalAvg) {
					startIndex = ls;
					endIndex = le;
					globalAvg = localAvg;
				}
			}
			++le;
		}
		
		return startIndex;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {1, 2, -1, 2, -2, -3};
		System.out.println(getMinAvgSliceIndex(A));
	}

}
