package dp;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianForStream {

	public static PriorityQueue<Integer> minHeap_ = new PriorityQueue<Integer>(10, new Comparator<Integer>() {

		public int compare(Integer o1, Integer o2) {
			if(o1 > o2) {
				return 1;
			} else if(o1 < o2) {
				return -1;
			}
			return 0;
		}
		
	});
	public static PriorityQueue<Integer> maxHeap_ = new PriorityQueue<Integer>(10, new Comparator<Integer>() {

		public int compare(Integer o1, Integer o2) {
			if(o1 > 02) {
				return -1;
			} else if (o1 < o2) {
				return 1;
			}
			return 0;
		}
		
	});
	
	public static int getMedian() {
		if(minHeap_.size() == maxHeap_.size()) {
			return (minHeap_.peek()+maxHeap_.peek())/2;
		} else if(minHeap_.size() > maxHeap_.size()) {
			return minHeap_.peek();
		}
		return maxHeap_.peek();
	}
	
	public static void addElement(int e) {
		
		if(maxHeap_.isEmpty()) {
			maxHeap_.offer(e);
			return;
		}
		
		if(minHeap_.size() == maxHeap_.size()) {
			if(e > minHeap_.peek()) {
				maxHeap_.offer(minHeap_.poll());
				minHeap_.offer(e);
			} else {
				maxHeap_.offer(e);
			}
		} else {
			if(e < maxHeap_.peek()) {
				minHeap_.offer(maxHeap_.poll());
				maxHeap_.offer(e);
			} else {
				minHeap_.offer(e);
			}
		}
	}
	
	public static void main(String[] args) {
		
		addElement(3);
		addElement(9);
		addElement(2);
		addElement(7);
		addElement(6);
		System.out.println(getMedian());
	}

}
