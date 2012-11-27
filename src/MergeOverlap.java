
public class MergeOverlap {
	#include <iostream>
	#include <vector>

	using namespace std;

	struct Interval
	{
	public:
	  Interval(int s, int e) : start(s), end(e) {}
	  int start;
	  int end;
	};


	vector<Interval> merge_overlaps(vector<Interval> intervals, Interval another)
	{
	  vector<Interval> result; 
	  vector<Interval>::iterator it;

	  bool merge_finished = false;

	  for (it = intervals.begin(); it != intervals.end(); it++){
	    if ( it->start < another.end && another.start < it->end){
	      another.start = (it->start < another.start) ? it->start : another.start;
	      another.end = (it->end < another.end) ? another.end : it->end;
	      continue;
	    }
	                                           
	    if (it->start > another.end){  
	      result.push_back(another); 
	      merge_finished = true;
	    }

	    result.push_back(*it);
	  }

	  if (! merge_finished) result.push_back(another);

	  return result;
	}


	void print_intervals(vector<Interval> & merged)
	{
	  for (int i = 0; i < merged.size(); i++){
	    cout << "(" << merged[i].start <<", " << merged[i].end<<") ";
	  }
	  cout << endl;
	}


	void test1()
	{
	  vector<Interval> intervals;
	  intervals.push_back( Interval(1,4) );
	  intervals.push_back( Interval(6,10) );
	  intervals.push_back( Interval(14,19) );

	  Interval another(13, 17);
	  vector<Interval> merged = merge_overlaps(intervals, another);
	  print_intervals(merged);
	}

	void test2()
	{
	  vector<Interval> intervals;
	  intervals.push_back( Interval(1,5));
	  intervals.push_back( Interval(6,15));
	  intervals.push_back( Interval(20,21));
	  intervals.push_back( Interval(23,26));
	  intervals.push_back( Interval(27,30));
	  intervals.push_back( Interval(35,40));
	  
	  Interval another(14,33);
	  vector<Interval> merged = merge_overlaps(intervals, another);
	  print_intervals(merged);
	}

	int main()
	{
	  test1();
	  test2();
	  return 0;
	}



}
