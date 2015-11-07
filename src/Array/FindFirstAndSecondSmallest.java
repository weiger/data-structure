package Array;

public class FindFirstAndSecondSmallest {

	public void searchFirstTwoSmallest(int[] nums){
		
		if(nums.length < 2)
			return ;
		
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i] < first){
				second = first;
				first = nums[i];
			}else if(nums[i] < second){
				second = nums[i];
			}	
		}
		
		if(second == Integer.MAX_VALUE)
			return ;
		
		System.out.println(first + "   "+ second);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 13, 1, 10, 34, 2};
		new FindFirstAndSecondSmallest().searchFirstTwoSmallest(arr);
	}

}
