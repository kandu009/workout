import java.util.HashSet;
import java.util.TreeSet;


/**
 * http://www.careercup.com/question?id=6285685721923584
 * 
 * From a list of intervals [start_time, end_time], we should minimize the
 * number of intervals by clubbing the overlapping intervals
 * 
 * Input: [4, 8], [3, 5], [-1 2], [10, 12] Output: [-1,8] [10,12]
 * 
 * Approach: 1. sort the intervals based on start time 2. merge consecutive
 * intervals if the first.end_time+1 >= second.start_time
 * 
 * @author rkandur
 *
 */
public class MinimizeOverlappingWindows {

	public static class Interval implements Comparable<Interval> {

		int start_;
		int end_;
		
		public Interval(int start, int end) {
			start_ = start;
			end_ = end;
		}
		public Interval(Interval p) {
			start_ = p.start_;
			end_ = p.end_;
		}
		
		public int compareTo(Interval o) {
			return start_-o.start_;
		}
		
	}
	
	private static HashSet<Interval> getMergedIntervals(TreeSet<Interval> pairs) {
		HashSet<Interval> result = new HashSet<Interval>();
    	Interval temp = null;
    	for(Interval p : pairs) {
    		if(temp == null) {
    			temp = p;
    		} else if(temp.end_+1 >= p.start_) {
    			temp.end_ = p.end_;
    		} else {
    			result.add(new Interval(temp));
    			temp = p;
    		}
    	}
    	result.add(temp);
    	return result;
	}
	
	public static void main(String[] args) {

		TreeSet<Interval> pairs = new TreeSet<Interval>();
    	pairs.add(new Interval(4, 8));
    	pairs.add(new Interval(3, 5));
    	pairs.add(new Interval(-1, 2));
    	pairs.add(new Interval(10, 12));

    	HashSet<Interval> result = getMergedIntervals(pairs);
    	for(Interval p : result) {
    		System.out.println(p.start_ + " " + p.end_);
    	}
		
	}

}
