package Array;

import java.util.Arrays;

public class TwoSumClosedToZero {

	public int[] getTwoSum(int[] nums){
		if(nums.length == 0)
			return new int[2];
		
		int[] res = new int[2];
		
		Arrays.sort(nums);
		
		int start = 0, end = nums.length-1;
		int diff = Integer.MAX_VALUE;
		
		while(start < end){
			int sum = nums[start] + nums[end];
			
			if(Math.abs(diff) > Math.abs(sum)){  
				diff = sum;
				res[0] = nums[start];
				res[1] = nums[end];
			}
			
			if(sum < 0)
				start++;
			else 
				end--;
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1, 60, -10, 70, -80, 85};
		 int[] res = new TwoSumClosedToZero().getTwoSum(arr);
		 for(int i : res)
			 System.out.print(i + "   ");
	}

}
