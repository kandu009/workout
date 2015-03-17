package dp;

/**
 * http://www.careercup.com/question?id=6282171643854848
 * 
 * Given a set of servers (with max capacities) and tasks (with max capacities)
 * check if the set of tasks can be executed on the servers
 * 
 * If server has more space after taking up on task, it can accommodate another
 * task But, a single task cannot be split and run on multiple servers.
 * 
 * @author rkandur
 *
 */
public class ArrangeTasksWithinCapacity {

	/**
	 * 
	 * @param servers	: servers capcity
	 * @param tasks		: tasks capacity
	 * @param served	: denotes which all tasks are served
	 */
	private static boolean canAccommodate(int[] servers, int[] tasks, boolean[] served) {
		
		if(allAreServed(served)) {
			return true;
		}
		
		/**
		 * Using DFS technique here to make sure any one of the possibilities 
		 * works. If none of them work, then the scheduling cannot be done.
		 */
		for(int i = 0; i < tasks.length; ++i) {
			if(!served[i]) {
				served[i] = true;
				for(int j = 0; j < servers.length; ++j) {
					if(servers[j] >= tasks[i]) {
						servers[j] = servers[j]-tasks[i];
						if(canAccommodate(servers, tasks, served)) {
							return true;
						} else {
							servers[j] = servers[j]+tasks[i];
						}
					}
				}
				served[i] = false;
			}
		}
		
		return false;
	}
	
	private static boolean allAreServed(boolean[] served) {
		for(int i = 0; i < served.length; ++i) {
			if(served[i] == false) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		int[] servers = new int[] {8, 16, 8, 32};
		int[] tasks = new int[] {18, 4, 8, 4, 6, 6, 8, 8};
		boolean[] served = new boolean[tasks.length];
		
		for(int i = 0; i < served.length; ++i) {
			served[i] = false;
		}
		
		if(canAccommodate(servers, tasks, served)) {
			System.out.println("Yes !!!");
		} else {
			System.out.println("No !!!!");
		}
		
	}

}
