package Array;

public class SortZeroOneTwo {

	public void sort(int[] nums){
		if(nums.length == 0)
			return ;
		
		int zero = 0, cur = 0, two = nums.length-1;
		
		while(cur <= two){
			if(nums[cur] == 0){
				swap(nums,zero,cur);
				zero++;
				cur++;
			}else if(nums[cur] == 1){
				cur++;
			}else if(nums[cur] == 2){
				swap(nums,cur,two);
				two--;
			}	
		}
	}
	
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		new SortZeroOneTwo().sort(input1);
		for(int i = 0; i < input1.length; i++)
			System.out.print(input1[i]+"   ");
	}

}
