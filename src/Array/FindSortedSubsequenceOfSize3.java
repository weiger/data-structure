package Array;

public class FindSortedSubsequenceOfSize3 {

	public void print(int[] nums){
		
		int max = nums.length-1, min = 0;
		
		int[] smaller = new int[nums.length];
		smaller[0] = -1;
		
		for(int i = 1; i < nums.length; i++){
			if(nums[i] <= nums[min]){
				min = i;
				smaller[i] = -1;
			}else
				smaller[i] = min;
		}
		
		int[] greater = new int[nums.length];
		greater[nums.length-1] = -1;
		for(int i = nums.length-2; i >= 0; i--){
			if(nums[i] >= nums[max]){
				max = i;
				greater[i] = -1;
			}else{
				greater[i] = max;
			}
		}
		
		for(int i = 0; i < nums.length; i++){
			if(smaller[i] != -1 && greater[i] != -1){
				System.out.print(nums[smaller[i]]+"   "+nums[i] +"   "+ nums[greater[i]]);
				return ;
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {12, 11, 10, 5, 6, 2, 30};
		new FindSortedSubsequenceOfSize3().print(nums1);
	}

}
