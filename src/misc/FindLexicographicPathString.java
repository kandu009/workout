package misc;
import java.util.TreeSet;


/**
 * http://www.careercup.com/question?id=5682818938044416
 *
 */
public class FindLexicographicPathString {

	/*private static int[] getNextBlock(char[][] A, boolean[][] visited, int curI, int curJ) {
		int retI = -1, retJ = -1;
		if(curI == 0) {
			if(A[curI][curJ+1] < A[curI+1][curJ]) {
				
			}
		} else {
			
		}
		
		return new int[] { retI, retJ};
	}*/
	
	/*private static String findBestPath(char[][] A) {
		
		char[] ret = new char[A.length*A[0].length];
		
		boolean[][] visited = new boolean[A.length][A[0].length];
		for(int i = 0; i < A.length; ++i) {
			for(int j = 0; j < A[0].length; ++j) {
				visited[i][j] = false;
			}
		}
		visited[0][0] = true;
		
		ret[0] = A[0][0];
		for(int i = 0, j = 0, rInd = 0; i < 2 || j < A.length;) {
			int[] r = getNextBlock(A, visited, i, j);
			i = r[0]; j = r[1];
		}
		
		return ret.toString();
	}*/
	
	private static TreeSet<String> findingAllPaths(char[][] a, boolean[][] visited, TreeSet<String> paths) {
		
		
		
		return null;
	}

	private static TreeSet<String> getAllPaths(char[][] A) {
		
		boolean[][] visited = new boolean[A.length][A[0].length];
		for(int i = 0; i < A.length; ++i) {
			for(int j = 0; j < A[0].length; ++j) {
				visited[i][j] = false;
			}
		}
		visited[0][0] = true;
		TreeSet<String> paths = new TreeSet<String>();
		return findingAllPaths(A, visited, paths);
		
	}
	
	public static void main(String[] args) {

		char[][] A = new char[][] {
									{'a', 'b','a','e'},
									{'b','c','d','f'}
								};
		
		TreeSet<String> allPats = getAllPaths(A);
		System.out.println(allPats.iterator().next());
	}

}
