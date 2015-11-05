package Hashing;
import java.util.*;

public class CheckDuplicateWithinKDistance {

	/*
	Given an unsorted array that may contain duplicates. 
	Also given a number k which is smaller than size of array. 
	Write a function that returns true if array contains duplicates 
	within k distance.
	*/
	
	public static boolean hasDuplicate(int[] nums, int k){
		HashSet<Integer> set = new HashSet<>();
		
		for(int i = 0; i < nums.length; i++){
			
			if(set.contains(nums[i]))
				return true;
			
			set.add(nums[i]);
			
			if(i >= k)
				set.remove(nums[i-k]);
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 4, 1, 2, 3, 4};
		System.out.println(hasDuplicate(arr,3));
		
		int arr1[] = {1, 2, 3, 1, 4, 5};
		System.out.println(hasDuplicate(arr1,3));
		
		int arr2[] = {1, 2, 3, 4, 4};
		System.out.println(hasDuplicate(arr2,3));
	}

}
