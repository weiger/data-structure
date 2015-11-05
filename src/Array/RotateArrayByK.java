package Array;

public class RotateArrayByK {

	public void rotate(int[] nums, int k){
		if(nums.length == 0)
			return ;
		
		swap(nums,0,nums.length-1);
		swap(nums,0,nums.length-k-1);
		swap(nums,nums.length-k,nums.length-1);
	}
	
	public void swap(int[] nums, int i, int j){
		
		while(i <= j){
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
		new RotateArrayByK().rotate(nums1, 2);
		for(int i : nums1)
			System.out.print(i + "   ");
		
		System.out.println();
		
	}

}
