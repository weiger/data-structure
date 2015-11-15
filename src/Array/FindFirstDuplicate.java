package Array;
import java.util.*;

public class FindFirstDuplicate {

	public int firstDuplicate(int[] nums){
		
		Set<Integer> set = new HashSet<>();
		int first = 0;
		
		for(int i = nums.length-1; i >= 0; i--){   // from end to start 
			if(set.contains(nums[i]))
				first = nums[i];
			else set.add(nums[i]);
		}
		return first;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 5, 3, 4, 3, 5, 6};
		System.out.println(new FindFirstDuplicate().firstDuplicate(arr));
	}

}
