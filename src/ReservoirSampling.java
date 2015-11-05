import java.util.*;

public class ReservoirSampling {

	
	//http://www.geeksforgeeks.org/reservoir-sampling/
	public static int[] returnRandomK(int[] nums, int k){
		int[] res = new int[k];
		
		int i = 0;
		
		for( ; i < k; i++){
			res[i] = nums[i];
		}
		
		for( ; i < nums.length; i++){
			Random rand = new Random();
			//int j = (int)Math.random()*(i+1);
			int j = 1 + rand.nextInt(i+1);
			if(j < k){
				res[j] = nums[i];
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] res = returnRandomK(nums,5);
		for(int i : res)
			System.out.print(i + "  ");
	}

}
