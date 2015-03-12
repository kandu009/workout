package dp;

/**
 * http://www.careercup.com/question?id=5675324027174912
 * 
 * Use the previous computations wherever possible At each index <i,,j>, compute
 * the xAxis, yAxis and diagonal product if possible Then choose the maximum of
 * these at each step
 * 
 */
public class FindMaximumSubArrayProduct {

	private static int MAX_ARRAY_SIZE = 4;
	
	private static int findMaximumProduct(int[][] m) {
		
		if(m.length < MAX_ARRAY_SIZE || m[0].length < MAX_ARRAY_SIZE) {
			return -1;
		}
		
		int xLength = m[0].length;
		int yLength = m.length;
		
		int xProd = m[0][0]*m[0][1]*m[0][2]*m[0][3];
		int yProd = m[0][0]*m[1][0]*m[2][0]*m[3][0];
		int dProd = m[0][0]*m[1][1]*m[2][2]*m[3][3];
		
		boolean computeDiagonal = true;
		int maxProduct = Integer.MIN_VALUE;
		
		for(int i = 1; i < xLength; ++i) {
			
			for(int j = 1; j < yLength; ++j) {
				
				if(xLength-i >= MAX_ARRAY_SIZE) {
					maxProduct = Math.max(maxProduct, xProd != 0 ? 
											xProd*m[i+3][j]/m[i-1][j] : 
												m[i][j]*m[i+1][j]*m[i+2][j]*m[i+3][j]);
				} else {
					computeDiagonal = false;
				}
				
				if(yLength-j >= MAX_ARRAY_SIZE) {
					maxProduct = Math.max(maxProduct, yProd != 0 ? 
											yProd*m[i][j+3]/m[i][j-1] : 
												m[i][j]*m[i][j+1]*m[i][j+2]*m[i][j+3]);
				} else {
					computeDiagonal = false;
				}
				
				if(computeDiagonal) {
					maxProduct = Math.max(maxProduct, dProd != 0 ? 
										dProd*m[i+3][j+3]/m[i-1][j-1] : 
											m[i][j]*m[i+1][j+1]*m[i+2][j+2]*m[i+3][j+3]);
				}
			
			}
		
		}
		
		return maxProduct;
	}
	
	public static void main(String[] args) {

		int[][] m = new int[][] {
									{1, 2, 0, -1 ,4},
						            {3, 1, 2, 4, 6},
						            {0, 6, 3, 1, 4},
						            {1, 3, 2, 0, 7},
						            {2, 0, 3, 2, 9}
								};
		
		System.out.println(findMaximumProduct(m));
	}

}
