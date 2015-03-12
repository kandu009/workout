package dp;

public class LongestIncreasingSequenceMatrix {

	public static void main(String[] args) {

		int[][] a = { 
						{2,3,4,5},
						{4,5,10,11},
						{20,6,9,12},
						{6,7,8,40}
					};
		
		System.out.println(Longest(a));
					  
		}

	private static int Longest(int[][] a) {
		
		int[][] sum = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		sum[0][0] = 1;
		
		for(int i = 1; i < a.length; ++i) {
			if(a[0][i-1] < a[0][i]) {
				sum[0][i] = sum[0][i-1]+1;
			} else {
				sum[0][i] = sum[0][i-1];
			}
		}
		
		for(int i = 1; i < a[0].length; ++i) {
			if(a[i-1][0] < a[i][0]) {
				sum[i][0] = sum[i-1][0]+1;
			} else {
				sum[i][0] = sum[i-1][0];
			}
		}
		
		for(int i = 1; i < a.length; ++i) {
			for(int j = 1; j < a[0].length; ++j) {
				
				int s = 0;
				
				if(a[i][j-1] < a[i][j]) {
					s = Math.max(s, sum[i][j-1]+1);
					sum[i][j] = s;
				} 
				
				if (a[i-1][j] < a[i][j]) {
					s = Math.max(s, sum[i-1][j]+1);
					sum[i][j] = s;
				}
			}
		}
		
		return sum[a.length-1][a[0].length-1];
	}
}
