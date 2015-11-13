package Array;

public class FindMaxOnesInEachRow {

	// O(mlogn)
	public int getNumbersOfOne(int[][] nums){
		int m = nums.length, n = nums[0].length;
		
		int max = 0;
		
		for(int i = 0; i < m; i++){
			int start = 0, end = nums[i].length-1;
			
			while(start <= end){
				int mid = start + (end-start)/2;
				
				if(nums[i][mid] != 1)
					start = mid+1;
				else
					end = mid-1;
			}
			
			max = Math.max(max,nums[i].length-start);
		}
		System.out.println(max);
		return max;
	}
	
	// Following method works in O(m+n) time complexity in worst case.
	public int getNumbersOfOne2(int[][] nums){
		int max_row_index = 0;
		
		int j = -1;
		for(int i = 0; i < nums[0].length; i++){
			if(nums[0][i] == 1){
				j = i;
				break;
			}
		}
		
		if(j == -1)
			j = nums[0].length-1;
		
		for(int i = 1; i < nums.length; i++){
			
			while(j >= 0 && nums[i][j] == 1){
				j = j-1;
				max_row_index = i;
			}
		}
		System.out.print(max_row_index);
		return max_row_index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = { {0, 0, 0, 1},
		        {0, 1, 1, 1},
		        {1, 1, 1, 1},
		        {0, 0, 0, 0}
		    };
		 
		new FindMaxOnesInEachRow().getNumbersOfOne2(nums);
	}

}
