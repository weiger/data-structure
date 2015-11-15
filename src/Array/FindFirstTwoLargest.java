package Array;

public class FindFirstTwoLargest {

	public int largestSumPair(int[] nums){
		
		int first, second;    // first largest and second largest
		if(nums[0] > nums[1]){
			first = nums[0];
			second = nums[1];
		}else{
			first = nums[1];
			second = nums[0];
		}
		
		for(int i = 2; i < nums.length; i++){
			if(nums[i] > first){
				second = first;      // second always equals last largest
				first = nums[i];
			}else if(nums[i] > second && nums[i] != first){  
				second = nums[i];
			}
		}
		System.out.println(first+second);
		return first+second;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] nums = {12, 34, 10, 6, 40} ;
		 new FindFirstTwoLargest().largestSumPair(nums);
	}

}
