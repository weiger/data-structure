package Array;

public class FindFixedPoint {

	public int fixedPoint(int[] nums){
		
		int start = 0, end = nums.length-1;
		
		while(start <= end){
			int mid = start + (end-start)/2;
			
			if(nums[mid] == mid)
				return mid;
			else if(nums[mid] < mid)
				start = mid+1;
			else 
				end = mid-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-10, -5, 0, 3, 7};
		System.out.println(new FindFixedPoint().fixedPoint(nums));
	}

}
