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
	
	// O(nlogn)
	public int getSum2(int[] nums){
		return maxSubArraySum(nums, 0 , nums.length-1);
	}
	
	int maxSubArraySum(int arr[], int l, int h)
	{
	   // Base Case: Only one element
	   if (l == h)
	     return arr[l];
	 
	   // Find middle point
	   int m = (l + h)/2;
	 
	   /* Return maximum of following three possible cases
	      a) Maximum subarray sum in left half
	      b) Maximum subarray sum in right half
	      c) Maximum subarray sum such that the subarray crosses the midpoint */
	   return Math.max(maxSubArraySum(arr, l, m),
	              Math.max(maxSubArraySum(arr, m+1, h),
	              maxCrossingSum(arr, l, m, h)));
	}
	
	public int maxCrossingSum(int arr[], int l, int m, int h)
	{
	    // Include elements on left of mid.
	    int sum = 0;
	    int left_sum = Integer.MIN_VALUE;
	    for (int i = m; i >= l; i--)
	    {
	        sum = sum + arr[i];
	        if (sum > left_sum)
	          left_sum = sum;
	    }
	 
	    // Include elements on right of mid
	    sum = 0;
	    int right_sum = Integer.MIN_VALUE;
	    for (int i = m+1; i <= h; i++)
	    {
	        sum = sum + arr[i];
	        if (sum > right_sum)
	          right_sum = sum;
	    }
	 
	    // Return sum of elements on left and right of mid
	    return left_sum + right_sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(new MaxSumContiguousSubarray().getSum(a));
		
		int[] b = {-2, -5, 6, -2, -3, 1, 5, -6};
		System.out.print(new MaxSumContiguousSubarray().getSum2(b));
	}

}
