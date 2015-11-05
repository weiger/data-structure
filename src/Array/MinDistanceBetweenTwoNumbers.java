package Array;

public class MinDistanceBetweenTwoNumbers {

	public int minDistance(int[] nums, int a, int b){
		if(nums.length == 0) return 0;
		
		int aIndex = -1, bIndex = -1;
		
		int min = nums.length+1;
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == a)
				aIndex = i;
			
			if(nums[i] == b)
				bIndex = i;
			
			if(aIndex != -1 && bIndex != -1)
				min = Math.min(min,Math.abs(aIndex-bIndex));
		}
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] ={3, 5, 4, 2, 6, 2, 0, 0, 5, 4, 8, 3};
		System.out.print(new MinDistanceBetweenTwoNumbers().minDistance(arr, 3, 6));
	}

}
