package Array;

public class ShortestSubarrayGreaterThanTarget {

	public int shortestSubarray(int[] nums, int target){
		
		int shortest = nums.length+1;
		
		int sum = nums[0];
		
		int i = 0, j = 0;
		
		while(j < nums.length){
			
			if(sum <= target && ++j < nums.length){
				sum += nums[j];
			}else{
				shortest = Math.min(shortest, j - i + 1);
				sum -= nums[i++];	
			}
		}
		System.out.println(shortest);
		return shortest;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1, 4, 45, 6, 10, 19};
		new ShortestSubarrayGreaterThanTarget().shortestSubarray(arr1, 51);
		
		
		int arr2[] = {1, 10, 5, 2, 7};
		new ShortestSubarrayGreaterThanTarget().shortestSubarray(arr2, 9);
		
		 int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
		 new ShortestSubarrayGreaterThanTarget().shortestSubarray(arr3, 280);
		
	}

}
