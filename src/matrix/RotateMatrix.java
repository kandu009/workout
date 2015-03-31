package matrix;

public class RotateMatrix {

	public static void rotateClockwise(int[][] matrix, int n) {
		
		for (int layer = 0; layer < n / 2; ++layer) {
		
			int first = layer;
			int last = n - 1 - layer;
			
			for (int i = first; i < last; ++i) {
				
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
			
		}
	}
	
	public static void rotateAntiClockwise(int[][] matrix, int n) {
		
		for (int layer = 0; layer < n / 2; ++layer) {
		
			int first = layer;
			int last = n - 1 - layer;
			
			for (int i = first; i < last; ++i) {
				
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[i][last];

				// bottom -> left
				matrix[i][last] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[last - offset][first];

				// top -> right
				matrix[last - offset][first] = top; // right <- saved top
			}
		}
			
	}
	
	public static void print(int[][] m) {
	
		for(int i = 0; i < m.length; ++i) {
			for(int j = 0; j < m.length; ++j) {
				System.out.println(m[i][j]);
			}
		}
	}
	
	public static void main(String[] args) {

		int[][] matrix = new int[][] {
										{1, 2, 3},
										{4, 5, 6},
										{7, 8, 9}
									 };
		print(matrix);
		System.out.println("*******************");
		rotateClockwise(matrix, 3);
		print(matrix);
		System.out.println("*******************");
		rotateAntiClockwise(matrix, 3);
		print(matrix);
										
	}

}
