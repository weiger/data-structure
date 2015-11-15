package Array;

public class FindPeakElement {

	public int findPeak(int[] nums){
		
		int start = 0, end = nums.length-1;
		
		while(start <= end){
			int mid = start + (end-start)/2;
			
			if(mid == 0) return nums[0];
			if(mid == nums.length-1) return nums[nums.length-1];
			
			if(nums[mid] < nums[mid+1] && nums[mid] > nums[mid-1])
				start = mid+1;
			else
				end = mid-1;
		}
		
		return nums[start];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,50,10,9,7,6};
		System.out.println(new FindPeakElement().findPeak(nums));
		
		int[] nums1 = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		System.out.println(new FindPeakElement().findPeak(nums1));
		
		int[] nums2 = {10, 20, 30, 40, 50};
		System.out.println(new FindPeakElement().findPeak(nums2));
		
		int[] nums3 = {120, 100, 80, 20, 0};
		System.out.println(new FindPeakElement().findPeak(nums3));
	}

}
