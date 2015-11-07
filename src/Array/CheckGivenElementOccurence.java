package Array;

public class CheckGivenElementOccurence {

	
	
	// Binary search: O(logN)
	public boolean isMajortiy(int[] nums, int target){
		if(nums.length == 0) return false;
		
		int index = findFirstOccurence(nums,0,nums.length-1,target);
		
		if(index == -1)
			return false;
		
		int n = nums.length;
		
		if((index+n/2) < n && nums[index+n/2] == target)
			return true;
		
		return false;
	}
	
	public int findFirstOccurence(int[] nums, int start, int end, int target){
		if(end >= start){
			int mid = (start+end)/2;
			
			if(mid == 0 || nums[mid-1] < target && nums[mid] == target)
				return mid;
			else if(target > nums[mid])
				return findFirstOccurence(nums,mid+1,end,target);
			else
				return findFirstOccurence(nums,start,mid-1,target);
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 3, 3, 3, 10};
		
		System.out.println(new CheckGivenElementOccurence().isMajortiy(arr, 3));
	}

}
