package Array;

public class FindSmallestMissingNumberInSortedArray {

	public int findSmallestMissingNumber(int[] nums, int m){
		
		int start = 0, end = nums.length-1;
		
		while(start <= end){
			int mid = start + (end - start)/2;
			
			if(nums[start] != start)
				return start;
			
			if(nums[mid] > mid)
				end = mid-1;
			else
				start = mid+1;
		}
		return nums[nums.length-1]+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,6,9};
		System.out.println(new FindSmallestMissingNumberInSortedArray().findSmallestMissingNumber(nums, 10));
		
		int[] nums1 = {4,5,10,11};
		System.out.println(new FindSmallestMissingNumberInSortedArray().findSmallestMissingNumber(nums1, 12));
		
		int[] nums2 = {0,1,2,3};
		System.out.println(new FindSmallestMissingNumberInSortedArray().findSmallestMissingNumber(nums2, 5));
		
		int[] nums3 = {0,1,2,3,4,5,6,7,10};
		System.out.println(new FindSmallestMissingNumberInSortedArray().findSmallestMissingNumber(nums3, 11));
		
		
	}

}
