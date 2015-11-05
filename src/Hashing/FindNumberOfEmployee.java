package Hashing;
import java.util.*;

public class FindNumberOfEmployee {

	static class Pair{
		String employee, manager;
		Pair(String employee, String manager){
			this.employee = employee;
			this.manager = manager;
		}
	}
	
	public static void solution(Pair[] pairs){
		if(pairs.length == 0)
			return ;
		
		Map<String, Integer> map = new HashMap<>();
		for(Pair p : pairs)
			map.put(p.employee, 0);
		
		
		for(int i = 0; i < pairs.length; i++){
			
			if(pairs[i].employee.equals(pairs[i].manager))
				continue;
			
			map.put(pairs[i].manager, map.get(pairs[i].manager)+1);
			
		}
		
		for(Pair p : pairs){
			int sub = map.get(p.employee);
			
			if(p.employee.equals(p.manager)) continue;
			
			map.put(p.manager, map.get(p.manager)+sub);
		}
		
		for(String key : map.keySet()){
			System.out.println(key + " - " + map.get(key));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair p1 = new Pair("A","C");
		Pair p2 = new Pair("B","C");
		Pair p3 = new Pair("C","F");
		Pair p4 = new Pair("D","E");
		Pair p5 = new Pair("E","F");
		Pair p6 = new Pair("F","F");
		
		Pair[] pairs = {p1,p2,p3,p4,p5,p6};
		solution(pairs);
		
	}

}
