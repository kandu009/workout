package practise;

public class MoveNonZeroToLeft {

	public static void main(String[] args) {
		int[] A = new int[] { 2, 0, 1, 0, 0, 3, 0, 2, 1, 3, 0, 5};
		moveAllNonZeroToLeft(A);
		
		for(int i = 0; i < A.length; ++i) {
			System.out.println(A[i]);
		}
	}

	private static void moveAllNonZeroToLeft(int[] a) {
		for(int i = 0, j = a.length-1; j >= i;) {
			if(a[i] != 0) {
				++i; continue;
			}
			if(a[j] == 0) {
				--j; continue;
			}
			
			swap(i, j, a);
			++i;
			--j;
		}
	}
	
	private static void swap(int i, int j, int[] A) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
