package Array;
import java.util.*;

public class MergeOverlappingInterval {

	static class Interval{
		int start, end;
		Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	public List<Interval> merge(Interval[] in){
		
		List<Interval> res = new ArrayList<>();
		
		Arrays.sort(in, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return i1.start-i2.start;
			}
		});
		
		Interval pivot = in[0];
		
		for(int i = 1; i < in.length; i++){
			Interval cur = in[i];
			
			if(pivot.end < cur.start){
				res.add(pivot);
				pivot = cur;
			}else{
				Interval temp = new Interval(pivot.start,Math.max(pivot.end, cur.end));
				pivot = temp;
			}
		}
		res.add(pivot);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval arr[] = { new Interval(6,8),
				           new Interval(1,9),
				           new Interval(2,4),
				           new Interval(4,7),
						 };
		List<Interval> res = new MergeOverlappingInterval().merge(arr);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i).start + ","+res.get(i).end);
		}
		
		Interval arr2[] = { new Interval(6,8),
		           new Interval(1,3),
		           new Interval(2,4),
		           new Interval(5,7),
				 };
		List<Interval> res2 = new MergeOverlappingInterval().merge(arr2);
		for(int i = 0; i < res2.size(); i++){
			System.out.println(res2.get(i).start + ","+res2.get(i).end);
		}
	}

}
