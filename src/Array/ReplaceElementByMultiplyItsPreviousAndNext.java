package Array;

public class ReplaceElementByMultiplyItsPreviousAndNext {

	public void replace(int[] nums){
		
		int pre = nums[0], next = 0;
		
		nums[0] = nums[0]*nums[1];
		
		for(int i = 1; i < nums.length-1; i++){
		
			next = nums[i+1];
			
			int product = pre*next;
			
			pre = nums[i];
			
			nums[i] = product;	
		}
		
		nums[nums.length-1] *= pre; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,4,5,6};
		new ReplaceElementByMultiplyItsPreviousAndNext().replace(nums);
		for(int i : nums) System.out.print(i+"   ");
	}

}
