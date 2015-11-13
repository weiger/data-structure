package Array;

public class SubArraySum {

	public int subArraySum(int[] nums, int sum){
		int cur_sum = nums[0], start = 0;
		
		for(int i = 1; i <= nums.length; i++){
			
			while(cur_sum > sum && start < i-1){
				cur_sum -= nums[start];
				start++;
			}
			
			if(cur_sum == sum){
				System.out.print(start+"~~~"+(i-1));
				return 1;
			}
			
			if(i < nums.length){
				cur_sum += nums[i];
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {15, 2, 4, 8, 9, 5, 10, 23};
		new SubArraySum().subArraySum(nums, 23);
	}

}
