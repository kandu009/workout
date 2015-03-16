

/**
 * http://www.careercup.com/question?id=5682818938044416
 * 
 * Given a 2Xn martix with characters, find the lexicographically smallest
 * string with all the characters in matrix. i.e., none of the items should be
 * missed.
 * 
 * Logic: we check for 4 possible moves (upward, downward, left, right) choose
 * only the path which leads to covering all characters. Of them, choose the one
 * with lexicographically smaller value.
 * 
 * TODO: very weirdly done, we can generalize this and avoid the crappy
 * conditions everywhere
 * 
 * @author rkandur
 *
 */
public class LexicographicSmallestStringFromMatrix {

	private static String findLexSmallestString(char[][] A) {

		boolean[][] visited = new boolean[A.length][A[0].length];
		for(int i = 0; i < visited.length; ++i) {
			for(int j = 0; j < visited[0].length; ++j) {
				visited[i][j] = false;
			}
		}
		
		StringBuilder result = new StringBuilder();
		result.append(A[0][0]);
		visited[0][0] = true;
		
		int i = 0; int j = 0;
		while(result.toString().length() != A.length*A[0].length) {
			
			int nextI = 0; int nextJ = 0;
			Character nextChar = null;

			if(i-1 >= 0) {
				/**
				 * This means, we are migrating from one row to other, In this
				 * case only if the previous r next column is completely
				 * visited, this move should be allowed. Otherwise it leads to a
				 * void (which is not covered in the resulting string).
				 */
				boolean proceed = false;
				if(j > 0 && j < A[0].length-1) {
					if(visited[i][j-1] && visited[i-1][j-1]) {
						proceed = true;
					}
				} else if (j == 0 || j == A[0].length-1) {
					proceed = true;
				}
				if(proceed && !visited[i-1][j]) {
					nextChar = A[i-1][j];
					nextI = i-1; nextJ = j;
				}
			}
			if(i+1 >= 0 && i+1 < A.length) {
				/**
				 * This means, we are migrating from one row to other, In this
				 * case only if the previous r next column is completely
				 * visited, this move should be allowed. Otherwise it leads to a
				 * void (which is not covered in the resulting string).
				 */
				boolean proceed = false;
				if(j > 0 && j < A[0].length-1) {
					if(visited[i][j-1] && visited[i+1][j-1]) {
						proceed = true;
					}
				} else if (j == 0 || j == A[0].length-1) {
					proceed = true;
				}
				if(proceed && !visited[i+1][j]) {
					if(nextChar == null) {
						nextChar = A[i+1][j];
						nextI = i+1; nextJ = j;
					} else if(nextChar > A[i+1][j]) {
						nextChar = A[i+1][j];
						nextI = i+1; nextJ = j;
					}
				}
			}
			if(j+1 < A[0].length) {
				if(!visited[i][j+1]) {
					if(nextChar == null) {
						nextChar = A[i][j+1];
						nextI = i; nextJ = j+1;
					} else if(nextChar > A[i][j+1]) {
						nextChar = A[i][j+1];
						nextI = i; nextJ = j+1;
					}
				}
			}
			if(j-1 >=0) {
				/**
				 * This means, we are migrating backwards, in a row. In this
				 * case only if the previous diagonal i.e., previous/next column
				 * + element right above or below the current element should
				 * already be visited. Otherwise it leads to a void (which is
				 * not covered in the resulting string).
				 */
				boolean proceed = false;
				if(i-1 >= 0) {
					if(j == A[0].length-1) {
						proceed = true;
					} else if(visited[i][j+1] && visited[i-1][j+1] && visited[i-1][j]) {
						proceed = true;
					}
				} else if(i == 0) {
					if(j == A[0].length-1) {
						proceed = true;
					} else if(visited[i][j+1] && visited[i+1][j+1] && visited[i+1][j]) {
						proceed = true;
					}
				}
				if(proceed && !visited[i][j-1]) {
					if(nextChar == null) {
						nextChar = A[i][j-1];
						nextI = i; nextJ = j-1;
					} 
					else if(nextChar > A[i][j-1]) {
						nextI = i; nextJ = j-1;
					}
				}
			}
			
			if(nextChar == null) {
				System.out.println("Something is wrong !!!");
				return "";
			}
			visited[nextI][nextJ] = true;
			result.append(A[nextI][nextJ]);
			i = nextI;
			j = nextJ;
		
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {

		char[][] A = { 
						{'a','b','a','b','a','a','a','b','a','b'},
						{'b','a','b','a','b','a','b','a','b','a'}
					 };
		
		System.out.println(findLexSmallestString(A));
		
	}

}
