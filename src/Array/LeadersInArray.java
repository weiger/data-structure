package Array;

// http://www.geeksforgeeks.org/leaders-in-an-array/

public class LeadersInArray {

	// O(n^2)
	public void findLeader(int[] nums){
		if(nums.length == 0)
			return ;
		
		for(int i = 0; i < nums.length-1;i++){
			for(int j = i+1; j < nums.length; j++){
				if(nums[i] < nums[j])
					break;
				
				if(j == nums.length-1)
					System.out.print(nums[i]+"   ");
			}
		}
		System.out.print(nums[nums.length-1]);
	}
	
	// O(n)
	public void findLeaders(int[] nums){
		
		int max = nums[nums.length-1];
		
		for(int i = nums.length-1; i >= 0; i--){
			if(nums[i] < max)
				continue;
			
			max = Math.max(max, nums[i]);
			System.out.print(nums[i]+"    ");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {16, 17, 4, 3, 5, 2};
		new LeadersInArray().findLeader(nums);
		System.out.println();
		new LeadersInArray().findLeaders(nums);
	}

}
