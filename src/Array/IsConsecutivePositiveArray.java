package Array;

public class IsConsecutivePositiveArray {

	// must be positive array and change the original array
	// O(n) time and O(1) space
	public boolean isConsecutive(int[] nums){
		
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		for(int i = 0; i < nums.length; i++){
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		
		if(max-min+1 == nums.length){
			
			for(int i = 0; i < nums.length; i++){
				
				int j = 0;     // use current positive-form current element minus min to get index
				
				if(nums[i] < 0)      
					j = -nums[i]-min;
				else
					j = nums[i]-min;
				
				if(nums[j] > 0)
					nums[j] = -nums[j];
				else
					return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {5, 4, 2, 3, 1, 6};
		System.out.println(new IsConsecutivePositiveArray().isConsecutive(arr));
	}

}
