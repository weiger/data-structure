package Array;

public class MaxSumContiguousSubarray {

	public int getSum(int[] nums){
		int max = Integer.MIN_VALUE;
		
		int sum = 0;
		
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
			
			sum = Math.max(sum, nums[i]);
			max = Math.max(sum, max);
			
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.print(new MaxSumContiguousSubarray().getSum(a));
	}

}
