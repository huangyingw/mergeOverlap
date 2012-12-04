import java.util.ArrayList;
import java.util.List;

public class MergeOverlap {

	List<Interval> merge_overlaps(List<Interval> intervals, Interval another) {
		List<Interval> result = new ArrayList<Interval>();

		boolean merge_finished = false;

		for (int it = 0; it < intervals.size(); it++) {
			Interval nav = intervals.get(it);
			if (isOverLap(another, nav)) {
				another.start = mergeStart(another, nav);
				another.end = mergeEnd(another, nav);
			} else {
				if (LessThanCurrent(another, nav)) {
					result.add(another);
					merge_finished = true;
				}
				result.add(nav);
			}
		}
		if (!merge_finished)
			result.add(another);
		return result;
	}

	private boolean LessThanCurrent(Interval another, Interval inter) {
		return inter.start > another.end;
	}

	private int mergeEnd(Interval another, Interval inter) {
		return (inter.end < another.end) ? another.end : inter.end;
	}

	private int mergeStart(Interval another, Interval inter) {
		return (inter.start < another.start) ? inter.start : another.start;
	}

	private boolean isOverLap(Interval another, Interval inter) {
		return inter.start < another.end && inter.end > another.start;
	}

	void print_intervals(List<Interval> merged) {
		for (int i = 0; i < merged.size(); i++) {
			System.out.print("(" + merged.get(i).start + ", "
					+ merged.get(i).end + ") ");
		}
		System.out.println();
	}

	void test1() {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(6, 10));
		intervals.add(new Interval(14, 19));

		Interval another = new Interval(13, 17);
		List<Interval> merged = merge_overlaps(intervals, another);
		print_intervals(merged);
	}

	void test2() {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 5));
		intervals.add(new Interval(6, 15));
		intervals.add(new Interval(20, 21));
		intervals.add(new Interval(23, 26));
		intervals.add(new Interval(27, 30));
		intervals.add(new Interval(35, 40));

		Interval another = new Interval(14, 33);
		List<Interval> merged = merge_overlaps(intervals, another);
		print_intervals(merged);
	}

	public static void main(String[] args) {
		MergeOverlap mo = new MergeOverlap();
		mo.test1();
		mo.test2();
		// (1, 4) (6, 10) (13, 19)
		// (1, 5) (6, 33) (35, 40)

	}
}
