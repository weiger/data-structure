package Array;

public class FindMinInRotatedAndSortedArray {

	public int findMin(int[] nums){
		if(nums.length == 0)
			return -1;
		
		int start = 0, end = nums.length-1;
		
		while(start <= end){
			int mid = start+(end-start)/2;
			
			if(nums[start] <= nums[end])
				return nums[start];
			
			if(nums[mid] >= nums[start])
				start = mid+1;
			else
				end = mid;
		}
		
		return -1;
	}
	
	public int findMin2(int[] nums){
		if(nums.length == 0)
			return -1;
		
		return search(nums,0,nums.length-1);
	}
	
	public int search(int[] nums, int start, int end){
		
		if(start == end)
			return nums[start];
		
		if(end < start)
			return nums[0];
		
		int mid = start + (end-start)/2;
		
		if(nums[start] < nums[end])
			return nums[start];
		else if(nums[mid] >= nums[start])
			return search(nums,mid+1,end);
		else 
			return search(nums,start,mid);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {8,1,2,3,4,5,6,7};
		int[] nums2 = {20,30,40,50,55,79,2,3,4,5};
		System.out.print(new FindMinInRotatedAndSortedArray().findMin2(nums2));
	}

}
