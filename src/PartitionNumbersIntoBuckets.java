import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 
 * http://www.careercup.com/question?id=5068409286950912
 * 
 * There are 3 machines M1, M2 and M3. Each machine is 90% full of its capacity
 * with integers. Now you have to sort all the integers combined and then store
 * the first 1/3rd in M1, second 1/3rd in M2 and last 1/3rd in M3.
 * 
 * Your objective is to minimize the number of sort operations and number of
 * data transfer operations. Each sort operation/data transfer operation is
 * counted as 1 irrespective of the count of values that are being
 * sorted/transferred.
 * 
 * psuedo code:
 * 
 * 1. Make M1 as a maxheap 
 * 2. Make M3 as a minheap 
 * 3. Do a while loop if min(M3) < max(M1): 
 * 		3.1. Exchange min(M3) and max(M1) 3.2. Maxify M1 and minify M3
 * 4. Loop for each number - say N - in M2: 
 * 		4.1. If N < max(M1), exchange N and max(M1), maxify M1 
 * 		4.2. If N > min(M3), exchange N and min(M3), minify M3
 * 
 */
public class PartitionNumbersIntoBuckets {

	private static void print(int[] M1, int[] M2, int[] M3) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("M1=={");
		for(int i = 0; i < M1.length; ++i) {
			sb.append(M1[i]).append(",");
		}
		sb.append("}");
		sb.append("\n");
		
		sb.append("M2=={");
		for(int i = 0; i < M2.length; ++i) {
			sb.append(M2[i]).append(",");
		}
		sb.append("}");
		sb.append("\n");
		
		sb.append("M3=={");
		for(int i = 0; i < M3.length; ++i) {
			sb.append(M3[i]).append(",");
		}
		sb.append("}");
		sb.append("\n");
		
		System.out.println(sb.toString());
	}

	private static void createPartitions(int[] M1, int[] M2, int[] M3) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(M1.length, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) {
					return -1;
				} else if(o1 < o2) {
					return 1;
				}
				return 0;
			}
		});
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(M3.length, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) {
					return 1;
				} else if(o1 < o2) {
					return -1;
				}
				return 0;
			}
		});
		
		for(int i = 0; i < M1.length; ++i) {
			maxHeap.add(M1[i]);
		}
		for(int i = 0; i < M3.length; ++i) {
			minHeap.add(M3[i]);
		}

		int i = M3.length;
		while(i > 0) {
			if(minHeap.peek() < maxHeap.peek()) {
				int temp = minHeap.poll();
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(temp);
			}
			--i;
		}
		
		for(int j = 0; j < M2.length; ++j) {
			if(M2[j] < maxHeap.peek()) {
				int temp = M2[j];
				M2[j] = maxHeap.poll();
				maxHeap.offer(temp);
			} else if(M2[j] > minHeap.peek()) {
				int temp = M2[j];
				M2[j] = minHeap.poll();
				minHeap.offer(temp);
			}
		}
		
		int k = 0;
		while(!maxHeap.isEmpty()) {
			M1[k] = maxHeap.poll();
			++k;
		}
		k = 0;
		while(!minHeap.isEmpty()) {
			M3[k] = minHeap.poll();
			++k;
		}
		
	}
	
	public static void main(String[] args) {

		int[] M1 = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1,-10 };
		int[] M2 = new int[] { 20, 19, 18, 17, 16, 15, 14, 23, 12, 11, 10 };
		int[] M3 = new int[] { 20, 19, 21, 122, 10, 9, 11, 12, 4, 13, 18, 17 };
		
		System.out.println("Before");
		print(M1, M2, M3);
		createPartitions(M1, M2, M3);
		System.out.println("After");
		print(M1, M2, M3);
		
	}

}
