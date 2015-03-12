package todo;

/**
 * http://www.careercup.com/question?id=5741092416782336
 *
 * Have two priority queues Q1, Q2
 * Q1: sorted as per start time (min Queue)
 * Q2: sorted as per end time (min Queue)
 * 
 * keep a local and global cumulative sum, when local > global, update it
 * 
 * should be like, a sliding window which is used to 
 * add a rate r1 if the start1 <= window <= end1
 * remove rate r1 if the window > end1
 * 
 */
public class MaxWaterFlownInWindow {

	/*
	 * 1. Sort all the events by their start time into a priority queue (earliest First) (heap1) 
	2. create a Priority Queue of events sorted by their end time (earliest first) (heap2) 
	4. create a value to track the best flow rate total 
	5. create a value to track the running flow rate total 
	6. while contents still exist in the heap1 
	___a. find the earliest value from heap1 and heap2 
	___b. while heap1 starts with the earliest starting time 
	______i. remove the event from heap1 with that starting time. 
	______ii. add the flow rate from the event to the running value total 
	______iii. add the event to heap2 
	___c. while heap2 starts with the earliest ending time 
	______i. remove the event from heap2 with that ending time 
	______ii. remove the flow rate from the even from the running total 
	___d. if the running flow rate total is better than the best flow rate total, store it 
	7. return the best flow rate total
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
