package practise;

public class FindTheCelebrity {

	private static boolean knows(int[][] connections, int i, int j) {
		if(i < 0 || i >= connections.length || j <0 || j > connections.length) {
			return false;
		}
		if(connections[i][j] == 1) {
			return true;
		}
		return false;
	}
	
	public static int findCelebrity(int[][] connections, int[] persons) {
		
		int firstIndex = 0;
		int secondIndex = 1;
		for (; firstIndex < persons.length && secondIndex < persons.length; ) {
			if(knows(connections, firstIndex, secondIndex)) {
				firstIndex = secondIndex;
				++secondIndex;
			} else {
				++secondIndex;
			}
		}
		
		return (firstIndex < persons.length) ? firstIndex
				: (secondIndex < persons.length) ? secondIndex : -1;
	}
	
	public static void main(String[] args) {
		int[][] connections = new int[][] {
								{0,0,0,0},
								{1,0,0,0},
								{1,1,0,1},
								{1,1,0,0}};
		
		int[] persons = new int[] { 0,1,2,3 };	
		
		System.out.println(findCelebrity(connections, persons));
	}
}
