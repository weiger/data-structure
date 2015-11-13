package Array;

public class MoveZeroToEnd {

	// keep order
	public void move(int[] nums){
		if(nums.length == 0)
			return ;
		
		int index = 0;
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != 0)
				nums[index++] = nums[i];
		}
		
		for(int i = index; i < nums.length; i++)
			nums[i] = 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
		new MoveZeroToEnd().move(nums);
		
		for(int i = 0; i < nums.length; i++)
			System.out.print(nums[i]+"   ");
	}

}
