package recursion;

/**
 * http://www.geeksforgeeks.org/minimum-steps-to-reach-a-destination/
 * 
 * Given a number line from -infinity to +infinity. You start at 0 and can go
 * either to the left or to the right. The condition is that in i’th move, you
 * take i steps.
 * 
 * a) Find if you can reach a given number x b) Find the most optimal way to
 * reach a given number x, if we can indeed reach it.
 * 
 * Example, 3 can be reached om 2 steps, (0, 1) (1, 3) and 4 can be reached in 3
 * steps (0, -1), (-1, 1) (1, 4).
 * 
 * Solution: At each step, find the count using leftStep and rightStep. Return
 * the minimum of them. 
 * Base case: 
 * 1. When we go beyond the step size in each
 * direction, stop going to extreme bounds by returning Max value.
 * 2. When currentStep and destinationStep is the same, return the count returned.
 * 
 * @author Ravali
 *
 */
public class MinimumStepsToReachDestination {

	public static int getMinSteps(int currentStep, 
			int currentIteration, int prevStepCount, int destinationStep) {
		
		if(Math.abs(currentStep) > Math.abs(destinationStep)) {
			return Integer.MAX_VALUE;
		}
		if(currentStep == destinationStep) {
			return prevStepCount;
		}
		
		int leftDest = currentStep-currentIteration;
		int countFromLeftMove = getMinSteps(leftDest, currentIteration+1, prevStepCount+1, destinationStep);
		
		int rightDest = currentStep+currentIteration;
		int countFromRightMove = getMinSteps(rightDest, currentIteration+1, prevStepCount+1, destinationStep);
		
		return Math.min(countFromLeftMove, countFromRightMove);
	}
	
	public static void main(String[] args) {

		int destinationStep = -3;
		System.out.println(getMinSteps(0, 1, 0, destinationStep));
		
	}

}
