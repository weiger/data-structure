package Array;
import java.util.*;

public class FindMaxBetweenDifferenceIAndJ {

	public int maxDifference(int[] nums){
		
		int[] leftMin = new int[nums.length];  // find min before current element
		leftMin[0] = nums[0];
		for(int i = 1; i < nums.length; i++){
			leftMin[i] = Math.min(nums[i], leftMin[i-1]);
		}
		
		int[] rightMax = new int[nums.length];   // find max after current element
		rightMax[nums.length-1] = nums[nums.length-1];
		for(int i = nums.length-2; i >= 0; i--){
			rightMax[i] = Math.max(nums[i], rightMax[i+1]);
		}
		
		int i = 0, j = 0;
		int maxDiff = -1;
		
		while(i < nums.length && j < nums.length){
			if(leftMin[i] < rightMax[j]){            // compare the max difference between i and j
				maxDiff = Math.max(maxDiff, j-i);    // update maxdiff
				j = j+1;
			}else{
				i = i+1;
			}
		}
		return maxDiff;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		System.out.println(new FindMaxBetweenDifferenceIAndJ().maxDifference(nums));
	}

}
