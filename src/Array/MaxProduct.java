package Array;

public class MaxProduct {

	public int getMaxProduct(int[] nums){
		if(nums.length == 0)
			return 0;
		
		int max = nums[0], min = nums[0];
		int res = nums[0];
		
		for(int i = 1; i < nums.length; i++){
			
			int max_copy = max;
			
			max = Math.max(nums[i]*min, Math.max(nums[i]*max, nums[i]));
			min = Math.min(nums[i]*min, Math.min(nums[i]*max_copy, nums[i]));
			
			res = Math.max(max, res);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, -2, -3, 0, 7, -8, -2};
		
		System.out.print(new MaxProduct().getMaxProduct(arr));
	}

}
