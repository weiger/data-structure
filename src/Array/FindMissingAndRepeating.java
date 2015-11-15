package Array;

public class FindMissingAndRepeating {

	public void print(int[] nums){
		
		int i = 0;
		
		while(i <nums.length){
            if(nums[i] != (i+1) && nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i])
                swap(nums,i,nums[i]-1);
            else
                i++;
        }
		
		for(i = 0; i < nums.length; i++){
			if(nums[i] != i+1){
				System.out.print("Missing is "+ (i+1) + ", and Repeating is "+ nums[i]);
				return ;
			}
		}
		
		System.out.print("Missing is "+ nums.length+1);
	}
	
	private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,1,3};
		new FindMissingAndRepeating().print(nums);
	}

}
