package Array;

//http://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/

public class ReplaceElementUsingItsRightMax {

	public void replace(int[] nums){
		
		if(nums.length == 0) return ;
		
		int max = nums[nums.length-1];
		
		nums[nums.length-1] = -1;
		
		for(int i = nums.length-2; i >= 0; i--){
			int temp = nums[i];
			nums[i] = max;
			max = Math.max(max, temp);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {16, 17, 4, 3, 5, 2};
		new ReplaceElementUsingItsRightMax().replace(nums);
		for(int i : nums) System.out.print(i+"   ");
	}

}
