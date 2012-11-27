/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeAllOverlap {
	class MyComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval x, Interval y) {
			if (x.start < y.start)
				return -1;
			else if (x.start > y.start)
				return 1;
			return 0;
		}
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Interval> res = new ArrayList<Interval>();

		int size = intervals.size();
		if (size < 1) {
			return res;
		}

		Collections.sort(intervals, new MyComparator());
		res.add(intervals.get(0));
		if (size == 1) {
			return res;
		}

		for (int i = 1; i < size; i++) {
			Interval cur = intervals.get(i);
			Interval prev = res.get(res.size() - 1);
			if (cur.start <= prev.end) {
				if (cur.end > prev.end)
					prev.end = cur.end;
			} else
				res.add(new Interval(cur.start, cur.end));
		}
		return res;

	}
}
