package Array;

public class MissingNumber {

	public int findMissing(int[] nums){
		if(nums.length == 0) return 1;
		
		int i = 0;
		
		while(i < nums.length){
			if(nums[i] != (i+1) && nums[i] >= 1  && nums[i] <= nums.length && nums[nums[i]-1] != nums[i] )
				swap(nums,i,nums[i]-1);
			else
				i++;
		}
		
		for(int j = 0; j < nums.length; j++){
			if(nums[j] != j+1)
				return j+1;
		}
		
		return nums.length+1;
	}
	
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 4, 6, 3, 7, 8};
		System.out.print(new MissingNumber().findMissing(nums));
	}

}
