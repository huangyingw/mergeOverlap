import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List;


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


	List<Interval> merge_overlaps(List<Interval> intervals, Interval another)
	{
	  List<Interval> result; 

	  boolean merge_finished = false;
	  List list=new ArrayList<E>();
	  
	  
	  for(int it=0;it<intervals.size();it++){
		  Interval inter=intervals.get(it);
		    if ( inter.start < another.end && another.start < inter.end){
			      another.start = (inter.start < another.start) ? inter.start : another.start;
			      another.end = (inter.end < another.end) ? another.end : inter.end;
			      continue;
			    }
			                                           
			    if (inter.start > another.end){  
			      result.push_back(another); 
			      merge_finished = true;
			    }

			    result.push_back(*inter);
	  }

	  if (! merge_finished) result.push_back(another);

	  return result;
	}


	void print_intervals(List<Interval> & merged)
	{
	  for (int i = 0; i < merged.size(); i++){
	    cout << "(" << merged[i].start <<", " << merged[i].end<<") ";
	  }
	  cout << endl;
	}


	void test1()
	{
	  List<Interval> intervals;
	  intervals.push_back( Interval(1,4) );
	  intervals.push_back( Interval(6,10) );
	  intervals.push_back( Interval(14,19) );

	  Interval another(13, 17);
	  List<Interval> merged = merge_overlaps(intervals, another);
	  print_intervals(merged);
	}

	void test2()
	{
	  List<Interval> intervals;
	  intervals.push_back( Interval(1,5));
	  intervals.push_back( Interval(6,15));
	  intervals.push_back( Interval(20,21));
	  intervals.push_back( Interval(23,26));
	  intervals.push_back( Interval(27,30));
	  intervals.push_back( Interval(35,40));
	  
	  Interval another(14,33);
	  List<Interval> merged = merge_overlaps(intervals, another);
	  print_intervals(merged);
	}

	int main()
	{
	  test1();
	  test2();
	  return 0;
	}



}
