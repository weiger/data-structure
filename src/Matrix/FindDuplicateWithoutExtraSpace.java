package Matrix;

public class FindDuplicateWithoutExtraSpace {

	// 0 - n-1;
	public void printDuplicate(int[] nums){
		if(nums.length == 0)
			return ;
		
		for(int i = 0; i < nums.length; i++){
			int index = Math.abs(nums[i]);
			if(nums[index] >= 0)
				nums[index] *= -1;
			else
				System.out.print(index+"  ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 1, 3, 6,6};
		new FindDuplicateWithoutExtraSpace().printDuplicate(nums);
	}

}
