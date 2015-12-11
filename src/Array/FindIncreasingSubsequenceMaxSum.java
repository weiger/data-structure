package Array;

public class FindIncreasingSubsequenceMaxSum {

	public int getMaxIncreasingSubsequenceSum(int[] nums){
		
		int []dp = new int[nums.length];
		dp[0] = nums[0];
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i < nums.length; i++){
			for(int j = 0; j < i; j++){
				if(nums[i] > nums[j]){
					dp[i] = Math.max(dp[i], dp[j]+nums[i]);
					max = Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(max);
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, 101, 2, 3, 100, 4, 5};
		new FindIncreasingSubsequenceMaxSum().getMaxIncreasingSubsequenceSum(nums1);
	}

}
