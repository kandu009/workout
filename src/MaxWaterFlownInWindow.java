

import java.util.Comparator;
import java.util.PriorityQueue;

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
	
	public static class Window {
		
		int startTime_;
		int endTime_;
		int volume_;
		
		public Window(int start, int end, int volume) {
			startTime_ = start;
			endTime_ = end;
			volume_ = volume;
		}
	}
	
	public static void main(String[] args) {

		PriorityQueue<Window> startTimeQueue = new PriorityQueue<Window>(10, new Comparator<Window>() {
			public int compare(Window o1, Window o2) {
				return o1.startTime_ - o2.startTime_;
			}
		});
		
		PriorityQueue<Window> endTimeQueue = new PriorityQueue<Window>(10, new Comparator<Window>() {
			public int compare(Window o1, Window o2) {
				return o1.endTime_ - o2.endTime_;
			}
		});
		
		Window w1 = new Window(0, 10, 100);
		Window w2 = new Window(10, 15, 300);
		Window w3 = new Window(16, 20, 400);
		Window w4 = new Window(5, 15, 200);

		startTimeQueue.add(w1);
		startTimeQueue.add(w2);
		startTimeQueue.add(w3);
		startTimeQueue.add(w4);
		
		endTimeQueue.add(w1);
		endTimeQueue.add(w2);
		endTimeQueue.add(w3);
		endTimeQueue.add(w4);
		
		System.out.println(findMaxFlow(startTimeQueue, endTimeQueue));
		
	}

	private static int findMaxFlow(PriorityQueue<Window> sq, PriorityQueue<Window> eq) {
		
		int maximumResult = 0;
		int result = 0;
		
		while(!sq.isEmpty() && !eq.isEmpty()) {
			
			int st = Integer.MAX_VALUE;
			int end = Integer.MAX_VALUE;
			
			if(!sq.isEmpty()) {
				st = sq.peek().startTime_;
			} 
			if(!eq.isEmpty()) {
				end = eq.peek().endTime_;
			}
			
			if(st <= end) {
				Window w = sq.poll(); 
				result += w.volume_;
				eq.offer(w);
				maximumResult = (maximumResult < result) ? result : maximumResult;
			} else {
				Window w = eq.poll();
				result -= w.volume_;
			}
			
		}
		
		return maximumResult;
	}

}
