package Array;

public class FindIndexOfZeroToReplaceItToGetLongestConsecutiveOnes {
	
	// O(n) time and O(n) space
	public int getIndex(int[] nums){
		
		int n = nums.length;
		
		int[] left = new int[n];
		int count = 0;
		
		for(int i = 0; i < n; i++){
			if(nums[i] == 1)
				count++;
			
			if(i > 0 && nums[i] == 0 && nums[i-1] != 0){
				left[i] = count;
				count = 0;
			}
		}
		
		
		//for(int p = 0; p < n; p++) System.out.print(left[p]+"   ");
		//System.out.println();
		
		int[] right = new int[n];
		count = 0;
		for(int i = n-1; i >= 0; i--){
			if(nums[i] == 1)
				count++;
			
			if(i < n-1 && nums[i] == 0 && nums[i+1] != 0){
				right[i] = count;
				count = 0;
			}
		}
	//	for(int p = 0; p < n; p++) System.out.print(right[p]+"   ");
	//	System.out.println();
		
		int index = -1, max = 0;
		for(int i = 0; i < n; i++){
			if(left[i] + right[i] > max){
				max = left[i] + right[i];
				index = i;
			}
		}
		
		return index;
	}
	
	// O(n) time and O(1) space
	public int getIndex2(int[] nums){
		int max_count = 0, max_index = -1;
		int prev_zero = -1, prev_prev_zero = -1;
		
		for(int cur = 0; cur < nums.length; cur++){
			if(nums[cur] == 0){
				if(cur - prev_prev_zero > max_count){
					max_count = cur - prev_prev_zero;
					max_index = prev_zero;
				}
				
				prev_prev_zero = prev_zero;
				prev_zero = cur;
			}
		}
		
		if(nums.length - prev_prev_zero > max_count)
			max_index = prev_zero;
		
		return max_index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] =  {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		System.out.println(new FindIndexOfZeroToReplaceItToGetLongestConsecutiveOnes().getIndex2(arr));
		
		int arr1[] =  {1, 1, 1,1,0};
		System.out.println(new FindIndexOfZeroToReplaceItToGetLongestConsecutiveOnes().getIndex(arr1));
		
	}

}
