package Array;
import java.util.*;

public class Combination {

	public void combination(int[] nums, int n){
		if(nums.length == 0)
			return ;
		
		List<Integer> list = new ArrayList<>();
		
		dfs(nums,0,list,n);
	}
	
	public void dfs(int[] nums, int start, List<Integer> list, int n){
		
		if(list.size() == n){
			System.out.println(list);
			return ;
		}
		
		for(int i = start; i < nums.length; i++){
			list.add(nums[i]);
			dfs(nums,i+1,list,n);
			list.remove(list.size()-1);
		}
	}
	
	public void combination2(int[] nums, int n){
		
		int[] data = new int[n];
		
		recursion(nums,n,0,data,0);
		
	}
	
	public void recursion(int[] nums, int n, int index, int[] data, int i){
		
		if(index == n){
			
			for(int j = 0; j < data.length; j++)
				System.out.print(data[j]+"   ");
			System.out.println();
			return ;
		}
		
		if(i >= nums.length)
			return ;
		
		data[index] = nums[i];
		
		recursion(nums,n,index+1,data,i+1);
		recursion(nums,n,index,data,i+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		new Combination().combination2(nums, 2);
	}

}
