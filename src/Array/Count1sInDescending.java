package Array;

public class Count1sInDescending {

	public int countOnes(int[] nums){
		
		int start = 0, end = nums.length-1;
		
		if(nums[start] == 0) return 0;
		
		if(nums[end] == 1) return nums.length;
		
		while(start < end){
			
			int mid = start + (end-start)/2;
			
			if(nums[mid] == 0){
				end = mid-1;
			}else{
				start = mid+1;
			}
		}
		
		return nums[start] == 1 ? start+1 : start;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,1,1,0,0};
		System.out.println(new Count1sInDescending().countOnes(nums));
		
		int[] nums1 = {1,1,1,0,0,0,0};
		System.out.println(new Count1sInDescending().countOnes(nums1));
		
		int[] nums2 = {1,1,0,0,0,0,0};
		System.out.println(new Count1sInDescending().countOnes(nums2));
		
		int[] nums3 = {1,1,1,1,1,1,1};
		System.out.println(new Count1sInDescending().countOnes(nums3));
		
		int[] nums4 = {0,0,0,0,0,0,0};
		System.out.println(new Count1sInDescending().countOnes(nums4));
	}

}
