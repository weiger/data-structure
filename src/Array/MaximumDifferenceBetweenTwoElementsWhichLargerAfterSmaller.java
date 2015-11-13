package Array;

public class MaximumDifferenceBetweenTwoElementsWhichLargerAfterSmaller {

	// keep small 
	public int maxDifference(int[] nums){
		
		int smaller = nums[0];
		int res = Integer.MIN_VALUE;
		
		for(int i = 1; i < nums.length; i++){
			if(smaller < nums[i]){
				res = Math.max(res, nums[i]-smaller);
			}else{
				smaller = nums[i];
			}
		}
		return res;
	}
	
	// keep larger
	public int maxDifference2(int[] nums){
		int maxDiff = -1;
		int n = nums.length;
		
		int maxRight = nums[n-1];
		
		for(int i = n-2; i >= 0; i--){
			if(nums[i] > maxRight)
				maxRight = nums[i];
			else{
				maxDiff = Math.max(maxDiff, maxRight-nums[i]);
			}	
		}
		return maxDiff;
	}
	
	// 类似买卖股票
	public int maxDifference3(int[] nums){
		int diff = nums[1]-nums[0];
		int curr_sum = diff;
		
		int max_sum = curr_sum;
		
		for(int i = 2; i < nums.length; i++){
			diff = nums[i]-nums[i-1];
			
			if(curr_sum > 0)
				curr_sum += diff;
			else
				curr_sum = diff;
			
			max_sum = Math.max(max_sum, curr_sum);
			
		}
		return max_sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 3, 10, 6, 4, 8, 1};
		System.out.println(new MaximumDifferenceBetweenTwoElementsWhichLargerAfterSmaller().maxDifference(nums));
		System.out.println(new MaximumDifferenceBetweenTwoElementsWhichLargerAfterSmaller().maxDifference3(nums));
		
		int[] nums2 = {7, 9, 5, 6, 3, 2 };
		System.out.println(new MaximumDifferenceBetweenTwoElementsWhichLargerAfterSmaller().maxDifference(nums2));
		
	}

}
