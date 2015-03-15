package trees;

/**
 * Given the number of nodes, find the total number of permutations possible in
 * a tree
 * 
 * After you insert a new node, we will have oldOpenslots -1 +2 open slots So,
 * at every step, possible combinations would be nc1 * openslots This goes till
 * n >= 1
 * 
 * @author rkandur
 *
 */
public class PermutationsOfTrees {
	
	private static int findIdenticalTrees(int size) {
		
		if(size <= 1) {
			return 1;
		}
		
		int result =  1;
		int vacantLeafPositions = 1;
		
		for(int i = size; i >= 1; --i) {
			result *= (size*vacantLeafPositions);
			vacantLeafPositions = vacantLeafPositions-1+2;	// as we will use up on existing openslot and this node will again openup two more new open slots
			--size;
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		System.out.println(findIdenticalTrees(3));
	}

}
