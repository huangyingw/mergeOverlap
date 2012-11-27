import java.util.ArrayList;
import java.util.List;

public class MergeOverlap {

	class Interval {
		public Interval(int s, int e) {
			start = s;
			end = e;
		}

		int start;
		int end;
	};

	List<Interval> merge_overlaps(List<Interval> intervals, Interval another) {
		List<Interval> result = new ArrayList<MergeOverlap.Interval>();

		boolean merge_finished = false;

		for (int it = 0; it < intervals.size(); it++) {
			Interval inter = intervals.get(it);
			if (inter.start < another.end && another.start < inter.end) {
				another.start = (inter.start < another.start) ? inter.start
						: another.start;
				another.end = (inter.end < another.end) ? another.end
						: inter.end;
				continue;
			}

			if (inter.start > another.end) {
				result.add(another);
				merge_finished = true;
			}

			result.add(inter);
		}

		if (!merge_finished)
			result.add(another);

		return result;
	}

	void print_intervals(List<Interval> merged) {
		for (int i = 0; i < merged.size(); i++) {
			System.out.print("(" + merged.get(i).start + ", "
					+ merged.get(i).end + ") ");
		}
		System.out.println();
	}

	void test1() {
		List<Interval> intervals = new ArrayList<MergeOverlap.Interval>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(6, 10));
		intervals.add(new Interval(14, 19));

		Interval another = new Interval(13, 17);
		List<Interval> merged = merge_overlaps(intervals, another);
		print_intervals(merged);
	}

	void test2() {
		List<Interval> intervals = new ArrayList<MergeOverlap.Interval>();
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
	}
}
