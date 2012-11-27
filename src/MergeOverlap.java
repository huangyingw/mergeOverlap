import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public class MergeOverlap<E> {


	class Interval
	{
	  public Interval(int s, int e)  {
		  start=s;
		  end=e;
	  }
	  int start;
	  int end;
	};


	Vector<Interval> merge_overlaps(Vector<Interval> intervals, Interval another)
	{
	  Vector<Interval> result; 
	  Iterator<Interval> it=intervals.iterator();

	  boolean merge_finished = false;
	  List list=new ArrayList<E>();
	  

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


	void print_intervals(Vector<Interval> & merged)
	{
	  for (int i = 0; i < merged.size(); i++){
	    cout << "(" << merged[i].start <<", " << merged[i].end<<") ";
	  }
	  cout << endl;
	}


	void test1()
	{
	  Vector<Interval> intervals;
	  intervals.push_back( Interval(1,4) );
	  intervals.push_back( Interval(6,10) );
	  intervals.push_back( Interval(14,19) );

	  Interval another(13, 17);
	  Vector<Interval> merged = merge_overlaps(intervals, another);
	  print_intervals(merged);
	}

	void test2()
	{
	  Vector<Interval> intervals;
	  intervals.push_back( Interval(1,5));
	  intervals.push_back( Interval(6,15));
	  intervals.push_back( Interval(20,21));
	  intervals.push_back( Interval(23,26));
	  intervals.push_back( Interval(27,30));
	  intervals.push_back( Interval(35,40));
	  
	  Interval another(14,33);
	  Vector<Interval> merged = merge_overlaps(intervals, another);
	  print_intervals(merged);
	}

	int main()
	{
	  test1();
	  test2();
	  return 0;
	}



}
