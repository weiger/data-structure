package Array;

public class FindMinPositiveNumber {

	public int getMinPositive(int[] nums){
		
		int i = 0;
		
		while(i < nums.length){
			if(nums[i] != i+1 && nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i])
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
	
	public void swap(int[] nums ,int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {2, 3, 7, 6, 8, -1, -10, 15};
		System.out.println(new FindMinPositiveNumber().getMinPositive(nums1));
		
		int[] nums2 = { 2, 3, -7, 6, 8, 1, -10, 15 };
		System.out.println(new FindMinPositiveNumber().getMinPositive(nums2));
	}

}
