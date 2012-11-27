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
import java.util.List;

public class MergeAllOverlap {
	public ArrayList<Interval> merge(List<Interval> intervals) {
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

	void test1() {
		List<Interval> intervals = new ArrayList<Interval>();

		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));

		List<Interval> merged = merge(intervals);
		print_intervals(merged);
	}

	void print_intervals(List<Interval> merged) {
		for (int i = 0; i < merged.size(); i++) {
			System.out.print("(" + merged.get(i).start + ", "
					+ merged.get(i).end + ") ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MergeAllOverlap mo = new MergeAllOverlap();
		mo.test1();
		// [1,6],[8,10],[15,18].

	}
}
