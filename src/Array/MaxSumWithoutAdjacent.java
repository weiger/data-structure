package Array;

// http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/

public class MaxSumWithoutAdjacent {

	public int maximum(int[] nums){
		if(nums.length == 0)
			return 0;
		
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		if(nums.length == 3) return Math.max(nums[0]+nums[2], nums[1]);
		
		
		nums[2] += nums[0];
		
		for(int i = 3; i < nums.length; i++){
			nums[i] += Math.max(nums[i-2], nums[i-3]);
		}
		
		return Math.max(nums[nums.length-1], nums[nums.length-2]);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,  5, 10, 40, 50, 35};
		System.out.println(new MaxSumWithoutAdjacent().maximum(arr));
	}

}
