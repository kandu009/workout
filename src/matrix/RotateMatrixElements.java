package matrix;


/**
 * 
 * https://www.hackerrank.com/challenges/matrix-rotation-algo
 * 
 * You are given a 2D matrix, a, of dimension MxN and a positive integer K. You
 * have to rotate the matrix K times and print the resultant matrix. Rotation
 * should be in anti-clockwise direction.
 * 
 * Since K could be really large, and we also know that if we rotate the first
 * layer of matrix will remain the same if we rotate it 2(m+n)-4 times. We could
 * use this to take a modulo of the actual rotations for each layer of the
 * matrix.
 * 
 * Assuming that each layer is a rectangle. i.e., there is no single inner layer
 * element.
 * 
 * @author Ravali
 *
 */
public class RotateMatrixElements {

	public static void rotateMatrix(int[][] a, int actual_rotations) {
		
		// left, right, top and bottom layers of the matrix. 
		int l = 0; int r = a[0].length-1; int t = 0; int b = a.length-1;
		
		// we need to rotate only n/2 and m/2 layers
		for(; l < a[0].length/2 && t < a.length/2 ;++l, --r, ++t, --b) {
			
			// number of elements for this layer i.e., anologous lo 2(m+n)-4.
			int num_of_elements = (2*(r-l+1))+(2*(b-t+1))-4;
			// modulo of the effective number of rotations needed.
			int modulo_rotations = actual_rotations%num_of_elements;
			
			// actual rotation logic. i.e., perform modulo_rotations.
			for(int iter = 0; iter < modulo_rotations; ++iter) {
				
				// copy top left element before overwriting it.
				int temp = a[t][l];
				// top horizontal left -> right
				for(int i = l; i < r; ++i) {
					a[t][i] = a [t][i+1];
				}
				// right vertical top -> bottom
				for(int i = t; i < b; ++i) {
					a[i][r] = a [i+1][r];
				}
				// bottom horizontal right -> left
				for(int i = r; i > l; --i) {
					a[b][i] = a [b][i-1];
				}
				// left vertical bottom -> top
				for(int i = b; i > t; --i) {
					a[i][l] = a [i-1][l];
				}
				// the place where the first top left element should go.
				a[t+1][l] = temp;
			}
		}
		
	}
	
	public static void main(String[] args) {

		int[][] a = new int[][] {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
	
		int k = 13;
		
		rotateMatrix(a, k);
		
		for(int i = 0; i < a.length; ++i) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < a[0].length; ++j) {
				sb.append(a[i][j]).append(" ");
			}
			System.out.println(sb.toString());
		}
		
	}

}
