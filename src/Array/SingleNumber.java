package Array;

public class SingleNumber {

	
	//Given an array of positive integers. All numbers occur even number of times 
	//except one number which occurs odd number of times. Find the number in O(n) 
	//time & constant space.
	
	// 奇数次
	public int getSingleOne(int[] nums){
		if(nums.length == 0) return -1;
		
		int res = 0;
		
		for(int i = 0; i < nums.length; i++){
			res ^= nums[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 2, 3, 1, 3};
		System.out.print(new SingleNumber().getSingleOne(nums));
	}

}
