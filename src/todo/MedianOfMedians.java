package todo;

//TODO: http://www.careercup.com/question?id=5434428369141760
// https://gist.github.com/andlima/1774060
// http://geekmeal.blogspot.com/2013/02/median-of-medians-algorithm.html
// http://stackoverflow.com/questions/9489061/understanding-median-of-medians-algorithm
// http://en.wikipedia.org/wiki/Median_of_medians
public class MedianOfMedians {

	public static void helper(int[] A, int s, int e, int k) {
		
		if(e-s+1 <= 5) {
//			sort(A, s, e);
			
		}
		
	}
	
	public static void findKLargestNumbers(int[] A, int k) {
		helper(A, 0, A.length-1, k);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < k; ++i) {
			sb.append(A[i]+" ");
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
