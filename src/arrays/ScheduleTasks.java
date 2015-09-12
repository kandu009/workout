package arrays;

/**
 * 
 * http://www.careercup.com/question?id=4847342612119552
 * 
 * There are at most eight servers in a data center. Each server has got a
 * capacity/memory limit. There can be at most 8 tasks that need to be scheduled
 * on those servers. Each task requires certain capacity/memory to run, and each
 * server can handle multiple tasks as long as the capacity limit is not hit.
 * Write a program to see if all of the given tasks can be scheduled or not on
 * the servers?
 * 
 * Ex: Servers capacity limits: 8, 16, 8, 32 Tasks capacity needs: 18, 4, 8, 4,
 * 6, 6, 8, 8 For this example, the program should say 'true'.
 * 
 * @author Ravali
 *
 */
public class ScheduleTasks {

	public static boolean isSchedulable(int[] serverCapacities,
			int[] taskCapacities, int taskToBeScheduled) {
		
		if(taskToBeScheduled >= taskCapacities.length) {
			return true;
		}
		
		// iterate over the remaining serverCapacities to schedule the rest of the tasks.
		for(int i = 0; i < serverCapacities.length; ++i) {
			// If there is a server which can run the task, use it and adjust the serverCapacity
			// before trying to schedule the rest of the tasks.
			if(serverCapacities[i] > taskCapacities[taskToBeScheduled]) {
				serverCapacities[i] -= taskCapacities[i];
				if(isSchedulable(serverCapacities, taskCapacities, taskToBeScheduled+1)) {
					return true;
				} else {
					// this means, we could not schedule the tasks using the above combination.
					// So set the serverCapacity back and try others.
					serverCapacities[i] += taskCapacities[i];
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		int[] serverCapacities = new int[] { 8, 16, 8, 22 };
		int[] taskCapacities = new int[] { 18, 4, 8, 4, 6, 6, 8, 8};
		
		if(isSchedulable(serverCapacities, taskCapacities, 0)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	}

}
