package Array;

public class FindPeak {

	public int getPeak(int[] nums){
		if(nums.length == 0)
			return -1;
		
		int start = 0, end = nums.length-1;
		
		while(start < end){
			int mid = (start+end+1)/2;
			
			if(nums[mid] > nums[mid-1])
				start = mid;
			else
				end = mid-1;
		}
		return nums[start];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,20,10,9,11,14,15};  // corner case: only one result
		System.out.println(new FindPeak().getPeak(nums));
	}

}
