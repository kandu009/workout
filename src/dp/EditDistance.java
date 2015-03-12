package dp;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 *
 * table[i][0] = Types.delete.value();
 * table[0][j] = Types.insert.value();
 * 
 * table[i][j] = min(
 * 						table[i-1][j-1] -> when A[i] == B[j],
 * 						table[i-1][j] + Types.delete.value(),
 * 						table[i][j-1] + Types.insert.value()
 * 						table[i-1][j-1] + Types.replace.value()
 * 					)
 */
public class EditDistance {

	public enum Types {
		delete(1),
		replace(2),
		insert(3);
		
		int id_;
		Types(int id) {
			id_ = id;
		}
		
		public int value() {
			return id_;
		}
	}
	
	public static int findEditDistance(char[] A, char[] B) {
		
		int[][] table = new int[A.length][B.length];
		for(int i = 0; i < A.length; ++i) {
			table[i][0] = Types.delete.value();
		}
		for(int j = 0; j < B.length; ++j) {
			table[0][j] = Types.insert.value();
		}
		
		for(int i = 1; i < A.length; ++i) {
			for(int j = 1; j < B.length; ++j) {
				int cost = Integer.MAX_VALUE;
				if(A[i] == B[j]) {
					cost = Math.min(table[i-1][j-1], cost); 
				} else {
					cost = Math.min(table[i-1][j] + Types.delete.value(), cost);
					cost = Math.min(table[i][j-1] + Types.insert.value(), cost);
					cost = Math.min(table[i-1][j-1] + Types.replace.value(), cost);
				}
				table[i][j] = cost;
			}
		}
		
		return table[A.length-1][B.length-1];
	}
	
	public static void main(String[] args) {

		String s1 = new String("act");
		String s2 = new String("dct");
		char[] A = s1.toCharArray();
		char[] B = s2.toCharArray();
		
		System.out.println(findEditDistance(A, B));
	}

}
