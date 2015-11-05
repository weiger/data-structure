package DynamicProgramming;

public class LongestIncreasingSubsequence {

	public static int getLongestIncreasingSubsequence(int[] nums){
		if(nums.length == 0) return 0;
		
		int[] dp = new int[nums.length];
		for(int i = 0; i < nums.length; i++)
			dp[i] = 1;
		
		for(int i = 1; i < nums.length; i++){
			for(int j = 0; j < i; j++){
				if(nums[i] >= nums[j]){
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}
		}
		return dp[nums.length-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10,22,9,33,21,50,41,60,80};
		System.out.println(getLongestIncreasingSubsequence(nums));
	}

}
