package Array;

public class FindMaxProductInIncreasingSubsequenceLength3 {

	public long findMaxProduct(int[] nums){
		if(nums.length == 0) return 0;
		
		int[] largestSmallerFromLeft = new int[nums.length];
		int[] largestGreaterFromRight = new int[nums.length];
		
		largestSmallerFromLeft[0] = 0;
		int largestLeft = nums[0];
		for(int i = 1; i < nums.length; i++){
			
			if(largestLeft < nums[i])
				largestLeft = Math.max(largestLeft, nums[i-1]);
			largestSmallerFromLeft[i] = largestLeft;
		}
		
		largestGreaterFromRight[nums.length-1] = 0;
		int largestRight = nums[nums.length-1];
		for(int i = nums.length-2; i >= 0; i--){
			if(largestRight > nums[i])
				largestRight = Math.max(largestRight, nums[i+1]);
			largestGreaterFromRight[i] = largestRight;
		}
		
		long res = 1;
		int p = -1, j = -1, k = -1;
		for(int i = 0; i < nums.length; i++){
			res = Math.max(res, largestSmallerFromLeft[i]*nums[i]*largestGreaterFromRight[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {6,7,8,1,2,3,9,10};
		System.out.println(new FindMaxProductInIncreasingSubsequenceLength3().findMaxProduct(nums));
		
		int[] nums1 = {1,5,10,8,9};
		System.out.println(new FindMaxProductInIncreasingSubsequenceLength3().findMaxProduct(nums1));
		
	}

}
