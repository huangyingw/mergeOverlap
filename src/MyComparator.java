import java.util.Comparator;


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